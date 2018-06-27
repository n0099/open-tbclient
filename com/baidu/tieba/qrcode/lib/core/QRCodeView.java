package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected boolean gkA;
    protected c gkB;
    private Runnable gkC;
    protected CameraPreview gkx;
    protected ScanBoxView gky;
    protected a gkz;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void bnU();

        void sA(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkA = false;
        this.gkC = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.gkA) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        i(context, attributeSet);
    }

    private void i(Context context, AttributeSet attributeSet) {
        this.gkx = new CameraPreview(getContext());
        this.gky = new ScanBoxView(getContext());
        this.gky.j(context, attributeSet);
        this.gkx.setId(d.g.bgaqrcode_camera_preview);
        addView(this.gkx);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gkx.getId());
        layoutParams.addRule(8, this.gkx.getId());
        addView(this.gky, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.ca(context);
    }

    public void setDelegate(a aVar) {
        this.gkz = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.gky;
    }

    public void bnY() {
        if (this.gky != null) {
            this.gky.setVisibility(0);
        }
    }

    public void bnZ() {
        if (this.gky != null) {
            this.gky.setVisibility(8);
        }
    }

    public void boa() {
        sa(0);
    }

    public void sa(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    sb(i2);
                    return;
                }
            }
        }
    }

    private void sb(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gkx.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gkz != null) {
                this.gkz.bnU();
            }
        }
    }

    public void stopCamera() {
        try {
            bod();
            if (this.mCamera != null) {
                this.gkx.bnW();
                this.gkx.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bob() {
        sc(1000);
    }

    public void sc(int i) {
        this.gkA = true;
        this.mHandler.removeCallbacks(this.gkC);
        this.mHandler.postDelayed(this.gkC, i);
    }

    public void boc() {
        boe();
        this.gkA = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gkC);
        }
    }

    public void bod() {
        boc();
        bnZ();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gkz = null;
        this.gkC = null;
    }

    protected void boe() {
        if (this.gkB != null) {
            this.gkB.gH();
            this.gkB = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gky.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gkA) {
            boe();
            this.gkB = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.gkA) {
                        if (QRCodeView.this.gkz != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.gkz.sA(str);
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
            }.bnX();
        }
    }
}
