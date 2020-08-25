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
    private TextureView.SurfaceTextureListener bOW;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private c mND;
    private a mNE;
    private Camera.Parameters mNT;
    private String mNU;
    private d mNV;
    private float mNW;
    private int mNX;
    private int mNY;
    private boolean mNZ;
    private Bitmap mOa;
    private b mOb;
    private boolean mOc;
    private final Runnable mOd;
    private final Runnable mOe;
    private Camera.PictureCallback mOf;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void dGf();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void dw(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean cbq();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void dGg();

        void dGh();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.mNU = null;
        this.mTouchMode = 0;
        this.mNZ = false;
        this.mOc = false;
        this.bOW = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.mOc) {
                    TbCameraView.this.mOc = TbCameraView.this.mND != null && TbCameraView.this.mND.cbq();
                }
                if (TbCameraView.this.mOc) {
                    new Thread(TbCameraView.this.mOd).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.mOe).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.mOd = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.xf(TbCameraView.this.mNZ);
                }
            }
        };
        this.mOe = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.mOf = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.mOa = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.mNV != null) {
                        TbCameraView.this.mNV.dGg();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.mNV != null) {
                    TbCameraView.this.mNV.dGh();
                }
            }
        };
        setSurfaceTextureListener(this.bOW);
        this.mNX = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.mNY = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void xf(boolean z) {
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
                if (this.mNE == null) {
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
                            this.mNZ = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.mNZ = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.mNE == null) {
                        this.mNE.dGf();
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
            this.mNT = this.mCamera.getParameters();
            this.mNT.setPictureFormat(256);
            Camera.Size h = h(this.mNT.getSupportedPictureSizes(), 1440, 1080);
            this.mNT.setPictureSize(h.width, h.height);
            Camera.Size h2 = h(this.mNT.getSupportedPreviewSizes(), 1440, 1080);
            this.mNT.setPreviewSize(h2.width, h2.height);
            if (this.mOb != null) {
                this.mOb.dw(h2.width, h2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.mNT.getSupportedFocusModes().contains("continuous-video")) {
                this.mNT.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.mNT);
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
                    if (this.mNT != null && this.mNT.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = ai(motionEvent);
                        if (this.mDistance > this.mNX) {
                            float f = this.mDistance - this.mNW;
                            int maxZoom = this.mNT.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.mNY) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                zoom(maxZoom);
                                this.mNW = this.mDistance;
                                break;
                            } else if (f < (-this.mNY)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                zoom(i2);
                                this.mNW = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.mNW = ai(motionEvent);
                    if (this.mNW > this.mNX) {
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
            this.mNT = this.mCamera.getParameters();
            if (this.mNT != null) {
                this.mNT.setZoom(i);
                this.mCamera.setParameters(this.mNT);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mRunnable);
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
        this.mNU = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.mNV = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.mOb = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.mND = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.mNE = aVar;
    }
}
