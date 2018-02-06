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
public class g {
    private FragmentTabHost bWZ;
    private PostSearchActivity gxZ;
    private d gyN;
    private d gyO;
    private d gyP;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity, View view) {
        this.gxZ = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.bWZ.getCurrentTabType();
    }

    public void ue(int i) {
        if (this.bWZ == null) {
            uf(1);
            return;
        }
        bng();
        if (this.bWZ.getCurrentTabType() == i) {
            d uh = uh(i);
            if (uh != null) {
                uh.lV(true);
                return;
            }
            return;
        }
        this.bWZ.setCurrentTabByType(i);
    }

    public void fh(boolean z) {
        if (this.bWZ != null) {
            if (z) {
                this.bWZ.setVisibility(0);
            } else {
                this.bWZ.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        fh(true);
        d uh = uh(i);
        if (uh != null) {
            uh.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWZ != null) {
            this.bWZ.onChangeSkinType(i);
        }
    }

    private void uf(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bWZ = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.bWZ.setup(this.gxZ.getSupportFragmentManager());
        this.bWZ.setTabWidgetViewHeight((int) this.gxZ.getResources().getDimension(d.e.ds80));
        this.bWZ.setShouldDrawIndicatorLine(true);
        bnf();
        this.bWZ.fw(3);
        this.bWZ.setCurrentTabByType(i);
        this.bWZ.setNeedShowThemeStyle(false);
        this.bWZ.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.bWZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.bWZ.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.bWZ != null) {
            this.bWZ.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void bnf() {
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        this.gyN = new d(1);
        cVar.aUz = this.gyN;
        cVar.aUy = ug(d.j.searching_time_tab);
        cVar.mType = 1;
        this.bWZ.a(cVar);
        FragmentTabHost.c cVar2 = new FragmentTabHost.c();
        this.gyO = new d(2);
        cVar2.aUz = this.gyO;
        cVar2.aUy = ug(d.j.searching_relative_tab);
        cVar2.mType = 2;
        this.bWZ.a(cVar2);
        FragmentTabHost.c cVar3 = new FragmentTabHost.c();
        this.gyP = new d(3);
        cVar3.aUz = this.gyP;
        cVar3.aUy = ug(d.j.searching_only_thread_tab);
        cVar3.mType = 3;
        this.bWZ.a(cVar3);
    }

    private FragmentTabIndicator ug(int i) {
        int ao = (l.ao(this.gxZ.getPageContext().getContext()) - (this.gxZ.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gxZ.getPageContext().getPageActivity()).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gxZ.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.bxS = d.C0140d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gxZ.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(ao);
        return fragmentTabIndicator;
    }

    private d uh(int i) {
        switch (i) {
            case 1:
                return this.gyN;
            case 2:
                return this.gyO;
            case 3:
                return this.gyP;
            default:
                return null;
        }
    }

    private void bng() {
        this.gyN.bmX();
        this.gyO.bmX();
        this.gyP.bmX();
    }
}
