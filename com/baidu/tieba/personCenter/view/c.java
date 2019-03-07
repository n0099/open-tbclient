package com.baidu.tieba.personCenter.view;

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
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c {
    private NoNetworkView dbq;
    private PluginErrorTipView eCy;
    private com.baidu.tieba.personCenter.b.c hME;
    private com.baidu.tieba.view.d hMF;
    private View hMG;
    private FrameLayout hMH;
    private a hMI;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void cy(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.dbq = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.eCy = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.hMH = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.hMG = new View(tbPageContext.getPageActivity());
            this.hMG.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.hMG);
            this.hME = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.hMF = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.hME.b(eVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || eVar.getUserData() == null || eVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hME.notifyDataSetChanged();
    }

    public void Q(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.hMF.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.hMF.bRz();
        this.hMF.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aXr() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.hMI = aVar;
    }

    public void aBs() {
        if (!aXr()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM()) {
                            c.this.aBt();
                            if (c.this.hMI != null) {
                                c.this.hMI.cy(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.jR(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.po(this.mPageContext.getString(d.j.neterror));
            this.refreshView.attachView(this.hMH, false);
            this.refreshView.anC();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aBt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.hMH);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.mTitle, d.C0236d.cp_cont_b);
            al.l(this.hMG, d.C0236d.cp_bg_line_d);
            al.l(this.mListView, d.C0236d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            al.f(this.mNavigationBar.getBarBgView(), d.C0236d.cp_bg_line_d, i);
            this.hME.onChangeSkinType();
            this.dbq.onChangeSkinType(this.mPageContext, i);
            this.eCy.onChangeSkinType(this.mPageContext, i);
            this.hMF.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.hME != null) {
            this.hME.bQr();
        }
    }

    public void I(int i, boolean z) {
        this.hMF.I(i, z);
    }

    public void bQq() {
        if (this.hME != null) {
            this.hME.bQq();
        }
    }

    public void bQr() {
        if (this.hME != null) {
            this.hME.bQr();
        }
    }
}
