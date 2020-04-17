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
    protected CameraPreview koG;
    protected ScanBoxView koH;
    protected a koI;
    protected boolean koJ;
    protected c koK;
    private Runnable koL;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void Ja(String str);

        void cMt();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.koJ = false;
        this.koL = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.koJ) {
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
        this.koG = new CameraPreview(getContext());
        this.koH = new ScanBoxView(getContext());
        this.koH.j(context, attributeSet);
        this.koG.setId(R.id.bgaqrcode_camera_preview);
        addView(this.koG);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.koG.getId());
        layoutParams.addRule(8, this.koG.getId());
        addView(this.koH, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fc(context);
    }

    public void setDelegate(a aVar) {
        this.koI = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.koH;
    }

    public void cMB() {
        if (this.koH != null) {
            this.koH.setVisibility(0);
        }
    }

    public void cMC() {
        if (this.koH != null) {
            this.koH.setVisibility(8);
        }
    }

    public void cMD() {
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
            this.koG.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.koI != null) {
                this.koI.cMt();
            }
        }
    }

    public void stopCamera() {
        try {
            cMG();
            if (this.mCamera != null) {
                this.koG.cMz();
                this.koG.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cME() {
        Bt(1000);
    }

    public void Bt(int i) {
        this.koJ = true;
        this.mHandler.removeCallbacks(this.koL);
        this.mHandler.postDelayed(this.koL, i);
    }

    public void cMF() {
        cMH();
        this.koJ = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.koL);
        }
    }

    public void cMG() {
        cMF();
        cMC();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.koI = null;
        this.koL = null;
    }

    protected void cMH() {
        if (this.koK != null) {
            this.koK.cancelTask();
            this.koK = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.koH.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.koJ) {
            cMH();
            this.koK = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.koJ) {
                        if (QRCodeView.this.koI != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.koI.Ja(str);
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
            }.cMA();
        }
    }
}
