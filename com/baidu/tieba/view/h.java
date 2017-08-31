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
    protected QuickWebView bYK;
    protected NoNetworkView bep;
    protected int bzd;
    protected PluginErrorTipView cbZ;
    protected g feW;
    protected BdPersonListView fiW;
    protected LinearLayout fiX;
    protected View fme;
    protected View fmf;
    protected View gdD;
    private View gwA;
    private int gwC;
    protected f gwo;
    private int gwp;
    public j gwq;
    protected View gwr;
    protected com.baidu.tieba.personPolymeric.d.k gws;
    protected View gwt;
    protected View gwu;
    protected com.baidu.tieba.model.a gwv;
    private k gww;
    protected TextView gwy;
    protected TextView gwz;
    protected NavigationBar mNavigationBar;
    public View mRootView;
    private int amF = aj.getColor(d.e.cp_cont_b);
    private int amG = aj.getColor(d.e.cp_cont_f);
    private boolean bzb = true;
    private boolean gwx = false;
    protected boolean gwB = false;
    private int aTK = 0;

    protected abstract void a(float f, boolean z);

    public h(TbPageContext tbPageContext) {
        this.aby = tbPageContext;
    }

    public void X(View view) {
        this.gwB = UtilHelper.canUseStyleImmersiveSticky();
        this.gwC = com.baidu.adp.lib.util.k.dip2px(this.aby.getContext(), this.gwB ? 20.0f : 10.0f);
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
        this.bep = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
        this.cbZ = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
        this.fiW = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
        this.fiX = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
        this.gwu = this.fiX.findViewById(d.h.sticky_view);
        this.gwA = this.fiX.findViewById(d.h.person_center_sticky_person_buttom_header);
        this.gwy = (TextView) this.fiX.findViewById(d.h.fourm_name_btn);
        this.gwz = (TextView) this.fiX.findViewById(d.h.reply_btn);
        this.fme = this.fiX.findViewById(d.h.fourm_name_divider);
        this.fmf = this.fiX.findViewById(d.h.reply_btn_divider);
        this.gwy.setOnClickListener(this);
        this.gwz.setOnClickListener(this);
        this.bYK = (QuickWebView) this.mRootView.findViewById(d.h.webview);
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.gwo.a(this.aby.getPageActivity(), this.mNavigationBar);
        this.fiW.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.view.h.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (h.this.gww != null) {
                    h.this.gww.onScrollStateChanged(absListView, i);
                }
                if (i == 0) {
                    if (h.this.gwp > 2 && h.this.fiX.getVisibility() != 0) {
                        h.this.alE();
                    }
                    if (h.this.gdD != null && h.this.gwp <= 2 && h.this.fiX.getVisibility() == 0 && h.this.gdD.getTop() > h.this.gwC) {
                        h.this.aYy();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                h.this.Vg();
                h.this.Vh();
                if (h.this.gww != null) {
                    h.this.gww.onScroll(absListView, i, i2, i3);
                }
                if (i == 0 && h.this.mNavigationBar.getY() != 0.0f) {
                    h.this.mNavigationBar.setY(0.0f);
                }
                if (h.this.gdD != null && !h.this.gwx && h.this.gwp <= i) {
                    if (h.this.gdD.getTop() <= h.this.mNavigationBar.getHeight() && h.this.gdD.getTop() > 0) {
                        h.this.mNavigationBar.setY(h.this.gdD.getTop() - h.this.mNavigationBar.getHeight());
                    }
                    if (h.this.gdD.getTop() < h.this.gwC) {
                        h.this.alE();
                        h.this.gwx = true;
                    }
                }
                if (h.this.gdD != null && h.this.gwx && h.this.gwp >= i && (h.this.gdD.getTop() > h.this.gwC || h.this.gdD.getWidth() == 0)) {
                    h.this.aYy();
                    h.this.gwx = false;
                }
                h.this.gwp = i;
            }
        });
    }

    protected void alE() {
    }

    protected void aYy() {
    }

    public void onChangeSkinType(int i) {
        this.amF = aj.getColor(d.e.cp_cont_b);
        this.amG = aj.getColor(d.e.cp_cont_f);
        aj.j(this.fiX, d.g.item_person_header_attention_bg_selector);
        aj.k(this.fme, d.e.cp_cont_b);
        aj.k(this.fmf, d.e.cp_cont_b);
        aj.j(this.gwA, d.g.item_person_header_attention_bg_selector);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cU(d.g.s_navbar_bg)));
        if (this.gwo != null) {
            this.gwo.onChangeSkinType(i);
        }
        this.bep.onChangeSkinType(this.aby, i);
        this.cbZ.onChangeSkinType(this.aby, i);
        if (this.gwq != null) {
            this.gwq.onChangeSkinType(i);
        }
        if (this.fiW != null && (this.fiW.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.fiW.getAdapter()).notifyDataSetChanged();
        }
        cC(this.aTK);
    }

    public void setOnViewResponseListener(g gVar) {
        this.feW = gVar;
        this.gwo.setOnViewResponseListener(gVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gwv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vg() {
        if (Build.VERSION.SDK_INT >= 11 && this.gwq != null) {
            int dimension = (int) this.aby.getResources().getDimension(d.f.ds98);
            int i = -this.gwq.Vq().getTop();
            int height = this.gwq.Vq().getHeight();
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
            if (this.fiW.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bzb) {
                    this.bzb = true;
                }
            } else if (this.bzb) {
                this.bzb = false;
            }
            a(alpha, !this.bzb);
            this.gwo.b(alpha, this.bzb ? false : true);
        }
    }

    public void cH(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fiW.getVisibility() != 0) {
            this.fiW.setVisibility(0);
        }
        this.fiW.setData(list);
    }

    public void kq(boolean z) {
        if (z) {
            this.fiW.smoothScrollToPosition(0);
        }
        this.gwq.kY();
    }

    public void bww() {
        this.fiW.postDelayed(new Runnable() { // from class: com.baidu.tieba.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.fiW.smoothScrollToPosition(4);
            }
        }, 150L);
    }

    public void a(k kVar) {
        this.gww = kVar;
    }

    public NavigationBar ahe() {
        return this.mNavigationBar;
    }

    public void qr(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            qr(0);
            this.fme.setVisibility(0);
            this.fmf.setVisibility(4);
            this.gwy.setTextColor(this.amF);
            this.gwz.setTextColor(this.amG);
            this.aTK = 0;
        } else if (view.getId() == d.h.reply_btn) {
            qr(1);
            this.fme.setVisibility(4);
            this.fmf.setVisibility(0);
            this.gwy.setTextColor(this.amG);
            this.gwz.setTextColor(this.amF);
            this.aTK = 1;
        }
    }

    private void cC(int i) {
        this.aTK = i;
        if (i == 0) {
            this.fme.setVisibility(0);
            this.fmf.setVisibility(4);
            this.gwy.setTextColor(this.amF);
            this.gwz.setTextColor(this.amG);
            return;
        }
        this.fme.setVisibility(4);
        this.fmf.setVisibility(0);
        this.gwy.setTextColor(this.amG);
        this.gwz.setTextColor(this.amF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pr(int i) {
        cC(i);
    }

    public void onDestory() {
        if (this.bYK != null) {
            this.bYK.destroy();
        }
    }
}
