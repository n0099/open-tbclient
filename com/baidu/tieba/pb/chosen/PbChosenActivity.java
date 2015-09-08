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
    private NavigationBar aIp;
    private BdListView aKK;
    private com.baidu.tbadk.editortools.c.d aTv;
    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> aTw;
    private TextView bZA;
    private View bZB;
    private com.baidu.tieba.pb.chosen.a.a bZC;
    private com.baidu.tieba.tbadkCore.w bZD;
    private com.baidu.tieba.pb.chosen.net.zan.a bZE;
    private com.baidu.tieba.pb.chosen.net.b bZF;
    private r bZG;
    private boolean bZH;
    private RelativeLayout bZv;
    private com.baidu.tieba.pb.chosen.a.e bZw;
    private com.baidu.tieba.pb.chosen.a.i bZx;
    private com.baidu.tieba.pb.chosen.a.d bZy;
    private com.baidu.tieba.pb.chosen.a.m bZz;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager mVoiceManager;
    private long startTime;
    private String shareUrl = null;
    private boolean aQO = false;
    private boolean bZI = false;
    private int from = 1;
    private final AbsListView.OnScrollListener aTA = new a(this);
    private com.baidu.tbadk.editortools.c.b atJ = new j(this);
    private View.OnClickListener bZJ = new k(this);
    private final a.d atM = new l(this);
    private d.a bZK = new m(this);
    private View.OnClickListener bZL = new n(this);
    private CustomMessageListener bZM = new o(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener bZN = new p(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private i.a bZO = new q(this);
    private e.b bZP = new b(this);
    private com.baidu.adp.framework.listener.a apA = new c(this, CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    private com.baidu.adp.framework.listener.a bZQ = new d(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    private CustomMessageListener bZR = new e(this, CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getForumInfo() != null && this.chosenData.getForumInfo().fromfid != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getForumInfo().fromfid.longValue()) {
                this.bZw.eg(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        if (this.bZF == null) {
            this.bZF = new com.baidu.tieba.pb.chosen.net.b();
        }
        this.bZF.a(this, longExtra);
        hideNetRefreshView(this.bZv);
        showLoadingView(this.bZv, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.bZv);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.bZv, getResources().getString(i.h.error_unkown_try_again), true);
            this.bZz.setVisible(false);
            return;
        }
        this.aQO = true;
        this.bZz.setVisible(true);
        this.chosenData = aVar;
        User_Info userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.bZw.a(userInfo);
        }
        if (this.bZy != null) {
            this.bZy.b(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ForumInfo forumInfo = aVar.getForumInfo();
        if (forumInfo != null) {
            if (this.bZA != null && forumInfo.threadsnum != null) {
                String o = aq.o(forumInfo.threadsnum.longValue());
                this.bZA.setText(getResources().getString(i.h.chosen_pb_reply_number_text, o));
                this.bZz.jn(getResources().getString(i.h.chosen_pb_reply_count_text, o));
            }
            this.bZx.a(forumInfo);
            this.bZx.aW(forumInfo.tag, forumInfo.tagabstract);
            this.bZw.a(getPageContext().getPageActivity(), forumInfo);
            com.baidu.tieba.pb.c.a aVar2 = new com.baidu.tieba.pb.c.a();
            aVar2.a(getPageContext(), aVar.getForumInfo().content);
            this.bZC.aX(aVar2.getData());
            this.bZC.notifyDataSetChanged();
        }
        this.aKK.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(i.g.chosen_pb_layout);
        this.bZv = (RelativeLayout) findViewById(i.f.chosen_pb_root);
        this.aKK = (BdListView) findViewById(i.f.chosen_pb_listview);
        this.aKK.setOnTouchListener(new f(this));
        this.aKK.setOnScrollListener(this.aTA);
        this.bZC = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aKK.setAdapter((ListAdapter) this.bZC);
        this.bZz = new com.baidu.tieba.pb.chosen.a.m(findViewById(i.f.chosen_pb_reply));
        this.bZz.y(this.bZJ);
        this.bZz.z(this.bZL);
        this.bZw = new com.baidu.tieba.pb.chosen.a.e(getPageContext().getPageActivity());
        this.bZx = new com.baidu.tieba.pb.chosen.a.i(getPageContext().getPageActivity());
        this.bZy = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity(), this.bZK);
        this.bZw.a(this.bZP);
        this.bZx.a(this.bZO);
        this.aKK.addHeaderView(this.bZw.acK());
        this.aKK.addFooterView(this.bZx.acL());
        this.aKK.addFooterView(this.bZy.getView());
        Oj();
        registerListener(this.bZQ);
        registerListener(this.bZR);
        registerListener(this.apA);
        registerListener(this.bZM);
        registerListener(this.bZN);
        acF();
        this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
        this.startTime = SystemClock.elapsedRealtime();
        this.from = getIntent().getIntExtra("from", 1);
        if (this.from == 2) {
            TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
        }
        com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("key_enter_recommend_pb", true);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        g(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bZH && !this.bZI) {
            this.bZH = true;
            showLoadingView(this.bZv, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aKK;
    }

    private void Oj() {
        this.aIp = (NavigationBar) findViewById(i.f.view_navigation_bar);
        if (this.aIp != null) {
            this.aIp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            this.aIp.setTitleText(i.h.chosen_pb_title);
            this.bZB = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.chosen_pb_reply_layout, (ViewGroup) null);
            this.bZA = (TextView) this.bZB.findViewById(i.f.chosen_pb_reply_number);
            this.aIp.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bZB, new h(this));
        }
    }

    private void acF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE), customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.aTv != null) {
                this.aTv.onActivityResult(i, i2, intent);
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

    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> acG() {
        if (this.aTw == null) {
            this.aTw = new i(this, getPageContext());
        }
        return this.aTw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().ad(i == 1);
        getPageContext().getLayoutMode().k(this.bZw.acK());
        getPageContext().getLayoutMode().k(this.bZx.acL());
        al.h(this.bZB, i.e.title_icon_bg);
        this.bZy.tf();
        this.bZz.tf();
        if (this.aIp != null) {
            this.aIp.onChangeSkinType(getPageContext(), i);
        }
        if (this.aTv != null && this.aTv.AL() != null) {
            this.aTv.AL().onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.aTv == null || this.aTv.AL() == null || !this.aTv.AL().AO()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.aTv.AL().zr();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aTv != null) {
            this.aTv.onSaveInstanceState(bundle);
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
        if (this.aTv != null) {
            this.aTv.onDestroy();
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    private void g(Bundle bundle) {
        com.baidu.tbadk.editortools.c.l lVar = new com.baidu.tbadk.editortools.c.l();
        lVar.a(acG());
        this.aTv = (com.baidu.tbadk.editortools.c.d) lVar.al(getActivity());
        this.aTv.b(this);
        this.aTv.a(this.atM);
        this.aTv.a(this.atJ);
        this.aTv.a(this, bundle);
        h(this.aTv);
    }

    private void h(com.baidu.tbadk.editortools.c.d dVar) {
        if (dVar.AL() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bZv.addView(dVar.AL(), layoutParams);
            dVar.AL().hide();
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
