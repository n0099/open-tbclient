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
    protected CameraPreview fUc;
    protected ScanBoxView fUd;
    protected a fUe;
    protected boolean fUf;
    protected c fUg;
    private Runnable fUh;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bis();

        void rG(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fUf = false;
        this.fUh = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.fUf) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        i(context, attributeSet);
    }

    private void i(Context context, AttributeSet attributeSet) {
        this.fUc = new CameraPreview(getContext());
        this.fUd = new ScanBoxView(getContext());
        this.fUd.j(context, attributeSet);
        this.fUc.setId(d.g.bgaqrcode_camera_preview);
        addView(this.fUc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.fUc.getId());
        layoutParams.addRule(8, this.fUc.getId());
        addView(this.fUd, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.bQ(context);
    }

    public void setDelegate(a aVar) {
        this.fUe = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.fUd;
    }

    public void biw() {
        if (this.fUd != null) {
            this.fUd.setVisibility(0);
        }
    }

    public void bix() {
        if (this.fUd != null) {
            this.fUd.setVisibility(8);
        }
    }

    public void biy() {
        rG(0);
    }

    public void rG(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    rH(i2);
                    return;
                }
            }
        }
    }

    private void rH(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.fUc.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.fUe != null) {
                this.fUe.bis();
            }
        }
    }

    public void stopCamera() {
        try {
            biB();
            if (this.mCamera != null) {
                this.fUc.biu();
                this.fUc.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void biz() {
        rI(1000);
    }

    public void rI(int i) {
        this.fUf = true;
        this.mHandler.removeCallbacks(this.fUh);
        this.mHandler.postDelayed(this.fUh, i);
    }

    public void biA() {
        biC();
        this.fUf = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.fUh);
        }
    }

    public void biB() {
        biA();
        bix();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.fUe = null;
        this.fUh = null;
    }

    protected void biC() {
        if (this.fUg != null) {
            this.fUg.dQ();
            this.fUg = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.fUd.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.fUf) {
            biC();
            this.fUg = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.fUf) {
                        if (QRCodeView.this.fUe != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.fUe.rG(str);
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
            }.biv();
        }
    }
}
