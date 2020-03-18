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
    protected CameraPreview jEN;
    protected ScanBoxView jEO;
    protected a jEP;
    protected boolean jEQ;
    protected c jER;
    private Runnable jES;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void Hv(String str);

        void cBU();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEQ = false;
        this.jES = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.jEQ) {
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
        this.jEN = new CameraPreview(getContext());
        this.jEO = new ScanBoxView(getContext());
        this.jEO.j(context, attributeSet);
        this.jEN.setId(R.id.bgaqrcode_camera_preview);
        addView(this.jEN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.jEN.getId());
        layoutParams.addRule(8, this.jEN.getId());
        addView(this.jEO, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fk(context);
    }

    public void setDelegate(a aVar) {
        this.jEP = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.jEO;
    }

    public void cCc() {
        if (this.jEO != null) {
            this.jEO.setVisibility(0);
        }
    }

    public void cCd() {
        if (this.jEO != null) {
            this.jEO.setVisibility(8);
        }
    }

    public void cCe() {
        AR(0);
    }

    public void AR(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    AS(i2);
                    return;
                }
            }
        }
    }

    private void AS(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.jEN.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.jEP != null) {
                this.jEP.cBU();
            }
        }
    }

    public void stopCamera() {
        try {
            cCh();
            if (this.mCamera != null) {
                this.jEN.cCa();
                this.jEN.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cCf() {
        AT(1000);
    }

    public void AT(int i) {
        this.jEQ = true;
        this.mHandler.removeCallbacks(this.jES);
        this.mHandler.postDelayed(this.jES, i);
    }

    public void cCg() {
        cCi();
        this.jEQ = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jES);
        }
    }

    public void cCh() {
        cCg();
        cCd();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.jEP = null;
        this.jES = null;
    }

    protected void cCi() {
        if (this.jER != null) {
            this.jER.cancelTask();
            this.jER = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.jEO.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.jEQ) {
            cCi();
            this.jER = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.jEQ) {
                        if (QRCodeView.this.jEP != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.jEP.Hv(str);
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
            }.cCb();
        }
    }
}
