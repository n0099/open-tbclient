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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {
    private NoNetworkView dnF;
    private PluginErrorTipView eWW;
    private com.baidu.tieba.personCenter.b.c ikQ;
    private com.baidu.tieba.view.d ikR;
    private View ikS;
    private FrameLayout ikT;
    private a ikU;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void cJ(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.dnF = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.eWW = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.ikT = (FrameLayout) view.findViewById(R.id.layout_container);
            this.mListView = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.ikS = new View(tbPageContext.getPageActivity());
            this.ikS.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.ikS);
            this.ikQ = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.ikR = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.ikQ.b(fVar);
            if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("clicked_blue_tip", false) || fVar.getUserData() == null || fVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ikQ.notifyDataSetChanged();
    }

    public void V(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.ikR.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.ikR.ccy();
        this.ikR.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bgJ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.ikU = aVar;
    }

    public void aJg() {
        if (!bgJ()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ()) {
                            c.this.aJh();
                            if (c.this.ikU != null) {
                                c.this.ikU.cJ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kK(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.qN(this.mPageContext.getString(R.string.neterror));
            this.refreshView.attachView(this.ikT, false);
            this.refreshView.atI();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aJh() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.ikT);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.ikS, R.color.cp_bg_line_d);
            am.l(this.mListView, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d, i);
            this.ikQ.onChangeSkinType();
            this.dnF.onChangeSkinType(this.mPageContext, i);
            this.eWW.onChangeSkinType(this.mPageContext, i);
            this.ikR.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ikQ != null) {
            this.ikQ.cbc();
        }
    }

    public void P(int i, boolean z) {
        this.ikR.P(i, z);
    }

    public void cbb() {
        if (this.ikQ != null) {
            this.ikQ.cbb();
        }
    }

    public void cbc() {
        if (this.ikQ != null) {
            this.ikQ.cbc();
        }
    }
}
