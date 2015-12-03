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
    private NoNetworkView aWm;
    private View.OnClickListener aZT = new ab(this);
    private com.baidu.adp.framework.listener.a cRZ = new ac(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    /* renamed from: com  reason: collision with root package name */
    private View f127com;
    private SkinProgressView dEE;
    private DressItemData dEF;
    private i dEn;
    private BackgroundPreviewActivity dFe;
    private w dFn;
    private BdExpandListView dFo;
    private u dFp;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public aa(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dFe = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.dFe.getPageContext().getPageActivity()).inflate(n.g.background_preview, (ViewGroup) null);
        this.dFe.setContentView(this.mRoot);
        this.f127com = this.mRoot.findViewById(n.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.personal_background_detail);
        this.dFo = (BdExpandListView) this.dFe.findViewById(n.f.personcenter_list);
        this.dEE = (SkinProgressView) this.mRoot.findViewById(n.f.view_bg_use);
        this.dEE.setListenerTag(this.dFe.getUniqueId());
        this.dEn = new i(backgroundPreviewActivity.getPageContext());
    }

    public void e(DressItemData dressItemData) {
        this.dEF = dressItemData;
        if (this.dEF == null) {
            LY();
            return;
        }
        LZ();
        if (this.dFn == null) {
            this.dFn = new w(this.dFe);
            this.dFn.d(dressItemData);
            this.dFo.addHeaderView(this.dFn.getRootView());
            this.dFn.oV();
            this.dFo.c(this.dFn.getRootView(), this.dFe.getResources().getDimensionPixelSize(n.d.ds400));
            this.dFp = new u(this.dFe.getPageContext(), dressItemData);
            this.dFo.setAdapter((ListAdapter) this.dFp);
            if (!this.dEF.getIsActivity()) {
                aFo();
                this.dFe.registerListener(this.cRZ);
            }
        }
        this.dEE.setOnClickListener(this.aZT);
        aFv();
    }

    private void aFo() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFv() {
        if (this.dEF != null) {
            boolean inUse = this.dEF.getInUse();
            int activityFinish = this.dEF.getActivityFinish();
            this.dEE.setFontSize(com.baidu.adp.lib.util.k.d(this.dFe.getPageContext().getPageActivity(), n.d.fontsize32));
            if (inUse) {
                this.dEE.b(0, 0.0f, this.dEF.getFreeUserLevel(), activityFinish);
            } else {
                this.dEE.b(9, 0.0f, this.dEF.getFreeUserLevel(), activityFinish);
            }
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.dFo.setExpandListRefreshListener(aVar);
    }

    public void LY() {
        this.f127com.setVisibility(8);
        as.j(this.mRoot, n.c.cp_bg_line_d);
        this.dFe.showNetRefreshView(this.mRoot, this.dFe.getPageContext().getResources().getString(n.i.no_data_text), false);
    }

    public void LZ() {
        as.j(this.mRoot, n.c.cp_bg_line_c);
        this.dFe.hideNetRefreshView(this.mRoot);
        this.f127com.setVisibility(0);
    }

    public void oV() {
        com.baidu.tbadk.i.a.a(this.dFe.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dFe.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dFe.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dFo != null && this.dFo.getVisibility() == 0 && this.dFp != null) {
            this.dFp.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
