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
    private float feV;
    private TextureView.SurfaceTextureListener ixP;
    private c jOR;
    private a jOS;
    private Camera.Parameters jPh;
    private boolean jPi;
    private String jPj;
    private d jPk;
    private float jPl;
    private int jPm;
    private int jPn;
    private boolean jPo;
    private Bitmap jPp;
    private b jPq;
    private boolean jPr;
    private final Runnable jPs;
    private final Runnable jPt;
    private Camera.PictureCallback jPu;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void cym();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cC(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean aZU();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void cyn();

        void cyo();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jPi = false;
        this.jPj = null;
        this.mTouchMode = 0;
        this.jPo = false;
        this.jPr = false;
        this.ixP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.jPr) {
                    TbCameraView.this.jPr = TbCameraView.this.jOR != null && TbCameraView.this.jOR.aZU();
                }
                if (TbCameraView.this.jPr) {
                    new Thread(TbCameraView.this.jPs).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.jPt).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.jPs = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.rR(TbCameraView.this.jPo);
                }
            }
        };
        this.jPt = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.jPu = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.jPp = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.jPi = false;
                    if (TbCameraView.this.jPk != null) {
                        TbCameraView.this.jPk.cyn();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.jPk != null) {
                    TbCameraView.this.jPk.cyo();
                }
            }
        };
        setSurfaceTextureListener(this.ixP);
        this.jPm = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.jPn = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void rR(boolean z) {
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
                if (this.jOS == null) {
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
                            this.jPo = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.jPo = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.jOS == null) {
                        this.jOS.cym();
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
            this.jPh = this.mCamera.getParameters();
            this.jPh.setPictureFormat(256);
            Camera.Size e = e(this.jPh.getSupportedPictureSizes(), 1440, 1080);
            this.jPh.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.jPh.getSupportedPreviewSizes(), 1440, 1080);
            this.jPh.setPreviewSize(e2.width, e2.height);
            if (this.jPq != null) {
                this.jPq.cC(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.jPh.getSupportedFocusModes().contains("continuous-video")) {
                this.jPh.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.jPh);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.jPi = true;
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
        this.jPi = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jPi) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.jPh != null && this.jPh.isZoomSupported() && this.mTouchMode == 2) {
                        this.feV = L(motionEvent);
                        if (this.feV > this.jPm) {
                            float f = this.feV - this.jPl;
                            int maxZoom = this.jPh.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.jPn) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                Bz(maxZoom);
                                this.jPl = this.feV;
                                break;
                            } else if (f < (-this.jPn)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                Bz(i2);
                                this.jPl = this.feV;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.jPl = L(motionEvent);
                    if (this.jPl > this.jPm) {
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

    private float L(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void Bz(int i) {
        if (this.mCamera != null) {
            this.jPh = this.mCamera.getParameters();
            if (this.jPh != null) {
                this.jPh.setZoom(i);
                this.mCamera.setParameters(this.jPh);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.mRunnable);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
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
        this.jPj = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.jPk = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.jPq = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.jOR = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.jOS = aVar;
    }
}
