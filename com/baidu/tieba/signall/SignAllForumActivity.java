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
    private j gVn;
    private GetForumListModel gVo;
    private SignAllForumModel gVp;
    private boolean gVq;
    private boolean isDestory;
    private boolean gVr = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gVn.bys().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gVs = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c byu;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (byu = SignAllForumActivity.this.gVn.byu()) != null) {
                byu.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gVn.byv().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gVt = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gVn.ph();
            a bxF = cVar.bxF();
            if (bxF != null && bxF.getErrorNumber() == 0) {
                SignAllForumActivity.this.gVn.a(cVar, SignAllForumActivity.this.gVo.bxY());
                return;
            }
            SignAllForumActivity.this.showToast(bxF.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void pz(String str) {
            SignAllForumActivity.this.gVn.ph();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gVu = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void pz(String str) {
            SignAllForumActivity.this.uH(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.gVr) {
                SignAllForumActivity.this.gVr = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).AJ();
                if (SignAllForumActivity.this.gVn != null && SignAllForumActivity.this.gVn.bys() != null) {
                    SignAllForumActivity.this.gVn.bys().setSignBefore(0);
                    return;
                }
                return;
            }
            a bxF = hVar.bxF();
            if (bxF == null || bxF.getErrorNumber() != 0) {
                SignAllForumActivity.this.uH(bxF.getUserMsg());
                return;
            }
            c byu = SignAllForumActivity.this.gVn.byu();
            byu.a(hVar);
            if (SignAllForumActivity.this.gVq) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{Integer.valueOf(byu.bxM()), Integer.valueOf(byu.bxN())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gVn.byv().notifyDataSetChanged();
            SignAllForumProgressView bys = SignAllForumActivity.this.gVn.bys();
            if (!byu.bxL()) {
                if (hVar.byf() != 0) {
                    SignAllForumActivity.this.uI(hVar.bxD());
                    SignAllForumActivity.this.Td.AB();
                } else if (hVar.byh() != 0) {
                    SignAllForumActivity.this.showToast(hVar.byi());
                } else {
                    SignAllForumActivity.this.showToast(e.j.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Td == null || !SignAllForumActivity.this.Td.isShowing()) {
                SignAllForumActivity.this.bya();
            }
            bys.setSignSuccess();
            SignAllForumActivity.this.b(byu);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azo));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azo));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bya() {
        if (this.gVn != null) {
            com.baidu.tbadk.coreExtra.messageCenter.d.HN().a(getPageContext(), this.gVn.aAg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bxu = cVar.bxu();
            final String OE = cVar.OE();
            final boolean bxI = cVar.bxI();
            if (cVar.bxt()) {
                this.gVn.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bxu, OE, Boolean.valueOf(bxI))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(String str) {
        if (this.gVq) {
            c byu = this.gVn.byu();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(byu.bxH().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gVn.bys().setSignSuccess();
        ArrayList<d> bxH = this.gVn.byu().bxH();
        int size = bxH.size();
        for (int i = 0; i < size; i++) {
            d dVar = bxH.get(i);
            dVar.ne(true);
            dVar.nf(false);
            dVar.nd(false);
        }
        this.gVn.byv().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress, getPageContext().getString(e.j.app_name), str, str, pendingIntent, z);
    }

    private void GP() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ba.bF(getActivity());
            finish();
            return;
        }
        GP();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gVs);
        initData();
        initUI();
    }

    private void initUI() {
        this.gVn = new j(this);
        this.gVn.a(this);
        this.gVn.setOnItemClickListener(this);
        if (this.gVp.isRunning) {
            this.gVt.a(this.gVp.byl());
            this.gVn.bys().setSigning(90);
            return;
        }
        this.gVn.startPullRefresh();
    }

    private void initData() {
        this.gVo = new GetForumListModel(this);
        this.gVo.a(this.gVt);
        this.gVp = new SignAllForumModel(this);
        this.gVp.a(this.gVu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gVn.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            this.gVn.ph();
        } else if (this.gVo == null) {
            showToast(e.j.neterror);
        } else if (!this.gVo.LoadData()) {
            this.gVn.ph();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c byu = this.gVn.byu();
        if (view == this.gVn.getProgressBar()) {
            if (byu != null) {
                if (byu.getBlockPopInfoData() != null) {
                    if (byu.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), byu.getBlockPopInfoData().appeal_msg, e.f.icon_toast_game_error, 3000).AJ();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), byu.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azo));
                    }
                } else if (this.gVn.bys().getCurrentStatus() == 2) {
                    showToast(e.j.signallforum_finished);
                } else {
                    if (byu.bxC() != 0) {
                        uI(byu.bxD());
                        this.Td.AB();
                    } else if (com.baidu.adp.lib.util.j.kV()) {
                        this.gVr = true;
                        byb();
                    } else {
                        showToast(e.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.gVn.byw()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void byb() {
        c byu = this.gVn.byu();
        this.gVn.bys().setDuration(Math.max(byu.bxH().size() * 50, 2000));
        this.gVn.bys().setSigning(0);
        this.gVp.d(byu);
        this.gVp.LoadData();
        this.gVn.byv().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gVn.byv().getItemViewType(i) == 0 && this.gVn.byu() != null && this.gVn.byu().bxE() != null && this.gVn.byu().bxE().size() > i && (dVar = this.gVn.byu().bxE().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uI(String str) {
        this.Td = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ej(str).a(e.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
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
        if (this.gVp != null && this.gVp.isRunning) {
            byc();
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
        if (this.gVo != null) {
            this.gVo.cancelLoadData();
            this.gVo = null;
        }
        if (this.gVn != null && this.gVn.byv() != null) {
            this.gVn.byv().byd();
        }
        if (this.gVp != null) {
            if (this.gVp.isRunning) {
                byc();
            }
            this.gVp.cancelMessage();
            this.gVp = null;
        }
        if (this.gVo != null) {
            this.gVo.cancelLoadData();
            this.gVo = null;
        }
    }

    private void byc() {
        this.gVq = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(e.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gVn == null || this.gVn.byt() == null) {
            return null;
        }
        return this.gVn.byt().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
