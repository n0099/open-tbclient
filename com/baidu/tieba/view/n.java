package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n {
    protected TbPageContext Fp;
    private com.baidu.tbadk.f.f GL;
    protected NoNetworkView Gt;
    private boolean bdP = true;
    protected int bdR;
    protected PluginErrorTipView bxt;
    protected m ezb;
    protected BdPersonListView fDA;
    protected com.baidu.tieba.model.a fDB;
    private v fDC;
    protected w fDy;
    public t fDz;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.x mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.f.h refreshView;

    protected abstract void a(float f, boolean z);

    public n(TbPageContext tbPageContext) {
        this.Fp = tbPageContext;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(r.j.fragment_person_center_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(r.h.person_center_navigation_bar);
        this.Gt = (NoNetworkView) this.mRootView.findViewById(r.h.person_center_no_network_view);
        this.bxt = (PluginErrorTipView) this.mRootView.findViewById(r.h.person_center_plugin_error_tip_view);
        this.fDA = (BdPersonListView) this.mRootView.findViewById(r.h.person_center_listview);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fDy.a(this.Fp.getPageActivity(), this.mNavigationBar);
        this.fDA.setOnScrollListener(new o(this));
    }

    public void onChangeSkinType(int i) {
        ap.j(this.mRootView, r.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ap.cQ(r.g.s_navbar_bg)));
        this.fDy.onChangeSkinType(i);
        this.Gt.onChangeSkinType(this.Fp, i);
        this.bxt.onChangeSkinType(this.Fp, i);
        this.fDz.onChangeSkinType(i);
        if (this.fDA.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.fDA.getAdapter()).notifyDataSetChanged();
        }
        if (this.GL != null) {
            this.GL.tg();
        }
        if (this.refreshView != null) {
            this.refreshView.tg();
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.ezb = mVar;
        this.fDy.setOnViewResponseListener(mVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fDB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pw() {
        if (Build.VERSION.SDK_INT >= 11 && this.fDz != null) {
            int dimension = (int) this.Fp.getResources().getDimension(r.f.ds98);
            int i = this.bdR - (-this.fDz.PG().getTop());
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
            if (this.fDA.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bdP) {
                    this.bdP = true;
                }
            } else if (this.bdP) {
                this.bdP = false;
            }
            a(alpha, !this.bdP);
            this.fDy.c(alpha, this.bdP ? false : true);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.w.s(list)) {
            list = new ArrayList<>();
        }
        this.fDA.setVisibility(0);
        this.fDA.setData(list);
    }

    public void g(boolean z, int i) {
        if (!amS()) {
            if (this.GL == null) {
                if (i < 0) {
                    this.GL = new com.baidu.tbadk.f.f(this.Fp.getPageActivity());
                } else {
                    this.GL = new com.baidu.tbadk.f.f(this.Fp.getPageActivity(), i);
                }
                this.GL.tg();
            }
            this.GL.b(this.mRootView, z);
            this.fDA.setVisibility(8);
        }
    }

    public void Jx() {
        if (this.GL != null) {
            this.GL.K(this.mRootView);
            this.GL = null;
        }
    }

    private boolean amS() {
        if (this.GL != null) {
            return this.GL.Ec();
        }
        return false;
    }

    public void G(String str, boolean z) {
        if (!ajZ()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.f.h(this.Fp.getPageActivity(), new p(this));
            }
            this.refreshView.eX(this.Fp.getResources().getDimensionPixelSize(r.f.ds280));
            this.refreshView.fY(str);
            this.refreshView.b(this.mRootView, z);
            this.refreshView.Ej();
            this.fDA.setVisibility(8);
        }
    }

    public void Jy() {
        if (this.refreshView != null) {
            this.refreshView.K(this.mRootView);
            this.refreshView = null;
        }
    }

    public boolean ajZ() {
        if (this.refreshView != null) {
            return this.refreshView.Ec();
        }
        return false;
    }

    public void a(v vVar) {
        this.fDC = vVar;
    }

    public View blP() {
        return this.mNavigationBar;
    }
}
