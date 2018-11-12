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
    private NoNetworkView bKI;
    private PluginErrorTipView dhI;
    private com.baidu.tieba.personCenter.b.c glD;
    private com.baidu.tieba.view.d glE;
    private View glF;
    private FrameLayout glG;
    private a glH;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes5.dex */
    public interface a {
        void bI(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bKI = (NoNetworkView) view.findViewById(e.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(e.g.person_center_navigation_bar);
            this.dhI = (PluginErrorTipView) view.findViewById(e.g.person_center_plugin_error_tip_view);
            this.glG = (FrameLayout) view.findViewById(e.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(e.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(e.C0200e.ds200));
            this.glF = new View(tbPageContext.getPageActivity());
            this.glF.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.glF);
            this.glD = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.glE = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.glD.b(eVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || eVar.getUserData() == null || eVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.glD.notifyDataSetChanged();
    }

    public void y(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(e.j.mine));
        this.glE.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(e.C0200e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(e.C0200e.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.glE.bnS();
        this.glE.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aIj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.glH = aVar;
    }

    public void ZR() {
        if (!aIj()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK()) {
                            c.this.ZS();
                            if (c.this.glH != null) {
                                c.this.glH.bI(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fP(this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.hV(this.mPageContext.getString(e.j.neterror));
            this.refreshView.attachView(this.glG, false);
            this.refreshView.MH();
            this.refreshView.onChangeSkinType();
        }
    }

    public void ZS() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.glG);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.glF, e.d.cp_bg_line_d);
            al.j(this.mListView, e.d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dB(e.f.s_navbar_bg)).mutate());
            this.glD.onChangeSkinType();
            this.bKI.onChangeSkinType(this.mPageContext, i);
            this.dhI.onChangeSkinType(this.mPageContext, i);
            this.glE.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.glD != null) {
            this.glD.bmJ();
        }
    }

    public void C(int i, boolean z) {
        this.glE.C(i, z);
    }

    public void bmI() {
        if (this.glD != null) {
            this.glD.bmI();
        }
    }

    public void bmJ() {
        if (this.glD != null) {
            this.glD.bmJ();
        }
    }
}
