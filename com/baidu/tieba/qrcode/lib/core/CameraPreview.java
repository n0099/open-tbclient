package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes23.dex */
public class CameraPreview extends TextureView implements TextureView.SurfaceTextureListener {
    private static final String TAG = CameraPreview.class.getSimpleName();
    private Camera mCamera;
    private boolean mSurfaceCreated;
    private SurfaceTexture mSurfaceTexture;
    private boolean mqa;
    private b mqb;
    private Runnable mqc;
    Camera.AutoFocusCallback mqd;

    public CameraPreview(Context context) {
        super(context);
        this.mqa = false;
        this.mSurfaceCreated = false;
        this.mqc = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraPreview.this.mCamera != null && CameraPreview.this.mqa && CameraPreview.this.mSurfaceCreated) {
                    try {
                        CameraPreview.this.mCamera.autoFocus(CameraPreview.this.mqd);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.mqd = new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.2
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                if (z) {
                    CameraPreview.this.postDelayed(CameraPreview.this.mqc, 2000L);
                } else {
                    CameraPreview.this.postDelayed(CameraPreview.this.mqc, 500L);
                }
            }
        };
        setSurfaceTextureListener(this);
    }

    public void setCamera(Camera camera) {
        this.mCamera = camera;
        if (this.mCamera != null) {
            this.mqb = new b(getContext());
            this.mqb.b(this.mCamera);
            if (this.mqa) {
                requestLayout();
            } else {
                ceZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceZ() {
        if (this.mSurfaceTexture != null && this.mCamera != null) {
            try {
                this.mqa = true;
                this.mCamera.setPreviewTexture(this.mSurfaceTexture);
                this.mqb.d(this.mCamera);
                this.mCamera.startPreview();
                this.mCamera.autoFocus(this.mqd);
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void dzt() {
        if (this.mCamera != null) {
            try {
                removeCallbacks(this.mqc);
                this.mqa = false;
                this.mCamera.cancelAutoFocus();
                this.mCamera.setOneShotPreviewCallback(null);
                this.mCamera.stopPreview();
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = getDefaultSize(getSuggestedMinimumHeight(), i2);
        if (this.mqb != null && this.mqb.dzr() != null) {
            Point dzr = this.mqb.dzr();
            int i3 = dzr.x;
            int i4 = dzr.y;
            if ((defaultSize * 1.0f) / defaultSize2 < (i3 * 1.0f) / i4) {
                defaultSize = (int) ((defaultSize2 / ((i4 * 1.0f) / i3)) + 0.5f);
            } else {
                defaultSize2 = (int) ((defaultSize / ((i3 * 1.0f) / i4)) + 0.5f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mSurfaceCreated = true;
        this.mSurfaceTexture = surfaceTexture;
        ceZ();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (surfaceTexture != null) {
            dzt();
            post(new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.3
                @Override // java.lang.Runnable
                public void run() {
                    CameraPreview.this.ceZ();
                }
            });
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurfaceCreated = false;
        dzt();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
