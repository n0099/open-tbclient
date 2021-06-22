package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class c implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<SurfaceHolder.Callback> f28694a;

    public c(SurfaceHolder.Callback callback) {
        this.f28694a = new WeakReference<>(callback);
    }

    public SurfaceHolder.Callback a() {
        return this.f28694a.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        SurfaceHolder.Callback callback = this.f28694a.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i2, i3, i4);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f28694a.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f28694a.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
