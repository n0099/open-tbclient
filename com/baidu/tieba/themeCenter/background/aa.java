package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class aa {
    private NoNetworkView aQP;
    private i deA;
    private View deN;
    private SkinProgressView deV;
    private DressItemData deW;
    private w dfB;
    private BdExpandListView dfC;
    private u dfD;
    private BackgroundPreviewActivity dfs;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private View.OnClickListener aUm = new ab(this);
    private com.baidu.adp.framework.listener.a deL = new ac(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    public aa(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dfs = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.dfs.getPageContext().getPageActivity()).inflate(i.g.background_preview, (ViewGroup) null);
        this.dfs.setContentView(this.mRoot);
        this.deN = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background_detail);
        this.dfC = (BdExpandListView) this.dfs.findViewById(i.f.personcenter_list);
        this.deV = (SkinProgressView) this.mRoot.findViewById(i.f.view_bg_use);
        this.deV.setListenerTag(this.dfs.getUniqueId());
        this.deA = new i(backgroundPreviewActivity.getPageContext());
    }

    public void d(DressItemData dressItemData) {
        this.deW = dressItemData;
        if (this.deW == null) {
            Kr();
            return;
        }
        Ks();
        this.dfB = new w(this.dfs);
        this.dfB.c(dressItemData);
        this.dfC.addHeaderView(this.dfB.getRootView());
        this.dfB.oO();
        this.dfC.c(this.dfB.getRootView(), this.dfs.getResources().getDimensionPixelSize(i.d.ds400));
        this.dfD = new u(this.dfs.getPageContext(), dressItemData);
        this.dfC.setAdapter((ListAdapter) this.dfD);
        if (!this.deW.getIsActivity()) {
            azm();
            this.dfs.registerListener(this.deL);
        }
        this.deV.setOnClickListener(this.aUm);
        azp();
    }

    private void azm() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azp() {
        boolean inUse = this.deW.getInUse();
        this.deV.setFontSize(com.baidu.adp.lib.util.k.d(this.dfs.getPageContext().getPageActivity(), i.d.fontsize32));
        if (inUse) {
            this.deV.a(0, 0.0f, this.deW.getFreeUserLevel());
        } else {
            this.deV.a(9, 0.0f, this.deW.getFreeUserLevel());
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.dfC.setExpandListRefreshListener(aVar);
    }

    public void Kr() {
        this.deN.setVisibility(8);
        am.j(this.mRoot, i.c.cp_bg_line_d);
        this.dfs.showNetRefreshView(this.mRoot, this.dfs.getPageContext().getResources().getString(i.h.no_data_text), false);
    }

    public void Ks() {
        am.j(this.mRoot, i.c.cp_bg_line_c);
        this.dfs.hideNetRefreshView(this.mRoot);
        this.deN.setVisibility(0);
    }

    public void oO() {
        com.baidu.tbadk.h.a.a(this.dfs.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dfs.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aQP != null && this.aQP.getVisibility() == 0) {
            this.aQP.onChangeSkinType(this.dfs.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dfC != null && this.dfC.getVisibility() == 0 && this.dfD != null) {
            this.dfD.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
