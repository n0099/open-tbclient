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
    private int An;
    protected c gzs;
    protected f gzt;
    protected a gzu;
    protected boolean gzv;
    protected d gzw;
    private Runnable gzx;
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
        this.gzv = false;
        this.gzx = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mCamera != null && e.this.gzv) {
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
        this.gzs = new c(getContext());
        this.gzt = new f(getContext());
        this.gzt.g(context, attributeSet);
        this.gzs.setId(d.g.bgaqrcode_camera_preview);
        addView(this.gzs);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gzs.getId());
        layoutParams.addRule(8, this.gzs.getId());
        addView(this.gzt, layoutParams);
        this.An = com.baidu.tieba.qrcode.lib.a.a.cc(context);
    }

    public void setDelegate(a aVar) {
        this.gzu = aVar;
    }

    public f getScanBoxView() {
        return this.gzt;
    }

    public void bnq() {
        if (this.gzt != null) {
            this.gzt.setVisibility(0);
        }
    }

    public void bnr() {
        if (this.gzt != null) {
            this.gzt.setVisibility(8);
        }
    }

    public void bns() {
        uj(0);
    }

    public void uj(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    uk(i2);
                    return;
                }
            }
        }
    }

    private void uk(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.gzs.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gzu != null) {
                this.gzu.bnm();
            }
        }
    }

    public void stopCamera() {
        try {
            bnv();
            if (this.mCamera != null) {
                this.gzs.bno();
                this.gzs.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bnt() {
        ul(1000);
    }

    public void ul(int i) {
        this.gzv = true;
        this.mHandler.removeCallbacks(this.gzx);
        this.mHandler.postDelayed(this.gzx, i);
    }

    public void bnu() {
        bnw();
        this.gzv = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gzx);
        }
    }

    public void bnv() {
        bnu();
        bnr();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gzu = null;
        this.gzx = null;
    }

    protected void bnw() {
        if (this.gzw != null) {
            this.gzw.lM();
            this.gzw = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gzt.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gzv) {
            bnw();
            this.gzw = new d(camera, bArr, this, this.An) { // from class: com.baidu.tieba.qrcode.lib.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (e.this.gzv) {
                        if (e.this.gzu != null && !TextUtils.isEmpty(str)) {
                            try {
                                e.this.gzu.rA(str);
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
