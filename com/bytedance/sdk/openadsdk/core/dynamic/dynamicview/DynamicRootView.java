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
    public o f28308a;

    /* renamed from: b  reason: collision with root package name */
    public j f28309b;

    /* renamed from: c  reason: collision with root package name */
    public g f28310c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f28311d;

    /* renamed from: e  reason: collision with root package name */
    public a f28312e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f28308a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f28312e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f28311d;
        return dynamicBaseWidget.f28302c > 0.0f && dynamicBaseWidget.f28303d > 0.0f;
    }

    public void a() {
        this.f28308a.a(this.f28311d.a() && c());
        this.f28308a.a(this.f28311d.f28302c);
        this.f28308a.b(this.f28311d.f28303d);
        this.f28309b.a(this.f28308a);
    }

    public void b() {
        this.f28308a.a(false);
        this.f28309b.a(this.f28308a);
    }

    public a getDynamicClickListener() {
        return this.f28312e;
    }

    public g getExpressVideoListener() {
        return this.f28310c;
    }

    public j getRenderListener() {
        return this.f28309b;
    }

    public void setDislikeView(View view) {
        this.f28312e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f28311d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f28310c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f28309b = jVar;
        this.f28312e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f28308a.c(d2);
        this.f28308a.d(d3);
        this.f28308a.e(d4);
        this.f28308a.f(d5);
    }
}
