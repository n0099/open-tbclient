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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n {
    protected TbPageContext Gd;
    private com.baidu.tbadk.g.f HA;
    protected NoNetworkView Hi;
    protected PluginErrorTipView bGy;
    private boolean bRW = true;
    protected m eDi;
    protected w fWl;
    public t fWm;
    protected BdPersonListView fWn;
    protected com.baidu.tieba.model.a fWo;
    private v fWp;
    protected int fWq;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.q mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.g.h refreshView;

    protected abstract void a(float f, boolean z);

    public n(TbPageContext tbPageContext) {
        this.Gd = tbPageContext;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(t.h.fragment_person_center_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(t.g.person_center_navigation_bar);
        this.Hi = (NoNetworkView) this.mRootView.findViewById(t.g.person_center_no_network_view);
        this.bGy = (PluginErrorTipView) this.mRootView.findViewById(t.g.person_center_plugin_error_tip_view);
        this.fWn = (BdPersonListView) this.mRootView.findViewById(t.g.person_center_listview);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fWl.a(this.Gd.getPageActivity(), this.mNavigationBar);
        this.fWn.setOnScrollListener(new o(this));
    }

    public void onChangeSkinType(int i) {
        av.k(this.mRootView, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(av.cO(t.f.s_navbar_bg)));
        this.fWl.onChangeSkinType(i);
        this.Hi.onChangeSkinType(this.Gd, i);
        this.bGy.onChangeSkinType(this.Gd, i);
        this.fWm.onChangeSkinType(i);
        if (this.fWn.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.fWn.getAdapter()).notifyDataSetChanged();
        }
        if (this.HA != null) {
            this.HA.ti();
        }
        if (this.refreshView != null) {
            this.refreshView.ti();
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.eDi = mVar;
        this.fWl.setOnViewResponseListener(mVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fWo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPN() {
        if (Build.VERSION.SDK_INT >= 11 && this.fWm != null) {
            int dimension = (int) this.Gd.getResources().getDimension(t.e.ds98);
            int i = this.fWq - (-this.fWm.aqE().getTop());
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
            if (this.fWn.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqp() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bRW) {
                    this.bRW = true;
                }
            } else if (this.bRW) {
                this.bRW = false;
            }
            a(alpha, !this.bRW);
            this.fWl.b(alpha, this.bRW ? false : true);
        }
    }

    public void dt(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.y.t(list)) {
            list = new ArrayList<>();
        }
        this.fWn.setData(list);
    }

    public void i(boolean z, int i) {
        if (!aoZ()) {
            if (this.HA == null) {
                if (i < 0) {
                    this.HA = new com.baidu.tbadk.g.f(this.Gd.getPageActivity());
                } else {
                    this.HA = new com.baidu.tbadk.g.f(this.Gd.getPageActivity(), i);
                }
                this.HA.ti();
            }
            this.HA.b(this.mRootView, z);
            this.fWn.setVisibility(8);
        }
    }

    public void Lb() {
        if (this.HA != null) {
            this.HA.L(this.mRootView);
            this.HA = null;
        }
        this.fWn.setVisibility(0);
    }

    private boolean aoZ() {
        if (this.HA != null) {
            return this.HA.Eu();
        }
        return false;
    }

    public void F(String str, boolean z) {
        if (!amA()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.g.h(this.Gd.getPageActivity(), new p(this));
            }
            this.refreshView.eT(this.Gd.getResources().getDimensionPixelSize(t.e.ds280));
            this.refreshView.fY(str);
            this.refreshView.b(this.mRootView, z);
            this.refreshView.EB();
            this.fWn.setVisibility(8);
        }
    }

    public void La() {
        if (this.refreshView != null) {
            this.refreshView.L(this.mRootView);
            this.refreshView = null;
        }
        this.fWn.setVisibility(0);
    }

    public boolean amA() {
        if (this.refreshView != null) {
            return this.refreshView.Eu();
        }
        return false;
    }

    public void a(v vVar) {
        this.fWp = vVar;
    }

    public View bqq() {
        return this.mNavigationBar;
    }
}
