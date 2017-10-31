package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class TbCameraView extends SurfaceView {
    private Camera.Parameters gRE;
    private String gRF;
    private float gRG;
    private int gRH;
    private SurfaceHolder.Callback gRI;
    private c gRt;
    private a gRu;
    private b gRv;
    private d gRx;
    private int gkU;
    private float gko;
    private Camera.PictureCallback glD;
    private boolean glo;
    private boolean glr;
    private Bitmap gls;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void brU();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void cf(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean brT();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void brW();

        void brX();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.glo = false;
        this.gRF = null;
        this.mTouchMode = 0;
        this.glr = false;
        this.gRI = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gRt != null && TbCameraView.this.gRt.brT()) {
                    TbCameraView.this.mn(TbCameraView.this.glr);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                TbCameraView.this.stopCamera();
            }
        };
        this.glD = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.gls = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.glo = false;
                    if (TbCameraView.this.gRx != null) {
                        TbCameraView.this.gRx.brW();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gRx != null) {
                    TbCameraView.this.gRx.brX();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gRI);
        this.gRH = getResources().getDimensionPixelSize(d.e.ds5);
        this.gkU = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mn(boolean z) {
        Camera.CameraInfo cameraInfo;
        int numberOfCameras;
        int i = 0;
        if (this.mSurfaceHolder != null) {
            try {
                cameraInfo = new Camera.CameraInfo();
                numberOfCameras = Camera.getNumberOfCameras();
            } catch (Throwable th) {
                th.printStackTrace();
                this.mCamera = null;
                if (this.gRu == null) {
                }
            }
            while (true) {
                if (i >= numberOfCameras) {
                    break;
                }
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo != null) {
                    if (z) {
                        if (cameraInfo.facing == 1) {
                            this.mCamera = Camera.open(i);
                            this.glr = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.glr = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gRu == null) {
                        this.gRu.brU();
                        return;
                    }
                    return;
                }
                i++;
            }
            startPreview(this.mSurfaceHolder);
        }
    }

    private void startPreview(SurfaceHolder surfaceHolder) {
        if (this.mCamera != null) {
            this.gRE = this.mCamera.getParameters();
            this.gRE.setPictureFormat(256);
            Camera.Size f = f(this.gRE.getSupportedPictureSizes(), 1440, 1080);
            this.gRE.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.gRE.getSupportedPreviewSizes(), 1440, 1080);
            this.gRE.setPreviewSize(f2.width, f2.height);
            if (this.gRv != null) {
                this.gRv.cf(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gRE.getSupportedFocusModes().contains("continuous-video")) {
                this.gRE.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gRE);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.glo = true;
        }
    }

    public void bsa() {
        if (this.mCamera != null && !this.glo) {
            this.mCamera.startPreview();
            this.glo = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.glo = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.glo && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.glD);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.glo) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gRE != null && this.gRE.isZoomSupported() && this.mTouchMode == 2) {
                        this.gRG = C(motionEvent);
                        if (this.gRG > this.gRH) {
                            float f = this.gRG - this.gko;
                            int maxZoom = this.gRE.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.gkU) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                vn(maxZoom);
                                this.gko = this.gRG;
                                break;
                            } else if (f < (-this.gkU)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                vn(i2);
                                this.gko = this.gRG;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.gko = C(motionEvent);
                    if (this.gko > this.gRH) {
                        this.mTouchMode = 2;
                        break;
                    }
                    break;
                case 6:
                    this.mTouchMode = 0;
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private float C(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void vn(int i) {
        if (this.mCamera != null) {
            this.gRE = this.mCamera.getParameters();
            if (this.gRE != null) {
                this.gRE.setZoom(i);
                this.mCamera.setParameters(this.gRE);
            }
        }
    }

    public void bsb() {
        v.a(new u<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                if (TbCameraView.this.gls != null && !StringUtils.isNull(TbCameraView.this.gRF)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.gls, TbCameraView.this.glr ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gRF));
                            b2.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            b2.recycle();
                            com.baidu.adp.lib.g.e.fP().post(TbCameraView.this.mRunnable);
                            return null;
                        }
                        return null;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }, null);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mRunnable);
    }

    public void bDd() {
        if (this.gls != null) {
            this.gls.recycle();
            this.gls = null;
        }
    }

    public Bitmap b(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
        if (com.baidu.tbadk.core.util.v.u(list) == 0) {
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            Camera.Size size = list.get(i5);
            if (size != null) {
                int abs = Math.abs(size.height - i2) + Math.abs(size.width - i);
                if (i5 == 0) {
                    i3 = abs;
                    i4 = 0;
                } else if (abs < i3) {
                    i3 = abs;
                    i4 = i5;
                }
            }
        }
        return list.get(i4);
    }

    public void setStorePath(String str) {
        this.gRF = str;
    }

    public void bsd() {
        stopCamera();
        mn(!this.glr);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gRx = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gRv = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gRt = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gRu = aVar;
    }
}
