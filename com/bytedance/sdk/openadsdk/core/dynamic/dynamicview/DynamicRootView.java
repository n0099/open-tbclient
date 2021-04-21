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
    public o f28001a;

    /* renamed from: b  reason: collision with root package name */
    public j f28002b;

    /* renamed from: c  reason: collision with root package name */
    public g f28003c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f28004d;

    /* renamed from: e  reason: collision with root package name */
    public a f28005e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f28001a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f28005e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f28004d;
        return dynamicBaseWidget.f27995c > 0.0f && dynamicBaseWidget.f27996d > 0.0f;
    }

    public void a() {
        this.f28001a.a(this.f28004d.a() && c());
        this.f28001a.a(this.f28004d.f27995c);
        this.f28001a.b(this.f28004d.f27996d);
        this.f28002b.a(this.f28001a);
    }

    public void b() {
        this.f28001a.a(false);
        this.f28002b.a(this.f28001a);
    }

    public a getDynamicClickListener() {
        return this.f28005e;
    }

    public g getExpressVideoListener() {
        return this.f28003c;
    }

    public j getRenderListener() {
        return this.f28002b;
    }

    public void setDislikeView(View view) {
        this.f28005e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f28004d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f28003c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f28002b = jVar;
        this.f28005e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f28001a.c(d2);
        this.f28001a.d(d3);
        this.f28001a.e(d4);
        this.f28001a.f(d5);
    }
}
