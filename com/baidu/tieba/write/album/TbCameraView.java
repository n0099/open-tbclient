package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class TbCameraView extends SurfaceView {
    private c gSB;
    private a gSC;
    private b gSD;
    private d gSF;
    private Camera.Parameters gSM;
    private String gSN;
    private float gSO;
    private int gSP;
    private SurfaceHolder.Callback gSQ;
    private int glW;
    private float glq;
    private Camera.PictureCallback gmF;
    private boolean gmq;
    private boolean gmt;
    private Bitmap gmu;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void bsf();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void ce(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean bse();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void bsh();

        void bsi();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmq = false;
        this.gSN = null;
        this.mTouchMode = 0;
        this.gmt = false;
        this.gSQ = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gSB != null && TbCameraView.this.gSB.bse()) {
                    TbCameraView.this.mv(TbCameraView.this.gmt);
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
        this.gmF = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.gmu = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.gmq = false;
                    if (TbCameraView.this.gSF != null) {
                        TbCameraView.this.gSF.bsh();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gSF != null) {
                    TbCameraView.this.gSF.bsi();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gSQ);
        this.gSP = getResources().getDimensionPixelSize(d.e.ds5);
        this.glW = getResources().getDimensionPixelSize(d.e.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mv(boolean z) {
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
                if (this.gSC == null) {
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
                            this.gmt = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.gmt = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gSC == null) {
                        this.gSC.bsf();
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
            this.gSM = this.mCamera.getParameters();
            this.gSM.setPictureFormat(256);
            Camera.Size f = f(this.gSM.getSupportedPictureSizes(), 1440, 1080);
            this.gSM.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.gSM.getSupportedPreviewSizes(), 1440, 1080);
            this.gSM.setPreviewSize(f2.width, f2.height);
            if (this.gSD != null) {
                this.gSD.ce(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gSM.getSupportedFocusModes().contains("continuous-video")) {
                this.gSM.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gSM);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.gmq = true;
        }
    }

    public void bsl() {
        if (this.mCamera != null && !this.gmq) {
            this.mCamera.startPreview();
            this.gmq = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.gmq = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.gmq && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.gmF);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gmq) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gSM != null && this.gSM.isZoomSupported() && this.mTouchMode == 2) {
                        this.gSO = C(motionEvent);
                        if (this.gSO > this.gSP) {
                            float f = this.gSO - this.glq;
                            int maxZoom = this.gSM.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.glW) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                vr(maxZoom);
                                this.glq = this.gSO;
                                break;
                            } else if (f < (-this.glW)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                vr(i2);
                                this.glq = this.gSO;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.glq = C(motionEvent);
                    if (this.glq > this.gSP) {
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

    private float C(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void vr(int i) {
        if (this.mCamera != null) {
            this.gSM = this.mCamera.getParameters();
            if (this.gSM != null) {
                this.gSM.setZoom(i);
                this.mCamera.setParameters(this.gSM);
            }
        }
    }

    public void bsm() {
        v.a(new u<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                if (TbCameraView.this.gmu != null && !StringUtils.isNull(TbCameraView.this.gSN)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.gmu, TbCameraView.this.gmt ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gSN));
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

    public void bDp() {
        if (this.gmu != null) {
            this.gmu.recycle();
            this.gmu = null;
        }
    }

    public Bitmap b(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
        if (com.baidu.tbadk.core.util.v.u(list) == 0) {
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
        this.gSN = str;
    }

    public void bso() {
        stopCamera();
        mv(!this.gmt);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gSF = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gSD = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gSB = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gSC = aVar;
    }
}
