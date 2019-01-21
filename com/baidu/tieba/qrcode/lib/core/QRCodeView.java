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
    protected CameraPreview gMR;
    protected ScanBoxView gMS;
    protected a gMT;
    protected boolean gMU;
    protected c gMV;
    private Runnable gMW;
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
        this.gMU = false;
        this.gMW = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.gMU) {
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
        this.gMR = new CameraPreview(getContext());
        this.gMS = new ScanBoxView(getContext());
        this.gMS.f(context, attributeSet);
        this.gMR.setId(e.g.bgaqrcode_camera_preview);
        addView(this.gMR);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gMR.getId());
        layoutParams.addRule(8, this.gMR.getId());
        addView(this.gMS, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cT(context);
    }

    public void setDelegate(a aVar) {
        this.gMT = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.gMS;
    }

    public void bvi() {
        if (this.gMS != null) {
            this.gMS.setVisibility(0);
        }
    }

    public void bvj() {
        if (this.gMS != null) {
            this.gMS.setVisibility(8);
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
            this.gMR.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gMT != null) {
                this.gMT.bvd();
            }
        }
    }

    public void stopCamera() {
        try {
            bvn();
            if (this.mCamera != null) {
                this.gMR.bvg();
                this.gMR.setCamera(null);
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
        this.gMU = true;
        this.mHandler.removeCallbacks(this.gMW);
        this.mHandler.postDelayed(this.gMW, i);
    }

    public void bvm() {
        bvo();
        this.gMU = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gMW);
        }
    }

    public void bvn() {
        bvm();
        bvj();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gMT = null;
        this.gMW = null;
    }

    protected void bvo() {
        if (this.gMV != null) {
            this.gMV.ia();
            this.gMV = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gMS.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gMU) {
            bvo();
            this.gMV = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.gMU) {
                        if (QRCodeView.this.gMT != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.gMT.uE(str);
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
