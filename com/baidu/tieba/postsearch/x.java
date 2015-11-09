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
    private FragmentTabHost beK;
    private PostSearchActivity cFs;
    private r cGd;
    private r cGe;
    private r cGf;
    private View mRootView;

    public x(PostSearchActivity postSearchActivity, View view) {
        this.cFs = postSearchActivity;
        this.mRootView = view;
    }

    public void kp(int i) {
        if (this.beK == null) {
            kq(1);
            return;
        }
        apb();
        if (this.beK.getCurrentTabType() == i) {
            r ks = ks(i);
            if (ks != null) {
                ks.fN(true);
                return;
            }
            return;
        }
        this.beK.setCurrentTabByType(i);
    }

    public void fO(boolean z) {
        if (this.beK != null) {
            if (z) {
                this.beK.setVisibility(0);
            } else {
                this.beK.setVisibility(8);
            }
        }
    }

    public void a(int i, j jVar, boolean z) {
        fO(true);
        r ks = ks(i);
        if (ks != null) {
            ks.a(jVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.beK != null) {
            this.beK.onChangeSkinType(i);
        }
    }

    private void kq(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(i.f.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.beK = (FragmentTabHost) inflate.findViewById(i.f.post_search_tab_host);
        this.beK.setup(this.cFs.getSupportFragmentManager());
        this.beK.setShouldDrawIndicatorLine(true);
        apa();
        this.beK.initViewPager();
        this.beK.setCurrentTabByType(i);
        this.beK.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void apa() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.cGd = new r(1);
        bVar.YK = this.cGd;
        bVar.YJ = kr(i.h.searching_time_tab);
        bVar.mType = 1;
        this.beK.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.cGe = new r(2);
        bVar2.YK = this.cGe;
        bVar2.YJ = kr(i.h.searching_relative_tab);
        bVar2.mType = 2;
        this.beK.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.cGf = new r(3);
        bVar3.YK = this.cGf;
        bVar3.YJ = kr(i.h.searching_only_thread_tab);
        bVar3.mType = 3;
        this.beK.a(bVar3);
    }

    private FragmentTabIndicator kr(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.cFs.getPageContext().getPageActivity()).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.cFs.getResources().getDimensionPixelSize(i.d.ds32));
        fragmentTabIndicator.atC = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.cFs.getResources().getDimensionPixelSize(i.d.ds4));
        return fragmentTabIndicator;
    }

    private r ks(int i) {
        switch (i) {
            case 1:
                return this.cGd;
            case 2:
                return this.cGe;
            case 3:
                return this.cGf;
            default:
                return null;
        }
    }

    private void apb() {
        this.cGd.aoT();
        this.cGe.aoT();
        this.cGf.aoT();
    }
}
