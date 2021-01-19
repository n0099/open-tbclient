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
    private DressItemData nvM;
    private d nwH;
    private i nxE;
    private BdExpandListView nxF;
    private g nxG;
    private SkinProgressView nxa;
    private BackgroundPreviewActivity nxw;
    private View.OnClickListener jcl = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && j.this.nvM != null && j.this.nwH != null) {
                TiebaStatic.log(new aq("c10284"));
                if (j.this.nvM.getInUse()) {
                    com.baidu.tbadk.core.e.b.B(j.this.nxw.getPageContext().getPageActivity(), 8);
                } else {
                    j.this.nwH.a(j.this.nvM, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nwR = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.j.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        TiebaStatic.log(new aq("c10286").an("obj_id", j.this.nvM.getPropsId()).an("obj_type", j.this.nvM.getFreeUserLevel()));
                        j.this.nvM.setInUse(true);
                        j.this.dOW();
                        com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), j.this.nvM.getPropsId());
                        return;
                    }
                    j.this.nwH.a(responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nvU ? com.baidu.tieba.themeCenter.c.nvS : com.baidu.tieba.themeCenter.c.nvT, responsedMessage.getErrorString(), j.this.nvM, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
                }
            }
        }
    };

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nxw = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.nxw.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.nxw.setContentView(this.mRoot);
        this.jQX = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine(false);
        this.nxF = (BdExpandListView) this.nxw.findViewById(R.id.personcenter_list);
        this.nxa = (SkinProgressView) this.mRoot.findViewById(R.id.view_bg_use);
        this.nwH = new d(backgroundPreviewActivity.getPageContext(), this.nxw.getUniqueId());
        this.nwH.setFrom(this.nxw.getFrom());
    }

    public void g(DressItemData dressItemData) {
        this.nvM = dressItemData;
        if (this.nvM == null) {
            czw();
            return;
        }
        czx();
        if (this.nxE == null) {
            this.nxE = new i(this.nxw);
            this.nxE.f(dressItemData);
            this.nxF.addHeaderView(this.nxE.getRootView());
            this.nxE.byV();
            this.nxF.setExpandView(this.nxE.getRootView(), this.nxw.getResources().getDimensionPixelSize(R.dimen.ds400));
            this.nxG = new g(this.nxw.getPageContext(), dressItemData);
            this.nxF.setAdapter((ListAdapter) this.nxG);
            dOS();
            this.nxw.registerListener(this.nwR);
        }
        this.nxa.setDressData(this.nvM);
        this.nxa.setOnClickListener(this.jcl);
        dOW();
    }

    private void dOS() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOW() {
        if (this.nvM != null) {
            boolean inUse = this.nvM.getInUse();
            int activityFinish = this.nvM.getActivityFinish();
            this.nxa.setFontSize(l.getDimens(this.nxw.getPageContext().getPageActivity(), R.dimen.fontsize32));
            if (inUse) {
                this.nxa.b(0, 0.0f, this.nvM.getFreeUserLevel(), activityFinish, 2);
            } else {
                this.nxa.b(9, 0.0f, this.nvM.getFreeUserLevel(), activityFinish, 2);
            }
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.nxF.setExpandListRefreshListener(aVar);
    }

    public void czw() {
        this.jQX.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nxw.getPageContext().getResources().getString(R.string.no_data_text);
        this.nxw.setNetRefreshViewTopMargin(agC);
        this.nxw.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nxw.hideNetRefreshView(this.mRoot);
        this.jQX.setVisibility(0);
    }

    public void byV() {
        com.baidu.tbadk.r.a.a(this.nxw.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nxw.getPageContext(), TbadkApplication.getInst().getSkinType());
            ao.setBackgroundResource(this.mNavigationBar, R.color.common_color_10262);
        }
        if (this.nxF != null && this.nxF.getVisibility() == 0 && this.nxG != null) {
            this.nxG.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nwR);
    }
}
