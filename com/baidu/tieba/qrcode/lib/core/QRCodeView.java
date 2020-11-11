package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes23.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;
    protected CameraPreview mqg;
    protected ScanBoxView mqh;
    protected a mqi;
    protected boolean mqj;
    protected c mqk;
    private Runnable mql;

    /* loaded from: classes23.dex */
    public interface a {
        void QY(String str);

        void dzn();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mqj = false;
        this.mql = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mqj) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.mqg = new CameraPreview(getContext());
        this.mqh = new ScanBoxView(getContext());
        this.mqh.j(context, attributeSet);
        this.mqg.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mqg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mqg.getId());
        layoutParams.addRule(8, this.mqg.getId());
        addView(this.mqh, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fK(context);
    }

    public void setDelegate(a aVar) {
        this.mqi = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mqh;
    }

    public void dzv() {
        if (this.mqh != null) {
            this.mqh.setVisibility(0);
        }
    }

    public void dzw() {
        if (this.mqh != null) {
            this.mqh.setVisibility(8);
        }
    }

    public void dzx() {
        HJ(0);
    }

    public void HJ(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    HK(i2);
                    return;
                }
            }
        }
    }

    private void HK(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mqg.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mqi != null) {
                this.mqi.dzn();
            }
        }
    }

    public void stopCamera() {
        try {
            dzA();
            if (this.mCamera != null) {
                this.mqg.dzt();
                this.mqg.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dzy() {
        HL(1000);
    }

    public void HL(int i) {
        this.mqj = true;
        this.mHandler.removeCallbacks(this.mql);
        this.mHandler.postDelayed(this.mql, i);
    }

    public void dzz() {
        dzB();
        this.mqj = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mql);
        }
    }

    public void dzA() {
        dzz();
        dzw();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mqi = null;
        this.mql = null;
    }

    protected void dzB() {
        if (this.mqk != null) {
            this.mqk.cancelTask();
            this.mqk = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mqh.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mqj) {
            dzB();
            this.mqk = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mqj) {
                        if (QRCodeView.this.mqi != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mqi.QY(str);
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
            }.dzu();
        }
    }
}
