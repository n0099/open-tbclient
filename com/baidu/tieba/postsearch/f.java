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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private PostSearchActivity gGT;
    private PostSearchListFragment gHH;
    private PostSearchListFragment gHI;
    private PostSearchListFragment gHJ;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gGT = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void tA(int i) {
        if (this.mTabHost == null) {
            tB(1);
            return;
        }
        bto();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment tD = tD(i);
            if (tD != null) {
                tD.mH(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void setVisibility(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        setVisibility(true);
        PostSearchListFragment tD = tD(i);
        if (tD != null) {
            tD.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
    }

    private void tB(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(e.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(e.g.post_search_tab_host);
        this.mTabHost.setup(this.gGT.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.gGT.getResources().getDimension(e.C0210e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        btn();
        this.mTabHost.dw(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void btn() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gHH = new PostSearchListFragment(1);
        bVar.azz = this.gHH;
        bVar.azy = tC(e.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gHI = new PostSearchListFragment(2);
        bVar2.azz = this.gHI;
        bVar2.azy = tC(e.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gHJ = new PostSearchListFragment(3);
        bVar3.azz = this.gHJ;
        bVar3.azy = tC(e.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator tC(int i) {
        int aO = (l.aO(this.gGT.getPageContext().getContext()) - (this.gGT.getResources().getDimensionPixelSize(e.C0210e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gGT.getPageContext().getPageActivity()).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gGT.getResources().getDimensionPixelSize(e.C0210e.ds32));
        fragmentTabIndicator.bdy = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gGT.getResources().getDimensionPixelSize(e.C0210e.ds4));
        fragmentTabIndicator.setWidth(aO);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment tD(int i) {
        switch (i) {
            case 1:
                return this.gHH;
            case 2:
                return this.gHI;
            case 3:
                return this.gHJ;
            default:
                return null;
        }
    }

    private void bto() {
        this.gHH.btf();
        this.gHI.btf();
        this.gHJ.btf();
    }
}
