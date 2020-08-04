package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes17.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview lja;
    protected ScanBoxView ljb;
    protected a ljc;
    protected boolean ljd;
    protected c lje;
    private Runnable ljf;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes17.dex */
    public interface a {
        void LZ(String str);

        void dbf();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ljd = false;
        this.ljf = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.ljd) {
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
        this.lja = new CameraPreview(getContext());
        this.ljb = new ScanBoxView(getContext());
        this.ljb.j(context, attributeSet);
        this.lja.setId(R.id.bgaqrcode_camera_preview);
        addView(this.lja);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.lja.getId());
        layoutParams.addRule(8, this.lja.getId());
        addView(this.ljb, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fj(context);
    }

    public void setDelegate(a aVar) {
        this.ljc = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.ljb;
    }

    public void dbn() {
        if (this.ljb != null) {
            this.ljb.setVisibility(0);
        }
    }

    public void dbo() {
        if (this.ljb != null) {
            this.ljb.setVisibility(8);
        }
    }

    public void dbp() {
        DB(0);
    }

    public void DB(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    DC(i2);
                    return;
                }
            }
        }
    }

    private void DC(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.lja.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.ljc != null) {
                this.ljc.dbf();
            }
        }
    }

    public void stopCamera() {
        try {
            dbs();
            if (this.mCamera != null) {
                this.lja.dbl();
                this.lja.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dbq() {
        DD(1000);
    }

    public void DD(int i) {
        this.ljd = true;
        this.mHandler.removeCallbacks(this.ljf);
        this.mHandler.postDelayed(this.ljf, i);
    }

    public void dbr() {
        dbt();
        this.ljd = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ljf);
        }
    }

    public void dbs() {
        dbr();
        dbo();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.ljc = null;
        this.ljf = null;
    }

    protected void dbt() {
        if (this.lje != null) {
            this.lje.cancelTask();
            this.lje = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.ljb.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.ljd) {
            dbt();
            this.lje = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.ljd) {
                        if (QRCodeView.this.ljc != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.ljc.LZ(str);
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
            }.dbm();
        }
    }
}
