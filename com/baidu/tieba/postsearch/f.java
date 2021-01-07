package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private PostSearchActivity mHR;
    private PostSearchListFragment mIH;
    private PostSearchListFragment mII;
    private PostSearchListFragment mIJ;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.mHR = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void IO(int i) {
        if (this.mTabHost == null) {
            IP(1);
            return;
        }
        dDz();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment IR = IR(i);
            if (IR != null) {
                IR.bx(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void ix(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        ix(true);
        PostSearchListFragment IR = IR(i);
        if (IR != null) {
            IR.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            ao.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.CAM_X0201);
        }
    }

    private void IP(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.mTabHost.setup(this.mHR.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.mHR.getResources().getDimension(R.dimen.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        dDy();
        this.mTabHost.initViewPager(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ao.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.CAM_X0201);
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void dDy() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.mIH = new PostSearchListFragment(1);
        bVar.mContentFragment = this.mIH;
        bVar.fbC = IQ(R.string.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.mII = new PostSearchListFragment(2);
        bVar2.mContentFragment = this.mII;
        bVar2.fbC = IQ(R.string.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.mIJ = new PostSearchListFragment(3);
        bVar3.mContentFragment = this.mIJ;
        bVar3.fbC = IQ(R.string.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator IQ(int i) {
        int equipmentWidth = (l.getEquipmentWidth(this.mHR.getPageContext().getContext()) - (this.mHR.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.mHR.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.mHR.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.mHR.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth(equipmentWidth);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment IR(int i) {
        switch (i) {
            case 1:
                return this.mIH;
            case 2:
                return this.mII;
            case 3:
                return this.mIJ;
            default:
                return null;
        }
    }

    private void dDz() {
        this.mIH.dDq();
        this.mII.dDq();
        this.mIJ.dDq();
    }
}
