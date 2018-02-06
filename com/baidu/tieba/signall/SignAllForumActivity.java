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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements j.b {
    private com.baidu.tbadk.core.dialog.a axS;
    private k gSa;
    private GetForumListModel gSb;
    private SignAllForumModel gSc;
    private boolean gSd;
    private boolean isDestory;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gSa.btR().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gSe = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c btT;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (btT = SignAllForumActivity.this.gSa.btT()) != null) {
                btT.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gSa.btU().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gSf = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gSa.sV();
            a bte = cVar.bte();
            if (bte != null && bte.getErrorNumber() == 0) {
                SignAllForumActivity.this.gSa.a(cVar, SignAllForumActivity.this.gSb.btx());
                return;
            }
            SignAllForumActivity.this.showToast(bte.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void nr(String str) {
            SignAllForumActivity.this.gSa.sV();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gSg = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void nr(String str) {
            SignAllForumActivity.this.ss(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            a bte = hVar.bte();
            if (bte == null || bte.getErrorNumber() != 0) {
                SignAllForumActivity.this.ss(bte.getUserMsg());
                return;
            }
            c btT = SignAllForumActivity.this.gSa.btT();
            btT.a(hVar);
            if (SignAllForumActivity.this.gSd) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{Integer.valueOf(btT.btl()), Integer.valueOf(btT.btm())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gSa.btU().notifyDataSetChanged();
            j btR = SignAllForumActivity.this.gSa.btR();
            if (!btT.btk()) {
                if (hVar.btD() != 0) {
                    SignAllForumActivity.this.st(hVar.btc());
                    SignAllForumActivity.this.axS.AU();
                } else if (hVar.btF() != 0) {
                    SignAllForumActivity.this.showToast(hVar.btG());
                } else {
                    SignAllForumActivity.this.showToast(d.j.signallforum_error);
                }
            }
            btR.btN();
            SignAllForumActivity.this.b(btT);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXL));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXL));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bsT = cVar.bsT();
            final String OU = cVar.OU();
            final boolean bth = cVar.bth();
            if (cVar.bsS()) {
                this.gSa.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bsT, OU, Boolean.valueOf(bth))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(String str) {
        if (this.gSd) {
            c btT = this.gSa.btT();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(btT.btg().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gSa.btR().btN();
        ArrayList<d> btg = this.gSa.btT().btg();
        int size = btg.size();
        for (int i = 0; i < size; i++) {
            d dVar = btg.get(i);
            dVar.mv(true);
            dVar.mw(false);
            dVar.mu(false);
        }
        this.gSa.btU().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.j.app_name), str, str, pendingIntent, z);
    }

    private void GN() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ay.aZ(getActivity());
            finish();
            return;
        }
        GN();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gSe);
        initData();
        initUI();
    }

    private void initUI() {
        this.gSa = new k(this);
        this.gSa.a(this);
        this.gSa.setOnItemClickListener(this);
        if (this.gSc.isRunning) {
            this.gSf.a(this.gSc.btJ());
            this.gSa.btR().setSigning(90);
            return;
        }
        this.gSa.startPullRefresh();
    }

    private void initData() {
        this.gSb = new GetForumListModel(this);
        this.gSb.a(this.gSf);
        this.gSc = new SignAllForumModel(this);
        this.gSc.a(this.gSg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gSa.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
            this.gSa.sV();
        } else if (this.gSb == null) {
            showToast(d.j.neterror);
        } else if (!this.gSb.LoadData()) {
            this.gSa.sV();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c btT = this.gSa.btT();
        if (view == this.gSa.getProgressBar()) {
            if (btT.getBlockPopInfoData() != null) {
                if (AntiHelper.a(getPageContext().getPageActivity(), btT.getBlockPopInfoData(), this.mInjectListener) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXL));
                }
            } else if (this.gSa.btR().getCurrentStatus() == 2) {
                showToast(d.j.signallforum_finished);
            } else {
                if (btT.btb() != 0) {
                    st(btT.btc());
                    this.axS.AU();
                } else if (com.baidu.adp.lib.util.j.oJ()) {
                    btz();
                } else {
                    showToast(d.j.neterror);
                }
                TiebaStatic.log("signall_click");
            }
        } else if (view == this.gSa.btV()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void btz() {
        c btT = this.gSa.btT();
        this.gSa.btR().setDuration(Math.max(btT.btg().size() * 50, 2000));
        this.gSa.btR().setSigning(0);
        this.gSc.d(btT);
        this.gSc.LoadData();
        this.gSa.btU().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gSa.btU().getItemViewType(i) == 0 && this.gSa.btT() != null && this.gSa.btT().btd() != null && this.gSa.btT().btd().size() > i && (dVar = this.gSa.btT().btd().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(String str) {
        this.axS = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dk(str).a(d.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.axS.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gSc != null && this.gSc.isRunning) {
            btA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.axS != null && this.axS.isShowing()) {
            this.axS.dismiss();
        }
        if (this.gSb != null) {
            this.gSb.cancelLoadData();
            this.gSb = null;
        }
        if (this.gSa != null && this.gSa.btU() != null) {
            this.gSa.btU().btB();
        }
        if (this.gSc != null) {
            if (this.gSc.isRunning) {
                btA();
            }
            this.gSc.cancelMessage();
            this.gSc = null;
        }
        if (this.gSb != null) {
            this.gSb.cancelLoadData();
            this.gSb = null;
        }
    }

    private void btA() {
        this.gSd = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.gSa == null || this.gSa.btS() == null) {
            return null;
        }
        return this.gSa.btS().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
