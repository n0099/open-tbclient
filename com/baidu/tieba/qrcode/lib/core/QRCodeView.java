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
    protected CameraPreview iEi;
    protected ScanBoxView iEj;
    protected a iEk;
    protected boolean iEl;
    protected c iEm;
    private Runnable iEn;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void Ci(String str);

        void ceN();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iEl = false;
        this.iEn = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iEl) {
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
        this.iEi = new CameraPreview(getContext());
        this.iEj = new ScanBoxView(getContext());
        this.iEj.j(context, attributeSet);
        this.iEi.setId(R.id.bgaqrcode_camera_preview);
        addView(this.iEi);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iEi.getId());
        layoutParams.addRule(8, this.iEi.getId());
        addView(this.iEj, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.dT(context);
    }

    public void setDelegate(a aVar) {
        this.iEk = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.iEj;
    }

    public void ceV() {
        if (this.iEj != null) {
            this.iEj.setVisibility(0);
        }
    }

    public void ceW() {
        if (this.iEj != null) {
            this.iEj.setVisibility(8);
        }
    }

    public void ceX() {
        xZ(0);
    }

    public void xZ(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    ya(i2);
                    return;
                }
            }
        }
    }

    private void ya(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.iEi.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iEk != null) {
                this.iEk.ceN();
            }
        }
    }

    public void stopCamera() {
        try {
            cfa();
            if (this.mCamera != null) {
                this.iEi.ceT();
                this.iEi.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void ceY() {
        yb(1000);
    }

    public void yb(int i) {
        this.iEl = true;
        this.mHandler.removeCallbacks(this.iEn);
        this.mHandler.postDelayed(this.iEn, i);
    }

    public void ceZ() {
        cfb();
        this.iEl = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iEn);
        }
    }

    public void cfa() {
        ceZ();
        ceW();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iEk = null;
        this.iEn = null;
    }

    protected void cfb() {
        if (this.iEm != null) {
            this.iEm.cancelTask();
            this.iEm = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.iEj.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iEl) {
            cfb();
            this.iEm = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iEl) {
                        if (QRCodeView.this.iEk != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iEk.Ci(str);
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
            }.ceU();
        }
    }
}
