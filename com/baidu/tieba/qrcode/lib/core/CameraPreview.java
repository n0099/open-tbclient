package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes3.dex */
public class CameraPreview extends TextureView implements TextureView.SurfaceTextureListener {
    public static final String l = CameraPreview.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    public Camera f20890e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20891f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20892g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.p2.b.a.b f20893h;

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f20894i;
    public Runnable j;
    public Camera.AutoFocusCallback k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraPreview.this.f20890e != null && CameraPreview.this.f20891f && CameraPreview.this.f20892g) {
                try {
                    CameraPreview.this.f20890e.autoFocus(CameraPreview.this.k);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            if (z) {
                CameraPreview cameraPreview = CameraPreview.this;
                cameraPreview.postDelayed(cameraPreview.j, 2000L);
                return;
            }
            CameraPreview cameraPreview2 = CameraPreview.this;
            cameraPreview2.postDelayed(cameraPreview2.j, 500L);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraPreview.this.f();
        }
    }

    public CameraPreview(Context context) {
        super(context);
        this.f20891f = false;
        this.f20892g = false;
        this.j = new a();
        this.k = new b();
        setSurfaceTextureListener(this);
    }

    public final void f() {
        Camera camera;
        SurfaceTexture surfaceTexture = this.f20894i;
        if (surfaceTexture == null || (camera = this.f20890e) == null) {
            return;
        }
        try {
            this.f20891f = true;
            camera.setPreviewTexture(surfaceTexture);
            this.f20893h.i(this.f20890e);
            this.f20890e.startPreview();
            this.f20890e.autoFocus(this.k);
        } catch (Exception e2) {
            Log.e(l, e2.toString(), e2);
        }
    }

    public void g() {
        if (this.f20890e != null) {
            try {
                removeCallbacks(this.j);
                this.f20891f = false;
                this.f20890e.cancelAutoFocus();
                this.f20890e.setOneShotPreviewCallback(null);
                this.f20890e.stopPreview();
            } catch (Exception e2) {
                Log.e(l, e2.toString(), e2);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int defaultSize = TextureView.getDefaultSize(getSuggestedMinimumWidth(), i2);
        int defaultSize2 = TextureView.getDefaultSize(getSuggestedMinimumHeight(), i3);
        d.a.j0.p2.b.a.b bVar = this.f20893h;
        if (bVar != null && bVar.e() != null) {
            Point e2 = this.f20893h.e();
            float f2 = defaultSize;
            float f3 = defaultSize2;
            float f4 = e2.x;
            float f5 = e2.y;
            float f6 = (f4 * 1.0f) / f5;
            if ((f2 * 1.0f) / f3 < f6) {
                defaultSize = (int) ((f3 / ((f5 * 1.0f) / f4)) + 0.5f);
            } else {
                defaultSize2 = (int) ((f2 / f6) + 0.5f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f20892g = true;
        this.f20894i = surfaceTexture;
        f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f20892g = false;
        g();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (surfaceTexture == null) {
            return;
        }
        g();
        post(new c());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setCamera(Camera camera) {
        this.f20890e = camera;
        if (camera != null) {
            d.a.j0.p2.b.a.b bVar = new d.a.j0.p2.b.a.b(getContext());
            this.f20893h = bVar;
            bVar.h(this.f20890e);
            if (this.f20891f) {
                requestLayout();
            } else {
                f();
            }
        }
    }
}
