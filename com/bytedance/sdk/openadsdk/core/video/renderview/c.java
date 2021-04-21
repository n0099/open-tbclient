package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<SurfaceHolder.Callback> f28461a;

    public c(SurfaceHolder.Callback callback) {
        this.f28461a = new WeakReference<>(callback);
    }

    public SurfaceHolder.Callback a() {
        return this.f28461a.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        SurfaceHolder.Callback callback = this.f28461a.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f28461a.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f28461a.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
