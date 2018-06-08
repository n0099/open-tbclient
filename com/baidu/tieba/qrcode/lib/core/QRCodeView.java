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
    protected boolean ggA;
    protected c ggB;
    private Runnable ggC;
    protected CameraPreview ggx;
    protected ScanBoxView ggy;
    protected a ggz;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bnq();

        void sB(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggA = false;
        this.ggC = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.ggA) {
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
        this.ggx = new CameraPreview(getContext());
        this.ggy = new ScanBoxView(getContext());
        this.ggy.j(context, attributeSet);
        this.ggx.setId(d.g.bgaqrcode_camera_preview);
        addView(this.ggx);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.ggx.getId());
        layoutParams.addRule(8, this.ggx.getId());
        addView(this.ggy, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cb(context);
    }

    public void setDelegate(a aVar) {
        this.ggz = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.ggy;
    }

    public void bnu() {
        if (this.ggy != null) {
            this.ggy.setVisibility(0);
        }
    }

    public void bnv() {
        if (this.ggy != null) {
            this.ggy.setVisibility(8);
        }
    }

    public void bnw() {
        rR(0);
    }

    public void rR(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    rS(i2);
                    return;
                }
            }
        }
    }

    private void rS(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.ggx.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.ggz != null) {
                this.ggz.bnq();
            }
        }
    }

    public void stopCamera() {
        try {
            bnz();
            if (this.mCamera != null) {
                this.ggx.bns();
                this.ggx.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bnx() {
        rT(1000);
    }

    public void rT(int i) {
        this.ggA = true;
        this.mHandler.removeCallbacks(this.ggC);
        this.mHandler.postDelayed(this.ggC, i);
    }

    public void bny() {
        bnA();
        this.ggA = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ggC);
        }
    }

    public void bnz() {
        bny();
        bnv();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.ggz = null;
        this.ggC = null;
    }

    protected void bnA() {
        if (this.ggB != null) {
            this.ggB.gH();
            this.ggB = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.ggy.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.ggA) {
            bnA();
            this.ggB = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.ggA) {
                        if (QRCodeView.this.ggz != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.ggz.sB(str);
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
            }.bnt();
        }
    }
}
