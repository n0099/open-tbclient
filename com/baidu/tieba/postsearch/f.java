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
    private PostSearchActivity gyC;
    private PostSearchListFragment gzq;
    private PostSearchListFragment gzr;
    private PostSearchListFragment gzs;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gyC = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void sN(int i) {
        if (this.mTabHost == null) {
            sO(1);
            return;
        }
        brZ();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment sQ = sQ(i);
            if (sQ != null) {
                sQ.mt(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void fB(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        fB(true);
        PostSearchListFragment sQ = sQ(i);
        if (sQ != null) {
            sQ.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
    }

    private void sO(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(e.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(e.g.post_search_tab_host);
        this.mTabHost.setup(this.gyC.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.gyC.getResources().getDimension(e.C0175e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        brY();
        this.mTabHost.cU(3);
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

    private void brY() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gzq = new PostSearchListFragment(1);
        bVar.avm = this.gzq;
        bVar.avl = sP(e.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gzr = new PostSearchListFragment(2);
        bVar2.avm = this.gzr;
        bVar2.avl = sP(e.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gzs = new PostSearchListFragment(3);
        bVar3.avm = this.gzs;
        bVar3.avl = sP(e.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator sP(int i) {
        int aO = (l.aO(this.gyC.getPageContext().getContext()) - (this.gyC.getResources().getDimensionPixelSize(e.C0175e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gyC.getPageContext().getPageActivity()).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gyC.getResources().getDimensionPixelSize(e.C0175e.ds32));
        fragmentTabIndicator.aZn = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gyC.getResources().getDimensionPixelSize(e.C0175e.ds4));
        fragmentTabIndicator.setWidth(aO);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment sQ(int i) {
        switch (i) {
            case 1:
                return this.gzq;
            case 2:
                return this.gzr;
            case 3:
                return this.gzs;
            default:
                return null;
        }
    }

    private void brZ() {
        this.gzq.brQ();
        this.gzr.brQ();
        this.gzs.brQ();
    }
}
