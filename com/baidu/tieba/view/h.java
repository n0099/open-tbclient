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
    protected TbPageContext aaS;
    protected PluginErrorTipView bXj;
    protected NoNetworkView bdg;
    protected int bwr;
    protected g fdz;
    protected BdPersonListView fhu;
    protected LinearLayout fhv;
    protected View fkC;
    protected View fkD;
    protected View gbW;
    protected f guL;
    private int guM;
    public j guN;
    protected View guO;
    protected com.baidu.tieba.personPolymeric.d.k guP;
    protected View guQ;
    protected View guR;
    protected com.baidu.tieba.model.a guS;
    private k guT;
    protected TextView guV;
    protected TextView guW;
    private View guX;
    private int guZ;
    protected NavigationBar mNavigationBar;
    public View mRootView;
    protected BaseWebView mWebView;
    private int alR = ai.getColor(d.e.cp_cont_b);
    private int alS = ai.getColor(d.e.cp_cont_f);
    private boolean bwp = true;
    private boolean guU = false;
    protected boolean guY = false;
    private int aSM = 0;

    protected abstract void a(float f, boolean z);

    public h(TbPageContext tbPageContext) {
        this.aaS = tbPageContext;
    }

    public void O(View view) {
        this.guY = UtilHelper.canUseStyleImmersiveSticky();
        this.guZ = com.baidu.adp.lib.util.k.dip2px(this.aaS.getContext(), this.guY ? 20.0f : 10.0f);
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
        this.bdg = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
        this.bXj = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
        this.fhu = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
        this.fhv = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
        this.guR = this.fhv.findViewById(d.h.sticky_view);
        this.guX = this.fhv.findViewById(d.h.person_center_sticky_person_buttom_header);
        this.guV = (TextView) this.fhv.findViewById(d.h.fourm_name_btn);
        this.guW = (TextView) this.fhv.findViewById(d.h.reply_btn);
        this.fkC = this.fhv.findViewById(d.h.fourm_name_divider);
        this.fkD = this.fhv.findViewById(d.h.reply_btn_divider);
        this.guV.setOnClickListener(this);
        this.guW.setOnClickListener(this);
        this.mWebView = (BaseWebView) this.mRootView.findViewById(d.h.webview);
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.guL.a(this.aaS.getPageActivity(), this.mNavigationBar);
        this.fhu.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.view.h.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (h.this.guT != null) {
                    h.this.guT.onScrollStateChanged(absListView, i);
                }
                if (i == 0) {
                    if (h.this.guM > 2 && h.this.fhv.getVisibility() != 0) {
                        h.this.ajj();
                    }
                    if (h.this.gbW != null && h.this.guM <= 2 && h.this.fhv.getVisibility() == 0 && h.this.gbW.getTop() > h.this.guZ) {
                        h.this.aYz();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                h.this.TV();
                h.this.TW();
                if (h.this.guT != null) {
                    h.this.guT.onScroll(absListView, i, i2, i3);
                }
                if (i == 0 && h.this.mNavigationBar.getY() != 0.0f) {
                    h.this.mNavigationBar.setY(0.0f);
                }
                if (h.this.gbW != null && !h.this.guU && h.this.guM <= i) {
                    if (h.this.gbW.getTop() <= h.this.mNavigationBar.getHeight() && h.this.gbW.getTop() > 0) {
                        h.this.mNavigationBar.setY(h.this.gbW.getTop() - h.this.mNavigationBar.getHeight());
                    }
                    if (h.this.gbW.getTop() < h.this.guZ) {
                        h.this.ajj();
                        h.this.guU = true;
                    }
                }
                if (h.this.gbW != null && h.this.guU && h.this.guM >= i && (h.this.gbW.getTop() > h.this.guZ || h.this.gbW.getWidth() == 0)) {
                    h.this.aYz();
                    h.this.guU = false;
                }
                h.this.guM = i;
            }
        });
    }

    protected void ajj() {
    }

    protected void aYz() {
    }

    public void onChangeSkinType(int i) {
        this.alR = ai.getColor(d.e.cp_cont_b);
        this.alS = ai.getColor(d.e.cp_cont_f);
        ai.j(this.fhv, d.g.item_person_header_attention_bg_selector);
        ai.k(this.fkC, d.e.cp_cont_b);
        ai.k(this.fkD, d.e.cp_cont_b);
        ai.j(this.guX, d.g.item_person_header_attention_bg_selector);
        ai.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cR(d.g.s_navbar_bg)));
        if (this.guL != null) {
            this.guL.onChangeSkinType(i);
        }
        this.bdg.onChangeSkinType(this.aaS, i);
        this.bXj.onChangeSkinType(this.aaS, i);
        if (this.guN != null) {
            this.guN.onChangeSkinType(i);
        }
        if (this.fhu != null && (this.fhu.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.fhu.getAdapter()).notifyDataSetChanged();
        }
        cA(this.aSM);
    }

    public void setOnViewResponseListener(g gVar) {
        this.fdz = gVar;
        this.guL.setOnViewResponseListener(gVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.guS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TV() {
        if (Build.VERSION.SDK_INT >= 11 && this.guN != null) {
            int dimension = (int) this.aaS.getResources().getDimension(d.f.ds98);
            int i = -this.guN.Uf().getTop();
            int height = this.guN.Uf().getHeight();
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
            if (this.fhu.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TW() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bwp) {
                    this.bwp = true;
                }
            } else if (this.bwp) {
                this.bwp = false;
            }
            a(alpha, !this.bwp);
            this.guL.b(alpha, this.bwp ? false : true);
        }
    }

    public void cH(List<com.baidu.adp.widget.ListView.f> list) {
        if (u.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fhu.getVisibility() != 0) {
            this.fhu.setVisibility(0);
        }
        this.fhu.setData(list);
    }

    public void km(boolean z) {
        if (z) {
            this.fhu.smoothScrollToPosition(0);
        }
        this.guN.kX();
    }

    public void bwy() {
        this.fhu.postDelayed(new Runnable() { // from class: com.baidu.tieba.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.fhu.smoothScrollToPosition(4);
            }
        }, 150L);
    }

    public void a(k kVar) {
        this.guT = kVar;
    }

    public NavigationBar afl() {
        return this.mNavigationBar;
    }

    public void qi(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            qi(0);
            this.fkC.setVisibility(0);
            this.fkD.setVisibility(4);
            this.guV.setTextColor(this.alR);
            this.guW.setTextColor(this.alS);
            this.aSM = 0;
        } else if (view.getId() == d.h.reply_btn) {
            qi(1);
            this.fkC.setVisibility(4);
            this.fkD.setVisibility(0);
            this.guV.setTextColor(this.alS);
            this.guW.setTextColor(this.alR);
            this.aSM = 1;
        }
    }

    private void cA(int i) {
        this.aSM = i;
        if (i == 0) {
            this.fkC.setVisibility(0);
            this.fkD.setVisibility(4);
            this.guV.setTextColor(this.alR);
            this.guW.setTextColor(this.alS);
            return;
        }
        this.fkC.setVisibility(4);
        this.fkD.setVisibility(0);
        this.guV.setTextColor(this.alS);
        this.guW.setTextColor(this.alR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pb(int i) {
        cA(i);
    }
}
