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
    private float fee;
    private TextureView.SurfaceTextureListener iwY;
    private boolean jOA;
    private final Runnable jOB;
    private final Runnable jOC;
    private Camera.PictureCallback jOD;
    private c jOa;
    private a jOb;
    private Camera.Parameters jOq;
    private boolean jOr;
    private String jOs;
    private d jOt;
    private float jOu;
    private int jOv;
    private int jOw;
    private boolean jOx;
    private Bitmap jOy;
    private b jOz;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void cyk();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cA(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean aZS();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void cyl();

        void cym();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jOr = false;
        this.jOs = null;
        this.mTouchMode = 0;
        this.jOx = false;
        this.jOA = false;
        this.iwY = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.jOA) {
                    TbCameraView.this.jOA = TbCameraView.this.jOa != null && TbCameraView.this.jOa.aZS();
                }
                if (TbCameraView.this.jOA) {
                    new Thread(TbCameraView.this.jOB).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.jOC).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.jOB = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.rR(TbCameraView.this.jOx);
                }
            }
        };
        this.jOC = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.jOD = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.jOy = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.jOr = false;
                    if (TbCameraView.this.jOt != null) {
                        TbCameraView.this.jOt.cyl();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.jOt != null) {
                    TbCameraView.this.jOt.cym();
                }
            }
        };
        setSurfaceTextureListener(this.iwY);
        this.jOv = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.jOw = getResources().getDimensionPixelSize(R.dimen.ds20);
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
                if (this.jOb == null) {
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
                            this.jOx = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.jOx = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.jOb == null) {
                        this.jOb.cyk();
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
            this.jOq = this.mCamera.getParameters();
            this.jOq.setPictureFormat(256);
            Camera.Size e = e(this.jOq.getSupportedPictureSizes(), 1440, 1080);
            this.jOq.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.jOq.getSupportedPreviewSizes(), 1440, 1080);
            this.jOq.setPreviewSize(e2.width, e2.height);
            if (this.jOz != null) {
                this.jOz.cA(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.jOq.getSupportedFocusModes().contains("continuous-video")) {
                this.jOq.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.jOq);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.jOr = true;
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
        this.jOr = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jOr) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.jOq != null && this.jOq.isZoomSupported() && this.mTouchMode == 2) {
                        this.fee = L(motionEvent);
                        if (this.fee > this.jOv) {
                            float f = this.fee - this.jOu;
                            int maxZoom = this.jOq.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.jOw) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                By(maxZoom);
                                this.jOu = this.fee;
                                break;
                            } else if (f < (-this.jOw)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                By(i2);
                                this.jOu = this.fee;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.jOu = L(motionEvent);
                    if (this.jOu > this.jOv) {
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

    public void By(int i) {
        if (this.mCamera != null) {
            this.jOq = this.mCamera.getParameters();
            if (this.jOq != null) {
                this.jOq.setZoom(i);
                this.mCamera.setParameters(this.jOq);
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
        this.jOs = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.jOt = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.jOz = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.jOa = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.jOb = aVar;
    }
}
