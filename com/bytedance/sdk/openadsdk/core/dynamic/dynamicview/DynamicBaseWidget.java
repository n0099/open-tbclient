package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.dynamic.b.e;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.a;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class DynamicBaseWidget extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public float f28848a;

    /* renamed from: b  reason: collision with root package name */
    public float f28849b;

    /* renamed from: c  reason: collision with root package name */
    public float f28850c;

    /* renamed from: d  reason: collision with root package name */
    public float f28851d;

    /* renamed from: e  reason: collision with root package name */
    public int f28852e;

    /* renamed from: f  reason: collision with root package name */
    public int f28853f;

    /* renamed from: g  reason: collision with root package name */
    public int f28854g;

    /* renamed from: h  reason: collision with root package name */
    public int f28855h;

    /* renamed from: i  reason: collision with root package name */
    public Context f28856i;
    public e j;
    public f k;
    public List<DynamicBaseWidget> l;
    public DynamicRootView m;
    public View n;
    public boolean o;
    public boolean p;

    public DynamicBaseWidget(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context);
        this.p = true;
        this.f28856i = context;
        this.m = dynamicRootView;
        this.k = fVar;
        this.f28848a = fVar.a();
        this.f28849b = fVar.b();
        this.f28850c = fVar.c();
        this.f28851d = fVar.d();
        this.f28854g = (int) al.a(this.f28856i, this.f28848a);
        this.f28855h = (int) al.a(this.f28856i, this.f28849b);
        this.f28852e = (int) al.a(this.f28856i, this.f28850c);
        this.f28853f = (int) al.a(this.f28856i, this.f28851d);
        e eVar = new e(fVar.e());
        this.j = eVar;
        this.o = eVar.k() > 0;
    }

    public void a(DynamicBaseWidget dynamicBaseWidget) {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.setShouldInvisible(this.o);
        this.l.add(dynamicBaseWidget);
    }

    public abstract boolean b();

    public boolean c() {
        return true;
    }

    public boolean d() {
        boolean b2 = b();
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f28852e, this.f28853f);
            u.f("DynamicBaseWidget", "widget mDynamicView:" + this.n);
            u.f("DynamicBaseWidget", "mDynamicView x,y,w,h:" + this.f28848a + "," + this.f28849b + "," + this.f28852e + "," + this.f28853f);
            layoutParams.topMargin = this.f28855h;
            layoutParams.leftMargin = this.f28854g;
            this.m.addView(this, layoutParams);
            return b2;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean e() {
        e eVar = this.j;
        return (eVar == null || eVar.p() == 0) ? false : true;
    }

    public Drawable getBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(al.a(this.f28856i, this.j.l()));
        gradientDrawable.setColor(this.j.q());
        gradientDrawable.setStroke((int) al.a(this.f28856i, this.j.n()), this.j.m());
        return gradientDrawable;
    }

    public int getClickArea() {
        return this.j.p();
    }

    public a getDynamicClickListener() {
        return this.m.getDynamicClickListener();
    }

    public void setLayoutUnit(f fVar) {
        this.k = fVar;
    }

    public void setShouldInvisible(boolean z) {
        this.o = z;
    }

    public boolean a() {
        boolean d2 = d();
        boolean c2 = c();
        if (!d2 || !c2) {
            this.p = false;
        }
        List<DynamicBaseWidget> list = this.l;
        if (list != null) {
            for (DynamicBaseWidget dynamicBaseWidget : list) {
                if (!dynamicBaseWidget.a()) {
                    this.p = false;
                }
            }
        }
        return this.p;
    }
}
