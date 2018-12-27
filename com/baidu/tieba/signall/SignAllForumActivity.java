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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements j.b {
    private com.baidu.tbadk.core.dialog.a Td;
    private j hfj;
    private GetForumListModel hfk;
    private SignAllForumModel hfl;
    private boolean hfm;
    private boolean isDestory;
    private boolean hfn = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.hfj.bBb().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener hfo = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c bBd;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bBd = SignAllForumActivity.this.hfj.bBd()) != null) {
                bBd.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.hfj.bBe().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a hfp = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.hfj.pg();
            a bAo = cVar.bAo();
            if (bAo != null && bAo.getErrorNumber() == 0) {
                SignAllForumActivity.this.hfj.a(cVar, SignAllForumActivity.this.hfk.bAH());
                return;
            }
            SignAllForumActivity.this.showToast(bAo.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void qe(String str) {
            SignAllForumActivity.this.hfj.pg();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a hfq = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void qe(String str) {
            SignAllForumActivity.this.vl(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.hfn) {
                SignAllForumActivity.this.hfn = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).BN();
                if (SignAllForumActivity.this.hfj != null && SignAllForumActivity.this.hfj.bBb() != null) {
                    SignAllForumActivity.this.hfj.bBb().setSignBefore(0);
                    return;
                }
                return;
            }
            a bAo = hVar.bAo();
            if (bAo == null || bAo.getErrorNumber() != 0) {
                SignAllForumActivity.this.vl(bAo.getUserMsg());
                return;
            }
            c bBd = SignAllForumActivity.this.hfj.bBd();
            bBd.a(hVar);
            if (SignAllForumActivity.this.hfm) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{Integer.valueOf(bBd.bAv()), Integer.valueOf(bBd.bAw())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.hfj.bBe().notifyDataSetChanged();
            SignAllForumProgressView bBb = SignAllForumActivity.this.hfj.bBb();
            if (!bBd.bAu()) {
                if (hVar.bAO() != 0) {
                    SignAllForumActivity.this.vm(hVar.bAm());
                    SignAllForumActivity.this.Td.BF();
                } else if (hVar.bAQ() != 0) {
                    SignAllForumActivity.this.showToast(hVar.bAR());
                } else {
                    SignAllForumActivity.this.showToast(e.j.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Td == null || !SignAllForumActivity.this.Td.isShowing()) {
                SignAllForumActivity.this.bAJ();
            }
            bBb.setSignSuccess();
            SignAllForumActivity.this.b(bBd);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCP));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bAJ() {
        if (this.hfj != null) {
            com.baidu.tbadk.coreExtra.messageCenter.d.IS().a(getPageContext(), this.hfj.aCF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bAd = cVar.bAd();
            final String PM = cVar.PM();
            final boolean bAr = cVar.bAr();
            if (cVar.bAc()) {
                this.hfj.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bAd, PM, Boolean.valueOf(bAr))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl(String str) {
        if (this.hfm) {
            c bBd = this.hfj.bBd();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(bBd.bAq().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.hfj.bBb().setSignSuccess();
        ArrayList<d> bAq = this.hfj.bBd().bAq();
        int size = bAq.size();
        for (int i = 0; i < size; i++) {
            d dVar = bAq.get(i);
            dVar.nj(true);
            dVar.nk(false);
            dVar.ni(false);
        }
        this.hfj.bBe().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress, getPageContext().getString(e.j.app_name), str, str, pendingIntent, z);
    }

    private void HU() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ba.bI(getActivity());
            finish();
            return;
        }
        HU();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.hfo);
        initData();
        initUI();
    }

    private void initUI() {
        this.hfj = new j(this);
        this.hfj.a(this);
        this.hfj.setOnItemClickListener(this);
        if (this.hfl.isRunning) {
            this.hfp.a(this.hfl.bAU());
            this.hfj.bBb().setSigning(90);
            return;
        }
        this.hfj.startPullRefresh();
    }

    private void initData() {
        this.hfk = new GetForumListModel(this);
        this.hfk.a(this.hfp);
        this.hfl = new SignAllForumModel(this);
        this.hfl.a(this.hfq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hfj.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            this.hfj.pg();
        } else if (this.hfk == null) {
            showToast(e.j.neterror);
        } else if (!this.hfk.LoadData()) {
            this.hfj.pg();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c bBd = this.hfj.bBd();
        if (view == this.hfj.getProgressBar()) {
            if (bBd != null) {
                if (bBd.getBlockPopInfoData() != null) {
                    if (bBd.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), bBd.getBlockPopInfoData().appeal_msg, e.f.icon_toast_game_error, 3000).BN();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), bBd.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCP));
                    }
                } else if (this.hfj.bBb().getCurrentStatus() == 2) {
                    showToast(e.j.signallforum_finished);
                } else {
                    if (bBd.bAl() != 0) {
                        vm(bBd.bAm());
                        this.Td.BF();
                    } else if (com.baidu.adp.lib.util.j.kV()) {
                        this.hfn = true;
                        bAK();
                    } else {
                        showToast(e.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.hfj.bBf()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void bAK() {
        c bBd = this.hfj.bBd();
        this.hfj.bBb().setDuration(Math.max(bBd.bAq().size() * 50, 2000));
        this.hfj.bBb().setSigning(0);
        this.hfl.d(bBd);
        this.hfl.LoadData();
        this.hfj.bBe().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.hfj.bBe().getItemViewType(i) == 0 && this.hfj.bBd() != null && this.hfj.bBd().bAn() != null && this.hfj.bBd().bAn().size() > i && (dVar = this.hfj.bBd().bAn().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm(String str) {
        this.Td = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).eB(str).a(e.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Td.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hfl != null && this.hfl.isRunning) {
            bAL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Td != null && this.Td.isShowing()) {
            this.Td.dismiss();
        }
        if (this.hfk != null) {
            this.hfk.cancelLoadData();
            this.hfk = null;
        }
        if (this.hfj != null && this.hfj.bBe() != null) {
            this.hfj.bBe().bAM();
        }
        if (this.hfl != null) {
            if (this.hfl.isRunning) {
                bAL();
            }
            this.hfl.cancelMessage();
            this.hfl = null;
        }
        if (this.hfk != null) {
            this.hfk.cancelLoadData();
            this.hfk = null;
        }
    }

    private void bAL() {
        this.hfm = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(e.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.hfj == null || this.hfj.bBc() == null) {
            return null;
        }
        return this.hfj.bBc().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
