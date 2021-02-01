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
    private View jYz;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private DressItemData nFw;
    private SkinProgressView nGK;
    private d nGr;
    private BackgroundPreviewActivity nHg;
    private i nHo;
    private BdExpandListView nHp;
    private g nHq;
    private View.OnClickListener jhR = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && j.this.nFw != null && j.this.nGr != null) {
                TiebaStatic.log(new ar("c10284"));
                if (j.this.nFw.getInUse()) {
                    com.baidu.tbadk.core.e.b.B(j.this.nHg.getPageContext().getPageActivity(), 8);
                } else {
                    j.this.nGr.a(j.this.nFw, true);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nGB = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.j.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        TiebaStatic.log(new ar("c10286").ap("obj_id", j.this.nFw.getPropsId()).ap("obj_type", j.this.nFw.getFreeUserLevel()));
                        j.this.nFw.setInUse(true);
                        j.this.dRh();
                        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), j.this.nFw.getPropsId());
                        return;
                    }
                    j.this.nGr.a(responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nFE ? com.baidu.tieba.themeCenter.c.nFC : com.baidu.tieba.themeCenter.c.nFD, responsedMessage.getErrorString(), j.this.nFw, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
                }
            }
        }
    };

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nHg = backgroundPreviewActivity;
        this.mRoot = LayoutInflater.from(this.nHg.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.nHg.setContentView(this.mRoot);
        this.jYz = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine(false);
        this.nHp = (BdExpandListView) this.nHg.findViewById(R.id.personcenter_list);
        this.nGK = (SkinProgressView) this.mRoot.findViewById(R.id.view_bg_use);
        this.nGr = new d(backgroundPreviewActivity.getPageContext(), this.nHg.getUniqueId());
        this.nGr.setFrom(this.nHg.getFrom());
    }

    public void g(DressItemData dressItemData) {
        this.nFw = dressItemData;
        if (this.nFw == null) {
            cAH();
            return;
        }
        cAI();
        if (this.nHo == null) {
            this.nHo = new i(this.nHg);
            this.nHo.f(dressItemData);
            this.nHp.addHeaderView(this.nHo.getRootView());
            this.nHo.bzn();
            this.nHp.setExpandView(this.nHo.getRootView(), this.nHg.getResources().getDimensionPixelSize(R.dimen.ds400));
            this.nHq = new g(this.nHg.getPageContext(), dressItemData);
            this.nHp.setAdapter((ListAdapter) this.nHq);
            dRd();
            this.nHg.registerListener(this.nGB);
        }
        this.nGK.setDressData(this.nFw);
        this.nGK.setOnClickListener(this.jhR);
        dRh();
    }

    private void dRd() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRh() {
        if (this.nFw != null) {
            boolean inUse = this.nFw.getInUse();
            int activityFinish = this.nFw.getActivityFinish();
            this.nGK.setFontSize(l.getDimens(this.nHg.getPageContext().getPageActivity(), R.dimen.fontsize32));
            if (inUse) {
                this.nGK.b(0, 0.0f, this.nFw.getFreeUserLevel(), activityFinish, 2);
            } else {
                this.nGK.b(9, 0.0f, this.nFw.getFreeUserLevel(), activityFinish, 2);
            }
        }
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.nHp.setExpandListRefreshListener(aVar);
    }

    public void cAH() {
        this.jYz.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nHg.getPageContext().getResources().getString(R.string.no_data_text);
        this.nHg.setNetRefreshViewTopMargin(topMargin);
        this.nHg.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAI() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nHg.hideNetRefreshView(this.mRoot);
        this.jYz.setVisibility(0);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.nHg.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nHg.getPageContext(), TbadkApplication.getInst().getSkinType());
            ap.setBackgroundResource(this.mNavigationBar, R.color.common_color_10262);
        }
        if (this.nHp != null && this.nHp.getVisibility() == 0 && this.nHq != null) {
            this.nHq.notifyDataSetChanged();
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nGB);
    }
}
