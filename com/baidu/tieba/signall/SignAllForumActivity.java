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
    private com.baidu.tbadk.core.dialog.a axK;
    private k gSb;
    private GetForumListModel gSc;
    private SignAllForumModel gSd;
    private boolean gSe;
    private boolean isDestory;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gSb.btR().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gSf = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c btT;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (btT = SignAllForumActivity.this.gSb.btT()) != null) {
                btT.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gSb.btU().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gSg = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gSb.sV();
            a bte = cVar.bte();
            if (bte != null && bte.getErrorNumber() == 0) {
                SignAllForumActivity.this.gSb.a(cVar, SignAllForumActivity.this.gSc.btx());
                return;
            }
            SignAllForumActivity.this.showToast(bte.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void nr(String str) {
            SignAllForumActivity.this.gSb.sV();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gSh = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
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
            c btT = SignAllForumActivity.this.gSb.btT();
            btT.a(hVar);
            if (SignAllForumActivity.this.gSe) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{Integer.valueOf(btT.btl()), Integer.valueOf(btT.btm())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gSb.btU().notifyDataSetChanged();
            j btR = SignAllForumActivity.this.gSb.btR();
            if (!btT.btk()) {
                if (hVar.btD() != 0) {
                    SignAllForumActivity.this.st(hVar.btc());
                    SignAllForumActivity.this.axK.AV();
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
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXB));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXB));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bsT = cVar.bsT();
            final String OU = cVar.OU();
            final boolean bth = cVar.bth();
            if (cVar.bsS()) {
                this.gSb.setListViewSelection(0);
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
        if (this.gSe) {
            c btT = this.gSb.btT();
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
        this.gSb.btR().btN();
        ArrayList<d> btg = this.gSb.btT().btg();
        int size = btg.size();
        for (int i = 0; i < size; i++) {
            d dVar = btg.get(i);
            dVar.mA(true);
            dVar.mB(false);
            dVar.mz(false);
        }
        this.gSb.btU().notifyDataSetChanged();
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
        registerListener(this.gSf);
        initData();
        initUI();
    }

    private void initUI() {
        this.gSb = new k(this);
        this.gSb.a(this);
        this.gSb.setOnItemClickListener(this);
        if (this.gSd.isRunning) {
            this.gSg.a(this.gSd.btJ());
            this.gSb.btR().setSigning(90);
            return;
        }
        this.gSb.startPullRefresh();
    }

    private void initData() {
        this.gSc = new GetForumListModel(this);
        this.gSc.a(this.gSg);
        this.gSd = new SignAllForumModel(this);
        this.gSd.a(this.gSh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gSb.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
            this.gSb.sV();
        } else if (this.gSc == null) {
            showToast(d.j.neterror);
        } else if (!this.gSc.LoadData()) {
            this.gSb.sV();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c btT = this.gSb.btT();
        if (view == this.gSb.getProgressBar()) {
            if (btT.getBlockPopInfoData() != null) {
                if (AntiHelper.a(getPageContext().getPageActivity(), btT.getBlockPopInfoData(), this.mInjectListener) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXB));
                }
            } else if (this.gSb.btR().getCurrentStatus() == 2) {
                showToast(d.j.signallforum_finished);
            } else {
                if (btT.btb() != 0) {
                    st(btT.btc());
                    this.axK.AV();
                } else if (com.baidu.adp.lib.util.j.oJ()) {
                    btz();
                } else {
                    showToast(d.j.neterror);
                }
                TiebaStatic.log("signall_click");
            }
        } else if (view == this.gSb.btV()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void btz() {
        c btT = this.gSb.btT();
        this.gSb.btR().setDuration(Math.max(btT.btg().size() * 50, 2000));
        this.gSb.btR().setSigning(0);
        this.gSd.d(btT);
        this.gSd.LoadData();
        this.gSb.btU().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gSb.btU().getItemViewType(i) == 0 && this.gSb.btT() != null && this.gSb.btT().btd() != null && this.gSb.btT().btd().size() > i && (dVar = this.gSb.btT().btd().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(String str) {
        this.axK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dk(str).a(d.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.axK.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gSd != null && this.gSd.isRunning) {
            btA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.axK != null && this.axK.isShowing()) {
            this.axK.dismiss();
        }
        if (this.gSc != null) {
            this.gSc.cancelLoadData();
            this.gSc = null;
        }
        if (this.gSb != null && this.gSb.btU() != null) {
            this.gSb.btU().btB();
        }
        if (this.gSd != null) {
            if (this.gSd.isRunning) {
                btA();
            }
            this.gSd.cancelMessage();
            this.gSd = null;
        }
        if (this.gSc != null) {
            this.gSc.cancelLoadData();
            this.gSc = null;
        }
    }

    private void btA() {
        this.gSe = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.gSb == null || this.gSb.btS() == null) {
            return null;
        }
        return this.gSb.btS().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
