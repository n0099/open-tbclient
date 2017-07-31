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
    protected TbPageContext acp;
    protected PluginErrorTipView bYp;
    protected NoNetworkView beq;
    protected int bxB;
    protected g feL;
    protected BdPersonListView fiI;
    protected LinearLayout fiJ;
    protected View flO;
    protected View flP;
    protected View gdi;
    protected f gvW;
    private int gvX;
    public j gvY;
    protected View gvZ;
    protected com.baidu.tieba.personPolymeric.d.k gwa;
    protected View gwb;
    protected View gwc;
    protected com.baidu.tieba.model.a gwd;
    private k gwe;
    protected TextView gwg;
    protected TextView gwh;
    private View gwi;
    private int gwk;
    protected NavigationBar mNavigationBar;
    public View mRootView;
    protected BaseWebView mWebView;
    private int ank = ai.getColor(d.e.cp_cont_b);
    private int anl = ai.getColor(d.e.cp_cont_f);
    private boolean bxz = true;
    private boolean gwf = false;
    protected boolean gwj = false;
    private int aTY = 0;

    protected abstract void a(float f, boolean z);

    public h(TbPageContext tbPageContext) {
        this.acp = tbPageContext;
    }

    public void O(View view) {
        this.gwj = UtilHelper.canUseStyleImmersiveSticky();
        this.gwk = com.baidu.adp.lib.util.k.dip2px(this.acp.getContext(), this.gwj ? 20.0f : 10.0f);
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
        this.beq = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
        this.bYp = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
        this.fiI = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
        this.fiJ = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
        this.gwc = this.fiJ.findViewById(d.h.sticky_view);
        this.gwi = this.fiJ.findViewById(d.h.person_center_sticky_person_buttom_header);
        this.gwg = (TextView) this.fiJ.findViewById(d.h.fourm_name_btn);
        this.gwh = (TextView) this.fiJ.findViewById(d.h.reply_btn);
        this.flO = this.fiJ.findViewById(d.h.fourm_name_divider);
        this.flP = this.fiJ.findViewById(d.h.reply_btn_divider);
        this.gwg.setOnClickListener(this);
        this.gwh.setOnClickListener(this);
        this.mWebView = (BaseWebView) this.mRootView.findViewById(d.h.webview);
    }

    public void initUI() {
        this.mNavigationBar.showBottomLine(false);
        this.gvW.a(this.acp.getPageActivity(), this.mNavigationBar);
        this.fiI.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.view.h.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (h.this.gwe != null) {
                    h.this.gwe.onScrollStateChanged(absListView, i);
                }
                if (i == 0) {
                    if (h.this.gvX > 2 && h.this.fiJ.getVisibility() != 0) {
                        h.this.ajw();
                    }
                    if (h.this.gdi != null && h.this.gvX <= 2 && h.this.fiJ.getVisibility() == 0 && h.this.gdi.getTop() > h.this.gwk) {
                        h.this.aYK();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                h.this.Ua();
                h.this.Ub();
                if (h.this.gwe != null) {
                    h.this.gwe.onScroll(absListView, i, i2, i3);
                }
                if (i == 0 && h.this.mNavigationBar.getY() != 0.0f) {
                    h.this.mNavigationBar.setY(0.0f);
                }
                if (h.this.gdi != null && !h.this.gwf && h.this.gvX <= i) {
                    if (h.this.gdi.getTop() <= h.this.mNavigationBar.getHeight() && h.this.gdi.getTop() > 0) {
                        h.this.mNavigationBar.setY(h.this.gdi.getTop() - h.this.mNavigationBar.getHeight());
                    }
                    if (h.this.gdi.getTop() < h.this.gwk) {
                        h.this.ajw();
                        h.this.gwf = true;
                    }
                }
                if (h.this.gdi != null && h.this.gwf && h.this.gvX >= i && (h.this.gdi.getTop() > h.this.gwk || h.this.gdi.getWidth() == 0)) {
                    h.this.aYK();
                    h.this.gwf = false;
                }
                h.this.gvX = i;
            }
        });
    }

    protected void ajw() {
    }

    protected void aYK() {
    }

    public void onChangeSkinType(int i) {
        this.ank = ai.getColor(d.e.cp_cont_b);
        this.anl = ai.getColor(d.e.cp_cont_f);
        ai.j(this.fiJ, d.g.item_person_header_attention_bg_selector);
        ai.k(this.flO, d.e.cp_cont_b);
        ai.k(this.flP, d.e.cp_cont_b);
        ai.j(this.gwi, d.g.item_person_header_attention_bg_selector);
        ai.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cT(d.g.s_navbar_bg)));
        if (this.gvW != null) {
            this.gvW.onChangeSkinType(i);
        }
        this.beq.onChangeSkinType(this.acp, i);
        this.bYp.onChangeSkinType(this.acp, i);
        if (this.gvY != null) {
            this.gvY.onChangeSkinType(i);
        }
        if (this.fiI != null && (this.fiI.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.fiI.getAdapter()).notifyDataSetChanged();
        }
        cC(this.aTY);
    }

    public void setOnViewResponseListener(g gVar) {
        this.feL = gVar;
        this.gvW.setOnViewResponseListener(gVar);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gwd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ua() {
        if (Build.VERSION.SDK_INT >= 11 && this.gvY != null) {
            int dimension = (int) this.acp.getResources().getDimension(d.f.ds98);
            int i = -this.gvY.Uk().getTop();
            int height = this.gvY.Uk().getHeight();
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
            if (this.fiI.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ub() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bxz) {
                    this.bxz = true;
                }
            } else if (this.bxz) {
                this.bxz = false;
            }
            a(alpha, !this.bxz);
            this.gvW.b(alpha, this.bxz ? false : true);
        }
    }

    public void cH(List<com.baidu.adp.widget.ListView.f> list) {
        if (u.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fiI.getVisibility() != 0) {
            this.fiI.setVisibility(0);
        }
        this.fiI.setData(list);
    }

    public void km(boolean z) {
        if (z) {
            this.fiI.smoothScrollToPosition(0);
        }
        this.gvY.lh();
    }

    public void bwF() {
        this.fiI.postDelayed(new Runnable() { // from class: com.baidu.tieba.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.fiI.smoothScrollToPosition(4);
            }
        }, 150L);
    }

    public void a(k kVar) {
        this.gwe = kVar;
    }

    public NavigationBar afq() {
        return this.mNavigationBar;
    }

    public void qh(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            qh(0);
            this.flO.setVisibility(0);
            this.flP.setVisibility(4);
            this.gwg.setTextColor(this.ank);
            this.gwh.setTextColor(this.anl);
            this.aTY = 0;
        } else if (view.getId() == d.h.reply_btn) {
            qh(1);
            this.flO.setVisibility(4);
            this.flP.setVisibility(0);
            this.gwg.setTextColor(this.anl);
            this.gwh.setTextColor(this.ank);
            this.aTY = 1;
        }
    }

    private void cC(int i) {
        this.aTY = i;
        if (i == 0) {
            this.flO.setVisibility(0);
            this.flP.setVisibility(4);
            this.gwg.setTextColor(this.ank);
            this.gwh.setTextColor(this.anl);
            return;
        }
        this.flO.setVisibility(4);
        this.flP.setVisibility(0);
        this.gwg.setTextColor(this.anl);
        this.gwh.setTextColor(this.ank);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pa(int i) {
        cC(i);
    }
}
