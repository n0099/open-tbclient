package com.baidu.tieba.personPolymeric.b;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    protected TbPageContext aat;
    private PluginErrorTipView bSV;
    private NoNetworkView bbO;
    public PbListView bbP;
    private com.baidu.tbadk.i.f bdc;
    protected BdPersonListView eUV;
    protected LinearLayout eUW;
    private a eUX;
    private ImageView eUY;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.y mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.i.h refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void T(View view);
    }

    public i(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.aat = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(w.h.person_center_navigation_bar);
            this.eUV = (BdPersonListView) this.mRootView.findViewById(w.h.person_center_listview);
            this.eUW = (LinearLayout) this.mRootView.findViewById(w.h.person_center_blank_view);
            this.bbO = (NoNetworkView) this.mRootView.findViewById(w.h.person_center_no_network_view);
            this.bSV = (PluginErrorTipView) this.mRootView.findViewById(w.h.person_center_plugin_error_tip_view);
            this.bbP = new PbListView(this.aat.getPageActivity());
            this.bbP.lc();
            this.bbP.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_d));
            this.bbP.dk(w.e.cp_bg_line_c);
            this.eUV.setNextPage(this.bbP);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void aUZ() {
        if (this.mRootView != null) {
            this.eUV.setVisibility(8);
            if (this.eUW != null) {
                this.eUW.setVisibility(8);
            }
            if (this.eUY != null) {
                this.eUY.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new j(this));
            this.mNavigationBar.setLoginClickListener(new k(this));
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.aat.getResources().getDimensionPixelSize(w.f.ds320);
            int dimensionPixelSize2 = this.aat.getResources().getDimensionPixelSize(w.f.ds480);
            int dimensionPixelSize3 = this.aat.getResources().getDimensionPixelSize(w.f.ds360);
            int dimensionPixelSize4 = this.aat.getResources().getDimensionPixelSize(w.f.ds60);
            int dimensionPixelSize5 = this.aat.getResources().getDimensionPixelSize(w.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aat.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(w.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aat.getString(w.l.unlogin_person_button_text), new l(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aat, i);
        }
        com.baidu.tbadk.core.util.as.j(this.eUW, w.g.item_person_header_attention_bg_selector);
        com.baidu.tbadk.core.util.as.j(this.mRootView, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.as.cP(w.g.s_navbar_bg)));
        if (this.eUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.eUV.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.bbO.onChangeSkinType(this.aat, i);
        this.bSV.onChangeSkinType(this.aat, i);
    }

    public void a(a aVar) {
        this.eUX = aVar;
    }

    public void Np() {
        if (this.refreshView != null) {
            this.refreshView.I(this.mRootView);
            this.refreshView = null;
        }
    }

    public void h(boolean z, int i) {
        if (this.bdc == null) {
            if (i < 0) {
                this.bdc = new com.baidu.tbadk.i.f(this.aat.getContext());
            } else {
                this.bdc = new com.baidu.tbadk.i.f(this.aat.getContext(), i);
            }
            this.bdc.onChangeSkinType();
        }
        this.bdc.c(this.mRootView, z);
    }

    public void Nm() {
        if (this.bdc != null) {
            this.bdc.I(this.mRootView);
            this.bdc = null;
        }
    }

    public void jR(boolean z) {
        if (z) {
            this.eUV.smoothScrollToPosition(0);
            aVa();
        }
    }

    public void kj(int i) {
        this.eUV.setVisibility(i);
    }

    public void J(String str, boolean z) {
        if (!amv()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.i.h(this.aat.getPageActivity(), new m(this));
            }
            this.refreshView.eU(this.aat.getResources().getDimensionPixelSize(w.f.ds280));
            this.refreshView.gk(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.Ev();
            this.refreshView.onChangeSkinType();
            this.eUV.setVisibility(8);
            if (this.eUY != null) {
                this.eUY.setVisibility(8);
            }
        }
    }

    public boolean amv() {
        if (this.refreshView != null) {
            return this.refreshView.Eo();
        }
        return false;
    }

    public void wD() {
        if (this.bbP != null) {
            this.bbP.wD();
        }
    }

    public void wE() {
        if (this.bbP != null) {
            this.bbP.wE();
        }
    }

    public void dD(boolean z) {
        if (this.eUV != null && this.bbP != null) {
            this.bbP.wE();
            if (z) {
                this.bbP.setText(this.aat.getString(w.l.list_no_more));
            } else {
                this.bbP.setText("");
            }
        }
    }

    public void WU() {
        if (this.eUV != null && this.bbP != null) {
            this.eUV.setNextPage(null);
            this.bbP.wG();
        }
    }

    public void cq(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.z.t(list)) {
            list = new ArrayList<>();
        }
        if (this.eUV.getVisibility() != 0) {
            this.eUV.setVisibility(0);
        }
        this.eUV.setData(list);
    }

    public void aVa() {
        if (com.baidu.tbadk.n.ab.fU()) {
            if (this.eUY == null) {
                this.eUY = new ImageView(this.aat.getPageActivity());
                this.eUY.setImageResource(w.g.icon_nichengjun);
                this.eUY.setOnClickListener(new n(this));
            }
            if (this.eUY.getParent() != null) {
                ((ViewGroup) this.eUY.getParent()).removeView(this.eUY);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds504);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.eUY, layoutParams);
            }
        } else if (this.eUY != null && this.eUY.getParent() != null && this.eUY.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.eUY);
        }
    }
}
