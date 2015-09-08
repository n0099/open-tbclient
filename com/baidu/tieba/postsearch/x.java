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
    private FragmentTabHost bdG;
    private r cxO;
    private r cxP;
    private r cxQ;
    private PostSearchActivity cxd;
    private View mRootView;

    public x(PostSearchActivity postSearchActivity, View view) {
        this.cxd = postSearchActivity;
        this.mRootView = view;
    }

    public void jG(int i) {
        if (this.bdG == null) {
            jH(1);
            return;
        }
        amp();
        if (this.bdG.getCurrentTabType() == i) {
            r jJ = jJ(i);
            if (jJ != null) {
                jJ.fz(true);
                return;
            }
            return;
        }
        this.bdG.setCurrentTabByType(i);
    }

    public void fA(boolean z) {
        if (this.bdG != null) {
            if (z) {
                this.bdG.setVisibility(0);
            } else {
                this.bdG.setVisibility(8);
            }
        }
    }

    public void a(int i, j jVar, boolean z) {
        fA(true);
        r jJ = jJ(i);
        if (jJ != null) {
            jJ.a(jVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bdG != null) {
            this.bdG.onChangeSkinType(i);
        }
    }

    private void jH(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(i.f.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bdG = (FragmentTabHost) inflate.findViewById(i.f.post_search_tab_host);
        this.bdG.setup(this.cxd.getSupportFragmentManager());
        this.bdG.setShouldDrawIndicatorLine(true);
        amo();
        this.bdG.initViewPager();
        this.bdG.setCurrentTabByType(i);
        this.bdG.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void amo() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.cxO = new r(1);
        bVar.YM = this.cxO;
        bVar.YL = jI(i.h.searching_time_tab);
        bVar.mType = 1;
        this.bdG.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.cxP = new r(2);
        bVar2.YM = this.cxP;
        bVar2.YL = jI(i.h.searching_relative_tab);
        bVar2.mType = 2;
        this.bdG.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.cxQ = new r(3);
        bVar3.YM = this.cxQ;
        bVar3.YL = jI(i.h.searching_only_thread_tab);
        bVar3.mType = 3;
        this.bdG.a(bVar3);
    }

    private FragmentTabIndicator jI(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.cxd.getPageContext().getPageActivity()).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.cxd.getResources().getDimensionPixelSize(i.d.ds32));
        fragmentTabIndicator.awo = i.c.main_bottom_button_color;
        fragmentTabIndicator.setContentTvTopMargin(this.cxd.getResources().getDimensionPixelSize(i.d.ds4));
        return fragmentTabIndicator;
    }

    private r jJ(int i) {
        switch (i) {
            case 1:
                return this.cxO;
            case 2:
                return this.cxP;
            case 3:
                return this.cxQ;
            default:
                return null;
        }
    }

    private void amp() {
        this.cxO.amh();
        this.cxP.amh();
        this.cxQ.amh();
    }
}
