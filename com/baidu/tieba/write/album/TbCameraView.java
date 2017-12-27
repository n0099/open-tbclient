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
import com.baidu.tieba.d;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener gDr;
    private c hNK;
    private a hNL;
    private Camera.Parameters hOd;
    private boolean hOe;
    private String hOf;
    private d hOg;
    private float hOh;
    private float hOi;
    private int hOj;
    private int hOk;
    private Bitmap hOl;
    private b hOm;
    private boolean hOn;
    private final Runnable hOo;
    private final Runnable hOp;
    private Camera.PictureCallback hOq;
    private boolean huS;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void bMm();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void dd(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean bMl();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void bMn();

        void bMo();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hOe = false;
        this.hOf = null;
        this.mTouchMode = 0;
        this.huS = false;
        this.hOn = false;
        this.gDr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.hOn) {
                    TbCameraView.this.hOn = TbCameraView.this.hNK != null && TbCameraView.this.hNK.bMl();
                }
                if (TbCameraView.this.hOn) {
                    new Thread(TbCameraView.this.hOo).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.hOp).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.hOo = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.ov(TbCameraView.this.huS);
                }
            }
        };
        this.hOp = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.hOq = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.hOl = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.hOe = false;
                    if (TbCameraView.this.hOg != null) {
                        TbCameraView.this.hOg.bMn();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.hOg != null) {
                    TbCameraView.this.hOg.bMo();
                }
            }
        };
        setSurfaceTextureListener(this.gDr);
        this.hOj = getResources().getDimensionPixelSize(d.e.ds5);
        this.hOk = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ov(boolean z) {
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
                if (this.hNL == null) {
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
                            this.huS = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.huS = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hNL == null) {
                        this.hNL.bMm();
                        return;
                    }
                    return;
                }
                i++;
            }
            b(this.mSurfaceTexture);
        }
    }

    private void b(SurfaceTexture surfaceTexture) {
        if (this.mCamera != null) {
            this.hOd = this.mCamera.getParameters();
            this.hOd.setPictureFormat(256);
            Camera.Size f = f(this.hOd.getSupportedPictureSizes(), 1440, 1080);
            this.hOd.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.hOd.getSupportedPreviewSizes(), 1440, 1080);
            this.hOd.setPreviewSize(f2.width, f2.height);
            if (this.hOm != null) {
                this.hOm.dd(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hOd.getSupportedFocusModes().contains("continuous-video")) {
                this.hOd.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hOd);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.hOe = true;
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
        this.hOe = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hOe) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hOd != null && this.hOd.isZoomSupported() && this.mTouchMode == 2) {
                        this.hOh = Q(motionEvent);
                        if (this.hOh > this.hOj) {
                            float f = this.hOh - this.hOi;
                            int maxZoom = this.hOd.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.hOk) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                yM(maxZoom);
                                this.hOi = this.hOh;
                                break;
                            } else if (f < (-this.hOk)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                yM(i2);
                                this.hOi = this.hOh;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.hOi = Q(motionEvent);
                    if (this.hOi > this.hOj) {
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

    private float Q(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void yM(int i) {
        if (this.mCamera != null) {
            this.hOd = this.mCamera.getParameters();
            if (this.hOd != null) {
                this.hOd.setZoom(i);
                this.mCamera.setParameters(this.hOd);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.mRunnable);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
        if (v.F(list) == 0) {
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
        this.hOf = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.hOg = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.hOm = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hNK = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hNL = aVar;
    }
}
