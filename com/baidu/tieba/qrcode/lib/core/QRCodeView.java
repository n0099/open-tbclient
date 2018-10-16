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
    protected CameraPreview gAD;
    protected ScanBoxView gAE;
    protected a gAF;
    protected boolean gAG;
    protected c gAH;
    private Runnable gAI;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bsu();

        void tF(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAG = false;
        this.gAI = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.gAG) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        e(context, attributeSet);
    }

    private void e(Context context, AttributeSet attributeSet) {
        this.gAD = new CameraPreview(getContext());
        this.gAE = new ScanBoxView(getContext());
        this.gAE.f(context, attributeSet);
        this.gAD.setId(e.g.bgaqrcode_camera_preview);
        addView(this.gAD);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gAD.getId());
        layoutParams.addRule(8, this.gAD.getId());
        addView(this.gAE, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cU(context);
    }

    public void setDelegate(a aVar) {
        this.gAF = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.gAE;
    }

    public void bsz() {
        if (this.gAE != null) {
            this.gAE.setVisibility(0);
        }
    }

    public void bsA() {
        if (this.gAE != null) {
            this.gAE.setVisibility(8);
        }
    }

    public void bsB() {
        sR(0);
    }

    public void sR(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    sS(i2);
                    return;
                }
            }
        }
    }

    private void sS(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gAD.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gAF != null) {
                this.gAF.bsu();
            }
        }
    }

    public void stopCamera() {
        try {
            bsE();
            if (this.mCamera != null) {
                this.gAD.bsx();
                this.gAD.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bsC() {
        sT(1000);
    }

    public void sT(int i) {
        this.gAG = true;
        this.mHandler.removeCallbacks(this.gAI);
        this.mHandler.postDelayed(this.gAI, i);
    }

    public void bsD() {
        bsF();
        this.gAG = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gAI);
        }
    }

    public void bsE() {
        bsD();
        bsA();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gAF = null;
        this.gAI = null;
    }

    protected void bsF() {
        if (this.gAH != null) {
            this.gAH.ib();
            this.gAH = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gAE.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gAG) {
            bsF();
            this.gAH = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.gAG) {
                        if (QRCodeView.this.gAF != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.gAF.tF(str);
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
            }.bsy();
        }
    }
}
