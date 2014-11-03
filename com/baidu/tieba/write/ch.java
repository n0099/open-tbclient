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
public class ch extends PopupWindow {
    private LinearLayout Pg;
    private int RO;
    private ci bUQ;
    private Context context;
    private int count;
    private int maxHeight;

    public ch(Context context) {
        super(context);
        this.RO = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        this.Pg = new LinearLayout(context);
        this.Pg.setOrientation(1);
        this.Pg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.Pg);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setPadding(0, 0, com.baidu.adp.lib.util.m.dip2px(context, 1.0f), com.baidu.adp.lib.util.m.dip2px(context, 1.0f));
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
    public void showAsDropDown(View view, int i, int i2) {
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.context.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.context.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        if (measuredWidth < view.getWidth()) {
            measuredWidth = view.getWidth();
        }
        int measuredHeight = getContentView().getMeasuredHeight();
        if (measuredHeight > this.maxHeight) {
            measuredHeight = this.maxHeight;
        }
        setWidth(measuredWidth);
        setHeight(measuredHeight);
        super.showAsDropDown(view, i, i2);
    }

    public void addView(View view) {
        view.setOnClickListener(new cj(this.count, this.bUQ));
        this.Pg.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void dP(int i) {
        if (this.RO != -1) {
            this.Pg.getChildAt(this.RO).setSelected(false);
        }
        this.RO = i;
        this.Pg.getChildAt(this.RO).setSelected(true);
    }

    public void a(ci ciVar) {
        this.bUQ = ciVar;
    }
}
