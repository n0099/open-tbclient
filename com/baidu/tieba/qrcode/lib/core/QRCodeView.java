package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.c;
/* loaded from: classes22.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    protected CameraPreview lIu;
    protected ScanBoxView lIv;
    protected a lIw;
    protected boolean lIx;
    protected c lIy;
    private Runnable lIz;
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;

    /* loaded from: classes22.dex */
    public interface a {
        void Pu(String str);

        void dpT();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lIx = false;
        this.lIz = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.lIx) {
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
        this.lIu = new CameraPreview(getContext());
        this.lIv = new ScanBoxView(getContext());
        this.lIv.j(context, attributeSet);
        this.lIu.setId(R.id.bgaqrcode_camera_preview);
        addView(this.lIu);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.lIu.getId());
        layoutParams.addRule(8, this.lIu.getId());
        addView(this.lIv, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fC(context);
    }

    public void setDelegate(a aVar) {
        this.lIw = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.lIv;
    }

    public void dqb() {
        if (this.lIv != null) {
            this.lIv.setVisibility(0);
        }
    }

    public void dqc() {
        if (this.lIv != null) {
            this.lIv.setVisibility(8);
        }
    }

    public void dqd() {
        Gx(0);
    }

    public void Gx(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Gy(i2);
                    return;
                }
            }
        }
    }

    private void Gy(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.lIu.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.lIw != null) {
                this.lIw.dpT();
            }
        }
    }

    public void stopCamera() {
        try {
            dqg();
            if (this.mCamera != null) {
                this.lIu.dpZ();
                this.lIu.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dqe() {
        Gz(1000);
    }

    public void Gz(int i) {
        this.lIx = true;
        this.mHandler.removeCallbacks(this.lIz);
        this.mHandler.postDelayed(this.lIz, i);
    }

    public void dqf() {
        dqh();
        this.lIx = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.lIz);
        }
    }

    public void dqg() {
        dqf();
        dqc();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.lIw = null;
        this.lIz = null;
    }

    protected void dqh() {
        if (this.lIy != null) {
            this.lIy.cancelTask();
            this.lIy = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.lIv.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.lIx) {
            dqh();
            this.lIy = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.lIx) {
                        if (QRCodeView.this.lIw != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.lIw.Pu(str);
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
            }.dqa();
        }
    }
}
