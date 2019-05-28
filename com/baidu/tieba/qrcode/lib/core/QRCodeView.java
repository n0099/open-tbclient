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
    protected CameraPreview iwP;
    protected ScanBoxView iwQ;
    protected a iwR;
    protected boolean iwS;
    protected c iwT;
    private Runnable iwU;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void CA(String str);

        void cdS();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwS = false;
        this.iwU = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iwS) {
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
        this.iwP = new CameraPreview(getContext());
        this.iwQ = new ScanBoxView(getContext());
        this.iwQ.j(context, attributeSet);
        this.iwP.setId(R.id.bgaqrcode_camera_preview);
        addView(this.iwP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iwP.getId());
        layoutParams.addRule(8, this.iwP.getId());
        addView(this.iwQ, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ee(context);
    }

    public void setDelegate(a aVar) {
        this.iwR = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.iwQ;
    }

    public void cea() {
        if (this.iwQ != null) {
            this.iwQ.setVisibility(0);
        }
    }

    public void ceb() {
        if (this.iwQ != null) {
            this.iwQ.setVisibility(8);
        }
    }

    public void cec() {
        yL(0);
    }

    public void yL(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    yM(i2);
                    return;
                }
            }
        }
    }

    private void yM(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.iwP.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iwR != null) {
                this.iwR.cdS();
            }
        }
    }

    public void stopCamera() {
        try {
            cef();
            if (this.mCamera != null) {
                this.iwP.cdY();
                this.iwP.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void ced() {
        yN(1000);
    }

    public void yN(int i) {
        this.iwS = true;
        this.mHandler.removeCallbacks(this.iwU);
        this.mHandler.postDelayed(this.iwU, i);
    }

    public void cee() {
        ceg();
        this.iwS = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iwU);
        }
    }

    public void cef() {
        cee();
        ceb();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iwR = null;
        this.iwU = null;
    }

    protected void ceg() {
        if (this.iwT != null) {
            this.iwT.gT();
            this.iwT = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.iwQ.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iwS) {
            ceg();
            this.iwT = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iwS) {
                        if (QRCodeView.this.iwR != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iwR.CA(str);
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
            }.cdZ();
        }
    }
}
