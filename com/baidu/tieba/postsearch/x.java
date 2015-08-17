package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class x {
    private FragmentTabHost bdl;
    private PostSearchActivity coG;
    private r cpr;
    private r cps;
    private r cpt;
    private View mRootView;

    public x(PostSearchActivity postSearchActivity, View view) {
        this.coG = postSearchActivity;
        this.mRootView = view;
    }

    public void iW(int i) {
        if (this.bdl == null) {
            iX(1);
            return;
        }
        ail();
        if (this.bdl.getCurrentTabType() == i) {
            r iZ = iZ(i);
            if (iZ != null) {
                iZ.eN(true);
                return;
            }
            return;
        }
        this.bdl.setCurrentTabByType(i);
    }

    public void eO(boolean z) {
        if (this.bdl != null) {
            if (z) {
                this.bdl.setVisibility(0);
            } else {
                this.bdl.setVisibility(8);
            }
        }
    }

    public void a(int i, j jVar, boolean z) {
        eO(true);
        r iZ = iZ(i);
        if (iZ != null) {
            iZ.a(jVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bdl != null) {
            this.bdl.onChangeSkinType(i);
        }
    }

    private void iX(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(i.f.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bdl = (FragmentTabHost) inflate.findViewById(i.f.post_search_tab_host);
        this.bdl.setup(this.coG.getSupportFragmentManager());
        this.bdl.setShouldDrawIndicatorLine(true);
        aik();
        this.bdl.initViewPager();
        this.bdl.setCurrentTabByType(i);
        this.bdl.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aik() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.cpr = new r(1);
        bVar.YD = this.cpr;
        bVar.YC = iY(i.C0057i.searching_time_tab);
        bVar.mType = 1;
        this.bdl.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.cps = new r(2);
        bVar2.YD = this.cps;
        bVar2.YC = iY(i.C0057i.searching_relative_tab);
        bVar2.mType = 2;
        this.bdl.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.cpt = new r(3);
        bVar3.YD = this.cpt;
        bVar3.YC = iY(i.C0057i.searching_only_thread_tab);
        bVar3.mType = 3;
        this.bdl.a(bVar3);
    }

    private FragmentTabIndicator iY(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.coG.getPageContext().getPageActivity()).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.coG.getResources().getDimensionPixelSize(i.d.ds32));
        fragmentTabIndicator.auG = i.c.main_bottom_button_color;
        fragmentTabIndicator.setContentTvTopMargin(this.coG.getResources().getDimensionPixelSize(i.d.ds4));
        return fragmentTabIndicator;
    }

    private r iZ(int i) {
        switch (i) {
            case 1:
                return this.cpr;
            case 2:
                return this.cps;
            case 3:
                return this.cpt;
            default:
                return null;
        }
    }

    private void ail() {
        this.cpr.aid();
        this.cps.aid();
        this.cpt.aid();
    }
}
