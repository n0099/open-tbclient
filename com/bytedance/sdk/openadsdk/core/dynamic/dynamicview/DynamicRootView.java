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
    public o f28102a;

    /* renamed from: b  reason: collision with root package name */
    public j f28103b;

    /* renamed from: c  reason: collision with root package name */
    public g f28104c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f28105d;

    /* renamed from: e  reason: collision with root package name */
    public a f28106e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f28102a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f28106e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f28105d;
        return dynamicBaseWidget.f28095c > 0.0f && dynamicBaseWidget.f28096d > 0.0f;
    }

    public void a() {
        this.f28102a.a(this.f28105d.a() && c());
        this.f28102a.a(this.f28105d.f28095c);
        this.f28102a.b(this.f28105d.f28096d);
        this.f28103b.a(this.f28102a);
    }

    public void b() {
        this.f28102a.a(false);
        this.f28103b.a(this.f28102a);
    }

    public a getDynamicClickListener() {
        return this.f28106e;
    }

    public g getExpressVideoListener() {
        return this.f28104c;
    }

    public j getRenderListener() {
        return this.f28103b;
    }

    public void setDislikeView(View view) {
        this.f28106e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f28105d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f28104c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f28103b = jVar;
        this.f28106e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f28102a.c(d2);
        this.f28102a.d(d3);
        this.f28102a.e(d4);
        this.f28102a.f(d5);
    }
}
