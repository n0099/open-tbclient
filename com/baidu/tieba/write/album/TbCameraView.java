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
    private boolean fOe;
    private String fVA;
    private float fVB;
    private float fVC;
    private int fVD;
    private int fVE;
    private Bitmap fVF;
    private SurfaceHolder.Callback fVG;
    private Camera.PictureCallback fVH;
    private c fVn;
    private a fVo;
    private b fVp;
    private d fVr;
    private Camera.Parameters fVy;
    private boolean fVz;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes.dex */
    public interface a {
        void bod();
    }

    /* loaded from: classes.dex */
    public interface b {
        void br(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean boc();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bnt();

        void boe();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fVz = false;
        this.fVA = null;
        this.mTouchMode = 0;
        this.fOe = false;
        this.fVG = new au(this);
        this.fVH = new av(this);
        this.mRunnable = new aw(this);
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.fVG);
        this.fVD = getResources().getDimensionPixelSize(w.f.ds5);
        this.fVE = getResources().getDimensionPixelSize(w.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lY(boolean z) {
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
                if (this.fVo == null) {
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
                            this.fOe = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.fOe = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.fVo == null) {
                        this.fVo.bod();
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
            this.fVy = this.mCamera.getParameters();
            this.fVy.setPictureFormat(256);
            Camera.Size e = e(this.fVy.getSupportedPictureSizes(), 1440, 1080);
            this.fVy.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.fVy.getSupportedPreviewSizes(), 1440, 1080);
            this.fVy.setPreviewSize(e2.width, e2.height);
            if (this.fVp != null) {
                this.fVp.br(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.fVy.getSupportedFocusModes().contains("continuous-video")) {
                this.fVy.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.fVy);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.fVz = true;
        }
    }

    public void bnV() {
        if (this.mCamera != null && !this.fVz) {
            this.mCamera.startPreview();
            this.fVz = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.fVz = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.fVz && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.fVH);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fVz) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.fVy != null && this.fVy.isZoomSupported() && this.mTouchMode == 2) {
                        this.fVB = r(motionEvent);
                        if (this.fVB > this.fVD) {
                            float f = this.fVB - this.fVC;
                            int maxZoom = this.fVy.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.fVE) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                to(maxZoom);
                                this.fVC = this.fVB;
                                break;
                            } else if (f < (-this.fVE)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                to(i2);
                                this.fVC = this.fVB;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.fVC = r(motionEvent);
                    if (this.fVC > this.fVD) {
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

    private float r(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void to(int i) {
        if (this.mCamera != null) {
            this.fVy = this.mCamera.getParameters();
            if (this.fVy != null) {
                this.fVy.setZoom(i);
                this.mCamera.setParameters(this.fVy);
            }
        }
    }

    public void bog() {
        com.baidu.tbadk.util.w.a(new ax(this), null);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.mRunnable);
    }

    public void boh() {
        if (this.fVF != null) {
            this.fVF.recycle();
            this.fVF = null;
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
        this.fVA = str;
    }

    public void boi() {
        stopCamera();
        lY(!this.fOe);
    }

    public void setOnGotPictureListener(d dVar) {
        this.fVr = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.fVp = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.fVn = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.fVo = aVar;
    }
}
