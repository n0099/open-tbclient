package com.baidu.tieba.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class h implements View.OnClickListener {
    protected TbPageContext acr;
    protected PluginErrorTipView bZb;
    protected NoNetworkView ber;
    protected int byk;
    protected g fgE;
    protected BdPersonListView fkB;
    protected LinearLayout fkC;
    protected View fnH;
    protected View fnI;
    protected View gfa;
    protected f gxO;
    private int gxP;
    public j gxQ;
    protected View gxR;
    protected com.baidu.tieba.personPolymeric.d.k gxS;
    protected View gxT;
    protected View gxU;
    protected com.baidu.tieba.model.a gxV;
    private k gxW;
    protected TextView gxY;
    protected TextView gxZ;
    private View gya;
    private int gyc;
    protected NavigationBar mNavigationBar;
    public View mRootView;
    protected BaseWebView mWebView;
    private int anl = ai.getColor(d.e.cp_cont_b);
    private int anm = ai.getColor(d.e.cp_cont_f);
    private boolean byi = true;
    private boolean gxX = false;
    protected boolean gyb = false;
    private int aTZ = 0;

    protected abstract void a(float f, boolean z);

    public h(TbPageContext tbPageContext) {
        this.acr = tbPageContext;
    }

    public void P(View view) {
        this.gyb = UtilHelper.canUseStyleImmersiveSticky();
        this.gyc = com.baidu.adp.lib.util.k.dip2px(this.acr.getContext(), this.gyb ? 20.0f : 10.0f);
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
        this.ber = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
        this.bZb = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
        this.fkB = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
        this.fkC = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
        this.gxU = this.fkC.findViewById(d.h.sticky_view);
        this.gya = this.fkC.findViewById(d.h.person_center_sticky_person_buttom_header);
        this.gxY = (TextView) this.fkC.findViewById(d.h.fourm_name_btn);
        this.gxZ = (TextView) this.fkC.findViewById(d.h.reply_btn);
        this.fnH = this.fkC.findViewById(d.h.fourm_name_divider);
        this.fnI = this.fkC.findViewById(d.h.reply_btn_divider);
        this.gxY.setOnClickListener(this);
        this.gxZ.setOnClickListener(this);
        this.mWebView = (BaseWebView) this.mRootView.findViewById(d.h.webview);
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.gxO.a(this.acr.getPageActivity(), this.mNavigationBar);
        this.fkB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.view.h.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (h.this.gxW != null) {
                    h.this.gxW.onScrollStateChanged(absListView, i);
                }
                if (i == 0) {
                    if (h.this.gxP > 2 && h.this.fkC.getVisibility() != 0) {
                        h.this.akc();
                    }
                    if (h.this.gfa != null && h.this.gxP <= 2 && h.this.fkC.getVisibility() == 0 && h.this.gfa.getTop() > h.this.gyc) {
                        h.this.aZr();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                h.this.Uw();
                h.this.Ux();
                if (h.this.gxW != null) {
                    h.this.gxW.onScroll(absListView, i, i2, i3);
                }
                if (i == 0 && h.this.mNavigationBar.getY() != 0.0f) {
                    h.this.mNavigationBar.setY(0.0f);
                }
                if (h.this.gfa != null && !h.this.gxX && h.this.gxP <= i) {
                    if (h.this.gfa.getTop() <= h.this.mNavigationBar.getHeight() && h.this.gfa.getTop() > 0) {
                        h.this.mNavigationBar.setY(h.this.gfa.getTop() - h.this.mNavigationBar.getHeight());
                    }
                    if (h.this.gfa.getTop() < h.this.gyc) {
                        h.this.akc();
                        h.this.gxX = true;
                    }
                }
                if (h.this.gfa != null && h.this.gxX && h.this.gxP >= i && (h.this.gfa.getTop() > h.this.gyc || h.this.gfa.getWidth() == 0)) {
                    h.this.aZr();
                    h.this.gxX = false;
                }
                h.this.gxP = i;
            }
        });
    }

    protected void akc() {
    }

    protected void aZr() {
    }

    public void onChangeSkinType(int i) {
        this.anl = ai.getColor(d.e.cp_cont_b);
        this.anm = ai.getColor(d.e.cp_cont_f);
        ai.j(this.fkC, d.g.item_person_header_attention_bg_selector);
        ai.k(this.fnH, d.e.cp_cont_b);
        ai.k(this.fnI, d.e.cp_cont_b);
        ai.j(this.gya, d.g.item_person_header_attention_bg_selector);
        ai.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cT(d.g.s_navbar_bg)));
        if (this.gxO != null) {
            this.gxO.onChangeSkinType(i);
        }
        this.ber.onChangeSkinType(this.acr, i);
        this.bZb.onChangeSkinType(this.acr, i);
        if (this.gxQ != null) {
            this.gxQ.onChangeSkinType(i);
        }
        if (this.fkB != null && (this.fkB.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.fkB.getAdapter()).notifyDataSetChanged();
        }
        cC(this.aTZ);
    }

    public void setOnViewResponseListener(g gVar) {
        this.fgE = gVar;
        this.gxO.setOnViewResponseListener(gVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gxV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uw() {
        if (Build.VERSION.SDK_INT >= 11 && this.gxQ != null) {
            int dimension = (int) this.acr.getResources().getDimension(d.f.ds98);
            int i = -this.gxQ.UG().getTop();
            int height = this.gxQ.UG().getHeight();
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
            if (this.fkB.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ux() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.byi) {
                    this.byi = true;
                }
            } else if (this.byi) {
                this.byi = false;
            }
            a(alpha, !this.byi);
            this.gxO.b(alpha, this.byi ? false : true);
        }
    }

    public void cK(List<com.baidu.adp.widget.ListView.f> list) {
        if (u.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fkB.getVisibility() != 0) {
            this.fkB.setVisibility(0);
        }
        this.fkB.setData(list);
    }

    public void kp(boolean z) {
        if (z) {
            this.fkB.smoothScrollToPosition(0);
        }
        this.gxQ.lh();
    }

    public void bxn() {
        this.fkB.postDelayed(new Runnable() { // from class: com.baidu.tieba.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.fkB.smoothScrollToPosition(4);
            }
        }, 150L);
    }

    public void a(k kVar) {
        this.gxW = kVar;
    }

    public NavigationBar afM() {
        return this.mNavigationBar;
    }

    public void qr(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            qr(0);
            this.fnH.setVisibility(0);
            this.fnI.setVisibility(4);
            this.gxY.setTextColor(this.anl);
            this.gxZ.setTextColor(this.anm);
            this.aTZ = 0;
        } else if (view.getId() == d.h.reply_btn) {
            qr(1);
            this.fnH.setVisibility(4);
            this.fnI.setVisibility(0);
            this.gxY.setTextColor(this.anm);
            this.gxZ.setTextColor(this.anl);
            this.aTZ = 1;
        }
    }

    private void cC(int i) {
        this.aTZ = i;
        if (i == 0) {
            this.fnH.setVisibility(0);
            this.fnI.setVisibility(4);
            this.gxY.setTextColor(this.anl);
            this.gxZ.setTextColor(this.anm);
            return;
        }
        this.fnH.setVisibility(4);
        this.fnI.setVisibility(0);
        this.gxY.setTextColor(this.anm);
        this.gxZ.setTextColor(this.anl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pk(int i) {
        cC(i);
    }
}
