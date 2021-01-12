package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, b {
    private static final ArrayList<c> c = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<a> f6754a;

    /* renamed from: b  reason: collision with root package name */
    private c f6755b;
    private b.a d;

    public SSRenderSurfaceView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6755b = new c(this);
        c.add(this.f6755b);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        this.f6754a = new WeakReference<>(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<c> it = c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.f6755b);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f6754a != null && this.f6754a.get() != null) {
            this.f6754a.get().a(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f6754a != null && this.f6754a.get() != null) {
            this.f6754a.get().a(surfaceHolder, i, i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.f6754a != null && this.f6754a.get() != null) {
            this.f6754a.get().b(surfaceHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.SSSurfaceView, android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.d = aVar;
    }
}
