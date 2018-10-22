package com.baidu.tieba.personCenter.view;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class c {
    private NoNetworkView bJX;
    private PluginErrorTipView dgD;
    private com.baidu.tieba.personCenter.b.c gke;
    private com.baidu.tieba.view.d gkf;
    private View gkg;
    private FrameLayout gkh;
    private a gki;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes5.dex */
    public interface a {
        void bG(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bJX = (NoNetworkView) view.findViewById(e.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(e.g.person_center_navigation_bar);
            this.dgD = (PluginErrorTipView) view.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gkh = (FrameLayout) view.findViewById(e.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(e.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(e.C0175e.ds200));
            this.gkg = new View(tbPageContext.getPageActivity());
            this.gkg.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.gkg);
            this.gke = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.gkf = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.gke.b(eVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || eVar.getUserData() == null || eVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gke.notifyDataSetChanged();
    }

    public void D(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(e.j.mine));
        this.gkf.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(e.C0175e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(e.C0175e.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.gkf.box();
        this.gkf.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aIL() {
        if (this.refreshView != null) {
            return this.refreshView.Mq();
        }
        return false;
    }

    public void a(a aVar) {
        this.gki = aVar;
    }

    public void ZH() {
        if (!aIL()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM()) {
                            c.this.ZI();
                            if (c.this.gki != null) {
                                c.this.gki.bG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fB(this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.hU(this.mPageContext.getString(e.j.neterror));
            this.refreshView.c(this.gkh, false);
            this.refreshView.My();
            this.refreshView.onChangeSkinType();
        }
    }

    public void ZI() {
        if (this.refreshView != null) {
            this.refreshView.ad(this.gkh);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.gkg, e.d.cp_bg_line_d);
            al.j(this.mListView, e.d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dn(e.f.s_navbar_bg)).mutate());
            this.gke.onChangeSkinType();
            this.bJX.onChangeSkinType(this.mPageContext, i);
            this.dgD.onChangeSkinType(this.mPageContext, i);
            this.gkf.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gke != null) {
            this.gke.bno();
        }
    }

    public void C(int i, boolean z) {
        this.gkf.C(i, z);
    }

    public void bnn() {
        if (this.gke != null) {
            this.gke.bnn();
        }
    }

    public void bno() {
        if (this.gke != null) {
            this.gke.bno();
        }
    }
}
