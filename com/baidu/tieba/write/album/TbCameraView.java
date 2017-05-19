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
import com.baidu.tieba.w;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public class TbCameraView extends SurfaceView {
    private int cxH;
    private boolean fGk;
    private c fNG;
    private a fNH;
    private b fNI;
    private d fNK;
    private Camera.Parameters fNR;
    private boolean fNS;
    private String fNT;
    private float fNU;
    private float fNV;
    private int fNW;
    private int fNX;
    private Bitmap fNY;
    private SurfaceHolder.Callback fNZ;
    private Camera.PictureCallback fOa;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;

    /* loaded from: classes.dex */
    public interface a {
        void bmG();
    }

    /* loaded from: classes.dex */
    public interface b {
        void br(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean bmF();
    }

    /* loaded from: classes.dex */
    public interface d {
        void blW();

        void bmH();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fNS = false;
        this.fNT = null;
        this.cxH = 0;
        this.fGk = false;
        this.fNZ = new au(this);
        this.fOa = new av(this);
        this.mRunnable = new aw(this);
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.fNZ);
        this.fNW = getResources().getDimensionPixelSize(w.f.ds5);
        this.fNX = getResources().getDimensionPixelSize(w.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lF(boolean z) {
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
                if (this.fNH == null) {
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
                            this.fGk = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.fGk = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.fNH == null) {
                        this.fNH.bmG();
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
            this.fNR = this.mCamera.getParameters();
            this.fNR.setPictureFormat(256);
            Camera.Size e = e(this.fNR.getSupportedPictureSizes(), 1440, 1080);
            this.fNR.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.fNR.getSupportedPreviewSizes(), 1440, 1080);
            this.fNR.setPreviewSize(e2.width, e2.height);
            if (this.fNI != null) {
                this.fNI.br(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.fNR.getSupportedFocusModes().contains("continuous-video")) {
                this.fNR.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.fNR);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.fNS = true;
        }
    }

    public void bmy() {
        if (this.mCamera != null && !this.fNS) {
            this.mCamera.startPreview();
            this.fNS = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.fNS = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.fNS && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.fOa);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fNS) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.cxH = 1;
                    break;
                case 1:
                    this.cxH = 0;
                    break;
                case 2:
                    if (this.fNR != null && this.fNR.isZoomSupported() && this.cxH == 2) {
                        this.fNU = q(motionEvent);
                        if (this.fNU > this.fNW) {
                            float f = this.fNU - this.fNV;
                            int maxZoom = this.fNR.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.fNX) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                sT(maxZoom);
                                this.fNV = this.fNU;
                                break;
                            } else if (f < (-this.fNX)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                sT(i2);
                                this.fNV = this.fNU;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.fNV = q(motionEvent);
                    if (this.fNV > this.fNW) {
                        this.cxH = 2;
                        break;
                    }
                    break;
                case 6:
                    this.cxH = 0;
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private float q(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void sT(int i) {
        if (this.mCamera != null) {
            this.fNR = this.mCamera.getParameters();
            if (this.fNR != null) {
                this.fNR.setZoom(i);
                this.mCamera.setParameters(this.fNR);
            }
        }
    }

    public void bmJ() {
        com.baidu.tbadk.util.w.a(new ax(this), null);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.mRunnable);
    }

    public void bmK() {
        if (this.fNY != null) {
            this.fNY.recycle();
            this.fNY = null;
        }
    }

    public Bitmap b(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (com.baidu.tbadk.core.util.x.q(list) == 0) {
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
        this.fNT = str;
    }

    public void bmL() {
        stopCamera();
        lF(!this.fGk);
    }

    public void setOnGotPictureListener(d dVar) {
        this.fNK = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.fNI = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.fNG = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.fNH = aVar;
    }
}
