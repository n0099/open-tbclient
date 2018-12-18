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
    private TextureView.SurfaceTextureListener gDu;
    private Camera.Parameters hSK;
    private boolean hSL;
    private String hSM;
    private d hSN;
    private float hSO;
    private float hSP;
    private int hSQ;
    private int hSR;
    private boolean hSS;
    private Bitmap hST;
    private b hSU;
    private boolean hSV;
    private final Runnable hSW;
    private final Runnable hSX;
    private Camera.PictureCallback hSY;
    private c hSs;
    private a hSt;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void bNT();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cb(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bNS();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bNU();

        void bNV();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSL = false;
        this.hSM = null;
        this.mTouchMode = 0;
        this.hSS = false;
        this.hSV = false;
        this.gDu = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.hSV) {
                    TbCameraView.this.hSV = TbCameraView.this.hSs != null && TbCameraView.this.hSs.bNS();
                }
                if (TbCameraView.this.hSV) {
                    new Thread(TbCameraView.this.hSW).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.hSX).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.hSW = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.oz(TbCameraView.this.hSS);
                }
            }
        };
        this.hSX = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.hSY = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.hST = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.hSL = false;
                    if (TbCameraView.this.hSN != null) {
                        TbCameraView.this.hSN.bNU();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.hSN != null) {
                    TbCameraView.this.hSN.bNV();
                }
            }
        };
        setSurfaceTextureListener(this.gDu);
        this.hSQ = getResources().getDimensionPixelSize(e.C0210e.ds5);
        this.hSR = getResources().getDimensionPixelSize(e.C0210e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void oz(boolean z) {
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
                if (this.hSt == null) {
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
                            this.hSS = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.hSS = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hSt == null) {
                        this.hSt.bNT();
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
            this.hSK = this.mCamera.getParameters();
            this.hSK.setPictureFormat(256);
            Camera.Size f = f(this.hSK.getSupportedPictureSizes(), 1440, 1080);
            this.hSK.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.hSK.getSupportedPreviewSizes(), 1440, 1080);
            this.hSK.setPreviewSize(f2.width, f2.height);
            if (this.hSU != null) {
                this.hSU.cb(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hSK.getSupportedFocusModes().contains("continuous-video")) {
                this.hSK.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hSK);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.hSL = true;
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
        this.hSL = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hSL) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hSK != null && this.hSK.isZoomSupported() && this.mTouchMode == 2) {
                        this.hSO = Q(motionEvent);
                        if (this.hSO > this.hSQ) {
                            float f = this.hSO - this.hSP;
                            int maxZoom = this.hSK.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.hSR) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                xf(maxZoom);
                                this.hSP = this.hSO;
                                break;
                            } else if (f < (-this.hSR)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                xf(i2);
                                this.hSP = this.hSO;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.hSP = Q(motionEvent);
                    if (this.hSP > this.hSQ) {
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

    public void xf(int i) {
        if (this.mCamera != null) {
            this.hSK = this.mCamera.getParameters();
            if (this.hSK != null) {
                this.hSK.setZoom(i);
                this.mCamera.setParameters(this.hSK);
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
        this.hSM = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.hSN = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.hSU = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hSs = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hSt = aVar;
    }
}
