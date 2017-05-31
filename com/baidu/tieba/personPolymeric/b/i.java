package com.baidu.tieba.personPolymeric.b;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private NoNetworkView aZX;
    public PbListView aZY;
    protected TbPageContext aas;
    private PluginErrorTipView bMu;
    protected BdPersonListView eKW;
    protected LinearLayout eKX;
    private a eKY;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.y mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.i.h refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void bd(View view);
    }

    public i(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.aas = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(w.h.person_center_navigation_bar);
            this.eKW = (BdPersonListView) this.mRootView.findViewById(w.h.person_center_listview);
            this.eKX = (LinearLayout) this.mRootView.findViewById(w.h.person_center_blank_view);
            this.aZX = (NoNetworkView) this.mRootView.findViewById(w.h.person_center_no_network_view);
            this.bMu = (PluginErrorTipView) this.mRootView.findViewById(w.h.person_center_plugin_error_tip_view);
            this.aZY = new PbListView(this.aas.getPageActivity());
            this.aZY.le();
            this.aZY.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
            this.aZY.di(w.e.cp_bg_line_c);
            this.eKW.setNextPage(this.aZY);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void aQU() {
        if (this.mRootView != null) {
            this.eKW.setVisibility(8);
            if (this.eKX != null) {
                this.eKX.setVisibility(8);
            }
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new j(this));
            this.mNavigationBar.setLoginClickListener(new k(this));
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.aas.getResources().getDimensionPixelSize(w.f.ds320);
            int dimensionPixelSize2 = this.aas.getResources().getDimensionPixelSize(w.f.ds480);
            int dimensionPixelSize3 = this.aas.getResources().getDimensionPixelSize(w.f.ds360);
            int dimensionPixelSize4 = this.aas.getResources().getDimensionPixelSize(w.f.ds60);
            int dimensionPixelSize5 = this.aas.getResources().getDimensionPixelSize(w.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aas.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(w.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aas.getString(w.l.unlogin_person_button_text), new l(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aas, i);
        }
        com.baidu.tbadk.core.util.aq.j(this.eKX, w.g.item_person_header_attention_bg_selector);
        com.baidu.tbadk.core.util.aq.j(this.mRootView, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cN(w.g.s_navbar_bg)));
        if (this.eKW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.eKW.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.aZX.onChangeSkinType(this.aas, i);
        this.bMu.onChangeSkinType(this.aas, i);
    }

    public void a(a aVar) {
        this.eKY = aVar;
    }

    public void Mx() {
        if (this.refreshView != null) {
            this.refreshView.H(this.mRootView);
            this.refreshView = null;
        }
    }

    public void jt(boolean z) {
        if (z) {
            this.eKW.smoothScrollToPosition(0);
        }
    }

    public void E(String str, boolean z) {
        if (!aiJ()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.i.h(this.aas.getPageActivity(), new m(this));
            }
            this.refreshView.eS(this.aas.getResources().getDimensionPixelSize(w.f.ds280));
            this.refreshView.fP(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.DY();
            this.eKW.setVisibility(8);
        }
    }

    public boolean aiJ() {
        if (this.refreshView != null) {
            return this.refreshView.DR();
        }
        return false;
    }

    public void wl() {
        if (this.aZY != null) {
            this.aZY.wl();
        }
    }

    public void wm() {
        if (this.aZY != null) {
            this.aZY.wm();
        }
    }

    public void dB(boolean z) {
        if (this.eKW != null && this.aZY != null) {
            this.aZY.wm();
            if (z) {
                this.aZY.setText(this.aas.getString(w.l.list_no_more));
            } else {
                this.aZY.setText("");
            }
        }
    }

    public void VD() {
        if (this.eKW != null && this.aZY != null) {
            this.eKW.setNextPage(null);
            this.aZY.wo();
        }
    }

    public void cb(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.r(list)) {
            list = new ArrayList<>();
        }
        if (this.eKW.getVisibility() != 0) {
            this.eKW.setVisibility(0);
        }
        this.eKW.setData(list);
    }
}
