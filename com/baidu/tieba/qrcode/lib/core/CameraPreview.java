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
    private boolean mED;
    private b mEE;
    private Runnable mEF;
    Camera.AutoFocusCallback mEG;
    private boolean mSurfaceCreated;
    private SurfaceTexture mSurfaceTexture;

    public CameraPreview(Context context) {
        super(context);
        this.mED = false;
        this.mSurfaceCreated = false;
        this.mEF = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraPreview.this.mCamera != null && CameraPreview.this.mED && CameraPreview.this.mSurfaceCreated) {
                    try {
                        CameraPreview.this.mCamera.autoFocus(CameraPreview.this.mEG);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.mEG = new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.2
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                if (z) {
                    CameraPreview.this.postDelayed(CameraPreview.this.mEF, 2000L);
                } else {
                    CameraPreview.this.postDelayed(CameraPreview.this.mEF, 500L);
                }
            }
        };
        setSurfaceTextureListener(this);
    }

    public void setCamera(Camera camera) {
        this.mCamera = camera;
        if (this.mCamera != null) {
            this.mEE = new b(getContext());
            this.mEE.b(this.mCamera);
            if (this.mED) {
                requestLayout();
            } else {
                cin();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cin() {
        if (this.mSurfaceTexture != null && this.mCamera != null) {
            try {
                this.mED = true;
                this.mCamera.setPreviewTexture(this.mSurfaceTexture);
                this.mEE.d(this.mCamera);
                this.mCamera.startPreview();
                this.mCamera.autoFocus(this.mEG);
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void dEl() {
        if (this.mCamera != null) {
            try {
                removeCallbacks(this.mEF);
                this.mED = false;
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
        if (this.mEE != null && this.mEE.dEj() != null) {
            Point dEj = this.mEE.dEj();
            int i3 = dEj.x;
            int i4 = dEj.y;
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
        cin();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (surfaceTexture != null) {
            dEl();
            post(new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.3
                @Override // java.lang.Runnable
                public void run() {
                    CameraPreview.this.cin();
                }
            });
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurfaceCreated = false;
        dEl();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
