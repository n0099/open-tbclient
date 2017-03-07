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
    protected NoNetworkView aRv;
    private com.baidu.tbadk.f.f aRx;
    protected TbPageContext aaI;
    protected PluginErrorTipView bEz;
    private boolean bkC = true;
    protected int bkE;
    protected m eCA;
    protected w fHZ;
    public t fIa;
    protected BdPersonListView fIb;
    protected com.baidu.tieba.model.a fIc;
    private v fId;
    protected NavigationBar mNavigationBar;
    protected y mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.f.h refreshView;

    protected abstract void a(float f, boolean z);

    public n(TbPageContext tbPageContext) {
        this.aaI = tbPageContext;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(w.j.fragment_person_center_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(w.h.person_center_navigation_bar);
        this.aRv = (NoNetworkView) this.mRootView.findViewById(w.h.person_center_no_network_view);
        this.bEz = (PluginErrorTipView) this.mRootView.findViewById(w.h.person_center_plugin_error_tip_view);
        this.fIb = (BdPersonListView) this.mRootView.findViewById(w.h.person_center_listview);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fHZ.a(this.aaI.getPageActivity(), this.mNavigationBar);
        this.fIb.setOnScrollListener(new o(this));
    }

    public void onChangeSkinType(int i) {
        aq.j(this.mRootView, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aq.cM(w.g.s_navbar_bg)));
        this.fHZ.onChangeSkinType(i);
        this.aRv.onChangeSkinType(this.aaI, i);
        this.bEz.onChangeSkinType(this.aaI, i);
        this.fIa.onChangeSkinType(i);
        if (this.fIb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.fIb.getAdapter()).notifyDataSetChanged();
        }
        if (this.aRx != null) {
            this.aRx.tD();
        }
        if (this.refreshView != null) {
            this.refreshView.tD();
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.eCA = mVar;
        this.fHZ.setOnViewResponseListener(mVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fIc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qp() {
        if (Build.VERSION.SDK_INT >= 11 && this.fIa != null) {
            int dimension = (int) this.aaI.getResources().getDimension(w.f.ds98);
            int i = this.bkE - (-this.fIa.Qz().getTop());
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
            if (this.fIb.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qq() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bkC) {
                    this.bkC = true;
                }
            } else if (this.bkC) {
                this.bkC = false;
            }
            a(alpha, !this.bkC);
            this.fHZ.c(alpha, this.bkC ? false : true);
        }
    }

    public void cV(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.q(list)) {
            list = new ArrayList<>();
        }
        this.fIb.setVisibility(0);
        this.fIb.setData(list);
    }

    public void g(boolean z, int i) {
        if (!amf()) {
            if (this.aRx == null) {
                if (i < 0) {
                    this.aRx = new com.baidu.tbadk.f.f(this.aaI.getPageActivity());
                } else {
                    this.aRx = new com.baidu.tbadk.f.f(this.aaI.getPageActivity(), i);
                }
                this.aRx.tD();
            }
            this.aRx.b(this.mRootView, z);
            this.fIb.setVisibility(8);
        }
    }

    public void Kc() {
        if (this.aRx != null) {
            this.aRx.I(this.mRootView);
            this.aRx = null;
        }
    }

    private boolean amf() {
        if (this.aRx != null) {
            return this.aRx.Ev();
        }
        return false;
    }

    public void H(String str, boolean z) {
        if (!ajl()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.f.h(this.aaI.getPageActivity(), new p(this));
            }
            this.refreshView.eS(this.aaI.getResources().getDimensionPixelSize(w.f.ds280));
            this.refreshView.fN(str);
            this.refreshView.b(this.mRootView, z);
            this.refreshView.EC();
            this.fIb.setVisibility(8);
        }
    }

    public void Kd() {
        if (this.refreshView != null) {
            this.refreshView.I(this.mRootView);
            this.refreshView = null;
        }
    }

    public boolean ajl() {
        if (this.refreshView != null) {
            return this.refreshView.Ev();
        }
        return false;
    }

    public void a(v vVar) {
        this.fId = vVar;
    }

    public View blE() {
        return this.mNavigationBar;
    }
}
