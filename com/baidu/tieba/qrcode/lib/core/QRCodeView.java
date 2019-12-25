package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes7.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview jyC;
    protected ScanBoxView jyD;
    protected a jyE;
    protected boolean jyF;
    protected c jyG;
    private Runnable jyH;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes7.dex */
    public interface a {
        void GX(String str);

        void cyT();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jyF = false;
        this.jyH = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.jyF) {
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
        this.jyC = new CameraPreview(getContext());
        this.jyD = new ScanBoxView(getContext());
        this.jyD.j(context, attributeSet);
        this.jyC.setId(R.id.bgaqrcode_camera_preview);
        addView(this.jyC);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.jyC.getId());
        layoutParams.addRule(8, this.jyC.getId());
        addView(this.jyD, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fl(context);
    }

    public void setDelegate(a aVar) {
        this.jyE = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.jyD;
    }

    public void czb() {
        if (this.jyD != null) {
            this.jyD.setVisibility(0);
        }
    }

    public void czc() {
        if (this.jyD != null) {
            this.jyD.setVisibility(8);
        }
    }

    public void czd() {
        Av(0);
    }

    public void Av(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Aw(i2);
                    return;
                }
            }
        }
    }

    private void Aw(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.jyC.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.jyE != null) {
                this.jyE.cyT();
            }
        }
    }

    public void stopCamera() {
        try {
            czg();
            if (this.mCamera != null) {
                this.jyC.cyZ();
                this.jyC.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void cze() {
        Ax(1000);
    }

    public void Ax(int i) {
        this.jyF = true;
        this.mHandler.removeCallbacks(this.jyH);
        this.mHandler.postDelayed(this.jyH, i);
    }

    public void czf() {
        czh();
        this.jyF = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jyH);
        }
    }

    public void czg() {
        czf();
        czc();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.jyE = null;
        this.jyH = null;
    }

    protected void czh() {
        if (this.jyG != null) {
            this.jyG.cancelTask();
            this.jyG = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.jyD.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.jyF) {
            czh();
            this.jyG = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.jyF) {
                        if (QRCodeView.this.jyE != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.jyE.GX(str);
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
            }.cza();
        }
    }
}
