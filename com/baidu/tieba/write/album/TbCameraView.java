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
    private Camera.Parameters gBA;
    private String gBB;
    private float gBC;
    private int gBD;
    private SurfaceHolder.Callback gBE;
    private c gBp;
    private a gBq;
    private b gBr;
    private d gBt;
    private float gcN;
    private int gdA;
    private boolean gdW;
    private boolean gdZ;
    private Bitmap gea;
    private Camera.PictureCallback gel;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes.dex */
    public interface a {
        void bqc();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bD(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean bqb();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bqe();

        void bqf();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdW = false;
        this.gBB = null;
        this.mTouchMode = 0;
        this.gdZ = false;
        this.gBE = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gBp != null && TbCameraView.this.gBp.bqb()) {
                    TbCameraView.this.mo(TbCameraView.this.gdZ);
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
        this.gel = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.gea = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.gdW = false;
                    if (TbCameraView.this.gBt != null) {
                        TbCameraView.this.gBt.bqe();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gBt != null) {
                    TbCameraView.this.gBt.bqf();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gBE);
        this.gBD = getResources().getDimensionPixelSize(d.f.ds5);
        this.gdA = getResources().getDimensionPixelSize(d.f.ds20);
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
                if (this.gBq == null) {
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
                            this.gdZ = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.gdZ = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gBq == null) {
                        this.gBq.bqc();
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
            this.gBA = this.mCamera.getParameters();
            this.gBA.setPictureFormat(256);
            Camera.Size e = e(this.gBA.getSupportedPictureSizes(), 1440, 1080);
            this.gBA.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.gBA.getSupportedPreviewSizes(), 1440, 1080);
            this.gBA.setPreviewSize(e2.width, e2.height);
            if (this.gBr != null) {
                this.gBr.bD(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gBA.getSupportedFocusModes().contains("continuous-video")) {
                this.gBA.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gBA);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.gdW = true;
        }
    }

    public void bqi() {
        if (this.mCamera != null && !this.gdW) {
            this.mCamera.startPreview();
            this.gdW = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.gdW = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.gdW && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.gel);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gdW) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gBA != null && this.gBA.isZoomSupported() && this.mTouchMode == 2) {
                        this.gBC = z(motionEvent);
                        if (this.gBC > this.gBD) {
                            float f = this.gBC - this.gcN;
                            int maxZoom = this.gBA.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.gdA) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                uk(maxZoom);
                                this.gcN = this.gBC;
                                break;
                            } else if (f < (-this.gdA)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                uk(i2);
                                this.gcN = this.gBC;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.gcN = z(motionEvent);
                    if (this.gcN > this.gBD) {
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

    public void uk(int i) {
        if (this.mCamera != null) {
            this.gBA = this.mCamera.getParameters();
            if (this.gBA != null) {
                this.gBA.setZoom(i);
                this.mCamera.setParameters(this.gBA);
            }
        }
    }

    public void bqj() {
        u.a(new t<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                if (TbCameraView.this.gea != null && !StringUtils.isNull(TbCameraView.this.gBB)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.gea, TbCameraView.this.gdZ ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gBB));
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

    public void byv() {
        if (this.gea != null) {
            this.gea.recycle();
            this.gea = null;
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
        this.gBB = str;
    }

    public void bql() {
        stopCamera();
        mo(!this.gdZ);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gBt = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gBr = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gBp = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gBq = aVar;
    }
}
