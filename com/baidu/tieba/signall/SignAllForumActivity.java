package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a aeo;
    private j nqj;
    private GetForumListModel nqk;
    private SignAllForumModel nql;
    private boolean nqm;
    private boolean nqn;
    private boolean nqo = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long mvB = 0;
    private boolean mIsFromSchema = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.nqj.dLy().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener nqp = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dLA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dLA = SignAllForumActivity.this.nqj.dLA()) != null) {
                dLA.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.nqj.dLB().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a nqq = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.nqj.completeRefresh();
            a dKN = cVar.dKN();
            if (dKN != null) {
                if (dKN.getErrorNumber() == 0) {
                    SignAllForumActivity.this.nqj.a(cVar, SignAllForumActivity.this.nqk.dLf());
                } else {
                    SignAllForumActivity.this.showToast(dKN.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.mvB);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.N(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Nb(String str) {
            SignAllForumActivity.this.nqj.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a nqr = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Nb(String str) {
            SignAllForumActivity.this.ST(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.nqo) {
                    SignAllForumActivity.this.nqo = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqF();
                    if (SignAllForumActivity.this.nqj != null && SignAllForumActivity.this.nqj.dLy() != null) {
                        SignAllForumActivity.this.nqj.dLy().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a dKN = hVar.dKN();
                if (dKN != null) {
                    if (dKN.getErrorNumber() == 0) {
                        c dLA = SignAllForumActivity.this.nqj.dLA();
                        dLA.a(hVar);
                        if (SignAllForumActivity.this.nqm) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dLA.dKU()), Integer.valueOf(dLA.dKV())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.nqn) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.nqj.dLB().notifyDataSetChanged();
                        SignAllForumProgressView dLy = SignAllForumActivity.this.nqj.dLy();
                        if (!dLA.dKT()) {
                            if (hVar.dLm() != 0) {
                                SignAllForumActivity.this.SU(hVar.dKL());
                                SignAllForumActivity.this.aeo.bqz();
                            } else if (hVar.dLo() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dLp());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.aeo == null || !SignAllForumActivity.this.aeo.isShowing()) {
                            SignAllForumActivity.this.dLh();
                        }
                        dLy.setSignSuccess();
                        SignAllForumActivity.this.b(dLA);
                        return;
                    }
                    SignAllForumActivity.this.ST(dKN.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dLh() {
        if (this.nqj != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.byD().a(getPageContext(), this.nqj.cnA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String dKC = cVar.dKC();
            final String bFc = cVar.bFc();
            final boolean dKQ = cVar.dKQ();
            if (cVar.dKB()) {
                this.nqj.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), dKC, bFc, Boolean.valueOf(dKQ))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ST(String str) {
        if (this.nqm) {
            c dLA = this.nqj.dLA();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dLA.dKP().size())});
            a(str, activity, false);
            if (this.nqn) {
                return;
            }
        }
        showToast(str);
        this.nqj.dLy().setSignSuccess();
        ArrayList<d> dKP = this.nqj.dLA().dKP();
        int size = dKP.size();
        for (int i = 0; i < size; i++) {
            d dVar = dKP.get(i);
            dVar.yd(true);
            dVar.ye(false);
            dVar.yc(false);
        }
        this.nqj.dLB().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void bxI() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kB().bs("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bh.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        bxI();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.nqp);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    private void initUI() {
        this.nqj = new j(this);
        this.nqj.setListPullRefreshListener(this);
        this.nqj.setOnItemClickListener(this);
        if (this.nql.isRunning) {
            this.nqq.a(this.nql.dLs());
            this.nqj.dLy().setSigning(90);
            return;
        }
        this.nqj.startPullRefresh();
    }

    private void initData() {
        this.nqk = new GetForumListModel(this);
        this.nqk.a(this.nqq);
        this.nql = new SignAllForumModel(this);
        this.nql.a(this.nqr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nqj.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.mvB = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.nqj.completeRefresh();
        } else if (this.nqk == null) {
            showToast(R.string.neterror);
        } else if (!this.nqk.LoadData()) {
            this.nqj.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dLA = this.nqj.dLA();
        if (view == this.nqj.getProgressBar()) {
            if (dLA != null) {
                if (dLA.getBlockPopInfoData() != null) {
                    if (dLA.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dLA.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqF();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dLA.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_SIGN));
                    }
                } else if (this.nqj.dLy().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dLA.dKK() != 0) {
                        SU(dLA.dKL());
                        this.aeo.bqz();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.nqo = true;
                        dLi();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.nqj.dLC()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void dLi() {
        c dLA = this.nqj.dLA();
        this.nqj.dLy().setDuration(Math.max(dLA.dKP().size() * 50, 2000));
        this.nqj.dLy().setSigning(0);
        this.nql.d(dLA);
        this.nql.LoadData();
        this.nqj.dLB().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.nqj.dLB().getItemViewType(i) == 0 && this.nqj.dLA() != null && this.nqj.dLA().dKM() != null && this.nqj.dLA().dKM().size() > i && (dVar = this.nqj.dLA().dKM().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SU(String str) {
        this.aeo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).AB(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.aeo.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nql != null && this.nql.isRunning) {
            dLj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nqn = true;
        if (this.aeo != null && this.aeo.isShowing()) {
            this.aeo.dismiss();
        }
        if (this.nqk != null) {
            this.nqk.cancelLoadData();
            this.nqk = null;
        }
        if (this.nqj != null && this.nqj.dLB() != null) {
            this.nqj.dLB().dLk();
        }
        if (this.nql != null) {
            if (this.nql.isRunning) {
                dLj();
            }
            this.nql.cancelMessage();
            this.nql = null;
        }
        if (this.nqk != null) {
            this.nqk.cancelLoadData();
            this.nqk = null;
        }
    }

    private void dLj() {
        this.nqm = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public q onGetPreLoadListView() {
        if (this.nqj == null || this.nqj.dLz() == null) {
            return null;
        }
        return this.nqj.dLz().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void N(long j, long j2) {
        if (com.baidu.tbadk.n.k.bEk().isSmallFlow() && this.creatTime > 0) {
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1009, true, this.nqk.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (hVar != null) {
                hVar.bEh();
            }
            this.creatTime = 0L;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SDK_RENAME /* 25050 */:
                    if (this.nqj != null) {
                        this.nqj.startPullRefresh();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
