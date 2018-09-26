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
/* loaded from: classes2.dex */
public class c {
    private NoNetworkView bBq;
    private PluginErrorTipView cYn;
    private com.baidu.tieba.personCenter.b.c gcB;
    private com.baidu.tieba.view.d gcC;
    private View gcD;
    private FrameLayout gcE;
    private a gcF;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void bG(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bBq = (NoNetworkView) view.findViewById(e.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(e.g.person_center_navigation_bar);
            this.cYn = (PluginErrorTipView) view.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gcE = (FrameLayout) view.findViewById(e.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(e.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(e.C0141e.ds200));
            this.gcD = new View(tbPageContext.getPageActivity());
            this.gcD.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.gcD);
            this.gcB = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.gcC = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.gcB.b(eVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || eVar.getUserData() == null || eVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gcB.notifyDataSetChanged();
    }

    public void D(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(e.j.mine));
        this.gcC.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(e.C0141e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(e.C0141e.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.gcC.blm();
        this.gcC.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aFt() {
        if (this.refreshView != null) {
            return this.refreshView.Ks();
        }
        return false;
    }

    public void a(a aVar) {
        this.gcF = aVar;
    }

    public void VZ() {
        if (!aFt()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ky()) {
                            c.this.Wa();
                            if (c.this.gcF != null) {
                                c.this.gcF.bG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fs(this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.hG(this.mPageContext.getString(e.j.neterror));
            this.refreshView.c(this.gcE, false);
            this.refreshView.KA();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Wa() {
        if (this.refreshView != null) {
            this.refreshView.ad(this.gcE);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.gcD, e.d.cp_bg_line_d);
            al.j(this.mListView, e.d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dd(e.f.s_navbar_bg)).mutate());
            this.gcB.onChangeSkinType();
            this.bBq.onChangeSkinType(this.mPageContext, i);
            this.cYn.onChangeSkinType(this.mPageContext, i);
            this.gcC.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gcB != null) {
            this.gcB.bkd();
        }
    }

    public void C(int i, boolean z) {
        this.gcC.C(i, z);
    }

    public void bkc() {
        if (this.gcB != null) {
            this.gcB.bkc();
        }
    }

    public void bkd() {
        if (this.gcB != null) {
            this.gcB.bkd();
        }
    }
}
