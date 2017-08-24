package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public class TbCameraView extends SurfaceView {
    private c gDh;
    private a gDi;
    private b gDj;
    private d gDl;
    private Camera.Parameters gDs;
    private String gDt;
    private float gDu;
    private int gDv;
    private SurfaceHolder.Callback gDw;
    private float geF;
    private boolean gfO;
    private boolean gfR;
    private Bitmap gfS;
    private int gfs;
    private Camera.PictureCallback ggd;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes.dex */
    public interface a {
        void bqD();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bL(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean bqC();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bqF();

        void bqG();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfO = false;
        this.gDt = null;
        this.mTouchMode = 0;
        this.gfR = false;
        this.gDw = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gDh != null && TbCameraView.this.gDh.bqC()) {
                    TbCameraView.this.mr(TbCameraView.this.gfR);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                TbCameraView.this.stopCamera();
            }
        };
        this.ggd = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.gfS = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.gfO = false;
                    if (TbCameraView.this.gDl != null) {
                        TbCameraView.this.gDl.bqF();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gDl != null) {
                    TbCameraView.this.gDl.bqG();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gDw);
        this.gDv = getResources().getDimensionPixelSize(d.f.ds5);
        this.gfs = getResources().getDimensionPixelSize(d.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mr(boolean z) {
        Camera.CameraInfo cameraInfo;
        int numberOfCameras;
        int i = 0;
        if (this.mSurfaceHolder != null) {
            try {
                cameraInfo = new Camera.CameraInfo();
                numberOfCameras = Camera.getNumberOfCameras();
            } catch (Throwable th) {
                th.printStackTrace();
                this.mCamera = null;
                if (this.gDi == null) {
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
                            this.gfR = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.gfR = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gDi == null) {
                        this.gDi.bqD();
                        return;
                    }
                    return;
                }
                i++;
            }
            startPreview(this.mSurfaceHolder);
        }
    }

    private void startPreview(SurfaceHolder surfaceHolder) {
        if (this.mCamera != null) {
            this.gDs = this.mCamera.getParameters();
            this.gDs.setPictureFormat(256);
            Camera.Size e = e(this.gDs.getSupportedPictureSizes(), 1440, 1080);
            this.gDs.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.gDs.getSupportedPreviewSizes(), 1440, 1080);
            this.gDs.setPreviewSize(e2.width, e2.height);
            if (this.gDj != null) {
                this.gDj.bL(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gDs.getSupportedFocusModes().contains("continuous-video")) {
                this.gDs.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gDs);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.gfO = true;
        }
    }

    public void bqJ() {
        if (this.mCamera != null && !this.gfO) {
            this.mCamera.startPreview();
            this.gfO = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.gfO = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.gfO && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.ggd);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gfO) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gDs != null && this.gDs.isZoomSupported() && this.mTouchMode == 2) {
                        this.gDu = z(motionEvent);
                        if (this.gDu > this.gDv) {
                            float f = this.gDu - this.geF;
                            int maxZoom = this.gDs.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.gfs) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                ut(maxZoom);
                                this.geF = this.gDu;
                                break;
                            } else if (f < (-this.gfs)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                ut(i2);
                                this.geF = this.gDu;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.geF = z(motionEvent);
                    if (this.geF > this.gDv) {
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

    private float z(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void ut(int i) {
        if (this.mCamera != null) {
            this.gDs = this.mCamera.getParameters();
            if (this.gDs != null) {
                this.gDs.setZoom(i);
                this.mCamera.setParameters(this.gDs);
            }
        }
    }

    public void bqK() {
        u.a(new t<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                if (TbCameraView.this.gfS != null && !StringUtils.isNull(TbCameraView.this.gDt)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.gfS, TbCameraView.this.gfR ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gDt));
                            b2.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            b2.recycle();
                            com.baidu.adp.lib.g.e.ga().post(TbCameraView.this.mRunnable);
                            return null;
                        }
                        return null;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }, null);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.mRunnable);
    }

    public void byU() {
        if (this.gfS != null) {
            this.gfS.recycle();
            this.gfS = null;
        }
    }

    public Bitmap b(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (com.baidu.tbadk.core.util.u.u(list) == 0) {
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
        this.gDt = str;
    }

    public void bqM() {
        stopCamera();
        mr(!this.gfR);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gDl = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gDj = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gDh = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gDi = aVar;
    }
}
