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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.n.m;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a abn;
    private j mNU;
    private GetForumListModel mNV;
    private SignAllForumModel mNW;
    private boolean mNX;
    private boolean mNY;
    private boolean mNZ = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long lVe = 0;
    private boolean mIsFromSchema = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.mNU.dHO().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener mOa = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dHQ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dHQ = SignAllForumActivity.this.mNU.dHQ()) != null) {
                dHQ.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.mNU.dHR().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a mOb = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.mNU.completeRefresh();
            a dHc = cVar.dHc();
            if (dHc != null) {
                if (dHc.getErrorNumber() == 0) {
                    SignAllForumActivity.this.mNU.a(cVar, SignAllForumActivity.this.mNV.dHv());
                } else {
                    SignAllForumActivity.this.showToast(dHc.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.lVe);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.H(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void ML(String str) {
            SignAllForumActivity.this.mNU.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a mOc = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void ML(String str) {
            SignAllForumActivity.this.So(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.mNZ) {
                    SignAllForumActivity.this.mNZ = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bpi();
                    if (SignAllForumActivity.this.mNU != null && SignAllForumActivity.this.mNU.dHO() != null) {
                        SignAllForumActivity.this.mNU.dHO().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a dHc = hVar.dHc();
                if (dHc != null) {
                    if (dHc.getErrorNumber() == 0) {
                        c dHQ = SignAllForumActivity.this.mNU.dHQ();
                        dHQ.a(hVar);
                        if (SignAllForumActivity.this.mNX) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dHQ.dHj()), Integer.valueOf(dHQ.dHk())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.mNY) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.mNU.dHR().notifyDataSetChanged();
                        SignAllForumProgressView dHO = SignAllForumActivity.this.mNU.dHO();
                        if (!dHQ.dHi()) {
                            if (hVar.dHC() != 0) {
                                SignAllForumActivity.this.Sp(hVar.dHa());
                                SignAllForumActivity.this.abn.bpc();
                            } else if (hVar.dHE() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dHF());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.abn == null || !SignAllForumActivity.this.abn.isShowing()) {
                            SignAllForumActivity.this.dHx();
                        }
                        dHO.setSignSuccess();
                        SignAllForumActivity.this.b(dHQ);
                        return;
                    }
                    SignAllForumActivity.this.So(dHc.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dHx() {
        if (this.mNU != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bwR().a(getPageContext(), this.mNU.cka());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String dGR = cVar.dGR();
            final String bDh = cVar.bDh();
            final boolean dHf = cVar.dHf();
            if (cVar.dGQ()) {
                this.mNU.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), dGR, bDh, Boolean.valueOf(dHf))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void So(String str) {
        if (this.mNX) {
            c dHQ = this.mNU.dHQ();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dHQ.dHe().size())});
            a(str, activity, false);
            if (this.mNY) {
                return;
            }
        }
        showToast(str);
        this.mNU.dHO().setSignSuccess();
        ArrayList<d> dHe = this.mNU.dHQ().dHe();
        int size = dHe.size();
        for (int i = 0; i < size; i++) {
            d dVar = dHe.get(i);
            dVar.xe(true);
            dVar.xf(false);
            dVar.xd(false);
        }
        this.mNU.dHR().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void bvW() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bq("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bg.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        bvW();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.mOa);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    private void initUI() {
        this.mNU = new j(this);
        this.mNU.setListPullRefreshListener(this);
        this.mNU.setOnItemClickListener(this);
        if (this.mNW.isRunning) {
            this.mOb.a(this.mNW.dHI());
            this.mNU.dHO().setSigning(90);
            return;
        }
        this.mNU.startPullRefresh();
    }

    private void initData() {
        this.mNV = new GetForumListModel(this);
        this.mNV.a(this.mOb);
        this.mNW = new SignAllForumModel(this);
        this.mNW.a(this.mOc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNU.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.lVe = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.mNU.completeRefresh();
        } else if (this.mNV == null) {
            showToast(R.string.neterror);
        } else if (!this.mNV.LoadData()) {
            this.mNU.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dHQ = this.mNU.dHQ();
        if (view == this.mNU.getProgressBar()) {
            if (dHQ != null) {
                if (dHQ.getBlockPopInfoData() != null) {
                    if (dHQ.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dHQ.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bpi();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dHQ.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_SIGN));
                    }
                } else if (this.mNU.dHO().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dHQ.dGZ() != 0) {
                        Sp(dHQ.dHa());
                        this.abn.bpc();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mNZ = true;
                        dHy();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.mNU.dHS()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void dHy() {
        c dHQ = this.mNU.dHQ();
        this.mNU.dHO().setDuration(Math.max(dHQ.dHe().size() * 50, 2000));
        this.mNU.dHO().setSigning(0);
        this.mNW.d(dHQ);
        this.mNW.LoadData();
        this.mNU.dHR().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.mNU.dHR().getItemViewType(i) == 0 && this.mNU.dHQ() != null && this.mNU.dHQ().dHb() != null && this.mNU.dHQ().dHb().size() > i && (dVar = this.mNU.dHQ().dHb().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sp(String str) {
        this.abn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Bo(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.abn.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNW != null && this.mNW.isRunning) {
            dHz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mNY = true;
        if (this.abn != null && this.abn.isShowing()) {
            this.abn.dismiss();
        }
        if (this.mNV != null) {
            this.mNV.cancelLoadData();
            this.mNV = null;
        }
        if (this.mNU != null && this.mNU.dHR() != null) {
            this.mNU.dHR().dHA();
        }
        if (this.mNW != null) {
            if (this.mNW.isRunning) {
                dHz();
            }
            this.mNW.cancelMessage();
            this.mNW = null;
        }
        if (this.mNV != null) {
            this.mNV.cancelLoadData();
            this.mNV = null;
        }
    }

    private void dHz() {
        this.mNX = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.mNU == null || this.mNU.dHP() == null) {
            return null;
        }
        return this.mNU.dHP().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void H(long j, long j2) {
        if (m.bCu().bCv() && this.creatTime > 0) {
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1009, true, this.mNV.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (iVar != null) {
                iVar.bCr();
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
                    if (this.mNU != null) {
                        this.mNU.startPullRefresh();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
