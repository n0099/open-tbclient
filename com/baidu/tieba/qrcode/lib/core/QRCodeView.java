package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes23.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected Camera mCamera;
    protected CameraPreview mEH;
    protected ScanBoxView mEI;
    protected a mEJ;
    protected boolean mEK;
    protected c mEL;
    private Runnable mEM;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes23.dex */
    public interface a {
        void RC(String str);

        void dEe();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEK = false;
        this.mEM = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mEK) {
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
        this.mEH = new CameraPreview(getContext());
        this.mEI = new ScanBoxView(getContext());
        this.mEI.j(context, attributeSet);
        this.mEH.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mEH);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mEH.getId());
        layoutParams.addRule(8, this.mEH.getId());
        addView(this.mEI, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.gs(context);
    }

    public void setDelegate(a aVar) {
        this.mEJ = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mEI;
    }

    public void dEm() {
        if (this.mEI != null) {
            this.mEI.setVisibility(0);
        }
    }

    public void dEn() {
        if (this.mEI != null) {
            this.mEI.setVisibility(8);
        }
    }

    public void dEo() {
        IY(0);
    }

    public void IY(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    IZ(i2);
                    return;
                }
            }
        }
    }

    private void IZ(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mEH.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mEJ != null) {
                this.mEJ.dEe();
            }
        }
    }

    public void stopCamera() {
        try {
            dEr();
            if (this.mCamera != null) {
                this.mEH.dEk();
                this.mEH.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dEp() {
        Ja(1000);
    }

    public void Ja(int i) {
        this.mEK = true;
        this.mHandler.removeCallbacks(this.mEM);
        this.mHandler.postDelayed(this.mEM, i);
    }

    public void dEq() {
        dEs();
        this.mEK = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mEM);
        }
    }

    public void dEr() {
        dEq();
        dEn();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mEJ = null;
        this.mEM = null;
    }

    protected void dEs() {
        if (this.mEL != null) {
            this.mEL.cancelTask();
            this.mEL = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mEI.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mEK) {
            dEs();
            this.mEL = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mEK) {
                        if (QRCodeView.this.mEJ != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mEJ.RC(str);
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
            }.dEl();
        }
    }
}
