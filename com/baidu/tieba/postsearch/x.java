package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class x {
    private FragmentTabHost blo;
    private r deM;
    private r deN;
    private r deO;
    private PostSearchActivity deb;
    private View mRootView;

    public x(PostSearchActivity postSearchActivity, View view) {
        this.deb = postSearchActivity;
        this.mRootView = view;
    }

    public void lA(int i) {
        if (this.blo == null) {
            lB(1);
            return;
        }
        auN();
        if (this.blo.getCurrentTabType() == i) {
            r lD = lD(i);
            if (lD != null) {
                lD.gF(true);
                return;
            }
            return;
        }
        this.blo.setCurrentTabByType(i);
    }

    public void gG(boolean z) {
        if (this.blo != null) {
            if (z) {
                this.blo.setVisibility(0);
            } else {
                this.blo.setVisibility(8);
            }
        }
    }

    public void a(int i, j jVar, boolean z) {
        gG(true);
        r lD = lD(i);
        if (lD != null) {
            lD.a(jVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.blo != null) {
            this.blo.onChangeSkinType(i);
        }
    }

    private void lB(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(n.f.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.blo = (FragmentTabHost) inflate.findViewById(n.f.post_search_tab_host);
        this.blo.setup(this.deb.getSupportFragmentManager());
        this.blo.setShouldDrawIndicatorLine(true);
        auM();
        this.blo.initViewPager();
        this.blo.setCurrentTabByType(i);
        this.blo.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void auM() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.deM = new r(1);
        bVar.Zw = this.deM;
        bVar.Zv = lC(n.i.searching_time_tab);
        bVar.mType = 1;
        this.blo.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.deN = new r(2);
        bVar2.Zw = this.deN;
        bVar2.Zv = lC(n.i.searching_relative_tab);
        bVar2.mType = 2;
        this.blo.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.deO = new r(3);
        bVar3.Zw = this.deO;
        bVar3.Zv = lC(n.i.searching_only_thread_tab);
        bVar3.mType = 3;
        this.blo.a(bVar3);
    }

    private FragmentTabIndicator lC(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.deb.getPageContext().getPageActivity()).inflate(n.g.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.deb.getResources().getDimensionPixelSize(n.d.ds32));
        fragmentTabIndicator.avG = n.c.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.deb.getResources().getDimensionPixelSize(n.d.ds4));
        return fragmentTabIndicator;
    }

    private r lD(int i) {
        switch (i) {
            case 1:
                return this.deM;
            case 2:
                return this.deN;
            case 3:
                return this.deO;
            default:
                return null;
        }
    }

    private void auN() {
        this.deM.auF();
        this.deN.auF();
        this.deO.auF();
    }
}
