package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f {
    private PostSearchListFragment iCR;
    private PostSearchListFragment iCS;
    private PostSearchListFragment iCT;
    private PostSearchActivity iCd;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.iCd = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void zo(int i) {
        if (this.mTabHost == null) {
            zp(1);
            return;
        }
        cgH();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment zr = zr(i);
            if (zr != null) {
                zr.qn(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void dc(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        dc(true);
        PostSearchListFragment zr = zr(i);
        if (zr != null) {
            zr.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            am.l(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        }
    }

    private void zp(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.mTabHost.setup(this.iCd.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.iCd.getResources().getDimension(R.dimen.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        cgG();
        this.mTabHost.hR(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        am.l(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void cgG() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.iCR = new PostSearchListFragment(1);
        bVar.bQQ = this.iCR;
        bVar.bQP = zq(R.string.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.iCS = new PostSearchListFragment(2);
        bVar2.bQQ = this.iCS;
        bVar2.bQP = zq(R.string.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.iCT = new PostSearchListFragment(3);
        bVar3.bQQ = this.iCT;
        bVar3.bQP = zq(R.string.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator zq(int i) {
        int af = (l.af(this.iCd.getPageContext().getContext()) - (this.iCd.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.iCd.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.iCd.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.cxy = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.iCd.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth(af);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment zr(int i) {
        switch (i) {
            case 1:
                return this.iCR;
            case 2:
                return this.iCS;
            case 3:
                return this.iCT;
            default:
                return null;
        }
    }

    private void cgH() {
        this.iCR.cgy();
        this.iCS.cgy();
        this.iCT.cgy();
    }
}
