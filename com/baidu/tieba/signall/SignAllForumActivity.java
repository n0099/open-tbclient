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
    private j ncV;
    private GetForumListModel ncW;
    private SignAllForumModel ncX;
    private boolean ncY;
    private boolean ncZ;
    private boolean nda = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long mjF = 0;
    private boolean mIsFromSchema = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.ncV.dMW().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener ndb = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dMY;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dMY = SignAllForumActivity.this.ncV.dMY()) != null) {
                dMY.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.ncV.dMZ().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a ndc = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.ncV.completeRefresh();
            a dMl = cVar.dMl();
            if (dMl != null) {
                if (dMl.getErrorNumber() == 0) {
                    SignAllForumActivity.this.ncV.a(cVar, SignAllForumActivity.this.ncW.dMD());
                } else {
                    SignAllForumActivity.this.showToast(dMl.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.mjF);
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
            SignAllForumActivity.this.ncV.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a ndd = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Nu(String str) {
            SignAllForumActivity.this.Td(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.nda) {
                    SignAllForumActivity.this.nda = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).brB();
                    if (SignAllForumActivity.this.ncV != null && SignAllForumActivity.this.ncV.dMW() != null) {
                        SignAllForumActivity.this.ncV.dMW().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a dMl = hVar.dMl();
                if (dMl != null) {
                    if (dMl.getErrorNumber() == 0) {
                        c dMY = SignAllForumActivity.this.ncV.dMY();
                        dMY.a(hVar);
                        if (SignAllForumActivity.this.ncY) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dMY.dMs()), Integer.valueOf(dMY.dMt())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.ncZ) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.ncV.dMZ().notifyDataSetChanged();
                        SignAllForumProgressView dMW = SignAllForumActivity.this.ncV.dMW();
                        if (!dMY.dMr()) {
                            if (hVar.dMK() != 0) {
                                SignAllForumActivity.this.Te(hVar.dMj());
                                SignAllForumActivity.this.acq.brv();
                            } else if (hVar.dMM() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dMN());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.acq == null || !SignAllForumActivity.this.acq.isShowing()) {
                            SignAllForumActivity.this.dMF();
                        }
                        dMW.setSignSuccess();
                        SignAllForumActivity.this.b(dMY);
                        return;
                    }
                    SignAllForumActivity.this.Td(dMl.getUserMsg());
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
    public void dMF() {
        if (this.ncV != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(getPageContext(), this.ncV.cno());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String dMa = cVar.dMa();
            final String bGb = cVar.bGb();
            final boolean dMo = cVar.dMo();
            if (cVar.dLZ()) {
                this.ncV.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), dMa, bGb, Boolean.valueOf(dMo))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Td(String str) {
        if (this.ncY) {
            c dMY = this.ncV.dMY();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dMY.dMn().size())});
            a(str, activity, false);
            if (this.ncZ) {
                return;
            }
        }
        showToast(str);
        this.ncV.dMW().setSignSuccess();
        ArrayList<d> dMn = this.ncV.dMY().dMn();
        int size = dMn.size();
        for (int i = 0; i < size; i++) {
            d dVar = dMn.get(i);
            dVar.xM(true);
            dVar.xN(false);
            dVar.xL(false);
        }
        this.ncV.dMZ().notifyDataSetChanged();
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
        registerListener(this.ndb);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        com.baidu.tieba.d.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    private void initUI() {
        this.ncV = new j(this);
        this.ncV.setListPullRefreshListener(this);
        this.ncV.setOnItemClickListener(this);
        if (this.ncX.isRunning) {
            this.ndc.a(this.ncX.dMQ());
            this.ncV.dMW().setSigning(90);
            return;
        }
        this.ncV.startPullRefresh();
    }

    private void initData() {
        this.ncW = new GetForumListModel(this);
        this.ncW.a(this.ndc);
        this.ncX = new SignAllForumModel(this);
        this.ncX.a(this.ndd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ncV.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.mjF = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.ncV.completeRefresh();
        } else if (this.ncW == null) {
            showToast(R.string.neterror);
        } else if (!this.ncW.LoadData()) {
            this.ncV.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dMY = this.ncV.dMY();
        if (view == this.ncV.getProgressBar()) {
            if (dMY != null) {
                if (dMY.getBlockPopInfoData() != null) {
                    if (dMY.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dMY.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).brB();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dMY.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_SIGN));
                    }
                } else if (this.ncV.dMW().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dMY.dMi() != 0) {
                        Te(dMY.dMj());
                        this.acq.brv();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.nda = true;
                        dMG();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.ncV.dNa()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void dMG() {
        c dMY = this.ncV.dMY();
        this.ncV.dMW().setDuration(Math.max(dMY.dMn().size() * 50, 2000));
        this.ncV.dMW().setSigning(0);
        this.ncX.d(dMY);
        this.ncX.LoadData();
        this.ncV.dMZ().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.ncV.dMZ().getItemViewType(i) == 0 && this.ncV.dMY() != null && this.ncV.dMY().dMk() != null && this.ncV.dMY().dMk().size() > i && (dVar = this.ncV.dMY().dMk().get(i)) != null) {
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
        if (this.ncX != null && this.ncX.isRunning) {
            dMH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ncZ = true;
        if (this.acq != null && this.acq.isShowing()) {
            this.acq.dismiss();
        }
        if (this.ncW != null) {
            this.ncW.cancelLoadData();
            this.ncW = null;
        }
        if (this.ncV != null && this.ncV.dMZ() != null) {
            this.ncV.dMZ().dMI();
        }
        if (this.ncX != null) {
            if (this.ncX.isRunning) {
                dMH();
            }
            this.ncX.cancelMessage();
            this.ncX = null;
        }
        if (this.ncW != null) {
            this.ncW.cancelLoadData();
            this.ncW = null;
        }
    }

    private void dMH() {
        this.ncY = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.ncV == null || this.ncV.dMX() == null) {
            return null;
        }
        return this.ncV.dMX().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void G(long j, long j2) {
        if (l.bFl().isSmallFlow() && this.creatTime > 0) {
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1009, true, this.ncW.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j);
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
                    if (this.ncV != null) {
                        this.ncV.startPullRefresh();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
