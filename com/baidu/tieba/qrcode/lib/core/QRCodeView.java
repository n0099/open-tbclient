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
    protected CameraPreview jCj;
    protected ScanBoxView jCk;
    protected a jCl;
    protected boolean jCm;
    protected c jCn;
    private Runnable jCo;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes8.dex */
    public interface a {
        void Hh(String str);

        void cAc();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCm = false;
        this.jCo = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.jCm) {
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
        this.jCj = new CameraPreview(getContext());
        this.jCk = new ScanBoxView(getContext());
        this.jCk.j(context, attributeSet);
        this.jCj.setId(R.id.bgaqrcode_camera_preview);
        addView(this.jCj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.jCj.getId());
        layoutParams.addRule(8, this.jCj.getId());
        addView(this.jCk, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fl(context);
    }

    public void setDelegate(a aVar) {
        this.jCl = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.jCk;
    }

    public void cAk() {
        if (this.jCk != null) {
            this.jCk.setVisibility(0);
        }
    }

    public void cAl() {
        if (this.jCk != null) {
            this.jCk.setVisibility(8);
        }
    }

    public void cAm() {
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
            this.jCj.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.jCl != null) {
                this.jCl.cAc();
            }
        }
    }

    public void stopCamera() {
        try {
            cAp();
            if (this.mCamera != null) {
                this.jCj.cAi();
                this.jCj.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cAn() {
        AC(1000);
    }

    public void AC(int i) {
        this.jCm = true;
        this.mHandler.removeCallbacks(this.jCo);
        this.mHandler.postDelayed(this.jCo, i);
    }

    public void cAo() {
        cAq();
        this.jCm = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jCo);
        }
    }

    public void cAp() {
        cAo();
        cAl();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.jCl = null;
        this.jCo = null;
    }

    protected void cAq() {
        if (this.jCn != null) {
            this.jCn.cancelTask();
            this.jCn = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.jCk.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.jCm) {
            cAq();
            this.jCn = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.jCm) {
                        if (QRCodeView.this.jCl != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.jCl.Hh(str);
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
            }.cAj();
        }
    }
}
