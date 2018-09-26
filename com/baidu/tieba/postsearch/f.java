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
    private PostSearchListFragment grP;
    private PostSearchListFragment grQ;
    private PostSearchListFragment grR;
    private PostSearchActivity grb;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.grb = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void sq(int i) {
        if (this.mTabHost == null) {
            sr(1);
            return;
        }
        boK();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment st = st(i);
            if (st != null) {
                st.mb(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void fj(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        fj(true);
        PostSearchListFragment st = st(i);
        if (st != null) {
            st.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
    }

    private void sr(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(e.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(e.g.post_search_tab_host);
        this.mTabHost.setup(this.grb.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.grb.getResources().getDimension(e.C0141e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        boJ();
        this.mTabHost.cK(3);
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

    private void boJ() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.grP = new PostSearchListFragment(1);
        bVar.aqv = this.grP;
        bVar.aqu = ss(e.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.grQ = new PostSearchListFragment(2);
        bVar2.aqv = this.grQ;
        bVar2.aqu = ss(e.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.grR = new PostSearchListFragment(3);
        bVar3.aqv = this.grR;
        bVar3.aqu = ss(e.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator ss(int i) {
        int aO = (l.aO(this.grb.getPageContext().getContext()) - (this.grb.getResources().getDimensionPixelSize(e.C0141e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.grb.getPageContext().getPageActivity()).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.grb.getResources().getDimensionPixelSize(e.C0141e.ds32));
        fragmentTabIndicator.aUO = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.grb.getResources().getDimensionPixelSize(e.C0141e.ds4));
        fragmentTabIndicator.setWidth(aO);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment st(int i) {
        switch (i) {
            case 1:
                return this.grP;
            case 2:
                return this.grQ;
            case 3:
                return this.grR;
            default:
                return null;
        }
    }

    private void boK() {
        this.grP.boB();
        this.grQ.boB();
        this.grR.boB();
    }
}
