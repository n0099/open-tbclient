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
    protected CameraPreview jDo;
    protected ScanBoxView jDp;
    protected a jDq;
    protected boolean jDr;
    protected c jDs;
    private Runnable jDt;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes10.dex */
    public interface a {
        void Hw(String str);

        void cBA();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDr = false;
        this.jDt = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.jDr) {
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
        this.jDo = new CameraPreview(getContext());
        this.jDp = new ScanBoxView(getContext());
        this.jDp.j(context, attributeSet);
        this.jDo.setId(R.id.bgaqrcode_camera_preview);
        addView(this.jDo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.jDo.getId());
        layoutParams.addRule(8, this.jDo.getId());
        addView(this.jDp, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fl(context);
    }

    public void setDelegate(a aVar) {
        this.jDq = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.jDp;
    }

    public void cBI() {
        if (this.jDp != null) {
            this.jDp.setVisibility(0);
        }
    }

    public void cBJ() {
        if (this.jDp != null) {
            this.jDp.setVisibility(8);
        }
    }

    public void cBK() {
        AJ(0);
    }

    public void AJ(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    AK(i2);
                    return;
                }
            }
        }
    }

    private void AK(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.jDo.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.jDq != null) {
                this.jDq.cBA();
            }
        }
    }

    public void stopCamera() {
        try {
            cBN();
            if (this.mCamera != null) {
                this.jDo.cBG();
                this.jDo.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cBL() {
        AL(1000);
    }

    public void AL(int i) {
        this.jDr = true;
        this.mHandler.removeCallbacks(this.jDt);
        this.mHandler.postDelayed(this.jDt, i);
    }

    public void cBM() {
        cBO();
        this.jDr = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jDt);
        }
    }

    public void cBN() {
        cBM();
        cBJ();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.jDq = null;
        this.jDt = null;
    }

    protected void cBO() {
        if (this.jDs != null) {
            this.jDs.cancelTask();
            this.jDs = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.jDp.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.jDr) {
            cBO();
            this.jDs = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.jDr) {
                        if (QRCodeView.this.jDq != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.jDq.Hw(str);
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
            }.cBH();
        }
    }
}
