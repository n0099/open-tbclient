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
public class cf extends PopupWindow {
    private int auZ;
    private LinearLayout container;
    private Context context;
    private int count;
    private a dZj;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface a {
        void ok(int i);
    }

    public cf(Context context) {
        super(context);
        this.auZ = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.container = new LinearLayout(context);
        this.container.setOrientation(1);
        this.container.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.container);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setPadding(0, 0, com.baidu.adp.lib.util.k.dip2px(context, 1.0f), com.baidu.adp.lib.util.k.dip2px(context, 1.0f));
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
        view.setOnClickListener(new b(this.count, this.dZj));
        this.container.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void od(int i) {
        if (this.auZ != -1) {
            this.container.getChildAt(this.auZ).setSelected(false);
        }
        this.auZ = i;
        this.container.getChildAt(this.auZ).setSelected(true);
    }

    public void a(a aVar) {
        this.dZj = aVar;
    }

    /* loaded from: classes.dex */
    public static class b implements View.OnClickListener {
        private a dZk;
        private int position;

        public b(int i, a aVar) {
            this.position = i;
            this.dZk = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dZk != null) {
                this.dZk.ok(this.position);
            }
        }
    }
}
