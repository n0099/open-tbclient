package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class s implements View.OnClickListener {
    protected TbPageContext aat;
    protected PluginErrorTipView bSV;
    protected NoNetworkView bbO;
    protected int bsi;
    protected r eRa;
    protected BdPersonListView eUV;
    protected LinearLayout eUW;
    protected View eXR;
    protected View eXS;
    private z gaA;
    protected TextView gaC;
    protected TextView gaD;
    private View gaE;
    private int gaG;
    protected q gas;
    private int gat;
    public x gau;
    protected View gav;
    protected View gaw;
    protected View gax;
    protected View gay;
    protected com.baidu.tieba.model.b gaz;
    protected NavigationBar mNavigationBar;
    public View mRootView;
    protected BaseWebView mWebView;
    private int aln = as.getColor(w.e.cp_cont_b);
    private int alo = as.getColor(w.e.cp_cont_f);
    private boolean bsg = true;
    private boolean gaB = false;
    protected boolean gaF = false;
    private int aRD = 0;

    protected abstract void a(float f, boolean z);

    public s(TbPageContext tbPageContext) {
        this.aat = tbPageContext;
    }

    public void O(View view) {
        this.gaF = UtilHelper.canUseStyleImmersiveSticky();
        this.gaG = com.baidu.adp.lib.util.k.dip2px(this.aat.getContext(), this.gaF ? 20 : 10);
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(w.h.person_center_navigation_bar);
        this.bbO = (NoNetworkView) this.mRootView.findViewById(w.h.person_center_no_network_view);
        this.bSV = (PluginErrorTipView) this.mRootView.findViewById(w.h.person_center_plugin_error_tip_view);
        this.eUV = (BdPersonListView) this.mRootView.findViewById(w.h.person_center_listview);
        this.eUW = (LinearLayout) this.mRootView.findViewById(w.h.person_center_blank_view);
        this.gay = this.eUW.findViewById(w.h.sticky_view);
        this.gaE = this.eUW.findViewById(w.h.person_center_sticky_person_buttom_header);
        this.gaC = (TextView) this.eUW.findViewById(w.h.fourm_name_btn);
        this.gaD = (TextView) this.eUW.findViewById(w.h.reply_btn);
        this.eXR = this.eUW.findViewById(w.h.fourm_name_divider);
        this.eXS = this.eUW.findViewById(w.h.reply_btn_divider);
        this.gaC.setOnClickListener(this);
        this.gaD.setOnClickListener(this);
        this.mWebView = (BaseWebView) this.mRootView.findViewById(w.h.webview);
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.gas.a(this.aat.getPageActivity(), this.mNavigationBar);
        this.eUV.setOnScrollListener(new t(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aVE() {
    }

    public void onChangeSkinType(int i) {
        this.aln = as.getColor(w.e.cp_cont_b);
        this.alo = as.getColor(w.e.cp_cont_f);
        as.j(this.eUW, w.g.item_person_header_attention_bg_selector);
        as.k(this.eXR, w.e.cp_cont_b);
        as.k(this.eXS, w.e.cp_cont_b);
        as.j(this.gaE, w.g.item_person_header_attention_bg_selector);
        as.j(this.mRootView, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(as.cP(w.g.s_navbar_bg)));
        if (this.gas != null) {
            this.gas.onChangeSkinType(i);
        }
        this.bbO.onChangeSkinType(this.aat, i);
        this.bSV.onChangeSkinType(this.aat, i);
        if (this.gau != null) {
            this.gau.onChangeSkinType(i);
        }
        if (this.eUV != null && (this.eUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.eUV.getAdapter()).notifyDataSetChanged();
        }
        cy(this.aRD);
    }

    public void setOnViewResponseListener(r rVar) {
        this.eRa = rVar;
        this.gas.setOnViewResponseListener(rVar);
    }

    public void a(com.baidu.tieba.model.b bVar) {
        this.gaz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl() {
        if (Build.VERSION.SDK_INT >= 11 && this.gau != null) {
            int dimension = (int) this.aat.getResources().getDimension(w.f.ds98);
            int i = -this.gau.Tv().getTop();
            int height = this.gau.Tv().getHeight();
            int i2 = height / 3;
            if (i < i2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
                }
            } else if (i >= i2 && i <= height) {
                double d = (i - i2) / (dimension + i2);
                this.mNavigationBar.getBarBgView().setAlpha((float) d);
                this.mNavigationBar.getTopCoverBgView().setAlpha((float) (1.0d - d));
            } else if (i > height - dimension && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
            if (this.eUV.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tm() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bsg) {
                    this.bsg = true;
                }
            } else if (this.bsg) {
                this.bsg = false;
            }
            a(alpha, !this.bsg);
            this.gas.b(alpha, this.bsg ? false : true);
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

    public void jR(boolean z) {
        if (z) {
            this.eUV.smoothScrollToPosition(0);
        }
        this.gau.kZ();
    }

    public void bqC() {
        this.eUV.postDelayed(new u(this), 150L);
    }

    public void a(z zVar) {
        this.gaA = zVar;
    }

    public NavigationBar aeL() {
        return this.mNavigationBar;
    }

    public void pS(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == w.h.fourm_name_btn) {
            pS(0);
            this.eXR.setVisibility(0);
            this.eXS.setVisibility(4);
            this.gaC.setTextColor(this.aln);
            this.gaD.setTextColor(this.alo);
            this.aRD = 0;
        } else if (view.getId() == w.h.reply_btn) {
            pS(1);
            this.eXR.setVisibility(4);
            this.eXS.setVisibility(0);
            this.gaC.setTextColor(this.alo);
            this.gaD.setTextColor(this.aln);
            this.aRD = 1;
        }
    }

    private void cy(int i) {
        this.aRD = i;
        if (i == 0) {
            this.eXR.setVisibility(0);
            this.eXS.setVisibility(4);
            this.gaC.setTextColor(this.aln);
            this.gaD.setTextColor(this.alo);
            return;
        }
        this.eXR.setVisibility(4);
        this.eXS.setVisibility(0);
        this.gaC.setTextColor(this.alo);
        this.gaD.setTextColor(this.aln);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oR(int i) {
        cy(i);
    }
}
