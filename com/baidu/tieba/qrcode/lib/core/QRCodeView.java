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
    protected CameraPreview jDa;
    protected ScanBoxView jDb;
    protected a jDc;
    protected boolean jDd;
    protected c jDe;
    private Runnable jDf;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void Hv(String str);

        void cBx();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDd = false;
        this.jDf = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.jDd) {
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
        this.jDa = new CameraPreview(getContext());
        this.jDb = new ScanBoxView(getContext());
        this.jDb.j(context, attributeSet);
        this.jDa.setId(R.id.bgaqrcode_camera_preview);
        addView(this.jDa);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.jDa.getId());
        layoutParams.addRule(8, this.jDa.getId());
        addView(this.jDb, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fl(context);
    }

    public void setDelegate(a aVar) {
        this.jDc = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.jDb;
    }

    public void cBF() {
        if (this.jDb != null) {
            this.jDb.setVisibility(0);
        }
    }

    public void cBG() {
        if (this.jDb != null) {
            this.jDb.setVisibility(8);
        }
    }

    public void cBH() {
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
            this.jDa.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.jDc != null) {
                this.jDc.cBx();
            }
        }
    }

    public void stopCamera() {
        try {
            cBK();
            if (this.mCamera != null) {
                this.jDa.cBD();
                this.jDa.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cBI() {
        AL(1000);
    }

    public void AL(int i) {
        this.jDd = true;
        this.mHandler.removeCallbacks(this.jDf);
        this.mHandler.postDelayed(this.jDf, i);
    }

    public void cBJ() {
        cBL();
        this.jDd = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jDf);
        }
    }

    public void cBK() {
        cBJ();
        cBG();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.jDc = null;
        this.jDf = null;
    }

    protected void cBL() {
        if (this.jDe != null) {
            this.jDe.cancelTask();
            this.jDe = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.jDb.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.jDd) {
            cBL();
            this.jDe = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.jDd) {
                        if (QRCodeView.this.jDc != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.jDc.Hv(str);
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
            }.cBE();
        }
    }
}
