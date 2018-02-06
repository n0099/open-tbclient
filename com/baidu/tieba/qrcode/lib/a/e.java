package com.baidu.tieba.qrcode.lib.a;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.a.d;
/* loaded from: classes3.dex */
public abstract class e extends RelativeLayout implements Camera.PreviewCallback, d.a {
    private int As;
    protected c gzn;
    protected f gzo;
    protected a gzp;
    protected boolean gzq;
    protected d gzr;
    private Runnable gzs;
    protected Camera mCamera;
    protected Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void bnm();

        void rA(String str);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzq = false;
        this.gzs = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mCamera != null && e.this.gzq) {
                    try {
                        e.this.mCamera.setOneShotPreviewCallback(e.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mHandler = new Handler();
        f(context, attributeSet);
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.gzn = new c(getContext());
        this.gzo = new f(getContext());
        this.gzo.g(context, attributeSet);
        this.gzn.setId(d.g.bgaqrcode_camera_preview);
        addView(this.gzn);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gzn.getId());
        layoutParams.addRule(8, this.gzn.getId());
        addView(this.gzo, layoutParams);
        this.As = com.baidu.tieba.qrcode.lib.a.a.cc(context);
    }

    public void setDelegate(a aVar) {
        this.gzp = aVar;
    }

    public f getScanBoxView() {
        return this.gzo;
    }

    public void bnq() {
        if (this.gzo != null) {
            this.gzo.setVisibility(0);
        }
    }

    public void bnr() {
        if (this.gzo != null) {
            this.gzo.setVisibility(8);
        }
    }

    public void bns() {
        ui(0);
    }

    public void ui(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    uj(i2);
                    return;
                }
            }
        }
    }

    private void uj(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gzn.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gzp != null) {
                this.gzp.bnm();
            }
        }
    }

    public void stopCamera() {
        try {
            bnv();
            if (this.mCamera != null) {
                this.gzn.bno();
                this.gzn.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bnt() {
        uk(1000);
    }

    public void uk(int i) {
        this.gzq = true;
        this.mHandler.removeCallbacks(this.gzs);
        this.mHandler.postDelayed(this.gzs, i);
    }

    public void bnu() {
        bnw();
        this.gzq = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gzs);
        }
    }

    public void bnv() {
        bnu();
        bnr();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gzp = null;
        this.gzs = null;
    }

    protected void bnw() {
        if (this.gzr != null) {
            this.gzr.lM();
            this.gzr = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gzo.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gzq) {
            bnw();
            this.gzr = new d(camera, bArr, this, this.As) { // from class: com.baidu.tieba.qrcode.lib.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (e.this.gzq) {
                        if (e.this.gzp != null && !TextUtils.isEmpty(str)) {
                            try {
                                e.this.gzp.rA(str);
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        }
                        try {
                            camera.setOneShotPreviewCallback(e.this);
                        } catch (Exception e2) {
                        }
                    }
                }
            }.bnp();
        }
    }
}
