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
    private TextureView.SurfaceTextureListener aXQ;
    private Camera.Parameters kNE;
    private String kNF;
    private d kNG;
    private float kNH;
    private int kNI;
    private int kNJ;
    private boolean kNK;
    private Bitmap kNL;
    private b kNM;
    private boolean kNN;
    private final Runnable kNO;
    private final Runnable kNP;
    private Camera.PictureCallback kNQ;
    private c kNo;
    private a kNp;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes13.dex */
    public interface a {
        void cUI();
    }

    /* loaded from: classes13.dex */
    public interface b {
        void cU(int i, int i2);
    }

    /* loaded from: classes13.dex */
    public interface c {
        boolean buE();
    }

    /* loaded from: classes13.dex */
    public interface d {
        void cUJ();

        void cUK();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.kNF = null;
        this.mTouchMode = 0;
        this.kNK = false;
        this.kNN = false;
        this.aXQ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.kNN) {
                    TbCameraView.this.kNN = TbCameraView.this.kNo != null && TbCameraView.this.kNo.buE();
                }
                if (TbCameraView.this.kNN) {
                    new Thread(TbCameraView.this.kNO).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.kNP).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.kNO = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.tN(TbCameraView.this.kNK);
                }
            }
        };
        this.kNP = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.kNQ = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.kNL = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.kNG != null) {
                        TbCameraView.this.kNG.cUJ();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.kNG != null) {
                    TbCameraView.this.kNG.cUK();
                }
            }
        };
        setSurfaceTextureListener(this.aXQ);
        this.kNI = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.kNJ = getResources().getDimensionPixelSize(R.dimen.ds20);
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
                if (this.kNp == null) {
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
                            this.kNK = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.kNK = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.kNp == null) {
                        this.kNp.cUI();
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
            this.kNE = this.mCamera.getParameters();
            this.kNE.setPictureFormat(256);
            Camera.Size e = e(this.kNE.getSupportedPictureSizes(), 1440, 1080);
            this.kNE.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.kNE.getSupportedPreviewSizes(), 1440, 1080);
            this.kNE.setPreviewSize(e2.width, e2.height);
            if (this.kNM != null) {
                this.kNM.cU(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.kNE.getSupportedFocusModes().contains("continuous-video")) {
                this.kNE.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.kNE);
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
                    if (this.kNE != null && this.kNE.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = K(motionEvent);
                        if (this.mDistance > this.kNI) {
                            float f = this.mDistance - this.kNH;
                            int maxZoom = this.kNE.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.kNJ) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                Ef(maxZoom);
                                this.kNH = this.mDistance;
                                break;
                            } else if (f < (-this.kNJ)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                Ef(i2);
                                this.kNH = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.kNH = K(motionEvent);
                    if (this.kNH > this.kNI) {
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
            this.kNE = this.mCamera.getParameters();
            if (this.kNE != null) {
                this.kNE.setZoom(i);
                this.mCamera.setParameters(this.kNE);
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
        this.kNF = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.kNG = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.kNM = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.kNo = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.kNp = aVar;
    }
}
