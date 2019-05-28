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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {
    private NoNetworkView dlX;
    private PluginErrorTipView eRW;
    private com.baidu.tieba.view.d ieA;
    private View ieB;
    private FrameLayout ieC;
    private a ieD;
    private com.baidu.tieba.personCenter.b.c iez;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void cG(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.dlX = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.eRW = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.ieC = (FrameLayout) view.findViewById(R.id.layout_container);
            this.mListView = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.ieB = new View(tbPageContext.getPageActivity());
            this.ieB.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.ieB);
            this.iez = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.ieA = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.iez.b(fVar);
            if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("clicked_blue_tip", false) || fVar.getUserData() == null || fVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iez.notifyDataSetChanged();
    }

    public void V(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.ieA.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.ieA.bZI();
        this.ieA.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean beG() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.ieD = aVar;
    }

    public void aHJ() {
        if (!beG()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG()) {
                            c.this.aHK();
                            if (c.this.ieD != null) {
                                c.this.ieD.cG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kE(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.qx(this.mPageContext.getString(R.string.neterror));
            this.refreshView.attachView(this.ieC, false);
            this.refreshView.asB();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aHK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.ieC);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.mTitle, R.color.cp_cont_b);
            al.l(this.ieB, R.color.cp_bg_line_d);
            al.l(this.mListView, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            al.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d, i);
            this.iez.onChangeSkinType();
            this.dlX.onChangeSkinType(this.mPageContext, i);
            this.eRW.onChangeSkinType(this.mPageContext, i);
            this.ieA.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.iez != null) {
            this.iez.bYm();
        }
    }

    public void N(int i, boolean z) {
        this.ieA.N(i, z);
    }

    public void bYl() {
        if (this.iez != null) {
            this.iez.bYl();
        }
    }

    public void bYm() {
        if (this.iez != null) {
            this.iez.bYm();
        }
    }
}
