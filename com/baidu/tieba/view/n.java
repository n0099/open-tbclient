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
    protected NoNetworkView aRN;
    private com.baidu.tbadk.i.f aRP;
    protected TbPageContext aaY;
    protected PluginErrorTipView bGJ;
    private boolean bmM = true;
    protected int bmO;
    protected m eCN;
    protected w fMe;
    public t fMf;
    protected BdPersonListView fMg;
    protected com.baidu.tieba.model.a fMh;
    private v fMi;
    protected NavigationBar mNavigationBar;
    protected y mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.i.h refreshView;

    protected abstract void a(float f, boolean z);

    public n(TbPageContext tbPageContext) {
        this.aaY = tbPageContext;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(w.j.fragment_person_center_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(w.h.person_center_navigation_bar);
        this.aRN = (NoNetworkView) this.mRootView.findViewById(w.h.person_center_no_network_view);
        this.bGJ = (PluginErrorTipView) this.mRootView.findViewById(w.h.person_center_plugin_error_tip_view);
        this.fMg = (BdPersonListView) this.mRootView.findViewById(w.h.person_center_listview);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fMe.a(this.aaY.getPageActivity(), this.mNavigationBar);
        this.fMg.setOnScrollListener(new o(this));
    }

    public void onChangeSkinType(int i) {
        aq.j(this.mRootView, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aq.cP(w.g.s_navbar_bg)));
        this.fMe.onChangeSkinType(i);
        this.aRN.onChangeSkinType(this.aaY, i);
        this.bGJ.onChangeSkinType(this.aaY, i);
        this.fMf.onChangeSkinType(i);
        if (this.fMg.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.fMg.getAdapter()).notifyDataSetChanged();
        }
        if (this.aRP != null) {
            this.aRP.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.eCN = mVar;
        this.fMe.setOnViewResponseListener(mVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fMh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RP() {
        if (Build.VERSION.SDK_INT >= 11 && this.fMf != null) {
            int dimension = (int) this.aaY.getResources().getDimension(w.f.ds98);
            int i = this.bmO - (-this.fMf.RZ().getTop());
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
            if (this.fMg.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RQ() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bmM) {
                    this.bmM = true;
                }
            } else if (this.bmM) {
                this.bmM = false;
            }
            a(alpha, !this.bmM);
            this.fMe.c(alpha, this.bmM ? false : true);
        }
    }

    public void cU(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.q(list)) {
            list = new ArrayList<>();
        }
        this.fMg.setVisibility(0);
        this.fMg.setData(list);
    }

    public void h(boolean z, int i) {
        if (!ana()) {
            if (this.aRP == null) {
                if (i < 0) {
                    this.aRP = new com.baidu.tbadk.i.f(this.aaY.getPageActivity());
                } else {
                    this.aRP = new com.baidu.tbadk.i.f(this.aaY.getPageActivity(), i);
                }
                this.aRP.onChangeSkinType();
            }
            this.aRP.b(this.mRootView, z);
            this.fMg.setVisibility(8);
        }
    }

    public void KC() {
        if (this.aRP != null) {
            this.aRP.I(this.mRootView);
            this.aRP = null;
        }
    }

    private boolean ana() {
        if (this.aRP != null) {
            return this.aRP.ET();
        }
        return false;
    }

    public void H(String str, boolean z) {
        if (!akg()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.i.h(this.aaY.getPageActivity(), new p(this));
            }
            this.refreshView.eV(this.aaY.getResources().getDimensionPixelSize(w.f.ds280));
            this.refreshView.fT(str);
            this.refreshView.b(this.mRootView, z);
            this.refreshView.Fa();
            this.fMg.setVisibility(8);
        }
    }

    public void KD() {
        if (this.refreshView != null) {
            this.refreshView.I(this.mRootView);
            this.refreshView = null;
        }
    }

    public boolean akg() {
        if (this.refreshView != null) {
            return this.refreshView.ET();
        }
        return false;
    }

    public void a(v vVar) {
        this.fMi = vVar;
    }

    public View bnp() {
        return this.mNavigationBar;
    }
}
