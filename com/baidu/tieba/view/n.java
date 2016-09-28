package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n {
    protected TbPageContext Gd;
    private com.baidu.tbadk.f.f HA;
    protected NoNetworkView Hi;
    protected PluginErrorTipView bGJ;
    private boolean bRP = true;
    protected m eFl;
    protected w fYq;
    public t fYr;
    protected BdPersonListView fYs;
    protected com.baidu.tieba.model.a fYt;
    private v fYu;
    protected int fYv;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.v mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.f.h refreshView;

    protected abstract void a(float f, boolean z);

    public n(TbPageContext tbPageContext) {
        this.Gd = tbPageContext;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(r.h.fragment_person_center_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(r.g.person_center_navigation_bar);
        this.Hi = (NoNetworkView) this.mRootView.findViewById(r.g.person_center_no_network_view);
        this.bGJ = (PluginErrorTipView) this.mRootView.findViewById(r.g.person_center_plugin_error_tip_view);
        this.fYs = (BdPersonListView) this.mRootView.findViewById(r.g.person_center_listview);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fYq.a(this.Gd.getPageActivity(), this.mNavigationBar);
        this.fYs.setOnScrollListener(new o(this));
    }

    public void onChangeSkinType(int i) {
        av.k(this.mRootView, r.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(av.cO(r.f.s_navbar_bg)));
        this.fYq.onChangeSkinType(i);
        this.Hi.onChangeSkinType(this.Gd, i);
        this.bGJ.onChangeSkinType(this.Gd, i);
        this.fYr.onChangeSkinType(i);
        if (this.fYs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.fYs.getAdapter()).notifyDataSetChanged();
        }
        if (this.HA != null) {
            this.HA.tx();
        }
        if (this.refreshView != null) {
            this.refreshView.tx();
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.eFl = mVar;
        this.fYq.setOnViewResponseListener(mVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fYt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQw() {
        if (Build.VERSION.SDK_INT >= 11 && this.fYr != null) {
            int dimension = (int) this.Gd.getResources().getDimension(r.e.ds98);
            int i = this.fYv - (-this.fYr.ard().getTop());
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
            if (this.fYs.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqT() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bRP) {
                    this.bRP = true;
                }
            } else if (this.bRP) {
                this.bRP = false;
            }
            a(alpha, !this.bRP);
            this.fYq.b(alpha, this.bRP ? false : true);
        }
    }

    public void du(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.y.t(list)) {
            list = new ArrayList<>();
        }
        this.fYs.setData(list);
    }

    public void j(boolean z, int i) {
        if (!apn()) {
            if (this.HA == null) {
                if (i < 0) {
                    this.HA = new com.baidu.tbadk.f.f(this.Gd.getPageActivity());
                } else {
                    this.HA = new com.baidu.tbadk.f.f(this.Gd.getPageActivity(), i);
                }
                this.HA.tx();
            }
            this.HA.b(this.mRootView, z);
            this.fYs.setVisibility(8);
        }
    }

    public void JE() {
        if (this.HA != null) {
            this.HA.L(this.mRootView);
            this.HA = null;
        }
        this.fYs.setVisibility(0);
    }

    private boolean apn() {
        if (this.HA != null) {
            return this.HA.Eu();
        }
        return false;
    }

    public void G(String str, boolean z) {
        if (!amx()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.f.h(this.Gd.getPageActivity(), new p(this));
            }
            this.refreshView.eS(this.Gd.getResources().getDimensionPixelSize(r.e.ds280));
            this.refreshView.gc(str);
            this.refreshView.b(this.mRootView, z);
            this.refreshView.EB();
            this.fYs.setVisibility(8);
        }
    }

    public void JJ() {
        if (this.refreshView != null) {
            this.refreshView.L(this.mRootView);
            this.refreshView = null;
        }
        this.fYs.setVisibility(0);
    }

    public boolean amx() {
        if (this.refreshView != null) {
            return this.refreshView.Eu();
        }
        return false;
    }

    public void a(v vVar) {
        this.fYu = vVar;
    }

    public View bqU() {
        return this.mNavigationBar;
    }
}
