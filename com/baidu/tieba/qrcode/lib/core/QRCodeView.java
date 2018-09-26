package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview gtc;
    protected ScanBoxView gtd;
    protected a gte;
    protected boolean gtf;
    protected c gtg;
    private Runnable gth;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bpf();

        void tf(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtf = false;
        this.gth = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.gtf) {
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
        this.gtc = new CameraPreview(getContext());
        this.gtd = new ScanBoxView(getContext());
        this.gtd.g(context, attributeSet);
        this.gtc.setId(e.g.bgaqrcode_camera_preview);
        addView(this.gtc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gtc.getId());
        layoutParams.addRule(8, this.gtc.getId());
        addView(this.gtd, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cH(context);
    }

    public void setDelegate(a aVar) {
        this.gte = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.gtd;
    }

    public void bpk() {
        if (this.gtd != null) {
            this.gtd.setVisibility(0);
        }
    }

    public void bpl() {
        if (this.gtd != null) {
            this.gtd.setVisibility(8);
        }
    }

    public void bpm() {
        su(0);
    }

    public void su(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    sv(i2);
                    return;
                }
            }
        }
    }

    private void sv(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gtc.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gte != null) {
                this.gte.bpf();
            }
        }
    }

    public void stopCamera() {
        try {
            bpp();
            if (this.mCamera != null) {
                this.gtc.bpi();
                this.gtc.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bpn() {
        sw(1000);
    }

    public void sw(int i) {
        this.gtf = true;
        this.mHandler.removeCallbacks(this.gth);
        this.mHandler.postDelayed(this.gth, i);
    }

    public void bpo() {
        bpq();
        this.gtf = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gth);
        }
    }

    public void bpp() {
        bpo();
        bpl();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gte = null;
        this.gth = null;
    }

    protected void bpq() {
        if (this.gtg != null) {
            this.gtg.hM();
            this.gtg = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gtd.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gtf) {
            bpq();
            this.gtg = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.gtf) {
                        if (QRCodeView.this.gte != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.gte.tf(str);
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
            }.bpj();
        }
    }
}
