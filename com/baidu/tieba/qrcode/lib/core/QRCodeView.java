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
    protected CameraPreview iDi;
    protected ScanBoxView iDj;
    protected a iDk;
    protected boolean iDl;
    protected c iDm;
    private Runnable iDn;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void Dp(String str);

        void cgK();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iDl = false;
        this.iDn = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iDl) {
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
        this.iDi = new CameraPreview(getContext());
        this.iDj = new ScanBoxView(getContext());
        this.iDj.j(context, attributeSet);
        this.iDi.setId(R.id.bgaqrcode_camera_preview);
        addView(this.iDi);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iDi.getId());
        layoutParams.addRule(8, this.iDi.getId());
        addView(this.iDj, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ef(context);
    }

    public void setDelegate(a aVar) {
        this.iDk = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.iDj;
    }

    public void cgS() {
        if (this.iDj != null) {
            this.iDj.setVisibility(0);
        }
    }

    public void cgT() {
        if (this.iDj != null) {
            this.iDj.setVisibility(8);
        }
    }

    public void cgU() {
        zq(0);
    }

    public void zq(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    zr(i2);
                    return;
                }
            }
        }
    }

    private void zr(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.iDi.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iDk != null) {
                this.iDk.cgK();
            }
        }
    }

    public void stopCamera() {
        try {
            cgX();
            if (this.mCamera != null) {
                this.iDi.cgQ();
                this.iDi.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cgV() {
        zs(1000);
    }

    public void zs(int i) {
        this.iDl = true;
        this.mHandler.removeCallbacks(this.iDn);
        this.mHandler.postDelayed(this.iDn, i);
    }

    public void cgW() {
        cgY();
        this.iDl = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iDn);
        }
    }

    public void cgX() {
        cgW();
        cgT();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iDk = null;
        this.iDn = null;
    }

    protected void cgY() {
        if (this.iDm != null) {
            this.iDm.hc();
            this.iDm = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.iDj.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iDl) {
            cgY();
            this.iDm = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iDl) {
                        if (QRCodeView.this.iDk != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iDk.Dp(str);
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
            }.cgR();
        }
    }
}
