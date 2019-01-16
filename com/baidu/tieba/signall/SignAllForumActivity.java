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
    private com.baidu.tbadk.core.dialog.a Tm;
    private j hgn;
    private GetForumListModel hgo;
    private SignAllForumModel hgp;
    private boolean hgq;
    private boolean isDestory;
    private boolean hgr = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.hgn.bBK().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener hgs = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c bBM;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bBM = SignAllForumActivity.this.hgn.bBM()) != null) {
                bBM.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.hgn.bBN().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a hgt = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.hgn.pk();
            a bAX = cVar.bAX();
            if (bAX != null && bAX.getErrorNumber() == 0) {
                SignAllForumActivity.this.hgn.a(cVar, SignAllForumActivity.this.hgo.bBq());
                return;
            }
            SignAllForumActivity.this.showToast(bAX.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void qu(String str) {
            SignAllForumActivity.this.hgn.pk();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a hgu = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void qu(String str) {
            SignAllForumActivity.this.vB(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.hgr) {
                SignAllForumActivity.this.hgr = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).Ca();
                if (SignAllForumActivity.this.hgn != null && SignAllForumActivity.this.hgn.bBK() != null) {
                    SignAllForumActivity.this.hgn.bBK().setSignBefore(0);
                    return;
                }
                return;
            }
            a bAX = hVar.bAX();
            if (bAX == null || bAX.getErrorNumber() != 0) {
                SignAllForumActivity.this.vB(bAX.getUserMsg());
                return;
            }
            c bBM = SignAllForumActivity.this.hgn.bBM();
            bBM.a(hVar);
            if (SignAllForumActivity.this.hgq) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{Integer.valueOf(bBM.bBe()), Integer.valueOf(bBM.bBf())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.hgn.bBN().notifyDataSetChanged();
            SignAllForumProgressView bBK = SignAllForumActivity.this.hgn.bBK();
            if (!bBM.bBd()) {
                if (hVar.bBx() != 0) {
                    SignAllForumActivity.this.vC(hVar.bAV());
                    SignAllForumActivity.this.Tm.BS();
                } else if (hVar.bBz() != 0) {
                    SignAllForumActivity.this.showToast(hVar.bBA());
                } else {
                    SignAllForumActivity.this.showToast(e.j.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Tm == null || !SignAllForumActivity.this.Tm.isShowing()) {
                SignAllForumActivity.this.bBs();
            }
            bBK.setSignSuccess();
            SignAllForumActivity.this.b(bBM);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDr));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDr));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bBs() {
        if (this.hgn != null) {
            com.baidu.tbadk.coreExtra.messageCenter.d.Jh().a(getPageContext(), this.hgn.aDc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bAM = cVar.bAM();
            final String Qe = cVar.Qe();
            final boolean bBa = cVar.bBa();
            if (cVar.bAL()) {
                this.hgn.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bAM, Qe, Boolean.valueOf(bBa))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vB(String str) {
        if (this.hgq) {
            c bBM = this.hgn.bBM();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(bBM.bAZ().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.hgn.bBK().setSignSuccess();
        ArrayList<d> bAZ = this.hgn.bBM().bAZ();
        int size = bAZ.size();
        for (int i = 0; i < size; i++) {
            d dVar = bAZ.get(i);
            dVar.nk(true);
            dVar.nl(false);
            dVar.nj(false);
        }
        this.hgn.bBN().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress, getPageContext().getString(e.j.app_name), str, str, pendingIntent, z);
    }

    private void Ij() {
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
        Ij();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.hgs);
        initData();
        initUI();
    }

    private void initUI() {
        this.hgn = new j(this);
        this.hgn.a(this);
        this.hgn.setOnItemClickListener(this);
        if (this.hgp.isRunning) {
            this.hgt.a(this.hgp.bBD());
            this.hgn.bBK().setSigning(90);
            return;
        }
        this.hgn.startPullRefresh();
    }

    private void initData() {
        this.hgo = new GetForumListModel(this);
        this.hgo.a(this.hgt);
        this.hgp = new SignAllForumModel(this);
        this.hgp.a(this.hgu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hgn.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            this.hgn.pk();
        } else if (this.hgo == null) {
            showToast(e.j.neterror);
        } else if (!this.hgo.LoadData()) {
            this.hgn.pk();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c bBM = this.hgn.bBM();
        if (view == this.hgn.getProgressBar()) {
            if (bBM != null) {
                if (bBM.getBlockPopInfoData() != null) {
                    if (bBM.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), bBM.getBlockPopInfoData().appeal_msg, e.f.icon_toast_game_error, 3000).Ca();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), bBM.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDr));
                    }
                } else if (this.hgn.bBK().getCurrentStatus() == 2) {
                    showToast(e.j.signallforum_finished);
                } else {
                    if (bBM.bAU() != 0) {
                        vC(bBM.bAV());
                        this.Tm.BS();
                    } else if (com.baidu.adp.lib.util.j.kV()) {
                        this.hgr = true;
                        bBt();
                    } else {
                        showToast(e.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.hgn.bBO()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void bBt() {
        c bBM = this.hgn.bBM();
        this.hgn.bBK().setDuration(Math.max(bBM.bAZ().size() * 50, 2000));
        this.hgn.bBK().setSigning(0);
        this.hgp.d(bBM);
        this.hgp.LoadData();
        this.hgn.bBN().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.hgn.bBN().getItemViewType(i) == 0 && this.hgn.bBM() != null && this.hgn.bBM().bAW() != null && this.hgn.bBM().bAW().size() > i && (dVar = this.hgn.bBM().bAW().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC(String str) {
        this.Tm = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).eK(str).a(e.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Tm.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hgp != null && this.hgp.isRunning) {
            bBu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Tm != null && this.Tm.isShowing()) {
            this.Tm.dismiss();
        }
        if (this.hgo != null) {
            this.hgo.cancelLoadData();
            this.hgo = null;
        }
        if (this.hgn != null && this.hgn.bBN() != null) {
            this.hgn.bBN().bBv();
        }
        if (this.hgp != null) {
            if (this.hgp.isRunning) {
                bBu();
            }
            this.hgp.cancelMessage();
            this.hgp = null;
        }
        if (this.hgo != null) {
            this.hgo.cancelLoadData();
            this.hgo = null;
        }
    }

    private void bBu() {
        this.hgq = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(e.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.hgn == null || this.hgn.bBL() == null) {
            return null;
        }
        return this.hgn.bBL().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
