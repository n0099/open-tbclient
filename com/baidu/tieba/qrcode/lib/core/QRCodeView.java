package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes8.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview jCe;
    protected ScanBoxView jCf;
    protected a jCg;
    protected boolean jCh;
    protected c jCi;
    private Runnable jCj;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes8.dex */
    public interface a {
        void Hh(String str);

        void cAa();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCh = false;
        this.jCj = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.jCh) {
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
        this.jCe = new CameraPreview(getContext());
        this.jCf = new ScanBoxView(getContext());
        this.jCf.j(context, attributeSet);
        this.jCe.setId(R.id.bgaqrcode_camera_preview);
        addView(this.jCe);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.jCe.getId());
        layoutParams.addRule(8, this.jCe.getId());
        addView(this.jCf, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fl(context);
    }

    public void setDelegate(a aVar) {
        this.jCg = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.jCf;
    }

    public void cAi() {
        if (this.jCf != null) {
            this.jCf.setVisibility(0);
        }
    }

    public void cAj() {
        if (this.jCf != null) {
            this.jCf.setVisibility(8);
        }
    }

    public void cAk() {
        AA(0);
    }

    public void AA(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    AB(i2);
                    return;
                }
            }
        }
    }

    private void AB(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.jCe.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.jCg != null) {
                this.jCg.cAa();
            }
        }
    }

    public void stopCamera() {
        try {
            cAn();
            if (this.mCamera != null) {
                this.jCe.cAg();
                this.jCe.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cAl() {
        AC(1000);
    }

    public void AC(int i) {
        this.jCh = true;
        this.mHandler.removeCallbacks(this.jCj);
        this.mHandler.postDelayed(this.jCj, i);
    }

    public void cAm() {
        cAo();
        this.jCh = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jCj);
        }
    }

    public void cAn() {
        cAm();
        cAj();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.jCg = null;
        this.jCj = null;
    }

    protected void cAo() {
        if (this.jCi != null) {
            this.jCi.cancelTask();
            this.jCi = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.jCf.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.jCh) {
            cAo();
            this.jCi = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.jCh) {
                        if (QRCodeView.this.jCg != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.jCg.Hh(str);
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
            }.cAh();
        }
    }
}
