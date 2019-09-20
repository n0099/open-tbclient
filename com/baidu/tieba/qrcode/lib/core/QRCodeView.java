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
    protected CameraPreview iGD;
    protected ScanBoxView iGE;
    protected a iGF;
    protected boolean iGG;
    protected c iGH;
    private Runnable iGI;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void DP(String str);

        void chQ();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iGG = false;
        this.iGI = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iGG) {
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
        this.iGD = new CameraPreview(getContext());
        this.iGE = new ScanBoxView(getContext());
        this.iGE.j(context, attributeSet);
        this.iGD.setId(R.id.bgaqrcode_camera_preview);
        addView(this.iGD);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iGD.getId());
        layoutParams.addRule(8, this.iGD.getId());
        addView(this.iGE, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.eh(context);
    }

    public void setDelegate(a aVar) {
        this.iGF = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.iGE;
    }

    public void chY() {
        if (this.iGE != null) {
            this.iGE.setVisibility(0);
        }
    }

    public void chZ() {
        if (this.iGE != null) {
            this.iGE.setVisibility(8);
        }
    }

    public void cia() {
        zv(0);
    }

    public void zv(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    zw(i2);
                    return;
                }
            }
        }
    }

    private void zw(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.iGD.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iGF != null) {
                this.iGF.chQ();
            }
        }
    }

    public void stopCamera() {
        try {
            cid();
            if (this.mCamera != null) {
                this.iGD.chW();
                this.iGD.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cib() {
        zx(1000);
    }

    public void zx(int i) {
        this.iGG = true;
        this.mHandler.removeCallbacks(this.iGI);
        this.mHandler.postDelayed(this.iGI, i);
    }

    public void cic() {
        cie();
        this.iGG = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iGI);
        }
    }

    public void cid() {
        cic();
        chZ();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iGF = null;
        this.iGI = null;
    }

    protected void cie() {
        if (this.iGH != null) {
            this.iGH.hc();
            this.iGH = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.iGE.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iGG) {
            cie();
            this.iGH = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iGG) {
                        if (QRCodeView.this.iGF != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iGF.DP(str);
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
            }.chX();
        }
    }
}
