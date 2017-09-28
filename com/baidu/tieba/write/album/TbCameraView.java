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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class TbCameraView extends SurfaceView {
    private c gHL;
    private a gHM;
    private b gHN;
    private d gHP;
    private Camera.Parameters gHW;
    private String gHX;
    private float gHY;
    private int gHZ;
    private SurfaceHolder.Callback gIa;
    private float gbQ;
    private boolean gcR;
    private boolean gcU;
    private Bitmap gcV;
    private int gcw;
    private Camera.PictureCallback gdg;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void boY();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void cd(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean boX();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void bpa();

        void bpb();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gcR = false;
        this.gHX = null;
        this.mTouchMode = 0;
        this.gcU = false;
        this.gIa = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gHL != null && TbCameraView.this.gHL.boX()) {
                    TbCameraView.this.mt(TbCameraView.this.gcU);
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
        this.gdg = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.gcV = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.gcR = false;
                    if (TbCameraView.this.gHP != null) {
                        TbCameraView.this.gHP.bpa();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gHP != null) {
                    TbCameraView.this.gHP.bpb();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gIa);
        this.gHZ = getResources().getDimensionPixelSize(d.f.ds5);
        this.gcw = getResources().getDimensionPixelSize(d.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mt(boolean z) {
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
                if (this.gHM == null) {
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
                            this.gcU = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.gcU = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gHM == null) {
                        this.gHM.boY();
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
            this.gHW = this.mCamera.getParameters();
            this.gHW.setPictureFormat(256);
            Camera.Size f = f(this.gHW.getSupportedPictureSizes(), 1440, 1080);
            this.gHW.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.gHW.getSupportedPreviewSizes(), 1440, 1080);
            this.gHW.setPreviewSize(f2.width, f2.height);
            if (this.gHN != null) {
                this.gHN.cd(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gHW.getSupportedFocusModes().contains("continuous-video")) {
                this.gHW.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gHW);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.gcR = true;
        }
    }

    public void bpe() {
        if (this.mCamera != null && !this.gcR) {
            this.mCamera.startPreview();
            this.gcR = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.gcR = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.gcR && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.gdg);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gcR) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gHW != null && this.gHW.isZoomSupported() && this.mTouchMode == 2) {
                        this.gHY = A(motionEvent);
                        if (this.gHY > this.gHZ) {
                            float f = this.gHY - this.gbQ;
                            int maxZoom = this.gHW.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.gcw) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                uU(maxZoom);
                                this.gbQ = this.gHY;
                                break;
                            } else if (f < (-this.gcw)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                uU(i2);
                                this.gbQ = this.gHY;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.gbQ = A(motionEvent);
                    if (this.gbQ > this.gHZ) {
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

    private float A(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void uU(int i) {
        if (this.mCamera != null) {
            this.gHW = this.mCamera.getParameters();
            if (this.gHW != null) {
                this.gHW.setZoom(i);
                this.mCamera.setParameters(this.gHW);
            }
        }
    }

    public void bpf() {
        t.a(new s<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                if (TbCameraView.this.gcV != null && !StringUtils.isNull(TbCameraView.this.gHX)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.gcV, TbCameraView.this.gcU ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gHX));
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

    public void bzM() {
        if (this.gcV != null) {
            this.gcV.recycle();
            this.gcV = null;
        }
    }

    public Bitmap b(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public Camera.Size f(List<Camera.Size> list, int i, int i2) {
        if (v.t(list) == 0) {
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
        this.gHX = str;
    }

    public void bph() {
        stopCamera();
        mt(!this.gcU);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gHP = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gHN = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gHL = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gHM = aVar;
    }
}
