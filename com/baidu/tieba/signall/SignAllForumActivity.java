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
    private com.baidu.tbadk.core.dialog.a TF;
    private SignAllForumModel iQA;
    private boolean iQB;
    private j iQy;
    private GetForumListModel iQz;
    private boolean isDestory;
    private boolean iQC = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.iQy.ckD().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener iQD = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c ckF;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (ckF = SignAllForumActivity.this.iQy.ckF()) != null) {
                ckF.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.iQy.ckG().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a iQE = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.iQy.oy();
            a cjR = cVar.cjR();
            if (cjR != null && cjR.getErrorNumber() == 0) {
                SignAllForumActivity.this.iQy.a(cVar, SignAllForumActivity.this.iQz.ckk());
                return;
            }
            SignAllForumActivity.this.showToast(cjR.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void ym(String str) {
            SignAllForumActivity.this.iQy.oy();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a iQF = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void ym(String str) {
            SignAllForumActivity.this.DC(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.iQC) {
                SignAllForumActivity.this.iQC = false;
                BdToast.b(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).afO();
                if (SignAllForumActivity.this.iQy != null && SignAllForumActivity.this.iQy.ckD() != null) {
                    SignAllForumActivity.this.iQy.ckD().setSignBefore(0);
                    return;
                }
                return;
            }
            a cjR = hVar.cjR();
            if (cjR == null || cjR.getErrorNumber() != 0) {
                SignAllForumActivity.this.DC(cjR.getUserMsg());
                return;
            }
            c ckF = SignAllForumActivity.this.iQy.ckF();
            ckF.a(hVar);
            if (SignAllForumActivity.this.iQB) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(ckF.cjY()), Integer.valueOf(ckF.cjZ())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.iQy.ckG().notifyDataSetChanged();
            SignAllForumProgressView ckD = SignAllForumActivity.this.iQy.ckD();
            if (!ckF.cjX()) {
                if (hVar.ckr() != 0) {
                    SignAllForumActivity.this.DD(hVar.cjP());
                    SignAllForumActivity.this.TF.afG();
                } else if (hVar.ckt() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cku());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.TF == null || !SignAllForumActivity.this.TF.isShowing()) {
                SignAllForumActivity.this.ckm();
            }
            ckD.setSignSuccess();
            SignAllForumActivity.this.b(ckF);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTd));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTd));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ckm() {
        if (this.iQy != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.anA().a(getPageContext(), this.iQy.bld());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cjG = cVar.cjG();
            final String auQ = cVar.auQ();
            final boolean cjU = cVar.cjU();
            if (cVar.cjF()) {
                this.iQy.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cjG, auQ, Boolean.valueOf(cjU))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC(String str) {
        if (this.iQB) {
            c ckF = this.iQy.ckF();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(ckF.cjT().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.iQy.ckD().setSignSuccess();
        ArrayList<d> cjT = this.iQy.ckF().cjT();
        int size = cjT.size();
        for (int i = 0; i < size; i++) {
            d dVar = cjT.get(i);
            dVar.qz(true);
            dVar.qA(false);
            dVar.qy(false);
        }
        this.iQy.ckG().notifyDataSetChanged();
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
        registerListener(this.iQD);
        initData();
        initUI();
    }

    private void initUI() {
        this.iQy = new j(this);
        this.iQy.setListPullRefreshListener(this);
        this.iQy.setOnItemClickListener(this);
        if (this.iQA.isRunning) {
            this.iQE.a(this.iQA.ckx());
            this.iQy.ckD().setSigning(90);
            return;
        }
        this.iQy.startPullRefresh();
    }

    private void initData() {
        this.iQz = new GetForumListModel(this);
        this.iQz.a(this.iQE);
        this.iQA = new SignAllForumModel(this);
        this.iQA.a(this.iQF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iQy.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        if (!com.baidu.adp.lib.util.j.jS()) {
            showToast(R.string.neterror);
            this.iQy.oy();
        } else if (this.iQz == null) {
            showToast(R.string.neterror);
        } else if (!this.iQz.LoadData()) {
            this.iQy.oy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c ckF = this.iQy.ckF();
        if (view == this.iQy.getProgressBar()) {
            if (ckF != null) {
                if (ckF.getBlockPopInfoData() != null) {
                    if (ckF.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.b(getPageContext().getPageActivity(), ckF.getBlockPopInfoData().appeal_msg, R.drawable.icon_toast_game_error, 3000).afO();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), ckF.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTd));
                    }
                } else if (this.iQy.ckD().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (ckF.cjO() != 0) {
                        DD(ckF.cjP());
                        this.TF.afG();
                    } else if (com.baidu.adp.lib.util.j.jS()) {
                        this.iQC = true;
                        ckn();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.iQy.ckH()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void ckn() {
        c ckF = this.iQy.ckF();
        this.iQy.ckD().setDuration(Math.max(ckF.cjT().size() * 50, 2000));
        this.iQy.ckD().setSigning(0);
        this.iQA.d(ckF);
        this.iQA.LoadData();
        this.iQy.ckG().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.iQy.ckG().getItemViewType(i) == 0 && this.iQy.ckF() != null && this.iQy.ckF().cjQ() != null && this.iQy.ckF().cjQ().size() > i && (dVar = this.iQy.ckF().cjQ().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD(String str) {
        this.TF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).mE(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.TF.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iQA != null && this.iQA.isRunning) {
            cko();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.TF != null && this.TF.isShowing()) {
            this.TF.dismiss();
        }
        if (this.iQz != null) {
            this.iQz.cancelLoadData();
            this.iQz = null;
        }
        if (this.iQy != null && this.iQy.ckG() != null) {
            this.iQy.ckG().ckp();
        }
        if (this.iQA != null) {
            if (this.iQA.isRunning) {
                cko();
            }
            this.iQA.cancelMessage();
            this.iQA = null;
        }
        if (this.iQz != null) {
            this.iQz.cancelLoadData();
            this.iQz = null;
        }
    }

    private void cko() {
        this.iQB = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.iQy == null || this.iQy.ckE() == null) {
            return null;
        }
        return this.iQy.ckE().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
