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
    protected CameraPreview mEJ;
    protected ScanBoxView mEK;
    protected a mEL;
    protected boolean mEM;
    protected c mEN;
    private Runnable mEO;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes23.dex */
    public interface a {
        void RC(String str);

        void dEf();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEM = false;
        this.mEO = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mEM) {
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
        this.mEJ = new CameraPreview(getContext());
        this.mEK = new ScanBoxView(getContext());
        this.mEK.j(context, attributeSet);
        this.mEJ.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mEJ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mEJ.getId());
        layoutParams.addRule(8, this.mEJ.getId());
        addView(this.mEK, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.gs(context);
    }

    public void setDelegate(a aVar) {
        this.mEL = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mEK;
    }

    public void dEn() {
        if (this.mEK != null) {
            this.mEK.setVisibility(0);
        }
    }

    public void dEo() {
        if (this.mEK != null) {
            this.mEK.setVisibility(8);
        }
    }

    public void dEp() {
        IY(0);
    }

    public void IY(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    IZ(i2);
                    return;
                }
            }
        }
    }

    private void IZ(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mEJ.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mEL != null) {
                this.mEL.dEf();
            }
        }
    }

    public void stopCamera() {
        try {
            dEs();
            if (this.mCamera != null) {
                this.mEJ.dEl();
                this.mEJ.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dEq() {
        Ja(1000);
    }

    public void Ja(int i) {
        this.mEM = true;
        this.mHandler.removeCallbacks(this.mEO);
        this.mHandler.postDelayed(this.mEO, i);
    }

    public void dEr() {
        dEt();
        this.mEM = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mEO);
        }
    }

    public void dEs() {
        dEr();
        dEo();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mEL = null;
        this.mEO = null;
    }

    protected void dEt() {
        if (this.mEN != null) {
            this.mEN.cancelTask();
            this.mEN = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mEK.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mEM) {
            dEt();
            this.mEN = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mEM) {
                        if (QRCodeView.this.mEL != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mEL.RC(str);
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
            }.dEm();
        }
    }
}
