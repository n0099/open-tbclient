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
    private FragmentTabHost aoi;
    private PostSearchListFragment gfX;
    private PostSearchListFragment gfY;
    private PostSearchListFragment gfZ;
    private PostSearchActivity gfi;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.gfi = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.aoi.getCurrentTabType();
    }

    public void rN(int i) {
        if (this.aoi == null) {
            rO(1);
            return;
        }
        bnk();
        if (this.aoi.getCurrentTabType() == i) {
            PostSearchListFragment rQ = rQ(i);
            if (rQ != null) {
                rQ.lH(true);
                return;
            }
            return;
        }
        this.aoi.setCurrentTabByType(i);
    }

    public void eR(boolean z) {
        if (this.aoi != null) {
            if (z) {
                this.aoi.setVisibility(0);
            } else {
                this.aoi.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        eR(true);
        PostSearchListFragment rQ = rQ(i);
        if (rQ != null) {
            rQ.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aoi != null) {
            this.aoi.onChangeSkinType(i);
        }
    }

    private void rO(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.aoi = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.aoi.setup(this.gfi.getSupportFragmentManager());
        this.aoi.setTabWidgetViewHeight((int) this.gfi.getResources().getDimension(d.e.ds80));
        this.aoi.setShouldDrawIndicatorLine(true);
        bnj();
        this.aoi.cx(3);
        this.aoi.setCurrentTabByType(i);
        this.aoi.setNeedShowThemeStyle(false);
        this.aoi.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.aoi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.aoi.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.aoi != null) {
            this.aoi.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void bnj() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.gfX = new PostSearchListFragment(1);
        bVar.anN = this.gfX;
        bVar.anM = rP(d.k.searching_time_tab);
        bVar.mType = 1;
        this.aoi.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.gfY = new PostSearchListFragment(2);
        bVar2.anN = this.gfY;
        bVar2.anM = rP(d.k.searching_relative_tab);
        bVar2.mType = 2;
        this.aoi.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.gfZ = new PostSearchListFragment(3);
        bVar3.anN = this.gfZ;
        bVar3.anM = rP(d.k.searching_only_thread_tab);
        bVar3.mType = 3;
        this.aoi.a(bVar3);
    }

    private FragmentTabIndicator rP(int i) {
        int ah = (l.ah(this.gfi.getPageContext().getContext()) - (this.gfi.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gfi.getPageContext().getPageActivity()).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gfi.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.aQD = d.C0141d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gfi.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(ah);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment rQ(int i) {
        switch (i) {
            case 1:
                return this.gfX;
            case 2:
                return this.gfY;
            case 3:
                return this.gfZ;
            default:
                return null;
        }
    }

    private void bnk() {
        this.gfX.bnb();
        this.gfY.bnb();
        this.gfZ.bnb();
    }
}
