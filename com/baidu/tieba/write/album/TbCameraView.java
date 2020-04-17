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
/* loaded from: classes2.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener bwD;
    private Camera.Parameters lyG;
    private String lyH;
    private d lyI;
    private float lyJ;
    private int lyK;
    private int lyL;
    private boolean lyM;
    private Bitmap lyN;
    private b lyO;
    private boolean lyP;
    private final Runnable lyQ;
    private final Runnable lyR;
    private Camera.PictureCallback lyS;
    private c lyq;
    private a lyr;
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void dfz();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void da(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean bEv();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void dfA();

        void dfB();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.lyH = null;
        this.mTouchMode = 0;
        this.lyM = false;
        this.lyP = false;
        this.bwD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.lyP) {
                    TbCameraView.this.lyP = TbCameraView.this.lyq != null && TbCameraView.this.lyq.bEv();
                }
                if (TbCameraView.this.lyP) {
                    new Thread(TbCameraView.this.lyQ).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.lyR).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.lyQ = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.uU(TbCameraView.this.lyM);
                }
            }
        };
        this.lyR = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.lyS = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.lyN = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.lyI != null) {
                        TbCameraView.this.lyI.dfA();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.lyI != null) {
                    TbCameraView.this.lyI.dfB();
                }
            }
        };
        setSurfaceTextureListener(this.bwD);
        this.lyK = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.lyL = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uU(boolean z) {
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
                if (this.lyr == null) {
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
                            this.lyM = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.lyM = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.lyr == null) {
                        this.lyr.dfz();
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
            this.lyG = this.mCamera.getParameters();
            this.lyG.setPictureFormat(256);
            Camera.Size f = f(this.lyG.getSupportedPictureSizes(), 1440, 1080);
            this.lyG.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.lyG.getSupportedPreviewSizes(), 1440, 1080);
            this.lyG.setPreviewSize(f2.width, f2.height);
            if (this.lyO != null) {
                this.lyO.da(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.lyG.getSupportedFocusModes().contains("continuous-video")) {
                this.lyG.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.lyG);
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
                    if (this.lyG != null && this.lyG.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = K(motionEvent);
                        if (this.mDistance > this.lyK) {
                            float f = this.mDistance - this.lyJ;
                            int maxZoom = this.lyG.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.lyL) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                EO(maxZoom);
                                this.lyJ = this.mDistance;
                                break;
                            } else if (f < (-this.lyL)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                EO(i2);
                                this.lyJ = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.lyJ = K(motionEvent);
                    if (this.lyJ > this.lyK) {
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

    private float K(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void EO(int i) {
        if (this.mCamera != null) {
            this.lyG = this.mCamera.getParameters();
            if (this.lyG != null) {
                this.lyG.setZoom(i);
                this.mCamera.setParameters(this.lyG);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.mRunnable);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
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
        this.lyH = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.lyI = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.lyO = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.lyq = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.lyr = aVar;
    }
}
