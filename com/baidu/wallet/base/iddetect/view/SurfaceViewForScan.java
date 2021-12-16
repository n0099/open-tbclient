package com.baidu.wallet.base.iddetect.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.CameraSizeInfo;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import com.baidu.wallet.base.iddetect.utils.Utils;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class SurfaceViewForScan extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_NUM = 4;
    public static final int CAMERA_BACK = 1;
    public static final int CAMERA_FRONT = 0;
    public static int FRAME_HEIGHT = 0;
    public static int FRAME_WIDTH = 0;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_TRACKER = 1;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[][] buffer;
    public Callback callback;
    public Camera camera;
    public int cameraID;
    public Camera.Parameters cameraParameters;
    public int displayRotation;
    public int focusAreaSize;
    public int frameFormat;
    public int frameHeight;
    public int frameWidth;
    public LooperThread looperThread;
    public IdCardActivity mAttachedActivity;
    public Context mContext;
    public int mCurrentCameraPosition;
    public int mCurrentMode;
    public Camera.AutoFocusCallback mFocusCallback;
    public CameraSizeInfo mInfo;
    public Camera.PictureCallback mPictureCallback;
    public byte[] rotatedFrame;
    public SurfaceHolder surfaceHolder;

    /* loaded from: classes13.dex */
    public interface Callback {
        void onFrame(byte[] bArr, int i2, int i3, int i4);
    }

    /* loaded from: classes13.dex */
    public class LooperThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Handler handler;
        public final /* synthetic */ SurfaceViewForScan this$0;

        public LooperThread(SurfaceViewForScan surfaceViewForScan) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {surfaceViewForScan};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = surfaceViewForScan;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                this.handler = new MyHandler(this.this$0);
                Looper.loop();
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class MyHandler extends Handler {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FRAME_INTERVAL = 200;
        public transient /* synthetic */ FieldHolder $fh;
        public long lastFrame;
        public final WeakReference<SurfaceViewForScan> surfaceViewForScanWR;

        public MyHandler(SurfaceViewForScan surfaceViewForScan) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {surfaceViewForScan};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lastFrame = System.currentTimeMillis();
            this.surfaceViewForScanWR = new WeakReference<>(surfaceViewForScan);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SurfaceViewForScan surfaceViewForScan;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (surfaceViewForScan = this.surfaceViewForScanWR.get()) == null) {
                return;
            }
            byte[] bArr = (byte[]) message.obj;
            if (System.currentTimeMillis() - this.lastFrame > 200) {
                this.lastFrame = System.currentTimeMillis();
                int i4 = surfaceViewForScan.displayRotation;
                if (surfaceViewForScan.mCurrentCameraPosition == 1) {
                    i4 += 180;
                }
                int i5 = 360 - i4;
                if (i5 == 0) {
                    System.arraycopy(bArr, 0, surfaceViewForScan.rotatedFrame, 0, bArr.length);
                    i2 = surfaceViewForScan.frameWidth;
                    i3 = surfaceViewForScan.frameHeight;
                } else if (i5 == 90) {
                    surfaceViewForScan.rotateYUV420Degree90(bArr, surfaceViewForScan.rotatedFrame, surfaceViewForScan.frameWidth, surfaceViewForScan.frameHeight);
                    i2 = surfaceViewForScan.frameHeight;
                    i3 = surfaceViewForScan.frameWidth;
                } else if (i5 == 180) {
                    surfaceViewForScan.rotateYUV420Degree180(bArr, surfaceViewForScan.rotatedFrame, surfaceViewForScan.frameWidth, surfaceViewForScan.frameHeight);
                    i2 = surfaceViewForScan.frameWidth;
                    i3 = surfaceViewForScan.frameHeight;
                } else if (i5 != 270) {
                    System.arraycopy(bArr, 0, surfaceViewForScan.rotatedFrame, 0, bArr.length);
                    i2 = surfaceViewForScan.frameWidth;
                    i3 = surfaceViewForScan.frameHeight;
                } else {
                    surfaceViewForScan.rotateYUV420Degree270(bArr, surfaceViewForScan.rotatedFrame, surfaceViewForScan.frameWidth, surfaceViewForScan.frameHeight);
                    i2 = surfaceViewForScan.frameHeight;
                    i3 = surfaceViewForScan.frameWidth;
                }
                if (surfaceViewForScan.callback != null) {
                    surfaceViewForScan.callback.onFrame(surfaceViewForScan.rotatedFrame, i2, i3, surfaceViewForScan.frameFormat);
                }
            }
            if (Build.VERSION.SDK_INT < 8 || surfaceViewForScan.camera == null || bArr == null) {
                return;
            }
            surfaceViewForScan.camera.addCallbackBuffer(bArr);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(409988824, "Lcom/baidu/wallet/base/iddetect/view/SurfaceViewForScan;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(409988824, "Lcom/baidu/wallet/base/iddetect/view/SurfaceViewForScan;");
                return;
            }
        }
        TAG = SurfaceViewForScan.class.getSimpleName();
        FRAME_HEIGHT = 720;
        FRAME_WIDTH = 960;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurfaceViewForScan(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int clamp(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65552, this, i2, i3, i4)) == null) ? i2 > i4 ? i4 : i2 < i3 ? i3 : i2 : invokeIII.intValue;
    }

    private void init(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65553, this, context, attributeSet, i2) == null) {
            this.mContext = context;
            this.mCurrentCameraPosition = 1;
            this.mCurrentMode = 1;
            try {
                CameraSizeInfo sortSizeInstance = CameraUtilsForScan.getSortSizeInstance(context, 1, false);
                this.mInfo = sortSizeInstance;
                if (sortSizeInstance != null) {
                    FRAME_WIDTH = sortSizeInstance.mWidth;
                    FRAME_HEIGHT = sortSizeInstance.mHeight;
                } else {
                    IdCardActivity idCardActivity = this.mAttachedActivity;
                    if (idCardActivity != null) {
                        idCardActivity.dialogPermission();
                        return;
                    }
                }
                SurfaceHolder holder = getHolder();
                this.surfaceHolder = holder;
                holder.addCallback(this);
                this.surfaceHolder.setType(3);
            } catch (Exception e2) {
                String simpleName = SurfaceViewForScan.class.getSimpleName();
                LogUtil.errord(simpleName, "init fail exception = " + e2.getMessage());
                throw e2;
            }
        }
    }

    private void initCamera() {
        IdCardActivity idCardActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                try {
                    try {
                        if (this.mCurrentCameraPosition == 1) {
                            this.camera = Camera.open(0);
                            this.cameraID = 0;
                        } else {
                            this.camera = Camera.open(1);
                            this.cameraID = 1;
                        }
                    } catch (Exception unused) {
                        this.camera = null;
                        this.cameraID = -1;
                    }
                } catch (Exception unused2) {
                    this.camera = Camera.open();
                    this.cameraID = 0;
                }
            } else {
                try {
                    this.camera = Camera.open();
                } catch (Exception unused3) {
                    this.camera = null;
                    this.cameraID = -1;
                }
            }
            if (this.camera != null || (idCardActivity = this.mAttachedActivity) == null) {
                return;
            }
            idCardActivity.dialogPermission();
        }
    }

    private void initSize() {
        Camera camera;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (camera = this.camera) == null || camera.getParameters() == null) {
            return;
        }
        int screenWidth = Utils.getScreenWidth(this.mContext);
        int screenHeight = Utils.getScreenHeight(this.mContext);
        LogUtil.i("ScreenSize", "width:" + screenHeight + ",height:" + screenWidth);
        List<Camera.Size> supportedPreviewSizes = this.camera.getParameters().getSupportedPreviewSizes();
        if (supportedPreviewSizes != null && supportedPreviewSizes.size() > 1) {
            for (int i3 = 0; i3 < supportedPreviewSizes.size(); i3++) {
                Camera.Size size = supportedPreviewSizes.get(i3);
                int i4 = size.width;
                if (i4 >= FRAME_WIDTH && (i2 = size.height) >= FRAME_HEIGHT && i4 <= screenHeight && i2 <= screenWidth) {
                    FRAME_WIDTH = i4;
                    FRAME_HEIGHT = i2;
                }
            }
        }
        LogUtil.i("FRAME Size", "FRAME_WIDTH:" + FRAME_WIDTH + ",FRAME_HEIGHT:" + FRAME_HEIGHT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rotateYUV420Degree180(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65556, this, bArr, bArr2, i2, i3)) == null) {
            int i4 = i2 * i3;
            int i5 = 0;
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                bArr2[i5] = bArr[i6];
                i5++;
            }
            for (int i7 = ((i4 * 3) / 2) - 1; i7 >= i4; i7 -= 2) {
                int i8 = i5 + 1;
                bArr2[i5] = bArr[i7 - 1];
                i5 = i8 + 1;
                bArr2[i8] = bArr[i7];
            }
            return true;
        }
        return invokeLLII.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rotateYUV420Degree270(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65557, this, bArr, bArr2, i2, i3)) == null) {
            int i4 = i2 - 1;
            int i5 = 0;
            for (int i6 = i4; i6 >= 0; i6--) {
                for (int i7 = 0; i7 < i3; i7++) {
                    bArr2[i5] = bArr[(i7 * i2) + i6];
                    i5++;
                }
            }
            int i8 = i2 * i3;
            int i9 = i8;
            while (i4 > 0) {
                for (int i10 = 0; i10 < i3 / 2; i10++) {
                    int i11 = (i10 * i2) + i8;
                    bArr2[i9] = bArr[(i4 - 1) + i11];
                    int i12 = i9 + 1;
                    bArr2[i12] = bArr[i11 + i4];
                    i9 = i12 + 1;
                }
                i4 -= 2;
            }
            return true;
        }
        return invokeLLII.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rotateYUV420Degree90(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65558, this, bArr, bArr2, i2, i3)) == null) {
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    bArr2[i4] = bArr[(i6 * i2) + i5];
                    i4++;
                }
            }
            int i7 = i2 * i3;
            int i8 = ((i7 * 3) / 2) - 1;
            for (int i9 = i2 - 1; i9 > 0; i9 -= 2) {
                for (int i10 = 0; i10 < i3 / 2; i10++) {
                    int i11 = (i10 * i2) + i7;
                    bArr2[i8] = bArr[i11 + i9];
                    int i12 = i8 - 1;
                    bArr2[i12] = bArr[i11 + (i9 - 1)];
                    i8 = i12 - 1;
                }
            }
            return true;
        }
        return invokeLLII.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:50|(7:(1:(0)(1:69))(1:70)|55|56|57|(1:59)|61|(2:63|64)(2:65|66))|71|55|56|57|(0)|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0087, code lost:
        if (r1 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0151, code lost:
        if (r0 != 3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01fd, code lost:
        if (r0 != 3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0231, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0232, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3 A[LOOP:0: B:21:0x00f1->B:22:0x00f3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a3 A[LOOP:1: B:38:0x01a1->B:39:0x01a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0221 A[Catch: Exception -> 0x0231, TRY_LEAVE, TryCatch #0 {Exception -> 0x0231, blocks: (B:53:0x020d, B:55:0x0221), top: B:67:0x020d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0272  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setupCamera() {
        Method method;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || this.camera == null) {
            return;
        }
        LooperThread looperThread = new LooperThread(this);
        this.looperThread = looperThread;
        looperThread.start();
        String str = TAG;
        LogUtil.i(str, "FRAME_WIDTH = " + FRAME_WIDTH + ";FRAME_HEIGHT=" + FRAME_HEIGHT);
        int i2 = Build.VERSION.SDK_INT;
        int i3 = 270;
        int i4 = 0;
        if (i2 >= 9) {
            Camera.Parameters parameters = this.camera.getParameters();
            this.cameraParameters = parameters;
            parameters.setPreviewFormat(17);
            this.cameraParameters.setPreviewSize(FRAME_WIDTH, FRAME_HEIGHT);
            this.camera.setParameters(this.cameraParameters);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.cameraID, cameraInfo);
            int rotation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i3 = 90;
                } else if (rotation == 2) {
                    i3 = 180;
                }
                if (cameraInfo.facing != 1) {
                    int i5 = (cameraInfo.orientation + i3) % 360;
                    this.displayRotation = i5;
                    this.displayRotation = (360 - i5) % 360;
                } else {
                    this.displayRotation = ((cameraInfo.orientation - i3) + 360) % 360;
                }
                this.camera.setDisplayOrientation(this.displayRotation);
                this.frameHeight = this.cameraParameters.getPreviewSize().height;
                this.frameWidth = this.cameraParameters.getPreviewSize().width;
                this.frameFormat = this.cameraParameters.getPreviewFormat();
                int bitsPerPixel = (int) ((((this.frameHeight * 1) * this.frameWidth) * ImageFormat.getBitsPerPixel(this.camera.getParameters().getPreviewFormat())) / 8);
                this.rotatedFrame = new byte[bitsPerPixel];
                while (i4 < 4) {
                    byte[][] bArr = this.buffer;
                    bArr[i4] = new byte[bitsPerPixel];
                    this.camera.addCallbackBuffer(bArr[i4]);
                    i4++;
                }
                if (this.mCurrentMode != 1) {
                    this.camera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback(this) { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SurfaceViewForScan this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr2, Camera camera) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr2, camera) == null) {
                                Message message = new Message();
                                message.obj = bArr2;
                                this.this$0.looperThread.handler.sendMessage(message);
                            }
                        }
                    });
                    return;
                } else {
                    this.camera.setPreviewCallbackWithBuffer(null);
                    return;
                }
            }
            i3 = 0;
            if (cameraInfo.facing != 1) {
            }
            this.camera.setDisplayOrientation(this.displayRotation);
            this.frameHeight = this.cameraParameters.getPreviewSize().height;
            this.frameWidth = this.cameraParameters.getPreviewSize().width;
            this.frameFormat = this.cameraParameters.getPreviewFormat();
            int bitsPerPixel2 = (int) ((((this.frameHeight * 1) * this.frameWidth) * ImageFormat.getBitsPerPixel(this.camera.getParameters().getPreviewFormat())) / 8);
            this.rotatedFrame = new byte[bitsPerPixel2];
            while (i4 < 4) {
            }
            if (this.mCurrentMode != 1) {
            }
        } else if (i2 == 8) {
            Camera.Parameters parameters2 = this.camera.getParameters();
            this.cameraParameters = parameters2;
            parameters2.setPreviewFormat(17);
            this.cameraParameters.setPreviewSize(FRAME_WIDTH, FRAME_HEIGHT);
            this.camera.setParameters(this.cameraParameters);
            int orientation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation != 0) {
                if (orientation == 1) {
                    i3 = 90;
                } else if (orientation == 2) {
                    i3 = 180;
                }
                int i6 = ((90 - i3) + 360) % 360;
                this.displayRotation = i6;
                this.camera.setDisplayOrientation(i6);
                this.frameHeight = this.cameraParameters.getPreviewSize().height;
                this.frameWidth = this.cameraParameters.getPreviewSize().width;
                this.frameFormat = this.cameraParameters.getPreviewFormat();
                int bitsPerPixel3 = (int) (((this.frameHeight * this.frameWidth) * ImageFormat.getBitsPerPixel(this.camera.getParameters().getPreviewFormat())) / 8);
                this.rotatedFrame = new byte[bitsPerPixel3];
                while (i4 < 4) {
                    byte[][] bArr2 = this.buffer;
                    bArr2[i4] = new byte[bitsPerPixel3];
                    this.camera.addCallbackBuffer(bArr2[i4]);
                    i4++;
                }
                if (this.mCurrentMode != 1) {
                    this.camera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback(this) { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SurfaceViewForScan this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i7 = newInitContext.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr3, Camera camera) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr3, camera) == null) {
                                Message message = new Message();
                                message.obj = bArr3;
                                this.this$0.looperThread.handler.sendMessage(message);
                            }
                        }
                    });
                    return;
                } else {
                    this.camera.setPreviewCallbackWithBuffer(null);
                    return;
                }
            }
            i3 = 0;
            int i62 = ((90 - i3) + 360) % 360;
            this.displayRotation = i62;
            this.camera.setDisplayOrientation(i62);
            this.frameHeight = this.cameraParameters.getPreviewSize().height;
            this.frameWidth = this.cameraParameters.getPreviewSize().width;
            this.frameFormat = this.cameraParameters.getPreviewFormat();
            int bitsPerPixel32 = (int) (((this.frameHeight * this.frameWidth) * ImageFormat.getBitsPerPixel(this.camera.getParameters().getPreviewFormat())) / 8);
            this.rotatedFrame = new byte[bitsPerPixel32];
            while (i4 < 4) {
            }
            if (this.mCurrentMode != 1) {
            }
        } else {
            Camera.Parameters parameters3 = this.camera.getParameters();
            this.cameraParameters = parameters3;
            parameters3.setPreviewFormat(17);
            this.cameraParameters.setPreviewSize(FRAME_WIDTH, FRAME_HEIGHT);
            this.camera.setParameters(this.cameraParameters);
            int orientation2 = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation2 != 0) {
                if (orientation2 == 1) {
                    i3 = 90;
                } else if (orientation2 == 2) {
                    i3 = 180;
                }
                this.displayRotation = ((90 - i3) + 360) % 360;
                method = this.camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                if (method != null) {
                    method.invoke(this.camera, Integer.valueOf(this.displayRotation));
                }
                this.frameHeight = this.cameraParameters.getPreviewSize().height;
                this.frameWidth = this.cameraParameters.getPreviewSize().width;
                this.frameFormat = this.cameraParameters.getPreviewFormat();
                this.rotatedFrame = new byte[(int) (((this.frameHeight * this.frameWidth) * 12) / 8)];
                if (this.mCurrentMode != 1) {
                    this.camera.setPreviewCallback(new Camera.PreviewCallback(this) { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SurfaceViewForScan this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i7 = newInitContext.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr3, Camera camera) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr3, camera) == null) {
                                Message message = new Message();
                                message.obj = bArr3;
                                this.this$0.looperThread.handler.sendMessage(message);
                            }
                        }
                    });
                    return;
                } else {
                    this.camera.setPreviewCallback(null);
                    return;
                }
            }
            i3 = 0;
            this.displayRotation = ((90 - i3) + 360) % 360;
            method = this.camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
            }
            this.frameHeight = this.cameraParameters.getPreviewSize().height;
            this.frameWidth = this.cameraParameters.getPreviewSize().width;
            this.frameFormat = this.cameraParameters.getPreviewFormat();
            this.rotatedFrame = new byte[(int) (((this.frameHeight * this.frameWidth) * 12) / 8)];
            if (this.mCurrentMode != 1) {
            }
        }
    }

    public void autoFocus() {
        Camera.Parameters parameters;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.camera != null && (parameters = this.camera.getParameters()) != null && parameters.getSupportedFocusModes() != null && parameters.getFocusMode() != null && parameters.getSupportedFocusModes().contains("auto") && parameters.getFocusMode().equals("auto")) {
                    this.camera.autoFocus(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public IdCardActivity getAttachedActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAttachedActivity : (IdCardActivity) invokeV.objValue;
    }

    public Camera getCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.camera : (Camera) invokeV.objValue;
    }

    public int getCameraID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cameraID : invokeV.intValue;
    }

    public Camera.PictureCallback getPictureCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPictureCallback : (Camera.PictureCallback) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            pointFocus(motionEvent.getX(), motionEvent.getY());
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void pointFocus(float f2, float f3) {
        Camera.Parameters parameters;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            try {
                if (this.camera != null && (parameters = this.camera.getParameters()) != null && parameters.getSupportedFocusModes() != null && parameters.getFocusMode() != null && parameters.getSupportedFocusModes().contains("auto") && parameters.getFocusMode().equals("auto")) {
                    ArrayList arrayList = new ArrayList();
                    int clamp = clamp((int) (((f2 / getWidth()) * 2000.0f) - 1000.0f), -1000, getWidth() - this.focusAreaSize);
                    int clamp2 = clamp((int) (((f3 / getHeight()) * 2000.0f) - 1000.0f), -1000, getHeight() - this.focusAreaSize);
                    String str = TAG;
                    LogUtil.d(str, "getWidth()" + getWidth() + "getHeight()" + getHeight());
                    String str2 = TAG;
                    LogUtil.d(str2, "left" + clamp + "top" + clamp2);
                    arrayList.add(new Camera.Area(new Rect(clamp, clamp2, this.focusAreaSize + clamp, this.focusAreaSize + clamp2), 1000));
                    this.camera.cancelAutoFocus();
                    parameters.setFocusMode("auto");
                    parameters.setFocusAreas(arrayList);
                    this.camera.setParameters(parameters);
                    this.camera.autoFocus(this.mFocusCallback);
                }
            } catch (Exception unused) {
                autoFocus();
            }
        }
    }

    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.camera != null) {
                    this.camera.setPreviewCallbackWithBuffer(null);
                    this.camera.setPreviewCallback(null);
                    this.camera.stopPreview();
                    this.camera.release();
                    this.camera = null;
                }
                if (this.looperThread == null || this.looperThread.handler == null) {
                    return;
                }
                this.looperThread.handler.getLooper().quit();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, idCardActivity) == null) {
            this.mAttachedActivity = idCardActivity;
        }
    }

    public void setAutoFocusCallback(Camera.AutoFocusCallback autoFocusCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, autoFocusCallback) == null) {
            this.mFocusCallback = autoFocusCallback;
        }
    }

    public void setPictureCallback(Camera.PictureCallback pictureCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pictureCallback) == null) {
            this.mPictureCallback = pictureCallback;
        }
    }

    public void setPreviewCallback(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, callback) == null) {
            this.callback = callback;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048588, this, surfaceHolder, i2, i3, i4) == null) || surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            if (this.camera != null) {
                this.camera.stopPreview();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            setupCamera();
            if (this.camera != null) {
                this.camera.setPreviewDisplay(surfaceHolder);
                this.camera.startPreview();
                autoFocus();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
            initCamera();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceHolder) == null) {
            Camera camera = this.camera;
            if (camera != null) {
                camera.release();
            }
            LooperThread looperThread = this.looperThread;
            if (looperThread == null || (handler = looperThread.handler) == null) {
                return;
            }
            handler.getLooper().quit();
        }
    }

    public void switchCamera() {
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (surfaceHolder = this.surfaceHolder) == null || surfaceHolder.getSurface() == null) {
            return;
        }
        if (this.mCurrentCameraPosition == 1) {
            this.mCurrentCameraPosition = 0;
        } else {
            this.mCurrentCameraPosition = 1;
        }
        try {
            releaseSource();
            initCamera();
            setupCamera();
            this.camera.setPreviewDisplay(this.surfaceHolder);
            this.camera.startPreview();
            autoFocus();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void takePicture() {
        Camera camera;
        Camera.PictureCallback pictureCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.mCurrentMode != 0 || (camera = this.camera) == null || (pictureCallback = this.mPictureCallback) == null) {
            return;
        }
        camera.takePicture(null, null, pictureCallback);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurfaceViewForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurfaceViewForScan(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.buffer = new byte[4];
        this.mCurrentCameraPosition = 0;
        this.mCurrentMode = 1;
        this.mPictureCallback = null;
        this.mContext = null;
        this.focusAreaSize = 100;
        init(context, attributeSet, i2);
    }
}
