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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.pb.chosen.a.d;
import com.baidu.tieba.pb.chosen.a.e;
import com.baidu.tieba.pb.chosen.a.i;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.a;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private NavigationBar aLP;
    private BdListView aTj;
    private com.baidu.tbadk.editortools.d.e bej;
    private com.baidu.tbadk.editortools.d.a<PbChosenActivity> bek;
    private VoiceManager ben;
    private RelativeLayout cIc;
    private com.baidu.tieba.pb.chosen.a.e cId;
    private com.baidu.tieba.pb.chosen.a.i cIe;
    private com.baidu.tieba.pb.chosen.a.d cIf;
    private com.baidu.tieba.pb.chosen.a.l cIg;
    private TextView cIh;
    private View cIi;
    private com.baidu.tieba.pb.chosen.a.a cIj;
    private com.baidu.tieba.tbadkCore.w cIk;
    private com.baidu.tieba.pb.chosen.net.zan.a cIl;
    private com.baidu.tieba.pb.chosen.net.b cIm;
    private t cIn;
    private boolean cIo;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private long startTime;
    private String shareUrl = null;
    private boolean bbv = false;
    private boolean cIp = false;
    private int from = 1;
    private int cIq = -1;
    private final AbsListView.OnScrollListener beo = new a(this);
    private com.baidu.tbadk.editortools.d.c avf = new l(this);
    private View.OnClickListener cIr = new m(this);
    private final a.d avl = new n(this);
    private d.a cIs = new o(this);
    private View.OnClickListener cIt = new p(this);
    private CustomMessageListener bgl = new q(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener cIu = new r(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private i.a cIv = new s(this);
    private e.b cIw = new b(this);
    private com.baidu.adp.framework.listener.a ass = new d(this, CmdConfigHttp.CMD_GET_FINE_PB, 309093);
    private CustomMessageListener cIx = new e(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private com.baidu.adp.framework.listener.a cIy = new f(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095);
    private CustomMessageListener cIz = new g(this, CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.cId.fc(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (getIntent() != null) {
            long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            long longExtra2 = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
            long longExtra3 = getIntent().getLongExtra("thread_id", 0L);
            if (this.cIm == null) {
                this.cIm = new com.baidu.tieba.pb.chosen.net.b();
            }
            this.cIm.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.cIc);
            showLoadingView(this.cIc, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.cIc);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.cIc, getResources().getString(t.j.error_unkown_try_again), true);
            this.cIg.setVisible(false);
            return;
        }
        this.bbv = true;
        this.cIg.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.cId.a(userInfo);
        }
        if (this.cIf != null) {
            this.cIf.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.cIh != null && threadInfo.post_num != null) {
                String y = aw.y(threadInfo.post_num.longValue());
                this.cIh.setText(getResources().getString(t.j.chosen_pb_reply_number_text, y));
                this.cIg.kw(getResources().getString(t.j.chosen_pb_reply_count_text, y));
            }
            this.cIe.a(threadInfo);
            this.cId.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.d.a aVar2 = new com.baidu.tieba.pb.d.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.cIj.bm(aVar2.getData());
            this.cIj.notifyDataSetChanged();
        }
        this.aTj.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(t.h.chosen_pb_layout);
        this.cIc = (RelativeLayout) findViewById(t.g.chosen_pb_root);
        this.aTj = (BdListView) findViewById(t.g.chosen_pb_listview);
        this.aTj.setOnTouchListener(new h(this));
        this.aTj.setOnScrollListener(this.beo);
        this.cIj = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.aTj.setAdapter((ListAdapter) this.cIj);
        this.cIg = new com.baidu.tieba.pb.chosen.a.l(findViewById(t.g.chosen_pb_reply));
        this.cIg.F(this.cIr);
        this.cIg.G(this.cIt);
        this.cId = new com.baidu.tieba.pb.chosen.a.e(getPageContext().getPageActivity());
        this.cIe = new com.baidu.tieba.pb.chosen.a.i(getPageContext().getPageActivity());
        this.cIf = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity(), this.cIs);
        this.cId.a(this.cIw);
        this.cIe.a(this.cIv);
        this.aTj.addHeaderView(this.cId.aow());
        this.aTj.addFooterView(this.cIe.aox());
        this.aTj.addFooterView(this.cIf.getView());
        SG();
        registerListener(this.cIy);
        registerListener(this.cIx);
        this.cIz.setSelfListener(true);
        registerListener(this.cIz);
        registerListener(this.ass);
        registerListener(this.bgl);
        registerListener(this.cIu);
        aoq();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("key_enter_recommend_pb", true);
            this.ben = new VoiceManager();
            this.ben.onCreate(getPageContext());
            d(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.cIo && !this.cIp) {
            this.cIo = true;
            showLoadingView(this.cIc, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aTj;
    }

    private void SG() {
        this.aLP = (NavigationBar) findViewById(t.g.view_navigation_bar);
        if (this.aLP != null) {
            this.aLP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
            this.aLP.setTitleText(t.j.chosen_pb_title);
            this.cIi = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.chosen_pb_reply_layout, (ViewGroup) null);
            this.cIh = (TextView) this.cIi.findViewById(t.g.chosen_pb_reply_number);
            this.aLP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cIi, new j(this));
        }
    }

    private void aoq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.bej != null) {
                this.bej.onActivityResult(i, i2, intent);
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
        if (this.ben != null) {
            this.ben.onStop(getPageContext());
        }
    }

    private com.baidu.tbadk.editortools.d.a<PbChosenActivity> aor() {
        if (this.bek == null) {
            this.bek = new k(this, getPageContext());
        }
        return this.bek;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().ac(i == 1);
        getPageContext().getLayoutMode().x(this.cId.aow());
        getPageContext().getLayoutMode().x(this.cIe.aox());
        this.cIf.uv();
        this.cIg.uv();
        if (this.aLP != null) {
            this.aLP.onChangeSkinType(getPageContext(), i);
        }
        if (this.bej != null && this.bej.Cz() != null) {
            this.bej.Cz().onChangeSkinType(i);
        }
        ar.l(this.cIc, t.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.bej == null || this.bej.Cz() == null || !this.bej.Cz().CC()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.bej.Cz().Ba();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bej != null) {
            this.bej.onSaveInstanceState(bundle);
        }
        if (this.ben != null) {
            this.ben.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.ben != null) {
            this.ben.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ben != null) {
            this.ben.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ben != null) {
            this.ben.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bej != null) {
            this.bej.onDestroy();
        }
        if (this.ben != null) {
            this.ben.onDestory(getPageContext());
        }
    }

    private void d(Bundle bundle) {
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.a(aor());
        this.bej = (com.baidu.tbadk.editortools.d.e) nVar.ak(getActivity());
        this.bej.d(this);
        this.bej.a(this.avl);
        this.bej.a(this.avf);
        this.bej.a(this, bundle);
        h(this.bej);
    }

    private void h(com.baidu.tbadk.editortools.d.e eVar) {
        if (eVar.Cz() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cIc.addView(eVar.Cz(), layoutParams);
            eVar.Cz().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ben;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
