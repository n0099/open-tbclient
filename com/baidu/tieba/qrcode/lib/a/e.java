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
    protected c gzc;
    protected f gzd;
    protected a gze;
    protected boolean gzf;
    protected d gzg;
    private Runnable gzh;
    protected Camera mCamera;
    protected Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void bnl();

        void rA(String str);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzf = false;
        this.gzh = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mCamera != null && e.this.gzf) {
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
        this.gzc = new c(getContext());
        this.gzd = new f(getContext());
        this.gzd.g(context, attributeSet);
        this.gzc.setId(d.g.bgaqrcode_camera_preview);
        addView(this.gzc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.gzc.getId());
        layoutParams.addRule(8, this.gzc.getId());
        addView(this.gzd, layoutParams);
        this.An = com.baidu.tieba.qrcode.lib.a.a.cc(context);
    }

    public void setDelegate(a aVar) {
        this.gze = aVar;
    }

    public f getScanBoxView() {
        return this.gzd;
    }

    public void bnp() {
        if (this.gzd != null) {
            this.gzd.setVisibility(0);
        }
    }

    public void bnq() {
        if (this.gzd != null) {
            this.gzd.setVisibility(8);
        }
    }

    public void bnr() {
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
            this.gzc.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.gze != null) {
                this.gze.bnl();
            }
        }
    }

    public void stopCamera() {
        try {
            bnu();
            if (this.mCamera != null) {
                this.gzc.bnn();
                this.gzc.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void bns() {
        ul(1000);
    }

    public void ul(int i) {
        this.gzf = true;
        this.mHandler.removeCallbacks(this.gzh);
        this.mHandler.postDelayed(this.gzh, i);
    }

    public void bnt() {
        bnv();
        this.gzf = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.gzh);
        }
    }

    public void bnu() {
        bnt();
        bnq();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.gze = null;
        this.gzh = null;
    }

    protected void bnv() {
        if (this.gzg != null) {
            this.gzg.lM();
            this.gzg = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.gzd.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.gzf) {
            bnv();
            this.gzg = new d(camera, bArr, this, this.An) { // from class: com.baidu.tieba.qrcode.lib.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (e.this.gzf) {
                        if (e.this.gze != null && !TextUtils.isEmpty(str)) {
                            try {
                                e.this.gze.rA(str);
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
            }.bno();
        }
    }
}
