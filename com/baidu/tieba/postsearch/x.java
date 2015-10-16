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
    private FragmentTabHost bee;
    private PostSearchActivity cDW;
    private r cEH;
    private r cEI;
    private r cEJ;
    private View mRootView;

    public x(PostSearchActivity postSearchActivity, View view) {
        this.cDW = postSearchActivity;
        this.mRootView = view;
    }

    public void kb(int i) {
        if (this.bee == null) {
            kc(1);
            return;
        }
        aoz();
        if (this.bee.getCurrentTabType() == i) {
            r ke = ke(i);
            if (ke != null) {
                ke.fK(true);
                return;
            }
            return;
        }
        this.bee.setCurrentTabByType(i);
    }

    public void fL(boolean z) {
        if (this.bee != null) {
            if (z) {
                this.bee.setVisibility(0);
            } else {
                this.bee.setVisibility(8);
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
        if (this.bee != null) {
            this.bee.onChangeSkinType(i);
        }
    }

    private void kc(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(i.f.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bee = (FragmentTabHost) inflate.findViewById(i.f.post_search_tab_host);
        this.bee.setup(this.cDW.getSupportFragmentManager());
        this.bee.setShouldDrawIndicatorLine(true);
        aoy();
        this.bee.initViewPager();
        this.bee.setCurrentTabByType(i);
        this.bee.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aoy() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.cEH = new r(1);
        bVar.YG = this.cEH;
        bVar.YF = kd(i.h.searching_time_tab);
        bVar.mType = 1;
        this.bee.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.cEI = new r(2);
        bVar2.YG = this.cEI;
        bVar2.YF = kd(i.h.searching_relative_tab);
        bVar2.mType = 2;
        this.bee.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.cEJ = new r(3);
        bVar3.YG = this.cEJ;
        bVar3.YF = kd(i.h.searching_only_thread_tab);
        bVar3.mType = 3;
        this.bee.a(bVar3);
    }

    private FragmentTabIndicator kd(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.cDW.getPageContext().getPageActivity()).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.cDW.getResources().getDimensionPixelSize(i.d.ds32));
        fragmentTabIndicator.auO = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.cDW.getResources().getDimensionPixelSize(i.d.ds4));
        return fragmentTabIndicator;
    }

    private r ke(int i) {
        switch (i) {
            case 1:
                return this.cEH;
            case 2:
                return this.cEI;
            case 3:
                return this.cEJ;
            default:
                return null;
        }
    }

    private void aoz() {
        this.cEH.aor();
        this.cEI.aor();
        this.cEJ.aor();
    }
}
