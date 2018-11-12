package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private PostSearchListFragment gAR;
    private PostSearchListFragment gAS;
    private PostSearchListFragment gAT;
    private PostSearchActivity gAd;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gAd = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void tg(int i) {
        if (this.mTabHost == null) {
            th(1);
            return;
        }
        brv();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment tj = tj(i);
            if (tj != null) {
                tj.mE(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void setVisibility(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        setVisibility(true);
        PostSearchListFragment tj = tj(i);
        if (tj != null) {
            tj.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
    }

    private void th(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(e.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(e.g.post_search_tab_host);
        this.mTabHost.setup(this.gAd.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.gAd.getResources().getDimension(e.C0200e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        bru();
        this.mTabHost.di(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void bru() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gAR = new PostSearchListFragment(1);
        bVar.avZ = this.gAR;
        bVar.avY = ti(e.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gAS = new PostSearchListFragment(2);
        bVar2.avZ = this.gAS;
        bVar2.avY = ti(e.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gAT = new PostSearchListFragment(3);
        bVar3.avZ = this.gAT;
        bVar3.avY = ti(e.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator ti(int i) {
        int aO = (l.aO(this.gAd.getPageContext().getContext()) - (this.gAd.getResources().getDimensionPixelSize(e.C0200e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gAd.getPageContext().getPageActivity()).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gAd.getResources().getDimensionPixelSize(e.C0200e.ds32));
        fragmentTabIndicator.baa = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gAd.getResources().getDimensionPixelSize(e.C0200e.ds4));
        fragmentTabIndicator.setWidth(aO);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment tj(int i) {
        switch (i) {
            case 1:
                return this.gAR;
            case 2:
                return this.gAS;
            case 3:
                return this.gAT;
            default:
                return null;
        }
    }

    private void brv() {
        this.gAR.brm();
        this.gAS.brm();
        this.gAT.brm();
    }
}
