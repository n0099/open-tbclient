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
    private NoNetworkView dnM;
    private PluginErrorTipView eXg;
    private com.baidu.tieba.personCenter.b.c ilT;
    private com.baidu.tieba.view.d ilU;
    private View ilV;
    private FrameLayout ilW;
    private a ilX;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void cL(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.dnM = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.eXg = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.ilW = (FrameLayout) view.findViewById(R.id.layout_container);
            this.mListView = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.ilV = new View(tbPageContext.getPageActivity());
            this.ilV.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.ilV);
            this.ilT = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.ilU = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.ilT.b(fVar);
            if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("clicked_blue_tip", false) || fVar.getUserData() == null || fVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ilT.notifyDataSetChanged();
    }

    public void V(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.ilU.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.ilU.ccQ();
        this.ilU.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bgM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.ilX = aVar;
    }

    public void aJi() {
        if (!bgM()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ()) {
                            c.this.aJj();
                            if (c.this.ilX != null) {
                                c.this.ilX.cL(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kL(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.qN(this.mPageContext.getString(R.string.neterror));
            this.refreshView.attachView(this.ilW, false);
            this.refreshView.atK();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aJj() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.ilW);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.ilV, R.color.cp_bg_line_d);
            am.l(this.mListView, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d, i);
            this.ilT.onChangeSkinType();
            this.dnM.onChangeSkinType(this.mPageContext, i);
            this.eXg.onChangeSkinType(this.mPageContext, i);
            this.ilU.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ilT != null) {
            this.ilT.cbu();
        }
    }

    public void P(int i, boolean z) {
        this.ilU.P(i, z);
    }

    public void cbt() {
        if (this.ilT != null) {
            this.ilT.cbt();
        }
    }

    public void cbu() {
        if (this.ilT != null) {
            this.ilT.cbu();
        }
    }
}
