package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes10.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview koK;
    protected ScanBoxView koL;
    protected a koM;
    protected boolean koN;
    protected c koO;
    private Runnable koP;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void Jd(String str);

        void cMr();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.koN = false;
        this.koP = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.koN) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.koK = new CameraPreview(getContext());
        this.koL = new ScanBoxView(getContext());
        this.koL.j(context, attributeSet);
        this.koK.setId(R.id.bgaqrcode_camera_preview);
        addView(this.koK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.koK.getId());
        layoutParams.addRule(8, this.koK.getId());
        addView(this.koL, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.eQ(context);
    }

    public void setDelegate(a aVar) {
        this.koM = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.koL;
    }

    public void cMz() {
        if (this.koL != null) {
            this.koL.setVisibility(0);
        }
    }

    public void cMA() {
        if (this.koL != null) {
            this.koL.setVisibility(8);
        }
    }

    public void cMB() {
        Br(0);
    }

    public void Br(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Bs(i2);
                    return;
                }
            }
        }
    }

    private void Bs(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.koK.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.koM != null) {
                this.koM.cMr();
            }
        }
    }

    public void stopCamera() {
        try {
            cME();
            if (this.mCamera != null) {
                this.koK.cMx();
                this.koK.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cMC() {
        Bt(1000);
    }

    public void Bt(int i) {
        this.koN = true;
        this.mHandler.removeCallbacks(this.koP);
        this.mHandler.postDelayed(this.koP, i);
    }

    public void cMD() {
        cMF();
        this.koN = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.koP);
        }
    }

    public void cME() {
        cMD();
        cMA();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.koM = null;
        this.koP = null;
    }

    protected void cMF() {
        if (this.koO != null) {
            this.koO.cancelTask();
            this.koO = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.koL.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.koN) {
            cMF();
            this.koO = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.koN) {
                        if (QRCodeView.this.koM != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.koM.Jd(str);
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
            }.cMy();
        }
    }
}
