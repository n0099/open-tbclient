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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c {
    private NoNetworkView bla;
    private PluginErrorTipView cHz;
    private com.baidu.tieba.personCenter.b.c fEB;
    private com.baidu.tieba.view.d fEC;
    private View fED;
    private FrameLayout fEE;
    private a fEF;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void bm(View view2);
    }

    public c(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view2 != null) {
            this.mPageContext = tbPageContext;
            this.bla = (NoNetworkView) view2.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view2.findViewById(d.g.person_center_navigation_bar);
            this.cHz = (PluginErrorTipView) view2.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fEE = (FrameLayout) view2.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view2.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.fED = new View(tbPageContext.getPageActivity());
            this.fED.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.fED);
            this.fEB = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.fEC = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.d dVar) {
        if (dVar != null) {
            this.fEB.b(dVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || dVar.getUserData() == null || dVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fEB.notifyDataSetChanged();
    }

    public void B(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.k.mine));
        this.fEC.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.fEC.beP();
        this.fEC.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean axe() {
        if (this.refreshView != null) {
            return this.refreshView.Fm();
        }
        return false;
    }

    public void a(a aVar) {
        this.fEF = aVar;
    }

    public void Qm() {
        if (!axe()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (j.gD()) {
                            c.this.Qn();
                            if (c.this.fEF != null) {
                                c.this.fEF.bm(view2);
                            }
                        }
                    }
                });
            }
            this.refreshView.fa(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.setSubText(this.mPageContext.getString(d.k.neterror));
            this.refreshView.d(this.fEE, false);
            this.refreshView.Fu();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Qn() {
        if (this.refreshView != null) {
            this.refreshView.P(this.fEE);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.h(this.mTitle, d.C0126d.cp_cont_b);
            ak.j(this.fED, d.C0126d.cp_bg_line_d);
            ak.j(this.mListView, d.C0126d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cO(d.f.s_navbar_bg)).mutate());
            this.fEB.onChangeSkinType();
            this.bla.onChangeSkinType(this.mPageContext, i);
            this.cHz.onChangeSkinType(this.mPageContext, i);
            this.fEC.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fEB != null) {
            this.fEB.bdI();
        }
    }

    public void C(int i, boolean z) {
        this.fEC.C(i, z);
    }

    public void bdH() {
        if (this.fEB != null) {
            this.fEB.bdH();
        }
    }

    public void bdI() {
        if (this.fEB != null) {
            this.fEB.bdI();
        }
    }
}
