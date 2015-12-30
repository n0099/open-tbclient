package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class aa {
    private NoNetworkView bam;
    private View.OnClickListener bdQ = new ab(this);
    private com.baidu.adp.framework.listener.a cWE = new ac(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private View csp;
    private i dLR;
    private BackgroundPreviewActivity dMG;
    private w dMP;
    private BdExpandListView dMQ;
    private u dMR;
    private SkinProgressView dMh;
    private DressItemData dMi;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public aa(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dMG = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.dMG.getPageContext().getPageActivity()).inflate(n.h.background_preview, (ViewGroup) null);
        this.dMG.setContentView(this.mRoot);
        this.csp = this.mRoot.findViewById(n.g.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.personal_background_detail);
        this.dMQ = (BdExpandListView) this.dMG.findViewById(n.g.personcenter_list);
        this.dMh = (SkinProgressView) this.mRoot.findViewById(n.g.view_bg_use);
        this.dMh.setListenerTag(this.dMG.getUniqueId());
        this.dLR = new i(backgroundPreviewActivity.getPageContext());
    }

    public void e(DressItemData dressItemData) {
        this.dMi = dressItemData;
        if (this.dMi == null) {
            Mr();
            return;
        }
        Ms();
        if (this.dMP == null) {
            this.dMP = new w(this.dMG);
            this.dMP.d(dressItemData);
            this.dMQ.addHeaderView(this.dMP.getRootView());
            this.dMP.ot();
            this.dMQ.c(this.dMP.getRootView(), this.dMG.getResources().getDimensionPixelSize(n.e.ds400));
            this.dMR = new u(this.dMG.getPageContext(), dressItemData);
            this.dMQ.setAdapter((ListAdapter) this.dMR);
            if (!this.dMi.getIsActivity()) {
                aHD();
                this.dMG.registerListener(this.cWE);
            }
        }
        this.dMh.setOnClickListener(this.bdQ);
        aHK();
    }

    private void aHD() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHK() {
        if (this.dMi != null) {
            boolean inUse = this.dMi.getInUse();
            int activityFinish = this.dMi.getActivityFinish();
            this.dMh.setFontSize(com.baidu.adp.lib.util.k.d(this.dMG.getPageContext().getPageActivity(), n.e.fontsize32));
            if (inUse) {
                this.dMh.b(0, 0.0f, this.dMi.getFreeUserLevel(), activityFinish);
            } else {
                this.dMh.b(9, 0.0f, this.dMi.getFreeUserLevel(), activityFinish);
            }
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.dMQ.setExpandListRefreshListener(aVar);
    }

    public void Mr() {
        this.csp.setVisibility(8);
        as.j(this.mRoot, n.d.cp_bg_line_d);
        this.dMG.showNetRefreshView(this.mRoot, this.dMG.getPageContext().getResources().getString(n.j.no_data_text), false);
    }

    public void Ms() {
        as.j(this.mRoot, n.d.cp_bg_line_c);
        this.dMG.hideNetRefreshView(this.mRoot);
        this.csp.setVisibility(0);
    }

    public void ot() {
        com.baidu.tbadk.i.a.a(this.dMG.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dMG.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dMG.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dMQ != null && this.dMQ.getVisibility() == 0 && this.dMR != null) {
            this.dMR.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
