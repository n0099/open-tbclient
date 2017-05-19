package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class q implements View.OnClickListener {
    protected NoNetworkView aSi;
    private com.baidu.tbadk.i.f aSk;
    protected TbPageContext aat;
    protected PluginErrorTipView bGG;
    protected int bnl;
    protected View eET;
    protected View eEU;
    protected p eyy;
    protected z fII;
    private int fIJ;
    public w fIK;
    protected BdPersonListView fIL;
    protected View fIM;
    protected View fIN;
    protected View fIO;
    protected LinearLayout fIP;
    protected View fIQ;
    protected com.baidu.tieba.model.a fIR;
    private y fIS;
    protected TextView fIU;
    protected TextView fIV;
    private View fIW;
    private int fIY;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.y mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.i.h refreshView;
    private int akJ = aq.getColor(w.e.cp_cont_b);
    private int akK = aq.getColor(w.e.cp_cont_f);
    private boolean bnj = true;
    private boolean fIT = false;
    protected boolean fIX = false;
    private int aQk = 0;

    protected abstract void a(float f, boolean z);

    public q(TbPageContext tbPageContext) {
        this.aat = tbPageContext;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fIX = UtilHelper.canUseStyleImmersiveSticky();
        this.fIY = this.fIX ? com.baidu.adp.lib.util.k.dip2px(this.aat.getContext(), 20.0f) : com.baidu.adp.lib.util.k.dip2px(this.aat.getContext(), 10.0f);
        this.mRootView = layoutInflater.inflate(w.j.fragment_person_center_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(w.h.person_center_navigation_bar);
        this.aSi = (NoNetworkView) this.mRootView.findViewById(w.h.person_center_no_network_view);
        this.bGG = (PluginErrorTipView) this.mRootView.findViewById(w.h.person_center_plugin_error_tip_view);
        this.fIL = (BdPersonListView) this.mRootView.findViewById(w.h.person_center_listview);
        this.fIP = (LinearLayout) this.mRootView.findViewById(w.h.person_center_blank_view);
        this.fIQ = this.fIP.findViewById(w.h.sticky_view);
        this.fIW = this.fIP.findViewById(w.h.person_center_sticky_person_buttom_header);
        this.fIU = (TextView) this.fIP.findViewById(w.h.fourm_name_btn);
        this.fIV = (TextView) this.fIP.findViewById(w.h.reply_btn);
        this.eET = this.fIP.findViewById(w.h.fourm_name_divider);
        this.eEU = this.fIP.findViewById(w.h.reply_btn_divider);
        this.fIU.setOnClickListener(this);
        this.fIV.setOnClickListener(this);
        return this.mRootView;
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fII.a(this.aat.getPageActivity(), this.mNavigationBar);
        this.fIL.setOnScrollListener(new r(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQf() {
    }

    public void onChangeSkinType(int i) {
        this.akJ = aq.getColor(w.e.cp_cont_b);
        this.akK = aq.getColor(w.e.cp_cont_f);
        aq.j(this.fIP, w.g.item_person_header_attention_bg_selector);
        aq.k(this.eET, w.e.cp_cont_b);
        aq.k(this.eEU, w.e.cp_cont_b);
        aq.j(this.fIW, w.g.item_person_header_attention_bg_selector);
        aq.j(this.mRootView, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aq.cM(w.g.s_navbar_bg)));
        this.fII.onChangeSkinType(i);
        this.aSi.onChangeSkinType(this.aat, i);
        this.bGG.onChangeSkinType(this.aat, i);
        this.fIK.onChangeSkinType(i);
        if (this.fIL.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.fIL.getAdapter()).notifyDataSetChanged();
        }
        if (this.aSk != null) {
            this.aSk.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        cv(this.aQk);
    }

    public void setOnViewResponseListener(p pVar) {
        this.eyy = pVar;
        this.fII.setOnViewResponseListener(pVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fIR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rk() {
        if (Build.VERSION.SDK_INT >= 11 && this.fIK != null) {
            int dimension = (int) this.aat.getResources().getDimension(w.f.ds98);
            int i = -this.fIK.Ru().getTop();
            int height = this.fIK.Ru().getHeight();
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
            if (this.fIL.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rl() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bnj) {
                    this.bnj = true;
                }
            } else if (this.bnj) {
                this.bnj = false;
            }
            a(alpha, !this.bnj);
            this.fII.c(alpha, this.bnj ? false : true);
        }
    }

    public void cK(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.r(list)) {
            list = new ArrayList<>();
        }
        if (this.fIL.getVisibility() != 0) {
            this.fIL.setVisibility(0);
        }
        this.fIL.setData(list);
    }

    public void lu(boolean z) {
        if (z) {
            this.fIL.smoothScrollToPosition(0);
        }
        ((com.baidu.tieba.personPolymeric.d.w) this.fIK).lb();
    }

    public void bkV() {
        this.fIL.postDelayed(new s(this), 150L);
    }

    public void H(String str, boolean z) {
        if (!ahu()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.i.h(this.aat.getPageActivity(), new t(this));
            }
            this.refreshView.eR(this.aat.getResources().getDimensionPixelSize(w.f.ds280));
            this.refreshView.fQ(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.Ee();
            this.fIL.setVisibility(8);
        }
    }

    public void JR() {
        if (this.refreshView != null) {
            this.refreshView.H(this.mRootView);
            this.refreshView = null;
        }
    }

    public boolean ahu() {
        if (this.refreshView != null) {
            return this.refreshView.DX();
        }
        return false;
    }

    public void a(y yVar) {
        this.fIS = yVar;
    }

    public View bkW() {
        return this.mNavigationBar;
    }

    public void pa(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == w.h.fourm_name_btn) {
            pa(0);
            this.eET.setVisibility(0);
            this.eEU.setVisibility(4);
            this.fIU.setTextColor(this.akJ);
            this.fIV.setTextColor(this.akK);
            this.aQk = 0;
        } else if (view.getId() == w.h.reply_btn) {
            pa(1);
            this.eET.setVisibility(4);
            this.eEU.setVisibility(0);
            this.fIU.setTextColor(this.akK);
            this.fIV.setTextColor(this.akJ);
            this.aQk = 1;
        }
    }

    private void cv(int i) {
        this.aQk = i;
        if (i == 0) {
            this.eET.setVisibility(0);
            this.eEU.setVisibility(4);
            this.fIU.setTextColor(this.akJ);
            this.fIV.setTextColor(this.akK);
            return;
        }
        this.eET.setVisibility(4);
        this.eEU.setVisibility(0);
        this.fIU.setTextColor(this.akK);
        this.fIV.setTextColor(this.akJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oh(int i) {
        cv(i);
    }
}
