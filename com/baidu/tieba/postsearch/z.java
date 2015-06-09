package com.baidu.tieba.postsearch;

import android.view.View;
import android.view.ViewStub;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class z {
    private FragmentTabHost aRP;
    private PostSearchActivity bXN;
    private s bYA;
    private s bYy;
    private s bYz;
    private View mRootView;

    public z(PostSearchActivity postSearchActivity, View view) {
        this.bXN = postSearchActivity;
        this.mRootView = view;
    }

    public void ic(int i) {
        if (this.aRP == null) {
            id(1);
            return;
        }
        agn();
        if (this.aRP.getCurrentTabType() == i) {
            s ig = ig(i);
            if (ig != null) {
                ig.ev(true);
                return;
            }
            return;
        }
        this.aRP.setCurrentTabByType(i);
    }

    public void ew(boolean z) {
        if (this.aRP != null) {
            if (z) {
                this.aRP.setVisibility(0);
            } else {
                this.aRP.setVisibility(8);
            }
        }
    }

    public void a(int i, j jVar, boolean z) {
        ew(true);
        s ig = ig(i);
        if (ig != null) {
            ig.a(jVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aRP != null) {
            this.aRP.onChangeSkinType(i);
        }
    }

    private void id(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(com.baidu.tieba.q.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.aRP = (FragmentTabHost) inflate.findViewById(com.baidu.tieba.q.post_search_tab_host);
        this.aRP.setup(this.bXN.getSupportFragmentManager());
        this.aRP.setShouldDrawIndicatorLine(true);
        agm();
        this.aRP.initViewPager();
        this.aRP.setCurrentTabByType(i);
        this.aRP.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void agm() {
        com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
        this.bYy = new s(1);
        bVar.TC = this.bYy;
        bVar.TB = ie(com.baidu.tieba.t.searching_time_tab);
        bVar.mType = 1;
        this.aRP.a(bVar);
        com.baidu.tbadk.core.tabHost.b bVar2 = new com.baidu.tbadk.core.tabHost.b();
        this.bYz = new s(2);
        bVar2.TC = this.bYz;
        bVar2.TB = ie(com.baidu.tieba.t.searching_relative_tab);
        bVar2.mType = 2;
        this.aRP.a(bVar2);
        com.baidu.tbadk.core.tabHost.b bVar3 = new com.baidu.tbadk.core.tabHost.b();
        this.bYA = new s(3);
        bVar3.TC = this.bYA;
        bVar3.TB = ie(com.baidu.tieba.t.searching_only_thread_tab);
        bVar3.mType = 3;
        this.aRP.a(bVar3);
    }

    private FragmentTabIndicator ie(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hr().inflate(this.bXN.getPageContext().getPageActivity(), com.baidu.tieba.r.fragmenttabindicator, null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.bXN.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds32));
        fragmentTabIndicator.amU = com.baidu.tieba.n.main_bottom_button_color;
        fragmentTabIndicator.setContentTvTopMargin(this.bXN.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds4));
        return fragmentTabIndicator;
    }

    private s ig(int i) {
        switch (i) {
            case 1:
                return this.bYy;
            case 2:
                return this.bYz;
            case 3:
                return this.bYA;
            default:
                return null;
        }
    }

    private void agn() {
        this.bYy.agf();
        this.bYz.agf();
        this.bYA.agf();
    }
}
