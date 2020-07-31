package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class f {
    private PostSearchActivity lgS;
    private PostSearchListFragment lhE;
    private PostSearchListFragment lhF;
    private PostSearchListFragment lhG;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.lgS = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void Dx(int i) {
        if (this.mTabHost == null) {
            Dy(1);
            return;
        }
        daJ();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment DA = DA(i);
            if (DA != null) {
                DA.requestData(true);
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
        PostSearchListFragment DA = DA(i);
        if (DA != null) {
            DA.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            ao.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        }
    }

    private void Dy(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.mTabHost.setup(this.lgS.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.lgS.getResources().getDimension(R.dimen.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        daI();
        this.mTabHost.initViewPager(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ao.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void daI() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.lhE = new PostSearchListFragment(1);
        bVar.mContentFragment = this.lhE;
        bVar.dYX = Dz(R.string.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.lhF = new PostSearchListFragment(2);
        bVar2.mContentFragment = this.lhF;
        bVar2.dYX = Dz(R.string.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.lhG = new PostSearchListFragment(3);
        bVar3.mContentFragment = this.lhG;
        bVar3.dYX = Dz(R.string.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator Dz(int i) {
        int equipmentWidth = (l.getEquipmentWidth(this.lgS.getPageContext().getContext()) - (this.lgS.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.lgS.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.lgS.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.lgS.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth(equipmentWidth);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment DA(int i) {
        switch (i) {
            case 1:
                return this.lhE;
            case 2:
                return this.lhF;
            case 3:
                return this.lhG;
            default:
                return null;
        }
    }

    private void daJ() {
        this.lhE.daA();
        this.lhF.daA();
        this.lhG.daA();
    }
}
