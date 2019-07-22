package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f {
    private PostSearchActivity iAZ;
    private PostSearchListFragment iBN;
    private PostSearchListFragment iBO;
    private PostSearchListFragment iBP;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.iAZ = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void zm(int i) {
        if (this.mTabHost == null) {
            zn(1);
            return;
        }
        cgp();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment zp = zp(i);
            if (zp != null) {
                zp.qm(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void dc(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        dc(true);
        PostSearchListFragment zp = zp(i);
        if (zp != null) {
            zp.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            am.l(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        }
    }

    private void zn(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.mTabHost.setup(this.iAZ.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.iAZ.getResources().getDimension(R.dimen.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        cgo();
        this.mTabHost.hR(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        am.l(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void cgo() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.iBN = new PostSearchListFragment(1);
        bVar.bQK = this.iBN;
        bVar.bQJ = zo(R.string.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.iBO = new PostSearchListFragment(2);
        bVar2.bQK = this.iBO;
        bVar2.bQJ = zo(R.string.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.iBP = new PostSearchListFragment(3);
        bVar3.bQK = this.iBP;
        bVar3.bQJ = zo(R.string.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator zo(int i) {
        int af = (l.af(this.iAZ.getPageContext().getContext()) - (this.iAZ.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.iAZ.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.iAZ.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.cxr = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.iAZ.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth(af);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment zp(int i) {
        switch (i) {
            case 1:
                return this.iBN;
            case 2:
                return this.iBO;
            case 3:
                return this.iBP;
            default:
                return null;
        }
    }

    private void cgp() {
        this.iBN.cgg();
        this.iBO.cgg();
        this.iBP.cgg();
    }
}
