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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements g.b {
    private com.baidu.tbadk.core.dialog.a Qj;
    private j gEJ;
    private GetForumListModel gEK;
    private SignAllForumModel gEL;
    private boolean gEM;
    private boolean isDestory;
    private boolean gEN = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gEJ.bta().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gEO = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c btc;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (btc = SignAllForumActivity.this.gEJ.btc()) != null) {
                btc.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gEJ.btd().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gEP = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gEJ.nY();
            a bso = cVar.bso();
            if (bso != null && bso.getErrorNumber() == 0) {
                SignAllForumActivity.this.gEJ.a(cVar, SignAllForumActivity.this.gEK.bsH());
                return;
            }
            SignAllForumActivity.this.showToast(bso.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void op(String str) {
            SignAllForumActivity.this.gEJ.nY();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gEQ = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void op(String str) {
            SignAllForumActivity.this.tq(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.gEN) {
                SignAllForumActivity.this.gEN = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).xn();
                if (SignAllForumActivity.this.gEJ != null && SignAllForumActivity.this.gEJ.bta() != null) {
                    SignAllForumActivity.this.gEJ.bta().setSignBefore(0);
                    return;
                }
                return;
            }
            a bso = hVar.bso();
            if (bso == null || bso.getErrorNumber() != 0) {
                SignAllForumActivity.this.tq(bso.getUserMsg());
                return;
            }
            c btc = SignAllForumActivity.this.gEJ.btc();
            btc.a(hVar);
            if (SignAllForumActivity.this.gEM) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{Integer.valueOf(btc.bsv()), Integer.valueOf(btc.bsw())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gEJ.btd().notifyDataSetChanged();
            SignAllForumProgressView bta = SignAllForumActivity.this.gEJ.bta();
            if (!btc.bsu()) {
                if (hVar.bsN() != 0) {
                    SignAllForumActivity.this.tr(hVar.bsm());
                    SignAllForumActivity.this.Qj.xf();
                } else if (hVar.bsP() != 0) {
                    SignAllForumActivity.this.showToast(hVar.bsQ());
                } else {
                    SignAllForumActivity.this.showToast(d.j.signallforum_error);
                }
            }
            bta.setSignSuccess();
            SignAllForumActivity.this.b(btc);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arr));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arr));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bsd = cVar.bsd();
            final String Lc = cVar.Lc();
            final boolean bsr = cVar.bsr();
            if (cVar.bsc()) {
                this.gEJ.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bsd, Lc, Boolean.valueOf(bsr))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(String str) {
        if (this.gEM) {
            c btc = this.gEJ.btc();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(btc.bsq().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gEJ.bta().setSignSuccess();
        ArrayList<d> bsq = this.gEJ.btc().bsq();
        int size = bsq.size();
        for (int i = 0; i < size; i++) {
            d dVar = bsq.get(i);
            dVar.me(true);
            dVar.mf(false);
            dVar.md(false);
        }
        this.gEJ.btd().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.j.app_name), str, str, pendingIntent, z);
    }

    private void Dp() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ba.aU(getActivity());
            finish();
            return;
        }
        Dp();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gEO);
        initData();
        initUI();
    }

    private void initUI() {
        this.gEJ = new j(this);
        this.gEJ.a(this);
        this.gEJ.setOnItemClickListener(this);
        if (this.gEL.isRunning) {
            this.gEP.a(this.gEL.bsT());
            this.gEJ.bta().setSigning(90);
            return;
        }
        this.gEJ.startPullRefresh();
    }

    private void initData() {
        this.gEK = new GetForumListModel(this);
        this.gEK.a(this.gEP);
        this.gEL = new SignAllForumModel(this);
        this.gEL.a(this.gEQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gEJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aS(boolean z) {
        if (!com.baidu.adp.lib.util.j.jE()) {
            showToast(d.j.neterror);
            this.gEJ.nY();
        } else if (this.gEK == null) {
            showToast(d.j.neterror);
        } else if (!this.gEK.LoadData()) {
            this.gEJ.nY();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c btc = this.gEJ.btc();
        if (view == this.gEJ.getProgressBar()) {
            if (btc != null) {
                if (btc.getBlockPopInfoData() != null) {
                    if (btc.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), btc.getBlockPopInfoData().appeal_msg, d.f.icon_toast_game_error, 3000).xn();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), btc.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arr));
                    }
                } else if (this.gEJ.bta().getCurrentStatus() == 2) {
                    showToast(d.j.signallforum_finished);
                } else {
                    if (btc.bsl() != 0) {
                        tr(btc.bsm());
                        this.Qj.xf();
                    } else if (com.baidu.adp.lib.util.j.jE()) {
                        this.gEN = true;
                        bsJ();
                    } else {
                        showToast(d.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.gEJ.bte()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void bsJ() {
        c btc = this.gEJ.btc();
        this.gEJ.bta().setDuration(Math.max(btc.bsq().size() * 50, 2000));
        this.gEJ.bta().setSigning(0);
        this.gEL.d(btc);
        this.gEL.LoadData();
        this.gEJ.btd().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gEJ.btd().getItemViewType(i) == 0 && this.gEJ.btc() != null && this.gEJ.btc().bsn() != null && this.gEJ.btc().bsn().size() > i && (dVar = this.gEJ.btc().bsn().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr(String str) {
        this.Qj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dB(str).a(d.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Qj.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gEL != null && this.gEL.isRunning) {
            bsK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Qj != null && this.Qj.isShowing()) {
            this.Qj.dismiss();
        }
        if (this.gEK != null) {
            this.gEK.cancelLoadData();
            this.gEK = null;
        }
        if (this.gEJ != null && this.gEJ.btd() != null) {
            this.gEJ.btd().bsL();
        }
        if (this.gEL != null) {
            if (this.gEL.isRunning) {
                bsK();
            }
            this.gEL.cancelMessage();
            this.gEL = null;
        }
        if (this.gEK != null) {
            this.gEK.cancelLoadData();
            this.gEK = null;
        }
    }

    private void bsK() {
        this.gEM = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gEJ == null || this.gEJ.btb() == null) {
            return null;
        }
        return this.gEJ.btb().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
