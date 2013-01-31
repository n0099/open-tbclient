package com.baidu.zeus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.ConditionVariable;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HTML5CameraView extends FrameLayout {
    private static final int CAMERA_CLOSED = 2;
    private static final int CAMERA_OPENED = 1;
    private static final int CHECK_DISPLAY_ROTATION = 5;
    public static final int ORIENTATION_HYSTERESIS = 5;
    private static final String TAG = "HTML5CameraView";
    private static final int WAIT_FOR_FOCUS_TO_COMPLETE = 3000;
    WebChromeClient client;
    private AutoFocusCallback mAutoFocusCallback;
    Camera mCamera;
    private int mCameraOrientation;
    private Context mContext;
    private int mDisplayOrientation;
    private int mDisplayRotation;
    private final ConditionVariable mFocusDone;
    private Handler mHandler;
    SurfaceHolder mHolder;
    Bitmap mInputImage;
    FrameLayout mLayout;
    Bitmap mNativeImage;
    private int mOrientation;
    private MyOrientationEventListener mOrientationListener;
    Camera.Parameters mParameters;
    SurfaceHolder.Callback mSHCallback;
    private volatile int mStatus;
    SurfaceView mSurfaceview;
    int m_CID;
    volatile int m_sdk_version;
    private Object nppLock;
    private boolean validNPP;
    static int m_width = 768;
    static int m_height = NotificationProxy.MAX_URL_LENGTH;
    static int m_width_1 = 480;
    static int m_height_1 = 640;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeCaptureSuccess(Bitmap bitmap, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeCaptureSuccessBuffer(byte[] bArr, int i);

    private native int nativegetOrientation();

    private native int nativegetRotation(Display display);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativesetDisplayCamera(Camera camera, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public void setCameraParameters() {
        this.mParameters = this.mCamera.getParameters();
        if (this.mParameters.getSupportedSceneModes() != null) {
            Log.d(TAG, "sceneMode");
            this.mParameters.setSceneMode(new String("auto"));
        }
        if (this.mParameters.getSupportedAntibanding() != null) {
            Log.d(TAG, "antibanding");
            this.mParameters.setAntibanding(new String("auto"));
        }
        List<Integer> supportedPreviewFrameRates = this.mParameters.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates != null) {
            this.mParameters.setPreviewFrameRate(((Integer) Collections.max(supportedPreviewFrameRates)).intValue());
        }
        List<Camera.Size> supportedPictureSizes = this.mParameters.getSupportedPictureSizes();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < supportedPictureSizes.size(); i3++) {
            int i4 = supportedPictureSizes.get(i3).height * supportedPictureSizes.get(i3).width;
            if (i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        this.mParameters.setPictureSize(supportedPictureSizes.get(i).width, supportedPictureSizes.get(i).height);
        this.mParameters.setJpegQuality(85);
        if (this.mParameters.isZoomSupported()) {
            Log.d(TAG, "zoom");
            this.mParameters.setZoom(0);
        }
        if (this.mParameters.getSupportedColorEffects() != null) {
            this.mParameters.setColorEffect(new String("none"));
            Log.d(TAG, "colorEffect");
        }
        if (this.mParameters.getSupportedFlashModes() != null) {
            Log.d(TAG, "flashMode");
            this.mParameters.setFlashMode(new String("auto"));
        }
        if (this.mParameters.getSupportedWhiteBalance() != null) {
            this.mParameters.setWhiteBalance(new String("auto"));
            Log.d(TAG, "WhiteBalance");
        }
        if (this.mParameters.getSupportedFocusModes() != null) {
            this.mParameters.setFocusMode(new String("auto"));
            Log.d(TAG, "focusMode");
        }
        this.mCamera.setParameters(this.mParameters);
    }

    /* loaded from: classes.dex */
    class MyOrientationEventListener extends OrientationEventListener {
        public MyOrientationEventListener(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (i != -1) {
                HTML5CameraView.this.mOrientation = HTML5CameraView.this.roundOrientation(i, HTML5CameraView.this.mOrientation);
                if (HTML5CameraView.this.mDisplayOrientation != HTML5CameraView.this.getDisplayRotation()) {
                    HTML5CameraView.this.mDisplayOrientation = HTML5CameraView.this.getDisplayRotation();
                    if (HTML5CameraView.this.mCamera != null) {
                        try {
                            HTML5CameraView.this.nativesetDisplayCamera(HTML5CameraView.this.mCamera, HTML5CameraView.this.mDisplayOrientation);
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        }
    }

    public int roundOrientation(int i, int i2) {
        if (i == -1) {
            i = 0;
        }
        return ((((i + 45) / 90) * 90) + this.mCameraOrientation) % 360;
    }

    public void setRotationParameter(Camera.Parameters parameters, int i, int i2) {
        if (-1 == i2) {
            i2 = this.mDisplayOrientation;
        }
        parameters.setRotation(i2);
    }

    public SurfaceView getview() {
        return this.mSurfaceview;
    }

    public static int getCameraNumbuer() {
        return 1;
    }

    public static void setViewSize(int i, int i2) {
        m_width = i;
        m_height = i2;
    }

    public int getDisplayRotation() {
        int i;
        int i2;
        try {
            i = nativegetRotation(((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay());
        } catch (Exception e) {
            i = 0;
        }
        switch (i) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                i2 = 0;
                break;
        }
        try {
            int nativegetOrientation = nativegetOrientation();
            this.mCameraOrientation = nativegetOrientation;
            return ((nativegetOrientation - i2) + 360) % 360;
        } catch (Throwable th) {
            this.mCameraOrientation = 90;
            this.m_sdk_version = 34;
            return ((90 - i2) + 360) % 360;
        }
    }

    public void CameraClose() {
        synchronized (this.nppLock) {
            if (this.mStatus == 1 && this.mCamera != null) {
                this.mCamera.stopPreview();
                this.mCamera.release();
                this.mOrientationListener.disable();
                this.mStatus = 2;
                this.mCamera = null;
            }
        }
    }

    public HTML5CameraView(Context context, int i) {
        super(context);
        this.nppLock = new Object();
        this.mStatus = 0;
        this.m_CID = 0;
        this.validNPP = true;
        this.m_sdk_version = 0;
        this.mCameraOrientation = 0;
        this.mOrientation = -1;
        this.mAutoFocusCallback = new AutoFocusCallback();
        this.mFocusDone = new ConditionVariable();
        this.mSHCallback = new SurfaceHolder.Callback() { // from class: com.baidu.zeus.HTML5CameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                synchronized (HTML5CameraView.this.nppLock) {
                    if (HTML5CameraView.this.validNPP) {
                        if (HTML5CameraView.this.mCamera != null) {
                            HTML5CameraView.this.mParameters = HTML5CameraView.this.mCamera.getParameters();
                            HTML5CameraView.this.setCameraParameters();
                            Log.d(HTML5CameraView.TAG, "changed");
                            Camera.Size optimalPreviewSize = HTML5CameraView.this.getOptimalPreviewSize(HTML5CameraView.this.mParameters.getSupportedPreviewSizes(), i3, i4);
                            HTML5CameraView.this.mParameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
                            HTML5CameraView.this.mSurfaceview.getHolder().setFixedSize(optimalPreviewSize.width, optimalPreviewSize.height);
                            HTML5CameraView.this.mDisplayOrientation = HTML5CameraView.this.getDisplayRotation();
                            HTML5CameraView.this.setRotationParameter(HTML5CameraView.this.mParameters, HTML5CameraView.this.m_CID, HTML5CameraView.this.mOrientation);
                            try {
                                HTML5CameraView.this.nativesetDisplayCamera(HTML5CameraView.this.mCamera, HTML5CameraView.this.mDisplayOrientation);
                            } catch (Throwable th) {
                            }
                            HTML5CameraView.this.mCamera.setParameters(HTML5CameraView.this.mParameters);
                            HTML5CameraView.this.mCamera.startPreview();
                            HTML5CameraView.this.mSurfaceview.setZOrderOnTop(true);
                        }
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                synchronized (HTML5CameraView.this.nppLock) {
                    if (HTML5CameraView.this.validNPP) {
                        Log.d(HTML5CameraView.TAG, "created");
                        try {
                            HTML5CameraView.this.mStatus = 1;
                            HTML5CameraView.this.mCamera = Camera.open();
                            HTML5CameraView.this.mDisplayOrientation = HTML5CameraView.this.getDisplayRotation();
                            HTML5CameraView.this.mOrientationListener.enable();
                            HTML5CameraView.this.mCamera.setPreviewDisplay(surfaceHolder);
                        } catch (IOException e) {
                            HTML5CameraView.this.mCamera.release();
                            HTML5CameraView.this.mCamera = null;
                        } catch (RuntimeException e2) {
                            HTML5CameraView.this.mCamera = null;
                        }
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                synchronized (HTML5CameraView.this.nppLock) {
                    if (HTML5CameraView.this.validNPP) {
                        Log.d(HTML5CameraView.TAG, "destroyed");
                        if (HTML5CameraView.this.mStatus == 1 && HTML5CameraView.this.mCamera != null) {
                            HTML5CameraView.this.mCamera.stopPreview();
                            HTML5CameraView.this.mCamera.release();
                            HTML5CameraView.this.mOrientationListener.disable();
                            HTML5CameraView.this.mStatus = 2;
                            HTML5CameraView.this.mCamera = null;
                        }
                    }
                }
            }
        };
        this.mContext = context;
        Log.d(TAG, "init");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mSurfaceview = new SurfaceView(context);
        this.mOrientationListener = new MyOrientationEventListener(context);
        this.m_CID = i;
        this.mLayout = this;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mSurfaceview.setLayoutParams(layoutParams);
        this.mSurfaceview.setZOrderOnTop(true);
        this.mLayout.addView(this.mSurfaceview, layoutParams2);
        this.mLayout.setVisibility(0);
        this.mHolder = this.mSurfaceview.getHolder();
        this.mHolder.setType(3);
        this.mSurfaceview.getHolder().setFixedSize(m_width, m_height);
        this.mHolder.addCallback(this.mSHCallback);
        this.mLayout.setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Camera.Size getOptimalPreviewSize(List list, int i, int i2) {
        double d;
        Camera.Size size;
        double d2 = i / i2;
        if (list == null) {
            return null;
        }
        Camera.Size size2 = null;
        double d3 = Double.MAX_VALUE;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Camera.Size size3 = (Camera.Size) it.next();
            if (Math.abs((size3.width / size3.height) - d2) <= 0.05d) {
                if (Math.abs(size3.height - i2) < d3) {
                    size = size3;
                    d = Math.abs(size3.height - i2);
                } else {
                    d = d3;
                    size = size2;
                }
                size2 = size;
                d3 = d;
            }
        }
        if (size2 == null) {
            double d4 = Double.MAX_VALUE;
            Iterator it2 = list.iterator();
            while (true) {
                double d5 = d4;
                if (it2.hasNext()) {
                    Camera.Size size4 = (Camera.Size) it2.next();
                    if (Math.abs(size4.height - i2) < d5) {
                        size2 = size4;
                        d4 = Math.abs(size4.height - i2);
                    } else {
                        d4 = d5;
                    }
                } else {
                    return size2;
                }
            }
        } else {
            return size2;
        }
    }

    /* loaded from: classes.dex */
    final class JpegPictureCallback implements Camera.PictureCallback {
        public JpegPictureCallback() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            HTML5CameraView.this.mCamera.getParameters();
            try {
                HTML5CameraView.this.nativeCaptureSuccessBuffer(bArr, bArr.length);
                HTML5CameraView.this.mNativeImage = null;
                HTML5CameraView.this.setCameraParameters();
                HTML5CameraView.this.mCamera.startPreview();
            } catch (Exception e) {
            } catch (OutOfMemoryError e2) {
                HTML5CameraView.this.mNativeImage = null;
                HTML5CameraView.this.nativeCaptureSuccess(HTML5CameraView.this.mNativeImage, HTML5CameraView.this.mOrientation);
                HTML5CameraView.this.setCameraParameters();
                HTML5CameraView.this.mCamera.startPreview();
            }
        }
    }

    /* loaded from: classes.dex */
    final class AutoFocusCallback implements Camera.AutoFocusCallback {
        private AutoFocusCallback() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            HTML5CameraView.this.mFocusDone.open();
            Log.d(HTML5CameraView.TAG, "AutoFocusCallback success=" + z);
        }
    }

    private boolean waitForFocusDone() {
        boolean block = this.mFocusDone.block(3000L);
        if (!block) {
            Log.d(TAG, "waitForFocusDone: timeout");
        }
        this.mFocusDone.close();
        return block;
    }

    private Bitmap rotate(Bitmap bitmap, int i) {
        if (i != 0 && bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                    return createBitmap;
                }
                return bitmap;
            } catch (OutOfMemoryError e) {
                return bitmap;
            }
        }
        return bitmap;
    }

    /* loaded from: classes.dex */
    final class RawPictureCallback implements Camera.PictureCallback {
        private RawPictureCallback() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            HTML5CameraView.this.mNativeImage = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            HTML5CameraView.this.nativeCaptureSuccess(HTML5CameraView.this.mNativeImage, HTML5CameraView.this.mOrientation);
            HTML5CameraView.this.mNativeImage = null;
            HTML5CameraView.this.mCamera.startPreview();
        }
    }

    public void capture() {
        if (this.mCamera != null) {
            if (this.m_sdk_version == 34) {
                setRotationParameter(this.mParameters, this.m_CID, 0);
            } else {
                setRotationParameter(this.mParameters, this.m_CID, this.mOrientation);
            }
            this.mCamera.setParameters(this.mParameters);
            this.mCamera.autoFocus(this.mAutoFocusCallback);
            waitForFocusDone();
            this.mCamera.takePicture(null, null, null, new JpegPictureCallback());
        }
    }
}
