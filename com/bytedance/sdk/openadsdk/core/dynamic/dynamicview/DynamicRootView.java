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
    public o f28216a;

    /* renamed from: b  reason: collision with root package name */
    public j f28217b;

    /* renamed from: c  reason: collision with root package name */
    public g f28218c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f28219d;

    /* renamed from: e  reason: collision with root package name */
    public a f28220e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f28216a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f28220e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f28219d;
        return dynamicBaseWidget.f28209c > 0.0f && dynamicBaseWidget.f28210d > 0.0f;
    }

    public void a() {
        this.f28216a.a(this.f28219d.a() && c());
        this.f28216a.a(this.f28219d.f28209c);
        this.f28216a.b(this.f28219d.f28210d);
        this.f28217b.a(this.f28216a);
    }

    public void b() {
        this.f28216a.a(false);
        this.f28217b.a(this.f28216a);
    }

    public a getDynamicClickListener() {
        return this.f28220e;
    }

    public g getExpressVideoListener() {
        return this.f28218c;
    }

    public j getRenderListener() {
        return this.f28217b;
    }

    public void setDislikeView(View view) {
        this.f28220e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f28219d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f28218c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f28217b = jVar;
        this.f28220e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f28216a.c(d2);
        this.f28216a.d(d3);
        this.f28216a.e(d4);
        this.f28216a.f(d5);
    }
}
