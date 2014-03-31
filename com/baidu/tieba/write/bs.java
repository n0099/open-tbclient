package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class bs extends PopupWindow {
    private int a;
    private bt b;
    private int c;
    private LinearLayout d;
    private Context e;
    private int f;

    public bs(Context context) {
        super(context);
        this.a = -1;
        this.e = context;
        ScrollView scrollView = new ScrollView(context);
        this.d = new LinearLayout(context);
        this.d.setOrientation(1);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.d);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setPadding(0, 0, com.baidu.adp.lib.util.i.a(context, 1.0f), com.baidu.adp.lib.util.i.a(context, 1.0f));
        scrollView.setFadingEdgeLength(0);
        try {
            Method declaredMethod = scrollView.getClass().getDeclaredMethod("setOverScrollMode", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(scrollView, 2);
        } catch (Exception e) {
        }
        setContentView(scrollView);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i, int i2) {
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        if (measuredWidth < view.getWidth()) {
            measuredWidth = view.getWidth();
        }
        int measuredHeight = getContentView().getMeasuredHeight();
        if (measuredHeight > this.f) {
            measuredHeight = this.f;
        }
        setWidth(measuredWidth);
        setHeight(measuredHeight);
        super.showAsDropDown(view, i, i2);
    }

    public final void a(View view) {
        view.setOnClickListener(new bu(this.c, this.b));
        this.d.addView(view);
        this.c++;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void b(int i) {
        if (this.a != -1) {
            this.d.getChildAt(this.a).setSelected(false);
        }
        this.a = i;
        this.d.getChildAt(this.a).setSelected(true);
    }

    public final void a(bt btVar) {
        this.b = btVar;
    }
}
