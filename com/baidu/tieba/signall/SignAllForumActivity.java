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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.f;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements g.b {
    private com.baidu.tbadk.core.dialog.a Qj;
    private j gEM;
    private GetForumListModel gEN;
    private SignAllForumModel gEO;
    private boolean gEP;
    private boolean isDestory;
    private boolean gEQ = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gEM.btb().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gER = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c btd;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (btd = SignAllForumActivity.this.gEM.btd()) != null) {
                btd.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gEM.bte().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gES = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gEM.nV();
            a bsp = cVar.bsp();
            if (bsp != null && bsp.getErrorNumber() == 0) {
                SignAllForumActivity.this.gEM.a(cVar, SignAllForumActivity.this.gEN.bsI());
                return;
            }
            SignAllForumActivity.this.showToast(bsp.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void or(String str) {
            SignAllForumActivity.this.gEM.nV();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gET = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void or(String str) {
            SignAllForumActivity.this.tu(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.gEQ) {
                SignAllForumActivity.this.gEQ = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), f.C0146f.icon_toast_game_error, 3000).xm();
                if (SignAllForumActivity.this.gEM != null && SignAllForumActivity.this.gEM.btb() != null) {
                    SignAllForumActivity.this.gEM.btb().setSignBefore(0);
                    return;
                }
                return;
            }
            a bsp = hVar.bsp();
            if (bsp == null || bsp.getErrorNumber() != 0) {
                SignAllForumActivity.this.tu(bsp.getUserMsg());
                return;
            }
            c btd = SignAllForumActivity.this.gEM.btd();
            btd.a(hVar);
            if (SignAllForumActivity.this.gEP) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(f.j.signallforum_back_finish, new Object[]{Integer.valueOf(btd.bsw()), Integer.valueOf(btd.bsx())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gEM.bte().notifyDataSetChanged();
            SignAllForumProgressView btb = SignAllForumActivity.this.gEM.btb();
            if (!btd.bsv()) {
                if (hVar.bsO() != 0) {
                    SignAllForumActivity.this.tv(hVar.bsn());
                    SignAllForumActivity.this.Qj.xe();
                } else if (hVar.bsQ() != 0) {
                    SignAllForumActivity.this.showToast(hVar.bsR());
                } else {
                    SignAllForumActivity.this.showToast(f.j.signallforum_error);
                }
            }
            btb.setSignSuccess();
            SignAllForumActivity.this.b(btd);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.ars));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.ars));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bse = cVar.bse();
            final String Lg = cVar.Lg();
            final boolean bss = cVar.bss();
            if (cVar.bsd()) {
                this.gEM.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bse, Lg, Boolean.valueOf(bss))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(String str) {
        if (this.gEP) {
            c btd = this.gEM.btd();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(f.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(btd.bsr().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gEM.btb().setSignSuccess();
        ArrayList<d> bsr = this.gEM.btd().bsr();
        int size = bsr.size();
        for (int i = 0; i < size; i++) {
            d dVar = bsr.get(i);
            dVar.me(true);
            dVar.mf(false);
            dVar.md(false);
        }
        this.gEM.bte().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), f.C0146f.singnallforum_progress, getPageContext().getString(f.j.app_name), str, str, pendingIntent, z);
    }

    private void Dp() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), f.C0146f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bb.aT(getActivity());
            finish();
            return;
        }
        Dp();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gER);
        initData();
        initUI();
    }

    private void initUI() {
        this.gEM = new j(this);
        this.gEM.a(this);
        this.gEM.setOnItemClickListener(this);
        if (this.gEO.isRunning) {
            this.gES.a(this.gEO.bsU());
            this.gEM.btb().setSigning(90);
            return;
        }
        this.gEM.startPullRefresh();
    }

    private void initData() {
        this.gEN = new GetForumListModel(this);
        this.gEN.a(this.gES);
        this.gEO = new SignAllForumModel(this);
        this.gEO.a(this.gET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gEM.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aT(boolean z) {
        if (!com.baidu.adp.lib.util.j.jE()) {
            showToast(f.j.neterror);
            this.gEM.nV();
        } else if (this.gEN == null) {
            showToast(f.j.neterror);
        } else if (!this.gEN.LoadData()) {
            this.gEM.nV();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c btd = this.gEM.btd();
        if (view == this.gEM.getProgressBar()) {
            if (btd != null) {
                if (btd.getBlockPopInfoData() != null) {
                    if (btd.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), btd.getBlockPopInfoData().appeal_msg, f.C0146f.icon_toast_game_error, 3000).xm();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), btd.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").r("obj_locate", at.a.ars));
                    }
                } else if (this.gEM.btb().getCurrentStatus() == 2) {
                    showToast(f.j.signallforum_finished);
                } else {
                    if (btd.bsm() != 0) {
                        tv(btd.bsn());
                        this.Qj.xe();
                    } else if (com.baidu.adp.lib.util.j.jE()) {
                        this.gEQ = true;
                        bsK();
                    } else {
                        showToast(f.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.gEM.btf()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void bsK() {
        c btd = this.gEM.btd();
        this.gEM.btb().setDuration(Math.max(btd.bsr().size() * 50, 2000));
        this.gEM.btb().setSigning(0);
        this.gEO.d(btd);
        this.gEO.LoadData();
        this.gEM.bte().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gEM.bte().getItemViewType(i) == 0 && this.gEM.btd() != null && this.gEM.btd().bso() != null && this.gEM.btd().bso().size() > i && (dVar = this.gEM.btd().bso().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(String str) {
        this.Qj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dB(str).a(f.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
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
        if (this.gEO != null && this.gEO.isRunning) {
            bsL();
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
        if (this.gEN != null) {
            this.gEN.cancelLoadData();
            this.gEN = null;
        }
        if (this.gEM != null && this.gEM.bte() != null) {
            this.gEM.bte().bsM();
        }
        if (this.gEO != null) {
            if (this.gEO.isRunning) {
                bsL();
            }
            this.gEO.cancelMessage();
            this.gEO = null;
        }
        if (this.gEN != null) {
            this.gEN.cancelLoadData();
            this.gEN = null;
        }
    }

    private void bsL() {
        this.gEP = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(f.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gEM == null || this.gEM.btc() == null) {
            return null;
        }
        return this.gEM.btc().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
