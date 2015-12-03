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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.chosen.a.d;
import com.baidu.tieba.pb.chosen.a.e;
import com.baidu.tieba.pb.chosen.a.i;
import com.baidu.tieba.tbadkCore.writeModel.a;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private NavigationBar aJm;
    private BdListView aNj;
    private com.baidu.tbadk.editortools.d.e aXY;
    private com.baidu.tbadk.editortools.d.a<PbChosenActivity> aXZ;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private RelativeLayout cxP;
    private com.baidu.tieba.pb.chosen.a.e cxQ;
    private com.baidu.tieba.pb.chosen.a.i cxR;
    private com.baidu.tieba.pb.chosen.a.d cxS;
    private com.baidu.tieba.pb.chosen.a.l cxT;
    private TextView cxU;
    private View cxV;
    private com.baidu.tieba.pb.chosen.a.a cxW;
    private com.baidu.tieba.tbadkCore.x cxX;
    private com.baidu.tieba.pb.chosen.net.zan.a cxY;
    private com.baidu.tieba.pb.chosen.net.b cxZ;
    private t cya;
    private boolean cyb;
    private VoiceManager mVoiceManager;
    private long startTime;
    private String shareUrl = null;
    private boolean aVg = false;
    private boolean cyc = false;
    private int from = 1;
    private int cyd = -1;
    private final AbsListView.OnScrollListener aYd = new a(this);
    private com.baidu.tbadk.editortools.d.c asJ = new l(this);
    private View.OnClickListener cye = new m(this);
    private final a.d asP = new n(this);
    private d.a cyf = new o(this);
    private View.OnClickListener cyg = new p(this);
    private CustomMessageListener cyh = new q(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener cyi = new r(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private i.a cyj = new s(this);
    private e.b cyk = new b(this);
    private com.baidu.adp.framework.listener.a apX = new d(this, CmdConfigHttp.CMD_GET_FINE_PB, 309093);
    private CustomMessageListener cyl = new e(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private com.baidu.adp.framework.listener.a cym = new f(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095);
    private CustomMessageListener cyn = new g(this, CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.cxQ.eP(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (getIntent() != null) {
            long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            long longExtra2 = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
            long longExtra3 = getIntent().getLongExtra("thread_id", 0L);
            if (this.cxZ == null) {
                this.cxZ = new com.baidu.tieba.pb.chosen.net.b();
            }
            this.cxZ.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.cxP);
            showLoadingView(this.cxP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.cxP);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.cxP, getResources().getString(n.i.error_unkown_try_again), true);
            this.cxT.setVisible(false);
            return;
        }
        this.aVg = true;
        this.cxT.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.cxQ.a(userInfo);
        }
        if (this.cxS != null) {
            this.cxS.b(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.cxU != null && threadInfo.post_num != null) {
                String w = ax.w(threadInfo.post_num.longValue());
                this.cxU.setText(getResources().getString(n.i.chosen_pb_reply_number_text, w));
                this.cxT.kw(getResources().getString(n.i.chosen_pb_reply_count_text, w));
            }
            this.cxR.a(threadInfo);
            this.cxQ.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.c.a aVar2 = new com.baidu.tieba.pb.c.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.cxW.bo(aVar2.getData());
            this.cxW.notifyDataSetChanged();
        }
        this.aNj.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(n.g.chosen_pb_layout);
        this.cxP = (RelativeLayout) findViewById(n.f.chosen_pb_root);
        this.aNj = (BdListView) findViewById(n.f.chosen_pb_listview);
        this.aNj.setOnTouchListener(new h(this));
        this.aNj.setOnScrollListener(this.aYd);
        this.cxW = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aNj.setAdapter((ListAdapter) this.cxW);
        this.cxT = new com.baidu.tieba.pb.chosen.a.l(findViewById(n.f.chosen_pb_reply));
        this.cxT.z(this.cye);
        this.cxT.A(this.cyg);
        this.cxQ = new com.baidu.tieba.pb.chosen.a.e(getPageContext().getPageActivity());
        this.cxR = new com.baidu.tieba.pb.chosen.a.i(getPageContext().getPageActivity());
        this.cxS = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity(), this.cyf);
        this.cxQ.a(this.cyk);
        this.cxR.a(this.cyj);
        this.aNj.addHeaderView(this.cxQ.ajq());
        this.aNj.addFooterView(this.cxR.ajr());
        this.aNj.addFooterView(this.cxS.getView());
        Qh();
        registerListener(this.cym);
        registerListener(this.cyl);
        this.cyn.setSelfListener(true);
        registerListener(this.cyn);
        registerListener(this.apX);
        registerListener(this.cyh);
        registerListener(this.cyi);
        ajl();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("key_enter_recommend_pb", true);
            this.mVoiceManager = new VoiceManager();
            this.mVoiceManager.onCreate(getPageContext());
            g(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.cyb && !this.cyc) {
            this.cyb = true;
            showLoadingView(this.cxP, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aNj;
    }

    private void Qh() {
        this.aJm = (NavigationBar) findViewById(n.f.view_navigation_bar);
        if (this.aJm != null) {
            this.aJm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
            this.aJm.setTitleText(n.i.chosen_pb_title);
            this.cxV = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.chosen_pb_reply_layout, (ViewGroup) null);
            this.cxU = (TextView) this.cxV.findViewById(n.f.chosen_pb_reply_number);
            this.aJm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cxV, new j(this));
        }
    }

    private void ajl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.aXY != null) {
                this.aXY.onActivityResult(i, i2, intent);
            }
            switch (i) {
                case 23003:
                    t.a(this, this.chosenData, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
                    return;
                case 23007:
                    t.a(this, this.chosenData, intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"), this.shareUrl);
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
        if (this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().excid != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_new_duration", null, 1, "duration", new StringBuilder(String.valueOf(SystemClock.elapsedRealtime() - this.startTime)).toString(), PbChosenActivityConfig.KEY_TID, this.chosenData.getThreadInfo().excid);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    private com.baidu.tbadk.editortools.d.a<PbChosenActivity> ajm() {
        if (this.aXZ == null) {
            this.aXZ = new k(this, getPageContext());
        }
        return this.aXZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().af(i == 1);
        getPageContext().getLayoutMode().k(this.cxQ.ajq());
        getPageContext().getLayoutMode().k(this.cxR.ajr());
        this.cxS.tH();
        this.cxT.tH();
        if (this.aJm != null) {
            this.aJm.onChangeSkinType(getPageContext(), i);
        }
        if (this.aXY != null && this.aXY.Bu() != null) {
            this.aXY.Bu().onChangeSkinType(i);
        }
        as.j(this.cxP, n.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.aXY == null || this.aXY.Bu() == null || !this.aXY.Bu().Bx()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.aXY.Bu().zY();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aXY != null) {
            this.aXY.onSaveInstanceState(bundle);
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
        if (this.aXY != null) {
            this.aXY.onDestroy();
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    private void g(Bundle bundle) {
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.a(ajm());
        this.aXY = (com.baidu.tbadk.editortools.d.e) nVar.al(getActivity());
        this.aXY.b(this);
        this.aXY.a(this.asP);
        this.aXY.a(this.asJ);
        this.aXY.a(this, bundle);
        h(this.aXY);
    }

    private void h(com.baidu.tbadk.editortools.d.e eVar) {
        if (eVar.Bu() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cxP.addView(eVar.Bu(), layoutParams);
            eVar.Bu().hide();
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
