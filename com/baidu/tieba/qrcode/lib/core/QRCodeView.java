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
    protected CameraPreview mKa;
    protected ScanBoxView mKb;
    protected a mKc;
    protected boolean mKd;
    protected c mKe;
    private Runnable mKf;
    private int mOrientation;

    /* loaded from: classes8.dex */
    public interface a {
        void Rh(String str);

        void dDV();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKd = false;
        this.mKf = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mKd) {
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
        this.mKa = new CameraPreview(getContext());
        this.mKb = new ScanBoxView(getContext());
        this.mKb.l(context, attributeSet);
        this.mKa.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mKa);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mKa.getId());
        layoutParams.addRule(8, this.mKa.getId());
        addView(this.mKb, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.gL(context);
    }

    public void setDelegate(a aVar) {
        this.mKc = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mKb;
    }

    public void dEd() {
        if (this.mKb != null) {
            this.mKb.setVisibility(0);
        }
    }

    public void dEe() {
        if (this.mKb != null) {
            this.mKb.setVisibility(8);
        }
    }

    public void dEf() {
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
            this.mKa.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mKc != null) {
                this.mKc.dDV();
            }
        }
    }

    public void stopCamera() {
        try {
            dEi();
            if (this.mCamera != null) {
                this.mKa.dEb();
                this.mKa.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dEg() {
        IU(1000);
    }

    public void IU(int i) {
        this.mKd = true;
        this.mHandler.removeCallbacks(this.mKf);
        this.mHandler.postDelayed(this.mKf, i);
    }

    public void dEh() {
        dEj();
        this.mKd = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mKf);
        }
    }

    public void dEi() {
        dEh();
        dEe();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mKc = null;
        this.mKf = null;
    }

    protected void dEj() {
        if (this.mKe != null) {
            this.mKe.cancelTask();
            this.mKe = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mKb.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mKd) {
            dEj();
            this.mKe = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mKd) {
                        if (QRCodeView.this.mKc != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mKc.Rh(str);
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
            }.dEc();
        }
    }
}
