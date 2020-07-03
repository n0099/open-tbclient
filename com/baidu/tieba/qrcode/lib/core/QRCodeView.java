package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes10.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview lbJ;
    protected ScanBoxView lbK;
    protected a lbL;
    protected boolean lbM;
    protected c lbN;
    private Runnable lbO;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void Lr(String str);

        void cXX();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lbM = false;
        this.lbO = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.lbM) {
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
        this.lbJ = new CameraPreview(getContext());
        this.lbK = new ScanBoxView(getContext());
        this.lbK.j(context, attributeSet);
        this.lbJ.setId(R.id.bgaqrcode_camera_preview);
        addView(this.lbJ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.lbJ.getId());
        layoutParams.addRule(8, this.lbJ.getId());
        addView(this.lbK, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ff(context);
    }

    public void setDelegate(a aVar) {
        this.lbL = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.lbK;
    }

    public void cYf() {
        if (this.lbK != null) {
            this.lbK.setVisibility(0);
        }
    }

    public void cYg() {
        if (this.lbK != null) {
            this.lbK.setVisibility(8);
        }
    }

    public void cYh() {
        Df(0);
    }

    public void Df(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Dg(i2);
                    return;
                }
            }
        }
    }

    private void Dg(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.lbJ.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.lbL != null) {
                this.lbL.cXX();
            }
        }
    }

    public void stopCamera() {
        try {
            cYk();
            if (this.mCamera != null) {
                this.lbJ.cYd();
                this.lbJ.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cYi() {
        Dh(1000);
    }

    public void Dh(int i) {
        this.lbM = true;
        this.mHandler.removeCallbacks(this.lbO);
        this.mHandler.postDelayed(this.lbO, i);
    }

    public void cYj() {
        cYl();
        this.lbM = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.lbO);
        }
    }

    public void cYk() {
        cYj();
        cYg();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.lbL = null;
        this.lbO = null;
    }

    protected void cYl() {
        if (this.lbN != null) {
            this.lbN.cancelTask();
            this.lbN = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.lbK.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.lbM) {
            cYl();
            this.lbN = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.lbM) {
                        if (QRCodeView.this.lbL != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.lbL.Lr(str);
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
            }.cYe();
        }
    }
}
