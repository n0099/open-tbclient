package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, b {

    /* renamed from: c  reason: collision with root package name */
    public static final ArrayList<c> f28447c = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<a> f28448a;

    /* renamed from: b  reason: collision with root package name */
    public c f28449b;

    /* renamed from: d  reason: collision with root package name */
    public b.a f28450d;

    public SSRenderSurfaceView(Context context) {
        super(context);
        a();
    }

    private void a() {
        c cVar = new c(this);
        this.f28449b = cVar;
        f28447c.add(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.SSSurfaceView, android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b.a aVar = this.f28450d;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.f28450d = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        WeakReference<a> weakReference = this.f28448a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f28448a.get().a(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.f28448a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f28448a.get().a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.f28448a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f28448a.get().b(surfaceHolder);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        this.f28448a = new WeakReference<>(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<c> it = f28447c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.f28449b);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
