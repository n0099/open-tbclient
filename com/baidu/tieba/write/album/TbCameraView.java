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
import com.baidu.tieba.e;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener gHq;
    private c hWL;
    private a hWM;
    private Camera.Parameters hXd;
    private boolean hXe;
    private String hXf;
    private d hXg;
    private float hXh;
    private float hXi;
    private int hXj;
    private int hXk;
    private boolean hXl;
    private Bitmap hXm;
    private b hXn;
    private boolean hXo;
    private final Runnable hXp;
    private final Runnable hXq;
    private Camera.PictureCallback hXr;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void bPs();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cc(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bPr();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bPt();

        void bPu();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hXe = false;
        this.hXf = null;
        this.mTouchMode = 0;
        this.hXl = false;
        this.hXo = false;
        this.gHq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.hXo) {
                    TbCameraView.this.hXo = TbCameraView.this.hWL != null && TbCameraView.this.hWL.bPr();
                }
                if (TbCameraView.this.hXo) {
                    new Thread(TbCameraView.this.hXp).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.hXq).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.hXp = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.oD(TbCameraView.this.hXl);
                }
            }
        };
        this.hXq = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.hXr = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.hXm = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.hXe = false;
                    if (TbCameraView.this.hXg != null) {
                        TbCameraView.this.hXg.bPt();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.hXg != null) {
                    TbCameraView.this.hXg.bPu();
                }
            }
        };
        setSurfaceTextureListener(this.gHq);
        this.hXj = getResources().getDimensionPixelSize(e.C0210e.ds5);
        this.hXk = getResources().getDimensionPixelSize(e.C0210e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void oD(boolean z) {
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
                if (this.hWM == null) {
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
                            this.hXl = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.hXl = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hWM == null) {
                        this.hWM.bPs();
                        return;
                    }
                    return;
                }
                i++;
            }
            d(this.mSurfaceTexture);
        }
    }

    private void d(SurfaceTexture surfaceTexture) {
        if (this.mCamera != null) {
            this.hXd = this.mCamera.getParameters();
            this.hXd.setPictureFormat(256);
            Camera.Size f = f(this.hXd.getSupportedPictureSizes(), 1440, 1080);
            this.hXd.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.hXd.getSupportedPreviewSizes(), 1440, 1080);
            this.hXd.setPreviewSize(f2.width, f2.height);
            if (this.hXn != null) {
                this.hXn.cc(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hXd.getSupportedFocusModes().contains("continuous-video")) {
                this.hXd.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hXd);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.hXe = true;
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
        this.hXe = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hXe) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hXd != null && this.hXd.isZoomSupported() && this.mTouchMode == 2) {
                        this.hXh = P(motionEvent);
                        if (this.hXh > this.hXj) {
                            float f = this.hXh - this.hXi;
                            int maxZoom = this.hXd.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.hXk) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                xu(maxZoom);
                                this.hXi = this.hXh;
                                break;
                            } else if (f < (-this.hXk)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                xu(i2);
                                this.hXi = this.hXh;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.hXi = P(motionEvent);
                    if (this.hXi > this.hXj) {
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

    public void xu(int i) {
        if (this.mCamera != null) {
            this.hXd = this.mCamera.getParameters();
            if (this.hXd != null) {
                this.hXd.setZoom(i);
                this.mCamera.setParameters(this.hXd);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mRunnable);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
        if (v.H(list) == 0) {
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
        this.hXf = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.hXg = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.hXn = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hWL = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hWM = aVar;
    }
}
