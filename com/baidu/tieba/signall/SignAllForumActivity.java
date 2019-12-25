package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements g.c {
    private com.baidu.tbadk.core.dialog.a Ft;
    private boolean isDestory;
    private j jTP;
    private GetForumListModel jTQ;
    private SignAllForumModel jTR;
    private boolean jTS;
    private boolean jTT = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.jTP.cGy().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener jTU = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cGA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cGA = SignAllForumActivity.this.jTP.cGA()) != null) {
                cGA.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.jTP.cGB().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a jTV = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.jTP.completeRefresh();
            a cFM = cVar.cFM();
            if (cFM != null && cFM.getErrorNumber() == 0) {
                SignAllForumActivity.this.jTP.a(cVar, SignAllForumActivity.this.jTQ.cGf());
                return;
            }
            SignAllForumActivity.this.showToast(cFM.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void CA(String str) {
            SignAllForumActivity.this.jTP.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a jTW = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void CA(String str) {
            SignAllForumActivity.this.Ik(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.jTT) {
                SignAllForumActivity.this.jTT = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCb();
                if (SignAllForumActivity.this.jTP != null && SignAllForumActivity.this.jTP.cGy() != null) {
                    SignAllForumActivity.this.jTP.cGy().setSignBefore(0);
                    return;
                }
                return;
            }
            a cFM = hVar.cFM();
            if (cFM == null || cFM.getErrorNumber() != 0) {
                SignAllForumActivity.this.Ik(cFM.getUserMsg());
                return;
            }
            c cGA = SignAllForumActivity.this.jTP.cGA();
            cGA.a(hVar);
            if (SignAllForumActivity.this.jTS) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cGA.cFT()), Integer.valueOf(cGA.cFU())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.jTP.cGB().notifyDataSetChanged();
            SignAllForumProgressView cGy = SignAllForumActivity.this.jTP.cGy();
            if (!cGA.cFS()) {
                if (hVar.cGm() != 0) {
                    SignAllForumActivity.this.Il(hVar.cFK());
                    SignAllForumActivity.this.Ft.aBW();
                } else if (hVar.cGo() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cGp());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Ft == null || !SignAllForumActivity.this.Ft.isShowing()) {
                SignAllForumActivity.this.cGh();
            }
            cGy.setSignSuccess();
            SignAllForumActivity.this.b(cGA);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cGh() {
        if (this.jTP != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aIR().a(getPageContext(), this.jTP.bpX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cFB = cVar.cFB();
            final String aPd = cVar.aPd();
            final boolean cFP = cVar.cFP();
            if (cVar.cFA()) {
                this.jTP.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cFB, aPd, Boolean.valueOf(cFP))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ik(String str) {
        if (this.jTS) {
            c cGA = this.jTP.cGA();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cGA.cFO().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.jTP.cGy().setSignSuccess();
        ArrayList<d> cFO = this.jTP.cGA().cFO();
        int size = cFO.size();
        for (int i = 0; i < size; i++) {
            d dVar = cFO.get(i);
            dVar.sk(true);
            dVar.sl(false);
            dVar.sj(false);
        }
        this.jTP.cGB().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aHT() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bc.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        aHT();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.jTU);
        initData();
        initUI();
    }

    private void initUI() {
        this.jTP = new j(this);
        this.jTP.setListPullRefreshListener(this);
        this.jTP.setOnItemClickListener(this);
        if (this.jTR.isRunning) {
            this.jTV.a(this.jTR.cGs());
            this.jTP.cGy().setSigning(90);
            return;
        }
        this.jTP.startPullRefresh();
    }

    private void initData() {
        this.jTQ = new GetForumListModel(this);
        this.jTQ.a(this.jTV);
        this.jTR = new SignAllForumModel(this);
        this.jTR.a(this.jTW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jTP.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.jTP.completeRefresh();
        } else if (this.jTQ == null) {
            showToast(R.string.neterror);
        } else if (!this.jTQ.LoadData()) {
            this.jTP.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cGA = this.jTP.cGA();
        if (view == this.jTP.getProgressBar()) {
            if (cGA != null) {
                if (cGA.getBlockPopInfoData() != null) {
                    if (cGA.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cGA.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCb();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cGA.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.jTP.cGy().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cGA.cFJ() != 0) {
                        Il(cGA.cFK());
                        this.Ft.aBW();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jTT = true;
                        cGi();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.jTP.cGC()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cGi() {
        c cGA = this.jTP.cGA();
        this.jTP.cGy().setDuration(Math.max(cGA.cFO().size() * 50, 2000));
        this.jTP.cGy().setSigning(0);
        this.jTR.d(cGA);
        this.jTR.LoadData();
        this.jTP.cGB().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.jTP.cGB().getItemViewType(i) == 0 && this.jTP.cGA() != null && this.jTP.cGA().cFL() != null && this.jTP.cGA().cFL().size() > i && (dVar = this.jTP.cGA().cFL().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il(String str) {
        this.Ft = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).sz(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Ft.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jTR != null && this.jTR.isRunning) {
            cGj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Ft != null && this.Ft.isShowing()) {
            this.Ft.dismiss();
        }
        if (this.jTQ != null) {
            this.jTQ.cancelLoadData();
            this.jTQ = null;
        }
        if (this.jTP != null && this.jTP.cGB() != null) {
            this.jTP.cGB().cGk();
        }
        if (this.jTR != null) {
            if (this.jTR.isRunning) {
                cGj();
            }
            this.jTR.cancelMessage();
            this.jTR = null;
        }
        if (this.jTQ != null) {
            this.jTQ.cancelLoadData();
            this.jTQ = null;
        }
    }

    private void cGj() {
        this.jTS = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.jTP == null || this.jTP.cGz() == null) {
            return null;
        }
        return this.jTP.cGz().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
