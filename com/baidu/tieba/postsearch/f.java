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
    private PostSearchActivity gjK;
    private PostSearchListFragment gkA;
    private PostSearchListFragment gky;
    private PostSearchListFragment gkz;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gjK = postSearchActivity;
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
        bmh();
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
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.mTabHost.setup(this.gjK.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.gjK.getResources().getDimension(d.e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        bmg();
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

    private void bmg() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gky = new PostSearchListFragment(1);
        bVar.anO = this.gky;
        bVar.anN = rV(d.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gkz = new PostSearchListFragment(2);
        bVar2.anO = this.gkz;
        bVar2.anN = rV(d.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gkA = new PostSearchListFragment(3);
        bVar3.anO = this.gkA;
        bVar3.anN = rV(d.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator rV(int i) {
        int ah = (l.ah(this.gjK.getPageContext().getContext()) - (this.gjK.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gjK.getPageContext().getPageActivity()).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gjK.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.aRz = d.C0140d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gjK.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(ah);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment rW(int i) {
        switch (i) {
            case 1:
                return this.gky;
            case 2:
                return this.gkz;
            case 3:
                return this.gkA;
            default:
                return null;
        }
    }

    private void bmh() {
        this.gky.blY();
        this.gkz.blY();
        this.gkA.blY();
    }
}
