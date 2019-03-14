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
    private PostSearchActivity icn;
    private PostSearchListFragment ida;
    private PostSearchListFragment idb;
    private PostSearchListFragment idc;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.icn = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void xE(int i) {
        if (this.mTabHost == null) {
            xF(1);
            return;
        }
        bVx();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment xH = xH(i);
            if (xH != null) {
                xH.pj(true);
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
        PostSearchListFragment xH = xH(i);
        if (xH != null) {
            xH.a(bVar, z);
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

    private void xF(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.mTabHost.setup(this.icn.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.icn.getResources().getDimension(d.e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        bVw();
        this.mTabHost.gY(3);
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

    private void bVw() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.ida = new PostSearchListFragment(1);
        bVar.bHW = this.ida;
        bVar.bHV = xG(d.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.idb = new PostSearchListFragment(2);
        bVar2.bHW = this.idb;
        bVar2.bHV = xG(d.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.idc = new PostSearchListFragment(3);
        bVar3.bHW = this.idc;
        bVar3.bHV = xG(d.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator xG(int i) {
        int aO = (l.aO(this.icn.getPageContext().getContext()) - (this.icn.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.icn.getPageContext().getPageActivity()).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.icn.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.cnR = d.C0277d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.icn.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(aO);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment xH(int i) {
        switch (i) {
            case 1:
                return this.ida;
            case 2:
                return this.idb;
            case 3:
                return this.idc;
            default:
                return null;
        }
    }

    private void bVx() {
        this.ida.bVo();
        this.idb.bVo();
        this.idc.bVo();
    }
}
