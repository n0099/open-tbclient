package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f {
    private PostSearchActivity lGp;
    private PostSearchListFragment lHb;
    private PostSearchListFragment lHc;
    private PostSearchListFragment lHd;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.lGp = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void Gt(int i) {
        if (this.mTabHost == null) {
            Gu(1);
            return;
        }
        dpx();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment Gw = Gw(i);
            if (Gw != null) {
                Gw.requestData(true);
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
        PostSearchListFragment Gw = Gw(i);
        if (Gw != null) {
            Gw.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            ap.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        }
    }

    private void Gu(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.mTabHost.setup(this.lGp.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.lGp.getResources().getDimension(R.dimen.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        dpw();
        this.mTabHost.initViewPager(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void dpw() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.lHb = new PostSearchListFragment(1);
        bVar.mContentFragment = this.lHb;
        bVar.ekW = Gv(R.string.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.lHc = new PostSearchListFragment(2);
        bVar2.mContentFragment = this.lHc;
        bVar2.ekW = Gv(R.string.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.lHd = new PostSearchListFragment(3);
        bVar3.mContentFragment = this.lHd;
        bVar3.ekW = Gv(R.string.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator Gv(int i) {
        int equipmentWidth = (l.getEquipmentWidth(this.lGp.getPageContext().getContext()) - (this.lGp.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.lGp.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.lGp.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.lGp.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth(equipmentWidth);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment Gw(int i) {
        switch (i) {
            case 1:
                return this.lHb;
            case 2:
                return this.lHc;
            case 3:
                return this.lHd;
            default:
                return null;
        }
    }

    private void dpx() {
        this.lHb.dpo();
        this.lHc.dpo();
        this.lHd.dpo();
    }
}
