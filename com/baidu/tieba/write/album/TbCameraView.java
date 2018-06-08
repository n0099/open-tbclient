package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener gbF;
    private c hoV;
    private a hoW;
    private final Runnable hpA;
    private final Runnable hpB;
    private Camera.PictureCallback hpC;
    private Camera.Parameters hpo;
    private boolean hpp;
    private String hpq;
    private d hpr;
    private float hps;
    private float hpt;
    private int hpu;
    private int hpv;
    private boolean hpw;
    private Bitmap hpx;
    private b hpy;
    private boolean hpz;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void bGX();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bU(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bGW();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bGY();

        void bGZ();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hpp = false;
        this.hpq = null;
        this.mTouchMode = 0;
        this.hpw = false;
        this.hpz = false;
        this.gbF = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.hpz) {
                    TbCameraView.this.hpz = TbCameraView.this.hoV != null && TbCameraView.this.hoV.bGW();
                }
                if (TbCameraView.this.hpz) {
                    new Thread(TbCameraView.this.hpA).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.hpB).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.hpA = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.nA(TbCameraView.this.hpw);
                }
            }
        };
        this.hpB = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.hpC = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.hpx = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.hpp = false;
                    if (TbCameraView.this.hpr != null) {
                        TbCameraView.this.hpr.bGY();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.hpr != null) {
                    TbCameraView.this.hpr.bGZ();
                }
            }
        };
        setSurfaceTextureListener(this.gbF);
        this.hpu = getResources().getDimensionPixelSize(d.e.ds5);
        this.hpv = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nA(boolean z) {
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
                if (this.hoW == null) {
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
                            this.hpw = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.hpw = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hoW == null) {
                        this.hoW.bGX();
                        return;
                    }
                    return;
                }
                i++;
            }
            c(this.mSurfaceTexture);
        }
    }

    private void c(SurfaceTexture surfaceTexture) {
        if (this.mCamera != null) {
            this.hpo = this.mCamera.getParameters();
            this.hpo.setPictureFormat(256);
            Camera.Size e = e(this.hpo.getSupportedPictureSizes(), 1440, 1080);
            this.hpo.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.hpo.getSupportedPreviewSizes(), 1440, 1080);
            this.hpo.setPreviewSize(e2.width, e2.height);
            if (this.hpy != null) {
                this.hpy.bU(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hpo.getSupportedFocusModes().contains("continuous-video")) {
                this.hpo.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hpo);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.hpp = true;
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
        this.hpp = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hpp) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hpo != null && this.hpo.isZoomSupported() && this.mTouchMode == 2) {
                        this.hps = Q(motionEvent);
                        if (this.hps > this.hpu) {
                            float f = this.hps - this.hpt;
                            int maxZoom = this.hpo.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.hpv) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                vk(maxZoom);
                                this.hpt = this.hps;
                                break;
                            } else if (f < (-this.hpv)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                vk(i2);
                                this.hpt = this.hps;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.hpt = Q(motionEvent);
                    if (this.hpt > this.hpu) {
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

    public void vk(int i) {
        if (this.mCamera != null) {
            this.hpo = this.mCamera.getParameters();
            if (this.hpo != null) {
                this.hpo.setZoom(i);
                this.mCamera.setParameters(this.hpo);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.mRunnable);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (w.y(list) == 0) {
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
        this.hpq = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.hpr = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.hpy = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hoV = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hoW = aVar;
    }
}
