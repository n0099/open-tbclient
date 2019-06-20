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
/* loaded from: classes3.dex */
public class TbCameraView extends TextureView {
    private float eVp;
    private TextureView.SurfaceTextureListener ipS;
    private Camera.Parameters jGJ;
    private boolean jGK;
    private String jGL;
    private d jGM;
    private float jGN;
    private int jGO;
    private int jGP;
    private boolean jGQ;
    private Bitmap jGR;
    private b jGS;
    private boolean jGT;
    private final Runnable jGU;
    private final Runnable jGV;
    private Camera.PictureCallback jGW;
    private c jGr;
    private a jGs;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void cxq();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cF(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean aXo();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void cxr();

        void cxs();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jGK = false;
        this.jGL = null;
        this.mTouchMode = 0;
        this.jGQ = false;
        this.jGT = false;
        this.ipS = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.jGT) {
                    TbCameraView.this.jGT = TbCameraView.this.jGr != null && TbCameraView.this.jGr.aXo();
                }
                if (TbCameraView.this.jGT) {
                    new Thread(TbCameraView.this.jGU).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.jGV).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.jGU = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.rT(TbCameraView.this.jGQ);
                }
            }
        };
        this.jGV = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.jGW = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.jGR = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.jGK = false;
                    if (TbCameraView.this.jGM != null) {
                        TbCameraView.this.jGM.cxr();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.jGM != null) {
                    TbCameraView.this.jGM.cxs();
                }
            }
        };
        setSurfaceTextureListener(this.ipS);
        this.jGO = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.jGP = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void rT(boolean z) {
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
                if (this.jGs == null) {
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
                            this.jGQ = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.jGQ = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.jGs == null) {
                        this.jGs.cxq();
                        return;
                    }
                    return;
                }
                i++;
            }
            c(this.mSurfaceTexture);
        }
    }

    private void c(SurfaceTexture surfaceTexture) {
        if (this.mCamera != null) {
            this.jGJ = this.mCamera.getParameters();
            this.jGJ.setPictureFormat(256);
            Camera.Size f = f(this.jGJ.getSupportedPictureSizes(), 1440, 1080);
            this.jGJ.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.jGJ.getSupportedPreviewSizes(), 1440, 1080);
            this.jGJ.setPreviewSize(f2.width, f2.height);
            if (this.jGS != null) {
                this.jGS.cF(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.jGJ.getSupportedFocusModes().contains("continuous-video")) {
                this.jGJ.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.jGJ);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.jGK = true;
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
        this.jGK = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jGK) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.jGJ != null && this.jGJ.isZoomSupported() && this.mTouchMode == 2) {
                        this.eVp = T(motionEvent);
                        if (this.eVp > this.jGO) {
                            float f = this.eVp - this.jGN;
                            int maxZoom = this.jGJ.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.jGP) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                Co(maxZoom);
                                this.jGN = this.eVp;
                                break;
                            } else if (f < (-this.jGP)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                Co(i2);
                                this.jGN = this.eVp;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.jGN = T(motionEvent);
                    if (this.jGN > this.jGO) {
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

    private float T(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void Co(int i) {
        if (this.mCamera != null) {
            this.jGJ = this.mCamera.getParameters();
            if (this.jGJ != null) {
                this.jGJ.setZoom(i);
                this.mCamera.setParameters(this.jGJ);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mRunnable);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
        if (v.Z(list) == 0) {
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
        this.jGL = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.jGM = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.jGS = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.jGr = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.jGs = aVar;
    }
}
