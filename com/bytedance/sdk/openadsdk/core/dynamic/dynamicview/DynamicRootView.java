package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.dynamic.d.a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
/* loaded from: classes6.dex */
public class DynamicRootView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected o f4421a;
    private j b;
    private g c;
    private DynamicBaseWidget d;
    private a e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        this.f4421a = new o();
        this.f4421a.a(2);
        this.e = new a();
        this.e.a(this);
    }

    public void setRenderListener(j jVar) {
        this.b = jVar;
        this.e.a(jVar);
    }

    public void setExpressVideoListener(g gVar) {
        this.c = gVar;
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.d = dynamicBaseWidget;
    }

    public void a() {
        this.f4421a.a(this.d.a() && c());
        this.f4421a.a(this.d.c);
        this.f4421a.b(this.d.d);
        this.b.a(this.f4421a);
    }

    public void a(double d, double d2, double d3, double d4) {
        this.f4421a.c(d);
        this.f4421a.d(d2);
        this.f4421a.e(d3);
        this.f4421a.f(d4);
    }

    public void b() {
        this.f4421a.a(false);
        this.b.a(this.f4421a);
    }

    public void setDislikeView(View view) {
        this.e.b(view);
    }

    public j getRenderListener() {
        return this.b;
    }

    public g getExpressVideoListener() {
        return this.c;
    }

    public a getDynamicClickListener() {
        return this.e;
    }

    private boolean c() {
        return this.d.c > 0.0f && this.d.d > 0.0f;
    }
}
