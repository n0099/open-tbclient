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
    private int aBF;
    private LinearLayout avs;
    private Context context;
    private int count;
    private a fTm;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface a {
        void rP(int i);
    }

    public b(Context context) {
        super(context);
        this.aBF = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.avs = new LinearLayout(context);
        this.avs.setOrientation(1);
        this.avs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.avs);
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
        view.setOnClickListener(new View$OnClickListenerC0084b(this.count, this.fTm));
        this.avs.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void te(int i) {
        if (this.aBF != -1) {
            this.avs.getChildAt(this.aBF).setSelected(false);
        }
        this.aBF = i;
        this.avs.getChildAt(this.aBF).setSelected(true);
    }

    public void a(a aVar) {
        this.fTm = aVar;
    }

    /* renamed from: com.baidu.tieba.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0084b implements View.OnClickListener {
        private a fTn;
        private int position;

        public View$OnClickListenerC0084b(int i, a aVar) {
            this.position = i;
            this.fTn = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fTn != null) {
                this.fTn.rP(this.position);
            }
        }
    }
}
