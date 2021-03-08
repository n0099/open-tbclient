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
/* loaded from: classes8.dex */
public class j {
    private static final int topMargin = l.getDimens(TbadkApplication.getInst().getContext(), R.dimen.ds320);
    private View kaP;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private d nIX;
    private DressItemData nIc;
    private BackgroundPreviewActivity nJM;
    private i nJU;
    private BdExpandListView nJV;
    private g nJW;
    private SkinProgressView nJq;
    private View.OnClickListener jjP = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && j.this.nIc != null && j.this.nIX != null) {
                TiebaStatic.log(new ar("c10284"));
                if (j.this.nIc.getInUse()) {
                    com.baidu.tbadk.core.e.b.B(j.this.nJM.getPageContext().getPageActivity(), 8);
                } else {
                    j.this.nIX.a(j.this.nIc, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nJh = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.j.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        TiebaStatic.log(new ar("c10286").aq("obj_id", j.this.nIc.getPropsId()).aq("obj_type", j.this.nIc.getFreeUserLevel()));
                        j.this.nIc.setInUse(true);
                        j.this.dRy();
                        com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), j.this.nIc.getPropsId());
                        return;
                    }
                    j.this.nIX.a(responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nIk ? com.baidu.tieba.themeCenter.c.nIi : com.baidu.tieba.themeCenter.c.nIj, responsedMessage.getErrorString(), j.this.nIc, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
                }
            }
        }
    };

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nJM = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.nJM.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.nJM.setContentView(this.mRoot);
        this.kaP = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine(false);
        this.nJV = (BdExpandListView) this.nJM.findViewById(R.id.personcenter_list);
        this.nJq = (SkinProgressView) this.mRoot.findViewById(R.id.view_bg_use);
        this.nIX = new d(backgroundPreviewActivity.getPageContext(), this.nJM.getUniqueId());
        this.nIX.setFrom(this.nJM.getFrom());
    }

    public void g(DressItemData dressItemData) {
        this.nIc = dressItemData;
        if (this.nIc == null) {
            cAU();
            return;
        }
        cAV();
        if (this.nJU == null) {
            this.nJU = new i(this.nJM);
            this.nJU.f(dressItemData);
            this.nJV.addHeaderView(this.nJU.getRootView());
            this.nJU.bzq();
            this.nJV.setExpandView(this.nJU.getRootView(), this.nJM.getResources().getDimensionPixelSize(R.dimen.ds400));
            this.nJW = new g(this.nJM.getPageContext(), dressItemData);
            this.nJV.setAdapter((ListAdapter) this.nJW);
            dRu();
            this.nJM.registerListener(this.nJh);
        }
        this.nJq.setDressData(this.nIc);
        this.nJq.setOnClickListener(this.jjP);
        dRy();
    }

    private void dRu() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRy() {
        if (this.nIc != null) {
            boolean inUse = this.nIc.getInUse();
            int activityFinish = this.nIc.getActivityFinish();
            this.nJq.setFontSize(l.getDimens(this.nJM.getPageContext().getPageActivity(), R.dimen.fontsize32));
            if (inUse) {
                this.nJq.b(0, 0.0f, this.nIc.getFreeUserLevel(), activityFinish, 2);
            } else {
                this.nJq.b(9, 0.0f, this.nIc.getFreeUserLevel(), activityFinish, 2);
            }
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.nJV.setExpandListRefreshListener(aVar);
    }

    public void cAU() {
        this.kaP.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nJM.getPageContext().getResources().getString(R.string.no_data_text);
        this.nJM.setNetRefreshViewTopMargin(topMargin);
        this.nJM.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAV() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nJM.hideNetRefreshView(this.mRoot);
        this.kaP.setVisibility(0);
    }

    public void bzq() {
        com.baidu.tbadk.r.a.a(this.nJM.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nJM.getPageContext(), TbadkApplication.getInst().getSkinType());
            ap.setBackgroundResource(this.mNavigationBar, R.color.common_color_10262);
        }
        if (this.nJV != null && this.nJV.getVisibility() == 0 && this.nJW != null) {
            this.nJW.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nJh);
    }
}
