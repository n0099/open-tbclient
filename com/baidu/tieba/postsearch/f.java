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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private PostSearchListFragment gjX;
    private PostSearchListFragment gjY;
    private PostSearchListFragment gjZ;
    private PostSearchActivity gjj;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private FragmentTabHost mTabHost;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gjj = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.mTabHost.getCurrentTabType();
    }

    public void rW(int i) {
        if (this.mTabHost == null) {
            rX(1);
            return;
        }
        bnO();
        if (this.mTabHost.getCurrentTabType() == i) {
            PostSearchListFragment rZ = rZ(i);
            if (rZ != null) {
                rZ.lR(true);
                return;
            }
            return;
        }
        this.mTabHost.setCurrentTabByType(i);
    }

    public void eR(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.setVisibility(0);
            } else {
                this.mTabHost.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        eR(true);
        PostSearchListFragment rZ = rZ(i);
        if (rZ != null) {
            rZ.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(i);
        }
    }

    private void rX(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.mTabHost = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.mTabHost.setup(this.gjj.getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) this.gjj.getResources().getDimension(d.e.ds80));
        this.mTabHost.setShouldDrawIndicatorLine(true);
        bnN();
        this.mTabHost.cy(3);
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

    private void bnN() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gjX = new PostSearchListFragment(1);
        bVar.aon = this.gjX;
        bVar.aom = rY(d.k.searching_time_tab);
        bVar.mType = 1;
        this.mTabHost.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gjY = new PostSearchListFragment(2);
        bVar2.aon = this.gjY;
        bVar2.aom = rY(d.k.searching_relative_tab);
        bVar2.mType = 2;
        this.mTabHost.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gjZ = new PostSearchListFragment(3);
        bVar3.aon = this.gjZ;
        bVar3.aom = rY(d.k.searching_only_thread_tab);
        bVar3.mType = 3;
        this.mTabHost.a(bVar3);
    }

    private FragmentTabIndicator rY(int i) {
        int ah = (l.ah(this.gjj.getPageContext().getContext()) - (this.gjj.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gjj.getPageContext().getPageActivity()).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gjj.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.aRz = d.C0142d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gjj.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(ah);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment rZ(int i) {
        switch (i) {
            case 1:
                return this.gjX;
            case 2:
                return this.gjY;
            case 3:
                return this.gjZ;
            default:
                return null;
        }
    }

    private void bnO() {
        this.gjX.bnF();
        this.gjY.bnF();
        this.gjZ.bnF();
    }
}
