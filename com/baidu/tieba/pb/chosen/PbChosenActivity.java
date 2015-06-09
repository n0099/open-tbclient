package com.baidu.tieba.pb.chosen;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> {
    private NavigationBar aox;
    private BdListView aoy;
    private com.baidu.tieba.pb.chosen.a.b bIP;
    private com.baidu.tieba.pb.chosen.a.h bIQ;
    private boolean bIR;
    private com.baidu.tieba.pb.chosen.net.zan.a bIS;
    private com.baidu.tieba.pb.chosen.net.b bIT;
    private h bIU;
    private com.baidu.tieba.pb.chosen.a.a bIW;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private View rootView;
    private long startTime;
    private String shareUrl = null;
    private boolean aIZ = false;
    private boolean bIV = false;
    private com.baidu.tieba.pb.chosen.a.k bIX = new a(this);
    private com.baidu.tieba.pb.chosen.a.g bIY = new b(this);
    private com.baidu.adp.framework.listener.a aiI = new c(this, CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    private com.baidu.adp.framework.listener.a bIZ = new d(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    private CustomMessageListener bJa = new e(this, 2001321);

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        if (this.bIT == null) {
            this.bIT = new com.baidu.tieba.pb.chosen.net.b();
        }
        this.bIT.a(this, longExtra);
        hideNetRefreshView(this.rootView);
        showLoadingView(this.rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        if (aVar != null) {
            this.aIZ = true;
            hideLoadingView(this.rootView);
            this.chosenData = aVar;
            User_Info userInfo = aVar.getUserInfo();
            if (userInfo != null) {
                this.bIP.a(userInfo);
            }
            ForumInfo forumInfo = aVar.getForumInfo();
            if (forumInfo != null) {
                this.bIQ.a(forumInfo);
                this.bIP.setTitle(forumInfo.title);
                this.bIP.ij(forumInfo.tag);
                this.bIP.N(getPageContext().getPageActivity(), forumInfo.fromfname);
                com.baidu.tieba.pb.d.a aVar2 = new com.baidu.tieba.pb.d.a();
                aVar2.a(getPageContext(), aVar.getForumInfo().content);
                this.bIW.aS(aVar2.getData());
                this.bIW.notifyDataSetChanged();
            }
            this.aoy.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.chosen_pb_layout);
        this.rootView = findViewById(q.chosen_pb_root);
        this.aoy = (BdListView) findViewById(q.chosen_pb_listview);
        this.bIW = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aoy.setAdapter((ListAdapter) this.bIW);
        this.bIP = new com.baidu.tieba.pb.chosen.a.b(getPageContext().getPageActivity());
        this.bIQ = new com.baidu.tieba.pb.chosen.a.h(getPageContext().getPageActivity());
        this.bIP.a(this.bIY);
        this.bIQ.a(this.bIX);
        this.aoy.addHeaderView(this.bIP.aan());
        this.aoy.addFooterView(this.bIQ.aao());
        this.aox = (NavigationBar) findViewById(q.view_navigation_bar);
        MN();
        registerListener(this.bIZ);
        registerListener(this.bJa);
        registerListener(this.aiI);
        aak();
        this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
        this.startTime = SystemClock.elapsedRealtime();
        if (getIntent().getIntExtra("from", 1) == 2) {
            TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
        }
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("key_enter_recommend_pb", true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bIR && !this.bIV) {
            this.bIR = true;
            showLoadingView(this.rootView, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aoy;
    }

    private void MN() {
        if (this.aox != null) {
            this.aox.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
            this.aox.setTitleText(t.chosen_pb_title);
            this.aox.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.chosen_pb_share, new g(this));
        }
    }

    private void aak() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001321, new com.baidu.tieba.pb.chosen.cache.b());
        MessageManager.getInstance().sendMessage(new CustomMessage(2001321), customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 23003:
                    h.a(this, this.chosenData, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0), this.shareUrl);
                    return;
                case 23007:
                    h.a(this, this.chosenData, intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"), this.shareUrl);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.chosenData != null && this.chosenData.getForumInfo() != null && this.chosenData.getForumInfo().ftid != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_new_duration", null, 1, "duration", new StringBuilder(String.valueOf(SystemClock.elapsedRealtime() - this.startTime)).toString(), PbChosenActivityConfig.KEY_TID, this.chosenData.getForumInfo().ftid);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().ab(i == 1);
        getPageContext().getLayoutMode().j(this.bIP.aan());
        getPageContext().getLayoutMode().j(this.bIQ.aao());
        if (this.aox != null) {
            this.aox.onChangeSkinType(getPageContext(), i);
        }
    }
}
