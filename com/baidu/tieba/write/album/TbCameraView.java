package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.io.IOException;
import java.util.List;
/* loaded from: classes11.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener aTp;
    private Camera.Parameters kMK;
    private String kML;
    private d kMM;
    private float kMN;
    private int kMO;
    private int kMP;
    private boolean kMQ;
    private Bitmap kMR;
    private b kMS;
    private boolean kMT;
    private final Runnable kMU;
    private final Runnable kMV;
    private Camera.PictureCallback kMW;
    private c kMu;
    private a kMv;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes11.dex */
    public interface a {
        void cTr();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void cR(int i, int i2);
    }

    /* loaded from: classes11.dex */
    public interface c {
        boolean bsX();
    }

    /* loaded from: classes11.dex */
    public interface d {
        void cTs();

        void cTt();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.kML = null;
        this.mTouchMode = 0;
        this.kMQ = false;
        this.kMT = false;
        this.aTp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.kMT) {
                    TbCameraView.this.kMT = TbCameraView.this.kMu != null && TbCameraView.this.kMu.bsX();
                }
                if (TbCameraView.this.kMT) {
                    new Thread(TbCameraView.this.kMU).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.kMV).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.kMU = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.tJ(TbCameraView.this.kMQ);
                }
            }
        };
        this.kMV = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.kMW = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.kMR = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.kMM != null) {
                        TbCameraView.this.kMM.cTs();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.kMM != null) {
                    TbCameraView.this.kMM.cTt();
                }
            }
        };
        setSurfaceTextureListener(this.aTp);
        this.kMO = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.kMP = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void tJ(boolean z) {
        Camera.CameraInfo cameraInfo;
        int numberOfCameras;
        int i = 0;
        if (this.mSurfaceTexture != null) {
            try {
                stopCamera();
                cameraInfo = new Camera.CameraInfo();
                numberOfCameras = Camera.getNumberOfCameras();
            } catch (Throwable th) {
                th.printStackTrace();
                stopCamera();
                if (this.kMv == null) {
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
                            this.kMQ = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.kMQ = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.kMv == null) {
                        this.kMv.cTr();
                        return;
                    }
                    return;
                }
                i++;
            }
            f(this.mSurfaceTexture);
        }
    }

    private void f(SurfaceTexture surfaceTexture) {
        if (this.mCamera != null) {
            this.kMK = this.mCamera.getParameters();
            this.kMK.setPictureFormat(256);
            Camera.Size e = e(this.kMK.getSupportedPictureSizes(), 1440, 1080);
            this.kMK.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.kMK.getSupportedPreviewSizes(), 1440, 1080);
            this.kMK.setPreviewSize(e2.width, e2.height);
            if (this.kMS != null) {
                this.kMS.cR(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.kMK.getSupportedFocusModes().contains("continuous-video")) {
                this.kMK.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.kMK);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.mIsPreviewing = true;
            } catch (IOException e3) {
                e3.printStackTrace();
                stopCamera();
            }
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            try {
                this.mCamera.setPreviewCallback(null);
                this.mCamera.stopPreview();
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mIsPreviewing = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsPreviewing) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.kMK != null && this.kMK.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = K(motionEvent);
                        if (this.mDistance > this.kMO) {
                            float f = this.mDistance - this.kMN;
                            int maxZoom = this.kMK.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.kMP) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                Ea(maxZoom);
                                this.kMN = this.mDistance;
                                break;
                            } else if (f < (-this.kMP)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                Ea(i2);
                                this.kMN = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.kMN = K(motionEvent);
                    if (this.kMN > this.kMO) {
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

    private float K(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void Ea(int i) {
        if (this.mCamera != null) {
            this.kMK = this.mCamera.getParameters();
            if (this.kMK != null) {
                this.kMK.setZoom(i);
                this.mCamera.setParameters(this.kMK);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.mRunnable);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (v.getCount(list) == 0) {
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
        this.kML = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.kMM = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.kMS = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.kMu = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.kMv = aVar;
    }
}
