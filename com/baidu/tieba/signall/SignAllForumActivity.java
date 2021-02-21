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
/* loaded from: classes8.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a acU;
    private j nod;
    private GetForumListModel noe;
    private SignAllForumModel nof;
    private boolean nog;
    private boolean noh;
    private boolean noi = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long mtz = 0;
    private boolean mIsFromSchema = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.nod.dLq().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener noj = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dLs;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dLs = SignAllForumActivity.this.nod.dLs()) != null) {
                dLs.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.nod.dLt().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a nok = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.nod.completeRefresh();
            a dKF = cVar.dKF();
            if (dKF != null) {
                if (dKF.getErrorNumber() == 0) {
                    SignAllForumActivity.this.nod.a(cVar, SignAllForumActivity.this.noe.dKX());
                } else {
                    SignAllForumActivity.this.showToast(dKF.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.mtz);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.N(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void MV(String str) {
            SignAllForumActivity.this.nod.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a nol = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void MV(String str) {
            SignAllForumActivity.this.SN(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.noi) {
                    SignAllForumActivity.this.noi = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqD();
                    if (SignAllForumActivity.this.nod != null && SignAllForumActivity.this.nod.dLq() != null) {
                        SignAllForumActivity.this.nod.dLq().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a dKF = hVar.dKF();
                if (dKF != null) {
                    if (dKF.getErrorNumber() == 0) {
                        c dLs = SignAllForumActivity.this.nod.dLs();
                        dLs.a(hVar);
                        if (SignAllForumActivity.this.nog) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dLs.dKM()), Integer.valueOf(dLs.dKN())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.noh) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.nod.dLt().notifyDataSetChanged();
                        SignAllForumProgressView dLq = SignAllForumActivity.this.nod.dLq();
                        if (!dLs.dKL()) {
                            if (hVar.dLe() != 0) {
                                SignAllForumActivity.this.SO(hVar.dKD());
                                SignAllForumActivity.this.acU.bqx();
                            } else if (hVar.dLg() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dLh());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.acU == null || !SignAllForumActivity.this.acU.isShowing()) {
                            SignAllForumActivity.this.dKZ();
                        }
                        dLq.setSignSuccess();
                        SignAllForumActivity.this.b(dLs);
                        return;
                    }
                    SignAllForumActivity.this.SN(dKF.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dKZ() {
        if (this.nod != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.byA().a(getPageContext(), this.nod.cnu());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String dKu = cVar.dKu();
            final String bEY = cVar.bEY();
            final boolean dKI = cVar.dKI();
            if (cVar.dKt()) {
                this.nod.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), dKu, bEY, Boolean.valueOf(dKI))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SN(String str) {
        if (this.nog) {
            c dLs = this.nod.dLs();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dLs.dKH().size())});
            a(str, activity, false);
            if (this.noh) {
                return;
            }
        }
        showToast(str);
        this.nod.dLq().setSignSuccess();
        ArrayList<d> dKH = this.nod.dLs().dKH();
        int size = dKH.size();
        for (int i = 0; i < size; i++) {
            d dVar = dKH.get(i);
            dVar.yd(true);
            dVar.ye(false);
            dVar.yc(false);
        }
        this.nod.dLt().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void bxF() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kB().bo("MainTabActivity")) {
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
        bxF();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.noj);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    private void initUI() {
        this.nod = new j(this);
        this.nod.setListPullRefreshListener(this);
        this.nod.setOnItemClickListener(this);
        if (this.nof.isRunning) {
            this.nok.a(this.nof.dLk());
            this.nod.dLq().setSigning(90);
            return;
        }
        this.nod.startPullRefresh();
    }

    private void initData() {
        this.noe = new GetForumListModel(this);
        this.noe.a(this.nok);
        this.nof = new SignAllForumModel(this);
        this.nof.a(this.nol);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nod.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.mtz = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.nod.completeRefresh();
        } else if (this.noe == null) {
            showToast(R.string.neterror);
        } else if (!this.noe.LoadData()) {
            this.nod.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dLs = this.nod.dLs();
        if (view == this.nod.getProgressBar()) {
            if (dLs != null) {
                if (dLs.getBlockPopInfoData() != null) {
                    if (dLs.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dLs.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqD();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dLs.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_SIGN));
                    }
                } else if (this.nod.dLq().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dLs.dKC() != 0) {
                        SO(dLs.dKD());
                        this.acU.bqx();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.noi = true;
                        dLa();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.nod.dLu()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void dLa() {
        c dLs = this.nod.dLs();
        this.nod.dLq().setDuration(Math.max(dLs.dKH().size() * 50, 2000));
        this.nod.dLq().setSigning(0);
        this.nof.d(dLs);
        this.nof.LoadData();
        this.nod.dLt().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.nod.dLt().getItemViewType(i) == 0 && this.nod.dLs() != null && this.nod.dLs().dKE() != null && this.nod.dLs().dKE().size() > i && (dVar = this.nod.dLs().dKE().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SO(String str) {
        this.acU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Au(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.acU.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nof != null && this.nof.isRunning) {
            dLb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.noh = true;
        if (this.acU != null && this.acU.isShowing()) {
            this.acU.dismiss();
        }
        if (this.noe != null) {
            this.noe.cancelLoadData();
            this.noe = null;
        }
        if (this.nod != null && this.nod.dLt() != null) {
            this.nod.dLt().dLc();
        }
        if (this.nof != null) {
            if (this.nof.isRunning) {
                dLb();
            }
            this.nof.cancelMessage();
            this.nof = null;
        }
        if (this.noe != null) {
            this.noe.cancelLoadData();
            this.noe = null;
        }
    }

    private void dLb() {
        this.nog = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public q onGetPreLoadListView() {
        if (this.nod == null || this.nod.dLr() == null) {
            return null;
        }
        return this.nod.dLr().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void N(long j, long j2) {
        if (com.baidu.tbadk.n.k.bEg().isSmallFlow() && this.creatTime > 0) {
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1009, true, this.noe.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (hVar != null) {
                hVar.bEd();
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
                    if (this.nod != null) {
                        this.nod.startPullRefresh();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
