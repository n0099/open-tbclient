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
    private j iQw;
    private GetForumListModel iQx;
    private SignAllForumModel iQy;
    private boolean iQz;
    private boolean isDestory;
    private boolean iQA = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.iQw.ckB().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener iQB = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c ckD;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (ckD = SignAllForumActivity.this.iQw.ckD()) != null) {
                ckD.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.iQw.ckE().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a iQC = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.iQw.oy();
            a cjP = cVar.cjP();
            if (cjP != null && cjP.getErrorNumber() == 0) {
                SignAllForumActivity.this.iQw.a(cVar, SignAllForumActivity.this.iQx.cki());
                return;
            }
            SignAllForumActivity.this.showToast(cjP.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void ym(String str) {
            SignAllForumActivity.this.iQw.oy();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a iQD = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void ym(String str) {
            SignAllForumActivity.this.DC(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.iQA) {
                SignAllForumActivity.this.iQA = false;
                BdToast.b(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).afO();
                if (SignAllForumActivity.this.iQw != null && SignAllForumActivity.this.iQw.ckB() != null) {
                    SignAllForumActivity.this.iQw.ckB().setSignBefore(0);
                    return;
                }
                return;
            }
            a cjP = hVar.cjP();
            if (cjP == null || cjP.getErrorNumber() != 0) {
                SignAllForumActivity.this.DC(cjP.getUserMsg());
                return;
            }
            c ckD = SignAllForumActivity.this.iQw.ckD();
            ckD.a(hVar);
            if (SignAllForumActivity.this.iQz) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(ckD.cjW()), Integer.valueOf(ckD.cjX())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.iQw.ckE().notifyDataSetChanged();
            SignAllForumProgressView ckB = SignAllForumActivity.this.iQw.ckB();
            if (!ckD.cjV()) {
                if (hVar.ckp() != 0) {
                    SignAllForumActivity.this.DD(hVar.cjN());
                    SignAllForumActivity.this.TF.afG();
                } else if (hVar.ckr() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cks());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.TF == null || !SignAllForumActivity.this.TF.isShowing()) {
                SignAllForumActivity.this.ckk();
            }
            ckB.setSignSuccess();
            SignAllForumActivity.this.b(ckD);
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
    public void ckk() {
        if (this.iQw != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.anA().a(getPageContext(), this.iQw.bla());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cjE = cVar.cjE();
            final String auQ = cVar.auQ();
            final boolean cjS = cVar.cjS();
            if (cVar.cjD()) {
                this.iQw.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cjE, auQ, Boolean.valueOf(cjS))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC(String str) {
        if (this.iQz) {
            c ckD = this.iQw.ckD();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(ckD.cjR().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.iQw.ckB().setSignSuccess();
        ArrayList<d> cjR = this.iQw.ckD().cjR();
        int size = cjR.size();
        for (int i = 0; i < size; i++) {
            d dVar = cjR.get(i);
            dVar.qz(true);
            dVar.qA(false);
            dVar.qy(false);
        }
        this.iQw.ckE().notifyDataSetChanged();
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
        registerListener(this.iQB);
        initData();
        initUI();
    }

    private void initUI() {
        this.iQw = new j(this);
        this.iQw.setListPullRefreshListener(this);
        this.iQw.setOnItemClickListener(this);
        if (this.iQy.isRunning) {
            this.iQC.a(this.iQy.ckv());
            this.iQw.ckB().setSigning(90);
            return;
        }
        this.iQw.startPullRefresh();
    }

    private void initData() {
        this.iQx = new GetForumListModel(this);
        this.iQx.a(this.iQC);
        this.iQy = new SignAllForumModel(this);
        this.iQy.a(this.iQD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iQw.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        if (!com.baidu.adp.lib.util.j.jS()) {
            showToast(R.string.neterror);
            this.iQw.oy();
        } else if (this.iQx == null) {
            showToast(R.string.neterror);
        } else if (!this.iQx.LoadData()) {
            this.iQw.oy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c ckD = this.iQw.ckD();
        if (view == this.iQw.getProgressBar()) {
            if (ckD != null) {
                if (ckD.getBlockPopInfoData() != null) {
                    if (ckD.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.b(getPageContext().getPageActivity(), ckD.getBlockPopInfoData().appeal_msg, R.drawable.icon_toast_game_error, 3000).afO();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), ckD.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTd));
                    }
                } else if (this.iQw.ckB().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (ckD.cjM() != 0) {
                        DD(ckD.cjN());
                        this.TF.afG();
                    } else if (com.baidu.adp.lib.util.j.jS()) {
                        this.iQA = true;
                        ckl();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.iQw.ckF()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void ckl() {
        c ckD = this.iQw.ckD();
        this.iQw.ckB().setDuration(Math.max(ckD.cjR().size() * 50, 2000));
        this.iQw.ckB().setSigning(0);
        this.iQy.d(ckD);
        this.iQy.LoadData();
        this.iQw.ckE().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.iQw.ckE().getItemViewType(i) == 0 && this.iQw.ckD() != null && this.iQw.ckD().cjO() != null && this.iQw.ckD().cjO().size() > i && (dVar = this.iQw.ckD().cjO().get(i)) != null) {
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
        if (this.iQy != null && this.iQy.isRunning) {
            ckm();
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
        if (this.iQx != null) {
            this.iQx.cancelLoadData();
            this.iQx = null;
        }
        if (this.iQw != null && this.iQw.ckE() != null) {
            this.iQw.ckE().ckn();
        }
        if (this.iQy != null) {
            if (this.iQy.isRunning) {
                ckm();
            }
            this.iQy.cancelMessage();
            this.iQy = null;
        }
        if (this.iQx != null) {
            this.iQx.cancelLoadData();
            this.iQx = null;
        }
    }

    private void ckm() {
        this.iQz = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.iQw == null || this.iQw.ckC() == null) {
            return null;
        }
        return this.iQw.ckC().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
