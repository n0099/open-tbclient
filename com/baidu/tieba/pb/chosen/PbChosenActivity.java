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
    private NavigationBar aGn;
    private BdListView aII;
    private com.baidu.tbadk.editortools.c.e aSK;
    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> aSL;
    private s cfA;
    private boolean cfB;
    private RelativeLayout cfp;
    private com.baidu.tieba.pb.chosen.a.e cfq;
    private com.baidu.tieba.pb.chosen.a.i cfr;
    private com.baidu.tieba.pb.chosen.a.d cfs;
    private com.baidu.tieba.pb.chosen.a.m cft;
    private TextView cfu;
    private View cfv;
    private com.baidu.tieba.pb.chosen.a.a cfw;
    private com.baidu.tieba.tbadkCore.w cfx;
    private com.baidu.tieba.pb.chosen.net.zan.a cfy;
    private com.baidu.tieba.pb.chosen.net.b cfz;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager mVoiceManager;
    private long startTime;
    private String shareUrl = null;
    private boolean aQd = false;
    private boolean cfC = false;
    private int from = 1;
    private final AbsListView.OnScrollListener aSP = new a(this);
    private com.baidu.tbadk.editortools.c.c aqG = new k(this);
    private View.OnClickListener cfD = new l(this);
    private final a.d aqM = new m(this);
    private d.a cfE = new n(this);
    private View.OnClickListener cfF = new o(this);
    private CustomMessageListener cfG = new p(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener cfH = new q(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private i.a cfI = new r(this);
    private e.b cfJ = new b(this);
    private com.baidu.adp.framework.listener.a aof = new d(this, CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    private com.baidu.adp.framework.listener.a cfK = new e(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    private CustomMessageListener cfL = new f(this, CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getForumInfo() != null && this.chosenData.getForumInfo().fromfid != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getForumInfo().fromfid.longValue()) {
                this.cfq.en(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        if (this.cfz == null) {
            this.cfz = new com.baidu.tieba.pb.chosen.net.b();
        }
        this.cfz.a(this, longExtra);
        hideNetRefreshView(this.cfp);
        showLoadingView(this.cfp, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.cfp);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.cfp, getResources().getString(i.h.error_unkown_try_again), true);
            this.cft.setVisible(false);
            return;
        }
        this.aQd = true;
        this.cft.setVisible(true);
        this.chosenData = aVar;
        User_Info userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.cfq.a(userInfo);
        }
        if (this.cfs != null) {
            this.cfs.b(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ForumInfo forumInfo = aVar.getForumInfo();
        if (forumInfo != null) {
            if (this.cfu != null && forumInfo.threadsnum != null) {
                String q = as.q(forumInfo.threadsnum.longValue());
                this.cfu.setText(getResources().getString(i.h.chosen_pb_reply_number_text, q));
                this.cft.jH(getResources().getString(i.h.chosen_pb_reply_count_text, q));
            }
            this.cfr.a(forumInfo);
            this.cfr.aV(forumInfo.tag, forumInfo.tagabstract);
            this.cfq.a(getPageContext().getPageActivity(), forumInfo);
            com.baidu.tieba.pb.c.a aVar2 = new com.baidu.tieba.pb.c.a();
            aVar2.a(getPageContext(), aVar.getForumInfo().content);
            this.cfw.bd(aVar2.getData());
            this.cfw.notifyDataSetChanged();
        }
        this.aII.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(i.g.chosen_pb_layout);
        this.cfp = (RelativeLayout) findViewById(i.f.chosen_pb_root);
        this.aII = (BdListView) findViewById(i.f.chosen_pb_listview);
        this.aII.setOnTouchListener(new g(this));
        this.aII.setOnScrollListener(this.aSP);
        this.cfw = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aII.setAdapter((ListAdapter) this.cfw);
        this.cft = new com.baidu.tieba.pb.chosen.a.m(findViewById(i.f.chosen_pb_reply));
        this.cft.z(this.cfD);
        this.cft.A(this.cfF);
        this.cfq = new com.baidu.tieba.pb.chosen.a.e(getPageContext().getPageActivity());
        this.cfr = new com.baidu.tieba.pb.chosen.a.i(getPageContext().getPageActivity());
        this.cfs = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity(), this.cfE);
        this.cfq.a(this.cfJ);
        this.cfr.a(this.cfI);
        this.aII.addHeaderView(this.cfq.aeY());
        this.aII.addFooterView(this.cfr.aeZ());
        this.aII.addFooterView(this.cfs.getView());
        OC();
        registerListener(this.cfK);
        registerListener(this.cfL);
        registerListener(this.aof);
        registerListener(this.cfG);
        registerListener(this.cfH);
        aeT();
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
        if (z && !this.cfB && !this.cfC) {
            this.cfB = true;
            showLoadingView(this.cfp, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aII;
    }

    private void OC() {
        this.aGn = (NavigationBar) findViewById(i.f.view_navigation_bar);
        if (this.aGn != null) {
            this.aGn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
            this.aGn.setTitleText(i.h.chosen_pb_title);
            this.cfv = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.chosen_pb_reply_layout, (ViewGroup) null);
            this.cfu = (TextView) this.cfv.findViewById(i.f.chosen_pb_reply_number);
            this.aGn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cfv, new i(this));
        }
    }

    private void aeT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE), customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.aSK != null) {
                this.aSK.onActivityResult(i, i2, intent);
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

    private com.baidu.tbadk.editortools.c.a<PbChosenActivity> aeU() {
        if (this.aSL == null) {
            this.aSL = new j(this, getPageContext());
        }
        return this.aSL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().ad(i == 1);
        getPageContext().getLayoutMode().k(this.cfq.aeY());
        getPageContext().getLayoutMode().k(this.cfr.aeZ());
        this.cfs.tc();
        this.cft.tc();
        if (this.aGn != null) {
            this.aGn.onChangeSkinType(getPageContext(), i);
        }
        if (this.aSK != null && this.aSK.Az() != null) {
            this.aSK.Az().onChangeSkinType(i);
        }
        an.j(this.cfp, i.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.aSK == null || this.aSK.Az() == null || !this.aSK.Az().AC()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.aSK.Az().zc();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aSK != null) {
            this.aSK.onSaveInstanceState(bundle);
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
        if (this.aSK != null) {
            this.aSK.onDestroy();
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    private void g(Bundle bundle) {
        com.baidu.tbadk.editortools.c.n nVar = new com.baidu.tbadk.editortools.c.n();
        nVar.a(aeU());
        this.aSK = (com.baidu.tbadk.editortools.c.e) nVar.ak(getActivity());
        this.aSK.b(this);
        this.aSK.a(this.aqM);
        this.aSK.a(this.aqG);
        this.aSK.a(this, bundle);
        h(this.aSK);
    }

    private void h(com.baidu.tbadk.editortools.c.e eVar) {
        if (eVar.Az() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cfp.addView(eVar.Az(), layoutParams);
            eVar.Az().hide();
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
