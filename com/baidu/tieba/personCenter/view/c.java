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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.f;
/* loaded from: classes.dex */
public class c {
    private NoNetworkView bYQ;
    private PluginErrorTipView dmj;
    private com.baidu.tieba.personCenter.b.c ghW;
    private f ghX;
    private View ghY;
    private FrameLayout ghZ;
    private a gia;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void cH(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bYQ = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.dmj = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.ghZ = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.ghY = new View(tbPageContext.getPageActivity());
            this.ghY.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.ghY);
            this.ghW = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.ghX = new f(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.d dVar) {
        if (dVar != null) {
            this.ghW.b(dVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || dVar.getUserData() == null || dVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ghW.notifyDataSetChanged();
    }

    public void ac(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.ghX.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.ghX.biC();
        this.ghX.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aAH() {
        if (this.refreshView != null) {
            return this.refreshView.Mb();
        }
        return false;
    }

    public void a(a aVar) {
        this.gia = aVar;
    }

    public void XP() {
        if (!aAH()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ow()) {
                            c.this.WE();
                            if (c.this.gia != null) {
                                c.this.gia.cH(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.id(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gF(this.mPageContext.getString(d.j.neterror));
            this.refreshView.j(this.ghZ, false);
            this.refreshView.Mj();
            this.refreshView.onChangeSkinType();
        }
    }

    public void WE() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.ghZ);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.mTitle, d.C0107d.cp_cont_b);
            aj.t(this.ghY, d.C0107d.cp_bg_line_d);
            aj.t(this.mListView, d.C0107d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.ghW.onChangeSkinType();
            this.bYQ.onChangeSkinType(this.mPageContext, i);
            this.dmj.onChangeSkinType(this.mPageContext, i);
            this.ghX.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ghW != null) {
            this.ghW.bhw();
        }
    }

    public void K(int i, boolean z) {
        this.ghX.K(i, z);
    }

    public void bhv() {
        if (this.ghW != null) {
            this.ghW.bhv();
        }
    }

    public void bhw() {
        if (this.ghW != null) {
            this.ghW.bhw();
        }
    }
}
