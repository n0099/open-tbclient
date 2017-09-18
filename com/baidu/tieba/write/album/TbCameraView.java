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
    private c gCN;
    private a gCO;
    private b gCP;
    private d gCR;
    private Camera.Parameters gCY;
    private String gCZ;
    private float gDa;
    private int gDb;
    private SurfaceHolder.Callback gDc;
    private int geP;
    private float gej;
    private boolean gfk;
    private boolean gfn;
    private Bitmap gfo;
    private Camera.PictureCallback gfz;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void bqd();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bR(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean bqc();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void bqf();

        void bqg();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfk = false;
        this.gCZ = null;
        this.mTouchMode = 0;
        this.gfn = false;
        this.gDc = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gCN != null && TbCameraView.this.gCN.bqc()) {
                    TbCameraView.this.my(TbCameraView.this.gfn);
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
        this.gfz = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.gfo = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.gfk = false;
                    if (TbCameraView.this.gCR != null) {
                        TbCameraView.this.gCR.bqf();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gCR != null) {
                    TbCameraView.this.gCR.bqg();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gDc);
        this.gDb = getResources().getDimensionPixelSize(d.f.ds5);
        this.geP = getResources().getDimensionPixelSize(d.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void my(boolean z) {
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
                if (this.gCO == null) {
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
                            this.gfn = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.gfn = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gCO == null) {
                        this.gCO.bqd();
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
            this.gCY = this.mCamera.getParameters();
            this.gCY.setPictureFormat(256);
            Camera.Size e = e(this.gCY.getSupportedPictureSizes(), 1440, 1080);
            this.gCY.setPictureSize(e.width, e.height);
            Camera.Size e2 = e(this.gCY.getSupportedPreviewSizes(), 1440, 1080);
            this.gCY.setPreviewSize(e2.width, e2.height);
            if (this.gCP != null) {
                this.gCP.bR(e2.width, e2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gCY.getSupportedFocusModes().contains("continuous-video")) {
                this.gCY.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gCY);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.gfk = true;
        }
    }

    public void bqj() {
        if (this.mCamera != null && !this.gfk) {
            this.mCamera.startPreview();
            this.gfk = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.gfk = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.gfk && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.gfz);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gfk) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gCY != null && this.gCY.isZoomSupported() && this.mTouchMode == 2) {
                        this.gDa = z(motionEvent);
                        if (this.gDa > this.gDb) {
                            float f = this.gDa - this.gej;
                            int maxZoom = this.gCY.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.geP) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                uy(maxZoom);
                                this.gej = this.gDa;
                                break;
                            } else if (f < (-this.geP)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                uy(i2);
                                this.gej = this.gDa;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.gej = z(motionEvent);
                    if (this.gej > this.gDb) {
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

    public void uy(int i) {
        if (this.mCamera != null) {
            this.gCY = this.mCamera.getParameters();
            if (this.gCY != null) {
                this.gCY.setZoom(i);
                this.mCamera.setParameters(this.gCY);
            }
        }
    }

    public void bqk() {
        u.a(new t<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                if (TbCameraView.this.gfo != null && !StringUtils.isNull(TbCameraView.this.gCZ)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.gfo, TbCameraView.this.gfn ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gCZ));
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

    public void byw() {
        if (this.gfo != null) {
            this.gfo.recycle();
            this.gfo = null;
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
        this.gCZ = str;
    }

    public void bqm() {
        stopCamera();
        my(!this.gfn);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gCR = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gCP = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gCN = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gCO = aVar;
    }
}
