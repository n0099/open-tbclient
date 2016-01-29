package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class y {
    private FragmentTabHost aTI;
    private PostSearchActivity dxA;
    private s dyn;
    private s dyo;
    private s dyp;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity, View view) {
        this.dxA = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.aTI.getCurrentTabType();
    }

    public void na(int i) {
        if (this.aTI == null) {
            nb(1);
            return;
        }
        aDc();
        if (this.aTI.getCurrentTabType() == i) {
            s nd = nd(i);
            if (nd != null) {
                nd.hh(true);
                return;
            }
            return;
        }
        this.aTI.setCurrentTabByType(i);
    }

    public void hi(boolean z) {
        if (this.aTI != null) {
            if (z) {
                this.aTI.setVisibility(0);
            } else {
                this.aTI.setVisibility(8);
            }
        }
    }

    public void a(int i, k kVar, boolean z) {
        hi(true);
        s nd = nd(i);
        if (nd != null) {
            nd.a(kVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aTI != null) {
            this.aTI.onChangeSkinType(i);
        }
    }

    private void nb(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(t.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.aTI = (FragmentTabHost) inflate.findViewById(t.g.post_search_tab_host);
        this.aTI.setup(this.dxA.getSupportFragmentManager());
        this.aTI.setShouldDrawIndicatorLine(true);
        aDb();
        this.aTI.initViewPager();
        this.aTI.setCurrentTabByType(i);
        this.aTI.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aDb() {
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        this.dyn = new s(1);
        cVar.aay = this.dyn;
        cVar.aax = nc(t.j.searching_time_tab);
        cVar.mType = 1;
        this.aTI.a(cVar);
        FragmentTabHost.c cVar2 = new FragmentTabHost.c();
        this.dyo = new s(2);
        cVar2.aay = this.dyo;
        cVar2.aax = nc(t.j.searching_relative_tab);
        cVar2.mType = 2;
        this.aTI.a(cVar2);
        FragmentTabHost.c cVar3 = new FragmentTabHost.c();
        this.dyp = new s(3);
        cVar3.aay = this.dyp;
        cVar3.aax = nc(t.j.searching_only_thread_tab);
        cVar3.mType = 3;
        this.aTI.a(cVar3);
    }

    private FragmentTabIndicator nc(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.dxA.getPageContext().getPageActivity()).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.dxA.getResources().getDimensionPixelSize(t.e.ds32));
        fragmentTabIndicator.ayd = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.dxA.getResources().getDimensionPixelSize(t.e.ds4));
        return fragmentTabIndicator;
    }

    private s nd(int i) {
        switch (i) {
            case 1:
                return this.dyn;
            case 2:
                return this.dyo;
            case 3:
                return this.dyp;
            default:
                return null;
        }
    }

    private void aDc() {
        this.dyn.aCU();
        this.dyo.aCU();
        this.dyp.aCU();
    }
}
