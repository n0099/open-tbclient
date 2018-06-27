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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c {
    private NoNetworkView buT;
    private PluginErrorTipView cPN;
    private com.baidu.tieba.personCenter.b.c fVc;
    private com.baidu.tieba.view.d fVd;
    private View fVe;
    private FrameLayout fVf;
    private a fVg;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void bq(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.buT = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.cPN = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fVf = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.fVe = new View(tbPageContext.getPageActivity());
            this.fVe.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.fVe);
            this.fVc = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.fVd = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.d dVar) {
        if (dVar != null) {
            this.fVc.b(dVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || dVar.getUserData() == null || dVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fVc.notifyDataSetChanged();
    }

    public void B(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.k.mine));
        this.fVd.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.fVd.bkv();
        this.fVd.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aCB() {
        if (this.refreshView != null) {
            return this.refreshView.Jh();
        }
        return false;
    }

    public void a(a aVar) {
        this.fVg = aVar;
    }

    public void Ub() {
        if (!aCB()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jr()) {
                            c.this.Uc();
                            if (c.this.fVg != null) {
                                c.this.fVg.bq(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fg(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.setSubText(this.mPageContext.getString(d.k.neterror));
            this.refreshView.d(this.fVf, false);
            this.refreshView.Jp();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Uc() {
        if (this.refreshView != null) {
            this.refreshView.Q(this.fVf);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.mTitle, d.C0142d.cp_cont_b);
            am.j(this.fVe, d.C0142d.cp_bg_line_d);
            am.j(this.mListView, d.C0142d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cS(d.f.s_navbar_bg)).mutate());
            this.fVc.onChangeSkinType();
            this.buT.onChangeSkinType(this.mPageContext, i);
            this.cPN.onChangeSkinType(this.mPageContext, i);
            this.fVd.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fVc != null) {
            this.fVc.bjo();
        }
    }

    public void C(int i, boolean z) {
        this.fVd.C(i, z);
    }

    public void bjn() {
        if (this.fVc != null) {
            this.fVc.bjn();
        }
    }

    public void bjo() {
        if (this.fVc != null) {
            this.fVc.bjo();
        }
    }
}
