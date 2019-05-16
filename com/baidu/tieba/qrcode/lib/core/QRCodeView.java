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
    protected CameraPreview iwM;
    protected ScanBoxView iwN;
    protected a iwO;
    protected boolean iwP;
    protected c iwQ;
    private Runnable iwR;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes5.dex */
    public interface a {
        void CA(String str);

        void cdP();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwP = false;
        this.iwR = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.iwP) {
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
        this.iwM = new CameraPreview(getContext());
        this.iwN = new ScanBoxView(getContext());
        this.iwN.j(context, attributeSet);
        this.iwM.setId(R.id.bgaqrcode_camera_preview);
        addView(this.iwM);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.iwM.getId());
        layoutParams.addRule(8, this.iwM.getId());
        addView(this.iwN, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ee(context);
    }

    public void setDelegate(a aVar) {
        this.iwO = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.iwN;
    }

    public void cdX() {
        if (this.iwN != null) {
            this.iwN.setVisibility(0);
        }
    }

    public void cdY() {
        if (this.iwN != null) {
            this.iwN.setVisibility(8);
        }
    }

    public void cdZ() {
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
            this.iwM.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.iwO != null) {
                this.iwO.cdP();
            }
        }
    }

    public void stopCamera() {
        try {
            cec();
            if (this.mCamera != null) {
                this.iwM.cdV();
                this.iwM.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cea() {
        yN(1000);
    }

    public void yN(int i) {
        this.iwP = true;
        this.mHandler.removeCallbacks(this.iwR);
        this.mHandler.postDelayed(this.iwR, i);
    }

    public void ceb() {
        ced();
        this.iwP = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iwR);
        }
    }

    public void cec() {
        ceb();
        cdY();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.iwO = null;
        this.iwR = null;
    }

    protected void ced() {
        if (this.iwQ != null) {
            this.iwQ.gT();
            this.iwQ = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.iwN.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.iwP) {
            ced();
            this.iwQ = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.iwP) {
                        if (QRCodeView.this.iwO != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.iwO.CA(str);
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
            }.cdW();
        }
    }
}
