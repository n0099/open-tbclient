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
    protected CameraPreview mKb;
    protected ScanBoxView mKc;
    protected a mKd;
    protected boolean mKe;
    protected c mKf;
    private Runnable mKg;
    private int mOrientation;

    /* loaded from: classes8.dex */
    public interface a {
        void Ri(String str);

        void dDU();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKe = false;
        this.mKg = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mKe) {
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
        this.mKb = new CameraPreview(getContext());
        this.mKc = new ScanBoxView(getContext());
        this.mKc.l(context, attributeSet);
        this.mKb.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mKb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mKb.getId());
        layoutParams.addRule(8, this.mKb.getId());
        addView(this.mKc, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.gL(context);
    }

    public void setDelegate(a aVar) {
        this.mKd = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mKc;
    }

    public void dEc() {
        if (this.mKc != null) {
            this.mKc.setVisibility(0);
        }
    }

    public void dEd() {
        if (this.mKc != null) {
            this.mKc.setVisibility(8);
        }
    }

    public void dEe() {
        IS(0);
    }

    public void IS(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    IT(i2);
                    return;
                }
            }
        }
    }

    private void IT(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mKb.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mKd != null) {
                this.mKd.dDU();
            }
        }
    }

    public void stopCamera() {
        try {
            dEh();
            if (this.mCamera != null) {
                this.mKb.dEa();
                this.mKb.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dEf() {
        IU(1000);
    }

    public void IU(int i) {
        this.mKe = true;
        this.mHandler.removeCallbacks(this.mKg);
        this.mHandler.postDelayed(this.mKg, i);
    }

    public void dEg() {
        dEi();
        this.mKe = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mKg);
        }
    }

    public void dEh() {
        dEg();
        dEd();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mKd = null;
        this.mKg = null;
    }

    protected void dEi() {
        if (this.mKf != null) {
            this.mKf.cancelTask();
            this.mKf = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mKc.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mKe) {
            dEi();
            this.mKf = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mKe) {
                        if (QRCodeView.this.mKd != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mKd.Ri(str);
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
            }.dEb();
        }
    }
}
