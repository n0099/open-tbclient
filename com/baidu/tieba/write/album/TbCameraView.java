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
/* loaded from: classes13.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener aXP;
    private b kNA;
    private boolean kNB;
    private final Runnable kNC;
    private final Runnable kND;
    private Camera.PictureCallback kNE;
    private c kNc;
    private a kNd;
    private Camera.Parameters kNs;
    private String kNt;
    private d kNu;
    private float kNv;
    private int kNw;
    private int kNx;
    private boolean kNy;
    private Bitmap kNz;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes13.dex */
    public interface a {
        void cUH();
    }

    /* loaded from: classes13.dex */
    public interface b {
        void cU(int i, int i2);
    }

    /* loaded from: classes13.dex */
    public interface c {
        boolean buD();
    }

    /* loaded from: classes13.dex */
    public interface d {
        void cUI();

        void cUJ();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.kNt = null;
        this.mTouchMode = 0;
        this.kNy = false;
        this.kNB = false;
        this.aXP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.kNB) {
                    TbCameraView.this.kNB = TbCameraView.this.kNc != null && TbCameraView.this.kNc.buD();
                }
                if (TbCameraView.this.kNB) {
                    new Thread(TbCameraView.this.kNC).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.kND).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.kNC = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.tN(TbCameraView.this.kNy);
                }
            }
        };
        this.kND = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.kNE = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.kNz = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.kNu != null) {
                        TbCameraView.this.kNu.cUI();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.kNu != null) {
                    TbCameraView.this.kNu.cUJ();
                }
            }
        };
        setSurfaceTextureListener(this.aXP);
        this.kNw = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.kNx = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void tN(boolean z) {
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
                if (this.kNd == null) {
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
                            this.kNy = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.kNy = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.kNd == null) {
                        this.kNd.cUH();
                        return;
                    }
                    return;
                }
                i++;
            }
            e(this.mSurfaceTexture);
        }
    }

    private void e(SurfaceTexture surfaceTexture) {
        if (this.mCamera != null) {
            this.kNs = this.mCamera.getParameters();
            this.kNs.setPictureFormat(256);
            Camera.Size e = e(this.kNs.getSupportedPictureSizes(), 1440, 1080);
            this.kNs.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.kNs.getSupportedPreviewSizes(), 1440, 1080);
            this.kNs.setPreviewSize(e2.width, e2.height);
            if (this.kNA != null) {
                this.kNA.cU(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.kNs.getSupportedFocusModes().contains("continuous-video")) {
                this.kNs.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.kNs);
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
                    if (this.kNs != null && this.kNs.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = K(motionEvent);
                        if (this.mDistance > this.kNw) {
                            float f = this.mDistance - this.kNv;
                            int maxZoom = this.kNs.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.kNx) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                Ef(maxZoom);
                                this.kNv = this.mDistance;
                                break;
                            } else if (f < (-this.kNx)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                Ef(i2);
                                this.kNv = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.kNv = K(motionEvent);
                    if (this.kNv > this.kNw) {
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

    public void Ef(int i) {
        if (this.mCamera != null) {
            this.kNs = this.mCamera.getParameters();
            if (this.kNs != null) {
                this.kNs.setZoom(i);
                this.mCamera.setParameters(this.kNs);
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
        this.kNt = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.kNu = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.kNA = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.kNc = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.kNd = aVar;
    }
}
