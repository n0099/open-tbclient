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
    private NoNetworkView dbr;
    private PluginErrorTipView eCg;
    private com.baidu.tieba.personCenter.b.c hMm;
    private com.baidu.tieba.view.d hMn;
    private View hMo;
    private FrameLayout hMp;
    private a hMq;
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
            this.dbr = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.eCg = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.hMp = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.hMo = new View(tbPageContext.getPageActivity());
            this.hMo.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.hMo);
            this.hMm = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.hMn = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.hMm.b(eVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || eVar.getUserData() == null || eVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hMm.notifyDataSetChanged();
    }

    public void S(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.hMn.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.hMn.bRy();
        this.hMn.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aXp() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.hMq = aVar;
    }

    public void aBp() {
        if (!aXp()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM()) {
                            c.this.aBq();
                            if (c.this.hMq != null) {
                                c.this.hMq.cy(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.jQ(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.pp(this.mPageContext.getString(d.j.neterror));
            this.refreshView.attachView(this.hMp, false);
            this.refreshView.any();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aBq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.hMp);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.mTitle, d.C0277d.cp_cont_b);
            al.l(this.hMo, d.C0277d.cp_bg_line_d);
            al.l(this.mListView, d.C0277d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            al.f(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d, i);
            this.hMm.onChangeSkinType();
            this.dbr.onChangeSkinType(this.mPageContext, i);
            this.eCg.onChangeSkinType(this.mPageContext, i);
            this.hMn.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.hMm != null) {
            this.hMm.bQq();
        }
    }

    public void I(int i, boolean z) {
        this.hMn.I(i, z);
    }

    public void bQp() {
        if (this.hMm != null) {
            this.hMm.bQp();
        }
    }

    public void bQq() {
        if (this.hMm != null) {
            this.hMm.bQq();
        }
    }
}
