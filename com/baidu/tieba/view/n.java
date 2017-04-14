package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n {
    protected NoNetworkView aRL;
    private com.baidu.tbadk.i.f aRN;
    protected TbPageContext aaX;
    protected PluginErrorTipView bEs;
    private boolean bkv = true;
    protected int bkx;
    protected m eAx;
    protected w fJI;
    public t fJJ;
    protected BdPersonListView fJK;
    protected com.baidu.tieba.model.a fJL;
    private v fJM;
    protected NavigationBar mNavigationBar;
    protected y mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.i.h refreshView;

    protected abstract void a(float f, boolean z);

    public n(TbPageContext tbPageContext) {
        this.aaX = tbPageContext;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(w.j.fragment_person_center_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(w.h.person_center_navigation_bar);
        this.aRL = (NoNetworkView) this.mRootView.findViewById(w.h.person_center_no_network_view);
        this.bEs = (PluginErrorTipView) this.mRootView.findViewById(w.h.person_center_plugin_error_tip_view);
        this.fJK = (BdPersonListView) this.mRootView.findViewById(w.h.person_center_listview);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fJI.a(this.aaX.getPageActivity(), this.mNavigationBar);
        this.fJK.setOnScrollListener(new o(this));
    }

    public void onChangeSkinType(int i) {
        aq.j(this.mRootView, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aq.cP(w.g.s_navbar_bg)));
        this.fJI.onChangeSkinType(i);
        this.aRL.onChangeSkinType(this.aaX, i);
        this.bEs.onChangeSkinType(this.aaX, i);
        this.fJJ.onChangeSkinType(i);
        if (this.fJK.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.fJK.getAdapter()).notifyDataSetChanged();
        }
        if (this.aRN != null) {
            this.aRN.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.eAx = mVar;
        this.fJI.setOnViewResponseListener(mVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fJL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QN() {
        if (Build.VERSION.SDK_INT >= 11 && this.fJJ != null) {
            int dimension = (int) this.aaX.getResources().getDimension(w.f.ds98);
            int i = this.bkx - (-this.fJJ.QX().getTop());
            if (i < dimension) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= dimension && i <= dimension * 2) {
                float f = 1.0f - (((i - dimension) * 1.0f) / dimension);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > dimension * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.fJK.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QO() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bkv) {
                    this.bkv = true;
                }
            } else if (this.bkv) {
                this.bkv = false;
            }
            a(alpha, !this.bkv);
            this.fJI.c(alpha, this.bkv ? false : true);
        }
    }

    public void cU(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.q(list)) {
            list = new ArrayList<>();
        }
        this.fJK.setVisibility(0);
        this.fJK.setData(list);
    }

    public void g(boolean z, int i) {
        if (!alZ()) {
            if (this.aRN == null) {
                if (i < 0) {
                    this.aRN = new com.baidu.tbadk.i.f(this.aaX.getPageActivity());
                } else {
                    this.aRN = new com.baidu.tbadk.i.f(this.aaX.getPageActivity(), i);
                }
                this.aRN.onChangeSkinType();
            }
            this.aRN.b(this.mRootView, z);
            this.fJK.setVisibility(8);
        }
    }

    public void KC() {
        if (this.aRN != null) {
            this.aRN.I(this.mRootView);
            this.aRN = null;
        }
    }

    private boolean alZ() {
        if (this.aRN != null) {
            return this.aRN.ET();
        }
        return false;
    }

    public void H(String str, boolean z) {
        if (!ajf()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.i.h(this.aaX.getPageActivity(), new p(this));
            }
            this.refreshView.eV(this.aaX.getResources().getDimensionPixelSize(w.f.ds280));
            this.refreshView.fT(str);
            this.refreshView.b(this.mRootView, z);
            this.refreshView.Fa();
            this.fJK.setVisibility(8);
        }
    }

    public void KD() {
        if (this.refreshView != null) {
            this.refreshView.I(this.mRootView);
            this.refreshView = null;
        }
    }

    public boolean ajf() {
        if (this.refreshView != null) {
            return this.refreshView.ET();
        }
        return false;
    }

    public void a(v vVar) {
        this.fJM = vVar;
    }

    public View bmo() {
        return this.mNavigationBar;
    }
}
