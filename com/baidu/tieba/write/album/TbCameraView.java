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
/* loaded from: classes2.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener bEl;
    private c lRJ;
    private a lRK;
    private Camera.Parameters lRZ;
    private String lSa;
    private d lSb;
    private float lSc;
    private int lSd;
    private int lSe;
    private boolean lSf;
    private Bitmap lSg;
    private b lSh;
    private boolean lSi;
    private final Runnable lSj;
    private final Runnable lSk;
    private Camera.PictureCallback lSl;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void dmN();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void df(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean bKL();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void dmO();

        void dmP();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.lSa = null;
        this.mTouchMode = 0;
        this.lSf = false;
        this.lSi = false;
        this.bEl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.lSi) {
                    TbCameraView.this.lSi = TbCameraView.this.lRJ != null && TbCameraView.this.lRJ.bKL();
                }
                if (TbCameraView.this.lSi) {
                    new Thread(TbCameraView.this.lSj).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.lSk).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.lSj = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.vs(TbCameraView.this.lSf);
                }
            }
        };
        this.lSk = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.lSl = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.lSg = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.lSb != null) {
                        TbCameraView.this.lSb.dmO();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.lSb != null) {
                    TbCameraView.this.lSb.dmP();
                }
            }
        };
        setSurfaceTextureListener(this.bEl);
        this.lSd = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.lSe = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void vs(boolean z) {
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
                if (this.lRK == null) {
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
                            this.lSf = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.lSf = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.lRK == null) {
                        this.lRK.dmN();
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
            this.lRZ = this.mCamera.getParameters();
            this.lRZ.setPictureFormat(256);
            Camera.Size f = f(this.lRZ.getSupportedPictureSizes(), 1440, 1080);
            this.lRZ.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.lRZ.getSupportedPreviewSizes(), 1440, 1080);
            this.lRZ.setPreviewSize(f2.width, f2.height);
            if (this.lSh != null) {
                this.lSh.df(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.lRZ.getSupportedFocusModes().contains("continuous-video")) {
                this.lRZ.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.lRZ);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.mIsPreviewing = true;
            } catch (IOException e) {
                e.printStackTrace();
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
                    if (this.lRZ != null && this.lRZ.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = P(motionEvent);
                        if (this.mDistance > this.lSd) {
                            float f = this.mDistance - this.lSc;
                            int maxZoom = this.lRZ.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.lSe) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                FB(maxZoom);
                                this.lSc = this.mDistance;
                                break;
                            } else if (f < (-this.lSe)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                FB(i2);
                                this.lSc = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.lSc = P(motionEvent);
                    if (this.lSc > this.lSd) {
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

    private float P(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void FB(int i) {
        if (this.mCamera != null) {
            this.lRZ = this.mCamera.getParameters();
            if (this.lRZ != null) {
                this.lRZ.setZoom(i);
                this.mCamera.setParameters(this.lRZ);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.mRunnable);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
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
        this.lSa = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.lSb = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.lSh = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.lRJ = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.lRK = aVar;
    }
}
