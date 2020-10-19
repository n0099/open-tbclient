package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes23.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview lXI;
    protected ScanBoxView lXJ;
    protected a lXK;
    protected boolean lXL;
    protected c lXM;
    private Runnable lXN;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes23.dex */
    public interface a {
        void Qj(String str);

        void dtE();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lXL = false;
        this.lXN = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.lXL) {
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
        this.lXI = new CameraPreview(getContext());
        this.lXJ = new ScanBoxView(getContext());
        this.lXJ.j(context, attributeSet);
        this.lXI.setId(R.id.bgaqrcode_camera_preview);
        addView(this.lXI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.lXI.getId());
        layoutParams.addRule(8, this.lXI.getId());
        addView(this.lXJ, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fJ(context);
    }

    public void setDelegate(a aVar) {
        this.lXK = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.lXJ;
    }

    public void dtM() {
        if (this.lXJ != null) {
            this.lXJ.setVisibility(0);
        }
    }

    public void dtN() {
        if (this.lXJ != null) {
            this.lXJ.setVisibility(8);
        }
    }

    public void dtO() {
        Hd(0);
    }

    public void Hd(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    He(i2);
                    return;
                }
            }
        }
    }

    private void He(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.lXI.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.lXK != null) {
                this.lXK.dtE();
            }
        }
    }

    public void stopCamera() {
        try {
            dtR();
            if (this.mCamera != null) {
                this.lXI.dtK();
                this.lXI.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dtP() {
        Hf(1000);
    }

    public void Hf(int i) {
        this.lXL = true;
        this.mHandler.removeCallbacks(this.lXN);
        this.mHandler.postDelayed(this.lXN, i);
    }

    public void dtQ() {
        dtS();
        this.lXL = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.lXN);
        }
    }

    public void dtR() {
        dtQ();
        dtN();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.lXK = null;
        this.lXN = null;
    }

    protected void dtS() {
        if (this.lXM != null) {
            this.lXM.cancelTask();
            this.lXM = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.lXJ.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.lXL) {
            dtS();
            this.lXM = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.lXL) {
                        if (QRCodeView.this.lXK != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.lXK.Qj(str);
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
            }.dtL();
        }
    }
}
