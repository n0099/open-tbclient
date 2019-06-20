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
    protected CameraPreview iwQ;
    protected ScanBoxView iwR;
    protected a iwS;
    protected boolean iwT;
    protected c iwU;
    private Runnable iwV;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void CC(String str);

        void cdT();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwT = false;
        this.iwV = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iwT) {
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
        this.iwQ = new CameraPreview(getContext());
        this.iwR = new ScanBoxView(getContext());
        this.iwR.j(context, attributeSet);
        this.iwQ.setId(R.id.bgaqrcode_camera_preview);
        addView(this.iwQ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iwQ.getId());
        layoutParams.addRule(8, this.iwQ.getId());
        addView(this.iwR, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ee(context);
    }

    public void setDelegate(a aVar) {
        this.iwS = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.iwR;
    }

    public void ceb() {
        if (this.iwR != null) {
            this.iwR.setVisibility(0);
        }
    }

    public void cec() {
        if (this.iwR != null) {
            this.iwR.setVisibility(8);
        }
    }

    public void ced() {
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
            this.iwQ.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iwS != null) {
                this.iwS.cdT();
            }
        }
    }

    public void stopCamera() {
        try {
            ceg();
            if (this.mCamera != null) {
                this.iwQ.cdZ();
                this.iwQ.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cee() {
        yN(1000);
    }

    public void yN(int i) {
        this.iwT = true;
        this.mHandler.removeCallbacks(this.iwV);
        this.mHandler.postDelayed(this.iwV, i);
    }

    public void cef() {
        ceh();
        this.iwT = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iwV);
        }
    }

    public void ceg() {
        cef();
        cec();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iwS = null;
        this.iwV = null;
    }

    protected void ceh() {
        if (this.iwU != null) {
            this.iwU.gT();
            this.iwU = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.iwR.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iwT) {
            ceh();
            this.iwU = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iwT) {
                        if (QRCodeView.this.iwS != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iwS.CC(str);
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
            }.cea();
        }
    }
}
