package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f {
    private PostSearchActivity iuI;
    private PostSearchListFragment ivw;
    private PostSearchListFragment ivx;
    private PostSearchListFragment ivy;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.iuI = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void yH(int i) {
        if (this.mTabHost == null) {
            yI(1);
            return;
        }
        cdy();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment yK = yK(i);
            if (yK != null) {
                yK.pY(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void cZ(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        cZ(true);
        PostSearchListFragment yK = yK(i);
        if (yK != null) {
            yK.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            al.l(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        }
    }

    private void yI(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.mTabHost.setup(this.iuI.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.iuI.getResources().getDimension(R.dimen.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        cdx();
        this.mTabHost.hL(3);
        this.mTabHost.setCurrentTabByType(i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        al.l(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.mTabHost != null) {
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void cdx() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.ivw = new PostSearchListFragment(1);
        bVar.bPK = this.ivw;
        bVar.bPJ = yJ(R.string.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.ivx = new PostSearchListFragment(2);
        bVar2.bPK = this.ivx;
        bVar2.bPJ = yJ(R.string.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.ivy = new PostSearchListFragment(3);
        bVar3.bPK = this.ivy;
        bVar3.bPJ = yJ(R.string.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator yJ(int i) {
        int af = (l.af(this.iuI.getPageContext().getContext()) - (this.iuI.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.iuI.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.iuI.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.cwc = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.iuI.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth(af);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment yK(int i) {
        switch (i) {
            case 1:
                return this.ivw;
            case 2:
                return this.ivx;
            case 3:
                return this.ivy;
            default:
                return null;
        }
    }

    private void cdy() {
        this.ivw.cdp();
        this.ivx.cdp();
        this.ivy.cdp();
    }
}
