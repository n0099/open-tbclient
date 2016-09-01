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
    private LinearLayout aqH;
    private int axl;
    private Context context;
    private int count;
    private a fZE;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface a {
        void rd(int i);
    }

    public b(Context context) {
        super(context);
        this.axl = -1;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.aqH = new LinearLayout(context);
        this.aqH.setOrientation(1);
        this.aqH.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.aqH);
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
        view.setOnClickListener(new View$OnClickListenerC0081b(this.count, this.fZE));
        this.aqH.addView(view);
        this.count++;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void sT(int i) {
        if (this.axl != -1) {
            this.aqH.getChildAt(this.axl).setSelected(false);
        }
        this.axl = i;
        this.aqH.getChildAt(this.axl).setSelected(true);
    }

    public void a(a aVar) {
        this.fZE = aVar;
    }

    /* renamed from: com.baidu.tieba.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0081b implements View.OnClickListener {
        private a fZF;
        private int position;

        public View$OnClickListenerC0081b(int i, a aVar) {
            this.position = i;
            this.fZF = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fZF != null) {
                this.fZF.rd(this.position);
            }
        }
    }
}
