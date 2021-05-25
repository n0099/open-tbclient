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
    public int f17983e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f17984f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f17985g;

    /* renamed from: h  reason: collision with root package name */
    public int f17986h;

    /* renamed from: i  reason: collision with root package name */
    public final SlidingTabStrip f17987i;

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public int f17988e;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f17988e = i2;
            if (SlidingTabLayout.this.f17985g != null) {
                SlidingTabLayout.this.f17985g.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int childCount = SlidingTabLayout.this.f17987i.getChildCount();
            if (childCount == 0 || i2 < 0 || i2 >= childCount) {
                return;
            }
            View childAt = SlidingTabLayout.this.f17987i.getChildAt(i2);
            SlidingTabLayout.this.k(i2, childAt != null ? (int) (childAt.getWidth() * f2) : 0);
            if (SlidingTabLayout.this.f17985g != null) {
                SlidingTabLayout.this.f17985g.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            SlidingTabLayout.this.f17987i.b(i2, SlidingTabLayout.this.f17986h);
            SlidingTabLayout.this.f17986h = i2;
            if (this.f17988e == 0) {
                SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
                slidingTabLayout.k(i2, slidingTabLayout.f17986h);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, Integer.valueOf(SlidingTabLayout.this.f17986h)));
            if (SlidingTabLayout.this.f17985g != null) {
                SlidingTabLayout.this.f17985g.onPageSelected(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i2 = 0; i2 < SlidingTabLayout.this.f17987i.getChildCount(); i2++) {
                if (view == SlidingTabLayout.this.f17987i.getChildAt(i2)) {
                    SlidingTabLayout.this.f17984f.setCurrentItem(i2, false);
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

    public final void j(int i2) {
        PagerAdapter adapter = this.f17984f.getAdapter();
        c cVar = new c();
        for (int i3 = 0; i3 < adapter.getCount(); i3++) {
            TextView i4 = i(getContext());
            i4.setText(StringHelper.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i3)) + "", 8, null));
            i4.setOnClickListener(cVar);
            if (adapter.getCount() < 8) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds22);
                i4.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                this.f17987i.addView(i4, layoutParams);
            } else {
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds22);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds16);
                i4.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
                this.f17987i.addView(i4);
            }
            if (i3 == i2) {
                i4.setTextSize(0, getResources().getDimension(R.dimen.ds32));
                SkinManager.setViewTextColor(i4, R.color.CAM_X0308, 1);
            }
        }
    }

    public final void k(int i2, int i3) {
        View childAt;
        int childCount = this.f17987i.getChildCount();
        if (childCount == 0 || i2 < 0 || i2 >= childCount || (childAt = this.f17987i.getChildAt(i2)) == null) {
            return;
        }
        int left = childAt.getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.f17983e;
        }
        scrollTo(left, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewPager viewPager = this.f17984f;
        if (viewPager != null) {
            k(viewPager.getCurrentItem(), 0);
        }
    }

    public void onChangeSkinType(int i2) {
        SlidingTabStrip slidingTabStrip = this.f17987i;
        if (slidingTabStrip != null) {
            slidingTabStrip.a(i2);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f17985g = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager, int i2) {
        this.f17987i.removeAllViews();
        this.f17984f = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new b());
            j(i2);
        }
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17986h = 0;
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f17983e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.f17987i = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
