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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a ada;
    private j ndV;
    private GetForumListModel ndW;
    private SignAllForumModel ndX;
    private boolean ndY;
    private boolean ndZ;
    private boolean nea = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long mki = 0;
    private boolean mIsFromSchema = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.ndV.dIX().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener neb = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dIZ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dIZ = SignAllForumActivity.this.ndV.dIZ()) != null) {
                dIZ.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.ndV.dJa().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a nec = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.ndV.completeRefresh();
            a dIm = cVar.dIm();
            if (dIm != null) {
                if (dIm.getErrorNumber() == 0) {
                    SignAllForumActivity.this.ndV.a(cVar, SignAllForumActivity.this.ndW.dIE());
                } else {
                    SignAllForumActivity.this.showToast(dIm.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.mki);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.J(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Mf(String str) {
            SignAllForumActivity.this.ndV.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a ned = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Mf(String str) {
            SignAllForumActivity.this.RD(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.nea) {
                    SignAllForumActivity.this.nea = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqk();
                    if (SignAllForumActivity.this.ndV != null && SignAllForumActivity.this.ndV.dIX() != null) {
                        SignAllForumActivity.this.ndV.dIX().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a dIm = hVar.dIm();
                if (dIm != null) {
                    if (dIm.getErrorNumber() == 0) {
                        c dIZ = SignAllForumActivity.this.ndV.dIZ();
                        dIZ.a(hVar);
                        if (SignAllForumActivity.this.ndY) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dIZ.dIt()), Integer.valueOf(dIZ.dIu())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.ndZ) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.ndV.dJa().notifyDataSetChanged();
                        SignAllForumProgressView dIX = SignAllForumActivity.this.ndV.dIX();
                        if (!dIZ.dIs()) {
                            if (hVar.dIL() != 0) {
                                SignAllForumActivity.this.RE(hVar.dIk());
                                SignAllForumActivity.this.ada.bqe();
                            } else if (hVar.dIN() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dIO());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.ada == null || !SignAllForumActivity.this.ada.isShowing()) {
                            SignAllForumActivity.this.dIG();
                        }
                        dIX.setSignSuccess();
                        SignAllForumActivity.this.b(dIZ);
                        return;
                    }
                    SignAllForumActivity.this.RD(dIm.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dIG() {
        if (this.ndV != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.byi().a(getPageContext(), this.ndV.cmp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String dIb = cVar.dIb();
            final String bEF = cVar.bEF();
            final boolean dIp = cVar.dIp();
            if (cVar.dIa()) {
                this.ndV.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), dIb, bEF, Boolean.valueOf(dIp))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RD(String str) {
        if (this.ndY) {
            c dIZ = this.ndV.dIZ();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dIZ.dIo().size())});
            a(str, activity, false);
            if (this.ndZ) {
                return;
            }
        }
        showToast(str);
        this.ndV.dIX().setSignSuccess();
        ArrayList<d> dIo = this.ndV.dIZ().dIo();
        int size = dIo.size();
        for (int i = 0; i < size; i++) {
            d dVar = dIo.get(i);
            dVar.xK(true);
            dVar.xL(false);
            dVar.xJ(false);
        }
        this.ndV.dJa().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void bxn() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kC().bo("MainTabActivity")) {
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
        bxn();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.neb);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    private void initUI() {
        this.ndV = new j(this);
        this.ndV.setListPullRefreshListener(this);
        this.ndV.setOnItemClickListener(this);
        if (this.ndX.isRunning) {
            this.nec.a(this.ndX.dIR());
            this.ndV.dIX().setSigning(90);
            return;
        }
        this.ndV.startPullRefresh();
    }

    private void initData() {
        this.ndW = new GetForumListModel(this);
        this.ndW.a(this.nec);
        this.ndX = new SignAllForumModel(this);
        this.ndX.a(this.ned);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ndV.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.mki = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.ndV.completeRefresh();
        } else if (this.ndW == null) {
            showToast(R.string.neterror);
        } else if (!this.ndW.LoadData()) {
            this.ndV.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dIZ = this.ndV.dIZ();
        if (view == this.ndV.getProgressBar()) {
            if (dIZ != null) {
                if (dIZ.getBlockPopInfoData() != null) {
                    if (dIZ.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dIZ.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqk();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dIZ.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_SIGN));
                    }
                } else if (this.ndV.dIX().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dIZ.dIj() != 0) {
                        RE(dIZ.dIk());
                        this.ada.bqe();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.nea = true;
                        dIH();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.ndV.dJb()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void dIH() {
        c dIZ = this.ndV.dIZ();
        this.ndV.dIX().setDuration(Math.max(dIZ.dIo().size() * 50, 2000));
        this.ndV.dIX().setSigning(0);
        this.ndX.d(dIZ);
        this.ndX.LoadData();
        this.ndV.dJa().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.ndV.dJa().getItemViewType(i) == 0 && this.ndV.dIZ() != null && this.ndV.dIZ().dIl() != null && this.ndV.dIZ().dIl().size() > i && (dVar = this.ndV.dIZ().dIl().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RE(String str) {
        this.ada = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Ad(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ada.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ndX != null && this.ndX.isRunning) {
            dII();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ndZ = true;
        if (this.ada != null && this.ada.isShowing()) {
            this.ada.dismiss();
        }
        if (this.ndW != null) {
            this.ndW.cancelLoadData();
            this.ndW = null;
        }
        if (this.ndV != null && this.ndV.dJa() != null) {
            this.ndV.dJa().dIJ();
        }
        if (this.ndX != null) {
            if (this.ndX.isRunning) {
                dII();
            }
            this.ndX.cancelMessage();
            this.ndX = null;
        }
        if (this.ndW != null) {
            this.ndW.cancelLoadData();
            this.ndW = null;
        }
    }

    private void dII() {
        this.ndY = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public q onGetPreLoadListView() {
        if (this.ndV == null || this.ndV.dIY() == null) {
            return null;
        }
        return this.ndV.dIY().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void J(long j, long j2) {
        if (com.baidu.tbadk.n.k.bDO().isSmallFlow() && this.creatTime > 0) {
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1009, true, this.ndW.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (hVar != null) {
                hVar.bDL();
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
                    if (this.ndV != null) {
                        this.ndV.startPullRefresh();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
