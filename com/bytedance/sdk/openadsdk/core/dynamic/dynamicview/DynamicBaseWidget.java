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
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class DynamicBaseWidget extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected float f4420a;
    protected float b;
    protected float c;
    protected float d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected Context i;
    protected e j;
    protected f k;
    protected List<DynamicBaseWidget> l;
    protected DynamicRootView m;
    protected View n;
    protected boolean o;
    private boolean p;

    abstract boolean b();

    public DynamicBaseWidget(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context);
        this.p = true;
        this.i = context;
        this.m = dynamicRootView;
        this.k = fVar;
        this.f4420a = fVar.a();
        this.b = fVar.b();
        this.c = fVar.c();
        this.d = fVar.d();
        this.g = (int) ak.a(this.i, this.f4420a);
        this.h = (int) ak.a(this.i, this.b);
        this.e = (int) ak.a(this.i, this.c);
        this.f = (int) ak.a(this.i, this.d);
        this.j = new e(fVar.e());
        this.o = this.j.k() > 0;
    }

    public void setLayoutUnit(f fVar) {
        this.k = fVar;
    }

    public void a(DynamicBaseWidget dynamicBaseWidget) {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        if (dynamicBaseWidget != null) {
            dynamicBaseWidget.setShouldInvisible(this.o);
            this.l.add(dynamicBaseWidget);
        }
    }

    public void setShouldInvisible(boolean z) {
        this.o = z;
    }

    public boolean a() {
        boolean d = d();
        boolean c = c();
        if (!d || !c) {
            this.p = false;
        }
        if (this.l != null) {
            for (DynamicBaseWidget dynamicBaseWidget : this.l) {
                if (!dynamicBaseWidget.a()) {
                    this.p = false;
                }
            }
        }
        return this.p;
    }

    protected boolean c() {
        return true;
    }

    protected boolean d() {
        boolean b = b();
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
            u.f("DynamicBaseWidget", "widget mDynamicView:" + this.n);
            u.f("DynamicBaseWidget", "mDynamicView x,y,w,h:" + this.f4420a + "," + this.b + "," + this.e + "," + this.f);
            layoutParams.topMargin = this.h;
            layoutParams.leftMargin = this.g;
            this.m.addView(this, layoutParams);
            return b;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        return (this.j == null || this.j.p() == 0) ? false : true;
    }

    public int getClickArea() {
        return this.j.p();
    }

    public a getDynamicClickListener() {
        return this.m.getDynamicClickListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ak.a(this.i, this.j.l()));
        gradientDrawable.setColor(this.j.q());
        gradientDrawable.setStroke((int) ak.a(this.i, this.j.n()), this.j.m());
        return gradientDrawable;
    }
}
