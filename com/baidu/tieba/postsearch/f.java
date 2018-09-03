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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class f {
    private PostSearchActivity gjJ;
    private PostSearchListFragment gkx;
    private PostSearchListFragment gky;
    private PostSearchListFragment gkz;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gjJ = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void rT(int i) {
        if (this.mTabHost == null) {
            rU(1);
            return;
        }
        bme();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment rW = rW(i);
            if (rW != null) {
                rW.lC(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void eS(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        eS(true);
        PostSearchListFragment rW = rW(i);
        if (rW != null) {
            rW.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
    }

    private void rU(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(f.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(f.g.post_search_tab_host);
        this.mTabHost.setup(this.gjJ.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.gjJ.getResources().getDimension(f.e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        bmd();
        this.mTabHost.cA(3);
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

    private void bmd() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gkx = new PostSearchListFragment(1);
        bVar.anP = this.gkx;
        bVar.anO = rV(f.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gky = new PostSearchListFragment(2);
        bVar2.anP = this.gky;
        bVar2.anO = rV(f.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gkz = new PostSearchListFragment(3);
        bVar3.anP = this.gkz;
        bVar3.anO = rV(f.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator rV(int i) {
        int ah = (l.ah(this.gjJ.getPageContext().getContext()) - (this.gjJ.getResources().getDimensionPixelSize(f.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gjJ.getPageContext().getPageActivity()).inflate(f.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gjJ.getResources().getDimensionPixelSize(f.e.ds32));
        fragmentTabIndicator.aRw = f.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gjJ.getResources().getDimensionPixelSize(f.e.ds4));
        fragmentTabIndicator.setWidth(ah);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment rW(int i) {
        switch (i) {
            case 1:
                return this.gkx;
            case 2:
                return this.gky;
            case 3:
                return this.gkz;
            default:
                return null;
        }
    }

    private void bme() {
        this.gkx.blV();
        this.gky.blV();
        this.gkz.blV();
    }
}
