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
    private FragmentTabHost aXu;
    private s dST;
    private s dSU;
    private s dSV;
    private PostSearchActivity dSg;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity, View view) {
        this.dSg = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.aXu.getCurrentTabType();
    }

    public void oj(int i) {
        if (this.aXu == null) {
            ok(1);
            return;
        }
        aKQ();
        if (this.aXu.getCurrentTabType() == i) {
            s om = om(i);
            if (om != null) {
                om.hU(true);
                return;
            }
            return;
        }
        this.aXu.setCurrentTabByType(i);
    }

    public void hV(boolean z) {
        if (this.aXu != null) {
            if (z) {
                this.aXu.setVisibility(0);
            } else {
                this.aXu.setVisibility(8);
            }
        }
    }

    public void a(int i, k kVar, boolean z) {
        hV(true);
        s om = om(i);
        if (om != null) {
            om.a(kVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aXu != null) {
            this.aXu.onChangeSkinType(i);
        }
    }

    private void ok(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(t.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.aXu = (FragmentTabHost) inflate.findViewById(t.g.post_search_tab_host);
        this.aXu.setup(this.dSg.getSupportFragmentManager());
        this.aXu.setShouldDrawIndicatorLine(true);
        aKP();
        this.aXu.initViewPager();
        this.aXu.setCurrentTabByType(i);
        this.aXu.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aKP() {
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        this.dST = new s(1);
        cVar.ZK = this.dST;
        cVar.ZJ = ol(t.j.searching_time_tab);
        cVar.mType = 1;
        this.aXu.a(cVar);
        FragmentTabHost.c cVar2 = new FragmentTabHost.c();
        this.dSU = new s(2);
        cVar2.ZK = this.dSU;
        cVar2.ZJ = ol(t.j.searching_relative_tab);
        cVar2.mType = 2;
        this.aXu.a(cVar2);
        FragmentTabHost.c cVar3 = new FragmentTabHost.c();
        this.dSV = new s(3);
        cVar3.ZK = this.dSV;
        cVar3.ZJ = ol(t.j.searching_only_thread_tab);
        cVar3.mType = 3;
        this.aXu.a(cVar3);
    }

    private FragmentTabIndicator ol(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.dSg.getPageContext().getPageActivity()).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.dSg.getResources().getDimensionPixelSize(t.e.ds32));
        fragmentTabIndicator.ayK = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.dSg.getResources().getDimensionPixelSize(t.e.ds4));
        return fragmentTabIndicator;
    }

    private s om(int i) {
        switch (i) {
            case 1:
                return this.dST;
            case 2:
                return this.dSU;
            case 3:
                return this.dSV;
            default:
                return null;
        }
    }

    private void aKQ() {
        this.dST.aKI();
        this.dSU.aKI();
        this.dSV.aKI();
    }
}
