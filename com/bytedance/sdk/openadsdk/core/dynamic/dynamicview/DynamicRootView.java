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
    public o f28134a;

    /* renamed from: b  reason: collision with root package name */
    public j f28135b;

    /* renamed from: c  reason: collision with root package name */
    public g f28136c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f28137d;

    /* renamed from: e  reason: collision with root package name */
    public a f28138e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f28134a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f28138e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f28137d;
        return dynamicBaseWidget.f28127c > 0.0f && dynamicBaseWidget.f28128d > 0.0f;
    }

    public void a() {
        this.f28134a.a(this.f28137d.a() && c());
        this.f28134a.a(this.f28137d.f28127c);
        this.f28134a.b(this.f28137d.f28128d);
        this.f28135b.a(this.f28134a);
    }

    public void b() {
        this.f28134a.a(false);
        this.f28135b.a(this.f28134a);
    }

    public a getDynamicClickListener() {
        return this.f28138e;
    }

    public g getExpressVideoListener() {
        return this.f28136c;
    }

    public j getRenderListener() {
        return this.f28135b;
    }

    public void setDislikeView(View view) {
        this.f28138e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f28137d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f28136c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f28135b = jVar;
        this.f28138e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f28134a.c(d2);
        this.f28134a.d(d3);
        this.f28134a.e(d4);
        this.f28134a.f(d5);
    }
}
