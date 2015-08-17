package com.baidu.tieba.pb.chosen;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.a.d;
import com.baidu.tieba.pb.chosen.a.e;
import com.baidu.tieba.pb.chosen.a.i;
import com.baidu.tieba.tbadkCore.writeModel.a;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private NavigationBar aIc;
    private BdListView aKx;
    private com.baidu.tbadk.editortools.c.d aTh;
    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> aTi;
    private RelativeLayout bYB;
    private com.baidu.tieba.pb.chosen.a.e bYC;
    private com.baidu.tieba.pb.chosen.a.i bYD;
    private com.baidu.tieba.pb.chosen.a.d bYE;
    private com.baidu.tieba.pb.chosen.a.m bYF;
    private TextView bYG;
    private View bYH;
    private com.baidu.tieba.pb.chosen.a.a bYI;
    private com.baidu.tieba.tbadkCore.v bYJ;
    private com.baidu.tieba.pb.chosen.net.zan.a bYK;
    private com.baidu.tieba.pb.chosen.net.b bYL;
    private r bYM;
    private boolean bYN;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager mVoiceManager;
    private long startTime;
    private String shareUrl = null;
    private boolean aQA = false;
    private boolean bYO = false;
    private int from = 1;
    private final AbsListView.OnScrollListener aTm = new a(this);
    private com.baidu.tbadk.editortools.c.b arZ = new j(this);
    private View.OnClickListener bYP = new k(this);
    private final a.d asc = new l(this);
    private d.a bYQ = new m(this);
    private View.OnClickListener bYR = new n(this);
    private CustomMessageListener bYS = new o(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener bYT = new p(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private i.a bYU = new q(this);
    private e.b bYV = new b(this);
    private com.baidu.adp.framework.listener.a anP = new c(this, CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    private com.baidu.adp.framework.listener.a bYW = new d(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    private CustomMessageListener bYX = new e(this, CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getForumInfo() != null && this.chosenData.getForumInfo().fromfid != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getForumInfo().fromfid.longValue()) {
                this.bYC.dZ(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        if (this.bYL == null) {
            this.bYL = new com.baidu.tieba.pb.chosen.net.b();
        }
        this.bYL.a(this, longExtra);
        hideNetRefreshView(this.bYB);
        showLoadingView(this.bYB, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.bYB);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.bYB, getResources().getString(i.C0057i.error_unkown_try_again), true);
            this.bYF.setVisible(false);
            return;
        }
        this.aQA = true;
        this.bYF.setVisible(true);
        this.chosenData = aVar;
        User_Info userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.bYC.a(userInfo);
        }
        if (this.bYE != null) {
            this.bYE.b(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ForumInfo forumInfo = aVar.getForumInfo();
        if (forumInfo != null) {
            if (this.bYG != null && forumInfo.threadsnum != null) {
                String o = aq.o(forumInfo.threadsnum.longValue());
                this.bYG.setText(getResources().getString(i.C0057i.chosen_pb_reply_number_text, o));
                this.bYF.jf(getResources().getString(i.C0057i.chosen_pb_reply_count_text, o));
            }
            this.bYD.a(forumInfo);
            this.bYD.aU(forumInfo.tag, forumInfo.tagabstract);
            this.bYC.a(getPageContext().getPageActivity(), forumInfo);
            com.baidu.tieba.pb.c.a aVar2 = new com.baidu.tieba.pb.c.a();
            aVar2.a(getPageContext(), aVar.getForumInfo().content);
            this.bYI.aW(aVar2.getData());
            this.bYI.notifyDataSetChanged();
        }
        this.aKx.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(i.g.chosen_pb_layout);
        this.bYB = (RelativeLayout) findViewById(i.f.chosen_pb_root);
        this.aKx = (BdListView) findViewById(i.f.chosen_pb_listview);
        this.aKx.setOnTouchListener(new f(this));
        this.aKx.setOnScrollListener(this.aTm);
        this.bYI = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aKx.setAdapter((ListAdapter) this.bYI);
        this.bYF = new com.baidu.tieba.pb.chosen.a.m(findViewById(i.f.chosen_pb_reply));
        this.bYF.z(this.bYP);
        this.bYF.A(this.bYR);
        this.bYC = new com.baidu.tieba.pb.chosen.a.e(getPageContext().getPageActivity());
        this.bYD = new com.baidu.tieba.pb.chosen.a.i(getPageContext().getPageActivity());
        this.bYE = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity(), this.bYQ);
        this.bYC.a(this.bYV);
        this.bYD.a(this.bYU);
        this.aKx.addHeaderView(this.bYC.acB());
        this.aKx.addFooterView(this.bYD.acC());
        this.aKx.addFooterView(this.bYE.getView());
        Oi();
        registerListener(this.bYW);
        registerListener(this.bYX);
        registerListener(this.anP);
        registerListener(this.bYS);
        registerListener(this.bYT);
        acw();
        this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
        this.startTime = SystemClock.elapsedRealtime();
        this.from = getIntent().getIntExtra("from", 1);
        if (this.from == 2) {
            TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
        }
        com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("key_enter_recommend_pb", true);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        g(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bYN && !this.bYO) {
            this.bYN = true;
            showLoadingView(this.bYB, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aKx;
    }

    private void Oi() {
        this.aIc = (NavigationBar) findViewById(i.f.view_navigation_bar);
        if (this.aIc != null) {
            this.aIc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            this.aIc.setTitleText(i.C0057i.chosen_pb_title);
            this.bYH = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.chosen_pb_reply_layout, (ViewGroup) null);
            this.bYG = (TextView) this.bYH.findViewById(i.f.chosen_pb_reply_number);
            this.aIc.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bYH, new h(this));
        }
    }

    private void acw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE), customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.aTh != null) {
                this.aTh.onActivityResult(i, i2, intent);
            }
            switch (i) {
                case 23003:
                    r.a(this, this.chosenData, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
                    return;
                case 23007:
                    r.a(this, this.chosenData, intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"), this.shareUrl);
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
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> acx() {
        if (this.aTi == null) {
            this.aTi = new i(this, getPageContext());
        }
        return this.aTi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().ad(i == 1);
        getPageContext().getLayoutMode().k(this.bYC.acB());
        getPageContext().getLayoutMode().k(this.bYD.acC());
        al.i(this.bYH, i.e.title_icon_bg);
        this.bYE.ta();
        this.bYF.ta();
        if (this.aIc != null) {
            this.aIc.onChangeSkinType(getPageContext(), i);
        }
        if (this.aTh != null && this.aTh.Ay() != null) {
            this.aTh.Ay().onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.aTh == null || this.aTh.Ay() == null || !this.aTh.Ay().AB()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.aTh.Ay().zk();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aTh != null) {
            this.aTh.onSaveInstanceState(bundle);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aTh != null) {
            this.aTh.onDestroy();
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    private void g(Bundle bundle) {
        com.baidu.tbadk.editortools.c.l lVar = new com.baidu.tbadk.editortools.c.l();
        lVar.a(acx());
        this.aTh = (com.baidu.tbadk.editortools.c.d) lVar.al(getActivity());
        this.aTh.b(this);
        this.aTh.a(this.asc);
        this.aTh.a(this.arZ);
        this.aTh.a(this, bundle);
        j(this.aTh);
    }

    private void j(com.baidu.tbadk.editortools.c.d dVar) {
        if (dVar.Ay() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bYB.addView(dVar.Ay(), layoutParams);
            dVar.Ay().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
