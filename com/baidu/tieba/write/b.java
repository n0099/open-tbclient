package com.baidu.tieba.write;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import com.baidu.adp.lib.util.k;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class b extends PopupWindow {
    private LinearLayout arj;
    private int axF;
    private Context context;
    private int count;
    private a gjs;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface a {
        void rK(int i);
    }

    public b(Context context) {
        super(context);
        this.axF = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.arj = new LinearLayout(context);
        this.arj.setOrientation(1);
        this.arj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.arj);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setPadding(0, 0, k.dip2px(context, 1.0f), k.dip2px(context, 1.0f));
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
        view.setOnClickListener(new View$OnClickListenerC0084b(this.count, this.gjs));
        this.arj.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void tD(int i) {
        if (this.axF != -1) {
            this.arj.getChildAt(this.axF).setSelected(false);
        }
        this.axF = i;
        this.arj.getChildAt(this.axF).setSelected(true);
    }

    public void a(a aVar) {
        this.gjs = aVar;
    }

    /* renamed from: com.baidu.tieba.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0084b implements View.OnClickListener {
        private a gjt;
        private int position;

        public View$OnClickListenerC0084b(int i, a aVar) {
            this.position = i;
            this.gjt = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gjt != null) {
                this.gjt.rK(this.position);
            }
        }
    }
}
