package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes8.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected Camera mCamera;
    protected Handler mHandler;
    private Runnable mOA;
    private int mOrientation;
    protected CameraPreview mOv;
    protected ScanBoxView mOw;
    protected a mOx;
    protected boolean mOy;
    protected c mOz;

    /* loaded from: classes8.dex */
    public interface a {
        void QR(String str);

        void dCn();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOy = false;
        this.mOA = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mOy) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        j(context, attributeSet);
    }

    private void j(Context context, AttributeSet attributeSet) {
        this.mOv = new CameraPreview(getContext());
        this.mOw = new ScanBoxView(getContext());
        this.mOw.l(context, attributeSet);
        this.mOv.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mOv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mOv.getId());
        layoutParams.addRule(8, this.mOv.getId());
        addView(this.mOw, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.gM(context);
    }

    public void setDelegate(a aVar) {
        this.mOx = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mOw;
    }

    public void dCv() {
        if (this.mOw != null) {
            this.mOw.setVisibility(0);
        }
    }

    public void dCw() {
        if (this.mOw != null) {
            this.mOw.setVisibility(8);
        }
    }

    public void dCx() {
        HD(0);
    }

    public void HD(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    HE(i2);
                    return;
                }
            }
        }
    }

    private void HE(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mOv.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mOx != null) {
                this.mOx.dCn();
            }
        }
    }

    public void stopCamera() {
        try {
            dCA();
            if (this.mCamera != null) {
                this.mOv.dCt();
                this.mOv.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dCy() {
        HF(1000);
    }

    public void HF(int i) {
        this.mOy = true;
        this.mHandler.removeCallbacks(this.mOA);
        this.mHandler.postDelayed(this.mOA, i);
    }

    public void dCz() {
        dCB();
        this.mOy = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mOA);
        }
    }

    public void dCA() {
        dCz();
        dCw();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mOx = null;
        this.mOA = null;
    }

    protected void dCB() {
        if (this.mOz != null) {
            this.mOz.cancelTask();
            this.mOz = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mOw.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mOy) {
            dCB();
            this.mOz = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mOy) {
                        if (QRCodeView.this.mOx != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mOx.QR(str);
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
            }.dCu();
        }
    }
}
