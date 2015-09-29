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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
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
    private NavigationBar aHi;
    private BdListView aJD;
    private com.baidu.tbadk.editortools.c.d aSr;
    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> aSs;
    private RelativeLayout ceD;
    private com.baidu.tieba.pb.chosen.a.e ceE;
    private com.baidu.tieba.pb.chosen.a.i ceF;
    private com.baidu.tieba.pb.chosen.a.d ceG;
    private com.baidu.tieba.pb.chosen.a.m ceH;
    private TextView ceI;
    private View ceJ;
    private com.baidu.tieba.pb.chosen.a.a ceK;
    private com.baidu.tieba.tbadkCore.w ceL;
    private com.baidu.tieba.pb.chosen.net.zan.a ceM;
    private com.baidu.tieba.pb.chosen.net.b ceN;
    private s ceO;
    private boolean ceP;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager mVoiceManager;
    private long startTime;
    private String shareUrl = null;
    private boolean aPK = false;
    private boolean ceQ = false;
    private int from = 1;
    private final AbsListView.OnScrollListener aSw = new a(this);
    private com.baidu.tbadk.editortools.c.b asg = new k(this);
    private View.OnClickListener ceR = new l(this);
    private final a.d asj = new m(this);
    private d.a ceS = new n(this);
    private View.OnClickListener ceT = new o(this);
    private CustomMessageListener ceU = new p(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener ceV = new q(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private i.a ceW = new r(this);
    private e.b ceX = new b(this);
    private com.baidu.adp.framework.listener.a anZ = new d(this, CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    private com.baidu.adp.framework.listener.a ceY = new e(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    private CustomMessageListener ceZ = new f(this, CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getForumInfo() != null && this.chosenData.getForumInfo().fromfid != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getForumInfo().fromfid.longValue()) {
                this.ceE.el(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        if (this.ceN == null) {
            this.ceN = new com.baidu.tieba.pb.chosen.net.b();
        }
        this.ceN.a(this, longExtra);
        hideNetRefreshView(this.ceD);
        showLoadingView(this.ceD, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.ceD);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.ceD, getResources().getString(i.h.error_unkown_try_again), true);
            this.ceH.setVisible(false);
            return;
        }
        this.aPK = true;
        this.ceH.setVisible(true);
        this.chosenData = aVar;
        User_Info userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.ceE.a(userInfo);
        }
        if (this.ceG != null) {
            this.ceG.b(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ForumInfo forumInfo = aVar.getForumInfo();
        if (forumInfo != null) {
            if (this.ceI != null && forumInfo.threadsnum != null) {
                String s = ar.s(forumInfo.threadsnum.longValue());
                this.ceI.setText(getResources().getString(i.h.chosen_pb_reply_number_text, s));
                this.ceH.jF(getResources().getString(i.h.chosen_pb_reply_count_text, s));
            }
            this.ceF.a(forumInfo);
            this.ceF.aW(forumInfo.tag, forumInfo.tagabstract);
            this.ceE.a(getPageContext().getPageActivity(), forumInfo);
            com.baidu.tieba.pb.c.a aVar2 = new com.baidu.tieba.pb.c.a();
            aVar2.a(getPageContext(), aVar.getForumInfo().content);
            this.ceK.aZ(aVar2.getData());
            this.ceK.notifyDataSetChanged();
        }
        this.aJD.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(i.g.chosen_pb_layout);
        this.ceD = (RelativeLayout) findViewById(i.f.chosen_pb_root);
        this.aJD = (BdListView) findViewById(i.f.chosen_pb_listview);
        this.aJD.setOnTouchListener(new g(this));
        this.aJD.setOnScrollListener(this.aSw);
        this.ceK = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aJD.setAdapter((ListAdapter) this.ceK);
        this.ceH = new com.baidu.tieba.pb.chosen.a.m(findViewById(i.f.chosen_pb_reply));
        this.ceH.z(this.ceR);
        this.ceH.A(this.ceT);
        this.ceE = new com.baidu.tieba.pb.chosen.a.e(getPageContext().getPageActivity());
        this.ceF = new com.baidu.tieba.pb.chosen.a.i(getPageContext().getPageActivity());
        this.ceG = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity(), this.ceS);
        this.ceE.a(this.ceX);
        this.ceF.a(this.ceW);
        this.aJD.addHeaderView(this.ceE.aeH());
        this.aJD.addFooterView(this.ceF.aeI());
        this.aJD.addFooterView(this.ceG.getView());
        Ok();
        registerListener(this.ceY);
        registerListener(this.ceZ);
        registerListener(this.anZ);
        registerListener(this.ceU);
        registerListener(this.ceV);
        aeC();
        this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
        this.startTime = SystemClock.elapsedRealtime();
        this.from = getIntent().getIntExtra("from", 1);
        if (this.from == 2) {
            TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
        }
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("key_enter_recommend_pb", true);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        g(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.ceP && !this.ceQ) {
            this.ceP = true;
            showLoadingView(this.ceD, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aJD;
    }

    private void Ok() {
        this.aHi = (NavigationBar) findViewById(i.f.view_navigation_bar);
        if (this.aHi != null) {
            this.aHi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
            this.aHi.setTitleText(i.h.chosen_pb_title);
            this.ceJ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.chosen_pb_reply_layout, (ViewGroup) null);
            this.ceI = (TextView) this.ceJ.findViewById(i.f.chosen_pb_reply_number);
            this.aHi.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ceJ, new i(this));
        }
    }

    private void aeC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE), customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.aSr != null) {
                this.aSr.onActivityResult(i, i2, intent);
            }
            switch (i) {
                case 23003:
                    s.a(this, this.chosenData, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
                    return;
                case 23007:
                    s.a(this, this.chosenData, intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"), this.shareUrl);
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

    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> aeD() {
        if (this.aSs == null) {
            this.aSs = new j(this, getPageContext());
        }
        return this.aSs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().ad(i == 1);
        getPageContext().getLayoutMode().k(this.ceE.aeH());
        getPageContext().getLayoutMode().k(this.ceF.aeI());
        this.ceG.tc();
        this.ceH.tc();
        if (this.aHi != null) {
            this.aHi.onChangeSkinType(getPageContext(), i);
        }
        if (this.aSr != null && this.aSr.Ax() != null) {
            this.aSr.Ax().onChangeSkinType(i);
        }
        am.j(this.ceD, i.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.aSr == null || this.aSr.Ax() == null || !this.aSr.Ax().AA()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.aSr.Ax().za();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aSr != null) {
            this.aSr.onSaveInstanceState(bundle);
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
        if (this.aSr != null) {
            this.aSr.onDestroy();
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    private void g(Bundle bundle) {
        com.baidu.tbadk.editortools.c.l lVar = new com.baidu.tbadk.editortools.c.l();
        lVar.a(aeD());
        this.aSr = (com.baidu.tbadk.editortools.c.d) lVar.ak(getActivity());
        this.aSr.b(this);
        this.aSr.a(this.asj);
        this.aSr.a(this.asg);
        this.aSr.a(this, bundle);
        h(this.aSr);
    }

    private void h(com.baidu.tbadk.editortools.c.d dVar) {
        if (dVar.Ax() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ceD.addView(dVar.Ax(), layoutParams);
            dVar.Ax().hide();
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
