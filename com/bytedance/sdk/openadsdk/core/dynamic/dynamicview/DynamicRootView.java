package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.dynamic.d.a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
/* loaded from: classes5.dex */
public class DynamicRootView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public o f27993a;

    /* renamed from: b  reason: collision with root package name */
    public j f27994b;

    /* renamed from: c  reason: collision with root package name */
    public g f27995c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f27996d;

    /* renamed from: e  reason: collision with root package name */
    public a f27997e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f27993a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f27997e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f27996d;
        return dynamicBaseWidget.f27987c > 0.0f && dynamicBaseWidget.f27988d > 0.0f;
    }

    public void a() {
        this.f27993a.a(this.f27996d.a() && c());
        this.f27993a.a(this.f27996d.f27987c);
        this.f27993a.b(this.f27996d.f27988d);
        this.f27994b.a(this.f27993a);
    }

    public void b() {
        this.f27993a.a(false);
        this.f27994b.a(this.f27993a);
    }

    public a getDynamicClickListener() {
        return this.f27997e;
    }

    public g getExpressVideoListener() {
        return this.f27995c;
    }

    public j getRenderListener() {
        return this.f27994b;
    }

    public void setDislikeView(View view) {
        this.f27997e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f27996d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f27995c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f27994b = jVar;
        this.f27997e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f27993a.c(d2);
        this.f27993a.d(d3);
        this.f27993a.e(d4);
        this.f27993a.f(d5);
    }
}
