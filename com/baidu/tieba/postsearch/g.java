package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g {
    private FragmentTabHost bWN;
    private PostSearchActivity gxO;
    private d gyC;
    private d gyD;
    private d gyE;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity, View view) {
        this.gxO = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.bWN.getCurrentTabType();
    }

    public void uf(int i) {
        if (this.bWN == null) {
            ug(1);
            return;
        }
        bnf();
        if (this.bWN.getCurrentTabType() == i) {
            d ui = ui(i);
            if (ui != null) {
                ui.lV(true);
                return;
            }
            return;
        }
        this.bWN.setCurrentTabByType(i);
    }

    public void fh(boolean z) {
        if (this.bWN != null) {
            if (z) {
                this.bWN.setVisibility(0);
            } else {
                this.bWN.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        fh(true);
        d ui = ui(i);
        if (ui != null) {
            ui.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWN != null) {
            this.bWN.onChangeSkinType(i);
        }
    }

    private void ug(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bWN = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.bWN.setup(this.gxO.getSupportFragmentManager());
        this.bWN.setTabWidgetViewHeight((int) this.gxO.getResources().getDimension(d.e.ds80));
        this.bWN.setShouldDrawIndicatorLine(true);
        bne();
        this.bWN.fw(3);
        this.bWN.setCurrentTabByType(i);
        this.bWN.setNeedShowThemeStyle(false);
        this.bWN.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.bWN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.bWN.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.bWN != null) {
            this.bWN.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void bne() {
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        this.gyC = new d(1);
        cVar.aUn = this.gyC;
        cVar.aUm = uh(d.j.searching_time_tab);
        cVar.mType = 1;
        this.bWN.a(cVar);
        FragmentTabHost.c cVar2 = new FragmentTabHost.c();
        this.gyD = new d(2);
        cVar2.aUn = this.gyD;
        cVar2.aUm = uh(d.j.searching_relative_tab);
        cVar2.mType = 2;
        this.bWN.a(cVar2);
        FragmentTabHost.c cVar3 = new FragmentTabHost.c();
        this.gyE = new d(3);
        cVar3.aUn = this.gyE;
        cVar3.aUm = uh(d.j.searching_only_thread_tab);
        cVar3.mType = 3;
        this.bWN.a(cVar3);
    }

    private FragmentTabIndicator uh(int i) {
        int ao = (l.ao(this.gxO.getPageContext().getContext()) - (this.gxO.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gxO.getPageContext().getPageActivity()).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gxO.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.bxF = d.C0141d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gxO.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(ao);
        return fragmentTabIndicator;
    }

    private d ui(int i) {
        switch (i) {
            case 1:
                return this.gyC;
            case 2:
                return this.gyD;
            case 3:
                return this.gyE;
            default:
                return null;
        }
    }

    private void bnf() {
        this.gyC.bmW();
        this.gyD.bmW();
        this.gyE.bmW();
    }
}
