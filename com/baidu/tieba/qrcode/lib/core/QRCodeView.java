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
    protected CameraPreview lzt;
    protected ScanBoxView lzu;
    protected a lzv;
    protected boolean lzw;
    protected c lzx;
    private Runnable lzy;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes17.dex */
    public interface a {
        void OS(String str);

        void dmj();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lzw = false;
        this.lzy = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.lzw) {
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
        this.lzt = new CameraPreview(getContext());
        this.lzu = new ScanBoxView(getContext());
        this.lzu.j(context, attributeSet);
        this.lzt.setId(R.id.bgaqrcode_camera_preview);
        addView(this.lzt);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.lzt.getId());
        layoutParams.addRule(8, this.lzt.getId());
        addView(this.lzu, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fw(context);
    }

    public void setDelegate(a aVar) {
        this.lzv = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.lzu;
    }

    public void dmr() {
        if (this.lzu != null) {
            this.lzu.setVisibility(0);
        }
    }

    public void dms() {
        if (this.lzu != null) {
            this.lzu.setVisibility(8);
        }
    }

    public void dmt() {
        FW(0);
    }

    public void FW(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    FX(i2);
                    return;
                }
            }
        }
    }

    private void FX(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.lzt.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.lzv != null) {
                this.lzv.dmj();
            }
        }
    }

    public void stopCamera() {
        try {
            dmw();
            if (this.mCamera != null) {
                this.lzt.dmp();
                this.lzt.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dmu() {
        FY(1000);
    }

    public void FY(int i) {
        this.lzw = true;
        this.mHandler.removeCallbacks(this.lzy);
        this.mHandler.postDelayed(this.lzy, i);
    }

    public void dmv() {
        dmx();
        this.lzw = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.lzy);
        }
    }

    public void dmw() {
        dmv();
        dms();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.lzv = null;
        this.lzy = null;
    }

    protected void dmx() {
        if (this.lzx != null) {
            this.lzx.cancelTask();
            this.lzx = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.lzu.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.lzw) {
            dmx();
            this.lzx = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.lzw) {
                        if (QRCodeView.this.lzv != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.lzv.OS(str);
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
            }.dmq();
        }
    }
}
