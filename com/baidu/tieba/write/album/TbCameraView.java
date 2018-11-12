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
    private TextureView.SurfaceTextureListener gwE;
    private boolean hLA;
    private String hLB;
    private d hLC;
    private float hLD;
    private float hLE;
    private int hLF;
    private int hLG;
    private boolean hLH;
    private Bitmap hLI;
    private b hLJ;
    private boolean hLK;
    private final Runnable hLL;
    private final Runnable hLM;
    private Camera.PictureCallback hLN;
    private c hLh;
    private a hLi;
    private Camera.Parameters hLz;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void bLO();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cd(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bLN();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bLP();

        void bLQ();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLA = false;
        this.hLB = null;
        this.mTouchMode = 0;
        this.hLH = false;
        this.hLK = false;
        this.gwE = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.hLK) {
                    TbCameraView.this.hLK = TbCameraView.this.hLh != null && TbCameraView.this.hLh.bLN();
                }
                if (TbCameraView.this.hLK) {
                    new Thread(TbCameraView.this.hLL).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.hLM).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.hLL = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.ox(TbCameraView.this.hLH);
                }
            }
        };
        this.hLM = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.hLN = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.hLI = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.hLA = false;
                    if (TbCameraView.this.hLC != null) {
                        TbCameraView.this.hLC.bLP();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.hLC != null) {
                    TbCameraView.this.hLC.bLQ();
                }
            }
        };
        setSurfaceTextureListener(this.gwE);
        this.hLF = getResources().getDimensionPixelSize(e.C0200e.ds5);
        this.hLG = getResources().getDimensionPixelSize(e.C0200e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ox(boolean z) {
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
                if (this.hLi == null) {
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
                            this.hLH = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.hLH = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hLi == null) {
                        this.hLi.bLO();
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
            this.hLz = this.mCamera.getParameters();
            this.hLz.setPictureFormat(256);
            Camera.Size f = f(this.hLz.getSupportedPictureSizes(), 1440, 1080);
            this.hLz.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.hLz.getSupportedPreviewSizes(), 1440, 1080);
            this.hLz.setPreviewSize(f2.width, f2.height);
            if (this.hLJ != null) {
                this.hLJ.cd(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.hLz.getSupportedFocusModes().contains("continuous-video")) {
                this.hLz.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.hLz);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.hLA = true;
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
        this.hLA = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hLA) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.hLz != null && this.hLz.isZoomSupported() && this.mTouchMode == 2) {
                        this.hLD = Q(motionEvent);
                        if (this.hLD > this.hLF) {
                            float f = this.hLD - this.hLE;
                            int maxZoom = this.hLz.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.hLG) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                wI(maxZoom);
                                this.hLE = this.hLD;
                                break;
                            } else if (f < (-this.hLG)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                wI(i2);
                                this.hLE = this.hLD;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.hLE = Q(motionEvent);
                    if (this.hLE > this.hLF) {
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

    public void wI(int i) {
        if (this.mCamera != null) {
            this.hLz = this.mCamera.getParameters();
            if (this.hLz != null) {
                this.hLz.setZoom(i);
                this.mCamera.setParameters(this.hLz);
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
        this.hLB = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.hLC = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.hLJ = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hLh = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hLi = aVar;
    }
}
