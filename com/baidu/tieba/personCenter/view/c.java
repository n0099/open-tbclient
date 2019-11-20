package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
    private BdTypeListView duK;
    private NoNetworkView dvR;
    private PluginErrorTipView faG;
    private com.baidu.tieba.personCenter.b.c ilM;
    private com.baidu.tieba.view.d ilN;
    private View ilO;
    private FrameLayout ilP;
    private a ilQ;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void cH(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.dvR = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.faG = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.ilP = (FrameLayout) view.findViewById(R.id.layout_container);
            this.duK = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.ilO = new View(tbPageContext.getPageActivity());
            this.ilO.setLayoutParams(layoutParams);
            this.duK.addFooterView(this.ilO);
            this.ilM = new com.baidu.tieba.personCenter.b.c(this.duK, tbPageContext, bdUniqueId);
            this.ilN = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.ilM.b(fVar);
            if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.CLICKED_BLUE_TIP, false) || fVar.getUserData() == null || fVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ilM.notifyDataSetChanged();
    }

    public void Z(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.ilN.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.ilN.caD();
        this.ilN.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bfk() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.ilQ = aVar;
    }

    public void aJl() {
        if (!bfk()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.aJm();
                            if (c.this.ilQ != null) {
                                c.this.ilQ.cH(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.setSubText(this.mPageContext.getString(R.string.neterror));
            this.refreshView.attachView(this.ilP, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aJm() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.ilP);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.ilO, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.duK, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.ilM.onChangeSkinType();
            this.dvR.onChangeSkinType(this.mPageContext, i);
            this.faG.onChangeSkinType(this.mPageContext, i);
            this.ilN.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ilM != null) {
            this.ilM.bZi();
        }
    }

    public void O(int i, boolean z) {
        this.ilN.O(i, z);
    }

    public void bZh() {
        if (this.ilM != null) {
            this.ilM.bZh();
        }
    }

    public void bZi() {
        if (this.ilM != null) {
            this.ilM.bZi();
        }
    }
}
