package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview gMQ;
    protected ScanBoxView gMR;
    protected a gMS;
    protected boolean gMT;
    protected c gMU;
    private Runnable gMV;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bvd();

        void uE(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gMT = false;
        this.gMV = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.gMT) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        c(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        this.gMQ = new CameraPreview(getContext());
        this.gMR = new ScanBoxView(getContext());
        this.gMR.f(context, attributeSet);
        this.gMQ.setId(e.g.bgaqrcode_camera_preview);
        addView(this.gMQ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gMQ.getId());
        layoutParams.addRule(8, this.gMQ.getId());
        addView(this.gMR, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cT(context);
    }

    public void setDelegate(a aVar) {
        this.gMS = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.gMR;
    }

    public void bvi() {
        if (this.gMR != null) {
            this.gMR.setVisibility(0);
        }
    }

    public void bvj() {
        if (this.gMR != null) {
            this.gMR.setVisibility(8);
        }
    }

    public void bvk() {
        tV(0);
    }

    public void tV(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    tW(i2);
                    return;
                }
            }
        }
    }

    private void tW(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gMQ.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gMS != null) {
                this.gMS.bvd();
            }
        }
    }

    public void stopCamera() {
        try {
            bvn();
            if (this.mCamera != null) {
                this.gMQ.bvg();
                this.gMQ.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bvl() {
        tX(1000);
    }

    public void tX(int i) {
        this.gMT = true;
        this.mHandler.removeCallbacks(this.gMV);
        this.mHandler.postDelayed(this.gMV, i);
    }

    public void bvm() {
        bvo();
        this.gMT = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gMV);
        }
    }

    public void bvn() {
        bvm();
        bvj();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gMS = null;
        this.gMV = null;
    }

    protected void bvo() {
        if (this.gMU != null) {
            this.gMU.ia();
            this.gMU = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gMR.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gMT) {
            bvo();
            this.gMU = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.gMT) {
                        if (QRCodeView.this.gMS != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.gMS.uE(str);
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        }
                        try {
                            camera.setOneShotPreviewCallback(QRCodeView.this);
                        } catch (Exception e2) {
                        }
                    }
                }
            }.bvh();
        }
    }
}
