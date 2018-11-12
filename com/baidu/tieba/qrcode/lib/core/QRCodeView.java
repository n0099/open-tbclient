package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview gCf;
    protected ScanBoxView gCg;
    protected a gCh;
    protected boolean gCi;
    protected c gCj;
    private Runnable gCk;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes3.dex */
    public interface a {
        void brQ();

        void tJ(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gCi = false;
        this.gCk = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.gCi) {
                    try {
                        QRCodeView.this.mCamera.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        e(context, attributeSet);
    }

    private void e(Context context, AttributeSet attributeSet) {
        this.gCf = new CameraPreview(getContext());
        this.gCg = new ScanBoxView(getContext());
        this.gCg.f(context, attributeSet);
        this.gCf.setId(e.g.bgaqrcode_camera_preview);
        addView(this.gCf);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gCf.getId());
        layoutParams.addRule(8, this.gCf.getId());
        addView(this.gCg, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.cP(context);
    }

    public void setDelegate(a aVar) {
        this.gCh = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.gCg;
    }

    public void brV() {
        if (this.gCg != null) {
            this.gCg.setVisibility(0);
        }
    }

    public void brW() {
        if (this.gCg != null) {
            this.gCg.setVisibility(8);
        }
    }

    public void brX() {
        tk(0);
    }

    public void tk(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    tl(i2);
                    return;
                }
            }
        }
    }

    private void tl(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gCf.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gCh != null) {
                this.gCh.brQ();
            }
        }
    }

    public void stopCamera() {
        try {
            bsa();
            if (this.mCamera != null) {
                this.gCf.brT();
                this.gCf.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void brY() {
        tm(1000);
    }

    public void tm(int i) {
        this.gCi = true;
        this.mHandler.removeCallbacks(this.gCk);
        this.mHandler.postDelayed(this.gCk, i);
    }

    public void brZ() {
        bsb();
        this.gCi = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gCk);
        }
    }

    public void bsa() {
        brZ();
        brW();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gCh = null;
        this.gCk = null;
    }

    protected void bsb() {
        if (this.gCj != null) {
            this.gCj.ia();
            this.gCj = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gCg.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gCi) {
            bsb();
            this.gCj = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.gCi) {
                        if (QRCodeView.this.gCh != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.gCh.tJ(str);
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
            }.brU();
        }
    }
}
