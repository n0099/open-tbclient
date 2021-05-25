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
    public o f28031a;

    /* renamed from: b  reason: collision with root package name */
    public j f28032b;

    /* renamed from: c  reason: collision with root package name */
    public g f28033c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f28034d;

    /* renamed from: e  reason: collision with root package name */
    public a f28035e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f28031a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f28035e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f28034d;
        return dynamicBaseWidget.f28024c > 0.0f && dynamicBaseWidget.f28025d > 0.0f;
    }

    public void a() {
        this.f28031a.a(this.f28034d.a() && c());
        this.f28031a.a(this.f28034d.f28024c);
        this.f28031a.b(this.f28034d.f28025d);
        this.f28032b.a(this.f28031a);
    }

    public void b() {
        this.f28031a.a(false);
        this.f28032b.a(this.f28031a);
    }

    public a getDynamicClickListener() {
        return this.f28035e;
    }

    public g getExpressVideoListener() {
        return this.f28033c;
    }

    public j getRenderListener() {
        return this.f28032b;
    }

    public void setDislikeView(View view) {
        this.f28035e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f28034d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f28033c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f28032b = jVar;
        this.f28035e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f28031a.c(d2);
        this.f28031a.d(d3);
        this.f28031a.e(d4);
        this.f28031a.f(d5);
    }
}
