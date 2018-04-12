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
    private FragmentTabHost bgN;
    private PostSearchActivity fSQ;
    private PostSearchListFragment fTF;
    private PostSearchListFragment fTG;
    private PostSearchListFragment fTH;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public f(PostSearchActivity postSearchActivity, View view2) {
        this.fSQ = postSearchActivity;
        this.mRootView = view2;
    }

    public int getCurrentTabType() {
        return this.bgN.getCurrentTabType();
    }

    public void rD(int i) {
        if (this.bgN == null) {
            rE(1);
            return;
        }
        bim();
        if (this.bgN.getCurrentTabType() == i) {
            PostSearchListFragment rG = rG(i);
            if (rG != null) {
                rG.lA(true);
                return;
            }
            return;
        }
        this.bgN.setCurrentTabByType(i);
    }

    public void eM(boolean z) {
        if (this.bgN != null) {
            if (z) {
                this.bgN.setVisibility(0);
            } else {
                this.bgN.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        eM(true);
        PostSearchListFragment rG = rG(i);
        if (rG != null) {
            rG.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bgN != null) {
            this.bgN.onChangeSkinType(i);
        }
    }

    private void rE(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bgN = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.bgN.setup(this.fSQ.getSupportFragmentManager());
        this.bgN.setTabWidgetViewHeight((int) this.fSQ.getResources().getDimension(d.e.ds80));
        this.bgN.setShouldDrawIndicatorLine(true);
        bil();
        this.bgN.cv(3);
        this.bgN.setCurrentTabByType(i);
        this.bgN.setNeedShowThemeStyle(false);
        this.bgN.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.bgN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.bgN.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.bgN != null) {
            this.bgN.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void bil() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        this.fTF = new PostSearchListFragment(1);
        bVar.afJ = this.fTF;
        bVar.afI = rF(d.k.searching_time_tab);
        bVar.mType = 1;
        this.bgN.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        this.fTG = new PostSearchListFragment(2);
        bVar2.afJ = this.fTG;
        bVar2.afI = rF(d.k.searching_relative_tab);
        bVar2.mType = 2;
        this.bgN.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        this.fTH = new PostSearchListFragment(3);
        bVar3.afJ = this.fTH;
        bVar3.afI = rF(d.k.searching_only_thread_tab);
        bVar3.mType = 3;
        this.bgN.a(bVar3);
    }

    private FragmentTabIndicator rF(int i) {
        int af = (l.af(this.fSQ.getPageContext().getContext()) - (this.fSQ.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.fSQ.getPageContext().getPageActivity()).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.fSQ.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.aIf = d.C0126d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.fSQ.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(af);
        return fragmentTabIndicator;
    }

    private PostSearchListFragment rG(int i) {
        switch (i) {
            case 1:
                return this.fTF;
            case 2:
                return this.fTG;
            case 3:
                return this.fTH;
            default:
                return null;
        }
    }

    private void bim() {
        this.fTF.bid();
        this.fTG.bid();
        this.fTH.bid();
    }
}
