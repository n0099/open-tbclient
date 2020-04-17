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
    private com.baidu.tbadk.core.dialog.a Zd;
    private boolean isDestory;
    private SignAllForumModel kJA;
    private boolean kJB;
    private j kJy;
    private GetForumListModel kJz;
    private boolean kJC = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long jSO = 0;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.kJy.cUj().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener kJD = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cUl;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cUl = SignAllForumActivity.this.kJy.cUl()) != null) {
                cUl.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.kJy.cUm().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a kJE = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.kJy.completeRefresh();
            a cTw = cVar.cTw();
            if (cTw != null) {
                if (cTw.getErrorNumber() == 0) {
                    SignAllForumActivity.this.kJy.a(cVar, SignAllForumActivity.this.kJz.cTP());
                } else {
                    SignAllForumActivity.this.showToast(cTw.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = System.currentTimeMillis() - SignAllForumActivity.this.jSO;
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.F(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void EJ(String str) {
            SignAllForumActivity.this.kJy.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a kJF = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void EJ(String str) {
            SignAllForumActivity.this.Km(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.kJC) {
                    SignAllForumActivity.this.kJC = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMZ();
                    if (SignAllForumActivity.this.kJy != null && SignAllForumActivity.this.kJy.cUj() != null) {
                        SignAllForumActivity.this.kJy.cUj().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a cTw = hVar.cTw();
                if (cTw != null) {
                    if (cTw.getErrorNumber() == 0) {
                        c cUl = SignAllForumActivity.this.kJy.cUl();
                        cUl.a(hVar);
                        if (SignAllForumActivity.this.kJB) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cUl.cTD()), Integer.valueOf(cUl.cTE())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.isDestory) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.kJy.cUm().notifyDataSetChanged();
                        SignAllForumProgressView cUj = SignAllForumActivity.this.kJy.cUj();
                        if (!cUl.cTC()) {
                            if (hVar.cTX() != 0) {
                                SignAllForumActivity.this.Kn(hVar.cTu());
                                SignAllForumActivity.this.Zd.aMU();
                            } else if (hVar.cTZ() != 0) {
                                SignAllForumActivity.this.showToast(hVar.cUa());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.Zd == null || !SignAllForumActivity.this.Zd.isShowing()) {
                            SignAllForumActivity.this.cTS();
                        }
                        cUj.setSignSuccess();
                        SignAllForumActivity.this.b(cUl);
                        return;
                    }
                    SignAllForumActivity.this.Km(cTw.getUserMsg());
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
    public void cTS() {
        if (this.kJy != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aUi().a(getPageContext(), this.kJy.bCt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cTl = cVar.cTl();
            final String bad = cVar.bad();
            final boolean cTz = cVar.cTz();
            if (cVar.cTk()) {
                this.kJy.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cTl, bad, Boolean.valueOf(cTz))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km(String str) {
        if (this.kJB) {
            c cUl = this.kJy.cUl();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cUl.cTy().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.kJy.cUj().setSignSuccess();
        ArrayList<d> cTy = this.kJy.cUl().cTy();
        int size = cTy.size();
        for (int i = 0; i < size; i++) {
            d dVar = cTy.get(i);
            dVar.tH(true);
            dVar.tI(false);
            dVar.tG(false);
        }
        this.kJy.cUm().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aTk() {
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
        aTk();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.kJD);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
    }

    private void initUI() {
        this.kJy = new j(this);
        this.kJy.setListPullRefreshListener(this);
        this.kJy.setOnItemClickListener(this);
        if (this.kJA.isRunning) {
            this.kJE.a(this.kJA.cUd());
            this.kJy.cUj().setSigning(90);
            return;
        }
        this.kJy.startPullRefresh();
    }

    private void initData() {
        this.kJz = new GetForumListModel(this);
        this.kJz.a(this.kJE);
        this.kJA = new SignAllForumModel(this);
        this.kJA.a(this.kJF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kJy.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.kJy.completeRefresh();
        } else if (this.kJz == null) {
            showToast(R.string.neterror);
        } else if (!this.kJz.LoadData()) {
            this.kJy.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cUl = this.kJy.cUl();
        if (view == this.kJy.getProgressBar()) {
            if (cUl != null) {
                if (cUl.getBlockPopInfoData() != null) {
                    if (cUl.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cUl.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMZ();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cUl.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.kJy.cUj().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cUl.cTt() != 0) {
                        Kn(cUl.cTu());
                        this.Zd.aMU();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.kJC = true;
                        cTT();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.kJy.cUn()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cTT() {
        c cUl = this.kJy.cUl();
        this.kJy.cUj().setDuration(Math.max(cUl.cTy().size() * 50, 2000));
        this.kJy.cUj().setSigning(0);
        this.kJA.d(cUl);
        this.jSO = System.currentTimeMillis();
        this.kJA.LoadData();
        this.kJy.cUm().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.kJy.cUm().getItemViewType(i) == 0 && this.kJy.cUl() != null && this.kJy.cUl().cTv() != null && this.kJy.cUl().cTv().size() > i && (dVar = this.kJy.cUl().cTv().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn(String str) {
        this.Zd = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).uf(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Zd.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kJA != null && this.kJA.isRunning) {
            cTU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Zd != null && this.Zd.isShowing()) {
            this.Zd.dismiss();
        }
        if (this.kJz != null) {
            this.kJz.cancelLoadData();
            this.kJz = null;
        }
        if (this.kJy != null && this.kJy.cUm() != null) {
            this.kJy.cUm().cTV();
        }
        if (this.kJA != null) {
            if (this.kJA.isRunning) {
                cTU();
            }
            this.kJA.cancelMessage();
            this.kJA = null;
        }
        if (this.kJz != null) {
            this.kJz.cancelLoadData();
            this.kJz = null;
        }
    }

    private void cTU() {
        this.kJB = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.kJy == null || this.kJy.cUk() == null) {
            return null;
        }
        return this.kJy.cUk().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void F(long j, long j2) {
        if (m.aZA().aZB() && this.creatTime > 0) {
            long j3 = j + this.creatTime;
            if (this.beginTime > 0) {
                j3 = System.currentTimeMillis() - this.beginTime;
            }
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1009, true, this.kJz.cTQ(), 0L, this.creatTime, j2, false, 0L, 0L, j3);
            if (iVar != null) {
                iVar.aZx();
            }
            this.creatTime = 0L;
        }
    }
}
