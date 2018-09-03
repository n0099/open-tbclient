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
import com.baidu.tieba.f;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class TbCameraView extends TextureView {
    private TextureView.SurfaceTextureListener ggf;
    private Camera.Parameters huG;
    private boolean huH;
    private String huI;
    private d huJ;
    private float huK;
    private float huL;
    private int huM;
    private int huN;
    private boolean huO;
    private Bitmap huP;
    private b huQ;
    private boolean huR;
    private final Runnable huS;
    private final Runnable huT;
    private Camera.PictureCallback huU;
    private c huo;
    private a hup;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void bGn();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bU(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean bGm();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bGo();

        void bGp();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huH = false;
        this.huI = null;
        this.mTouchMode = 0;
        this.huO = false;
        this.huR = false;
        this.ggf = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.huR) {
                    TbCameraView.this.huR = TbCameraView.this.huo != null && TbCameraView.this.huo.bGm();
                }
                if (TbCameraView.this.huR) {
                    new Thread(TbCameraView.this.huS).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.huT).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.huS = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.nw(TbCameraView.this.huO);
                }
            }
        };
        this.huT = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.huU = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.huP = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.huH = false;
                    if (TbCameraView.this.huJ != null) {
                        TbCameraView.this.huJ.bGo();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.huJ != null) {
                    TbCameraView.this.huJ.bGp();
                }
            }
        };
        setSurfaceTextureListener(this.ggf);
        this.huM = getResources().getDimensionPixelSize(f.e.ds5);
        this.huN = getResources().getDimensionPixelSize(f.e.ds20);
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
                if (this.hup == null) {
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
                            this.huO = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.huO = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.hup == null) {
                        this.hup.bGn();
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
            this.huG = this.mCamera.getParameters();
            this.huG.setPictureFormat(256);
            Camera.Size e = e(this.huG.getSupportedPictureSizes(), 1440, 1080);
            this.huG.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.huG.getSupportedPreviewSizes(), 1440, 1080);
            this.huG.setPreviewSize(e2.width, e2.height);
            if (this.huQ != null) {
                this.huQ.bU(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.huG.getSupportedFocusModes().contains("continuous-video")) {
                this.huG.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.huG);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.huH = true;
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
        this.huH = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.huH) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.huG != null && this.huG.isZoomSupported() && this.mTouchMode == 2) {
                        this.huK = Q(motionEvent);
                        if (this.huK > this.huM) {
                            float f = this.huK - this.huL;
                            int maxZoom = this.huG.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.huN) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                vs(maxZoom);
                                this.huL = this.huK;
                                break;
                            } else if (f < (-this.huN)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                vs(i2);
                                this.huL = this.huK;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.huL = Q(motionEvent);
                    if (this.huL > this.huM) {
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
            this.huG = this.mCamera.getParameters();
            if (this.huG != null) {
                this.huG.setZoom(i);
                this.mCamera.setParameters(this.huG);
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
        this.huI = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.huJ = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.huQ = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.huo = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.hup = aVar;
    }
}
