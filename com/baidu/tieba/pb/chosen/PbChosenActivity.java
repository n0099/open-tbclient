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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
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
    private NavigationBar aHt;
    private BdListView aJO;
    private com.baidu.tbadk.editortools.c.d aSC;
    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> aSD;
    private RelativeLayout ceO;
    private com.baidu.tieba.pb.chosen.a.e ceP;
    private com.baidu.tieba.pb.chosen.a.i ceQ;
    private com.baidu.tieba.pb.chosen.a.d ceR;
    private com.baidu.tieba.pb.chosen.a.m ceS;
    private TextView ceT;
    private View ceU;
    private com.baidu.tieba.pb.chosen.a.a ceV;
    private com.baidu.tieba.tbadkCore.w ceW;
    private com.baidu.tieba.pb.chosen.net.zan.a ceX;
    private com.baidu.tieba.pb.chosen.net.b ceY;
    private s ceZ;
    private boolean cfa;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager mVoiceManager;
    private long startTime;
    private String shareUrl = null;
    private boolean aPV = false;
    private boolean cfb = false;
    private int from = 1;
    private final AbsListView.OnScrollListener aSH = new a(this);
    private com.baidu.tbadk.editortools.c.b ash = new k(this);
    private View.OnClickListener cfc = new l(this);
    private final a.d ask = new m(this);
    private d.a cfd = new n(this);
    private View.OnClickListener cfe = new o(this);
    private CustomMessageListener cff = new p(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener cfg = new q(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private i.a cfh = new r(this);
    private e.b cfi = new b(this);
    private com.baidu.adp.framework.listener.a aoa = new d(this, CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    private com.baidu.adp.framework.listener.a cfj = new e(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    private CustomMessageListener cfk = new f(this, CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getForumInfo() != null && this.chosenData.getForumInfo().fromfid != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getForumInfo().fromfid.longValue()) {
                this.ceP.el(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        if (this.ceY == null) {
            this.ceY = new com.baidu.tieba.pb.chosen.net.b();
        }
        this.ceY.a(this, longExtra);
        hideNetRefreshView(this.ceO);
        showLoadingView(this.ceO, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.ceO);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.ceO, getResources().getString(i.h.error_unkown_try_again), true);
            this.ceS.setVisible(false);
            return;
        }
        this.aPV = true;
        this.ceS.setVisible(true);
        this.chosenData = aVar;
        User_Info userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.ceP.a(userInfo);
        }
        if (this.ceR != null) {
            this.ceR.b(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ForumInfo forumInfo = aVar.getForumInfo();
        if (forumInfo != null) {
            if (this.ceT != null && forumInfo.threadsnum != null) {
                String q = as.q(forumInfo.threadsnum.longValue());
                this.ceT.setText(getResources().getString(i.h.chosen_pb_reply_number_text, q));
                this.ceS.jF(getResources().getString(i.h.chosen_pb_reply_count_text, q));
            }
            this.ceQ.a(forumInfo);
            this.ceQ.aW(forumInfo.tag, forumInfo.tagabstract);
            this.ceP.a(getPageContext().getPageActivity(), forumInfo);
            com.baidu.tieba.pb.c.a aVar2 = new com.baidu.tieba.pb.c.a();
            aVar2.a(getPageContext(), aVar.getForumInfo().content);
            this.ceV.aZ(aVar2.getData());
            this.ceV.notifyDataSetChanged();
        }
        this.aJO.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(i.g.chosen_pb_layout);
        this.ceO = (RelativeLayout) findViewById(i.f.chosen_pb_root);
        this.aJO = (BdListView) findViewById(i.f.chosen_pb_listview);
        this.aJO.setOnTouchListener(new g(this));
        this.aJO.setOnScrollListener(this.aSH);
        this.ceV = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aJO.setAdapter((ListAdapter) this.ceV);
        this.ceS = new com.baidu.tieba.pb.chosen.a.m(findViewById(i.f.chosen_pb_reply));
        this.ceS.z(this.cfc);
        this.ceS.A(this.cfe);
        this.ceP = new com.baidu.tieba.pb.chosen.a.e(getPageContext().getPageActivity());
        this.ceQ = new com.baidu.tieba.pb.chosen.a.i(getPageContext().getPageActivity());
        this.ceR = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity(), this.cfd);
        this.ceP.a(this.cfi);
        this.ceQ.a(this.cfh);
        this.aJO.addHeaderView(this.ceP.aeD());
        this.aJO.addFooterView(this.ceQ.aeE());
        this.aJO.addFooterView(this.ceR.getView());
        Og();
        registerListener(this.cfj);
        registerListener(this.cfk);
        registerListener(this.aoa);
        registerListener(this.cff);
        registerListener(this.cfg);
        aey();
        this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
        this.startTime = SystemClock.elapsedRealtime();
        this.from = getIntent().getIntExtra("from", 1);
        if (this.from == 2) {
            TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
        }
        com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("key_enter_recommend_pb", true);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        g(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.cfa && !this.cfb) {
            this.cfa = true;
            showLoadingView(this.ceO, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aJO;
    }

    private void Og() {
        this.aHt = (NavigationBar) findViewById(i.f.view_navigation_bar);
        if (this.aHt != null) {
            this.aHt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
            this.aHt.setTitleText(i.h.chosen_pb_title);
            this.ceU = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.chosen_pb_reply_layout, (ViewGroup) null);
            this.ceT = (TextView) this.ceU.findViewById(i.f.chosen_pb_reply_number);
            this.aHt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ceU, new i(this));
        }
    }

    private void aey() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE), customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.aSC != null) {
                this.aSC.onActivityResult(i, i2, intent);
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

    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> aez() {
        if (this.aSD == null) {
            this.aSD = new j(this, getPageContext());
        }
        return this.aSD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().ad(i == 1);
        getPageContext().getLayoutMode().k(this.ceP.aeD());
        getPageContext().getLayoutMode().k(this.ceQ.aeE());
        this.ceR.sZ();
        this.ceS.sZ();
        if (this.aHt != null) {
            this.aHt.onChangeSkinType(getPageContext(), i);
        }
        if (this.aSC != null && this.aSC.Au() != null) {
            this.aSC.Au().onChangeSkinType(i);
        }
        an.j(this.ceO, i.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.aSC == null || this.aSC.Au() == null || !this.aSC.Au().Ax()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.aSC.Au().yX();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aSC != null) {
            this.aSC.onSaveInstanceState(bundle);
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
        if (this.aSC != null) {
            this.aSC.onDestroy();
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    private void g(Bundle bundle) {
        com.baidu.tbadk.editortools.c.l lVar = new com.baidu.tbadk.editortools.c.l();
        lVar.a(aez());
        this.aSC = (com.baidu.tbadk.editortools.c.d) lVar.ak(getActivity());
        this.aSC.b(this);
        this.aSC.a(this.ask);
        this.aSC.a(this.ash);
        this.aSC.a(this, bundle);
        h(this.aSC);
    }

    private void h(com.baidu.tbadk.editortools.c.d dVar) {
        if (dVar.Au() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ceO.addView(dVar.Au(), layoutParams);
            dVar.Au().hide();
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
