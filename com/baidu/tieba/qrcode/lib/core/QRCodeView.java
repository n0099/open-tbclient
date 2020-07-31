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
    protected CameraPreview liY;
    protected ScanBoxView liZ;
    protected a lja;
    protected boolean ljb;
    protected c ljc;
    private Runnable ljd;
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
        this.ljb = false;
        this.ljd = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.ljb) {
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
        this.liY = new CameraPreview(getContext());
        this.liZ = new ScanBoxView(getContext());
        this.liZ.j(context, attributeSet);
        this.liY.setId(R.id.bgaqrcode_camera_preview);
        addView(this.liY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.liY.getId());
        layoutParams.addRule(8, this.liY.getId());
        addView(this.liZ, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fj(context);
    }

    public void setDelegate(a aVar) {
        this.lja = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.liZ;
    }

    public void dbn() {
        if (this.liZ != null) {
            this.liZ.setVisibility(0);
        }
    }

    public void dbo() {
        if (this.liZ != null) {
            this.liZ.setVisibility(8);
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
            this.liY.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.lja != null) {
                this.lja.dbf();
            }
        }
    }

    public void stopCamera() {
        try {
            dbs();
            if (this.mCamera != null) {
                this.liY.dbl();
                this.liY.setCamera(null);
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
        this.ljb = true;
        this.mHandler.removeCallbacks(this.ljd);
        this.mHandler.postDelayed(this.ljd, i);
    }

    public void dbr() {
        dbt();
        this.ljb = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ljd);
        }
    }

    public void dbs() {
        dbr();
        dbo();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.lja = null;
        this.ljd = null;
    }

    protected void dbt() {
        if (this.ljc != null) {
            this.ljc.cancelTask();
            this.ljc = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.liZ.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.ljb) {
            dbt();
            this.ljc = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.ljb) {
                        if (QRCodeView.this.lja != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.lja.LZ(str);
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
