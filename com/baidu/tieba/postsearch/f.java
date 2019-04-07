package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class f {
    private PostSearchActivity ibZ;
    private PostSearchListFragment icM;
    private PostSearchListFragment icN;
    private PostSearchListFragment icO;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.ibZ = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void xA(int i) {
        if (this.mTabHost == null) {
            xB(1);
            return;
        }
        bVt();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment xD = xD(i);
            if (xD != null) {
                xD.pj(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void cI(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        cI(true);
        PostSearchListFragment xD = xD(i);
        if (xD != null) {
            xD.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            al.l(this.mTabHost.getFragmentTabWidget(), d.C0277d.cp_bg_line_d);
        }
    }

    private void xB(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.mTabHost.setup(this.ibZ.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.ibZ.getResources().getDimension(d.e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        bVs();
        this.mTabHost.gX(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        al.l(this.mTabHost.getFragmentTabWidget(), d.C0277d.cp_bg_line_d);
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void bVs() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.icM = new PostSearchListFragment(1);
        bVar.bHY = this.icM;
        bVar.bHX = xC(d.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.icN = new PostSearchListFragment(2);
        bVar2.bHY = this.icN;
        bVar2.bHX = xC(d.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.icO = new PostSearchListFragment(3);
        bVar3.bHY = this.icO;
        bVar3.bHX = xC(d.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator xC(int i) {
        int aO = (l.aO(this.ibZ.getPageContext().getContext()) - (this.ibZ.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.ibZ.getPageContext().getPageActivity()).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.ibZ.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.cnT = d.C0277d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.ibZ.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(aO);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment xD(int i) {
        switch (i) {
            case 1:
                return this.icM;
            case 2:
                return this.icN;
            case 3:
                return this.icO;
            default:
                return null;
        }
    }

    private void bVt() {
        this.icM.bVk();
        this.icN.bVk();
        this.icO.bVk();
    }
}
