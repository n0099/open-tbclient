package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class SlidingTabLayout extends MyHorizontalScrollView {
    private int currentIndex;
    private int fZt;
    private ViewPager.OnPageChangeListener fZu;
    private final SlidingTabStrip gLn;
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
        this.fZt = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.gLn = new SlidingTabStrip(context);
        addView(this.gLn, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fZu = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager, int i) {
        this.gLn.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            vd(i);
        }
    }

    protected TextView eb(Context context) {
        float dimension = getResources().getDimension(d.e.ds28);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextSize(0, dimension);
        al.d(textView, d.C0236d.cp_cont_b, 1);
        return textView;
    }

    private void vd(int i) {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        b bVar = new b();
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            TextView eb = eb(getContext());
            eb.setText(ap.g(((Object) adapter.getPageTitle(i2)) + "", 8, null));
            eb.setOnClickListener(bVar);
            if (adapter.getCount() < 8) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds22);
                eb.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                this.gLn.addView(eb, layoutParams);
            } else {
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds22);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds16);
                eb.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
                this.gLn.addView(eb);
            }
            if (i2 == i) {
                eb.setTextSize(0, getResources().getDimension(d.e.ds32));
                al.d(eb, d.C0236d.cp_other_b, 1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            bD(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, int i2) {
        View childAt;
        int childCount = this.gLn.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.gLn.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fZt;
            }
            scrollTo(left, 0);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.gLn.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                View childAt = SlidingTabLayout.this.gLn.getChildAt(i);
                SlidingTabLayout.this.bD(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.fZu != null) {
                    SlidingTabLayout.this.fZu.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.fZu != null) {
                SlidingTabLayout.this.fZu.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.gLn.bG(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.bD(i, SlidingTabLayout.this.currentIndex);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, Integer.valueOf(SlidingTabLayout.this.currentIndex)));
            if (SlidingTabLayout.this.fZu != null) {
                SlidingTabLayout.this.fZu.onPageSelected(i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gLn != null) {
            this.gLn.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.gLn.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.gLn.getChildAt(i)) {
                    SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }
}
