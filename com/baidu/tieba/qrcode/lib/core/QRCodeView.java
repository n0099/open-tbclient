package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes5.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview iec;
    protected ScanBoxView ied;
    protected a iee;
    protected boolean ief;
    protected c ieg;
    private Runnable ieh;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void Bh(String str);

        void bVO();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ief = false;
        this.ieh = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.ief) {
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
        this.iec = new CameraPreview(getContext());
        this.ied = new ScanBoxView(getContext());
        this.ied.j(context, attributeSet);
        this.iec.setId(d.g.bgaqrcode_camera_preview);
        addView(this.iec);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iec.getId());
        layoutParams.addRule(8, this.iec.getId());
        addView(this.ied, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.eo(context);
    }

    public void setDelegate(a aVar) {
        this.iee = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.ied;
    }

    public void bVU() {
        if (this.ied != null) {
            this.ied.setVisibility(0);
        }
    }

    public void bVV() {
        if (this.ied != null) {
            this.ied.setVisibility(8);
        }
    }

    public void bVW() {
        xE(0);
    }

    public void xE(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    xF(i2);
                    return;
                }
            }
        }
    }

    private void xF(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.iec.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iee != null) {
                this.iee.bVO();
            }
        }
    }

    public void stopCamera() {
        try {
            bVZ();
            if (this.mCamera != null) {
                this.iec.bVS();
                this.iec.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bVX() {
        xG(1000);
    }

    public void xG(int i) {
        this.ief = true;
        this.mHandler.removeCallbacks(this.ieh);
        this.mHandler.postDelayed(this.ieh, i);
    }

    public void bVY() {
        bWa();
        this.ief = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ieh);
        }
    }

    public void bVZ() {
        bVY();
        bVV();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iee = null;
        this.ieh = null;
    }

    protected void bWa() {
        if (this.ieg != null) {
            this.ieg.hZ();
            this.ieg = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.ied.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.ief) {
            bWa();
            this.ieg = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.ief) {
                        if (QRCodeView.this.iee != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iee.Bh(str);
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
            }.bVT();
        }
    }
}
