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
import com.baidu.adp.widget.ListView.t;
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
import com.baidu.tbadk.n.l;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a acq;
    private j ncT;
    private GetForumListModel ncU;
    private SignAllForumModel ncV;
    private boolean ncW;
    private boolean ncX;
    private boolean ncY = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long mjD = 0;
    private boolean mIsFromSchema = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.ncT.dMV().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener ncZ = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dMX;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dMX = SignAllForumActivity.this.ncT.dMX()) != null) {
                dMX.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.ncT.dMY().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a nda = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.ncT.completeRefresh();
            a dMk = cVar.dMk();
            if (dMk != null) {
                if (dMk.getErrorNumber() == 0) {
                    SignAllForumActivity.this.ncT.a(cVar, SignAllForumActivity.this.ncU.dMC());
                } else {
                    SignAllForumActivity.this.showToast(dMk.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.mjD);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.G(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Nu(String str) {
            SignAllForumActivity.this.ncT.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a ndb = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Nu(String str) {
            SignAllForumActivity.this.Td(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.ncY) {
                    SignAllForumActivity.this.ncY = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).brB();
                    if (SignAllForumActivity.this.ncT != null && SignAllForumActivity.this.ncT.dMV() != null) {
                        SignAllForumActivity.this.ncT.dMV().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a dMk = hVar.dMk();
                if (dMk != null) {
                    if (dMk.getErrorNumber() == 0) {
                        c dMX = SignAllForumActivity.this.ncT.dMX();
                        dMX.a(hVar);
                        if (SignAllForumActivity.this.ncW) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dMX.dMr()), Integer.valueOf(dMX.dMs())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.ncX) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.ncT.dMY().notifyDataSetChanged();
                        SignAllForumProgressView dMV = SignAllForumActivity.this.ncT.dMV();
                        if (!dMX.dMq()) {
                            if (hVar.dMJ() != 0) {
                                SignAllForumActivity.this.Te(hVar.dMi());
                                SignAllForumActivity.this.acq.brv();
                            } else if (hVar.dML() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dMM());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.acq == null || !SignAllForumActivity.this.acq.isShowing()) {
                            SignAllForumActivity.this.dME();
                        }
                        dMV.setSignSuccess();
                        SignAllForumActivity.this.b(dMX);
                        return;
                    }
                    SignAllForumActivity.this.Td(dMk.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dME() {
        if (this.ncT != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(getPageContext(), this.ncT.cnn());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String dLZ = cVar.dLZ();
            final String bGb = cVar.bGb();
            final boolean dMn = cVar.dMn();
            if (cVar.dLY()) {
                this.ncT.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), dLZ, bGb, Boolean.valueOf(dMn))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Td(String str) {
        if (this.ncW) {
            c dMX = this.ncT.dMX();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dMX.dMm().size())});
            a(str, activity, false);
            if (this.ncX) {
                return;
            }
        }
        showToast(str);
        this.ncT.dMV().setSignSuccess();
        ArrayList<d> dMm = this.ncT.dMX().dMm();
        int size = dMm.size();
        for (int i = 0; i < size; i++) {
            d dVar = dMm.get(i);
            dVar.xM(true);
            dVar.xN(false);
            dVar.xL(false);
        }
        this.ncT.dMY().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void byM() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bt("MainTabActivity")) {
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
        byM();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.ncZ);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        com.baidu.tieba.d.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    private void initUI() {
        this.ncT = new j(this);
        this.ncT.setListPullRefreshListener(this);
        this.ncT.setOnItemClickListener(this);
        if (this.ncV.isRunning) {
            this.nda.a(this.ncV.dMP());
            this.ncT.dMV().setSigning(90);
            return;
        }
        this.ncT.startPullRefresh();
    }

    private void initData() {
        this.ncU = new GetForumListModel(this);
        this.ncU.a(this.nda);
        this.ncV = new SignAllForumModel(this);
        this.ncV.a(this.ndb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ncT.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.mjD = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.ncT.completeRefresh();
        } else if (this.ncU == null) {
            showToast(R.string.neterror);
        } else if (!this.ncU.LoadData()) {
            this.ncT.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dMX = this.ncT.dMX();
        if (view == this.ncT.getProgressBar()) {
            if (dMX != null) {
                if (dMX.getBlockPopInfoData() != null) {
                    if (dMX.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dMX.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).brB();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dMX.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_SIGN));
                    }
                } else if (this.ncT.dMV().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dMX.dMh() != 0) {
                        Te(dMX.dMi());
                        this.acq.brv();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.ncY = true;
                        dMF();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.ncT.dMZ()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void dMF() {
        c dMX = this.ncT.dMX();
        this.ncT.dMV().setDuration(Math.max(dMX.dMm().size() * 50, 2000));
        this.ncT.dMV().setSigning(0);
        this.ncV.d(dMX);
        this.ncV.LoadData();
        this.ncT.dMY().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.ncT.dMY().getItemViewType(i) == 0 && this.ncT.dMX() != null && this.ncT.dMX().dMj() != null && this.ncT.dMX().dMj().size() > i && (dVar = this.ncT.dMX().dMj().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Te(String str) {
        this.acq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Bq(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.acq.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ncV != null && this.ncV.isRunning) {
            dMG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ncX = true;
        if (this.acq != null && this.acq.isShowing()) {
            this.acq.dismiss();
        }
        if (this.ncU != null) {
            this.ncU.cancelLoadData();
            this.ncU = null;
        }
        if (this.ncT != null && this.ncT.dMY() != null) {
            this.ncT.dMY().dMH();
        }
        if (this.ncV != null) {
            if (this.ncV.isRunning) {
                dMG();
            }
            this.ncV.cancelMessage();
            this.ncV = null;
        }
        if (this.ncU != null) {
            this.ncU.cancelLoadData();
            this.ncU = null;
        }
    }

    private void dMG() {
        this.ncW = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.ncT == null || this.ncT.dMW() == null) {
            return null;
        }
        return this.ncT.dMW().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void G(long j, long j2) {
        if (l.bFl().isSmallFlow() && this.creatTime > 0) {
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1009, true, this.ncU.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (hVar != null) {
                hVar.bFi();
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
                    if (this.ncT != null) {
                        this.ncT.startPullRefresh();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
