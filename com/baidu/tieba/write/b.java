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
    private int aBT;
    private LinearLayout avE;
    private Context context;
    private int count;
    private a fOS;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface a {
        void rA(int i);
    }

    public b(Context context) {
        super(context);
        this.aBT = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.avE = new LinearLayout(context);
        this.avE.setOrientation(1);
        this.avE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.avE);
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
        view.setOnClickListener(new View$OnClickListenerC0076b(this.count, this.fOS));
        this.avE.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void sQ(int i) {
        if (this.aBT != -1) {
            this.avE.getChildAt(this.aBT).setSelected(false);
        }
        this.aBT = i;
        this.avE.getChildAt(this.aBT).setSelected(true);
    }

    public void a(a aVar) {
        this.fOS = aVar;
    }

    /* renamed from: com.baidu.tieba.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0076b implements View.OnClickListener {
        private a fOT;
        private int position;

        public View$OnClickListenerC0076b(int i, a aVar) {
            this.position = i;
            this.fOT = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fOT != null) {
                this.fOT.rA(this.position);
            }
        }
    }
}
