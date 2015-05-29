package com.baidu.tieba.write.write;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class cn extends PopupWindow {
    private LinearLayout agF;
    private co cDu;
    private Context context;
    private int count;
    private int mCurrentIndex;
    private int maxHeight;

    public cn(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.agF = new LinearLayout(context);
        this.agF.setOrientation(1);
        this.agF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.agF);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setPadding(0, 0, com.baidu.adp.lib.util.n.dip2px(context, 1.0f), com.baidu.adp.lib.util.n.dip2px(context, 1.0f));
        scrollView.setFadingEdgeLength(0);
        scrollView.setScrollbarFadingEnabled(false);
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
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.context.getResources().getDisplayMetrics().widthPixels, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(this.context.getResources().getDisplayMetrics().heightPixels, ExploreByTouchHelper.INVALID_ID));
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
        view.setOnClickListener(new cp(this.count, this.cDu));
        this.agF.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setCurrentIndex(int i) {
        if (this.mCurrentIndex != -1) {
            this.agF.getChildAt(this.mCurrentIndex).setSelected(false);
        }
        this.mCurrentIndex = i;
        this.agF.getChildAt(this.mCurrentIndex).setSelected(true);
    }

    public void a(co coVar) {
        this.cDu = coVar;
    }
}
