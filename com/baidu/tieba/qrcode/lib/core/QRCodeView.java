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
    protected CameraPreview jDc;
    protected ScanBoxView jDd;
    protected a jDe;
    protected boolean jDf;
    protected c jDg;
    private Runnable jDh;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void Hv(String str);

        void cBz();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDf = false;
        this.jDh = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.jDf) {
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
        this.jDc = new CameraPreview(getContext());
        this.jDd = new ScanBoxView(getContext());
        this.jDd.j(context, attributeSet);
        this.jDc.setId(R.id.bgaqrcode_camera_preview);
        addView(this.jDc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.jDc.getId());
        layoutParams.addRule(8, this.jDc.getId());
        addView(this.jDd, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fl(context);
    }

    public void setDelegate(a aVar) {
        this.jDe = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.jDd;
    }

    public void cBH() {
        if (this.jDd != null) {
            this.jDd.setVisibility(0);
        }
    }

    public void cBI() {
        if (this.jDd != null) {
            this.jDd.setVisibility(8);
        }
    }

    public void cBJ() {
        AJ(0);
    }

    public void AJ(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    AK(i2);
                    return;
                }
            }
        }
    }

    private void AK(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.jDc.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.jDe != null) {
                this.jDe.cBz();
            }
        }
    }

    public void stopCamera() {
        try {
            cBM();
            if (this.mCamera != null) {
                this.jDc.cBF();
                this.jDc.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cBK() {
        AL(1000);
    }

    public void AL(int i) {
        this.jDf = true;
        this.mHandler.removeCallbacks(this.jDh);
        this.mHandler.postDelayed(this.jDh, i);
    }

    public void cBL() {
        cBN();
        this.jDf = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jDh);
        }
    }

    public void cBM() {
        cBL();
        cBI();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.jDe = null;
        this.jDh = null;
    }

    protected void cBN() {
        if (this.jDg != null) {
            this.jDg.cancelTask();
            this.jDg = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.jDd.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.jDf) {
            cBN();
            this.jDg = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.jDf) {
                        if (QRCodeView.this.jDe != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.jDe.Hv(str);
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
            }.cBG();
        }
    }
}
