package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public volatile Camera f23566a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f23567a = new b();
    }

    public static final b a() {
        return a.f23567a;
    }

    public Camera b() {
        if (this.f23566a == null) {
            synchronized (b.class) {
                if (this.f23566a == null) {
                    this.f23566a = Camera.open();
                }
            }
        }
        return this.f23566a;
    }

    public void c() {
        if (this.f23566a != null) {
            this.f23566a.stopPreview();
        }
    }

    public Camera.Parameters d() {
        if (this.f23566a != null) {
            return this.f23566a.getParameters();
        }
        return null;
    }

    public void e() {
        if (this.f23566a != null) {
            this.f23566a.startPreview();
        }
    }

    public void f() {
        if (this.f23566a != null) {
            this.f23566a.release();
            this.f23566a = null;
        }
    }

    public void g() {
        if (this.f23566a != null) {
            this.f23566a.cancelAutoFocus();
        }
    }

    public b() {
    }

    public void a(Camera.Parameters parameters) {
        if (parameters != null) {
            parameters.setRotation(0);
        }
        if (this.f23566a != null) {
            this.f23566a.setParameters(parameters);
        }
    }

    public void a(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f23566a != null) {
            this.f23566a.setPreviewDisplay(surfaceHolder);
        }
    }

    public void a(byte[] bArr) {
        if (this.f23566a != null) {
            this.f23566a.addCallbackBuffer(bArr);
        }
    }

    public void a(Camera.PreviewCallback previewCallback) {
        if (this.f23566a != null) {
            this.f23566a.setPreviewCallbackWithBuffer(previewCallback);
        }
    }

    public void a(Camera.AutoFocusCallback autoFocusCallback) {
        if (this.f23566a != null) {
            this.f23566a.autoFocus(autoFocusCallback);
        }
    }

    public void a(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2, Camera.PictureCallback pictureCallback3) {
        if (this.f23566a != null) {
            this.f23566a.takePicture(shutterCallback, pictureCallback, pictureCallback2, pictureCallback3);
        }
    }

    public void a(Camera.AutoFocusCallback autoFocusCallback, String str) {
        g();
        Camera.Parameters d2 = d();
        List<String> supportedFocusModes = d2.getSupportedFocusModes();
        if (supportedFocusModes == null || !supportedFocusModes.contains(str)) {
            return;
        }
        d2.setFocusMode(str);
        a(d2);
        a(autoFocusCallback);
    }
}
