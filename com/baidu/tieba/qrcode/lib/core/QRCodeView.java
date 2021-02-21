package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes8.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected Camera mCamera;
    protected Handler mHandler;
    protected CameraPreview mOK;
    protected ScanBoxView mOL;
    protected a mOM;
    protected boolean mON;
    protected c mOO;
    private Runnable mOP;
    private int mOrientation;

    /* loaded from: classes8.dex */
    public interface a {
        void QS(String str);

        void dCu();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mON = false;
        this.mOP = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mON) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        j(context, attributeSet);
    }

    private void j(Context context, AttributeSet attributeSet) {
        this.mOK = new CameraPreview(getContext());
        this.mOL = new ScanBoxView(getContext());
        this.mOL.l(context, attributeSet);
        this.mOK.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mOK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mOK.getId());
        layoutParams.addRule(8, this.mOK.getId());
        addView(this.mOL, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.gM(context);
    }

    public void setDelegate(a aVar) {
        this.mOM = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mOL;
    }

    public void dCC() {
        if (this.mOL != null) {
            this.mOL.setVisibility(0);
        }
    }

    public void dCD() {
        if (this.mOL != null) {
            this.mOL.setVisibility(8);
        }
    }

    public void dCE() {
        HD(0);
    }

    public void HD(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    HE(i2);
                    return;
                }
            }
        }
    }

    private void HE(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mOK.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mOM != null) {
                this.mOM.dCu();
            }
        }
    }

    public void stopCamera() {
        try {
            dCH();
            if (this.mCamera != null) {
                this.mOK.dCA();
                this.mOK.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dCF() {
        HF(1000);
    }

    public void HF(int i) {
        this.mON = true;
        this.mHandler.removeCallbacks(this.mOP);
        this.mHandler.postDelayed(this.mOP, i);
    }

    public void dCG() {
        dCI();
        this.mON = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mOP);
        }
    }

    public void dCH() {
        dCG();
        dCD();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mOM = null;
        this.mOP = null;
    }

    protected void dCI() {
        if (this.mOO != null) {
            this.mOO.cancelTask();
            this.mOO = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mOL.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mON) {
            dCI();
            this.mOO = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mON) {
                        if (QRCodeView.this.mOM != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mOM.QS(str);
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
            }.dCB();
        }
    }
}
