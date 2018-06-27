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
    private TextureView.SurfaceTextureListener gfG;
    private String htA;
    private d htB;
    private float htC;
    private float htD;
    private int htE;
    private int htF;
    private boolean htG;
    private Bitmap htH;
    private b htI;
    private boolean htJ;
    private final Runnable htK;
    private final Runnable htL;
    private Camera.PictureCallback htM;
    private c htf;
    private a htg;
    private Camera.Parameters hty;
    private boolean htz;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void bHy();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bS(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bHx();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bHA();

        void bHz();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.htz = false;
        this.htA = null;
        this.mTouchMode = 0;
        this.htG = false;
        this.htJ = false;
        this.gfG = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.htJ) {
                    TbCameraView.this.htJ = TbCameraView.this.htf != null && TbCameraView.this.htf.bHx();
                }
                if (TbCameraView.this.htJ) {
                    new Thread(TbCameraView.this.htK).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.htL).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.htK = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.nI(TbCameraView.this.htG);
                }
            }
        };
        this.htL = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.htM = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.htH = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.htz = false;
                    if (TbCameraView.this.htB != null) {
                        TbCameraView.this.htB.bHz();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.htB != null) {
                    TbCameraView.this.htB.bHA();
                }
            }
        };
        setSurfaceTextureListener(this.gfG);
        this.htE = getResources().getDimensionPixelSize(d.e.ds5);
        this.htF = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nI(boolean z) {
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
                if (this.htg == null) {
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
                            this.htG = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.htG = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.htg == null) {
                        this.htg.bHy();
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
            this.hty = this.mCamera.getParameters();
            this.hty.setPictureFormat(256);
            Camera.Size e = e(this.hty.getSupportedPictureSizes(), 1440, 1080);
            this.hty.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.hty.getSupportedPreviewSizes(), 1440, 1080);
            this.hty.setPreviewSize(e2.width, e2.height);
            if (this.htI != null) {
                this.htI.bS(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hty.getSupportedFocusModes().contains("continuous-video")) {
                this.hty.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hty);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.htz = true;
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
        this.htz = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.htz) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hty != null && this.hty.isZoomSupported() && this.mTouchMode == 2) {
                        this.htC = Q(motionEvent);
                        if (this.htC > this.htE) {
                            float f = this.htC - this.htD;
                            int maxZoom = this.hty.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.htF) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                vt(maxZoom);
                                this.htD = this.htC;
                                break;
                            } else if (f < (-this.htF)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                vt(i2);
                                this.htD = this.htC;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.htD = Q(motionEvent);
                    if (this.htD > this.htE) {
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

    public void vt(int i) {
        if (this.mCamera != null) {
            this.hty = this.mCamera.getParameters();
            if (this.hty != null) {
                this.hty.setZoom(i);
                this.mCamera.setParameters(this.hty);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.mRunnable);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (w.z(list) == 0) {
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
        this.htA = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.htB = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.htI = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.htf = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.htg = aVar;
    }
}
