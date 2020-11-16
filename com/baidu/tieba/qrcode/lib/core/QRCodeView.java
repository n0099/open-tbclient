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
    protected Camera mCamera;
    protected Handler mHandler;
    private int mOrientation;
    protected CameraPreview mqA;
    protected ScanBoxView mqB;
    protected a mqC;
    protected boolean mqD;
    protected c mqE;
    private Runnable mqF;

    /* loaded from: classes22.dex */
    public interface a {
        void Qt(String str);

        void dyN();
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mqD = false;
        this.mqF = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.mCamera != null && QRCodeView.this.mqD) {
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
        this.mqA = new CameraPreview(getContext());
        this.mqB = new ScanBoxView(getContext());
        this.mqB.j(context, attributeSet);
        this.mqA.setId(R.id.bgaqrcode_camera_preview);
        addView(this.mqA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.mqA.getId());
        layoutParams.addRule(8, this.mqA.getId());
        addView(this.mqB, layoutParams);
        this.mOrientation = com.baidu.tieba.qrcode.lib.core.a.fJ(context);
    }

    public void setDelegate(a aVar) {
        this.mqC = aVar;
    }

    public ScanBoxView getScanBoxView() {
        return this.mqB;
    }

    public void dyV() {
        if (this.mqB != null) {
            this.mqB.setVisibility(0);
        }
    }

    public void dyW() {
        if (this.mqB != null) {
            this.mqB.setVisibility(8);
        }
    }

    public void dyX() {
        Ih(0);
    }

    public void Ih(int i) {
        if (this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Ii(i2);
                    return;
                }
            }
        }
    }

    private void Ii(int i) {
        try {
            this.mCamera = Camera.open(i);
            this.mqA.setCamera(this.mCamera);
        } catch (Exception e) {
            if (this.mqC != null) {
                this.mqC.dyN();
            }
        }
    }

    public void stopCamera() {
        try {
            dza();
            if (this.mCamera != null) {
                this.mqA.dyT();
                this.mqA.setCamera(null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public void dyY() {
        Ij(1000);
    }

    public void Ij(int i) {
        this.mqD = true;
        this.mHandler.removeCallbacks(this.mqF);
        this.mHandler.postDelayed(this.mqF, i);
    }

    public void dyZ() {
        dzb();
        this.mqD = false;
        if (this.mCamera != null) {
            try {
                this.mCamera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
            }
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mqF);
        }
    }

    public void dza() {
        dyZ();
        dyW();
    }

    public void onDestroy() {
        stopCamera();
        this.mHandler = null;
        this.mqC = null;
        this.mqF = null;
    }

    protected void dzb() {
        if (this.mqE != null) {
            this.mqE.cancelTask();
            this.mqE = null;
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.mqB.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, final Camera camera) {
        if (this.mqD) {
            dzb();
            this.mqE = new c(camera, bArr, this, this.mOrientation) { // from class: com.baidu.tieba.qrcode.lib.core.QRCodeView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    if (QRCodeView.this.mqD) {
                        if (QRCodeView.this.mqC != null && !TextUtils.isEmpty(str)) {
                            try {
                                QRCodeView.this.mqC.Qt(str);
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
            }.dyU();
        }
    }
}
