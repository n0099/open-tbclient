package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes8.dex */
public class j {
    private static final int agC = l.getDimens(TbadkApplication.getInst().getContext(), R.dimen.ds320);
    private View jQX;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private DressItemData nvL;
    private d nwG;
    private SkinProgressView nwZ;
    private i nxD;
    private BdExpandListView nxE;
    private g nxF;
    private BackgroundPreviewActivity nxv;
    private View.OnClickListener jcl = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && j.this.nvL != null && j.this.nwG != null) {
                TiebaStatic.log(new aq("c10284"));
                if (j.this.nvL.getInUse()) {
                    com.baidu.tbadk.core.e.b.B(j.this.nxv.getPageContext().getPageActivity(), 8);
                } else {
                    j.this.nwG.a(j.this.nvL, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nwQ = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.j.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        TiebaStatic.log(new aq("c10286").an("obj_id", j.this.nvL.getPropsId()).an("obj_type", j.this.nvL.getFreeUserLevel()));
                        j.this.nvL.setInUse(true);
                        j.this.dOW();
                        com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), j.this.nvL.getPropsId());
                        return;
                    }
                    j.this.nwG.a(responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nvT ? com.baidu.tieba.themeCenter.c.nvR : com.baidu.tieba.themeCenter.c.nvS, responsedMessage.getErrorString(), j.this.nvL, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
                }
            }
        }
    };

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nxv = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.nxv.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.nxv.setContentView(this.mRoot);
        this.jQX = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine(false);
        this.nxE = (BdExpandListView) this.nxv.findViewById(R.id.personcenter_list);
        this.nwZ = (SkinProgressView) this.mRoot.findViewById(R.id.view_bg_use);
        this.nwG = new d(backgroundPreviewActivity.getPageContext(), this.nxv.getUniqueId());
        this.nwG.setFrom(this.nxv.getFrom());
    }

    public void g(DressItemData dressItemData) {
        this.nvL = dressItemData;
        if (this.nvL == null) {
            czw();
            return;
        }
        czx();
        if (this.nxD == null) {
            this.nxD = new i(this.nxv);
            this.nxD.f(dressItemData);
            this.nxE.addHeaderView(this.nxD.getRootView());
            this.nxD.byV();
            this.nxE.setExpandView(this.nxD.getRootView(), this.nxv.getResources().getDimensionPixelSize(R.dimen.ds400));
            this.nxF = new g(this.nxv.getPageContext(), dressItemData);
            this.nxE.setAdapter((ListAdapter) this.nxF);
            dOS();
            this.nxv.registerListener(this.nwQ);
        }
        this.nwZ.setDressData(this.nvL);
        this.nwZ.setOnClickListener(this.jcl);
        dOW();
    }

    private void dOS() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOW() {
        if (this.nvL != null) {
            boolean inUse = this.nvL.getInUse();
            int activityFinish = this.nvL.getActivityFinish();
            this.nwZ.setFontSize(l.getDimens(this.nxv.getPageContext().getPageActivity(), R.dimen.fontsize32));
            if (inUse) {
                this.nwZ.b(0, 0.0f, this.nvL.getFreeUserLevel(), activityFinish, 2);
            } else {
                this.nwZ.b(9, 0.0f, this.nvL.getFreeUserLevel(), activityFinish, 2);
            }
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.nxE.setExpandListRefreshListener(aVar);
    }

    public void czw() {
        this.jQX.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nxv.getPageContext().getResources().getString(R.string.no_data_text);
        this.nxv.setNetRefreshViewTopMargin(agC);
        this.nxv.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nxv.hideNetRefreshView(this.mRoot);
        this.jQX.setVisibility(0);
    }

    public void byV() {
        com.baidu.tbadk.r.a.a(this.nxv.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nxv.getPageContext(), TbadkApplication.getInst().getSkinType());
            ao.setBackgroundResource(this.mNavigationBar, R.color.common_color_10262);
        }
        if (this.nxE != null && this.nxE.getVisibility() == 0 && this.nxF != null) {
            this.nxF.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nwQ);
    }
}
