package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int ctD;
    private ViewPager.OnPageChangeListener ctE;
    private final k ctF;
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
        this.ctD = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.ctF = new k(context);
        addView(this.ctF, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ctE = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ctF.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            ajZ();
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
            al.b(textView, i.c.cp_link_tip_a, 1);
        } else {
            al.b(textView, i.c.cp_cont_c, 1);
        }
        if (i == 0) {
            textView.setPadding(getResources().getDimensionPixelSize(i.d.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return textView;
    }

    private void ajZ() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        b bVar = new b(this, null);
        for (int i = 0; i < adapter.getCount(); i++) {
            TextView m = m(getContext(), i);
            m.setText(adapter.getPageTitle(i));
            m.setOnClickListener(bVar);
            this.ctF.addView(m);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.ctF != null) {
            this.ctF.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            au(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(int i, int i2) {
        View childAt;
        int childCount = this.ctF.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.ctF.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ctD;
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
            int childCount = SlidingTabLayout.this.ctF.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.ctF.d(i, f);
                View childAt = SlidingTabLayout.this.ctF.getChildAt(i);
                SlidingTabLayout.this.au(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.ctE != null) {
                    SlidingTabLayout.this.ctE.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.ctE != null) {
                SlidingTabLayout.this.ctE.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.ctF.av(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.ctF.d(i, 0.0f);
                SlidingTabLayout.this.au(i, 0);
            }
            if (SlidingTabLayout.this.ctE != null) {
                SlidingTabLayout.this.ctE.onPageSelected(i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ctF != null) {
            this.ctF.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.ctF.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.ctF.getChildAt(i)) {
                    SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }
}
