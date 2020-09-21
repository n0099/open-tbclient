package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener bRa;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;
    private c mXS;
    private a mXT;
    private Camera.Parameters mYi;
    private String mYj;
    private d mYk;
    private float mYl;
    private int mYm;
    private int mYn;
    private boolean mYo;
    private Bitmap mYp;
    private b mYq;
    private boolean mYr;
    private final Runnable mYs;
    private final Runnable mYt;
    private Camera.PictureCallback mYu;

    /* loaded from: classes3.dex */
    public interface a {
        void dKi();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void dA(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean ceG();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void dKj();

        void dKk();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.mYj = null;
        this.mTouchMode = 0;
        this.mYo = false;
        this.mYr = false;
        this.bRa = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.mYr) {
                    TbCameraView.this.mYr = TbCameraView.this.mXS != null && TbCameraView.this.mXS.ceG();
                }
                if (TbCameraView.this.mYr) {
                    new Thread(TbCameraView.this.mYs).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.mYt).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.mYs = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.xq(TbCameraView.this.mYo);
                }
            }
        };
        this.mYt = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.mYu = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.mYp = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.mYk != null) {
                        TbCameraView.this.mYk.dKj();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.mYk != null) {
                    TbCameraView.this.mYk.dKk();
                }
            }
        };
        setSurfaceTextureListener(this.bRa);
        this.mYm = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.mYn = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void xq(boolean z) {
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
                if (this.mXT == null) {
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
                            this.mYo = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.mYo = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.mXT == null) {
                        this.mXT.dKi();
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
            this.mYi = this.mCamera.getParameters();
            this.mYi.setPictureFormat(256);
            Camera.Size h = h(this.mYi.getSupportedPictureSizes(), 1440, 1080);
            this.mYi.setPictureSize(h.width, h.height);
            Camera.Size h2 = h(this.mYi.getSupportedPreviewSizes(), 1440, 1080);
            this.mYi.setPreviewSize(h2.width, h2.height);
            if (this.mYq != null) {
                this.mYq.dA(h2.width, h2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.mYi.getSupportedFocusModes().contains("continuous-video")) {
                this.mYi.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.mYi);
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
                    if (this.mYi != null && this.mYi.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = ai(motionEvent);
                        if (this.mDistance > this.mYm) {
                            float f = this.mDistance - this.mYl;
                            int maxZoom = this.mYi.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.mYn) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                zoom(maxZoom);
                                this.mYl = this.mDistance;
                                break;
                            } else if (f < (-this.mYn)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                zoom(i2);
                                this.mYl = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.mYl = ai(motionEvent);
                    if (this.mYl > this.mYm) {
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

    private float ai(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void zoom(int i) {
        if (this.mCamera != null) {
            this.mYi = this.mCamera.getParameters();
            if (this.mYi != null) {
                this.mYi.setZoom(i);
                this.mCamera.setParameters(this.mYi);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.mRunnable);
    }

    public Camera.Size h(List<Camera.Size> list, int i, int i2) {
        if (y.getCount(list) == 0) {
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
        this.mYj = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.mYk = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.mYq = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.mXS = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.mXT = aVar;
    }
}
