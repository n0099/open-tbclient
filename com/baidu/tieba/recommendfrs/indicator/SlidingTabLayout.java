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
    private ViewPager asg;
    private int cJa;
    private ViewPager.OnPageChangeListener cJb;
    private int currentIndex;
    private final p eaJ;
    private b eaK;
    private List<q> eaL;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.eaL = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cJa = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.eaJ = new p(context);
        addView(this.eaJ, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cJb = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eaJ.removeAllViews();
        this.asg = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            aoq();
        }
    }

    protected q n(Context context, int i) {
        getResources().getDimension(t.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds20);
        q qVar = new q(context);
        qVar.sf();
        if (i == 0) {
            at.c(qVar.getTextView(), t.d.s_actionbar_text_line_color_s, 1);
        } else {
            at.c(qVar.getTextView(), t.d.cp_cont_c, 1);
        }
        if (i == 0) {
            qVar.getTextView().setPadding(getResources().getDimensionPixelSize(t.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            qVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return qVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x002f: INVOKE  (r6v0 java.lang.CharSequence A[REMOVE]) = (r1v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void aoq() {
        PagerAdapter adapter = this.asg.getAdapter();
        c cVar = new c(this, null);
        this.eaL.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            q n = n(getContext(), i);
            this.eaL.add(n);
            n.getTextView().setText(ay.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            n.setOnClickListener(cVar);
            this.eaJ.addView(n);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.eaJ != null) {
            this.eaJ.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.asg != null) {
            aG(this.asg.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i, int i2) {
        int aW = aW(i, i2);
        if (aW >= 0) {
            scrollTo(aW, 0);
        }
    }

    private int aW(int i, int i2) {
        View childAt;
        int childCount = this.eaJ.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.eaJ.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cJa;
        }
        return left;
    }

    public void aV(int i, int i2) {
        q qVar;
        if (!y.s(this.eaL) && (qVar = (q) y.c(this.eaL, i)) != null) {
            if (i2 > 0) {
                qVar.getRedTipView().setVisibility(0);
            } else {
                qVar.getRedTipView().setVisibility(8);
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.eaJ.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.eaJ.e(i, f);
                View childAt = SlidingTabLayout.this.eaJ.getChildAt(i);
                SlidingTabLayout.this.aG(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cJb != null) {
                    SlidingTabLayout.this.cJb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cJb != null) {
                SlidingTabLayout.this.cJb.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.eaJ.aH(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.aX(i2, i);
            }
            if (SlidingTabLayout.this.cJb != null) {
                SlidingTabLayout.this.cJb.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, int i2) {
        clearAnimation();
        if (this.eaK == null) {
            this.eaK = new b(this, null);
            this.eaK.setDuration(300L);
        }
        int aW = aW(i2, 0);
        this.eaK.oy(i);
        this.eaK.aN(getScrollX(), aW);
        startAnimation(this.eaK);
    }

    public void onChangeSkinType(int i) {
        if (this.eaJ != null) {
            this.eaJ.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.eaJ.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.eaJ.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.asg.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int eaN;
        private int eaO;
        private int eaP;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void oy(int i) {
            this.eaP = i;
        }

        public void aN(int i, int i2) {
            this.eaN = i;
            this.eaO = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.eaO - this.eaN) * f) + this.eaN), 0);
            if (SlidingTabLayout.this.eaJ != null) {
                SlidingTabLayout.this.eaJ.g(this.eaP, f);
            }
        }
    }
}
