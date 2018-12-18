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
    private j hcf;
    private GetForumListModel hcg;
    private SignAllForumModel hch;
    private boolean hci;
    private boolean isDestory;
    private boolean hcj = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.hcf.bAl().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener hck = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c bAn;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bAn = SignAllForumActivity.this.hcf.bAn()) != null) {
                bAn.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.hcf.bAo().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a hcl = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.hcf.pg();
            a bzy = cVar.bzy();
            if (bzy != null && bzy.getErrorNumber() == 0) {
                SignAllForumActivity.this.hcf.a(cVar, SignAllForumActivity.this.hcg.bzR());
                return;
            }
            SignAllForumActivity.this.showToast(bzy.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void qb(String str) {
            SignAllForumActivity.this.hcf.pg();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a hcm = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void qb(String str) {
            SignAllForumActivity.this.vi(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.hcj) {
                SignAllForumActivity.this.hcj = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).BN();
                if (SignAllForumActivity.this.hcf != null && SignAllForumActivity.this.hcf.bAl() != null) {
                    SignAllForumActivity.this.hcf.bAl().setSignBefore(0);
                    return;
                }
                return;
            }
            a bzy = hVar.bzy();
            if (bzy == null || bzy.getErrorNumber() != 0) {
                SignAllForumActivity.this.vi(bzy.getUserMsg());
                return;
            }
            c bAn = SignAllForumActivity.this.hcf.bAn();
            bAn.a(hVar);
            if (SignAllForumActivity.this.hci) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{Integer.valueOf(bAn.bzF()), Integer.valueOf(bAn.bzG())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.hcf.bAo().notifyDataSetChanged();
            SignAllForumProgressView bAl = SignAllForumActivity.this.hcf.bAl();
            if (!bAn.bzE()) {
                if (hVar.bzY() != 0) {
                    SignAllForumActivity.this.vj(hVar.bzw());
                    SignAllForumActivity.this.Td.BF();
                } else if (hVar.bAa() != 0) {
                    SignAllForumActivity.this.showToast(hVar.bAb());
                } else {
                    SignAllForumActivity.this.showToast(e.j.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Td == null || !SignAllForumActivity.this.Td.isShowing()) {
                SignAllForumActivity.this.bzT();
            }
            bAl.setSignSuccess();
            SignAllForumActivity.this.b(bAn);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCO));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCO));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bzT() {
        if (this.hcf != null) {
            com.baidu.tbadk.coreExtra.messageCenter.d.IR().a(getPageContext(), this.hcf.aBQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bzn = cVar.bzn();
            final String PK = cVar.PK();
            final boolean bzB = cVar.bzB();
            if (cVar.bzm()) {
                this.hcf.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bzn, PK, Boolean.valueOf(bzB))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(String str) {
        if (this.hci) {
            c bAn = this.hcf.bAn();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(bAn.bzA().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.hcf.bAl().setSignSuccess();
        ArrayList<d> bzA = this.hcf.bAn().bzA();
        int size = bzA.size();
        for (int i = 0; i < size; i++) {
            d dVar = bzA.get(i);
            dVar.ng(true);
            dVar.nh(false);
            dVar.nf(false);
        }
        this.hcf.bAo().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress, getPageContext().getString(e.j.app_name), str, str, pendingIntent, z);
    }

    private void HT() {
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
        HT();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.hck);
        initData();
        initUI();
    }

    private void initUI() {
        this.hcf = new j(this);
        this.hcf.a(this);
        this.hcf.setOnItemClickListener(this);
        if (this.hch.isRunning) {
            this.hcl.a(this.hch.bAe());
            this.hcf.bAl().setSigning(90);
            return;
        }
        this.hcf.startPullRefresh();
    }

    private void initData() {
        this.hcg = new GetForumListModel(this);
        this.hcg.a(this.hcl);
        this.hch = new SignAllForumModel(this);
        this.hch.a(this.hcm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hcf.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            this.hcf.pg();
        } else if (this.hcg == null) {
            showToast(e.j.neterror);
        } else if (!this.hcg.LoadData()) {
            this.hcf.pg();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c bAn = this.hcf.bAn();
        if (view == this.hcf.getProgressBar()) {
            if (bAn != null) {
                if (bAn.getBlockPopInfoData() != null) {
                    if (bAn.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), bAn.getBlockPopInfoData().appeal_msg, e.f.icon_toast_game_error, 3000).BN();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), bAn.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCO));
                    }
                } else if (this.hcf.bAl().getCurrentStatus() == 2) {
                    showToast(e.j.signallforum_finished);
                } else {
                    if (bAn.bzv() != 0) {
                        vj(bAn.bzw());
                        this.Td.BF();
                    } else if (com.baidu.adp.lib.util.j.kV()) {
                        this.hcj = true;
                        bzU();
                    } else {
                        showToast(e.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.hcf.bAp()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void bzU() {
        c bAn = this.hcf.bAn();
        this.hcf.bAl().setDuration(Math.max(bAn.bzA().size() * 50, 2000));
        this.hcf.bAl().setSigning(0);
        this.hch.d(bAn);
        this.hch.LoadData();
        this.hcf.bAo().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.hcf.bAo().getItemViewType(i) == 0 && this.hcf.bAn() != null && this.hcf.bAn().bzx() != null && this.hcf.bAn().bzx().size() > i && (dVar = this.hcf.bAn().bzx().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj(String str) {
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
        if (this.hch != null && this.hch.isRunning) {
            bzV();
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
        if (this.hcg != null) {
            this.hcg.cancelLoadData();
            this.hcg = null;
        }
        if (this.hcf != null && this.hcf.bAo() != null) {
            this.hcf.bAo().bzW();
        }
        if (this.hch != null) {
            if (this.hch.isRunning) {
                bzV();
            }
            this.hch.cancelMessage();
            this.hch = null;
        }
        if (this.hcg != null) {
            this.hcg.cancelLoadData();
            this.hcg = null;
        }
    }

    private void bzV() {
        this.hci = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(e.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.hcf == null || this.hcf.bAm() == null) {
            return null;
        }
        return this.hcf.bAm().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
