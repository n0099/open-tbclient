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
public class i extends PopupWindow {
    private Context context;
    private int count;
    private LinearLayout ehT;
    private a lQS;
    private int mCurrentIndex;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface a {
        void Dv(int i);
    }

    public i(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.ehT = new LinearLayout(context);
        this.ehT.setOrientation(1);
        this.ehT.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.ehT);
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
        view.setOnClickListener(new b(this.count, this.lQS));
        this.ehT.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setCurrentIndex(int i) {
        if (this.mCurrentIndex != -1) {
            this.ehT.getChildAt(this.mCurrentIndex).setSelected(false);
        }
        this.mCurrentIndex = i;
        this.ehT.getChildAt(this.mCurrentIndex).setSelected(true);
    }

    public void a(a aVar) {
        this.lQS = aVar;
    }

    /* loaded from: classes.dex */
    public static class b implements View.OnClickListener {
        private a lQT;
        private int position;

        public b(int i, a aVar) {
            this.position = i;
            this.lQT = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.lQT != null) {
                this.lQT.Dv(this.position);
            }
        }
    }
}
