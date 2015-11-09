package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class aa {
    private NoNetworkView aRi;
    private i dgG;
    private View dgT;
    private w dhH;
    private BdExpandListView dhI;
    private u dhJ;
    private SkinProgressView dhb;
    private DressItemData dhc;
    private BackgroundPreviewActivity dhy;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private View.OnClickListener aUF = new ab(this);
    private com.baidu.adp.framework.listener.a dgR = new ac(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    public aa(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dhy = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.dhy.getPageContext().getPageActivity()).inflate(i.g.background_preview, (ViewGroup) null);
        this.dhy.setContentView(this.mRoot);
        this.dgT = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background_detail);
        this.dhI = (BdExpandListView) this.dhy.findViewById(i.f.personcenter_list);
        this.dhb = (SkinProgressView) this.mRoot.findViewById(i.f.view_bg_use);
        this.dhb.setListenerTag(this.dhy.getUniqueId());
        this.dgG = new i(backgroundPreviewActivity.getPageContext());
    }

    public void d(DressItemData dressItemData) {
        this.dhc = dressItemData;
        if (this.dhc == null) {
            KD();
            return;
        }
        KE();
        this.dhH = new w(this.dhy);
        this.dhH.c(dressItemData);
        this.dhI.addHeaderView(this.dhH.getRootView());
        this.dhH.oP();
        this.dhI.c(this.dhH.getRootView(), this.dhy.getResources().getDimensionPixelSize(i.d.ds400));
        this.dhJ = new u(this.dhy.getPageContext(), dressItemData);
        this.dhI.setAdapter((ListAdapter) this.dhJ);
        if (!this.dhc.getIsActivity()) {
            aAi();
            this.dhy.registerListener(this.dgR);
        }
        this.dhb.setOnClickListener(this.aUF);
        aAl();
    }

    private void aAi() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAl() {
        boolean inUse = this.dhc.getInUse();
        this.dhb.setFontSize(com.baidu.adp.lib.util.k.d(this.dhy.getPageContext().getPageActivity(), i.d.fontsize32));
        if (inUse) {
            this.dhb.a(0, 0.0f, this.dhc.getFreeUserLevel());
        } else {
            this.dhb.a(9, 0.0f, this.dhc.getFreeUserLevel());
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.dhI.setExpandListRefreshListener(aVar);
    }

    public void KD() {
        this.dgT.setVisibility(8);
        an.j(this.mRoot, i.c.cp_bg_line_d);
        this.dhy.showNetRefreshView(this.mRoot, this.dhy.getPageContext().getResources().getString(i.h.no_data_text), false);
    }

    public void KE() {
        an.j(this.mRoot, i.c.cp_bg_line_c);
        this.dhy.hideNetRefreshView(this.mRoot);
        this.dgT.setVisibility(0);
    }

    public void oP() {
        com.baidu.tbadk.h.a.a(this.dhy.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dhy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRi != null && this.aRi.getVisibility() == 0) {
            this.aRi.onChangeSkinType(this.dhy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dhI != null && this.dhI.getVisibility() == 0 && this.dhJ != null) {
            this.dhJ.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
