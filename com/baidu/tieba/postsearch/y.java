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
    private FragmentTabHost aTo;
    private PostSearchActivity dUY;
    private s dVL;
    private s dVM;
    private s dVN;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity, View view) {
        this.dUY = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.aTo.getCurrentTabType();
    }

    public void nY(int i) {
        if (this.aTo == null) {
            nZ(1);
            return;
        }
        aKX();
        if (this.aTo.getCurrentTabType() == i) {
            s ob = ob(i);
            if (ob != null) {
                ob.iE(true);
                return;
            }
            return;
        }
        this.aTo.setCurrentTabByType(i);
    }

    public void iF(boolean z) {
        if (this.aTo != null) {
            if (z) {
                this.aTo.setVisibility(0);
            } else {
                this.aTo.setVisibility(8);
            }
        }
    }

    public void a(int i, k kVar, boolean z) {
        iF(true);
        s ob = ob(i);
        if (ob != null) {
            ob.a(kVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aTo != null) {
            this.aTo.onChangeSkinType(i);
        }
    }

    private void nZ(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(t.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.aTo = (FragmentTabHost) inflate.findViewById(t.g.post_search_tab_host);
        this.aTo.setup(this.dUY.getSupportFragmentManager());
        this.aTo.setTabWidgetViewHeight((int) this.dUY.getResources().getDimension(t.e.ds80));
        this.aTo.setShouldDrawIndicatorLine(true);
        aKW();
        this.aTo.ch(3);
        this.aTo.setCurrentTabByType(i);
        this.aTo.setNeedShowThemeStyle(false);
        this.aTo.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.aTo.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    private void aKW() {
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        this.dVL = new s(1);
        cVar.Vd = this.dVL;
        cVar.Vc = oa(t.j.searching_time_tab);
        cVar.mType = 1;
        this.aTo.a(cVar);
        FragmentTabHost.c cVar2 = new FragmentTabHost.c();
        this.dVM = new s(2);
        cVar2.Vd = this.dVM;
        cVar2.Vc = oa(t.j.searching_relative_tab);
        cVar2.mType = 2;
        this.aTo.a(cVar2);
        FragmentTabHost.c cVar3 = new FragmentTabHost.c();
        this.dVN = new s(3);
        cVar3.Vd = this.dVN;
        cVar3.Vc = oa(t.j.searching_only_thread_tab);
        cVar3.mType = 3;
        this.aTo.a(cVar3);
    }

    private FragmentTabIndicator oa(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.dUY.getPageContext().getPageActivity()).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.dUY.getResources().getDimensionPixelSize(t.e.ds32));
        fragmentTabIndicator.auL = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.dUY.getResources().getDimensionPixelSize(t.e.ds4));
        return fragmentTabIndicator;
    }

    private s ob(int i) {
        switch (i) {
            case 1:
                return this.dVL;
            case 2:
                return this.dVM;
            case 3:
                return this.dVN;
            default:
                return null;
        }
    }

    private void aKX() {
        this.dVL.aKP();
        this.dVM.aKP();
        this.dVN.aKP();
    }
}
