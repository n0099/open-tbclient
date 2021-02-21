package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private PostSearchActivity mMG;
    private PostSearchListFragment mNs;
    private PostSearchListFragment mNt;
    private PostSearchListFragment mNu;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.mMG = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void Hz(int i) {
        if (this.mTabHost == null) {
            HA(1);
            return;
        }
        dBY();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment HC = HC(i);
            if (HC != null) {
                HC.by(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void iv(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        iv(true);
        PostSearchListFragment HC = HC(i);
        if (HC != null) {
            HC.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            ap.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.CAM_X0201);
        }
    }

    private void HA(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.mTabHost.setup(this.mMG.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.mMG.getResources().getDimension(R.dimen.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        dBX();
        this.mTabHost.initViewPager(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.CAM_X0201);
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void dBX() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.mNs = new PostSearchListFragment(1);
        bVar.mContentFragment = this.mNs;
        bVar.eZk = HB(R.string.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.mNt = new PostSearchListFragment(2);
        bVar2.mContentFragment = this.mNt;
        bVar2.eZk = HB(R.string.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.mNu = new PostSearchListFragment(3);
        bVar3.mContentFragment = this.mNu;
        bVar3.eZk = HB(R.string.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator HB(int i) {
        int equipmentWidth = (l.getEquipmentWidth(this.mMG.getPageContext().getContext()) - (this.mMG.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.mMG.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.mMG.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.mMG.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth(equipmentWidth);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment HC(int i) {
        switch (i) {
            case 1:
                return this.mNs;
            case 2:
                return this.mNt;
            case 3:
                return this.mNu;
            default:
                return null;
        }
    }

    private void dBY() {
        this.mNs.dBP();
        this.mNt.dBP();
        this.mNu.dBP();
    }
}
