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
/* loaded from: classes18.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a aaB;
    private j lVV;
    private GetForumListModel lVW;
    private SignAllForumModel lVX;
    private boolean lVY;
    private boolean lVZ;
    private boolean lWa = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long lew = 0;
    private boolean mIsFromSchema = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.lVV.duv().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener lWb = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dux;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dux = SignAllForumActivity.this.lVV.dux()) != null) {
                dux.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.lVV.duy().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a lWc = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.lVV.completeRefresh();
            a dtJ = cVar.dtJ();
            if (dtJ != null) {
                if (dtJ.getErrorNumber() == 0) {
                    SignAllForumActivity.this.lVV.a(cVar, SignAllForumActivity.this.lVW.duc());
                } else {
                    SignAllForumActivity.this.showToast(dtJ.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.lew);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.I(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void KE(String str) {
            SignAllForumActivity.this.lVV.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a lWd = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void KE(String str) {
            SignAllForumActivity.this.Qk(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.lWa) {
                    SignAllForumActivity.this.lWa = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bhm();
                    if (SignAllForumActivity.this.lVV != null && SignAllForumActivity.this.lVV.duv() != null) {
                        SignAllForumActivity.this.lVV.duv().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a dtJ = hVar.dtJ();
                if (dtJ != null) {
                    if (dtJ.getErrorNumber() == 0) {
                        c dux = SignAllForumActivity.this.lVV.dux();
                        dux.a(hVar);
                        if (SignAllForumActivity.this.lVY) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dux.dtQ()), Integer.valueOf(dux.dtR())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.lVZ) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.lVV.duy().notifyDataSetChanged();
                        SignAllForumProgressView duv = SignAllForumActivity.this.lVV.duv();
                        if (!dux.dtP()) {
                            if (hVar.duj() != 0) {
                                SignAllForumActivity.this.Ql(hVar.dtH());
                                SignAllForumActivity.this.aaB.bhg();
                            } else if (hVar.dul() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dum());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.aaB == null || !SignAllForumActivity.this.aaB.isShowing()) {
                            SignAllForumActivity.this.due();
                        }
                        duv.setSignSuccess();
                        SignAllForumActivity.this.b(dux);
                        return;
                    }
                    SignAllForumActivity.this.Qk(dtJ.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void due() {
        if (this.lVV != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.boT().a(getPageContext(), this.lVV.bZb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String dty = cVar.dty();
            final String bva = cVar.bva();
            final boolean dtM = cVar.dtM();
            if (cVar.dtx()) {
                this.lVV.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), dty, bva, Boolean.valueOf(dtM))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qk(String str) {
        if (this.lVY) {
            c dux = this.lVV.dux();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dux.dtL().size())});
            a(str, activity, false);
            if (this.lVZ) {
                return;
            }
        }
        showToast(str);
        this.lVV.duv().setSignSuccess();
        ArrayList<d> dtL = this.lVV.dux().dtL();
        int size = dtL.size();
        for (int i = 0; i < size; i++) {
            d dVar = dtL.get(i);
            dVar.vN(true);
            dVar.vO(false);
            dVar.vM(false);
        }
        this.lVV.duy().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void bnZ() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lb().bo("MainTabActivity")) {
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
        bnZ();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.lWb);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    private void initUI() {
        this.lVV = new j(this);
        this.lVV.setListPullRefreshListener(this);
        this.lVV.setOnItemClickListener(this);
        if (this.lVX.isRunning) {
            this.lWc.a(this.lVX.dup());
            this.lVV.duv().setSigning(90);
            return;
        }
        this.lVV.startPullRefresh();
    }

    private void initData() {
        this.lVW = new GetForumListModel(this);
        this.lVW.a(this.lWc);
        this.lVX = new SignAllForumModel(this);
        this.lVX.a(this.lWd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lVV.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.lew = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.lVV.completeRefresh();
        } else if (this.lVW == null) {
            showToast(R.string.neterror);
        } else if (!this.lVW.LoadData()) {
            this.lVV.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dux = this.lVV.dux();
        if (view == this.lVV.getProgressBar()) {
            if (dux != null) {
                if (dux.getBlockPopInfoData() != null) {
                    if (dux.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dux.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bhm();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dux.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_SIGN));
                    }
                } else if (this.lVV.duv().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dux.dtG() != 0) {
                        Ql(dux.dtH());
                        this.aaB.bhg();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.lWa = true;
                        duf();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.lVV.duz()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void duf() {
        c dux = this.lVV.dux();
        this.lVV.duv().setDuration(Math.max(dux.dtL().size() * 50, 2000));
        this.lVV.duv().setSigning(0);
        this.lVX.d(dux);
        this.lVX.LoadData();
        this.lVV.duy().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.lVV.duy().getItemViewType(i) == 0 && this.lVV.dux() != null && this.lVV.dux().dtI() != null && this.lVV.dux().dtI().size() > i && (dVar = this.lVV.dux().dtI().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ql(String str) {
        this.aaB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).zz(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.aaB.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lVX != null && this.lVX.isRunning) {
            dug();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lVZ = true;
        if (this.aaB != null && this.aaB.isShowing()) {
            this.aaB.dismiss();
        }
        if (this.lVW != null) {
            this.lVW.cancelLoadData();
            this.lVW = null;
        }
        if (this.lVV != null && this.lVV.duy() != null) {
            this.lVV.duy().duh();
        }
        if (this.lVX != null) {
            if (this.lVX.isRunning) {
                dug();
            }
            this.lVX.cancelMessage();
            this.lVX = null;
        }
        if (this.lVW != null) {
            this.lVW.cancelLoadData();
            this.lVW = null;
        }
    }

    private void dug() {
        this.lVY = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.lVV == null || this.lVV.duw() == null) {
            return null;
        }
        return this.lVV.duw().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void I(long j, long j2) {
        if (m.bun().buo() && this.creatTime > 0) {
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1009, true, this.lVW.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (iVar != null) {
                iVar.buk();
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
                    if (this.lVV != null) {
                        this.lVV.startPullRefresh();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
