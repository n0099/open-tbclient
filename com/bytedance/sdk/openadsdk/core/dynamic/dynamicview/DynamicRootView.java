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
    public o f28307a;

    /* renamed from: b  reason: collision with root package name */
    public j f28308b;

    /* renamed from: c  reason: collision with root package name */
    public g f28309c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f28310d;

    /* renamed from: e  reason: collision with root package name */
    public a f28311e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f28307a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f28311e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f28310d;
        return dynamicBaseWidget.f28301c > 0.0f && dynamicBaseWidget.f28302d > 0.0f;
    }

    public void a() {
        this.f28307a.a(this.f28310d.a() && c());
        this.f28307a.a(this.f28310d.f28301c);
        this.f28307a.b(this.f28310d.f28302d);
        this.f28308b.a(this.f28307a);
    }

    public void b() {
        this.f28307a.a(false);
        this.f28308b.a(this.f28307a);
    }

    public a getDynamicClickListener() {
        return this.f28311e;
    }

    public g getExpressVideoListener() {
        return this.f28309c;
    }

    public j getRenderListener() {
        return this.f28308b;
    }

    public void setDislikeView(View view) {
        this.f28311e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f28310d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f28309c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f28308b = jVar;
        this.f28311e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f28307a.c(d2);
        this.f28307a.d(d3);
        this.f28307a.e(d4);
        this.f28307a.f(d5);
    }
}
