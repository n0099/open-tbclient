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
    private TextureView.SurfaceTextureListener aYd;
    private c kOY;
    private a kOZ;
    private Camera.PictureCallback kPA;
    private Camera.Parameters kPo;
    private String kPp;
    private d kPq;
    private float kPr;
    private int kPs;
    private int kPt;
    private boolean kPu;
    private Bitmap kPv;
    private b kPw;
    private boolean kPx;
    private final Runnable kPy;
    private final Runnable kPz;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes13.dex */
    public interface a {
        void cVd();
    }

    /* loaded from: classes13.dex */
    public interface b {
        void cV(int i, int i2);
    }

    /* loaded from: classes13.dex */
    public interface c {
        boolean buJ();
    }

    /* loaded from: classes13.dex */
    public interface d {
        void cVe();

        void cVf();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.kPp = null;
        this.mTouchMode = 0;
        this.kPu = false;
        this.kPx = false;
        this.aYd = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.kPx) {
                    TbCameraView.this.kPx = TbCameraView.this.kOY != null && TbCameraView.this.kOY.buJ();
                }
                if (TbCameraView.this.kPx) {
                    new Thread(TbCameraView.this.kPy).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.kPz).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.kPy = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.tU(TbCameraView.this.kPu);
                }
            }
        };
        this.kPz = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.kPA = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.kPv = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.kPq != null) {
                        TbCameraView.this.kPq.cVe();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.kPq != null) {
                    TbCameraView.this.kPq.cVf();
                }
            }
        };
        setSurfaceTextureListener(this.aYd);
        this.kPs = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.kPt = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void tU(boolean z) {
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
                if (this.kOZ == null) {
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
                            this.kPu = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.kPu = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.kOZ == null) {
                        this.kOZ.cVd();
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
            this.kPo = this.mCamera.getParameters();
            this.kPo.setPictureFormat(256);
            Camera.Size e = e(this.kPo.getSupportedPictureSizes(), 1440, 1080);
            this.kPo.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.kPo.getSupportedPreviewSizes(), 1440, 1080);
            this.kPo.setPreviewSize(e2.width, e2.height);
            if (this.kPw != null) {
                this.kPw.cV(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.kPo.getSupportedFocusModes().contains("continuous-video")) {
                this.kPo.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.kPo);
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
                    if (this.kPo != null && this.kPo.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = K(motionEvent);
                        if (this.mDistance > this.kPs) {
                            float f = this.mDistance - this.kPr;
                            int maxZoom = this.kPo.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.kPt) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                En(maxZoom);
                                this.kPr = this.mDistance;
                                break;
                            } else if (f < (-this.kPt)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                En(i2);
                                this.kPr = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.kPr = K(motionEvent);
                    if (this.kPr > this.kPs) {
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

    public void En(int i) {
        if (this.mCamera != null) {
            this.kPo = this.mCamera.getParameters();
            if (this.kPo != null) {
                this.kPo.setZoom(i);
                this.mCamera.setParameters(this.kPo);
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
        this.kPp = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.kPq = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.kPw = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.kOY = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.kOZ = aVar;
    }
}
