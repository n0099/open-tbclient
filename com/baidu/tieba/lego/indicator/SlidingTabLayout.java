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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class SlidingTabLayout extends MyHorizontalScrollView {
    private ViewPager Zk;
    private int currentIndex;
    private int kvf;
    private ViewPager.OnPageChangeListener kvg;
    private final SlidingTabStrip lcy;

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
        this.kvf = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.lcy = new SlidingTabStrip(context);
        addView(this.lcy, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kvg = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager, int i) {
        this.lcy.removeAllViews();
        this.Zk = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            Fw(i);
        }
    }

    protected TextView gA(Context context) {
        float dimension = getResources().getDimension(R.dimen.ds28);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextSize(0, dimension);
        ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
        return textView;
    }

    private void Fw(int i) {
        PagerAdapter adapter = this.Zk.getAdapter();
        b bVar = new b();
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            TextView gA = gA(getContext());
            gA.setText(at.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i2)) + "", 8, null));
            gA.setOnClickListener(bVar);
            if (adapter.getCount() < 8) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds22);
                gA.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                this.lcy.addView(gA, layoutParams);
            } else {
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds22);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds16);
                gA.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
                this.lcy.addView(gA);
            }
            if (i2 == i) {
                gA.setTextSize(0, getResources().getDimension(R.dimen.ds32));
                ao.setViewTextColor(gA, R.color.CAM_X0308, 1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Zk != null) {
            cN(this.Zk.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i, int i2) {
        View childAt;
        int childCount = this.lcy.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.lcy.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.kvf;
            }
            scrollTo(left, 0);
        }
    }

    /* loaded from: classes9.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.lcy.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                View childAt = SlidingTabLayout.this.lcy.getChildAt(i);
                SlidingTabLayout.this.cN(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.kvg != null) {
                    SlidingTabLayout.this.kvg.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.kvg != null) {
                SlidingTabLayout.this.kvg.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.lcy.cQ(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cN(i, SlidingTabLayout.this.currentIndex);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, Integer.valueOf(SlidingTabLayout.this.currentIndex)));
            if (SlidingTabLayout.this.kvg != null) {
                SlidingTabLayout.this.kvg.onPageSelected(i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lcy != null) {
            this.lcy.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.lcy.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.lcy.getChildAt(i)) {
                    SlidingTabLayout.this.Zk.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }
}
