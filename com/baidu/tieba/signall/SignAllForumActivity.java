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
    private j ixY;
    private GetForumListModel ixZ;
    private SignAllForumModel iya;
    private boolean iyb;
    private boolean iyc = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.ixY.ccB().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener iyd = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c ccD;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (ccD = SignAllForumActivity.this.ixY.ccD()) != null) {
                ccD.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.ixY.ccE().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a iye = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.ixY.pD();
            a cbO = cVar.cbO();
            if (cbO != null && cbO.getErrorNumber() == 0) {
                SignAllForumActivity.this.ixY.a(cVar, SignAllForumActivity.this.ixZ.cch());
                return;
            }
            SignAllForumActivity.this.showToast(cbO.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void wY(String str) {
            SignAllForumActivity.this.ixY.pD();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a iyf = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void wY(String str) {
            SignAllForumActivity.this.Ch(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.iyc) {
                SignAllForumActivity.this.iyc = false;
                BdToast.b(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).abh();
                if (SignAllForumActivity.this.ixY != null && SignAllForumActivity.this.ixY.ccB() != null) {
                    SignAllForumActivity.this.ixY.ccB().setSignBefore(0);
                    return;
                }
                return;
            }
            a cbO = hVar.cbO();
            if (cbO == null || cbO.getErrorNumber() != 0) {
                SignAllForumActivity.this.Ch(cbO.getUserMsg());
                return;
            }
            c ccD = SignAllForumActivity.this.ixY.ccD();
            ccD.a(hVar);
            if (SignAllForumActivity.this.iyb) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{Integer.valueOf(ccD.cbV()), Integer.valueOf(ccD.cbW())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.ixY.ccE().notifyDataSetChanged();
            SignAllForumProgressView ccB = SignAllForumActivity.this.ixY.ccB();
            if (!ccD.cbU()) {
                if (hVar.cco() != 0) {
                    SignAllForumActivity.this.Ci(hVar.cbM());
                    SignAllForumActivity.this.VQ.aaZ();
                } else if (hVar.ccq() != 0) {
                    SignAllForumActivity.this.showToast(hVar.ccr());
                } else {
                    SignAllForumActivity.this.showToast(d.j.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.VQ == null || !SignAllForumActivity.this.VQ.isShowing()) {
                SignAllForumActivity.this.ccj();
            }
            ccB.setSignSuccess();
            SignAllForumActivity.this.b(ccD);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLo));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLo));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ccj() {
        if (this.ixY != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aiC().a(getPageContext(), this.ixY.bdL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cbD = cVar.cbD();
            final String apP = cVar.apP();
            final boolean cbR = cVar.cbR();
            if (cVar.cbC()) {
                this.ixY.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cbD, apP, Boolean.valueOf(cbR))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(String str) {
        if (this.iyb) {
            c ccD = this.ixY.ccD();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(ccD.cbQ().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.ixY.ccB().setSignSuccess();
        ArrayList<d> cbQ = this.ixY.ccD().cbQ();
        int size = cbQ.size();
        for (int i = 0; i < size; i++) {
            d dVar = cbQ.get(i);
            dVar.pK(true);
            dVar.pL(false);
            dVar.pJ(false);
        }
        this.ixY.ccE().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.j.app_name), str, str, pendingIntent, z);
    }

    private void ahE() {
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
        ahE();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.iyd);
        initData();
        initUI();
    }

    private void initUI() {
        this.ixY = new j(this);
        this.ixY.setListPullRefreshListener(this);
        this.ixY.setOnItemClickListener(this);
        if (this.iya.isRunning) {
            this.iye.a(this.iya.ccu());
            this.ixY.ccB().setSigning(90);
            return;
        }
        this.ixY.startPullRefresh();
    }

    private void initData() {
        this.ixZ = new GetForumListModel(this);
        this.ixZ.a(this.iye);
        this.iya = new SignAllForumModel(this);
        this.iya.a(this.iyf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ixY.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (!com.baidu.adp.lib.util.j.kY()) {
            showToast(d.j.neterror);
            this.ixY.pD();
        } else if (this.ixZ == null) {
            showToast(d.j.neterror);
        } else if (!this.ixZ.LoadData()) {
            this.ixY.pD();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c ccD = this.ixY.ccD();
        if (view == this.ixY.getProgressBar()) {
            if (ccD != null) {
                if (ccD.getBlockPopInfoData() != null) {
                    if (ccD.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.b(getPageContext().getPageActivity(), ccD.getBlockPopInfoData().appeal_msg, d.f.icon_toast_game_error, 3000).abh();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), ccD.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLo));
                    }
                } else if (this.ixY.ccB().getCurrentStatus() == 2) {
                    showToast(d.j.signallforum_finished);
                } else {
                    if (ccD.cbL() != 0) {
                        Ci(ccD.cbM());
                        this.VQ.aaZ();
                    } else if (com.baidu.adp.lib.util.j.kY()) {
                        this.iyc = true;
                        cck();
                    } else {
                        showToast(d.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.ixY.ccF()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void cck() {
        c ccD = this.ixY.ccD();
        this.ixY.ccB().setDuration(Math.max(ccD.cbQ().size() * 50, 2000));
        this.ixY.ccB().setSigning(0);
        this.iya.d(ccD);
        this.iya.LoadData();
        this.ixY.ccE().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.ixY.ccE().getItemViewType(i) == 0 && this.ixY.ccD() != null && this.ixY.ccD().cbN() != null && this.ixY.ccD().cbN().size() > i && (dVar = this.ixY.ccD().cbN().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci(String str) {
        this.VQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ly(str).a(d.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
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
        if (this.iya != null && this.iya.isRunning) {
            ccl();
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
        if (this.ixZ != null) {
            this.ixZ.cancelLoadData();
            this.ixZ = null;
        }
        if (this.ixY != null && this.ixY.ccE() != null) {
            this.ixY.ccE().ccm();
        }
        if (this.iya != null) {
            if (this.iya.isRunning) {
                ccl();
            }
            this.iya.cancelMessage();
            this.iya = null;
        }
        if (this.ixZ != null) {
            this.ixZ.cancelLoadData();
            this.ixZ = null;
        }
    }

    private void ccl() {
        this.iyb = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.ixY == null || this.ixY.ccC() == null) {
            return null;
        }
        return this.ixY.ccC().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
