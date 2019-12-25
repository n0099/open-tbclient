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
/* loaded from: classes10.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener aSx;
    private float fSI;
    private c kIO;
    private a kIP;
    private Camera.Parameters kJe;
    private String kJf;
    private d kJg;
    private float kJh;
    private int kJi;
    private int kJj;
    private boolean kJk;
    private Bitmap kJl;
    private b kJm;
    private boolean kJn;
    private final Runnable kJo;
    private final Runnable kJp;
    private Camera.PictureCallback kJq;
    private Camera mCamera;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes10.dex */
    public interface a {
        void cSm();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void cS(int i, int i2);
    }

    /* loaded from: classes10.dex */
    public interface c {
        boolean brV();
    }

    /* loaded from: classes10.dex */
    public interface d {
        void cSn();

        void cSo();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.kJf = null;
        this.mTouchMode = 0;
        this.kJk = false;
        this.kJn = false;
        this.aSx = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.kJn) {
                    TbCameraView.this.kJn = TbCameraView.this.kIO != null && TbCameraView.this.kIO.brV();
                }
                if (TbCameraView.this.kJn) {
                    new Thread(TbCameraView.this.kJo).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.kJp).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.kJo = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.tx(TbCameraView.this.kJk);
                }
            }
        };
        this.kJp = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.kJq = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.kJl = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.kJg != null) {
                        TbCameraView.this.kJg.cSn();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.kJg != null) {
                    TbCameraView.this.kJg.cSo();
                }
            }
        };
        setSurfaceTextureListener(this.aSx);
        this.kJi = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.kJj = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void tx(boolean z) {
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
                if (this.kIP == null) {
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
                            this.kJk = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.kJk = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.kIP == null) {
                        this.kIP.cSm();
                        return;
                    }
                    return;
                }
                i++;
            }
            f(this.mSurfaceTexture);
        }
    }

    private void f(SurfaceTexture surfaceTexture) {
        if (this.mCamera != null) {
            this.kJe = this.mCamera.getParameters();
            this.kJe.setPictureFormat(256);
            Camera.Size e = e(this.kJe.getSupportedPictureSizes(), 1440, 1080);
            this.kJe.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.kJe.getSupportedPreviewSizes(), 1440, 1080);
            this.kJe.setPreviewSize(e2.width, e2.height);
            if (this.kJm != null) {
                this.kJm.cS(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.kJe.getSupportedFocusModes().contains("continuous-video")) {
                this.kJe.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.kJe);
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
                    if (this.kJe != null && this.kJe.isZoomSupported() && this.mTouchMode == 2) {
                        this.fSI = L(motionEvent);
                        if (this.fSI > this.kJi) {
                            float f = this.fSI - this.kJh;
                            int maxZoom = this.kJe.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.kJj) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                DV(maxZoom);
                                this.kJh = this.fSI;
                                break;
                            } else if (f < (-this.kJj)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                DV(i2);
                                this.kJh = this.fSI;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.kJh = L(motionEvent);
                    if (this.kJh > this.kJi) {
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

    private float L(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void DV(int i) {
        if (this.mCamera != null) {
            this.kJe = this.mCamera.getParameters();
            if (this.kJe != null) {
                this.kJe.setZoom(i);
                this.mCamera.setParameters(this.kJe);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.mRunnable);
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
        this.kJf = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.kJg = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.kJm = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.kIO = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.kIP = aVar;
    }
}
