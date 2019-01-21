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
    private PostSearchActivity gKP;
    private PostSearchListFragment gLD;
    private PostSearchListFragment gLE;
    private PostSearchListFragment gLF;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gKP = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void tR(int i) {
        if (this.mTabHost == null) {
            tS(1);
            return;
        }
        buI();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment tU = tU(i);
            if (tU != null) {
                tU.mK(true);
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
        PostSearchListFragment tU = tU(i);
        if (tU != null) {
            tU.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
    }

    private void tS(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(e.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(e.g.post_search_tab_host);
        this.mTabHost.setup(this.gKP.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.gKP.getResources().getDimension(e.C0210e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        buH();
        this.mTabHost.dw(3);
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

    private void buH() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gLD = new PostSearchListFragment(1);
        bVar.aAc = this.gLD;
        bVar.aAb = tT(e.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gLE = new PostSearchListFragment(2);
        bVar2.aAc = this.gLE;
        bVar2.aAb = tT(e.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gLF = new PostSearchListFragment(3);
        bVar3.aAc = this.gLF;
        bVar3.aAb = tT(e.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator tT(int i) {
        int aO = (l.aO(this.gKP.getPageContext().getContext()) - (this.gKP.getResources().getDimensionPixelSize(e.C0210e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gKP.getPageContext().getPageActivity()).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gKP.getResources().getDimensionPixelSize(e.C0210e.ds32));
        fragmentTabIndicator.ben = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gKP.getResources().getDimensionPixelSize(e.C0210e.ds4));
        fragmentTabIndicator.setWidth(aO);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment tU(int i) {
        switch (i) {
            case 1:
                return this.gLD;
            case 2:
                return this.gLE;
            case 3:
                return this.gLF;
            default:
                return null;
        }
    }

    private void buI() {
        this.gLD.buz();
        this.gLE.buz();
        this.gLF.buz();
    }
}
