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
    protected CameraPreview kGF;
    protected ScanBoxView kGG;
    protected a kGH;
    protected boolean kGI;
    protected c kGJ;
    private Runnable kGK;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void KP(String str);

        void cTr();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kGI = false;
        this.kGK = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.kGI) {
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
        this.kGF = new CameraPreview(getContext());
        this.kGG = new ScanBoxView(getContext());
        this.kGG.j(context, attributeSet);
        this.kGF.setId(R.id.bgaqrcode_camera_preview);
        addView(this.kGF);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.kGF.getId());
        layoutParams.addRule(8, this.kGF.getId());
        addView(this.kGG, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ff(context);
    }

    public void setDelegate(a aVar) {
        this.kGH = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.kGG;
    }

    public void cTz() {
        if (this.kGG != null) {
            this.kGG.setVisibility(0);
        }
    }

    public void cTA() {
        if (this.kGG != null) {
            this.kGG.setVisibility(8);
        }
    }

    public void cTB() {
        Cb(0);
    }

    public void Cb(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Cc(i2);
                    return;
                }
            }
        }
    }

    private void Cc(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.kGF.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.kGH != null) {
                this.kGH.cTr();
            }
        }
    }

    public void stopCamera() {
        try {
            cTE();
            if (this.mCamera != null) {
                this.kGF.cTx();
                this.kGF.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cTC() {
        Cd(1000);
    }

    public void Cd(int i) {
        this.kGI = true;
        this.mHandler.removeCallbacks(this.kGK);
        this.mHandler.postDelayed(this.kGK, i);
    }

    public void cTD() {
        cTF();
        this.kGI = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.kGK);
        }
    }

    public void cTE() {
        cTD();
        cTA();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.kGH = null;
        this.kGK = null;
    }

    protected void cTF() {
        if (this.kGJ != null) {
            this.kGJ.cancelTask();
            this.kGJ = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.kGG.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.kGI) {
            cTF();
            this.kGJ = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.kGI) {
                        if (QRCodeView.this.kGH != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.kGH.KP(str);
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
            }.cTy();
        }
    }
}
