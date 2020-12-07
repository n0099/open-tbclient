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
    private TextureView.SurfaceTextureListener cub;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;
    private Camera.Parameters nVI;
    private String nVJ;
    private d nVK;
    private float nVL;
    private int nVM;
    private int nVN;
    private boolean nVO;
    private Bitmap nVP;
    private b nVQ;
    private boolean nVR;
    private final Runnable nVS;
    private final Runnable nVT;
    private Camera.PictureCallback nVU;
    private c nVs;
    private a nVt;

    /* loaded from: classes3.dex */
    public interface a {
        void dYV();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void dK(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean crz();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void dYW();

        void dYX();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.nVJ = null;
        this.mTouchMode = 0;
        this.nVO = false;
        this.nVR = false;
        this.cub = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.nVR) {
                    TbCameraView.this.nVR = TbCameraView.this.nVs != null && TbCameraView.this.nVs.crz();
                }
                if (TbCameraView.this.nVR) {
                    new Thread(TbCameraView.this.nVS).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.nVT).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.nVS = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.zj(TbCameraView.this.nVO);
                }
            }
        };
        this.nVT = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.nVU = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.nVP = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.nVK != null) {
                        TbCameraView.this.nVK.dYW();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.nVK != null) {
                    TbCameraView.this.nVK.dYX();
                }
            }
        };
        setSurfaceTextureListener(this.cub);
        this.nVM = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.nVN = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zj(boolean z) {
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
                if (this.nVt == null) {
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
                            this.nVO = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.nVO = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.nVt == null) {
                        this.nVt.dYV();
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
            this.nVI = this.mCamera.getParameters();
            this.nVI.setPictureFormat(256);
            Camera.Size f = f(this.nVI.getSupportedPictureSizes(), 1440, 1080);
            this.nVI.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.nVI.getSupportedPreviewSizes(), 1440, 1080);
            this.nVI.setPreviewSize(f2.width, f2.height);
            if (this.nVQ != null) {
                this.nVQ.dK(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.nVI.getSupportedFocusModes().contains("continuous-video")) {
                this.nVI.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.nVI);
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
                    if (this.nVI != null && this.nVI.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = ak(motionEvent);
                        if (this.mDistance > this.nVM) {
                            float f = this.mDistance - this.nVL;
                            int maxZoom = this.nVI.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.nVN) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                zoom(maxZoom);
                                this.nVL = this.mDistance;
                                break;
                            } else if (f < (-this.nVN)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                zoom(i2);
                                this.nVL = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.nVL = ak(motionEvent);
                    if (this.nVL > this.nVM) {
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

    private float ak(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void zoom(int i) {
        if (this.mCamera != null) {
            this.nVI = this.mCamera.getParameters();
            if (this.nVI != null) {
                this.nVI.setZoom(i);
                this.mCamera.setParameters(this.nVI);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mRunnable);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
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
        this.nVJ = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.nVK = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.nVQ = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.nVs = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.nVt = aVar;
    }
}
