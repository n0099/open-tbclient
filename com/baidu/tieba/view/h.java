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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class h implements View.OnClickListener {
    protected TbPageContext aby;
    protected QuickWebView bZC;
    protected NoNetworkView bem;
    protected int bzU;
    protected PluginErrorTipView ccR;
    protected g ffP;
    protected BdPersonListView fjP;
    protected LinearLayout fjQ;
    protected View fmX;
    protected View fmY;
    protected View gex;
    protected f gxi;
    private int gxj;
    public j gxk;
    protected View gxl;
    protected com.baidu.tieba.personPolymeric.d.k gxm;
    protected View gxn;
    protected View gxo;
    protected com.baidu.tieba.model.a gxp;
    private k gxq;
    protected TextView gxs;
    protected TextView gxt;
    private View gxu;
    private int gxw;
    protected NavigationBar mNavigationBar;
    public View mRootView;
    private int amD = aj.getColor(d.e.cp_cont_b);
    private int amE = aj.getColor(d.e.cp_cont_f);
    private boolean bzS = true;
    private boolean gxr = false;
    protected boolean gxv = false;
    private int aTH = 0;

    protected abstract void a(float f, boolean z);

    public h(TbPageContext tbPageContext) {
        this.aby = tbPageContext;
    }

    public void X(View view) {
        this.gxv = UtilHelper.canUseStyleImmersiveSticky();
        this.gxw = com.baidu.adp.lib.util.k.dip2px(this.aby.getContext(), this.gxv ? 20.0f : 10.0f);
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
        this.bem = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
        this.ccR = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
        this.fjP = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
        this.fjQ = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
        this.gxo = this.fjQ.findViewById(d.h.sticky_view);
        this.gxu = this.fjQ.findViewById(d.h.person_center_sticky_person_buttom_header);
        this.gxs = (TextView) this.fjQ.findViewById(d.h.fourm_name_btn);
        this.gxt = (TextView) this.fjQ.findViewById(d.h.reply_btn);
        this.fmX = this.fjQ.findViewById(d.h.fourm_name_divider);
        this.fmY = this.fjQ.findViewById(d.h.reply_btn_divider);
        this.gxs.setOnClickListener(this);
        this.gxt.setOnClickListener(this);
        this.bZC = (QuickWebView) this.mRootView.findViewById(d.h.webview);
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.gxi.a(this.aby.getPageActivity(), this.mNavigationBar);
        this.fjP.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.view.h.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (h.this.gxq != null) {
                    h.this.gxq.onScrollStateChanged(absListView, i);
                }
                if (i == 0) {
                    if (h.this.gxj > 2 && h.this.fjQ.getVisibility() != 0) {
                        h.this.alP();
                    }
                    if (h.this.gex != null && h.this.gxj <= 2 && h.this.fjQ.getVisibility() == 0 && h.this.gex.getTop() > h.this.gxw) {
                        h.this.aYJ();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                h.this.Vr();
                h.this.Vs();
                if (h.this.gxq != null) {
                    h.this.gxq.onScroll(absListView, i, i2, i3);
                }
                if (i == 0 && h.this.mNavigationBar.getY() != 0.0f) {
                    h.this.mNavigationBar.setY(0.0f);
                }
                if (h.this.gex != null && !h.this.gxr && h.this.gxj <= i) {
                    if (h.this.gex.getTop() <= h.this.mNavigationBar.getHeight() && h.this.gex.getTop() > 0) {
                        h.this.mNavigationBar.setY(h.this.gex.getTop() - h.this.mNavigationBar.getHeight());
                    }
                    if (h.this.gex.getTop() < h.this.gxw) {
                        h.this.alP();
                        h.this.gxr = true;
                    }
                }
                if (h.this.gex != null && h.this.gxr && h.this.gxj >= i && (h.this.gex.getTop() > h.this.gxw || h.this.gex.getWidth() == 0)) {
                    h.this.aYJ();
                    h.this.gxr = false;
                }
                h.this.gxj = i;
            }
        });
    }

    protected void alP() {
    }

    protected void aYJ() {
    }

    public void onChangeSkinType(int i) {
        this.amD = aj.getColor(d.e.cp_cont_b);
        this.amE = aj.getColor(d.e.cp_cont_f);
        aj.j(this.fjQ, d.g.item_person_header_attention_bg_selector);
        aj.k(this.fmX, d.e.cp_cont_b);
        aj.k(this.fmY, d.e.cp_cont_b);
        aj.j(this.gxu, d.g.item_person_header_attention_bg_selector);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cU(d.g.s_navbar_bg)));
        if (this.gxi != null) {
            this.gxi.onChangeSkinType(i);
        }
        this.bem.onChangeSkinType(this.aby, i);
        this.ccR.onChangeSkinType(this.aby, i);
        if (this.gxk != null) {
            this.gxk.onChangeSkinType(i);
        }
        if (this.fjP != null && (this.fjP.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.fjP.getAdapter()).notifyDataSetChanged();
        }
        cC(this.aTH);
    }

    public void setOnViewResponseListener(g gVar) {
        this.ffP = gVar;
        this.gxi.setOnViewResponseListener(gVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gxp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vr() {
        if (Build.VERSION.SDK_INT >= 11 && this.gxk != null) {
            int dimension = (int) this.aby.getResources().getDimension(d.f.ds98);
            int i = -this.gxk.VB().getTop();
            int height = this.gxk.VB().getHeight();
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
            if (this.fjP.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vs() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bzS) {
                    this.bzS = true;
                }
            } else if (this.bzS) {
                this.bzS = false;
            }
            a(alpha, !this.bzS);
            this.gxi.b(alpha, this.bzS ? false : true);
        }
    }

    public void cI(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fjP.getVisibility() != 0) {
            this.fjP.setVisibility(0);
        }
        this.fjP.setData(list);
    }

    public void kr(boolean z) {
        if (z) {
            this.fjP.smoothScrollToPosition(0);
        }
        this.gxk.kY();
    }

    public void bwH() {
        this.fjP.postDelayed(new Runnable() { // from class: com.baidu.tieba.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.fjP.smoothScrollToPosition(4);
            }
        }, 150L);
    }

    public void a(k kVar) {
        this.gxq = kVar;
    }

    public NavigationBar ahp() {
        return this.mNavigationBar;
    }

    public void qt(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            qt(0);
            this.fmX.setVisibility(0);
            this.fmY.setVisibility(4);
            this.gxs.setTextColor(this.amD);
            this.gxt.setTextColor(this.amE);
            this.aTH = 0;
        } else if (view.getId() == d.h.reply_btn) {
            qt(1);
            this.fmX.setVisibility(4);
            this.fmY.setVisibility(0);
            this.gxs.setTextColor(this.amE);
            this.gxt.setTextColor(this.amD);
            this.aTH = 1;
        }
    }

    private void cC(int i) {
        this.aTH = i;
        if (i == 0) {
            this.fmX.setVisibility(0);
            this.fmY.setVisibility(4);
            this.gxs.setTextColor(this.amD);
            this.gxt.setTextColor(this.amE);
            return;
        }
        this.fmX.setVisibility(4);
        this.fmY.setVisibility(0);
        this.gxs.setTextColor(this.amE);
        this.gxt.setTextColor(this.amD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pt(int i) {
        cC(i);
    }

    public void onDestory() {
        if (this.bZC != null) {
            this.bZC.destroy();
        }
    }
}
