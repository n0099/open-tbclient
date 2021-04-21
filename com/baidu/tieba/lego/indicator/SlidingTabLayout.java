package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SlidingTabLayout extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public int f18397e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f18398f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f18399g;

    /* renamed from: h  reason: collision with root package name */
    public int f18400h;
    public final SlidingTabStrip i;

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public int f18401e;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.f18401e = i;
            if (SlidingTabLayout.this.f18399g != null) {
                SlidingTabLayout.this.f18399g.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            int childCount = SlidingTabLayout.this.i.getChildCount();
            if (childCount == 0 || i < 0 || i >= childCount) {
                return;
            }
            View childAt = SlidingTabLayout.this.i.getChildAt(i);
            SlidingTabLayout.this.k(i, childAt != null ? (int) (childAt.getWidth() * f2) : 0);
            if (SlidingTabLayout.this.f18399g != null) {
                SlidingTabLayout.this.f18399g.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.i.b(i, SlidingTabLayout.this.f18400h);
            SlidingTabLayout.this.f18400h = i;
            if (this.f18401e == 0) {
                SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
                slidingTabLayout.k(i, slidingTabLayout.f18400h);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, Integer.valueOf(SlidingTabLayout.this.f18400h)));
            if (SlidingTabLayout.this.f18399g != null) {
                SlidingTabLayout.this.f18399g.onPageSelected(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.i.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.i.getChildAt(i)) {
                    SlidingTabLayout.this.f18398f.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public TextView i(Context context) {
        float dimension = getResources().getDimension(R.dimen.ds28);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextSize(0, dimension);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        return textView;
    }

    public final void j(int i) {
        PagerAdapter adapter = this.f18398f.getAdapter();
        c cVar = new c();
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            TextView i3 = i(getContext());
            i3.setText(StringHelper.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i2)) + "", 8, null));
            i3.setOnClickListener(cVar);
            if (adapter.getCount() < 8) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds22);
                i3.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                this.i.addView(i3, layoutParams);
            } else {
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds22);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds16);
                i3.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
                this.i.addView(i3);
            }
            if (i2 == i) {
                i3.setTextSize(0, getResources().getDimension(R.dimen.ds32));
                SkinManager.setViewTextColor(i3, R.color.CAM_X0308, 1);
            }
        }
    }

    public final void k(int i, int i2) {
        View childAt;
        int childCount = this.i.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.i.getChildAt(i)) == null) {
            return;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.f18397e;
        }
        scrollTo(left, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewPager viewPager = this.f18398f;
        if (viewPager != null) {
            k(viewPager.getCurrentItem(), 0);
        }
    }

    public void onChangeSkinType(int i) {
        SlidingTabStrip slidingTabStrip = this.i;
        if (slidingTabStrip != null) {
            slidingTabStrip.a(i);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f18399g = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager, int i) {
        this.i.removeAllViews();
        this.f18398f = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new b());
            j(i);
        }
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18400h = 0;
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f18397e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.i = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
