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
/* loaded from: classes3.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener fQt;
    private int hdA;
    private boolean hdB;
    private Bitmap hdC;
    private b hdD;
    private boolean hdE;
    private final Runnable hdF;
    private final Runnable hdG;
    private Camera.PictureCallback hdH;
    private c hda;
    private a hdb;
    private Camera.Parameters hdt;
    private boolean hdu;
    private String hdv;
    private d hdw;
    private float hdx;
    private float hdy;
    private int hdz;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void bBR();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bS(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bBQ();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bBS();

        void bBT();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hdu = false;
        this.hdv = null;
        this.mTouchMode = 0;
        this.hdB = false;
        this.hdE = false;
        this.fQt = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.hdE) {
                    TbCameraView.this.hdE = TbCameraView.this.hda != null && TbCameraView.this.hda.bBQ();
                }
                if (TbCameraView.this.hdE) {
                    new Thread(TbCameraView.this.hdF).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.hdG).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.hdF = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.ns(TbCameraView.this.hdB);
                }
            }
        };
        this.hdG = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.hdH = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.hdC = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.hdu = false;
                    if (TbCameraView.this.hdw != null) {
                        TbCameraView.this.hdw.bBS();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.hdw != null) {
                    TbCameraView.this.hdw.bBT();
                }
            }
        };
        setSurfaceTextureListener(this.fQt);
        this.hdz = getResources().getDimensionPixelSize(d.e.ds5);
        this.hdA = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ns(boolean z) {
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
                if (this.hdb == null) {
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
                            this.hdB = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.hdB = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hdb == null) {
                        this.hdb.bBR();
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
            this.hdt = this.mCamera.getParameters();
            this.hdt.setPictureFormat(256);
            Camera.Size e = e(this.hdt.getSupportedPictureSizes(), 1440, 1080);
            this.hdt.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.hdt.getSupportedPreviewSizes(), 1440, 1080);
            this.hdt.setPreviewSize(e2.width, e2.height);
            if (this.hdD != null) {
                this.hdD.bS(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hdt.getSupportedFocusModes().contains("continuous-video")) {
                this.hdt.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hdt);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.hdu = true;
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
        this.hdu = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hdu) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hdt != null && this.hdt.isZoomSupported() && this.mTouchMode == 2) {
                        this.hdx = P(motionEvent);
                        if (this.hdx > this.hdz) {
                            float f = this.hdx - this.hdy;
                            int maxZoom = this.hdt.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.hdA) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                uS(maxZoom);
                                this.hdy = this.hdx;
                                break;
                            } else if (f < (-this.hdA)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                uS(i2);
                                this.hdy = this.hdx;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.hdy = P(motionEvent);
                    if (this.hdy > this.hdz) {
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

    public void uS(int i) {
        if (this.mCamera != null) {
            this.hdt = this.mCamera.getParameters();
            if (this.hdt != null) {
                this.hdt.setZoom(i);
                this.mCamera.setParameters(this.hdt);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.mRunnable);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (v.v(list) == 0) {
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
        this.hdv = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.hdw = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.hdD = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hda = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hdb = aVar;
    }
}
