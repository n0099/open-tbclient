package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes5.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview iEm;
    protected ScanBoxView iEn;
    protected a iEo;
    protected boolean iEp;
    protected c iEq;
    private Runnable iEr;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void Dq(String str);

        void chc();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iEp = false;
        this.iEr = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iEp) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        d(context, attributeSet);
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.iEm = new CameraPreview(getContext());
        this.iEn = new ScanBoxView(getContext());
        this.iEn.j(context, attributeSet);
        this.iEm.setId(R.id.bgaqrcode_camera_preview);
        addView(this.iEm);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iEm.getId());
        layoutParams.addRule(8, this.iEm.getId());
        addView(this.iEn, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.eg(context);
    }

    public void setDelegate(a aVar) {
        this.iEo = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.iEn;
    }

    public void chk() {
        if (this.iEn != null) {
            this.iEn.setVisibility(0);
        }
    }

    public void chl() {
        if (this.iEn != null) {
            this.iEn.setVisibility(8);
        }
    }

    public void chm() {
        zs(0);
    }

    public void zs(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    zt(i2);
                    return;
                }
            }
        }
    }

    private void zt(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.iEm.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iEo != null) {
                this.iEo.chc();
            }
        }
    }

    public void stopCamera() {
        try {
            chp();
            if (this.mCamera != null) {
                this.iEm.chi();
                this.iEm.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void chn() {
        zu(1000);
    }

    public void zu(int i) {
        this.iEp = true;
        this.mHandler.removeCallbacks(this.iEr);
        this.mHandler.postDelayed(this.iEr, i);
    }

    public void cho() {
        chq();
        this.iEp = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iEr);
        }
    }

    public void chp() {
        cho();
        chl();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iEo = null;
        this.iEr = null;
    }

    protected void chq() {
        if (this.iEq != null) {
            this.iEq.hc();
            this.iEq = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.iEn.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iEp) {
            chq();
            this.iEq = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iEp) {
                        if (QRCodeView.this.iEo != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iEo.Dq(str);
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
            }.chj();
        }
    }
}
