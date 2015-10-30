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
    private NoNetworkView aRa;
    private BackgroundPreviewActivity dfS;
    private i dfa;
    private View dfn;
    private SkinProgressView dfv;
    private DressItemData dfw;
    private w dgb;
    private BdExpandListView dgc;
    private u dgd;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private View.OnClickListener aUx = new ab(this);
    private com.baidu.adp.framework.listener.a dfl = new ac(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    public aa(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dfS = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.dfS.getPageContext().getPageActivity()).inflate(i.g.background_preview, (ViewGroup) null);
        this.dfS.setContentView(this.mRoot);
        this.dfn = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background_detail);
        this.dgc = (BdExpandListView) this.dfS.findViewById(i.f.personcenter_list);
        this.dfv = (SkinProgressView) this.mRoot.findViewById(i.f.view_bg_use);
        this.dfv.setListenerTag(this.dfS.getUniqueId());
        this.dfa = new i(backgroundPreviewActivity.getPageContext());
    }

    public void d(DressItemData dressItemData) {
        this.dfw = dressItemData;
        if (this.dfw == null) {
            Kn();
            return;
        }
        Ko();
        this.dgb = new w(this.dfS);
        this.dgb.c(dressItemData);
        this.dgc.addHeaderView(this.dgb.getRootView());
        this.dgb.oO();
        this.dgc.c(this.dgb.getRootView(), this.dfS.getResources().getDimensionPixelSize(i.d.ds400));
        this.dgd = new u(this.dfS.getPageContext(), dressItemData);
        this.dgc.setAdapter((ListAdapter) this.dgd);
        if (!this.dfw.getIsActivity()) {
            azs();
            this.dfS.registerListener(this.dfl);
        }
        this.dfv.setOnClickListener(this.aUx);
        azv();
    }

    private void azs() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azv() {
        boolean inUse = this.dfw.getInUse();
        this.dfv.setFontSize(com.baidu.adp.lib.util.k.d(this.dfS.getPageContext().getPageActivity(), i.d.fontsize32));
        if (inUse) {
            this.dfv.a(0, 0.0f, this.dfw.getFreeUserLevel());
        } else {
            this.dfv.a(9, 0.0f, this.dfw.getFreeUserLevel());
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.dgc.setExpandListRefreshListener(aVar);
    }

    public void Kn() {
        this.dfn.setVisibility(8);
        an.j(this.mRoot, i.c.cp_bg_line_d);
        this.dfS.showNetRefreshView(this.mRoot, this.dfS.getPageContext().getResources().getString(i.h.no_data_text), false);
    }

    public void Ko() {
        an.j(this.mRoot, i.c.cp_bg_line_c);
        this.dfS.hideNetRefreshView(this.mRoot);
        this.dfn.setVisibility(0);
    }

    public void oO() {
        com.baidu.tbadk.h.a.a(this.dfS.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dfS.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRa != null && this.aRa.getVisibility() == 0) {
            this.aRa.onChangeSkinType(this.dfS.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dgc != null && this.dgc.getVisibility() == 0 && this.dgd != null) {
            this.dgd.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
