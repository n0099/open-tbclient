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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.n.m;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a ZV;
    private boolean isDestory;
    private j lEr;
    private GetForumListModel lEs;
    private SignAllForumModel lEt;
    private boolean lEu;
    private boolean lEv = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long kOG = 0;
    private boolean mIsFromSchema = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.lEr.dja().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener lEw = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c djc;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (djc = SignAllForumActivity.this.lEr.djc()) != null) {
                djc.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.lEr.djd().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a lEx = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.lEr.completeRefresh();
            a dio = cVar.dio();
            if (dio != null) {
                if (dio.getErrorNumber() == 0) {
                    SignAllForumActivity.this.lEr.a(cVar, SignAllForumActivity.this.lEs.diH());
                } else {
                    SignAllForumActivity.this.showToast(dio.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.kOG);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.I(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void HM(String str) {
            SignAllForumActivity.this.lEr.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a lEy = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void HM(String str) {
            SignAllForumActivity.this.Nm(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.lEv) {
                    SignAllForumActivity.this.lEv = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aYR();
                    if (SignAllForumActivity.this.lEr != null && SignAllForumActivity.this.lEr.dja() != null) {
                        SignAllForumActivity.this.lEr.dja().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a dio = hVar.dio();
                if (dio != null) {
                    if (dio.getErrorNumber() == 0) {
                        c djc = SignAllForumActivity.this.lEr.djc();
                        djc.a(hVar);
                        if (SignAllForumActivity.this.lEu) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(djc.div()), Integer.valueOf(djc.diw())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.isDestory) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.lEr.djd().notifyDataSetChanged();
                        SignAllForumProgressView dja = SignAllForumActivity.this.lEr.dja();
                        if (!djc.diu()) {
                            if (hVar.diO() != 0) {
                                SignAllForumActivity.this.Nn(hVar.dim());
                                SignAllForumActivity.this.ZV.aYL();
                            } else if (hVar.diQ() != 0) {
                                SignAllForumActivity.this.showToast(hVar.diR());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.ZV == null || !SignAllForumActivity.this.ZV.isShowing()) {
                            SignAllForumActivity.this.diJ();
                        }
                        dja.setSignSuccess();
                        SignAllForumActivity.this.b(djc);
                        return;
                    }
                    SignAllForumActivity.this.Nm(dio.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void diJ() {
        if (this.lEr != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bgj().a(getPageContext(), this.lEr.bPb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String did = cVar.did();
            final String bmn = cVar.bmn();
            final boolean dir = cVar.dir();
            if (cVar.dic()) {
                this.lEr.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), did, bmn, Boolean.valueOf(dir))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nm(String str) {
        if (this.lEu) {
            c djc = this.lEr.djc();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(djc.diq().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.lEr.dja().setSignSuccess();
        ArrayList<d> diq = this.lEr.djc().diq();
        int size = diq.size();
        for (int i = 0; i < size; i++) {
            d dVar = diq.get(i);
            dVar.uY(true);
            dVar.uZ(false);
            dVar.uX(false);
        }
        this.lEr.djd().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void bfp() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bf.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        bfp();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.lEw);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    private void initUI() {
        this.lEr = new j(this);
        this.lEr.setListPullRefreshListener(this);
        this.lEr.setOnItemClickListener(this);
        if (this.lEt.isRunning) {
            this.lEx.a(this.lEt.diU());
            this.lEr.dja().setSigning(90);
            return;
        }
        this.lEr.startPullRefresh();
    }

    private void initData() {
        this.lEs = new GetForumListModel(this);
        this.lEs.a(this.lEx);
        this.lEt = new SignAllForumModel(this);
        this.lEt.a(this.lEy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lEr.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kOG = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.lEr.completeRefresh();
        } else if (this.lEs == null) {
            showToast(R.string.neterror);
        } else if (!this.lEs.LoadData()) {
            this.lEr.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c djc = this.lEr.djc();
        if (view == this.lEr.getProgressBar()) {
            if (djc != null) {
                if (djc.getBlockPopInfoData() != null) {
                    if (djc.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), djc.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aYR();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), djc.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_SIGN));
                    }
                } else if (this.lEr.dja().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (djc.dil() != 0) {
                        Nn(djc.dim());
                        this.ZV.aYL();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.lEv = true;
                        diK();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.lEr.dje()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void diK() {
        c djc = this.lEr.djc();
        this.lEr.dja().setDuration(Math.max(djc.diq().size() * 50, 2000));
        this.lEr.dja().setSigning(0);
        this.lEt.d(djc);
        this.lEt.LoadData();
        this.lEr.djd().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.lEr.djd().getItemViewType(i) == 0 && this.lEr.djc() != null && this.lEr.djc().din() != null && this.lEr.djc().din().size() > i && (dVar = this.lEr.djc().din().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nn(String str) {
        this.ZV = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).xl(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ZV.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lEt != null && this.lEt.isRunning) {
            diL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.ZV != null && this.ZV.isShowing()) {
            this.ZV.dismiss();
        }
        if (this.lEs != null) {
            this.lEs.cancelLoadData();
            this.lEs = null;
        }
        if (this.lEr != null && this.lEr.djd() != null) {
            this.lEr.djd().diM();
        }
        if (this.lEt != null) {
            if (this.lEt.isRunning) {
                diL();
            }
            this.lEt.cancelMessage();
            this.lEt = null;
        }
        if (this.lEs != null) {
            this.lEs.cancelLoadData();
            this.lEs = null;
        }
    }

    private void diL() {
        this.lEu = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.lEr == null || this.lEr.djb() == null) {
            return null;
        }
        return this.lEr.djb().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void I(long j, long j2) {
        if (m.blA().blB() && this.creatTime > 0) {
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1009, true, this.lEs.chB(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (iVar != null) {
                iVar.blx();
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
                    if (this.lEr != null) {
                        this.lEr.startPullRefresh();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
