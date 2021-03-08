package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes7.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;
    protected CameraPreview mQP;
    protected ScanBoxView mQQ;
    protected a mQR;
    protected boolean mQS;
    protected c mQT;
    private Runnable mQU;

    /* loaded from: classes7.dex */
    public interface a {
        void QY(String str);

        void dCC();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQS = false;
        this.mQU = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mQS) {
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
        this.mQP = new CameraPreview(getContext());
        this.mQQ = new ScanBoxView(getContext());
        this.mQQ.l(context, attributeSet);
        this.mQP.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mQP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mQP.getId());
        layoutParams.addRule(8, this.mQP.getId());
        addView(this.mQQ, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.gL(context);
    }

    public void setDelegate(a aVar) {
        this.mQR = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mQQ;
    }

    public void dCK() {
        if (this.mQQ != null) {
            this.mQQ.setVisibility(0);
        }
    }

    public void dCL() {
        if (this.mQQ != null) {
            this.mQQ.setVisibility(8);
        }
    }

    public void dCM() {
        HG(0);
    }

    public void HG(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    HH(i2);
                    return;
                }
            }
        }
    }

    private void HH(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mQP.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mQR != null) {
                this.mQR.dCC();
            }
        }
    }

    public void stopCamera() {
        try {
            dCP();
            if (this.mCamera != null) {
                this.mQP.dCI();
                this.mQP.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dCN() {
        HI(1000);
    }

    public void HI(int i) {
        this.mQS = true;
        this.mHandler.removeCallbacks(this.mQU);
        this.mHandler.postDelayed(this.mQU, i);
    }

    public void dCO() {
        dCQ();
        this.mQS = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mQU);
        }
    }

    public void dCP() {
        dCO();
        dCL();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mQR = null;
        this.mQU = null;
    }

    protected void dCQ() {
        if (this.mQT != null) {
            this.mQT.cancelTask();
            this.mQT = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mQQ.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mQS) {
            dCQ();
            this.mQT = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mQS) {
                        if (QRCodeView.this.mQR != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mQR.QY(str);
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
            }.dCJ();
        }
    }
}
