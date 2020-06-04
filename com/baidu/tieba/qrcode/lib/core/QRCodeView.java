package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes10.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview kHN;
    protected ScanBoxView kHO;
    protected a kHP;
    protected boolean kHQ;
    protected c kHR;
    private Runnable kHS;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void KQ(String str);

        void cTH();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kHQ = false;
        this.kHS = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.kHQ) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.kHN = new CameraPreview(getContext());
        this.kHO = new ScanBoxView(getContext());
        this.kHO.j(context, attributeSet);
        this.kHN.setId(R.id.bgaqrcode_camera_preview);
        addView(this.kHN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.kHN.getId());
        layoutParams.addRule(8, this.kHN.getId());
        addView(this.kHO, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ff(context);
    }

    public void setDelegate(a aVar) {
        this.kHP = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.kHO;
    }

    public void cTP() {
        if (this.kHO != null) {
            this.kHO.setVisibility(0);
        }
    }

    public void cTQ() {
        if (this.kHO != null) {
            this.kHO.setVisibility(8);
        }
    }

    public void cTR() {
        Cd(0);
    }

    public void Cd(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Ce(i2);
                    return;
                }
            }
        }
    }

    private void Ce(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.kHN.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.kHP != null) {
                this.kHP.cTH();
            }
        }
    }

    public void stopCamera() {
        try {
            cTU();
            if (this.mCamera != null) {
                this.kHN.cTN();
                this.kHN.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cTS() {
        Cf(1000);
    }

    public void Cf(int i) {
        this.kHQ = true;
        this.mHandler.removeCallbacks(this.kHS);
        this.mHandler.postDelayed(this.kHS, i);
    }

    public void cTT() {
        cTV();
        this.kHQ = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.kHS);
        }
    }

    public void cTU() {
        cTT();
        cTQ();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.kHP = null;
        this.kHS = null;
    }

    protected void cTV() {
        if (this.kHR != null) {
            this.kHR.cancelTask();
            this.kHR = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.kHO.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.kHQ) {
            cTV();
            this.kHR = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.kHQ) {
                        if (QRCodeView.this.kHP != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.kHP.KQ(str);
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
            }.cTO();
        }
    }
}
