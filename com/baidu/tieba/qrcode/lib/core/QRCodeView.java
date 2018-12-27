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
    protected CameraPreview gLM;
    protected ScanBoxView gLN;
    protected a gLO;
    protected boolean gLP;
    protected c gLQ;
    private Runnable gLR;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void buu();

        void uo(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLP = false;
        this.gLR = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.gLP) {
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
        this.gLM = new CameraPreview(getContext());
        this.gLN = new ScanBoxView(getContext());
        this.gLN.f(context, attributeSet);
        this.gLM.setId(e.g.bgaqrcode_camera_preview);
        addView(this.gLM);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gLM.getId());
        layoutParams.addRule(8, this.gLM.getId());
        addView(this.gLN, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cT(context);
    }

    public void setDelegate(a aVar) {
        this.gLO = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.gLN;
    }

    public void buz() {
        if (this.gLN != null) {
            this.gLN.setVisibility(0);
        }
    }

    public void buA() {
        if (this.gLN != null) {
            this.gLN.setVisibility(8);
        }
    }

    public void buB() {
        tR(0);
    }

    public void tR(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    tS(i2);
                    return;
                }
            }
        }
    }

    private void tS(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gLM.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gLO != null) {
                this.gLO.buu();
            }
        }
    }

    public void stopCamera() {
        try {
            buE();
            if (this.mCamera != null) {
                this.gLM.bux();
                this.gLM.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void buC() {
        tT(1000);
    }

    public void tT(int i) {
        this.gLP = true;
        this.mHandler.removeCallbacks(this.gLR);
        this.mHandler.postDelayed(this.gLR, i);
    }

    public void buD() {
        buF();
        this.gLP = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gLR);
        }
    }

    public void buE() {
        buD();
        buA();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gLO = null;
        this.gLR = null;
    }

    protected void buF() {
        if (this.gLQ != null) {
            this.gLQ.ia();
            this.gLQ = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gLN.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gLP) {
            buF();
            this.gLQ = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.gLP) {
                        if (QRCodeView.this.gLO != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.gLO.uo(str);
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
            }.buy();
        }
    }
}
