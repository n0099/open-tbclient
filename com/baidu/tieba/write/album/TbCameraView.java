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
    private Camera.Parameters gHG;
    private String gHH;
    private float gHI;
    private int gHJ;
    private SurfaceHolder.Callback gHK;
    private c gHv;
    private a gHw;
    private b gHx;
    private d gHz;
    private float gbB;
    private boolean gcC;
    private boolean gcF;
    private Bitmap gcG;
    private Camera.PictureCallback gcR;
    private int gch;
    private Camera mCamera;
    private Context mContext;
    private Runnable mRunnable;
    private SurfaceHolder mSurfaceHolder;
    private int mTouchMode;

    /* loaded from: classes2.dex */
    public interface a {
        void boQ();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void cd(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean boP();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void boS();

        void boT();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gcC = false;
        this.gHH = null;
        this.mTouchMode = 0;
        this.gcF = false;
        this.gHK = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.write.album.TbCameraView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                TbCameraView.this.mSurfaceHolder = surfaceHolder;
                if (TbCameraView.this.gHv != null && TbCameraView.this.gHv.boP()) {
                    TbCameraView.this.ms(TbCameraView.this.gcF);
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
        this.gcR = new Camera.PictureCallback() { // from class: com.baidu.tieba.write.album.TbCameraView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                if (bArr != null) {
                    TbCameraView.this.gcG = BitmapHelper.Bytes2Bitmap(bArr);
                    if (TbCameraView.this.mCamera != null) {
                        TbCameraView.this.mCamera.stopPreview();
                    }
                    TbCameraView.this.gcC = false;
                    if (TbCameraView.this.gHz != null) {
                        TbCameraView.this.gHz.boS();
                    }
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.write.album.TbCameraView.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbCameraView.this.gHz != null) {
                    TbCameraView.this.gHz.boT();
                }
            }
        };
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this.gHK);
        this.gHJ = getResources().getDimensionPixelSize(d.f.ds5);
        this.gch = getResources().getDimensionPixelSize(d.f.ds20);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ms(boolean z) {
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
                if (this.gHw == null) {
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
                            this.gcF = true;
                            break;
                        }
                    } else if (cameraInfo.facing == 0) {
                        this.mCamera = Camera.open(i);
                        this.gcF = false;
                        break;
                    }
                    th.printStackTrace();
                    this.mCamera = null;
                    if (this.gHw == null) {
                        this.gHw.boQ();
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
            this.gHG = this.mCamera.getParameters();
            this.gHG.setPictureFormat(256);
            Camera.Size f = f(this.gHG.getSupportedPictureSizes(), 1440, 1080);
            this.gHG.setPictureSize(f.width, f.height);
            Camera.Size f2 = f(this.gHG.getSupportedPreviewSizes(), 1440, 1080);
            this.gHG.setPreviewSize(f2.width, f2.height);
            if (this.gHx != null) {
                this.gHx.cd(f2.width, f2.height);
            }
            this.mCamera.setDisplayOrientation(90);
            if (this.gHG.getSupportedFocusModes().contains("continuous-video")) {
                this.gHG.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.gHG);
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.gcC = true;
        }
    }

    public void boW() {
        if (this.mCamera != null && !this.gcC) {
            this.mCamera.startPreview();
            this.gcC = true;
        }
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.gcC = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture() {
        if (this.gcC && this.mCamera != null) {
            this.mCamera.takePicture(null, null, this.gcR);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gcC) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mTouchMode = 1;
                    break;
                case 1:
                    this.mTouchMode = 0;
                    break;
                case 2:
                    if (this.gHG != null && this.gHG.isZoomSupported() && this.mTouchMode == 2) {
                        this.gHI = A(motionEvent);
                        if (this.gHI > this.gHJ) {
                            float f = this.gHI - this.gbB;
                            int maxZoom = this.gHG.getMaxZoom();
                            int zoom = this.mCamera.getParameters().getZoom();
                            if (f > this.gch) {
                                int i = zoom + 1;
                                if (i <= maxZoom) {
                                    maxZoom = i;
                                }
                                uT(maxZoom);
                                this.gbB = this.gHI;
                                break;
                            } else if (f < (-this.gch)) {
                                int i2 = zoom - 1;
                                if (i2 < 0) {
                                    i2 = 0;
                                }
                                uT(i2);
                                this.gbB = this.gHI;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.gbB = A(motionEvent);
                    if (this.gbB > this.gHJ) {
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

    public void uT(int i) {
        if (this.mCamera != null) {
            this.gHG = this.mCamera.getParameters();
            if (this.gHG != null) {
                this.gHG.setZoom(i);
                this.mCamera.setParameters(this.gHG);
            }
        }
    }

    public void boX() {
        t.a(new s<Object>() { // from class: com.baidu.tieba.write.album.TbCameraView.3
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                if (TbCameraView.this.gcG != null && !StringUtils.isNull(TbCameraView.this.gHH)) {
                    try {
                        Bitmap b2 = TbCameraView.this.b(TbCameraView.this.gcG, TbCameraView.this.gcF ? -90 : 90);
                        if (b2 != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(TbCameraView.this.gHH));
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

    public void bzF() {
        if (this.gcG != null) {
            this.gcG.recycle();
            this.gcG = null;
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
        this.gHH = str;
    }

    public void boZ() {
        stopCamera();
        ms(!this.gcF);
    }

    public void setOnGotPictureListener(d dVar) {
        this.gHz = dVar;
    }

    public void setOnPreviewSizeChangedListener(b bVar) {
        this.gHx = bVar;
    }

    public void setOnRequestPermissionListener(c cVar) {
        this.gHv = cVar;
    }

    public void setOnOpenCameraFailedListener(a aVar) {
        this.gHw = aVar;
    }
}
