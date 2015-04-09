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
    private TextView aBu;
    private NavigationBar anu;
    private PullToRefreshScrollView bFT;
    private ScrollView bFU;
    private View bFV;
    private com.baidu.tieba.pb.chosen.a.a bFW;
    private com.baidu.tieba.pb.chosen.a.e bFX;
    private TbRichView bFY;
    private boolean bFZ;
    private Animation bGa;
    private Animation bGb;
    private com.baidu.tieba.pb.chosen.net.zan.a bGc;
    private n bGd;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private View rootView;
    private long startTime;
    private String shareUrl = null;
    private boolean aGQ = false;
    private boolean bGe = false;
    private com.baidu.tieba.pb.chosen.widget.c bGf = new a(this);
    private com.baidu.adp.lib.g.e bGg = new f(this);
    private com.baidu.tieba.pb.chosen.a.i bGh = new g(this);
    private com.baidu.tieba.pb.chosen.a.d bGi = new h(this);
    private com.baidu.adp.framework.listener.a ahI = new i(this, CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    private com.baidu.adp.framework.listener.a bGj = new j(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    private CustomMessageListener bGk = new k(this, 2001321);

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        ai(getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L));
        hideNetRefreshView(this.rootView);
        showLoadingView(this.rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        if (aVar != null) {
            this.bFT.setVisibility(0);
            this.aGQ = true;
            hideLoadingView(this.rootView);
            this.chosenData = aVar;
            User_Info userInfo = aVar.getUserInfo();
            if (userInfo != null) {
                this.bFW.a(userInfo);
            }
            ForumInfo forumInfo = aVar.getForumInfo();
            if (forumInfo != null) {
                this.bFX.a(forumInfo);
                com.baidu.tieba.pb.richview.b bVar = new com.baidu.tieba.pb.richview.b(getPageContext().getPageActivity());
                bVar.aT(aVar.getForumInfo().content);
                this.bFY.P(bVar.getData());
                this.aBu.setText(forumInfo.title);
                this.bFW.hD(forumInfo.tag);
            }
            this.bFV.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.chosen_pb_view);
        this.bFT = (PullToRefreshScrollView) findViewById(v.chosen_pb_content_group);
        this.bFT.setPullToRefreshEnabled(false);
        this.bFU = this.bFT.getRefreshableView();
        this.bFU.setFillViewport(true);
        this.bFV = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), w.chosen_pb_layout, null);
        this.bFU.addView(this.bFV, new FrameLayout.LayoutParams(-1, -1));
        this.rootView = findViewById(v.chosen_pb_decor_view);
        this.bFV.setVisibility(8);
        this.bFW = new com.baidu.tieba.pb.chosen.a.a(findViewById(v.chosen_pb_person_layout));
        this.bFX = new com.baidu.tieba.pb.chosen.a.e(getBaseContext(), findViewById(v.chosen_pb_post_layout));
        this.bFW.a(this.bGi);
        this.bFX.a(this.bGh);
        this.aBu = (TextView) findViewById(v.chosen_pb_title);
        YJ();
        this.anu = (NavigationBar) findViewById(v.view_navigation_bar);
        LH();
        this.bFT.setOnRefreshListener(this.bGf);
        YK();
        registerListener(this.bGj);
        registerListener(this.bGk);
        YP();
        this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
        this.startTime = SystemClock.elapsedRealtime();
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("key_enter_recommend_pb", true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bFZ && !this.bGe) {
            this.bFZ = true;
            showLoadingView(this.rootView, true);
        }
    }

    private void YJ() {
        this.bFY = (TbRichView) findViewById(v.chosen_pb_rich_text);
        com.baidu.tieba.pb.richview.c cVar = new com.baidu.tieba.pb.richview.c();
        cVar.a(new com.baidu.tieba.pb.richview.b.b(getPageContext().getPageActivity()));
        cVar.a(new com.baidu.tieba.pb.richview.b.e(getPageContext().getPageActivity()));
        this.bFY.setViewProxy(cVar);
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

    private void YK() {
        YO();
        YN();
        registerListener(this.ahI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YL() {
        if (this.bGa == null) {
            this.bGa = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.chosen_pb_pull_down_anim);
            this.bGa.setAnimationListener(this.bGg);
        }
        return this.bGa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YM() {
        if (this.bGb == null) {
            this.bGb = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.chosen_pb_drag_up_anim);
            this.bGb.setAnimationListener(this.bGg);
        }
        return this.bGb;
    }

    private void YN() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(307003);
        bVar.setResponsedClass(ChosenPbSocketResponse.class);
        bVar.i(true);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void YO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, com.baidu.tieba.tbadkCore.a.a.R(TbConfig.FINE_PB_PAGE, 307003));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void LH() {
        if (this.anu != null) {
            this.anu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
            this.anu.setTitleText(y.chosen_pb_title);
            this.anu.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.chosen_pb_share, new m(this));
        }
    }

    private void YP() {
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
        if (this.anu != null) {
            this.anu.onChangeSkinType(getPageContext(), i);
        }
        if (this.bFT != null) {
            this.bFT.YY();
        }
    }
}
