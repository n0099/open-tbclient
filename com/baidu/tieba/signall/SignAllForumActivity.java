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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements g.b {
    private com.baidu.tbadk.core.dialog.a Qm;
    private j gDB;
    private GetForumListModel gDC;
    private SignAllForumModel gDD;
    private boolean gDE;
    private boolean isDestory;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gDB.bux().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gDF = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c buz;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (buz = SignAllForumActivity.this.gDB.buz()) != null) {
                buz.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gDB.buA().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gDG = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gDB.nW();
            a btL = cVar.btL();
            if (btL != null && btL.getErrorNumber() == 0) {
                SignAllForumActivity.this.gDB.a(cVar, SignAllForumActivity.this.gDC.bue());
                return;
            }
            SignAllForumActivity.this.showToast(btL.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void om(String str) {
            SignAllForumActivity.this.gDB.nW();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gDH = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void om(String str) {
            SignAllForumActivity.this.ts(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            a btL = hVar.btL();
            if (btL == null || btL.getErrorNumber() != 0) {
                SignAllForumActivity.this.ts(btL.getUserMsg());
                return;
            }
            c buz = SignAllForumActivity.this.gDB.buz();
            buz.a(hVar);
            if (SignAllForumActivity.this.gDE) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.k.signallforum_back_finish, new Object[]{Integer.valueOf(buz.btS()), Integer.valueOf(buz.btT())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gDB.buA().notifyDataSetChanged();
            SignAllForumProgressView bux = SignAllForumActivity.this.gDB.bux();
            if (!buz.btR()) {
                if (hVar.buk() != 0) {
                    SignAllForumActivity.this.tt(hVar.btJ());
                    SignAllForumActivity.this.Qm.xn();
                } else if (hVar.bum() != 0) {
                    SignAllForumActivity.this.showToast(hVar.bun());
                } else {
                    SignAllForumActivity.this.showToast(d.k.signallforum_error);
                }
            }
            bux.setSignSuccess();
            SignAllForumActivity.this.b(buz);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arQ));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arQ));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String btA = cVar.btA();
            final String Lh = cVar.Lh();
            final boolean btO = cVar.btO();
            if (cVar.btz()) {
                this.gDB.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), btA, Lh, Boolean.valueOf(btO))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(String str) {
        if (this.gDE) {
            c buz = this.gDB.buz();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.k.signallforum_back_finish, new Object[]{0, Integer.valueOf(buz.btN().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gDB.bux().setSignSuccess();
        ArrayList<d> btN = this.gDB.buz().btN();
        int size = btN.size();
        for (int i = 0; i < size; i++) {
            d dVar = btN.get(i);
            dVar.mt(true);
            dVar.mu(false);
            dVar.ms(false);
        }
        this.gDB.buA().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.k.app_name), str, str, pendingIntent, z);
    }

    private void Dt() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress);
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
        Dt();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gDF);
        initData();
        initUI();
    }

    private void initUI() {
        this.gDB = new j(this);
        this.gDB.a(this);
        this.gDB.setOnItemClickListener(this);
        if (this.gDD.isRunning) {
            this.gDG.a(this.gDD.buq());
            this.gDB.bux().setSigning(90);
            return;
        }
        this.gDB.startPullRefresh();
    }

    private void initData() {
        this.gDC = new GetForumListModel(this);
        this.gDC.a(this.gDG);
        this.gDD = new SignAllForumModel(this);
        this.gDD.a(this.gDH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gDB.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aU(boolean z) {
        if (!com.baidu.adp.lib.util.j.jD()) {
            showToast(d.k.neterror);
            this.gDB.nW();
        } else if (this.gDC == null) {
            showToast(d.k.neterror);
        } else if (!this.gDC.LoadData()) {
            this.gDB.nW();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c buz = this.gDB.buz();
        if (view == this.gDB.getProgressBar()) {
            if (buz.getBlockPopInfoData() != null) {
                if (AntiHelper.a(getPageContext().getPageActivity(), buz.getBlockPopInfoData(), this.mInjectListener) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arQ));
                }
            } else if (this.gDB.bux().getCurrentStatus() == 2) {
                showToast(d.k.signallforum_finished);
            } else {
                if (buz.btI() != 0) {
                    tt(buz.btJ());
                    this.Qm.xn();
                } else if (com.baidu.adp.lib.util.j.jD()) {
                    bug();
                } else {
                    showToast(d.k.neterror);
                }
                TiebaStatic.log("signall_click");
            }
        } else if (view == this.gDB.buB()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void bug() {
        c buz = this.gDB.buz();
        this.gDB.bux().setDuration(Math.max(buz.btN().size() * 50, 2000));
        this.gDB.bux().setSigning(0);
        this.gDD.d(buz);
        this.gDD.LoadData();
        this.gDB.buA().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gDB.buA().getItemViewType(i) == 0 && this.gDB.buz() != null && this.gDB.buz().btK() != null && this.gDB.buz().btK().size() > i && (dVar = this.gDB.buz().btK().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(String str) {
        this.Qm = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dE(str).a(d.k.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Qm.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gDD != null && this.gDD.isRunning) {
            buh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Qm != null && this.Qm.isShowing()) {
            this.Qm.dismiss();
        }
        if (this.gDC != null) {
            this.gDC.cancelLoadData();
            this.gDC = null;
        }
        if (this.gDB != null && this.gDB.buA() != null) {
            this.gDB.buA().bui();
        }
        if (this.gDD != null) {
            if (this.gDD.isRunning) {
                buh();
            }
            this.gDD.cancelMessage();
            this.gDD = null;
        }
        if (this.gDC != null) {
            this.gDC.cancelLoadData();
            this.gDC = null;
        }
    }

    private void buh() {
        this.gDE = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.k.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gDB == null || this.gDB.buy() == null) {
            return null;
        }
        return this.gDB.buy().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
