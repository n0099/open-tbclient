package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview gIV;
    protected ScanBoxView gIW;
    protected a gIX;
    protected boolean gIY;
    protected c gIZ;
    private Runnable gJa;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void btI();

        void ul(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIY = false;
        this.gJa = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.gIY) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        c(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        this.gIV = new CameraPreview(getContext());
        this.gIW = new ScanBoxView(getContext());
        this.gIW.f(context, attributeSet);
        this.gIV.setId(e.g.bgaqrcode_camera_preview);
        addView(this.gIV);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gIV.getId());
        layoutParams.addRule(8, this.gIV.getId());
        addView(this.gIW, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cT(context);
    }

    public void setDelegate(a aVar) {
        this.gIX = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.gIW;
    }

    public void btN() {
        if (this.gIW != null) {
            this.gIW.setVisibility(0);
        }
    }

    public void btO() {
        if (this.gIW != null) {
            this.gIW.setVisibility(8);
        }
    }

    public void btP() {
        tE(0);
    }

    public void tE(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    tF(i2);
                    return;
                }
            }
        }
    }

    private void tF(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gIV.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gIX != null) {
                this.gIX.btI();
            }
        }
    }

    public void stopCamera() {
        try {
            btS();
            if (this.mCamera != null) {
                this.gIV.btL();
                this.gIV.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void btQ() {
        tG(1000);
    }

    public void tG(int i) {
        this.gIY = true;
        this.mHandler.removeCallbacks(this.gJa);
        this.mHandler.postDelayed(this.gJa, i);
    }

    public void btR() {
        btT();
        this.gIY = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gJa);
        }
    }

    public void btS() {
        btR();
        btO();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gIX = null;
        this.gJa = null;
    }

    protected void btT() {
        if (this.gIZ != null) {
            this.gIZ.ia();
            this.gIZ = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gIW.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gIY) {
            btT();
            this.gIZ = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.gIY) {
                        if (QRCodeView.this.gIX != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.gIX.ul(str);
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
            }.btM();
        }
    }
}
