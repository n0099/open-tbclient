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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class TbCameraView extends SurfaceView {
    private c gBU;
    private a gBV;
    private b gBW;
    private d gBY;
    private Camera.Parameters gCf;
    private String gCg;
    private float gCh;
    private int gCi;
    private SurfaceHolder.Callback gCj;
    private int gdV;
    private float gdp;
    private Camera.PictureCallback geF;
    private boolean geq;
    private boolean get;
    private Bitmap geu;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void bpS();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bN(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean bpR();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void bpU();

        void bpV();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.geq = false;
        this.gCg = null;
        this.mTouchMode = 0;
        this.get = false;
        this.gCj = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gBU != null && TbCameraView.this.gBU.bpR()) {
                    TbCameraView.this.mx(TbCameraView.this.get);
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
        this.geF = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.geu = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.geq = false;
                    if (TbCameraView.this.gBY != null) {
                        TbCameraView.this.gBY.bpU();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gBY != null) {
                    TbCameraView.this.gBY.bpV();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gCj);
        this.gCi = getResources().getDimensionPixelSize(d.f.ds5);
        this.gdV = getResources().getDimensionPixelSize(d.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mx(boolean z) {
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
                if (this.gBV == null) {
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
                            this.get = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.get = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gBV == null) {
                        this.gBV.bpS();
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
            this.gCf = this.mCamera.getParameters();
            this.gCf.setPictureFormat(256);
            Camera.Size e = e(this.gCf.getSupportedPictureSizes(), 1440, 1080);
            this.gCf.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.gCf.getSupportedPreviewSizes(), 1440, 1080);
            this.gCf.setPreviewSize(e2.width, e2.height);
            if (this.gBW != null) {
                this.gBW.bN(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gCf.getSupportedFocusModes().contains("continuous-video")) {
                this.gCf.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gCf);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.geq = true;
        }
    }

    public void bpY() {
        if (this.mCamera != null && !this.geq) {
            this.mCamera.startPreview();
            this.geq = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.geq = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.geq && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.geF);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.geq) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gCf != null && this.gCf.isZoomSupported() && this.mTouchMode == 2) {
                        this.gCh = z(motionEvent);
                        if (this.gCh > this.gCi) {
                            float f = this.gCh - this.gdp;
                            int maxZoom = this.gCf.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.gdV) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                uw(maxZoom);
                                this.gdp = this.gCh;
                                break;
                            } else if (f < (-this.gdV)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                uw(i2);
                                this.gdp = this.gCh;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.gdp = z(motionEvent);
                    if (this.gdp > this.gCi) {
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

    public void uw(int i) {
        if (this.mCamera != null) {
            this.gCf = this.mCamera.getParameters();
            if (this.gCf != null) {
                this.gCf.setZoom(i);
                this.mCamera.setParameters(this.gCf);
            }
        }
    }

    public void bpZ() {
        u.a(new t<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                if (TbCameraView.this.geu != null && !StringUtils.isNull(TbCameraView.this.gCg)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.geu, TbCameraView.this.get ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gCg));
                            b2.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            b2.recycle();
                            com.baidu.adp.lib.g.e.fQ().post(TbCameraView.this.mRunnable);
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
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.mRunnable);
    }

    public void byl() {
        if (this.geu != null) {
            this.geu.recycle();
            this.geu = null;
        }
    }

    public Bitmap b(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public Camera.Size e(List<Camera.Size> list, int i, int i2) {
        if (v.u(list) == 0) {
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
        this.gCg = str;
    }

    public void bqb() {
        stopCamera();
        mx(!this.get);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gBY = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gBW = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gBU = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gBV = aVar;
    }
}
