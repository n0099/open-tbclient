package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int djn;
    private ViewPager.OnPageChangeListener djo;
    private final k djp;
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
        this.djn = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.djp = new k(context);
        addView(this.djp, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.djo = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.djp.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            awD();
        }
    }

    protected TextView m(Context context, int i) {
        float dimension = getResources().getDimension(n.d.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.d.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(n.d.ds20);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(0, dimension);
        if (i == 0) {
            as.b(textView, n.c.s_actionbar_text_line_color_s, 1);
        } else {
            as.b(textView, n.c.cp_cont_c, 1);
        }
        if (i == 0) {
            textView.setPadding(getResources().getDimensionPixelSize(n.d.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return textView;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x0021: INVOKE  (r5v0 java.lang.CharSequence A[REMOVE]) = (r1v0 android.support.v4.view.PagerAdapter), (r0v2 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void awD() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        b bVar = new b(this, null);
        for (int i = 0; i < adapter.getCount(); i++) {
            TextView m = m(getContext(), i);
            m.setText(ax.e(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            m.setOnClickListener(bVar);
            this.djp.addView(m);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.djp != null) {
            this.djp.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            aG(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i, int i2) {
        View childAt;
        int childCount = this.djp.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.djp.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.djn;
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
            int childCount = SlidingTabLayout.this.djp.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.djp.d(i, f);
                View childAt = SlidingTabLayout.this.djp.getChildAt(i);
                SlidingTabLayout.this.aG(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.djo != null) {
                    SlidingTabLayout.this.djo.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.djo != null) {
                SlidingTabLayout.this.djo.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.djp.aH(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.djp.d(i, 0.0f);
                SlidingTabLayout.this.aG(i, 0);
            }
            if (SlidingTabLayout.this.djo != null) {
                SlidingTabLayout.this.djo.onPageSelected(i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.djp != null) {
            this.djp.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.djp.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.djp.getChildAt(i)) {
                    SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }
}
