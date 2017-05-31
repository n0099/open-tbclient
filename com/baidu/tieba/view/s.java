package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
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
public abstract class s implements View.OnClickListener {
    protected NoNetworkView aZX;
    protected TbPageContext aas;
    protected PluginErrorTipView bMu;
    protected int bos;
    protected r bxW;
    protected BdPersonListView eKW;
    protected LinearLayout eKX;
    protected View eNI;
    protected View eNJ;
    protected q fQB;
    private int fQC;
    public x fQD;
    protected View fQE;
    protected View fQF;
    protected View fQG;
    protected View fQH;
    protected com.baidu.tieba.model.b fQI;
    private z fQJ;
    protected TextView fQL;
    protected TextView fQM;
    private View fQN;
    private int fQP;
    protected NavigationBar mNavigationBar;
    public View mRootView;
    private com.baidu.tbadk.i.h refreshView;
    private int akz = aq.getColor(w.e.cp_cont_b);
    private int akA = aq.getColor(w.e.cp_cont_f);
    private boolean boq = true;
    private boolean fQK = false;
    protected boolean fQO = false;
    private int aQl = 0;

    protected abstract void a(float f, boolean z);

    public s(TbPageContext tbPageContext) {
        this.aas = tbPageContext;
    }

    public void N(View view) {
        this.fQO = UtilHelper.canUseStyleImmersiveSticky();
        this.fQP = this.fQO ? com.baidu.adp.lib.util.k.dip2px(this.aas.getContext(), 20.0f) : com.baidu.adp.lib.util.k.dip2px(this.aas.getContext(), 10.0f);
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(w.h.person_center_navigation_bar);
        this.aZX = (NoNetworkView) this.mRootView.findViewById(w.h.person_center_no_network_view);
        this.bMu = (PluginErrorTipView) this.mRootView.findViewById(w.h.person_center_plugin_error_tip_view);
        this.eKW = (BdPersonListView) this.mRootView.findViewById(w.h.person_center_listview);
        this.eKX = (LinearLayout) this.mRootView.findViewById(w.h.person_center_blank_view);
        this.fQH = this.eKX.findViewById(w.h.sticky_view);
        this.fQN = this.eKX.findViewById(w.h.person_center_sticky_person_buttom_header);
        this.fQL = (TextView) this.eKX.findViewById(w.h.fourm_name_btn);
        this.fQM = (TextView) this.eKX.findViewById(w.h.reply_btn);
        this.eNI = this.eKX.findViewById(w.h.fourm_name_divider);
        this.eNJ = this.eKX.findViewById(w.h.reply_btn_divider);
        this.fQL.setOnClickListener(this);
        this.fQM.setOnClickListener(this);
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.fQB.a(this.aas.getPageActivity(), this.mNavigationBar);
        this.eKW.setOnScrollListener(new t(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aRw() {
    }

    public void onChangeSkinType(int i) {
        this.akz = aq.getColor(w.e.cp_cont_b);
        this.akA = aq.getColor(w.e.cp_cont_f);
        aq.j(this.eKX, w.g.item_person_header_attention_bg_selector);
        aq.k(this.eNI, w.e.cp_cont_b);
        aq.k(this.eNJ, w.e.cp_cont_b);
        aq.j(this.fQN, w.g.item_person_header_attention_bg_selector);
        aq.j(this.mRootView, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aq.cN(w.g.s_navbar_bg)));
        this.fQB.onChangeSkinType(i);
        this.aZX.onChangeSkinType(this.aas, i);
        this.bMu.onChangeSkinType(this.aas, i);
        this.fQD.onChangeSkinType(i);
        if (this.eKW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.eKW.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        cw(this.aQl);
    }

    public void setOnViewResponseListener(r rVar) {
        this.bxW = rVar;
        this.fQB.setOnViewResponseListener(rVar);
    }

    public void a(com.baidu.tieba.model.b bVar) {
        this.fQI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rw() {
        if (Build.VERSION.SDK_INT >= 11 && this.fQD != null) {
            int dimension = (int) this.aas.getResources().getDimension(w.f.ds98);
            int i = -this.fQD.RG().getTop();
            int height = this.fQD.RG().getHeight();
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
            if (this.eKW.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rx() {
        if (2 != TbadkCoreApplication.m9getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.boq) {
                    this.boq = true;
                }
            } else if (this.boq) {
                this.boq = false;
            }
            a(alpha, !this.boq);
            this.fQB.b(alpha, this.boq ? false : true);
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

    public void jt(boolean z) {
        if (z) {
            this.eKW.smoothScrollToPosition(0);
        }
        this.fQD.lb();
    }

    public void bms() {
        this.eKW.postDelayed(new u(this), 150L);
    }

    public void a(z zVar) {
        this.fQJ = zVar;
    }

    public NavigationBar aaU() {
        return this.mNavigationBar;
    }

    public void pz(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == w.h.fourm_name_btn) {
            pz(0);
            this.eNI.setVisibility(0);
            this.eNJ.setVisibility(4);
            this.fQL.setTextColor(this.akz);
            this.fQM.setTextColor(this.akA);
            this.aQl = 0;
        } else if (view.getId() == w.h.reply_btn) {
            pz(1);
            this.eNI.setVisibility(4);
            this.eNJ.setVisibility(0);
            this.fQL.setTextColor(this.akA);
            this.fQM.setTextColor(this.akz);
            this.aQl = 1;
        }
    }

    private void cw(int i) {
        this.aQl = i;
        if (i == 0) {
            this.eNI.setVisibility(0);
            this.eNJ.setVisibility(4);
            this.fQL.setTextColor(this.akz);
            this.fQM.setTextColor(this.akA);
            return;
        }
        this.eNI.setVisibility(4);
        this.eNJ.setVisibility(0);
        this.fQL.setTextColor(this.akA);
        this.fQM.setTextColor(this.akz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oA(int i) {
        cw(i);
    }
}
