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
    private NavigationBar aKK;
    private BdListView aRc;
    private com.baidu.tbadk.editortools.d.e bbY;
    private com.baidu.tbadk.editortools.d.a<PbChosenActivity> bbZ;
    private com.baidu.tieba.pb.chosen.a.l cBA;
    private TextView cBB;
    private View cBC;
    private com.baidu.tieba.pb.chosen.a.a cBD;
    private com.baidu.tieba.tbadkCore.x cBE;
    private com.baidu.tieba.pb.chosen.net.zan.a cBF;
    private com.baidu.tieba.pb.chosen.net.b cBG;
    private t cBH;
    private boolean cBI;
    private RelativeLayout cBw;
    private com.baidu.tieba.pb.chosen.a.e cBx;
    private com.baidu.tieba.pb.chosen.a.i cBy;
    private com.baidu.tieba.pb.chosen.a.d cBz;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager mVoiceManager;
    private long startTime;
    private String shareUrl = null;
    private boolean aZg = false;
    private boolean cBJ = false;
    private int from = 1;
    private int cBK = -1;
    private final AbsListView.OnScrollListener bcc = new a(this);
    private com.baidu.tbadk.editortools.d.c aun = new l(this);
    private View.OnClickListener cBL = new m(this);
    private final a.d aut = new n(this);
    private d.a cBM = new o(this);
    private View.OnClickListener cBN = new p(this);
    private CustomMessageListener cBO = new q(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener cBP = new r(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private i.a cBQ = new s(this);
    private e.b cBR = new b(this);
    private com.baidu.adp.framework.listener.a arz = new d(this, CmdConfigHttp.CMD_GET_FINE_PB, 309093);
    private CustomMessageListener cBS = new e(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private com.baidu.adp.framework.listener.a cBT = new f(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095);
    private CustomMessageListener cBU = new g(this, CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.cBx.eO(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (getIntent() != null) {
            long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            long longExtra2 = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
            long longExtra3 = getIntent().getLongExtra("thread_id", 0L);
            if (this.cBG == null) {
                this.cBG = new com.baidu.tieba.pb.chosen.net.b();
            }
            this.cBG.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.cBw);
            showLoadingView(this.cBw, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.cBw);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.cBw, getResources().getString(n.j.error_unkown_try_again), true);
            this.cBA.setVisible(false);
            return;
        }
        this.aZg = true;
        this.cBA.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.cBx.a(userInfo);
        }
        if (this.cBz != null) {
            this.cBz.b(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.cBB != null && threadInfo.post_num != null) {
                String x = ax.x(threadInfo.post_num.longValue());
                this.cBB.setText(getResources().getString(n.j.chosen_pb_reply_number_text, x));
                this.cBA.ks(getResources().getString(n.j.chosen_pb_reply_count_text, x));
            }
            this.cBy.a(threadInfo);
            this.cBx.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.c.a aVar2 = new com.baidu.tieba.pb.c.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.cBD.bl(aVar2.getData());
            this.cBD.notifyDataSetChanged();
        }
        this.aRc.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(n.h.chosen_pb_layout);
        this.cBw = (RelativeLayout) findViewById(n.g.chosen_pb_root);
        this.aRc = (BdListView) findViewById(n.g.chosen_pb_listview);
        this.aRc.setOnTouchListener(new h(this));
        this.aRc.setOnScrollListener(this.bcc);
        this.cBD = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aRc.setAdapter((ListAdapter) this.cBD);
        this.cBA = new com.baidu.tieba.pb.chosen.a.l(findViewById(n.g.chosen_pb_reply));
        this.cBA.z(this.cBL);
        this.cBA.A(this.cBN);
        this.cBx = new com.baidu.tieba.pb.chosen.a.e(getPageContext().getPageActivity());
        this.cBy = new com.baidu.tieba.pb.chosen.a.i(getPageContext().getPageActivity());
        this.cBz = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity(), this.cBM);
        this.cBx.a(this.cBR);
        this.cBy.a(this.cBQ);
        this.aRc.addHeaderView(this.cBx.aky());
        this.aRc.addFooterView(this.cBy.akz());
        this.aRc.addFooterView(this.cBz.getView());
        Qz();
        registerListener(this.cBT);
        registerListener(this.cBS);
        this.cBU.setSelfListener(true);
        registerListener(this.cBU);
        registerListener(this.arz);
        registerListener(this.cBO);
        registerListener(this.cBP);
        aks();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("key_enter_recommend_pb", true);
            this.mVoiceManager = new VoiceManager();
            this.mVoiceManager.onCreate(getPageContext());
            c(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.cBI && !this.cBJ) {
            this.cBI = true;
            showLoadingView(this.cBw, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aRc;
    }

    private void Qz() {
        this.aKK = (NavigationBar) findViewById(n.g.view_navigation_bar);
        if (this.aKK != null) {
            this.aKK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
            this.aKK.setTitleText(n.j.chosen_pb_title);
            this.cBC = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.chosen_pb_reply_layout, (ViewGroup) null);
            this.cBB = (TextView) this.cBC.findViewById(n.g.chosen_pb_reply_number);
            this.aKK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cBC, new j(this));
        }
    }

    private void aks() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.bbY != null) {
                this.bbY.onActivityResult(i, i2, intent);
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

    private com.baidu.tbadk.editortools.d.a<PbChosenActivity> akt() {
        if (this.bbZ == null) {
            this.bbZ = new k(this, getPageContext());
        }
        return this.bbZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().ac(i == 1);
        getPageContext().getLayoutMode().k(this.cBx.aky());
        getPageContext().getLayoutMode().k(this.cBy.akz());
        this.cBz.tr();
        this.cBA.tr();
        if (this.aKK != null) {
            this.aKK.onChangeSkinType(getPageContext(), i);
        }
        if (this.bbY != null && this.bbY.Bj() != null) {
            this.bbY.Bj().onChangeSkinType(i);
        }
        as.j(this.cBw, n.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.bbY == null || this.bbY.Bj() == null || !this.bbY.Bj().Bm()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.bbY.Bj().zK();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bbY != null) {
            this.bbY.onSaveInstanceState(bundle);
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
        if (this.bbY != null) {
            this.bbY.onDestroy();
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    private void c(Bundle bundle) {
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.a(akt());
        this.bbY = (com.baidu.tbadk.editortools.d.e) nVar.ak(getActivity());
        this.bbY.d(this);
        this.bbY.a(this.aut);
        this.bbY.a(this.aun);
        this.bbY.a(this, bundle);
        h(this.bbY);
    }

    private void h(com.baidu.tbadk.editortools.d.e eVar) {
        if (eVar.Bj() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cBw.addView(eVar.Bj(), layoutParams);
            eVar.Bj().hide();
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
