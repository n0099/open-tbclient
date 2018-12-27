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
    private PostSearchActivity gJK;
    private PostSearchListFragment gKA;
    private PostSearchListFragment gKy;
    private PostSearchListFragment gKz;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gJK = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void tN(int i) {
        if (this.mTabHost == null) {
            tO(1);
            return;
        }
        btZ();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment tQ = tQ(i);
            if (tQ != null) {
                tQ.mK(true);
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
        PostSearchListFragment tQ = tQ(i);
        if (tQ != null) {
            tQ.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
    }

    private void tO(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(e.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(e.g.post_search_tab_host);
        this.mTabHost.setup(this.gJK.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.gJK.getResources().getDimension(e.C0210e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        btY();
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

    private void btY() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gKy = new PostSearchListFragment(1);
        bVar.azz = this.gKy;
        bVar.azy = tP(e.j.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gKz = new PostSearchListFragment(2);
        bVar2.azz = this.gKz;
        bVar2.azy = tP(e.j.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gKA = new PostSearchListFragment(3);
        bVar3.azz = this.gKA;
        bVar3.azy = tP(e.j.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator tP(int i) {
        int aO = (l.aO(this.gJK.getPageContext().getContext()) - (this.gJK.getResources().getDimensionPixelSize(e.C0210e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gJK.getPageContext().getPageActivity()).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gJK.getResources().getDimensionPixelSize(e.C0210e.ds32));
        fragmentTabIndicator.bdB = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gJK.getResources().getDimensionPixelSize(e.C0210e.ds4));
        fragmentTabIndicator.setWidth(aO);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment tQ(int i) {
        switch (i) {
            case 1:
                return this.gKy;
            case 2:
                return this.gKz;
            case 3:
                return this.gKA;
            default:
                return null;
        }
    }

    private void btZ() {
        this.gKy.btQ();
        this.gKz.btQ();
        this.gKA.btQ();
    }
}
