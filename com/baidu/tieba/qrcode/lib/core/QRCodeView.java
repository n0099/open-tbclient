package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview glH;
    protected ScanBoxView glI;
    protected a glJ;
    protected boolean glK;
    protected c glL;
    private Runnable glM;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bmy();

        void sv(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.glK = false;
        this.glM = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.glK) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        f(context, attributeSet);
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.glH = new CameraPreview(getContext());
        this.glI = new ScanBoxView(getContext());
        this.glI.g(context, attributeSet);
        this.glH.setId(d.g.bgaqrcode_camera_preview);
        addView(this.glH);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.glH.getId());
        layoutParams.addRule(8, this.glH.getId());
        addView(this.glI, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cb(context);
    }

    public void setDelegate(a aVar) {
        this.glJ = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.glI;
    }

    public void bmC() {
        if (this.glI != null) {
            this.glI.setVisibility(0);
        }
    }

    public void bmD() {
        if (this.glI != null) {
            this.glI.setVisibility(8);
        }
    }

    public void bmE() {
        rX(0);
    }

    public void rX(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    rY(i2);
                    return;
                }
            }
        }
    }

    private void rY(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.glH.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.glJ != null) {
                this.glJ.bmy();
            }
        }
    }

    public void stopCamera() {
        try {
            bmH();
            if (this.mCamera != null) {
                this.glH.bmA();
                this.glH.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bmF() {
        rZ(1000);
    }

    public void rZ(int i) {
        this.glK = true;
        this.mHandler.removeCallbacks(this.glM);
        this.mHandler.postDelayed(this.glM, i);
    }

    public void bmG() {
        bmI();
        this.glK = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.glM);
        }
    }

    public void bmH() {
        bmG();
        bmD();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.glJ = null;
        this.glM = null;
    }

    protected void bmI() {
        if (this.glL != null) {
            this.glL.gG();
            this.glL = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.glI.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.glK) {
            bmI();
            this.glL = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.glK) {
                        if (QRCodeView.this.glJ != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.glJ.sv(str);
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
            }.bmB();
        }
    }
}
