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
    protected CameraPreview mkj;
    protected ScanBoxView mkk;
    protected a mkl;
    protected boolean mkm;
    protected c mkn;
    private Runnable mko;

    /* loaded from: classes23.dex */
    public interface a {
        void QH(String str);

        void dwL();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mkm = false;
        this.mko = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mkm) {
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
        this.mkj = new CameraPreview(getContext());
        this.mkk = new ScanBoxView(getContext());
        this.mkk.j(context, attributeSet);
        this.mkj.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mkj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mkj.getId());
        layoutParams.addRule(8, this.mkj.getId());
        addView(this.mkk, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fK(context);
    }

    public void setDelegate(a aVar) {
        this.mkl = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mkk;
    }

    public void dwT() {
        if (this.mkk != null) {
            this.mkk.setVisibility(0);
        }
    }

    public void dwU() {
        if (this.mkk != null) {
            this.mkk.setVisibility(8);
        }
    }

    public void dwV() {
        Hw(0);
    }

    public void Hw(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Hx(i2);
                    return;
                }
            }
        }
    }

    private void Hx(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mkj.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mkl != null) {
                this.mkl.dwL();
            }
        }
    }

    public void stopCamera() {
        try {
            dwY();
            if (this.mCamera != null) {
                this.mkj.dwR();
                this.mkj.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dwW() {
        Hy(1000);
    }

    public void Hy(int i) {
        this.mkm = true;
        this.mHandler.removeCallbacks(this.mko);
        this.mHandler.postDelayed(this.mko, i);
    }

    public void dwX() {
        dwZ();
        this.mkm = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mko);
        }
    }

    public void dwY() {
        dwX();
        dwU();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mkl = null;
        this.mko = null;
    }

    protected void dwZ() {
        if (this.mkn != null) {
            this.mkn.cancelTask();
            this.mkn = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mkk.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mkm) {
            dwZ();
            this.mkn = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mkm) {
                        if (QRCodeView.this.mkl != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mkl.QH(str);
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
            }.dwS();
        }
    }
}
