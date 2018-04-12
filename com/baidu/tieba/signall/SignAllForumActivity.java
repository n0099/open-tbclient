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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements e.b {
    private com.baidu.tbadk.core.dialog.a JV;
    private j gnh;
    private GetForumListModel gni;
    private SignAllForumModel gnj;
    private boolean gnk;
    private boolean isDestory;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gnh.boZ().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gnl = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c bpb;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bpb = SignAllForumActivity.this.gnh.bpb()) != null) {
                bpb.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gnh.bpc().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gnm = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gnh.lh();
            a bon = cVar.bon();
            if (bon != null && bon.getErrorNumber() == 0) {
                SignAllForumActivity.this.gnh.a(cVar, SignAllForumActivity.this.gni.boG());
                return;
            }
            SignAllForumActivity.this.showToast(bon.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void nv(String str) {
            SignAllForumActivity.this.gnh.lh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gnn = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void nv(String str) {
            SignAllForumActivity.this.sz(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            a bon = hVar.bon();
            if (bon == null || bon.getErrorNumber() != 0) {
                SignAllForumActivity.this.sz(bon.getUserMsg());
                return;
            }
            c bpb = SignAllForumActivity.this.gnh.bpb();
            bpb.a(hVar);
            if (SignAllForumActivity.this.gnk) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.k.signallforum_back_finish, new Object[]{Integer.valueOf(bpb.bou()), Integer.valueOf(bpb.bov())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gnh.bpc().notifyDataSetChanged();
            SignAllForumProgressView boZ = SignAllForumActivity.this.gnh.boZ();
            if (!bpb.bot()) {
                if (hVar.boM() != 0) {
                    SignAllForumActivity.this.sA(hVar.bol());
                    SignAllForumActivity.this.JV.tD();
                } else if (hVar.boO() != 0) {
                    SignAllForumActivity.this.showToast(hVar.boP());
                } else {
                    SignAllForumActivity.this.showToast(d.k.signallforum_error);
                }
            }
            boZ.setSignSuccess();
            SignAllForumActivity.this.b(bpb);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajf));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajf));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String boc = cVar.boc();
            final String Hx = cVar.Hx();
            final boolean boq = cVar.boq();
            if (cVar.bob()) {
                this.gnh.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), boc, Hx, Boolean.valueOf(boq))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz(String str) {
        if (this.gnk) {
            c bpb = this.gnh.bpb();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.k.signallforum_back_finish, new Object[]{0, Integer.valueOf(bpb.bop().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gnh.boZ().setSignSuccess();
        ArrayList<d> bop = this.gnh.bpb().bop();
        int size = bop.size();
        for (int i = 0; i < size; i++) {
            d dVar = bop.get(i);
            dVar.mb(true);
            dVar.mc(false);
            dVar.ma(false);
        }
        this.gnh.bpc().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.k.app_name), str, str, pendingIntent, z);
    }

    private void zB() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            az.aJ(getActivity());
            finish();
            return;
        }
        zB();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gnl);
        initData();
        initUI();
    }

    private void initUI() {
        this.gnh = new j(this);
        this.gnh.a(this);
        this.gnh.setOnItemClickListener(this);
        if (this.gnj.isRunning) {
            this.gnm.a(this.gnj.boS());
            this.gnh.boZ().setSigning(90);
            return;
        }
        this.gnh.startPullRefresh();
    }

    private void initData() {
        this.gni = new GetForumListModel(this);
        this.gni.a(this.gnm);
        this.gnj = new SignAllForumModel(this);
        this.gnj.a(this.gnn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gnh.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        if (!com.baidu.adp.lib.util.j.gP()) {
            showToast(d.k.neterror);
            this.gnh.lh();
        } else if (this.gni == null) {
            showToast(d.k.neterror);
        } else if (!this.gni.LoadData()) {
            this.gnh.lh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        c bpb = this.gnh.bpb();
        if (view2 == this.gnh.getProgressBar()) {
            if (bpb.getBlockPopInfoData() != null) {
                if (AntiHelper.a(getPageContext().getPageActivity(), bpb.getBlockPopInfoData(), this.mInjectListener) != null) {
                    TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajf));
                }
            } else if (this.gnh.boZ().getCurrentStatus() == 2) {
                showToast(d.k.signallforum_finished);
            } else {
                if (bpb.bok() != 0) {
                    sA(bpb.bol());
                    this.JV.tD();
                } else if (com.baidu.adp.lib.util.j.gP()) {
                    boI();
                } else {
                    showToast(d.k.neterror);
                }
                TiebaStatic.log("signall_click");
            }
        } else if (view2 == this.gnh.bpd()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void boI() {
        c bpb = this.gnh.bpb();
        this.gnh.boZ().setDuration(Math.max(bpb.bop().size() * 50, 2000));
        this.gnh.boZ().setSigning(0);
        this.gnj.d(bpb);
        this.gnj.LoadData();
        this.gnh.bpc().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        d dVar;
        if (this.gnh.bpc().getItemViewType(i) == 0 && this.gnh.bpb() != null && this.gnh.bpb().bom() != null && this.gnh.bpb().bom().size() > i && (dVar = this.gnh.bpb().bom().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sA(String str) {
        this.JV = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dc(str).a(d.k.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.JV.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gnj != null && this.gnj.isRunning) {
            boJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.JV != null && this.JV.isShowing()) {
            this.JV.dismiss();
        }
        if (this.gni != null) {
            this.gni.cancelLoadData();
            this.gni = null;
        }
        if (this.gnh != null && this.gnh.bpc() != null) {
            this.gnh.bpc().boK();
        }
        if (this.gnj != null) {
            if (this.gnj.isRunning) {
                boJ();
            }
            this.gnj.cancelMessage();
            this.gnj = null;
        }
        if (this.gni != null) {
            this.gni.cancelLoadData();
            this.gni = null;
        }
    }

    private void boJ() {
        this.gnk = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.k.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gnh == null || this.gnh.bpa() == null) {
            return null;
        }
        return this.gnh.bpa().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
