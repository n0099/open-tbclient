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
/* loaded from: classes24.dex */
public class f {
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;
    private PostSearchListFragment moN;
    private PostSearchListFragment moO;
    private PostSearchListFragment moP;
    private PostSearchActivity moa;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.moa = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void HF(int i) {
        if (this.mTabHost == null) {
            HG(1);
            return;
        }
        dyR();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment HI = HI(i);
            if (HI != null) {
                HI.requestData(true);
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
        PostSearchListFragment HI = HI(i);
        if (HI != null) {
            HI.a(bVar, z);
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

    private void HG(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.mTabHost.setup(this.moa.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.moa.getResources().getDimension(R.dimen.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        dyQ();
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

    private void dyQ() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.moN = new PostSearchListFragment(1);
        bVar.mContentFragment = this.moN;
        bVar.eLs = HH(R.string.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.moO = new PostSearchListFragment(2);
        bVar2.mContentFragment = this.moO;
        bVar2.eLs = HH(R.string.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.moP = new PostSearchListFragment(3);
        bVar3.mContentFragment = this.moP;
        bVar3.eLs = HH(R.string.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator HH(int i) {
        int equipmentWidth = (l.getEquipmentWidth(this.moa.getPageContext().getContext()) - (this.moa.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.moa.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.moa.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.moa.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth(equipmentWidth);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment HI(int i) {
        switch (i) {
            case 1:
                return this.moN;
            case 2:
                return this.moO;
            case 3:
                return this.moP;
            default:
                return null;
        }
    }

    private void dyR() {
        this.moN.dyI();
        this.moO.dyI();
        this.moP.dyI();
    }
}
