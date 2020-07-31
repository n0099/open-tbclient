package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener bJy;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;
    private Camera.Parameters mvE;
    private String mvF;
    private d mvG;
    private float mvH;
    private int mvI;
    private int mvJ;
    private boolean mvK;
    private Bitmap mvL;
    private b mvM;
    private boolean mvN;
    private final Runnable mvO;
    private final Runnable mvP;
    private Camera.PictureCallback mvQ;
    private c mvn;
    private a mvo;

    /* loaded from: classes3.dex */
    public interface a {
        void duI();
    }

    /* loaded from: classes3.dex */
    public interface b {
        /* renamed from: do  reason: not valid java name */
        void m37do(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bRe();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void duJ();

        void duK();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.mvF = null;
        this.mTouchMode = 0;
        this.mvK = false;
        this.mvN = false;
        this.bJy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.mvN) {
                    TbCameraView.this.mvN = TbCameraView.this.mvn != null && TbCameraView.this.mvn.bRe();
                }
                if (TbCameraView.this.mvN) {
                    new Thread(TbCameraView.this.mvO).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.mvP).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.mvO = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.wq(TbCameraView.this.mvK);
                }
            }
        };
        this.mvP = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.mvQ = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.mvL = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.mvG != null) {
                        TbCameraView.this.mvG.duJ();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.mvG != null) {
                    TbCameraView.this.mvG.duK();
                }
            }
        };
        setSurfaceTextureListener(this.bJy);
        this.mvI = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.mvJ = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wq(boolean z) {
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
                if (this.mvo == null) {
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
                            this.mvK = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.mvK = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.mvo == null) {
                        this.mvo.duI();
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
            this.mvE = this.mCamera.getParameters();
            this.mvE.setPictureFormat(256);
            Camera.Size h = h(this.mvE.getSupportedPictureSizes(), 1440, 1080);
            this.mvE.setPictureSize(h.width, h.height);
            Camera.Size h2 = h(this.mvE.getSupportedPreviewSizes(), 1440, 1080);
            this.mvE.setPreviewSize(h2.width, h2.height);
            if (this.mvM != null) {
                this.mvM.m37do(h2.width, h2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.mvE.getSupportedFocusModes().contains("continuous-video")) {
                this.mvE.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.mvE);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.mIsPreviewing = true;
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
                    if (this.mvE != null && this.mvE.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = P(motionEvent);
                        if (this.mDistance > this.mvI) {
                            float f = this.mDistance - this.mvH;
                            int maxZoom = this.mvE.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.mvJ) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                zoom(maxZoom);
                                this.mvH = this.mDistance;
                                break;
                            } else if (f < (-this.mvJ)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                zoom(i2);
                                this.mvH = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.mvH = P(motionEvent);
                    if (this.mvH > this.mvI) {
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

    public void zoom(int i) {
        if (this.mCamera != null) {
            this.mvE = this.mCamera.getParameters();
            if (this.mvE != null) {
                this.mvE.setZoom(i);
                this.mCamera.setParameters(this.mvE);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mRunnable);
    }

    public Camera.Size h(List<Camera.Size> list, int i, int i2) {
        if (x.getCount(list) == 0) {
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
        this.mvF = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.mvG = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.mvM = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.mvn = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.mvo = aVar;
    }
}
