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
    private TextureView.SurfaceTextureListener gsT;
    private c hDM;
    private a hDN;
    private Camera.Parameters hEf;
    private boolean hEg;
    private String hEh;
    private d hEi;
    private float hEj;
    private float hEk;
    private int hEl;
    private int hEm;
    private Bitmap hEn;
    private b hEo;
    private boolean hEp;
    private final Runnable hEq;
    private final Runnable hEr;
    private Camera.PictureCallback hEs;
    private boolean hkQ;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void bFO();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void cW(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean bFN();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void bFP();

        void bFQ();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEg = false;
        this.hEh = null;
        this.mTouchMode = 0;
        this.hkQ = false;
        this.hEp = false;
        this.gsT = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.hEp) {
                    TbCameraView.this.hEp = TbCameraView.this.hDM != null && TbCameraView.this.hDM.bFN();
                }
                if (TbCameraView.this.hEp) {
                    new Thread(TbCameraView.this.hEq).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.hEr).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.hEq = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.nB(TbCameraView.this.hkQ);
                }
            }
        };
        this.hEr = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.hEs = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.hEn = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.hEg = false;
                    if (TbCameraView.this.hEi != null) {
                        TbCameraView.this.hEi.bFP();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.hEi != null) {
                    TbCameraView.this.hEi.bFQ();
                }
            }
        };
        setSurfaceTextureListener(this.gsT);
        this.hEl = getResources().getDimensionPixelSize(d.e.ds5);
        this.hEm = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nB(boolean z) {
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
                if (this.hDN == null) {
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
                            this.hkQ = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.hkQ = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hDN == null) {
                        this.hDN.bFO();
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
            this.hEf = this.mCamera.getParameters();
            this.hEf.setPictureFormat(256);
            Camera.Size f = f(this.hEf.getSupportedPictureSizes(), 1440, 1080);
            this.hEf.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.hEf.getSupportedPreviewSizes(), 1440, 1080);
            this.hEf.setPreviewSize(f2.width, f2.height);
            if (this.hEo != null) {
                this.hEo.cW(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hEf.getSupportedFocusModes().contains("continuous-video")) {
                this.hEf.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hEf);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.hEg = true;
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
        this.hEg = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hEg) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hEf != null && this.hEf.isZoomSupported() && this.mTouchMode == 2) {
                        this.hEj = Q(motionEvent);
                        if (this.hEj > this.hEl) {
                            float f = this.hEj - this.hEk;
                            int maxZoom = this.hEf.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.hEm) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                xp(maxZoom);
                                this.hEk = this.hEj;
                                break;
                            } else if (f < (-this.hEm)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                xp(i2);
                                this.hEk = this.hEj;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.hEk = Q(motionEvent);
                    if (this.hEk > this.hEl) {
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

    public void xp(int i) {
        if (this.mCamera != null) {
            this.hEf = this.mCamera.getParameters();
            if (this.hEf != null) {
                this.hEf.setZoom(i);
                this.mCamera.setParameters(this.hEf);
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
        this.hEh = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.hEi = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.hEo = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hDM = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hDN = aVar;
    }
}
