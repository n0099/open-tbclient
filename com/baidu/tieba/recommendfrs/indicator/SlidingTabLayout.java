package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager aim;
    private int cIw;
    private ViewPager.OnPageChangeListener cIx;
    private int currentIndex;
    private b dXA;
    private List<p> dXB;
    private final o dXz;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.dXB = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cIw = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.dXz = new o(context);
        addView(this.dXz, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cIx = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dXz.removeAllViews();
        this.aim = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            aon();
        }
    }

    protected p n(Context context, int i) {
        getResources().getDimension(t.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds20);
        p pVar = new p(context);
        pVar.uA();
        if (i == 0) {
            at.b(pVar.getTextView(), t.d.s_actionbar_text_line_color_s, 1);
        } else {
            at.b(pVar.getTextView(), t.d.cp_cont_c, 1);
        }
        if (i == 0) {
            pVar.getTextView().setPadding(getResources().getDimensionPixelSize(t.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            pVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return pVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x002f: INVOKE  (r6v0 java.lang.CharSequence A[REMOVE]) = (r1v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void aon() {
        PagerAdapter adapter = this.aim.getAdapter();
        c cVar = new c(this, null);
        this.dXB.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            p n = n(getContext(), i);
            this.dXB.add(n);
            n.getTextView().setText(ay.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            n.setOnClickListener(cVar);
            this.dXz.addView(n);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.dXz != null) {
            this.dXz.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aim != null) {
            aH(this.aim.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(int i, int i2) {
        int aV = aV(i, i2);
        if (aV >= 0) {
            scrollTo(aV, 0);
        }
    }

    private int aV(int i, int i2) {
        View childAt;
        int childCount = this.dXz.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.dXz.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cIw;
        }
        return left;
    }

    public void aU(int i, int i2) {
        p pVar;
        if (!y.q(this.dXB) && (pVar = (p) y.b(this.dXB, i)) != null) {
            if (i2 > 0) {
                pVar.getRedTipView().setVisibility(0);
            } else {
                pVar.getRedTipView().setVisibility(8);
            }
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
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.dXz.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.dXz.e(i, f);
                View childAt = SlidingTabLayout.this.dXz.getChildAt(i);
                SlidingTabLayout.this.aH(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cIx != null) {
                    SlidingTabLayout.this.cIx.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cIx != null) {
                SlidingTabLayout.this.cIx.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.dXz.aI(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.aW(i2, i);
            }
            if (SlidingTabLayout.this.cIx != null) {
                SlidingTabLayout.this.cIx.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(int i, int i2) {
        clearAnimation();
        if (this.dXA == null) {
            this.dXA = new b(this, null);
            this.dXA.setDuration(300L);
        }
        int aV = aV(i2, 0);
        this.dXA.oE(i);
        this.dXA.aX(getScrollX(), aV);
        startAnimation(this.dXA);
    }

    public void onChangeSkinType(int i) {
        if (this.dXz != null) {
            this.dXz.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        /* synthetic */ c(SlidingTabLayout slidingTabLayout, c cVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.dXz.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.dXz.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.aim.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int dXD;
        private int dXE;
        private int dXF;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void oE(int i) {
            this.dXF = i;
        }

        public void aX(int i, int i2) {
            this.dXD = i;
            this.dXE = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.dXE - this.dXD) * f) + this.dXD), 0);
            if (SlidingTabLayout.this.dXz != null) {
                SlidingTabLayout.this.dXz.g(this.dXF, f);
            }
        }
    }
}
