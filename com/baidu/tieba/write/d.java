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
public class d extends PopupWindow {
    private int aFG;
    private LinearLayout ayZ;
    private Context context;
    private int count;
    private a haZ;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface a {
        void sO(int i);
    }

    public d(Context context) {
        super(context);
        this.aFG = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.ayZ = new LinearLayout(context);
        this.ayZ.setOrientation(1);
        this.ayZ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.ayZ);
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
    public void showAsDropDown(View view2, int i, int i2) {
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.context.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.context.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        if (measuredWidth < view2.getWidth()) {
            measuredWidth = view2.getWidth();
        }
        int measuredHeight = getContentView().getMeasuredHeight();
        if (measuredHeight > this.maxHeight) {
            measuredHeight = this.maxHeight;
        }
        setWidth(measuredWidth);
        setHeight(measuredHeight);
        super.showAsDropDown(view2, i, i2);
    }

    public void addView(View view2) {
        view2.setOnClickListener(new b(this.count, this.haZ));
        this.ayZ.addView(view2);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setCurrentIndex(int i) {
        if (this.aFG != -1) {
            this.ayZ.getChildAt(this.aFG).setSelected(false);
        }
        this.aFG = i;
        this.ayZ.getChildAt(this.aFG).setSelected(true);
    }

    public void a(a aVar) {
        this.haZ = aVar;
    }

    /* loaded from: classes.dex */
    public static class b implements View.OnClickListener {
        private a hba;
        private int position;

        public b(int i, a aVar) {
            this.position = i;
            this.hba = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.hba != null) {
                this.hba.sO(this.position);
            }
        }
    }
}
