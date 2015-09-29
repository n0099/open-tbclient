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
    private FragmentTabHost bdT;
    private PostSearchActivity cDL;
    private r cEw;
    private r cEx;
    private r cEy;
    private View mRootView;

    public x(PostSearchActivity postSearchActivity, View view) {
        this.cDL = postSearchActivity;
        this.mRootView = view;
    }

    public void kb(int i) {
        if (this.bdT == null) {
            kc(1);
            return;
        }
        aoz();
        if (this.bdT.getCurrentTabType() == i) {
            r ke = ke(i);
            if (ke != null) {
                ke.fK(true);
                return;
            }
            return;
        }
        this.bdT.setCurrentTabByType(i);
    }

    public void fL(boolean z) {
        if (this.bdT != null) {
            if (z) {
                this.bdT.setVisibility(0);
            } else {
                this.bdT.setVisibility(8);
            }
        }
    }

    public void a(int i, j jVar, boolean z) {
        fL(true);
        r ke = ke(i);
        if (ke != null) {
            ke.a(jVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bdT != null) {
            this.bdT.onChangeSkinType(i);
        }
    }

    private void kc(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(i.f.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bdT = (FragmentTabHost) inflate.findViewById(i.f.post_search_tab_host);
        this.bdT.setup(this.cDL.getSupportFragmentManager());
        this.bdT.setShouldDrawIndicatorLine(true);
        aoy();
        this.bdT.initViewPager();
        this.bdT.setCurrentTabByType(i);
        this.bdT.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aoy() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.cEw = new r(1);
        bVar.YE = this.cEw;
        bVar.YD = kd(i.h.searching_time_tab);
        bVar.mType = 1;
        this.bdT.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.cEx = new r(2);
        bVar2.YE = this.cEx;
        bVar2.YD = kd(i.h.searching_relative_tab);
        bVar2.mType = 2;
        this.bdT.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.cEy = new r(3);
        bVar3.YE = this.cEy;
        bVar3.YD = kd(i.h.searching_only_thread_tab);
        bVar3.mType = 3;
        this.bdT.a(bVar3);
    }

    private FragmentTabIndicator kd(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.cDL.getPageContext().getPageActivity()).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.cDL.getResources().getDimensionPixelSize(i.d.ds32));
        fragmentTabIndicator.auN = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.cDL.getResources().getDimensionPixelSize(i.d.ds4));
        return fragmentTabIndicator;
    }

    private r ke(int i) {
        switch (i) {
            case 1:
                return this.cEw;
            case 2:
                return this.cEx;
            case 3:
                return this.cEy;
            default:
                return null;
        }
    }

    private void aoz() {
        this.cEw.aor();
        this.cEx.aor();
        this.cEy.aor();
    }
}
