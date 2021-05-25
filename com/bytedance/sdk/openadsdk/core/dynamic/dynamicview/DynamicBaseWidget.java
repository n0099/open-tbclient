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
/* loaded from: classes6.dex */
public abstract class DynamicBaseWidget extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public float f28022a;

    /* renamed from: b  reason: collision with root package name */
    public float f28023b;

    /* renamed from: c  reason: collision with root package name */
    public float f28024c;

    /* renamed from: d  reason: collision with root package name */
    public float f28025d;

    /* renamed from: e  reason: collision with root package name */
    public int f28026e;

    /* renamed from: f  reason: collision with root package name */
    public int f28027f;

    /* renamed from: g  reason: collision with root package name */
    public int f28028g;

    /* renamed from: h  reason: collision with root package name */
    public int f28029h;

    /* renamed from: i  reason: collision with root package name */
    public Context f28030i;
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
        this.f28030i = context;
        this.m = dynamicRootView;
        this.k = fVar;
        this.f28022a = fVar.a();
        this.f28023b = fVar.b();
        this.f28024c = fVar.c();
        this.f28025d = fVar.d();
        this.f28028g = (int) al.a(this.f28030i, this.f28022a);
        this.f28029h = (int) al.a(this.f28030i, this.f28023b);
        this.f28026e = (int) al.a(this.f28030i, this.f28024c);
        this.f28027f = (int) al.a(this.f28030i, this.f28025d);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f28026e, this.f28027f);
            u.f("DynamicBaseWidget", "widget mDynamicView:" + this.n);
            u.f("DynamicBaseWidget", "mDynamicView x,y,w,h:" + this.f28022a + "," + this.f28023b + "," + this.f28026e + "," + this.f28027f);
            layoutParams.topMargin = this.f28029h;
            layoutParams.leftMargin = this.f28028g;
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
        gradientDrawable.setCornerRadius(al.a(this.f28030i, this.j.l()));
        gradientDrawable.setColor(this.j.q());
        gradientDrawable.setStroke((int) al.a(this.f28030i, this.j.n()), this.j.m());
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
