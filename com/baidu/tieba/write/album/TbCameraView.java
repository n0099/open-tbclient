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
    private TextureView.SurfaceTextureListener guE;
    private Camera.Parameters hFN;
    private boolean hFO;
    private String hFP;
    private d hFQ;
    private float hFR;
    private float hFS;
    private int hFT;
    private int hFU;
    private boolean hFV;
    private Bitmap hFW;
    private b hFX;
    private boolean hFY;
    private final Runnable hFZ;
    private c hFu;
    private a hFv;
    private final Runnable hGa;
    private Camera.PictureCallback hGb;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void bGG();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void cR(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean bGF();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void bGH();

        void bGI();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFO = false;
        this.hFP = null;
        this.mTouchMode = 0;
        this.hFV = false;
        this.hFY = false;
        this.guE = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.hFY) {
                    TbCameraView.this.hFY = TbCameraView.this.hFu != null && TbCameraView.this.hFu.bGF();
                }
                if (TbCameraView.this.hFY) {
                    new Thread(TbCameraView.this.hFZ).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.hGa).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.hFZ = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.nN(TbCameraView.this.hFV);
                }
            }
        };
        this.hGa = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.hGb = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.hFW = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.hFO = false;
                    if (TbCameraView.this.hFQ != null) {
                        TbCameraView.this.hFQ.bGH();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.hFQ != null) {
                    TbCameraView.this.hFQ.bGI();
                }
            }
        };
        setSurfaceTextureListener(this.guE);
        this.hFT = getResources().getDimensionPixelSize(d.e.ds5);
        this.hFU = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nN(boolean z) {
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
                if (this.hFv == null) {
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
                            this.hFV = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.hFV = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hFv == null) {
                        this.hFv.bGG();
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
            this.hFN = this.mCamera.getParameters();
            this.hFN.setPictureFormat(256);
            Camera.Size f = f(this.hFN.getSupportedPictureSizes(), 1440, 1080);
            this.hFN.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.hFN.getSupportedPreviewSizes(), 1440, 1080);
            this.hFN.setPreviewSize(f2.width, f2.height);
            if (this.hFX != null) {
                this.hFX.cR(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hFN.getSupportedFocusModes().contains("continuous-video")) {
                this.hFN.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hFN);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.hFO = true;
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
        this.hFO = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hFO) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hFN != null && this.hFN.isZoomSupported() && this.mTouchMode == 2) {
                        this.hFR = U(motionEvent);
                        if (this.hFR > this.hFT) {
                            float f = this.hFR - this.hFS;
                            int maxZoom = this.hFN.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.hFU) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                xp(maxZoom);
                                this.hFS = this.hFR;
                                break;
                            } else if (f < (-this.hFU)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                xp(i2);
                                this.hFS = this.hFR;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.hFS = U(motionEvent);
                    if (this.hFS > this.hFT) {
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

    private float U(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void xp(int i) {
        if (this.mCamera != null) {
            this.hFN = this.mCamera.getParameters();
            if (this.hFN != null) {
                this.hFN.setZoom(i);
                this.mCamera.setParameters(this.hFN);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mRunnable);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
        if (v.D(list) == 0) {
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
        this.hFP = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.hFQ = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.hFX = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hFu = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hFv = aVar;
    }
}
