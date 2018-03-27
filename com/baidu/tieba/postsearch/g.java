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
    private FragmentTabHost bWQ;
    private d gyS;
    private d gyT;
    private d gyU;
    private PostSearchActivity gye;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity, View view) {
        this.gye = postSearchActivity;
        this.mRootView = view;
    }

    public int getCurrentTabType() {
        return this.bWQ.getCurrentTabType();
    }

    public void uf(int i) {
        if (this.bWQ == null) {
            ug(1);
            return;
        }
        bng();
        if (this.bWQ.getCurrentTabType() == i) {
            d ui = ui(i);
            if (ui != null) {
                ui.ma(true);
                return;
            }
            return;
        }
        this.bWQ.setCurrentTabByType(i);
    }

    public void fh(boolean z) {
        if (this.bWQ != null) {
            if (z) {
                this.bWQ.setVisibility(0);
            } else {
                this.bWQ.setVisibility(8);
            }
        }
    }

    public void a(int i, b bVar, boolean z) {
        fh(true);
        d ui = ui(i);
        if (ui != null) {
            ui.a(bVar, z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWQ != null) {
            this.bWQ.onChangeSkinType(i);
        }
    }

    private void ug(int i) {
        View inflate = ((ViewStub) this.mRootView.findViewById(d.g.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        this.bWQ = (FragmentTabHost) inflate.findViewById(d.g.post_search_tab_host);
        this.bWQ.setup(this.gye.getSupportFragmentManager());
        this.bWQ.setTabWidgetViewHeight((int) this.gye.getResources().getDimension(d.e.ds80));
        this.bWQ.setShouldDrawIndicatorLine(true);
        bnf();
        this.bWQ.fw(3);
        this.bWQ.setCurrentTabByType(i);
        this.bWQ.setNeedShowThemeStyle(false);
        this.bWQ.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.bWQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.bWQ.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        if (this.bWQ != null) {
            this.bWQ.setOnPageChangeListener(this.mOnPageChangeListener);
        }
    }

    private void bnf() {
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        this.gyS = new d(1);
        cVar.aUp = this.gyS;
        cVar.aUo = uh(d.j.searching_time_tab);
        cVar.mType = 1;
        this.bWQ.a(cVar);
        FragmentTabHost.c cVar2 = new FragmentTabHost.c();
        this.gyT = new d(2);
        cVar2.aUp = this.gyT;
        cVar2.aUo = uh(d.j.searching_relative_tab);
        cVar2.mType = 2;
        this.bWQ.a(cVar2);
        FragmentTabHost.c cVar3 = new FragmentTabHost.c();
        this.gyU = new d(3);
        cVar3.aUp = this.gyU;
        cVar3.aUo = uh(d.j.searching_only_thread_tab);
        cVar3.mType = 3;
        this.bWQ.a(cVar3);
    }

    private FragmentTabIndicator uh(int i) {
        int ao = (l.ao(this.gye.getPageContext().getContext()) - (this.gye.getResources().getDimensionPixelSize(d.e.ds34) * 2)) / 3;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.gye.getPageContext().getPageActivity()).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.gye.getResources().getDimensionPixelSize(d.e.ds32));
        fragmentTabIndicator.bxI = d.C0141d.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.gye.getResources().getDimensionPixelSize(d.e.ds4));
        fragmentTabIndicator.setWidth(ao);
        return fragmentTabIndicator;
    }

    private d ui(int i) {
        switch (i) {
            case 1:
                return this.gyS;
            case 2:
                return this.gyT;
            case 3:
                return this.gyU;
            default:
                return null;
        }
    }

    private void bng() {
        this.gyS.bmX();
        this.gyT.bmX();
        this.gyU.bmX();
    }
}
