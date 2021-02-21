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
/* loaded from: classes8.dex */
public class TbCameraView extends TextureView {
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;
    private c oeQ;
    private a oeR;
    private Camera.Parameters ofh;
    private String ofi;
    private d ofj;
    private float ofk;
    private int ofl;
    private int ofm;
    private boolean ofn;
    private Bitmap ofo;
    private b ofp;
    private boolean ofq;
    private TextureView.SurfaceTextureListener ofr;
    private final Runnable ofs;
    private final Runnable oft;
    private Camera.PictureCallback ofu;

    /* loaded from: classes8.dex */
    public interface a {
        void dXe();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void dD(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface c {
        boolean crT();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void dXf();

        void dXg();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.ofi = null;
        this.mTouchMode = 0;
        this.ofn = false;
        this.ofq = false;
        this.ofr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.ofq) {
                    TbCameraView.this.ofq = TbCameraView.this.oeQ != null && TbCameraView.this.oeQ.crT();
                }
                if (TbCameraView.this.ofq) {
                    new Thread(TbCameraView.this.ofs).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.oft).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.ofs = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.zC(TbCameraView.this.ofn);
                }
            }
        };
        this.oft = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.ofu = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.ofo = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.ofj != null) {
                        TbCameraView.this.ofj.dXf();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.ofj != null) {
                    TbCameraView.this.ofj.dXg();
                }
            }
        };
        setSurfaceTextureListener(this.ofr);
        this.ofl = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.ofm = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zC(boolean z) {
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
                if (this.oeR == null) {
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
                            this.ofn = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.ofn = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.oeR == null) {
                        this.oeR.dXe();
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
            this.ofh = this.mCamera.getParameters();
            this.ofh.setPictureFormat(256);
            Camera.Size f = f(this.ofh.getSupportedPictureSizes(), 1440, 1080);
            this.ofh.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.ofh.getSupportedPreviewSizes(), 1440, 1080);
            this.ofh.setPreviewSize(f2.width, f2.height);
            if (this.ofp != null) {
                this.ofp.dD(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.ofh.getSupportedFocusModes().contains("continuous-video")) {
                this.ofh.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.ofh);
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
                    if (this.ofh != null && this.ofh.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = ak(motionEvent);
                        if (this.mDistance > this.ofl) {
                            float f = this.mDistance - this.ofk;
                            int maxZoom = this.ofh.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.ofm) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                zoom(maxZoom);
                                this.ofk = this.mDistance;
                                break;
                            } else if (f < (-this.ofm)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                zoom(i2);
                                this.ofk = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.ofk = ak(motionEvent);
                    if (this.ofk > this.ofl) {
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
            this.ofh = this.mCamera.getParameters();
            if (this.ofh != null) {
                this.ofh.setZoom(i);
                this.mCamera.setParameters(this.ofh);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mRunnable);
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
        this.ofi = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.ofj = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.ofp = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.oeQ = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.oeR = aVar;
    }
}
