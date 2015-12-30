package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int dpR;
    private ViewPager.OnPageChangeListener dpS;
    private final k dpT;
    private ViewPager mViewPager;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.dpR = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.dpT = new k(context);
        addView(this.dpT, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dpS = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dpT.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            ayJ();
        }
    }

    protected TextView m(Context context, int i) {
        float dimension = getResources().getDimension(n.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(n.e.ds20);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(0, dimension);
        if (i == 0) {
            as.b(textView, n.d.s_actionbar_text_line_color_s, 1);
        } else {
            as.b(textView, n.d.cp_cont_c, 1);
        }
        if (i == 0) {
            textView.setPadding(getResources().getDimensionPixelSize(n.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return textView;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x0021: INVOKE  (r5v0 java.lang.CharSequence A[REMOVE]) = (r1v0 android.support.v4.view.PagerAdapter), (r0v2 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void ayJ() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        b bVar = new b(this, null);
        for (int i = 0; i < adapter.getCount(); i++) {
            TextView m = m(getContext(), i);
            m.setText(ax.e(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            m.setOnClickListener(bVar);
            this.dpT.addView(m);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.dpT != null) {
            this.dpT.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            aV(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(int i, int i2) {
        View childAt;
        int childCount = this.dpT.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.dpT.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dpR;
            }
            scrollTo(left, 0);
        }
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        /* synthetic */ a(SlidingTabLayout slidingTabLayout, a aVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.dpT.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.dpT.d(i, f);
                View childAt = SlidingTabLayout.this.dpT.getChildAt(i);
                SlidingTabLayout.this.aV(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.dpS != null) {
                    SlidingTabLayout.this.dpS.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.dpS != null) {
                SlidingTabLayout.this.dpS.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.dpT.aW(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.dpT.d(i, 0.0f);
                SlidingTabLayout.this.aV(i, 0);
            }
            if (SlidingTabLayout.this.dpS != null) {
                SlidingTabLayout.this.dpS.onPageSelected(i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dpT != null) {
            this.dpT.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.dpT.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.dpT.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }
}
