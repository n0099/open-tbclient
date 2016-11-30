package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
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
    private com.baidu.tbadk.f.f HC;
    protected NoNetworkView Hk;
    protected PluginErrorTipView bJD;
    private boolean bUg = true;
    protected m eLK;
    protected w gfL;
    public t gfM;
    protected BdPersonListView gfN;
    protected com.baidu.tieba.model.a gfO;
    private v gfP;
    protected int gfQ;
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
        this.Hk = (NoNetworkView) this.mRootView.findViewById(r.g.person_center_no_network_view);
        this.bJD = (PluginErrorTipView) this.mRootView.findViewById(r.g.person_center_plugin_error_tip_view);
        this.gfN = (BdPersonListView) this.mRootView.findViewById(r.g.person_center_listview);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.gfL.a(this.Gf.getPageActivity(), this.mNavigationBar);
        this.gfN.setOnScrollListener(new o(this));
    }

    public void onChangeSkinType(int i) {
        at.k(this.mRootView, r.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(at.cP(r.f.s_navbar_bg)));
        this.gfL.onChangeSkinType(i);
        this.Hk.onChangeSkinType(this.Gf, i);
        this.bJD.onChangeSkinType(this.Gf, i);
        this.gfM.onChangeSkinType(i);
        if (this.gfN.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.gfN.getAdapter()).notifyDataSetChanged();
        }
        if (this.HC != null) {
            this.HC.tB();
        }
        if (this.refreshView != null) {
            this.refreshView.tB();
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.eLK = mVar;
        this.gfL.setOnViewResponseListener(mVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gfO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSr() {
        if (Build.VERSION.SDK_INT >= 11 && this.gfM != null) {
            int dimension = (int) this.Gf.getResources().getDimension(r.e.ds98);
            int i = this.gfQ - (-this.gfM.ata().getTop());
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
            if (this.gfN.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btm() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bUg) {
                    this.bUg = true;
                }
            } else if (this.bUg) {
                this.bUg = false;
            }
            a(alpha, !this.bUg);
            this.gfL.c(alpha, this.bUg ? false : true);
        }
    }

    public void dA(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.t(list)) {
            list = new ArrayList<>();
        }
        this.gfN.setVisibility(0);
        this.gfN.setData(list);
    }

    public void j(boolean z, int i) {
        if (!arj()) {
            if (this.HC == null) {
                if (i < 0) {
                    this.HC = new com.baidu.tbadk.f.f(this.Gf.getPageActivity());
                } else {
                    this.HC = new com.baidu.tbadk.f.f(this.Gf.getPageActivity(), i);
                }
                this.HC.tB();
            }
            this.HC.b(this.mRootView, z);
            this.gfN.setVisibility(8);
        }
    }

    public void JO() {
        if (this.HC != null) {
            this.HC.M(this.mRootView);
            this.HC = null;
        }
    }

    private boolean arj() {
        if (this.HC != null) {
            return this.HC.Ez();
        }
        return false;
    }

    public void G(String str, boolean z) {
        if (!aos()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.f.h(this.Gf.getPageActivity(), new p(this));
            }
            this.refreshView.eV(this.Gf.getResources().getDimensionPixelSize(r.e.ds280));
            this.refreshView.gf(str);
            this.refreshView.b(this.mRootView, z);
            this.refreshView.EG();
            this.gfN.setVisibility(8);
        }
    }

    public void JP() {
        if (this.refreshView != null) {
            this.refreshView.M(this.mRootView);
            this.refreshView = null;
        }
    }

    public boolean aos() {
        if (this.refreshView != null) {
            return this.refreshView.Ez();
        }
        return false;
    }

    public void a(v vVar) {
        this.gfP = vVar;
    }

    public View btn() {
        return this.mNavigationBar;
    }
}
