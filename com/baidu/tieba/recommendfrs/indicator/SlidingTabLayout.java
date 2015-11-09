package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int cKR;
    private ViewPager.OnPageChangeListener cKS;
    private final k cKT;
    private int currentIndex;
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
        this.cKR = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cKT = new k(context);
        addView(this.cKT, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cKS = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cKT.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            arf();
        }
    }

    protected TextView m(Context context, int i) {
        float dimension = getResources().getDimension(i.d.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(i.d.ds20);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(0, dimension);
        if (i == 0) {
            an.b(textView, i.c.s_actionbar_text_line_color_s, 1);
        } else {
            an.b(textView, i.c.cp_cont_c, 1);
        }
        if (i == 0) {
            textView.setPadding(getResources().getDimensionPixelSize(i.d.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return textView;
    }

    private void arf() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        b bVar = new b(this, null);
        for (int i = 0; i < adapter.getCount(); i++) {
            TextView m = m(getContext(), i);
            m.setText(adapter.getPageTitle(i));
            m.setOnClickListener(bVar);
            this.cKT.addView(m);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cKT != null) {
            this.cKT.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            aE(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(int i, int i2) {
        View childAt;
        int childCount = this.cKT.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.cKT.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cKR;
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
            int childCount = SlidingTabLayout.this.cKT.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cKT.d(i, f);
                View childAt = SlidingTabLayout.this.cKT.getChildAt(i);
                SlidingTabLayout.this.aE(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cKS != null) {
                    SlidingTabLayout.this.cKS.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cKS != null) {
                SlidingTabLayout.this.cKS.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.cKT.aF(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cKT.d(i, 0.0f);
                SlidingTabLayout.this.aE(i, 0);
            }
            if (SlidingTabLayout.this.cKS != null) {
                SlidingTabLayout.this.cKS.onPageSelected(i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cKT != null) {
            this.cKT.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.cKT.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cKT.getChildAt(i)) {
                    SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }
}
