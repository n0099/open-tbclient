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
    private boolean gzh;
    private b gzi;
    private Runnable gzj;
    Camera.AutoFocusCallback gzk;
    private Camera mCamera;
    private boolean mSurfaceCreated;
    private SurfaceTexture mSurfaceTexture;

    public c(Context context) {
        super(context);
        this.gzh = false;
        this.mSurfaceCreated = false;
        this.gzj = new Runnable() { // from class: com.baidu.tieba.qrcode.lib.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mCamera != null && c.this.gzh && c.this.mSurfaceCreated) {
                    try {
                        c.this.mCamera.autoFocus(c.this.gzk);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.gzk = new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.qrcode.lib.a.c.2
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                if (z) {
                    c.this.postDelayed(c.this.gzj, 2000L);
                } else {
                    c.this.postDelayed(c.this.gzj, 500L);
                }
            }
        };
        setSurfaceTextureListener(this);
    }

    public void setCamera(Camera camera) {
        this.mCamera = camera;
        if (this.mCamera != null) {
            this.gzi = new b(getContext());
            this.gzi.d(this.mCamera);
            if (this.gzh) {
                requestLayout();
            } else {
                aep();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aep() {
        if (this.mSurfaceTexture != null && this.mCamera != null) {
            try {
                this.gzh = true;
                this.mCamera.setPreviewTexture(this.mSurfaceTexture);
                this.gzi.f(this.mCamera);
                this.mCamera.startPreview();
                this.mCamera.autoFocus(this.gzk);
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void bno() {
        if (this.mCamera != null) {
            try {
                removeCallbacks(this.gzj);
                this.gzh = false;
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
        if (this.gzi != null && this.gzi.getCameraResolution() != null) {
            Point cameraResolution = this.gzi.getCameraResolution();
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
        aep();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (surfaceTexture != null) {
            bno();
            post(new Runnable() { // from class: com.baidu.tieba.qrcode.lib.a.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aep();
                }
            });
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurfaceCreated = false;
        bno();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
