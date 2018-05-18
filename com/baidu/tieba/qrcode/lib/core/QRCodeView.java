package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview fVi;
    protected ScanBoxView fVj;
    protected a fVk;
    protected boolean fVl;
    protected c fVm;
    private Runnable fVn;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bis();

        void rJ(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fVl = false;
        this.fVn = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.fVl) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        i(context, attributeSet);
    }

    private void i(Context context, AttributeSet attributeSet) {
        this.fVi = new CameraPreview(getContext());
        this.fVj = new ScanBoxView(getContext());
        this.fVj.j(context, attributeSet);
        this.fVi.setId(d.g.bgaqrcode_camera_preview);
        addView(this.fVi);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.fVi.getId());
        layoutParams.addRule(8, this.fVi.getId());
        addView(this.fVj, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.bQ(context);
    }

    public void setDelegate(a aVar) {
        this.fVk = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.fVj;
    }

    public void biw() {
        if (this.fVj != null) {
            this.fVj.setVisibility(0);
        }
    }

    public void bix() {
        if (this.fVj != null) {
            this.fVj.setVisibility(8);
        }
    }

    public void biy() {
        rF(0);
    }

    public void rF(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    rG(i2);
                    return;
                }
            }
        }
    }

    private void rG(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.fVi.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.fVk != null) {
                this.fVk.bis();
            }
        }
    }

    public void stopCamera() {
        try {
            biB();
            if (this.mCamera != null) {
                this.fVi.biu();
                this.fVi.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void biz() {
        rH(1000);
    }

    public void rH(int i) {
        this.fVl = true;
        this.mHandler.removeCallbacks(this.fVn);
        this.mHandler.postDelayed(this.fVn, i);
    }

    public void biA() {
        biC();
        this.fVl = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.fVn);
        }
    }

    public void biB() {
        biA();
        bix();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.fVk = null;
        this.fVn = null;
    }

    protected void biC() {
        if (this.fVm != null) {
            this.fVm.dQ();
            this.fVm = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.fVj.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.fVl) {
            biC();
            this.fVm = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.fVl) {
                        if (QRCodeView.this.fVk != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.fVk.rJ(str);
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
            }.biv();
        }
    }
}
