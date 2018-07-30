package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener ggg;
    private Camera.Parameters huE;
    private boolean huF;
    private String huG;
    private d huH;
    private float huI;
    private float huJ;
    private int huK;
    private int huL;
    private boolean huM;
    private Bitmap huN;
    private b huO;
    private boolean huP;
    private final Runnable huQ;
    private final Runnable huR;
    private Camera.PictureCallback huS;
    private c hum;
    private a hun;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void bGj();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bU(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bGi();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bGk();

        void bGl();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huF = false;
        this.huG = null;
        this.mTouchMode = 0;
        this.huM = false;
        this.huP = false;
        this.ggg = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.huP) {
                    TbCameraView.this.huP = TbCameraView.this.hum != null && TbCameraView.this.hum.bGi();
                }
                if (TbCameraView.this.huP) {
                    new Thread(TbCameraView.this.huQ).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.huR).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.huQ = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.nw(TbCameraView.this.huM);
                }
            }
        };
        this.huR = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.huS = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.huN = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.huF = false;
                    if (TbCameraView.this.huH != null) {
                        TbCameraView.this.huH.bGk();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.huH != null) {
                    TbCameraView.this.huH.bGl();
                }
            }
        };
        setSurfaceTextureListener(this.ggg);
        this.huK = getResources().getDimensionPixelSize(d.e.ds5);
        this.huL = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nw(boolean z) {
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
                if (this.hun == null) {
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
                            this.huM = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.huM = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hun == null) {
                        this.hun.bGj();
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
            this.huE = this.mCamera.getParameters();
            this.huE.setPictureFormat(256);
            Camera.Size e = e(this.huE.getSupportedPictureSizes(), 1440, 1080);
            this.huE.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.huE.getSupportedPreviewSizes(), 1440, 1080);
            this.huE.setPreviewSize(e2.width, e2.height);
            if (this.huO != null) {
                this.huO.bU(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.huE.getSupportedFocusModes().contains("continuous-video")) {
                this.huE.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.huE);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.huF = true;
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
        this.huF = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.huF) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.huE != null && this.huE.isZoomSupported() && this.mTouchMode == 2) {
                        this.huI = Q(motionEvent);
                        if (this.huI > this.huK) {
                            float f = this.huI - this.huJ;
                            int maxZoom = this.huE.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.huL) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                vs(maxZoom);
                                this.huJ = this.huI;
                                break;
                            } else if (f < (-this.huL)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                vs(i2);
                                this.huJ = this.huI;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.huJ = Q(motionEvent);
                    if (this.huJ > this.huK) {
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

    public void vs(int i) {
        if (this.mCamera != null) {
            this.huE = this.mCamera.getParameters();
            if (this.huE != null) {
                this.huE.setZoom(i);
                this.mCamera.setParameters(this.huE);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.mRunnable);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (w.y(list) == 0) {
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
        this.huG = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.huH = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.huO = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.hum = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hun = aVar;
    }
}
