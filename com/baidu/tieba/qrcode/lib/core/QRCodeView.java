package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes7.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected Camera mCamera;
    protected CameraPreview mFq;
    protected ScanBoxView mFr;
    protected a mFs;
    protected boolean mFt;
    protected c mFu;
    private Runnable mFv;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes7.dex */
    public interface a {
        void PZ(String str);

        void dAd();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFt = false;
        this.mFv = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mFt) {
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
        this.mFq = new CameraPreview(getContext());
        this.mFr = new ScanBoxView(getContext());
        this.mFr.l(context, attributeSet);
        this.mFq.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mFq);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mFq.getId());
        layoutParams.addRule(8, this.mFq.getId());
        addView(this.mFr, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.gJ(context);
    }

    public void setDelegate(a aVar) {
        this.mFs = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mFr;
    }

    public void dAl() {
        if (this.mFr != null) {
            this.mFr.setVisibility(0);
        }
    }

    public void dAm() {
        if (this.mFr != null) {
            this.mFr.setVisibility(8);
        }
    }

    public void dAn() {
        Hl(0);
    }

    public void Hl(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Hm(i2);
                    return;
                }
            }
        }
    }

    private void Hm(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mFq.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mFs != null) {
                this.mFs.dAd();
            }
        }
    }

    public void stopCamera() {
        try {
            dAq();
            if (this.mCamera != null) {
                this.mFq.dAj();
                this.mFq.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dAo() {
        Hn(1000);
    }

    public void Hn(int i) {
        this.mFt = true;
        this.mHandler.removeCallbacks(this.mFv);
        this.mHandler.postDelayed(this.mFv, i);
    }

    public void dAp() {
        dAr();
        this.mFt = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mFv);
        }
    }

    public void dAq() {
        dAp();
        dAm();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mFs = null;
        this.mFv = null;
    }

    protected void dAr() {
        if (this.mFu != null) {
            this.mFu.cancelTask();
            this.mFu = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mFr.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mFt) {
            dAr();
            this.mFu = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mFt) {
                        if (QRCodeView.this.mFs != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mFs.PZ(str);
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
            }.dAk();
        }
    }
}
