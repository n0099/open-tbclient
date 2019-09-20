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
    private float fck;
    private TextureView.SurfaceTextureListener izn;
    private c jQW;
    private a jQX;
    private final Runnable jRA;
    private Camera.PictureCallback jRB;
    private Camera.Parameters jRo;
    private boolean jRp;
    private String jRq;
    private d jRr;
    private float jRs;
    private int jRt;
    private int jRu;
    private boolean jRv;
    private Bitmap jRw;
    private b jRx;
    private boolean jRy;
    private final Runnable jRz;
    private Camera mCamera;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;

    /* loaded from: classes3.dex */
    public interface a {
        void cBA();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cJ(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean aZR();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void cBB();

        void cBC();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jRp = false;
        this.jRq = null;
        this.mTouchMode = 0;
        this.jRv = false;
        this.jRy = false;
        this.izn = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.jRy) {
                    TbCameraView.this.jRy = TbCameraView.this.jQW != null && TbCameraView.this.jQW.aZR();
                }
                if (TbCameraView.this.jRy) {
                    new Thread(TbCameraView.this.jRz).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.jRA).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.jRz = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.sm(TbCameraView.this.jRv);
                }
            }
        };
        this.jRA = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.jRB = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.jRw = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.jRp = false;
                    if (TbCameraView.this.jRr != null) {
                        TbCameraView.this.jRr.cBB();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.jRr != null) {
                    TbCameraView.this.jRr.cBC();
                }
            }
        };
        setSurfaceTextureListener(this.izn);
        this.jRt = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.jRu = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sm(boolean z) {
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
                if (this.jQX == null) {
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
                            this.jRv = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.jRv = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.jQX == null) {
                        this.jQX.cBA();
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
            this.jRo = this.mCamera.getParameters();
            this.jRo.setPictureFormat(256);
            Camera.Size f = f(this.jRo.getSupportedPictureSizes(), 1440, 1080);
            this.jRo.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.jRo.getSupportedPreviewSizes(), 1440, 1080);
            this.jRo.setPreviewSize(f2.width, f2.height);
            if (this.jRx != null) {
                this.jRx.cJ(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.jRo.getSupportedFocusModes().contains("continuous-video")) {
                this.jRo.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.jRo);
            try {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                this.jRp = true;
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
        this.jRp = false;
        this.mCamera = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jRp) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.jRo != null && this.jRo.isZoomSupported() && this.mTouchMode == 2) {
                        this.fck = T(motionEvent);
                        if (this.fck > this.jRt) {
                            float f = this.fck - this.jRs;
                            int maxZoom = this.jRo.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.jRu) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                Db(maxZoom);
                                this.jRs = this.fck;
                                break;
                            } else if (f < (-this.jRu)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                Db(i2);
                                this.jRs = this.fck;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.jRs = T(motionEvent);
                    if (this.jRs > this.jRt) {
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

    public void Db(int i) {
        if (this.mCamera != null) {
            this.jRo = this.mCamera.getParameters();
            if (this.jRo != null) {
                this.jRo.setZoom(i);
                this.mCamera.setParameters(this.jRo);
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
        this.jRq = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.jRr = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.jRx = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.jQW = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.jQX = aVar;
    }
}
