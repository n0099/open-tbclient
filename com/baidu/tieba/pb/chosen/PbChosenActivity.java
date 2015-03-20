package com.baidu.tieba.pb.chosen;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.net.ChosenPbHttpResponse;
import com.baidu.tieba.pb.chosen.net.ChosenPbNetMessage;
import com.baidu.tieba.pb.chosen.net.ChosenPbSocketResponse;
import com.baidu.tieba.pb.chosen.widget.PullToRefreshScrollView;
import com.baidu.tieba.pb.richview.TbRichView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> {
    private TextView aBm;
    private NavigationBar anm;
    private PullToRefreshScrollView bFG;
    private ScrollView bFH;
    private View bFI;
    private com.baidu.tieba.pb.chosen.a.a bFJ;
    private com.baidu.tieba.pb.chosen.a.e bFK;
    private TbRichView bFL;
    private boolean bFM;
    private Animation bFN;
    private Animation bFO;
    private com.baidu.tieba.pb.chosen.net.zan.a bFP;
    private n bFQ;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private View rootView;
    private long startTime;
    private String shareUrl = null;
    private boolean aGI = false;
    private boolean bFR = false;
    private com.baidu.tieba.pb.chosen.widget.c bFS = new a(this);
    private com.baidu.adp.lib.g.e bFT = new f(this);
    private com.baidu.tieba.pb.chosen.a.i bFU = new g(this);
    private com.baidu.tieba.pb.chosen.a.d bFV = new h(this);
    private com.baidu.adp.framework.listener.a ahA = new i(this, CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    private com.baidu.adp.framework.listener.a bFW = new j(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    private CustomMessageListener bFX = new k(this, 2001321);

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        ai(getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L));
        hideNetRefreshView(this.rootView);
        showLoadingView(this.rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        if (aVar != null) {
            this.bFG.setVisibility(0);
            this.aGI = true;
            hideLoadingView(this.rootView);
            this.chosenData = aVar;
            User_Info userInfo = aVar.getUserInfo();
            if (userInfo != null) {
                this.bFJ.a(userInfo);
            }
            ForumInfo forumInfo = aVar.getForumInfo();
            if (forumInfo != null) {
                this.bFK.a(forumInfo);
                com.baidu.tieba.pb.richview.b bVar = new com.baidu.tieba.pb.richview.b(getPageContext().getPageActivity());
                bVar.aQ(aVar.getForumInfo().content);
                this.bFL.N(bVar.getData());
                this.aBm.setText(forumInfo.title);
                this.bFJ.hA(forumInfo.tag);
            }
            this.bFI.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.chosen_pb_view);
        this.bFG = (PullToRefreshScrollView) findViewById(v.chosen_pb_content_group);
        this.bFG.setPullToRefreshEnabled(false);
        this.bFH = this.bFG.getRefreshableView();
        this.bFH.setFillViewport(true);
        this.bFI = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), w.chosen_pb_layout, null);
        this.bFH.addView(this.bFI, new FrameLayout.LayoutParams(-1, -1));
        this.rootView = findViewById(v.chosen_pb_decor_view);
        this.bFI.setVisibility(8);
        this.bFJ = new com.baidu.tieba.pb.chosen.a.a(findViewById(v.chosen_pb_person_layout));
        this.bFK = new com.baidu.tieba.pb.chosen.a.e(getBaseContext(), findViewById(v.chosen_pb_post_layout));
        this.bFJ.a(this.bFV);
        this.bFK.a(this.bFU);
        this.aBm = (TextView) findViewById(v.chosen_pb_title);
        Yx();
        this.anm = (NavigationBar) findViewById(v.view_navigation_bar);
        Lv();
        this.bFG.setOnRefreshListener(this.bFS);
        Yy();
        registerListener(this.bFW);
        registerListener(this.bFX);
        YD();
        this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
        this.startTime = SystemClock.elapsedRealtime();
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("key_enter_recommend_pb", true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bFM && !this.bFR) {
            this.bFM = true;
            showLoadingView(this.rootView, true);
        }
    }

    private void Yx() {
        this.bFL = (TbRichView) findViewById(v.chosen_pb_rich_text);
        com.baidu.tieba.pb.richview.c cVar = new com.baidu.tieba.pb.richview.c();
        cVar.a(new com.baidu.tieba.pb.richview.b.b(getPageContext().getPageActivity()));
        cVar.a(new com.baidu.tieba.pb.richview.b.e(getPageContext().getPageActivity()));
        this.bFL.setViewProxy(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(long j) {
        ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
        int M = com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity());
        chosenPbNetMessage.setQ_type(45L);
        chosenPbNetMessage.setScrH(N);
        chosenPbNetMessage.setScrW(M);
        chosenPbNetMessage.setScr_dip(M / 320.0f);
        chosenPbNetMessage.setTid(j);
        sendMessage(chosenPbNetMessage);
    }

    private void Yy() {
        YC();
        YB();
        registerListener(this.ahA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Yz() {
        if (this.bFN == null) {
            this.bFN = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.chosen_pb_pull_down_anim);
            this.bFN.setAnimationListener(this.bFT);
        }
        return this.bFN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YA() {
        if (this.bFO == null) {
            this.bFO = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.chosen_pb_drag_up_anim);
            this.bFO.setAnimationListener(this.bFT);
        }
        return this.bFO;
    }

    private void YB() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(307003);
        bVar.setResponsedClass(ChosenPbSocketResponse.class);
        bVar.i(true);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void YC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, com.baidu.tieba.tbadkCore.a.a.R(TbConfig.FINE_PB_PAGE, 307003));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Lv() {
        if (this.anm != null) {
            this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
            this.anm.setTitleText(y.chosen_pb_title);
            this.anm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.chosen_pb_share, new m(this));
        }
    }

    private void YD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001321, new com.baidu.tieba.pb.chosen.cache.b());
        MessageManager.getInstance().sendMessage(new CustomMessage(2001321), customMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 23003:
                    a(intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
                    return;
                case 23007:
                    R(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(int i, String str, int i2) {
        if (this.chosenData != null && this.chosenData.getForumInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bZ(this.chosenData.getForumInfo().title);
            com.baidu.tieba.pb.chosen.a.j jVar = new com.baidu.tieba.pb.chosen.a.j(getPageContext().getPageActivity());
            jVar.v(this.shareUrl, false);
            jVar.setTitle(this.chosenData.getForumInfo()._abstract);
            aVar.j(jVar);
            aVar.a(y.share, new b(this, jVar, i, str, i2));
            aVar.b(y.alert_no_button, new c(this, jVar));
            aVar.ad(false);
            aVar.b(getPageContext()).re();
        }
    }

    private void R(Intent intent) {
        b(intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void b(long j, String str, String str2) {
        if (this.chosenData != null && this.chosenData.getForumInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bZ(this.chosenData.getForumInfo().title);
            com.baidu.tieba.pb.chosen.a.j jVar = new com.baidu.tieba.pb.chosen.a.j(getPageContext().getPageActivity());
            jVar.setTitle(this.chosenData.getForumInfo()._abstract);
            jVar.v(this.shareUrl, false);
            aVar.j(jVar);
            aVar.a(y.share, new d(this, jVar, j, str, str2));
            aVar.b(y.alert_no_button, new e(this, jVar));
            aVar.ad(false);
            aVar.b(getPageContext()).re();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_new_duration", new StringBuilder(String.valueOf(SystemClock.elapsedRealtime() - this.startTime)).toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().X(i == 1);
        getPageContext().getLayoutMode().h(this.rootView);
        if (this.anm != null) {
            this.anm.onChangeSkinType(getPageContext(), i);
        }
        if (this.bFG != null) {
            this.bFG.YM();
        }
    }
}
