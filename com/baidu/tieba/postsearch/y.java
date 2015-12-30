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
public class y {
    private FragmentTabHost bpf;
    private PostSearchActivity djG;
    private s dks;
    private s dkt;
    private s dku;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity, View view) {
        this.djG = postSearchActivity;
        this.mRootView = view;
    }

    public void lZ(int i) {
        if (this.bpf == null) {
            ma(1);
            return;
        }
        awG();
        if (this.bpf.getCurrentTabType() == i) {
            s mc = mc(i);
            if (mc != null) {
                mc.gL(true);
                return;
            }
            return;
        }
        this.bpf.setCurrentTabByType(i);
    }

    public void gM(boolean z) {
        if (this.bpf != null) {
            if (z) {
                this.bpf.setVisibility(0);
            } else {
                this.bpf.setVisibility(8);
            }
        }
    }

    public void a(int i, k kVar, boolean z) {
        gM(true);
        s mc = mc(i);
        if (mc != null) {
            mc.a(kVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bpf != null) {
            this.bpf.onChangeSkinType(i);
        }
    }

    private void ma(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(n.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bpf = (FragmentTabHost) inflate.findViewById(n.g.post_search_tab_host);
        this.bpf.setup(this.djG.getSupportFragmentManager());
        this.bpf.setShouldDrawIndicatorLine(true);
        awF();
        this.bpf.initViewPager();
        this.bpf.setCurrentTabByType(i);
        this.bpf.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void awF() {
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        this.dks = new s(1);
        cVar.aaa = this.dks;
        cVar.ZZ = mb(n.j.searching_time_tab);
        cVar.mType = 1;
        this.bpf.a(cVar);
        FragmentTabHost.c cVar2 = new FragmentTabHost.c();
        this.dkt = new s(2);
        cVar2.aaa = this.dkt;
        cVar2.ZZ = mb(n.j.searching_relative_tab);
        cVar2.mType = 2;
        this.bpf.a(cVar2);
        FragmentTabHost.c cVar3 = new FragmentTabHost.c();
        this.dku = new s(3);
        cVar3.aaa = this.dku;
        cVar3.ZZ = mb(n.j.searching_only_thread_tab);
        cVar3.mType = 3;
        this.bpf.a(cVar3);
    }

    private FragmentTabIndicator mb(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.djG.getPageContext().getPageActivity()).inflate(n.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.djG.getResources().getDimensionPixelSize(n.e.ds32));
        fragmentTabIndicator.axk = n.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.djG.getResources().getDimensionPixelSize(n.e.ds4));
        return fragmentTabIndicator;
    }

    private s mc(int i) {
        switch (i) {
            case 1:
                return this.dks;
            case 2:
                return this.dkt;
            case 3:
                return this.dku;
            default:
                return null;
        }
    }

    private void awG() {
        this.dks.awy();
        this.dkt.awy();
        this.dku.awy();
    }
}
