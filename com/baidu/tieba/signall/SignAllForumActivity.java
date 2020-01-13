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
/* loaded from: classes9.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements g.c {
    private com.baidu.tbadk.core.dialog.a Fy;
    private boolean isDestory;
    private j jXr;
    private GetForumListModel jXs;
    private SignAllForumModel jXt;
    private boolean jXu;
    private boolean jXv = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.jXr.cHC().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener jXw = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cHE;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cHE = SignAllForumActivity.this.jXr.cHE()) != null) {
                cHE.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.jXr.cHF().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a jXx = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.jXr.completeRefresh();
            a cGQ = cVar.cGQ();
            if (cGQ != null && cGQ.getErrorNumber() == 0) {
                SignAllForumActivity.this.jXr.a(cVar, SignAllForumActivity.this.jXs.cHj());
                return;
            }
            SignAllForumActivity.this.showToast(cGQ.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void CK(String str) {
            SignAllForumActivity.this.jXr.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a jXy = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void CK(String str) {
            SignAllForumActivity.this.Iu(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.jXv) {
                SignAllForumActivity.this.jXv = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCu();
                if (SignAllForumActivity.this.jXr != null && SignAllForumActivity.this.jXr.cHC() != null) {
                    SignAllForumActivity.this.jXr.cHC().setSignBefore(0);
                    return;
                }
                return;
            }
            a cGQ = hVar.cGQ();
            if (cGQ == null || cGQ.getErrorNumber() != 0) {
                SignAllForumActivity.this.Iu(cGQ.getUserMsg());
                return;
            }
            c cHE = SignAllForumActivity.this.jXr.cHE();
            cHE.a(hVar);
            if (SignAllForumActivity.this.jXu) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cHE.cGX()), Integer.valueOf(cHE.cGY())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.jXr.cHF().notifyDataSetChanged();
            SignAllForumProgressView cHC = SignAllForumActivity.this.jXr.cHC();
            if (!cHE.cGW()) {
                if (hVar.cHq() != 0) {
                    SignAllForumActivity.this.Iv(hVar.cGO());
                    SignAllForumActivity.this.Fy.aCp();
                } else if (hVar.cHs() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cHt());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Fy == null || !SignAllForumActivity.this.Fy.isShowing()) {
                SignAllForumActivity.this.cHl();
            }
            cHC.setSignSuccess();
            SignAllForumActivity.this.b(cHE);
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
    public void cHl() {
        if (this.jXr != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aJl().a(getPageContext(), this.jXr.bqY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cGF = cVar.cGF();
            final String aPw = cVar.aPw();
            final boolean cGT = cVar.cGT();
            if (cVar.cGE()) {
                this.jXr.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cGF, aPw, Boolean.valueOf(cGT))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu(String str) {
        if (this.jXu) {
            c cHE = this.jXr.cHE();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cHE.cGS().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.jXr.cHC().setSignSuccess();
        ArrayList<d> cGS = this.jXr.cHE().cGS();
        int size = cGS.size();
        for (int i = 0; i < size; i++) {
            d dVar = cGS.get(i);
            dVar.sw(true);
            dVar.sx(false);
            dVar.sv(false);
        }
        this.jXr.cHF().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aIn() {
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
        aIn();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.jXw);
        initData();
        initUI();
    }

    private void initUI() {
        this.jXr = new j(this);
        this.jXr.setListPullRefreshListener(this);
        this.jXr.setOnItemClickListener(this);
        if (this.jXt.isRunning) {
            this.jXx.a(this.jXt.cHw());
            this.jXr.cHC().setSigning(90);
            return;
        }
        this.jXr.startPullRefresh();
    }

    private void initData() {
        this.jXs = new GetForumListModel(this);
        this.jXs.a(this.jXx);
        this.jXt = new SignAllForumModel(this);
        this.jXt.a(this.jXy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jXr.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.jXr.completeRefresh();
        } else if (this.jXs == null) {
            showToast(R.string.neterror);
        } else if (!this.jXs.LoadData()) {
            this.jXr.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cHE = this.jXr.cHE();
        if (view == this.jXr.getProgressBar()) {
            if (cHE != null) {
                if (cHE.getBlockPopInfoData() != null) {
                    if (cHE.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cHE.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCu();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cHE.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.jXr.cHC().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cHE.cGN() != 0) {
                        Iv(cHE.cGO());
                        this.Fy.aCp();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jXv = true;
                        cHm();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.jXr.cHG()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cHm() {
        c cHE = this.jXr.cHE();
        this.jXr.cHC().setDuration(Math.max(cHE.cGS().size() * 50, 2000));
        this.jXr.cHC().setSigning(0);
        this.jXt.d(cHE);
        this.jXt.LoadData();
        this.jXr.cHF().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.jXr.cHF().getItemViewType(i) == 0 && this.jXr.cHE() != null && this.jXr.cHE().cGP() != null && this.jXr.cHE().cGP().size() > i && (dVar = this.jXr.cHE().cGP().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv(String str) {
        this.Fy = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).sC(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Fy.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jXt != null && this.jXt.isRunning) {
            cHn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Fy != null && this.Fy.isShowing()) {
            this.Fy.dismiss();
        }
        if (this.jXs != null) {
            this.jXs.cancelLoadData();
            this.jXs = null;
        }
        if (this.jXr != null && this.jXr.cHF() != null) {
            this.jXr.cHF().cHo();
        }
        if (this.jXt != null) {
            if (this.jXt.isRunning) {
                cHn();
            }
            this.jXt.cancelMessage();
            this.jXt = null;
        }
        if (this.jXs != null) {
            this.jXs.cancelLoadData();
            this.jXs = null;
        }
    }

    private void cHn() {
        this.jXu = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.jXr == null || this.jXr.cHD() == null) {
            return null;
        }
        return this.jXr.cHD().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
