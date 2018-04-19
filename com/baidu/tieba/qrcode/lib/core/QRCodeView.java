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
    protected CameraPreview fUf;
    protected ScanBoxView fUg;
    protected a fUh;
    protected boolean fUi;
    protected c fUj;
    private Runnable fUk;
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
        this.fUi = false;
        this.fUk = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.fUi) {
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
        this.fUf = new CameraPreview(getContext());
        this.fUg = new ScanBoxView(getContext());
        this.fUg.j(context, attributeSet);
        this.fUf.setId(d.g.bgaqrcode_camera_preview);
        addView(this.fUf);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.fUf.getId());
        layoutParams.addRule(8, this.fUf.getId());
        addView(this.fUg, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.bQ(context);
    }

    public void setDelegate(a aVar) {
        this.fUh = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.fUg;
    }

    public void biw() {
        if (this.fUg != null) {
            this.fUg.setVisibility(0);
        }
    }

    public void bix() {
        if (this.fUg != null) {
            this.fUg.setVisibility(8);
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
            this.fUf.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.fUh != null) {
                this.fUh.bis();
            }
        }
    }

    public void stopCamera() {
        try {
            biB();
            if (this.mCamera != null) {
                this.fUf.biu();
                this.fUf.setCamera(null);
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
        this.fUi = true;
        this.mHandler.removeCallbacks(this.fUk);
        this.mHandler.postDelayed(this.fUk, i);
    }

    public void biA() {
        biC();
        this.fUi = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.fUk);
        }
    }

    public void biB() {
        biA();
        bix();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.fUh = null;
        this.fUk = null;
    }

    protected void biC() {
        if (this.fUj != null) {
            this.fUj.dQ();
            this.fUj = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.fUg.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.fUi) {
            biC();
            this.fUj = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.fUi) {
                        if (QRCodeView.this.fUh != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.fUh.rG(str);
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
