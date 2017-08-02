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
    private c gAe;
    private a gAf;
    private b gAg;
    private d gAi;
    private Camera.Parameters gAp;
    private String gAq;
    private float gAr;
    private int gAs;
    private SurfaceHolder.Callback gAt;
    private float gbB;
    private boolean gcK;
    private boolean gcN;
    private Bitmap gcO;
    private Camera.PictureCallback gcZ;
    private int gco;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes.dex */
    public interface a {
        void bpV();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bC(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean bpU();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bpX();

        void bpY();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gcK = false;
        this.gAq = null;
        this.mTouchMode = 0;
        this.gcN = false;
        this.gAt = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gAe != null && TbCameraView.this.gAe.bpU()) {
                    TbCameraView.this.mo(TbCameraView.this.gcN);
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
        this.gcZ = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.gcO = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.gcK = false;
                    if (TbCameraView.this.gAi != null) {
                        TbCameraView.this.gAi.bpX();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gAi != null) {
                    TbCameraView.this.gAi.bpY();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gAt);
        this.gAs = getResources().getDimensionPixelSize(d.f.ds5);
        this.gco = getResources().getDimensionPixelSize(d.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo(boolean z) {
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
                if (this.gAf == null) {
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
                            this.gcN = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.gcN = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gAf == null) {
                        this.gAf.bpV();
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
            this.gAp = this.mCamera.getParameters();
            this.gAp.setPictureFormat(256);
            Camera.Size e = e(this.gAp.getSupportedPictureSizes(), 1440, 1080);
            this.gAp.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.gAp.getSupportedPreviewSizes(), 1440, 1080);
            this.gAp.setPreviewSize(e2.width, e2.height);
            if (this.gAg != null) {
                this.gAg.bC(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gAp.getSupportedFocusModes().contains("continuous-video")) {
                this.gAp.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gAp);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.gcK = true;
        }
    }

    public void bqb() {
        if (this.mCamera != null && !this.gcK) {
            this.mCamera.startPreview();
            this.gcK = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.gcK = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.gcK && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.gcZ);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gcK) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gAp != null && this.gAp.isZoomSupported() && this.mTouchMode == 2) {
                        this.gAr = z(motionEvent);
                        if (this.gAr > this.gAs) {
                            float f = this.gAr - this.gbB;
                            int maxZoom = this.gAp.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.gco) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                ul(maxZoom);
                                this.gbB = this.gAr;
                                break;
                            } else if (f < (-this.gco)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                ul(i2);
                                this.gbB = this.gAr;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.gbB = z(motionEvent);
                    if (this.gbB > this.gAs) {
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

    public void ul(int i) {
        if (this.mCamera != null) {
            this.gAp = this.mCamera.getParameters();
            if (this.gAp != null) {
                this.gAp.setZoom(i);
                this.mCamera.setParameters(this.gAp);
            }
        }
    }

    public void bqc() {
        u.a(new t<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                if (TbCameraView.this.gcO != null && !StringUtils.isNull(TbCameraView.this.gAq)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.gcO, TbCameraView.this.gcN ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gAq));
                            b2.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            b2.recycle();
                            com.baidu.adp.lib.g.e.fP().post(TbCameraView.this.mRunnable);
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mRunnable);
    }

    public void byo() {
        if (this.gcO != null) {
            this.gcO.recycle();
            this.gcO = null;
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
        this.gAq = str;
    }

    public void bqe() {
        stopCamera();
        mo(!this.gcN);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gAi = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gAg = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gAe = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gAf = aVar;
    }
}
