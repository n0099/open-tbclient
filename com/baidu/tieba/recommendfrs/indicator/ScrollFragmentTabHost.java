package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabRootView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, c {
    private int Tv;
    private final List<e> Tx;
    private CustomViewPager Ty;
    private ScrollFragmentTabWidget cch;
    private e cci;
    private a ccj;
    private int cck;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.Tx = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Tx = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cck = context.getResources().getDimensionPixelSize(o.ds72);
        com.baidu.adp.lib.g.b.hr().a(context, r.scroll_fragment_tabhost, this, true);
        this.Tv = -1;
        this.cci = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.cch != null) {
            this.cch.getLayoutParams().height = i;
            this.cch.requestLayout();
        }
    }

    public void setTabWidgetViewWidth(int i) {
        if (this.cch != null) {
            this.cch.setIndicatorWidth(i);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.cch != null) {
            this.cch.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.cch = (ScrollFragmentTabWidget) findViewById(q.tabcontainer);
        this.cch.setTabSelectionListener(this);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.cch.setPadding(i, i2, i3, i4);
    }

    public void a(e eVar) {
        a(eVar, -1);
    }

    public void a(e eVar, int i) {
        if (eVar != null && eVar.ahL() != null && eVar.ahM() != null && !this.Tx.contains(eVar)) {
            this.cch.o(eVar.ahM(), i);
            if (i == -1) {
                this.Tx.add(eVar);
            } else {
                this.Tx.add(i, eVar);
            }
            if (this.Tv != -1 && i <= this.Tv) {
                this.Tv++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.Ty != null) {
            this.Ty.setScrollable(z);
        }
    }

    public int getTabcount() {
        return this.Tx.size();
    }

    public void initViewPager() {
        if (this.Ty != null) {
            removeView(this.Ty);
        }
        this.Ty = new CustomViewPager(this.mContext);
        this.Ty.setId(q.tab_content);
        this.Ty.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(this.Ty);
        this.Ty.setOffscreenPageLimit(1);
        this.Ty.setOnPageChangeListener(this);
        this.ccj = new a(this.mFragmentManager, this.Tx);
        this.Ty.setAdapter(this.ccj);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Tx.size() && i != this.Tv) {
            this.Tv = i;
            this.cci = this.Tx.get(this.Tv);
            this.cch.setCurrentTab(this.Tv);
            this.Ty.setCurrentItem(this.Tv, false);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.c
    public void c(int i, boolean z) {
        TiebaStatic.eventStat(this.mContext, "kantie_1", null, 1, "finetab", this.Tx.get(i).ahK());
        this.Ty.setCurrentItem(i, false);
    }

    public int getCurrentTabIndex() {
        return this.Tv;
    }

    public Fragment getCurrentFragment() {
        if (this.cci != null) {
            return this.cci.ahL();
        }
        return null;
    }

    public Fragment jc(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.ccj.getItem(jd(str));
    }

    public int jd(String str) {
        if (StringUtils.isNull(str) || this.Tx == null) {
            return -1;
        }
        String fixedText = UtilHelper.getFixedText(str, 4);
        int size = this.Tx.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.Tx.get(i);
            if (eVar != null && eVar.je(fixedText)) {
                return i;
            }
        }
        return -1;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Tx.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Ty.getId(), this.ccj.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.Tx.clear();
        this.cci = null;
        this.Tv = -1;
        this.cch.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.cch.onChangeSkinType(i);
        ay.d(this, n.cp_bg_line_d, i);
        if (this.ccj != null) {
            int count = this.ccj.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.ccj.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        im(i);
    }

    private void im(int i) {
        this.cch.smoothScrollTo(this.cch.in(i - 1) - this.cck, 0);
        this.Tv = i;
        this.cci = this.Tx.get(i);
        this.cch.setCurrentTab(this.Tv);
        ViewGroup viewGroup = (ViewGroup) this.cci.ahL().getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
