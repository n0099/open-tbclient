package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.f;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview glK;
    protected ScanBoxView glL;
    protected a glM;
    protected boolean glN;
    protected c glO;
    private Runnable glP;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bmy();

        void sy(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.glN = false;
        this.glP = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.glN) {
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
        this.glK = new CameraPreview(getContext());
        this.glL = new ScanBoxView(getContext());
        this.glL.g(context, attributeSet);
        this.glK.setId(f.g.bgaqrcode_camera_preview);
        addView(this.glK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.glK.getId());
        layoutParams.addRule(8, this.glK.getId());
        addView(this.glL, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ca(context);
    }

    public void setDelegate(a aVar) {
        this.glM = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.glL;
    }

    public void bmD() {
        if (this.glL != null) {
            this.glL.setVisibility(0);
        }
    }

    public void bmE() {
        if (this.glL != null) {
            this.glL.setVisibility(8);
        }
    }

    public void bmF() {
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
            this.glK.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.glM != null) {
                this.glM.bmy();
            }
        }
    }

    public void stopCamera() {
        try {
            bmI();
            if (this.mCamera != null) {
                this.glK.bmB();
                this.glK.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bmG() {
        rZ(1000);
    }

    public void rZ(int i) {
        this.glN = true;
        this.mHandler.removeCallbacks(this.glP);
        this.mHandler.postDelayed(this.glP, i);
    }

    public void bmH() {
        bmJ();
        this.glN = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.glP);
        }
    }

    public void bmI() {
        bmH();
        bmE();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.glM = null;
        this.glP = null;
    }

    protected void bmJ() {
        if (this.glO != null) {
            this.glO.gG();
            this.glO = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.glL.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.glN) {
            bmJ();
            this.glO = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.glN) {
                        if (QRCodeView.this.glM != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.glM.sy(str);
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
            }.bmC();
        }
    }
}
