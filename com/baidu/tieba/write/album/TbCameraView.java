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
/* loaded from: classes7.dex */
public class TbCameraView extends TextureView {
    private Camera mCamera;
    private float mDistance;
    private boolean mIsPreviewing;
    private Runnable mRunnable;
    private SurfaceTexture mSurfaceTexture;
    private int mTouchMode;
    private c ogW;
    private a ogX;
    private Camera.Parameters ohm;
    private String ohn;
    private d oho;
    private float ohp;
    private int ohq;
    private int ohr;
    private boolean ohs;
    private Bitmap oht;
    private b ohu;
    private boolean ohv;
    private TextureView.SurfaceTextureListener ohw;
    private final Runnable ohx;
    private final Runnable ohy;
    private Camera.PictureCallback ohz;

    /* loaded from: classes7.dex */
    public interface a {
        void dXm();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void dD(int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface c {
        boolean crZ();
    }

    /* loaded from: classes7.dex */
    public interface d {
        void dXn();

        void dXo();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPreviewing = false;
        this.ohn = null;
        this.mTouchMode = 0;
        this.ohs = false;
        this.ohv = false;
        this.ohw = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TbCameraView.this.mSurfaceTexture = surfaceTexture;
                if (!TbCameraView.this.ohv) {
                    TbCameraView.this.ohv = TbCameraView.this.ogW != null && TbCameraView.this.ogW.crZ();
                }
                if (TbCameraView.this.ohv) {
                    new Thread(TbCameraView.this.ohx).start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                new Thread(TbCameraView.this.ohy).start();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.ohx = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.zB(TbCameraView.this.ohs);
                }
            }
        };
        this.ohy = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TbCameraView.this) {
                    TbCameraView.this.stopCamera();
                }
            }
        };
        this.ohz = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.oht = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.mIsPreviewing = false;
                    if (TbCameraView.this.oho != null) {
                        TbCameraView.this.oho.dXn();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.5
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.oho != null) {
                    TbCameraView.this.oho.dXo();
                }
            }
        };
        setSurfaceTextureListener(this.ohw);
        this.ohq = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.ohr = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zB(boolean z) {
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
                if (this.ogX == null) {
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
                            this.ohs = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.ohs = false;
                        break;
                    }
                    th.printStackTrace();
                    stopCamera();
                    if (this.ogX == null) {
                        this.ogX.dXm();
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
            this.ohm = this.mCamera.getParameters();
            this.ohm.setPictureFormat(256);
            Camera.Size f = f(this.ohm.getSupportedPictureSizes(), 1440, 1080);
            this.ohm.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.ohm.getSupportedPreviewSizes(), 1440, 1080);
            this.ohm.setPreviewSize(f2.width, f2.height);
            if (this.ohu != null) {
                this.ohu.dD(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.ohm.getSupportedFocusModes().contains("continuous-video")) {
                this.ohm.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.ohm);
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
                    if (this.ohm != null && this.ohm.isZoomSupported() && this.mTouchMode == 2) {
                        this.mDistance = ak(motionEvent);
                        if (this.mDistance > this.ohq) {
                            float f = this.mDistance - this.ohp;
                            int maxZoom = this.ohm.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.ohr) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                zoom(maxZoom);
                                this.ohp = this.mDistance;
                                break;
                            } else if (f < (-this.ohr)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                zoom(i2);
                                this.ohp = this.mDistance;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.ohp = ak(motionEvent);
                    if (this.ohp > this.ohq) {
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
            this.ohm = this.mCamera.getParameters();
            if (this.ohm != null) {
                this.ohm.setZoom(i);
                this.mCamera.setParameters(this.ohm);
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
        this.ohn = str;
    }

    public void setOnGotPictureListener(d dVar) {
        this.oho = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.ohu = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.ogW = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.ogX = aVar;
    }
}
