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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes9.dex */
public class j {
    private static final int topMargin = l.getDimens(TbadkApplication.getInst().getContext(), R.dimen.ds320);
    private View jYN;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private DressItemData nFW;
    private d nGR;
    private BackgroundPreviewActivity nHG;
    private i nHO;
    private BdExpandListView nHP;
    private g nHQ;
    private SkinProgressView nHk;
    private View.OnClickListener jig = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && j.this.nFW != null && j.this.nGR != null) {
                TiebaStatic.log(new ar("c10284"));
                if (j.this.nFW.getInUse()) {
                    com.baidu.tbadk.core.e.b.B(j.this.nHG.getPageContext().getPageActivity(), 8);
                } else {
                    j.this.nGR.a(j.this.nFW, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nHb = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.j.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        TiebaStatic.log(new ar("c10286").ap("obj_id", j.this.nFW.getPropsId()).ap("obj_type", j.this.nFW.getFreeUserLevel()));
                        j.this.nFW.setInUse(true);
                        j.this.dRp();
                        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), j.this.nFW.getPropsId());
                        return;
                    }
                    j.this.nGR.a(responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nGe ? com.baidu.tieba.themeCenter.c.nGc : com.baidu.tieba.themeCenter.c.nGd, responsedMessage.getErrorString(), j.this.nFW, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
                }
            }
        }
    };

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nHG = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.nHG.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.nHG.setContentView(this.mRoot);
        this.jYN = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine(false);
        this.nHP = (BdExpandListView) this.nHG.findViewById(R.id.personcenter_list);
        this.nHk = (SkinProgressView) this.mRoot.findViewById(R.id.view_bg_use);
        this.nGR = new d(backgroundPreviewActivity.getPageContext(), this.nHG.getUniqueId());
        this.nGR.setFrom(this.nHG.getFrom());
    }

    public void g(DressItemData dressItemData) {
        this.nFW = dressItemData;
        if (this.nFW == null) {
            cAO();
            return;
        }
        cAP();
        if (this.nHO == null) {
            this.nHO = new i(this.nHG);
            this.nHO.f(dressItemData);
            this.nHP.addHeaderView(this.nHO.getRootView());
            this.nHO.bzn();
            this.nHP.setExpandView(this.nHO.getRootView(), this.nHG.getResources().getDimensionPixelSize(R.dimen.ds400));
            this.nHQ = new g(this.nHG.getPageContext(), dressItemData);
            this.nHP.setAdapter((ListAdapter) this.nHQ);
            dRl();
            this.nHG.registerListener(this.nHb);
        }
        this.nHk.setDressData(this.nFW);
        this.nHk.setOnClickListener(this.jig);
        dRp();
    }

    private void dRl() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRp() {
        if (this.nFW != null) {
            boolean inUse = this.nFW.getInUse();
            int activityFinish = this.nFW.getActivityFinish();
            this.nHk.setFontSize(l.getDimens(this.nHG.getPageContext().getPageActivity(), R.dimen.fontsize32));
            if (inUse) {
                this.nHk.b(0, 0.0f, this.nFW.getFreeUserLevel(), activityFinish, 2);
            } else {
                this.nHk.b(9, 0.0f, this.nFW.getFreeUserLevel(), activityFinish, 2);
            }
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.nHP.setExpandListRefreshListener(aVar);
    }

    public void cAO() {
        this.jYN.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nHG.getPageContext().getResources().getString(R.string.no_data_text);
        this.nHG.setNetRefreshViewTopMargin(topMargin);
        this.nHG.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAP() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nHG.hideNetRefreshView(this.mRoot);
        this.jYN.setVisibility(0);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.nHG.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nHG.getPageContext(), TbadkApplication.getInst().getSkinType());
            ap.setBackgroundResource(this.mNavigationBar, R.color.common_color_10262);
        }
        if (this.nHP != null && this.nHP.getVisibility() == 0 && this.nHQ != null) {
            this.nHQ.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nHb);
    }
}
