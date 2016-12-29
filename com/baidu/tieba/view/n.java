package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n {
    protected TbPageContext Gf;
    private com.baidu.tbadk.f.f HB;
    protected NoNetworkView Hj;
    private boolean bAr = true;
    protected PluginErrorTipView bpH;
    protected m epg;
    protected w fuD;
    public t fuE;
    protected BdPersonListView fuF;
    protected com.baidu.tieba.model.a fuG;
    private v fuH;
    protected int fuI;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.w mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.f.h refreshView;

    protected abstract void a(float f, boolean z);

    public n(TbPageContext tbPageContext) {
        this.Gf = tbPageContext;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(r.h.fragment_person_center_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(r.g.person_center_navigation_bar);
        this.Hj = (NoNetworkView) this.mRootView.findViewById(r.g.person_center_no_network_view);
        this.bpH = (PluginErrorTipView) this.mRootView.findViewById(r.g.person_center_plugin_error_tip_view);
        this.fuF = (BdPersonListView) this.mRootView.findViewById(r.g.person_center_listview);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fuD.a(this.Gf.getPageActivity(), this.mNavigationBar);
        this.fuF.setOnScrollListener(new o(this));
    }

    public void onChangeSkinType(int i) {
        ar.k(this.mRootView, r.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ar.cR(r.f.s_navbar_bg)));
        this.fuD.onChangeSkinType(i);
        this.Hj.onChangeSkinType(this.Gf, i);
        this.bpH.onChangeSkinType(this.Gf, i);
        this.fuE.onChangeSkinType(i);
        if (this.fuF.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.fuF.getAdapter()).notifyDataSetChanged();
        }
        if (this.HB != null) {
            this.HB.tm();
        }
        if (this.refreshView != null) {
            this.refreshView.tm();
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.epg = mVar;
        this.fuD.setOnViewResponseListener(mVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fuG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkl() {
        if (Build.VERSION.SDK_INT >= 11 && this.fuE != null) {
            int dimension = (int) this.Gf.getResources().getDimension(r.e.ds98);
            int i = this.fuI - (-this.fuE.anz().getTop());
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
            if (this.fuF.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkm() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bAr) {
                    this.bAr = true;
                }
            } else if (this.bAr) {
                this.bAr = false;
            }
            a(alpha, !this.bAr);
            this.fuD.c(alpha, this.bAr ? false : true);
        }
    }

    public void dj(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.t(list)) {
            list = new ArrayList<>();
        }
        this.fuF.setVisibility(0);
        this.fuF.setData(list);
    }

    public void g(boolean z, int i) {
        if (!alL()) {
            if (this.HB == null) {
                if (i < 0) {
                    this.HB = new com.baidu.tbadk.f.f(this.Gf.getPageActivity());
                } else {
                    this.HB = new com.baidu.tbadk.f.f(this.Gf.getPageActivity(), i);
                }
                this.HB.tm();
            }
            this.HB.b(this.mRootView, z);
            this.fuF.setVisibility(8);
        }
    }

    public void Jj() {
        if (this.HB != null) {
            this.HB.M(this.mRootView);
            this.HB = null;
        }
    }

    private boolean alL() {
        if (this.HB != null) {
            return this.HB.Eh();
        }
        return false;
    }

    public void H(String str, boolean z) {
        if (!aiS()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.f.h(this.Gf.getPageActivity(), new p(this));
            }
            this.refreshView.eW(this.Gf.getResources().getDimensionPixelSize(r.e.ds280));
            this.refreshView.gb(str);
            this.refreshView.b(this.mRootView, z);
            this.refreshView.Eo();
            this.fuF.setVisibility(8);
        }
    }

    public void Jk() {
        if (this.refreshView != null) {
            this.refreshView.M(this.mRootView);
            this.refreshView = null;
        }
    }

    public boolean aiS() {
        if (this.refreshView != null) {
            return this.refreshView.Eh();
        }
        return false;
    }

    public void a(v vVar) {
        this.fuH = vVar;
    }

    public View bkn() {
        return this.mNavigationBar;
    }
}
