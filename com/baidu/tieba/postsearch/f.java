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
public class f {
    private FragmentTabHost bgO;
    private PostSearchActivity fTT;
    private PostSearchListFragment fUI;
    private PostSearchListFragment fUJ;
    private PostSearchListFragment fUK;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public f(PostSearchActivity postSearchActivity, View view2) {
        this.fTT = postSearchActivity;
        this.mRootView = view2;
    }

    public int getCurrentTabType() {
        return this.bgO.getCurrentTabType();
    }

    public void rB(int i) {
        if (this.bgO == null) {
            rC(1);
            return;
        }
        bim();
        if (this.bgO.getCurrentTabType() == i) {
            PostSearchListFragment rE = rE(i);
            if (rE != null) {
                rE.lB(true);
                return;
            }
            return;
        }
        this.bgO.setCurrentTabByType(i);
    }

    public void eN(boolean z) {
        if (this.bgO != null) {
            if (z) {
                this.bgO.setVisibility(0);
            } else {
                this.bgO.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        eN(true);
        PostSearchListFragment rE = rE(i);
        if (rE != null) {
            rE.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bgO != null) {
            this.bgO.onChangeSkinType(i);
        }
    }

    private void rC(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bgO = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.bgO.setup(this.fTT.getSupportFragmentManager());
        this.bgO.setTabWidgetViewHeight((int) this.fTT.getResources().getDimension(d.e.ds80));
        this.bgO.setShouldDrawIndicatorLine(true);
        bil();
        this.bgO.cv(3);
        this.bgO.setCurrentTabByType(i);
        this.bgO.setNeedShowThemeStyle(false);
        this.bgO.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.bgO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.bgO.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.bgO != null) {
            this.bgO.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void bil() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.fUI = new PostSearchListFragment(1);
        bVar.afJ = this.fUI;
        bVar.afI = rD(d.k.searching_time_tab);
        bVar.mType = 1;
        this.bgO.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.fUJ = new PostSearchListFragment(2);
        bVar2.afJ = this.fUJ;
        bVar2.afI = rD(d.k.searching_relative_tab);
        bVar2.mType = 2;
        this.bgO.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.fUK = new PostSearchListFragment(3);
        bVar3.afJ = this.fUK;
        bVar3.afI = rD(d.k.searching_only_thread_tab);
        bVar3.mType = 3;
        this.bgO.a(bVar3);
    }

    private FragmentTabIndicator rD(int i) {
        int af = (l.af(this.fTT.getPageContext().getContext()) - (this.fTT.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.fTT.getPageContext().getPageActivity()).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.fTT.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.aIg = d.C0126d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.fTT.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(af);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment rE(int i) {
        switch (i) {
            case 1:
                return this.fUI;
            case 2:
                return this.fUJ;
            case 3:
                return this.fUK;
            default:
                return null;
        }
    }

    private void bim() {
        this.fUI.bid();
        this.fUJ.bid();
        this.fUK.bid();
    }
}
