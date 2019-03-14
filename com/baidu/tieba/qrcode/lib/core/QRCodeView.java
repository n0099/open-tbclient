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
    protected CameraPreview ieq;
    protected ScanBoxView ier;
    protected a ies;
    protected boolean iet;
    protected c ieu;
    private Runnable iev;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void Bi(String str);

        void bVS();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iet = false;
        this.iev = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iet) {
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
        this.ieq = new CameraPreview(getContext());
        this.ier = new ScanBoxView(getContext());
        this.ier.j(context, attributeSet);
        this.ieq.setId(d.g.bgaqrcode_camera_preview);
        addView(this.ieq);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.ieq.getId());
        layoutParams.addRule(8, this.ieq.getId());
        addView(this.ier, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.eo(context);
    }

    public void setDelegate(a aVar) {
        this.ies = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.ier;
    }

    public void bVY() {
        if (this.ier != null) {
            this.ier.setVisibility(0);
        }
    }

    public void bVZ() {
        if (this.ier != null) {
            this.ier.setVisibility(8);
        }
    }

    public void bWa() {
        xI(0);
    }

    public void xI(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    xJ(i2);
                    return;
                }
            }
        }
    }

    private void xJ(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.ieq.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.ies != null) {
                this.ies.bVS();
            }
        }
    }

    public void stopCamera() {
        try {
            bWd();
            if (this.mCamera != null) {
                this.ieq.bVW();
                this.ieq.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bWb() {
        xK(1000);
    }

    public void xK(int i) {
        this.iet = true;
        this.mHandler.removeCallbacks(this.iev);
        this.mHandler.postDelayed(this.iev, i);
    }

    public void bWc() {
        bWe();
        this.iet = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iev);
        }
    }

    public void bWd() {
        bWc();
        bVZ();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.ies = null;
        this.iev = null;
    }

    protected void bWe() {
        if (this.ieu != null) {
            this.ieu.hZ();
            this.ieu = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.ier.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iet) {
            bWe();
            this.ieu = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iet) {
                        if (QRCodeView.this.ies != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.ies.Bi(str);
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
            }.bVX();
        }
    }
}
