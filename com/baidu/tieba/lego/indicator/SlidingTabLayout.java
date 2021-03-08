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
/* loaded from: classes8.dex */
public class SlidingTabLayout extends MyHorizontalScrollView {
    private ViewPager aaw;
    private int currentIndex;
    private int kAX;
    private ViewPager.OnPageChangeListener kAY;
    private final SlidingTabStrip lil;

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
        this.kAX = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.lil = new SlidingTabStrip(context);
        addView(this.lil, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kAY = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager, int i) {
        this.lil.removeAllViews();
        this.aaw = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            El(i);
        }
    }

    protected TextView gx(Context context) {
        float dimension = getResources().getDimension(R.dimen.ds28);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextSize(0, dimension);
        ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
        return textView;
    }

    private void El(int i) {
        PagerAdapter adapter = this.aaw.getAdapter();
        b bVar = new b();
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            TextView gx = gx(getContext());
            gx.setText(au.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i2)) + "", 8, null));
            gx.setOnClickListener(bVar);
            if (adapter.getCount() < 8) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds22);
                gx.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                this.lil.addView(gx, layoutParams);
            } else {
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds22);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds16);
                gx.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
                this.lil.addView(gx);
            }
            if (i2 == i) {
                gx.setTextSize(0, getResources().getDimension(R.dimen.ds32));
                ap.setViewTextColor(gx, R.color.CAM_X0308, 1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aaw != null) {
            cL(this.aaw.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(int i, int i2) {
        View childAt;
        int childCount = this.lil.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.lil.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.kAX;
            }
            scrollTo(left, 0);
        }
    }

    /* loaded from: classes8.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.lil.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                View childAt = SlidingTabLayout.this.lil.getChildAt(i);
                SlidingTabLayout.this.cL(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.kAY != null) {
                    SlidingTabLayout.this.kAY.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.kAY != null) {
                SlidingTabLayout.this.kAY.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlidingTabLayout.this.lil.cO(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cL(i, SlidingTabLayout.this.currentIndex);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, Integer.valueOf(SlidingTabLayout.this.currentIndex)));
            if (SlidingTabLayout.this.kAY != null) {
                SlidingTabLayout.this.kAY.onPageSelected(i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lil != null) {
            this.lil.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.lil.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.lil.getChildAt(i)) {
                    SlidingTabLayout.this.aaw.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }
}
