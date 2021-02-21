package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes8.dex */
public class CameraPreview extends TextureView implements TextureView.SurfaceTextureListener {
    private static final String TAG = CameraPreview.class.getSimpleName();
    private Camera mCamera;
    private boolean mOE;
    private b mOF;
    private Runnable mOG;
    Camera.AutoFocusCallback mOH;
    private boolean mSurfaceCreated;
    private SurfaceTexture mSurfaceTexture;

    public CameraPreview(Context context) {
        super(context);
        this.mOE = false;
        this.mSurfaceCreated = false;
        this.mOG = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraPreview.this.mCamera != null && CameraPreview.this.mOE && CameraPreview.this.mSurfaceCreated) {
                    try {
                        CameraPreview.this.mCamera.autoFocus(CameraPreview.this.mOH);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.mOH = new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.2
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                if (z) {
                    CameraPreview.this.postDelayed(CameraPreview.this.mOG, 2000L);
                } else {
                    CameraPreview.this.postDelayed(CameraPreview.this.mOG, 500L);
                }
            }
        };
        setSurfaceTextureListener(this);
    }

    public void setCamera(Camera camera) {
        this.mCamera = camera;
        if (this.mCamera != null) {
            this.mOF = new b(getContext());
            this.mOF.b(this.mCamera);
            if (this.mOE) {
                requestLayout();
            } else {
                cij();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cij() {
        if (this.mSurfaceTexture != null && this.mCamera != null) {
            try {
                this.mOE = true;
                this.mCamera.setPreviewTexture(this.mSurfaceTexture);
                this.mOF.d(this.mCamera);
                this.mCamera.startPreview();
                this.mCamera.autoFocus(this.mOH);
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void dCA() {
        if (this.mCamera != null) {
            try {
                removeCallbacks(this.mOG);
                this.mOE = false;
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
        if (this.mOF != null && this.mOF.dCy() != null) {
            Point dCy = this.mOF.dCy();
            int i3 = dCy.x;
            int i4 = dCy.y;
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
        cij();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (surfaceTexture != null) {
            dCA();
            post(new Runnable() { // from class: com.baidu.tieba.qrcode.lib.core.CameraPreview.3
                @Override // java.lang.Runnable
                public void run() {
                    CameraPreview.this.cij();
                }
            });
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurfaceCreated = false;
        dCA();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
