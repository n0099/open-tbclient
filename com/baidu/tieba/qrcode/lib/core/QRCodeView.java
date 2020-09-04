package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes17.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview lzE;
    protected ScanBoxView lzF;
    protected a lzG;
    protected boolean lzH;
    protected c lzI;
    private Runnable lzJ;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes17.dex */
    public interface a {
        void OT(String str);

        void dmm();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lzH = false;
        this.lzJ = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.lzH) {
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
        this.lzE = new CameraPreview(getContext());
        this.lzF = new ScanBoxView(getContext());
        this.lzF.j(context, attributeSet);
        this.lzE.setId(R.id.bgaqrcode_camera_preview);
        addView(this.lzE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.lzE.getId());
        layoutParams.addRule(8, this.lzE.getId());
        addView(this.lzF, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fw(context);
    }

    public void setDelegate(a aVar) {
        this.lzG = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.lzF;
    }

    public void dmu() {
        if (this.lzF != null) {
            this.lzF.setVisibility(0);
        }
    }

    public void dmv() {
        if (this.lzF != null) {
            this.lzF.setVisibility(8);
        }
    }

    public void dmw() {
        FW(0);
    }

    public void FW(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    FX(i2);
                    return;
                }
            }
        }
    }

    private void FX(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.lzE.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.lzG != null) {
                this.lzG.dmm();
            }
        }
    }

    public void stopCamera() {
        try {
            dmz();
            if (this.mCamera != null) {
                this.lzE.dms();
                this.lzE.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dmx() {
        FY(1000);
    }

    public void FY(int i) {
        this.lzH = true;
        this.mHandler.removeCallbacks(this.lzJ);
        this.mHandler.postDelayed(this.lzJ, i);
    }

    public void dmy() {
        dmA();
        this.lzH = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.lzJ);
        }
    }

    public void dmz() {
        dmy();
        dmv();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.lzG = null;
        this.lzJ = null;
    }

    protected void dmA() {
        if (this.lzI != null) {
            this.lzI.cancelTask();
            this.lzI = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.lzF.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.lzH) {
            dmA();
            this.lzI = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.lzH) {
                        if (QRCodeView.this.lzG != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.lzG.OT(str);
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
            }.dmt();
        }
    }
}
