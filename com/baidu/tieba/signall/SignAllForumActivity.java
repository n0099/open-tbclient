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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements h.c {
    private com.baidu.tbadk.core.dialog.a TD;
    private j iQC;
    private GetForumListModel iQD;
    private SignAllForumModel iQE;
    private boolean iQF;
    private boolean isDestory;
    private boolean iQG = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.iQC.ckE().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener iQH = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c ckG;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (ckG = SignAllForumActivity.this.iQC.ckG()) != null) {
                ckG.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.iQC.ckH().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a iQI = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.iQC.oy();
            a cjS = cVar.cjS();
            if (cjS != null && cjS.getErrorNumber() == 0) {
                SignAllForumActivity.this.iQC.a(cVar, SignAllForumActivity.this.iQD.ckl());
                return;
            }
            SignAllForumActivity.this.showToast(cjS.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void yo(String str) {
            SignAllForumActivity.this.iQC.oy();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a iQJ = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void yo(String str) {
            SignAllForumActivity.this.DE(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.iQG) {
                SignAllForumActivity.this.iQG = false;
                BdToast.b(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).afO();
                if (SignAllForumActivity.this.iQC != null && SignAllForumActivity.this.iQC.ckE() != null) {
                    SignAllForumActivity.this.iQC.ckE().setSignBefore(0);
                    return;
                }
                return;
            }
            a cjS = hVar.cjS();
            if (cjS == null || cjS.getErrorNumber() != 0) {
                SignAllForumActivity.this.DE(cjS.getUserMsg());
                return;
            }
            c ckG = SignAllForumActivity.this.iQC.ckG();
            ckG.a(hVar);
            if (SignAllForumActivity.this.iQF) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(ckG.cjZ()), Integer.valueOf(ckG.cka())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.iQC.ckH().notifyDataSetChanged();
            SignAllForumProgressView ckE = SignAllForumActivity.this.iQC.ckE();
            if (!ckG.cjY()) {
                if (hVar.cks() != 0) {
                    SignAllForumActivity.this.DF(hVar.cjQ());
                    SignAllForumActivity.this.TD.afG();
                } else if (hVar.cku() != 0) {
                    SignAllForumActivity.this.showToast(hVar.ckv());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.TD == null || !SignAllForumActivity.this.TD.isShowing()) {
                SignAllForumActivity.this.ckn();
            }
            ckE.setSignSuccess();
            SignAllForumActivity.this.b(ckG);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTe));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTe));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ckn() {
        if (this.iQC != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.anA().a(getPageContext(), this.iQC.bld());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cjH = cVar.cjH();
            final String auQ = cVar.auQ();
            final boolean cjV = cVar.cjV();
            if (cVar.cjG()) {
                this.iQC.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cjH, auQ, Boolean.valueOf(cjV))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE(String str) {
        if (this.iQF) {
            c ckG = this.iQC.ckG();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(ckG.cjU().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.iQC.ckE().setSignSuccess();
        ArrayList<d> cjU = this.iQC.ckG().cjU();
        int size = cjU.size();
        for (int i = 0; i < size; i++) {
            d dVar = cjU.get(i);
            dVar.qA(true);
            dVar.qB(false);
            dVar.qz(false);
        }
        this.iQC.ckH().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void amC() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bc.cD(getActivity());
            finish();
            return;
        }
        amC();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.iQH);
        initData();
        initUI();
    }

    private void initUI() {
        this.iQC = new j(this);
        this.iQC.setListPullRefreshListener(this);
        this.iQC.setOnItemClickListener(this);
        if (this.iQE.isRunning) {
            this.iQI.a(this.iQE.cky());
            this.iQC.ckE().setSigning(90);
            return;
        }
        this.iQC.startPullRefresh();
    }

    private void initData() {
        this.iQD = new GetForumListModel(this);
        this.iQD.a(this.iQI);
        this.iQE = new SignAllForumModel(this);
        this.iQE.a(this.iQJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iQC.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        if (!com.baidu.adp.lib.util.j.jS()) {
            showToast(R.string.neterror);
            this.iQC.oy();
        } else if (this.iQD == null) {
            showToast(R.string.neterror);
        } else if (!this.iQD.LoadData()) {
            this.iQC.oy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c ckG = this.iQC.ckG();
        if (view == this.iQC.getProgressBar()) {
            if (ckG != null) {
                if (ckG.getBlockPopInfoData() != null) {
                    if (ckG.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.b(getPageContext().getPageActivity(), ckG.getBlockPopInfoData().appeal_msg, R.drawable.icon_toast_game_error, 3000).afO();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), ckG.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTe));
                    }
                } else if (this.iQC.ckE().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (ckG.cjP() != 0) {
                        DF(ckG.cjQ());
                        this.TD.afG();
                    } else if (com.baidu.adp.lib.util.j.jS()) {
                        this.iQG = true;
                        cko();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.iQC.ckI()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void cko() {
        c ckG = this.iQC.ckG();
        this.iQC.ckE().setDuration(Math.max(ckG.cjU().size() * 50, 2000));
        this.iQC.ckE().setSigning(0);
        this.iQE.d(ckG);
        this.iQE.LoadData();
        this.iQC.ckH().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.iQC.ckH().getItemViewType(i) == 0 && this.iQC.ckG() != null && this.iQC.ckG().cjR() != null && this.iQC.ckG().cjR().size() > i && (dVar = this.iQC.ckG().cjR().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF(String str) {
        this.TD = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).mD(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.TD.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iQE != null && this.iQE.isRunning) {
            ckp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.TD != null && this.TD.isShowing()) {
            this.TD.dismiss();
        }
        if (this.iQD != null) {
            this.iQD.cancelLoadData();
            this.iQD = null;
        }
        if (this.iQC != null && this.iQC.ckH() != null) {
            this.iQC.ckH().ckq();
        }
        if (this.iQE != null) {
            if (this.iQE.isRunning) {
                ckp();
            }
            this.iQE.cancelMessage();
            this.iQE = null;
        }
        if (this.iQD != null) {
            this.iQD.cancelLoadData();
            this.iQD = null;
        }
    }

    private void ckp() {
        this.iQF = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.iQC == null || this.iQC.ckF() == null) {
            return null;
        }
        return this.iQC.ckF().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
