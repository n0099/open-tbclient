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
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.n.m;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements g.c {
    private com.baidu.tbadk.core.dialog.a Zg;
    private boolean isDestory;
    private j kJC;
    private GetForumListModel kJD;
    private SignAllForumModel kJE;
    private boolean kJF;
    private boolean kJG = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long jSS = 0;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.kJC.cUh().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener kJH = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cUj;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cUj = SignAllForumActivity.this.kJC.cUj()) != null) {
                cUj.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.kJC.cUk().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a kJI = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.kJC.completeRefresh();
            a cTu = cVar.cTu();
            if (cTu != null) {
                if (cTu.getErrorNumber() == 0) {
                    SignAllForumActivity.this.kJC.a(cVar, SignAllForumActivity.this.kJD.cTN());
                } else {
                    SignAllForumActivity.this.showToast(cTu.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = System.currentTimeMillis() - SignAllForumActivity.this.jSS;
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.F(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void EM(String str) {
            SignAllForumActivity.this.kJC.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a kJJ = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void EM(String str) {
            SignAllForumActivity.this.Kp(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.kJG) {
                    SignAllForumActivity.this.kJG = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMX();
                    if (SignAllForumActivity.this.kJC != null && SignAllForumActivity.this.kJC.cUh() != null) {
                        SignAllForumActivity.this.kJC.cUh().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a cTu = hVar.cTu();
                if (cTu != null) {
                    if (cTu.getErrorNumber() == 0) {
                        c cUj = SignAllForumActivity.this.kJC.cUj();
                        cUj.a(hVar);
                        if (SignAllForumActivity.this.kJF) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cUj.cTB()), Integer.valueOf(cUj.cTC())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.isDestory) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.kJC.cUk().notifyDataSetChanged();
                        SignAllForumProgressView cUh = SignAllForumActivity.this.kJC.cUh();
                        if (!cUj.cTA()) {
                            if (hVar.cTV() != 0) {
                                SignAllForumActivity.this.Kq(hVar.cTs());
                                SignAllForumActivity.this.Zg.aMS();
                            } else if (hVar.cTX() != 0) {
                                SignAllForumActivity.this.showToast(hVar.cTY());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.Zg == null || !SignAllForumActivity.this.Zg.isShowing()) {
                            SignAllForumActivity.this.cTQ();
                        }
                        cUh.setSignSuccess();
                        SignAllForumActivity.this.b(cUj);
                        return;
                    }
                    SignAllForumActivity.this.Kp(cTu.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cTQ() {
        if (this.kJC != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aUg().a(getPageContext(), this.kJC.bCr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cTj = cVar.cTj();
            final String bab = cVar.bab();
            final boolean cTx = cVar.cTx();
            if (cVar.cTi()) {
                this.kJC.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cTj, bab, Boolean.valueOf(cTx))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kp(String str) {
        if (this.kJF) {
            c cUj = this.kJC.cUj();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cUj.cTw().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.kJC.cUh().setSignSuccess();
        ArrayList<d> cTw = this.kJC.cUj().cTw();
        int size = cTw.size();
        for (int i = 0; i < size; i++) {
            d dVar = cTw.get(i);
            dVar.tH(true);
            dVar.tI(false);
            dVar.tG(false);
        }
        this.kJC.cUk().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aTi() {
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
        aTi();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.kJH);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
    }

    private void initUI() {
        this.kJC = new j(this);
        this.kJC.setListPullRefreshListener(this);
        this.kJC.setOnItemClickListener(this);
        if (this.kJE.isRunning) {
            this.kJI.a(this.kJE.cUb());
            this.kJC.cUh().setSigning(90);
            return;
        }
        this.kJC.startPullRefresh();
    }

    private void initData() {
        this.kJD = new GetForumListModel(this);
        this.kJD.a(this.kJI);
        this.kJE = new SignAllForumModel(this);
        this.kJE.a(this.kJJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kJC.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.kJC.completeRefresh();
        } else if (this.kJD == null) {
            showToast(R.string.neterror);
        } else if (!this.kJD.LoadData()) {
            this.kJC.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cUj = this.kJC.cUj();
        if (view == this.kJC.getProgressBar()) {
            if (cUj != null) {
                if (cUj.getBlockPopInfoData() != null) {
                    if (cUj.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cUj.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMX();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cUj.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.kJC.cUh().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cUj.cTr() != 0) {
                        Kq(cUj.cTs());
                        this.Zg.aMS();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.kJG = true;
                        cTR();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.kJC.cUl()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cTR() {
        c cUj = this.kJC.cUj();
        this.kJC.cUh().setDuration(Math.max(cUj.cTw().size() * 50, 2000));
        this.kJC.cUh().setSigning(0);
        this.kJE.d(cUj);
        this.jSS = System.currentTimeMillis();
        this.kJE.LoadData();
        this.kJC.cUk().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.kJC.cUk().getItemViewType(i) == 0 && this.kJC.cUj() != null && this.kJC.cUj().cTt() != null && this.kJC.cUj().cTt().size() > i && (dVar = this.kJC.cUj().cTt().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kq(String str) {
        this.Zg = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ui(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Zg.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kJE != null && this.kJE.isRunning) {
            cTS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Zg != null && this.Zg.isShowing()) {
            this.Zg.dismiss();
        }
        if (this.kJD != null) {
            this.kJD.cancelLoadData();
            this.kJD = null;
        }
        if (this.kJC != null && this.kJC.cUk() != null) {
            this.kJC.cUk().cTT();
        }
        if (this.kJE != null) {
            if (this.kJE.isRunning) {
                cTS();
            }
            this.kJE.cancelMessage();
            this.kJE = null;
        }
        if (this.kJD != null) {
            this.kJD.cancelLoadData();
            this.kJD = null;
        }
    }

    private void cTS() {
        this.kJF = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.kJC == null || this.kJC.cUi() == null) {
            return null;
        }
        return this.kJC.cUi().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void F(long j, long j2) {
        if (m.aZy().aZz() && this.creatTime > 0) {
            long j3 = j + this.creatTime;
            if (this.beginTime > 0) {
                j3 = System.currentTimeMillis() - this.beginTime;
            }
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1009, true, this.kJD.cTO(), 0L, this.creatTime, j2, false, 0L, 0L, j3);
            if (iVar != null) {
                iVar.aZv();
            }
            this.creatTime = 0L;
        }
    }
}
