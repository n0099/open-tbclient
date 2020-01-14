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
    private j jXw;
    private GetForumListModel jXx;
    private SignAllForumModel jXy;
    private boolean jXz;
    private boolean jXA = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.jXw.cHE().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener jXB = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cHG;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cHG = SignAllForumActivity.this.jXw.cHG()) != null) {
                cHG.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.jXw.cHH().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a jXC = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.jXw.completeRefresh();
            a cGS = cVar.cGS();
            if (cGS != null && cGS.getErrorNumber() == 0) {
                SignAllForumActivity.this.jXw.a(cVar, SignAllForumActivity.this.jXx.cHl());
                return;
            }
            SignAllForumActivity.this.showToast(cGS.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void CK(String str) {
            SignAllForumActivity.this.jXw.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a jXD = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void CK(String str) {
            SignAllForumActivity.this.Iu(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.jXA) {
                SignAllForumActivity.this.jXA = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCu();
                if (SignAllForumActivity.this.jXw != null && SignAllForumActivity.this.jXw.cHE() != null) {
                    SignAllForumActivity.this.jXw.cHE().setSignBefore(0);
                    return;
                }
                return;
            }
            a cGS = hVar.cGS();
            if (cGS == null || cGS.getErrorNumber() != 0) {
                SignAllForumActivity.this.Iu(cGS.getUserMsg());
                return;
            }
            c cHG = SignAllForumActivity.this.jXw.cHG();
            cHG.a(hVar);
            if (SignAllForumActivity.this.jXz) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cHG.cGZ()), Integer.valueOf(cHG.cHa())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.jXw.cHH().notifyDataSetChanged();
            SignAllForumProgressView cHE = SignAllForumActivity.this.jXw.cHE();
            if (!cHG.cGY()) {
                if (hVar.cHs() != 0) {
                    SignAllForumActivity.this.Iv(hVar.cGQ());
                    SignAllForumActivity.this.Fy.aCp();
                } else if (hVar.cHu() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cHv());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Fy == null || !SignAllForumActivity.this.Fy.isShowing()) {
                SignAllForumActivity.this.cHn();
            }
            cHE.setSignSuccess();
            SignAllForumActivity.this.b(cHG);
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
    public void cHn() {
        if (this.jXw != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aJl().a(getPageContext(), this.jXw.bqY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cGH = cVar.cGH();
            final String aPw = cVar.aPw();
            final boolean cGV = cVar.cGV();
            if (cVar.cGG()) {
                this.jXw.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cGH, aPw, Boolean.valueOf(cGV))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu(String str) {
        if (this.jXz) {
            c cHG = this.jXw.cHG();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cHG.cGU().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.jXw.cHE().setSignSuccess();
        ArrayList<d> cGU = this.jXw.cHG().cGU();
        int size = cGU.size();
        for (int i = 0; i < size; i++) {
            d dVar = cGU.get(i);
            dVar.sw(true);
            dVar.sx(false);
            dVar.sv(false);
        }
        this.jXw.cHH().notifyDataSetChanged();
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
        registerListener(this.jXB);
        initData();
        initUI();
    }

    private void initUI() {
        this.jXw = new j(this);
        this.jXw.setListPullRefreshListener(this);
        this.jXw.setOnItemClickListener(this);
        if (this.jXy.isRunning) {
            this.jXC.a(this.jXy.cHy());
            this.jXw.cHE().setSigning(90);
            return;
        }
        this.jXw.startPullRefresh();
    }

    private void initData() {
        this.jXx = new GetForumListModel(this);
        this.jXx.a(this.jXC);
        this.jXy = new SignAllForumModel(this);
        this.jXy.a(this.jXD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jXw.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.jXw.completeRefresh();
        } else if (this.jXx == null) {
            showToast(R.string.neterror);
        } else if (!this.jXx.LoadData()) {
            this.jXw.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cHG = this.jXw.cHG();
        if (view == this.jXw.getProgressBar()) {
            if (cHG != null) {
                if (cHG.getBlockPopInfoData() != null) {
                    if (cHG.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cHG.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCu();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cHG.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.jXw.cHE().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cHG.cGP() != 0) {
                        Iv(cHG.cGQ());
                        this.Fy.aCp();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jXA = true;
                        cHo();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.jXw.cHI()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cHo() {
        c cHG = this.jXw.cHG();
        this.jXw.cHE().setDuration(Math.max(cHG.cGU().size() * 50, 2000));
        this.jXw.cHE().setSigning(0);
        this.jXy.d(cHG);
        this.jXy.LoadData();
        this.jXw.cHH().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.jXw.cHH().getItemViewType(i) == 0 && this.jXw.cHG() != null && this.jXw.cHG().cGR() != null && this.jXw.cHG().cGR().size() > i && (dVar = this.jXw.cHG().cGR().get(i)) != null) {
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
        if (this.jXy != null && this.jXy.isRunning) {
            cHp();
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
        if (this.jXx != null) {
            this.jXx.cancelLoadData();
            this.jXx = null;
        }
        if (this.jXw != null && this.jXw.cHH() != null) {
            this.jXw.cHH().cHq();
        }
        if (this.jXy != null) {
            if (this.jXy.isRunning) {
                cHp();
            }
            this.jXy.cancelMessage();
            this.jXy = null;
        }
        if (this.jXx != null) {
            this.jXx.cancelLoadData();
            this.jXx = null;
        }
    }

    private void cHp() {
        this.jXz = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.jXw == null || this.jXw.cHF() == null) {
            return null;
        }
        return this.jXw.cHF().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
