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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager ahW;
    private int currentIndex;
    private int dFG;
    private ViewPager.OnPageChangeListener dFH;
    private final o dFI;
    private b dFJ;
    private List<p> dFK;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.dFK = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.dFG = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.dFI = new o(context);
        addView(this.dFI, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dFH = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dFI.removeAllViews();
        this.ahW = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            aFR();
        }
    }

    protected p k(Context context, int i) {
        getResources().getDimension(t.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds20);
        p pVar = new p(context);
        pVar.uv();
        if (i == 0) {
            ar.b(pVar.getTextView(), t.d.s_actionbar_text_line_color_s, 1);
        } else {
            ar.b(pVar.getTextView(), t.d.cp_cont_c, 1);
        }
        if (i == 0) {
            pVar.getTextView().setPadding(getResources().getDimensionPixelSize(t.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            pVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return pVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x002f: INVOKE  (r6v0 java.lang.CharSequence A[REMOVE]) = (r1v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void aFR() {
        PagerAdapter adapter = this.ahW.getAdapter();
        c cVar = new c(this, null);
        this.dFK.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            p k = k(getContext(), i);
            this.dFK.add(k);
            k.getTextView().setText(aw.e(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            k.setOnClickListener(cVar);
            this.dFI.addView(k);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.dFI != null) {
            this.dFI.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ahW != null) {
            aV(this.ahW.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(int i, int i2) {
        int aW = aW(i, i2);
        if (aW > 0) {
            scrollTo(aW, 0);
        }
    }

    private int aW(int i, int i2) {
        View childAt;
        int childCount = this.dFI.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.dFI.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.dFG;
        }
        return left;
    }

    public void aU(int i, int i2) {
        p pVar;
        if (!x.p(this.dFK) && (pVar = (p) x.b(this.dFK, i)) != null) {
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
            if (f > 0.0f && (childCount = SlidingTabLayout.this.dFI.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.dFI.d(i, f);
                View childAt = SlidingTabLayout.this.dFI.getChildAt(i);
                SlidingTabLayout.this.aV(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.dFH != null) {
                    SlidingTabLayout.this.dFH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.dFH != null) {
                SlidingTabLayout.this.dFH.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.dFI.aZ(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.aX(i2, i);
            }
            if (SlidingTabLayout.this.dFH != null) {
                SlidingTabLayout.this.dFH.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, int i2) {
        clearAnimation();
        if (this.dFJ == null) {
            this.dFJ = new b(this, null);
            this.dFJ.setDuration(300L);
        }
        int aW = aW(i2, 0);
        this.dFJ.nB(i);
        this.dFJ.aY(getScrollX(), aW);
        startAnimation(this.dFJ);
    }

    public void onChangeSkinType(int i) {
        if (this.dFI != null) {
            this.dFI.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.dFI.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.dFI.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.ahW.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int dFM;
        private int dFN;
        private int dFO;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void nB(int i) {
            this.dFO = i;
        }

        public void aY(int i, int i2) {
            this.dFM = i;
            this.dFN = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.dFN - this.dFM) * f) + this.dFM), 0);
            if (SlidingTabLayout.this.dFI != null) {
                SlidingTabLayout.this.dFI.f(this.dFO, f);
            }
        }
    }
}
