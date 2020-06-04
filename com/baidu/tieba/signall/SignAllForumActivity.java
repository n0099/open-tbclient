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
import com.baidu.adp.widget.ListView.r;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.n.m;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a Zw;
    private boolean isDestory;
    private j ldb;
    private GetForumListModel ldc;
    private SignAllForumModel ldd;
    private boolean lde;
    private boolean ldf = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long klQ = 0;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.ldb.dbB().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener ldg = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dbD;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dbD = SignAllForumActivity.this.ldb.dbD()) != null) {
                dbD.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.ldb.dbE().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a ldh = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.ldb.completeRefresh();
            a daO = cVar.daO();
            if (daO != null) {
                if (daO.getErrorNumber() == 0) {
                    SignAllForumActivity.this.ldb.a(cVar, SignAllForumActivity.this.ldc.dbh());
                } else {
                    SignAllForumActivity.this.showToast(daO.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.klQ);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.G(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Gv(String str) {
            SignAllForumActivity.this.ldb.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a ldi = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Gv(String str) {
            SignAllForumActivity.this.Mc(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.ldf) {
                    SignAllForumActivity.this.ldf = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                    if (SignAllForumActivity.this.ldb != null && SignAllForumActivity.this.ldb.dbB() != null) {
                        SignAllForumActivity.this.ldb.dbB().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a daO = hVar.daO();
                if (daO != null) {
                    if (daO.getErrorNumber() == 0) {
                        c dbD = SignAllForumActivity.this.ldb.dbD();
                        dbD.a(hVar);
                        if (SignAllForumActivity.this.lde) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dbD.daV()), Integer.valueOf(dbD.daW())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.isDestory) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.ldb.dbE().notifyDataSetChanged();
                        SignAllForumProgressView dbB = SignAllForumActivity.this.ldb.dbB();
                        if (!dbD.daU()) {
                            if (hVar.dbp() != 0) {
                                SignAllForumActivity.this.Md(hVar.daM());
                                SignAllForumActivity.this.Zw.aST();
                            } else if (hVar.dbr() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dbs());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.Zw == null || !SignAllForumActivity.this.Zw.isShowing()) {
                            SignAllForumActivity.this.dbk();
                        }
                        dbB.setSignSuccess();
                        SignAllForumActivity.this.b(dbD);
                        return;
                    }
                    SignAllForumActivity.this.Mc(daO.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dbk() {
        if (this.ldb != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bao().a(getPageContext(), this.ldb.bIN());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String daD = cVar.daD();
            final String bgm = cVar.bgm();
            final boolean daR = cVar.daR();
            if (cVar.daC()) {
                this.ldb.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), daD, bgm, Boolean.valueOf(daR))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mc(String str) {
        if (this.lde) {
            c dbD = this.ldb.dbD();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dbD.daQ().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.ldb.dbB().setSignSuccess();
        ArrayList<d> daQ = this.ldb.dbD().daQ();
        int size = daQ.size();
        for (int i = 0; i < size; i++) {
            d dVar = daQ.get(i);
            dVar.uf(true);
            dVar.ug(false);
            dVar.ue(false);
        }
        this.ldb.dbE().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aZq() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bc.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        aZq();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.ldg);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
    }

    private void initUI() {
        this.ldb = new j(this);
        this.ldb.setListPullRefreshListener(this);
        this.ldb.setOnItemClickListener(this);
        if (this.ldd.isRunning) {
            this.ldh.a(this.ldd.dbv());
            this.ldb.dbB().setSigning(90);
            return;
        }
        this.ldb.startPullRefresh();
    }

    private void initData() {
        this.ldc = new GetForumListModel(this);
        this.ldc.a(this.ldh);
        this.ldd = new SignAllForumModel(this);
        this.ldd.a(this.ldi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ldb.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.klQ = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.ldb.completeRefresh();
        } else if (this.ldc == null) {
            showToast(R.string.neterror);
        } else if (!this.ldc.LoadData()) {
            this.ldb.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dbD = this.ldb.dbD();
        if (view == this.ldb.getProgressBar()) {
            if (dbD != null) {
                if (dbD.getBlockPopInfoData() != null) {
                    if (dbD.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dbD.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dbD.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.ldb.dbB().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dbD.daL() != 0) {
                        Md(dbD.daM());
                        this.Zw.aST();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.ldf = true;
                        dbl();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.ldb.dbF()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void dbl() {
        c dbD = this.ldb.dbD();
        this.ldb.dbB().setDuration(Math.max(dbD.daQ().size() * 50, 2000));
        this.ldb.dbB().setSigning(0);
        this.ldd.d(dbD);
        this.ldd.LoadData();
        this.ldb.dbE().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.ldb.dbE().getItemViewType(i) == 0 && this.ldb.dbD() != null && this.ldb.dbD().daN() != null && this.ldb.dbD().daN().size() > i && (dVar = this.ldb.dbD().daN().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Md(String str) {
        this.Zw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).vO(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Zw.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ldd != null && this.ldd.isRunning) {
            dbm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Zw != null && this.Zw.isShowing()) {
            this.Zw.dismiss();
        }
        if (this.ldc != null) {
            this.ldc.cancelLoadData();
            this.ldc = null;
        }
        if (this.ldb != null && this.ldb.dbE() != null) {
            this.ldb.dbE().dbn();
        }
        if (this.ldd != null) {
            if (this.ldd.isRunning) {
                dbm();
            }
            this.ldd.cancelMessage();
            this.ldd = null;
        }
        if (this.ldc != null) {
            this.ldc.cancelLoadData();
            this.ldc = null;
        }
    }

    private void dbm() {
        this.lde = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public r onGetPreLoadListView() {
        if (this.ldb == null || this.ldb.dbC() == null) {
            return null;
        }
        return this.ldb.dbC().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void G(long j, long j2) {
        if (m.bfJ().bfK() && this.creatTime > 0) {
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1009, true, this.ldc.dbi(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (iVar != null) {
                iVar.bfG();
            }
            this.creatTime = 0L;
        }
    }
}
