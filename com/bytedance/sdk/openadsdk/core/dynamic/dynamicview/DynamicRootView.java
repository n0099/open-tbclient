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
    public o f28857a;

    /* renamed from: b  reason: collision with root package name */
    public j f28858b;

    /* renamed from: c  reason: collision with root package name */
    public g f28859c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f28860d;

    /* renamed from: e  reason: collision with root package name */
    public a f28861e;

    public DynamicRootView(@NonNull Context context) {
        super(context);
        o oVar = new o();
        this.f28857a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.f28861e = aVar;
        aVar.a(this);
    }

    private boolean c() {
        DynamicBaseWidget dynamicBaseWidget = this.f28860d;
        return dynamicBaseWidget.f28850c > 0.0f && dynamicBaseWidget.f28851d > 0.0f;
    }

    public void a() {
        this.f28857a.a(this.f28860d.a() && c());
        this.f28857a.a(this.f28860d.f28850c);
        this.f28857a.b(this.f28860d.f28851d);
        this.f28858b.a(this.f28857a);
    }

    public void b() {
        this.f28857a.a(false);
        this.f28858b.a(this.f28857a);
    }

    public a getDynamicClickListener() {
        return this.f28861e;
    }

    public g getExpressVideoListener() {
        return this.f28859c;
    }

    public j getRenderListener() {
        return this.f28858b;
    }

    public void setDislikeView(View view) {
        this.f28861e.b(view);
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.f28860d = dynamicBaseWidget;
    }

    public void setExpressVideoListener(g gVar) {
        this.f28859c = gVar;
    }

    public void setRenderListener(j jVar) {
        this.f28858b = jVar;
        this.f28861e.a(jVar);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.f28857a.c(d2);
        this.f28857a.d(d3);
        this.f28857a.e(d4);
        this.f28857a.f(d5);
    }
}
