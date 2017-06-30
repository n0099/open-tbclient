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
    private boolean fXV;
    private c gfY;
    private a gfZ;
    private b gga;
    private d ggc;
    private Camera.Parameters ggj;
    private boolean ggk;
    private String ggl;
    private float ggm;
    private float ggn;
    private int ggo;
    private int ggp;
    private Bitmap ggq;
    private SurfaceHolder.Callback ggr;
    private Camera.PictureCallback ggs;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes.dex */
    public interface a {
        void bsA();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bA(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean bsz();
    }

    /* loaded from: classes.dex */
    public interface d {
        void brQ();

        void bsB();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggk = false;
        this.ggl = null;
        this.mTouchMode = 0;
        this.fXV = false;
        this.ggr = new au(this);
        this.ggs = new av(this);
        this.mRunnable = new aw(this);
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.ggr);
        this.ggo = getResources().getDimensionPixelSize(w.f.ds5);
        this.ggp = getResources().getDimensionPixelSize(w.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mz(boolean z) {
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
                if (this.gfZ == null) {
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
                            this.fXV = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.fXV = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gfZ == null) {
                        this.gfZ.bsA();
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
            this.ggj = this.mCamera.getParameters();
            this.ggj.setPictureFormat(256);
            Camera.Size e = e(this.ggj.getSupportedPictureSizes(), 1440, 1080);
            this.ggj.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.ggj.getSupportedPreviewSizes(), 1440, 1080);
            this.ggj.setPreviewSize(e2.width, e2.height);
            if (this.gga != null) {
                this.gga.bA(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.ggj.getSupportedFocusModes().contains("continuous-video")) {
                this.ggj.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.ggj);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.ggk = true;
        }
    }

    public void bss() {
        if (this.mCamera != null && !this.ggk) {
            this.mCamera.startPreview();
            this.ggk = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.ggk = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.ggk && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.ggs);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ggk) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.ggj != null && this.ggj.isZoomSupported() && this.mTouchMode == 2) {
                        this.ggm = t(motionEvent);
                        if (this.ggm > this.ggo) {
                            float f = this.ggm - this.ggn;
                            int maxZoom = this.ggj.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.ggp) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                tJ(maxZoom);
                                this.ggn = this.ggm;
                                break;
                            } else if (f < (-this.ggp)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                tJ(i2);
                                this.ggn = this.ggm;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.ggn = t(motionEvent);
                    if (this.ggn > this.ggo) {
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

    private float t(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void tJ(int i) {
        if (this.mCamera != null) {
            this.ggj = this.mCamera.getParameters();
            if (this.ggj != null) {
                this.ggj.setZoom(i);
                this.mCamera.setParameters(this.ggj);
            }
        }
    }

    public void bsD() {
        com.baidu.tbadk.util.x.a(new ax(this), null);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.mRunnable);
    }

    public void bsE() {
        if (this.ggq != null) {
            this.ggq.recycle();
            this.ggq = null;
        }
    }

    public Bitmap b(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (com.baidu.tbadk.core.util.z.s(list) == 0) {
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
        this.ggl = str;
    }

    public void bsF() {
        stopCamera();
        mz(!this.fXV);
    }

    public void setOnGotPictureListener(d dVar) {
        this.ggc = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gga = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gfY = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gfZ = aVar;
    }
}
