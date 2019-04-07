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
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements h.c {
    private com.baidu.tbadk.core.dialog.a VQ;
    private boolean isDestory;
    private j ixI;
    private GetForumListModel ixJ;
    private SignAllForumModel ixK;
    private boolean ixL;
    private boolean ixM = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.ixI.ccx().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener ixN = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c ccz;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (ccz = SignAllForumActivity.this.ixI.ccz()) != null) {
                ccz.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.ixI.ccA().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a ixO = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.ixI.pD();
            a cbK = cVar.cbK();
            if (cbK != null && cbK.getErrorNumber() == 0) {
                SignAllForumActivity.this.ixI.a(cVar, SignAllForumActivity.this.ixJ.ccd());
                return;
            }
            SignAllForumActivity.this.showToast(cbK.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void wX(String str) {
            SignAllForumActivity.this.ixI.pD();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a ixP = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void wX(String str) {
            SignAllForumActivity.this.Cg(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.ixM) {
                SignAllForumActivity.this.ixM = false;
                BdToast.b(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).abe();
                if (SignAllForumActivity.this.ixI != null && SignAllForumActivity.this.ixI.ccx() != null) {
                    SignAllForumActivity.this.ixI.ccx().setSignBefore(0);
                    return;
                }
                return;
            }
            a cbK = hVar.cbK();
            if (cbK == null || cbK.getErrorNumber() != 0) {
                SignAllForumActivity.this.Cg(cbK.getUserMsg());
                return;
            }
            c ccz = SignAllForumActivity.this.ixI.ccz();
            ccz.a(hVar);
            if (SignAllForumActivity.this.ixL) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{Integer.valueOf(ccz.cbR()), Integer.valueOf(ccz.cbS())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.ixI.ccA().notifyDataSetChanged();
            SignAllForumProgressView ccx = SignAllForumActivity.this.ixI.ccx();
            if (!ccz.cbQ()) {
                if (hVar.cck() != 0) {
                    SignAllForumActivity.this.Ch(hVar.cbI());
                    SignAllForumActivity.this.VQ.aaW();
                } else if (hVar.ccm() != 0) {
                    SignAllForumActivity.this.showToast(hVar.ccn());
                } else {
                    SignAllForumActivity.this.showToast(d.j.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.VQ == null || !SignAllForumActivity.this.VQ.isShowing()) {
                SignAllForumActivity.this.ccf();
            }
            ccx.setSignSuccess();
            SignAllForumActivity.this.b(ccz);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLq));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ccf() {
        if (this.ixI != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aiz().a(getPageContext(), this.ixI.bdJ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cbz = cVar.cbz();
            final String apM = cVar.apM();
            final boolean cbN = cVar.cbN();
            if (cVar.cby()) {
                this.ixI.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cbz, apM, Boolean.valueOf(cbN))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cg(String str) {
        if (this.ixL) {
            c ccz = this.ixI.ccz();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(ccz.cbM().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.ixI.ccx().setSignSuccess();
        ArrayList<d> cbM = this.ixI.ccz().cbM();
        int size = cbM.size();
        for (int i = 0; i < size; i++) {
            d dVar = cbM.get(i);
            dVar.pK(true);
            dVar.pL(false);
            dVar.pJ(false);
        }
        this.ixI.ccA().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.j.app_name), str, str, pendingIntent, z);
    }

    private void ahB() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bc.cY(getActivity());
            finish();
            return;
        }
        ahB();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.ixN);
        initData();
        initUI();
    }

    private void initUI() {
        this.ixI = new j(this);
        this.ixI.setListPullRefreshListener(this);
        this.ixI.setOnItemClickListener(this);
        if (this.ixK.isRunning) {
            this.ixO.a(this.ixK.ccq());
            this.ixI.ccx().setSigning(90);
            return;
        }
        this.ixI.startPullRefresh();
    }

    private void initData() {
        this.ixJ = new GetForumListModel(this);
        this.ixJ.a(this.ixO);
        this.ixK = new SignAllForumModel(this);
        this.ixK.a(this.ixP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ixI.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (!com.baidu.adp.lib.util.j.kY()) {
            showToast(d.j.neterror);
            this.ixI.pD();
        } else if (this.ixJ == null) {
            showToast(d.j.neterror);
        } else if (!this.ixJ.LoadData()) {
            this.ixI.pD();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c ccz = this.ixI.ccz();
        if (view == this.ixI.getProgressBar()) {
            if (ccz != null) {
                if (ccz.getBlockPopInfoData() != null) {
                    if (ccz.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.b(getPageContext().getPageActivity(), ccz.getBlockPopInfoData().appeal_msg, d.f.icon_toast_game_error, 3000).abe();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), ccz.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLq));
                    }
                } else if (this.ixI.ccx().getCurrentStatus() == 2) {
                    showToast(d.j.signallforum_finished);
                } else {
                    if (ccz.cbH() != 0) {
                        Ch(ccz.cbI());
                        this.VQ.aaW();
                    } else if (com.baidu.adp.lib.util.j.kY()) {
                        this.ixM = true;
                        ccg();
                    } else {
                        showToast(d.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.ixI.ccB()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void ccg() {
        c ccz = this.ixI.ccz();
        this.ixI.ccx().setDuration(Math.max(ccz.cbM().size() * 50, 2000));
        this.ixI.ccx().setSigning(0);
        this.ixK.d(ccz);
        this.ixK.LoadData();
        this.ixI.ccA().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.ixI.ccA().getItemViewType(i) == 0 && this.ixI.ccz() != null && this.ixI.ccz().cbJ() != null && this.ixI.ccz().cbJ().size() > i && (dVar = this.ixI.ccz().cbJ().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(String str) {
        this.VQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).lz(str).a(d.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.VQ.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ixK != null && this.ixK.isRunning) {
            cch();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.VQ != null && this.VQ.isShowing()) {
            this.VQ.dismiss();
        }
        if (this.ixJ != null) {
            this.ixJ.cancelLoadData();
            this.ixJ = null;
        }
        if (this.ixI != null && this.ixI.ccA() != null) {
            this.ixI.ccA().cci();
        }
        if (this.ixK != null) {
            if (this.ixK.isRunning) {
                cch();
            }
            this.ixK.cancelMessage();
            this.ixK = null;
        }
        if (this.ixJ != null) {
            this.ixJ.cancelLoadData();
            this.ixJ = null;
        }
    }

    private void cch() {
        this.ixL = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.ixI == null || this.ixI.ccy() == null) {
            return null;
        }
        return this.ixI.ccy().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
