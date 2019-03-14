package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import com.baidu.adp.lib.util.l;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class h extends PopupWindow {
    private int biS;
    private LinearLayout ceE;
    private Context context;
    private int count;
    private a jmu;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface a {
        void yZ(int i);
    }

    public h(Context context) {
        super(context);
        this.biS = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.ceE = new LinearLayout(context);
        this.ceE.setOrientation(1);
        this.ceE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.ceE);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setPadding(0, 0, l.dip2px(context, 1.0f), l.dip2px(context, 1.0f));
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
        view.setOnClickListener(new b(this.count, this.jmu));
        this.ceE.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setCurrentIndex(int i) {
        if (this.biS != -1) {
            this.ceE.getChildAt(this.biS).setSelected(false);
        }
        this.biS = i;
        this.ceE.getChildAt(this.biS).setSelected(true);
    }

    public void a(a aVar) {
        this.jmu = aVar;
    }

    /* loaded from: classes.dex */
    public static class b implements View.OnClickListener {
        private a jmv;
        private int position;

        public b(int i, a aVar) {
            this.position = i;
            this.jmv = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jmv != null) {
                this.jmv.yZ(this.position);
            }
        }
    }
}
