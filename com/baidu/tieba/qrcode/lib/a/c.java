package com.baidu.tieba.qrcode.lib.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes3.dex */
public class c extends TextureView implements TextureView.SurfaceTextureListener {
    private static final String TAG = c.class.getSimpleName();
    private boolean gyW;
    private b gyX;
    private Runnable gyY;
    Camera.AutoFocusCallback gyZ;
    private Camera mCamera;
    private boolean mSurfaceCreated;
    private SurfaceTexture mSurfaceTexture;

    public c(Context context) {
        super(context);
        this.gyW = false;
        this.mSurfaceCreated = false;
        this.gyY = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mCamera != null && c.this.gyW && c.this.mSurfaceCreated) {
                    try {
                        c.this.mCamera.autoFocus(c.this.gyZ);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.gyZ = new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.qrcode.lib.a.c.2
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                if (z) {
                    c.this.postDelayed(c.this.gyY, 2000L);
                } else {
                    c.this.postDelayed(c.this.gyY, 500L);
                }
            }
        };
        setSurfaceTextureListener(this);
    }

    public void setCamera(Camera camera) {
        this.mCamera = camera;
        if (this.mCamera != null) {
            this.gyX = new b(getContext());
            this.gyX.d(this.mCamera);
            if (this.gyW) {
                requestLayout();
            } else {
                aeo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeo() {
        if (this.mSurfaceTexture != null && this.mCamera != null) {
            try {
                this.gyW = true;
                this.mCamera.setPreviewTexture(this.mSurfaceTexture);
                this.gyX.f(this.mCamera);
                this.mCamera.startPreview();
                this.mCamera.autoFocus(this.gyZ);
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void bnn() {
        if (this.mCamera != null) {
            try {
                removeCallbacks(this.gyY);
                this.gyW = false;
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
        if (this.gyX != null && this.gyX.getCameraResolution() != null) {
            Point cameraResolution = this.gyX.getCameraResolution();
            int i3 = cameraResolution.x;
            int i4 = cameraResolution.y;
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
        aeo();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (surfaceTexture != null) {
            bnn();
            post(new Runnable() { // from class: com.baidu.tieba.qrcode.lib.a.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aeo();
                }
            });
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurfaceCreated = false;
        bnn();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
