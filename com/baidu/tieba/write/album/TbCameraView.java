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
    private float faE;
    private TextureView.SurfaceTextureListener ixl;
    private c jOB;
    private a jOC;
    private Camera.Parameters jOT;
    private boolean jOU;
    private String jOV;
    private d jOW;
    private float jOX;
    private int jOY;
    private int jOZ;
    private boolean jPa;
    private Bitmap jPb;
    private b jPc;
    private boolean jPd;
    private final Runnable jPe;
    private final Runnable jPf;
    private Camera.PictureCallback jPg;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void cAM();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cK(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean aZn();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void cAN();

        void cAO();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jOU = false;
        this.jOV = null;
        this.mTouchMode = 0;
        this.jPa = false;
        this.jPd = false;
        this.ixl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.jPd) {
                    TbCameraView.this.jPd = TbCameraView.this.jOB != null && TbCameraView.this.jOB.aZn();
                }
                if (TbCameraView.this.jPd) {
                    new Thread(TbCameraView.this.jPe).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.jPf).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.jPe = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.sj(TbCameraView.this.jPa);
                }
            }
        };
        this.jPf = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.jPg = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.jPb = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.jOU = false;
                    if (TbCameraView.this.jOW != null) {
                        TbCameraView.this.jOW.cAN();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.jOW != null) {
                    TbCameraView.this.jOW.cAO();
                }
            }
        };
        setSurfaceTextureListener(this.ixl);
        this.jOY = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.jOZ = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sj(boolean z) {
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
                if (this.jOC == null) {
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
                            this.jPa = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.jPa = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.jOC == null) {
                        this.jOC.cAM();
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
            this.jOT = this.mCamera.getParameters();
            this.jOT.setPictureFormat(256);
            Camera.Size f = f(this.jOT.getSupportedPictureSizes(), 1440, 1080);
            this.jOT.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.jOT.getSupportedPreviewSizes(), 1440, 1080);
            this.jOT.setPreviewSize(f2.width, f2.height);
            if (this.jPc != null) {
                this.jPc.cK(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.jOT.getSupportedFocusModes().contains("continuous-video")) {
                this.jOT.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.jOT);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.jOU = true;
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
        this.jOU = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jOU) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.jOT != null && this.jOT.isZoomSupported() && this.mTouchMode == 2) {
                        this.faE = U(motionEvent);
                        if (this.faE > this.jOY) {
                            float f = this.faE - this.jOX;
                            int maxZoom = this.jOT.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.jOZ) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                CX(maxZoom);
                                this.jOX = this.faE;
                                break;
                            } else if (f < (-this.jOZ)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                CX(i2);
                                this.jOX = this.faE;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.jOX = U(motionEvent);
                    if (this.jOX > this.jOY) {
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

    private float U(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void CX(int i) {
        if (this.mCamera != null) {
            this.jOT = this.mCamera.getParameters();
            if (this.jOT != null) {
                this.jOT.setZoom(i);
                this.mCamera.setParameters(this.jOT);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mRunnable);
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
        this.jOV = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.jOW = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.jPc = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.jOB = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.jOC = aVar;
    }
}
