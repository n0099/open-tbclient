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
    protected CameraPreview iEZ;
    protected ScanBoxView iFa;
    protected a iFb;
    protected boolean iFc;
    protected c iFd;
    private Runnable iFe;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void Ci(String str);

        void ceP();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iFc = false;
        this.iFe = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iFc) {
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
        this.iEZ = new CameraPreview(getContext());
        this.iFa = new ScanBoxView(getContext());
        this.iFa.j(context, attributeSet);
        this.iEZ.setId(R.id.bgaqrcode_camera_preview);
        addView(this.iEZ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iEZ.getId());
        layoutParams.addRule(8, this.iEZ.getId());
        addView(this.iFa, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.dT(context);
    }

    public void setDelegate(a aVar) {
        this.iFb = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.iFa;
    }

    public void ceX() {
        if (this.iFa != null) {
            this.iFa.setVisibility(0);
        }
    }

    public void ceY() {
        if (this.iFa != null) {
            this.iFa.setVisibility(8);
        }
    }

    public void ceZ() {
        ya(0);
    }

    public void ya(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    yb(i2);
                    return;
                }
            }
        }
    }

    private void yb(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.iEZ.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iFb != null) {
                this.iFb.ceP();
            }
        }
    }

    public void stopCamera() {
        try {
            cfc();
            if (this.mCamera != null) {
                this.iEZ.ceV();
                this.iEZ.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cfa() {
        yc(1000);
    }

    public void yc(int i) {
        this.iFc = true;
        this.mHandler.removeCallbacks(this.iFe);
        this.mHandler.postDelayed(this.iFe, i);
    }

    public void cfb() {
        cfd();
        this.iFc = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iFe);
        }
    }

    public void cfc() {
        cfb();
        ceY();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iFb = null;
        this.iFe = null;
    }

    protected void cfd() {
        if (this.iFd != null) {
            this.iFd.cancelTask();
            this.iFd = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.iFa.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iFc) {
            cfd();
            this.iFd = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iFc) {
                        if (QRCodeView.this.iFb != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iFb.Ci(str);
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
            }.ceW();
        }
    }
}
