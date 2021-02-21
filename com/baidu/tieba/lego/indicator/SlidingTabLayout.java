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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class SlidingTabLayout extends MyHorizontalScrollView {
    private ViewPager Ze;
    private int currentIndex;
    private int kyV;
    private ViewPager.OnPageChangeListener kyW;
    private final SlidingTabStrip lgj;

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
        this.kyV = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.lgj = new SlidingTabStrip(context);
        addView(this.lgj, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kyW = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager, int i) {
        this.lgj.removeAllViews();
        this.Ze = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            Ei(i);
        }
    }

    protected TextView gy(Context context) {
        float dimension = getResources().getDimension(R.dimen.ds28);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextSize(0, dimension);
        ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
        return textView;
    }

    private void Ei(int i) {
        PagerAdapter adapter = this.Ze.getAdapter();
        b bVar = new b();
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            TextView gy = gy(getContext());
            gy.setText(au.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i2)) + "", 8, null));
            gy.setOnClickListener(bVar);
            if (adapter.getCount() < 8) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds22);
                gy.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                this.lgj.addView(gy, layoutParams);
            } else {
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds22);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds16);
                gy.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
                this.lgj.addView(gy);
            }
            if (i2 == i) {
                gy.setTextSize(0, getResources().getDimension(R.dimen.ds32));
                ap.setViewTextColor(gy, R.color.CAM_X0308, 1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Ze != null) {
            cL(this.Ze.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(int i, int i2) {
        View childAt;
        int childCount = this.lgj.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.lgj.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.kyV;
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
            int childCount = SlidingTabLayout.this.lgj.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                View childAt = SlidingTabLayout.this.lgj.getChildAt(i);
                SlidingTabLayout.this.cL(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.kyW != null) {
                    SlidingTabLayout.this.kyW.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.kyW != null) {
                SlidingTabLayout.this.kyW.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.lgj.cO(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cL(i, SlidingTabLayout.this.currentIndex);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, Integer.valueOf(SlidingTabLayout.this.currentIndex)));
            if (SlidingTabLayout.this.kyW != null) {
                SlidingTabLayout.this.kyW.onPageSelected(i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lgj != null) {
            this.lgj.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.lgj.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.lgj.getChildAt(i)) {
                    SlidingTabLayout.this.Ze.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }
}
