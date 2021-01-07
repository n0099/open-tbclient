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
/* loaded from: classes9.dex */
public class j {
    private static final int aht = l.getDimens(TbadkApplication.getInst().getContext(), R.dimen.ds320);
    private View jVC;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private DressItemData nAq;
    private SkinProgressView nBE;
    private d nBl;
    private BackgroundPreviewActivity nCa;
    private i nCi;
    private BdExpandListView nCj;
    private g nCk;
    private View.OnClickListener jgS = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && j.this.nAq != null && j.this.nBl != null) {
                TiebaStatic.log(new aq("c10284"));
                if (j.this.nAq.getInUse()) {
                    com.baidu.tbadk.core.e.b.B(j.this.nCa.getPageContext().getPageActivity(), 8);
                } else {
                    j.this.nBl.a(j.this.nAq, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nBv = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.j.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        TiebaStatic.log(new aq("c10286").an("obj_id", j.this.nAq.getPropsId()).an("obj_type", j.this.nAq.getFreeUserLevel()));
                        j.this.nAq.setInUse(true);
                        j.this.dSO();
                        com.baidu.tbadk.core.sharedPref.b.bvr().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), j.this.nAq.getPropsId());
                        return;
                    }
                    j.this.nBl.a(responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nAy ? com.baidu.tieba.themeCenter.c.nAw : com.baidu.tieba.themeCenter.c.nAx, responsedMessage.getErrorString(), j.this.nAq, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
                }
            }
        }
    };

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nCa = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.nCa.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.nCa.setContentView(this.mRoot);
        this.jVC = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine(false);
        this.nCj = (BdExpandListView) this.nCa.findViewById(R.id.personcenter_list);
        this.nBE = (SkinProgressView) this.mRoot.findViewById(R.id.view_bg_use);
        this.nBl = new d(backgroundPreviewActivity.getPageContext(), this.nCa.getUniqueId());
        this.nBl.setFrom(this.nCa.getFrom());
    }

    public void g(DressItemData dressItemData) {
        this.nAq = dressItemData;
        if (this.nAq == null) {
            cDo();
            return;
        }
        cDp();
        if (this.nCi == null) {
            this.nCi = new i(this.nCa);
            this.nCi.f(dressItemData);
            this.nCj.addHeaderView(this.nCi.getRootView());
            this.nCi.bCP();
            this.nCj.setExpandView(this.nCi.getRootView(), this.nCa.getResources().getDimensionPixelSize(R.dimen.ds400));
            this.nCk = new g(this.nCa.getPageContext(), dressItemData);
            this.nCj.setAdapter((ListAdapter) this.nCk);
            dSK();
            this.nCa.registerListener(this.nBv);
        }
        this.nBE.setDressData(this.nAq);
        this.nBE.setOnClickListener(this.jgS);
        dSO();
    }

    private void dSK() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSO() {
        if (this.nAq != null) {
            boolean inUse = this.nAq.getInUse();
            int activityFinish = this.nAq.getActivityFinish();
            this.nBE.setFontSize(l.getDimens(this.nCa.getPageContext().getPageActivity(), R.dimen.fontsize32));
            if (inUse) {
                this.nBE.b(0, 0.0f, this.nAq.getFreeUserLevel(), activityFinish, 2);
            } else {
                this.nBE.b(9, 0.0f, this.nAq.getFreeUserLevel(), activityFinish, 2);
            }
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.nCj.setExpandListRefreshListener(aVar);
    }

    public void cDo() {
        this.jVC.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nCa.getPageContext().getResources().getString(R.string.no_data_text);
        this.nCa.setNetRefreshViewTopMargin(aht);
        this.nCa.showNetRefreshView(this.mRoot, string, false);
    }

    public void cDp() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nCa.hideNetRefreshView(this.mRoot);
        this.jVC.setVisibility(0);
    }

    public void bCP() {
        com.baidu.tbadk.r.a.a(this.nCa.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nCa.getPageContext(), TbadkApplication.getInst().getSkinType());
            ao.setBackgroundResource(this.mNavigationBar, R.color.common_color_10262);
        }
        if (this.nCj != null && this.nCj.getVisibility() == 0 && this.nCk != null) {
            this.nCk.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nBv);
    }
}
