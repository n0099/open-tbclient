package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.signall.f;
import com.baidu.tieba.signall.w;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements t.b {
    private com.baidu.tbadk.core.dialog.a CP;
    private af ejk;
    private f ejl;
    private w ejm;
    private boolean ejn;
    private boolean ejo;
    private final CustomMessageListener mMemListener = new j(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener ejp = new k(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a ejq = new l(this);
    private w.a ejr = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            String UT = cVar.UT();
            String Fn = cVar.Fn();
            boolean aPV = cVar.aPV();
            if (cVar.aPJ()) {
                this.ejk.gD(0);
                new Handler().postDelayed(new n(this, UT, Fn, aPV), 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(String str) {
        if (this.ejn) {
            c aQI = this.ejk.aQI();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(t.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(aQI.aPU().size())});
            a(str, activity, false);
            if (this.ejo) {
                return;
            }
        }
        showToast(str);
        this.ejk.aQG().aQA();
        ArrayList<e> aPU = this.ejk.aQI().aPU();
        int size = aPU.size();
        for (int i = 0; i < size; i++) {
            e eVar = aPU.get(i);
            eVar.jl(true);
            eVar.jm(false);
            eVar.jk(false);
        }
        this.ejk.aQJ().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), t.f.singnallforum_progress, getPageContext().getString(t.j.app_name), str, str, pendingIntent, z);
    }

    private void xn() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), t.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bl.ab(getActivity());
            finish();
            return;
        }
        xn();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.ejp);
        initData();
        nq();
    }

    private void nq() {
        this.ejk = new af(this);
        this.ejk.a(this);
        this.ejk.setOnItemClickListener(this);
        if (this.ejm.fU) {
            this.ejq.a(this.ejm.aQw());
            this.ejk.aQG().setSigning(90);
            return;
        }
        this.ejk.jy();
    }

    private void initData() {
        this.ejl = new f(this);
        this.ejl.a(this.ejq);
        this.ejm = new w(this);
        this.ejm.a(this.ejr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ejk.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(t.j.neterror);
            this.ejk.Np();
        } else if (!this.ejl.LoadData()) {
            this.ejk.Np();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c aQI = this.ejk.aQI();
        if (view == this.ejk.getProgressBar()) {
            if (this.ejk.aQG().getCurrentStatus() == 2) {
                showToast(t.j.signallforum_finished);
                return;
            }
            if (aQI.aPP() != 0) {
                nz(aQI.aPQ());
                this.CP.rV();
            } else if (com.baidu.adp.lib.util.i.fq()) {
                aQn();
            } else {
                showToast(t.j.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.ejk.aQK()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void aQn() {
        c aQI = this.ejk.aQI();
        this.ejk.aQG().setDuration(Math.max(aQI.aPU().size() * 50, 2000));
        this.ejk.aQG().setSigning(0);
        this.ejm.d(aQI);
        this.ejm.LoadData();
        this.ejk.aQJ().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.ejk.aQJ().getItemViewType(i) == 0 && this.ejk.aQI() != null && this.ejk.aQI().aPR() != null && this.ejk.aQI().aPR().size() > i && (eVar = this.ejk.aQI().aPR().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(String str) {
        this.CP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cA(str).a(t.j.signallforum_signnow, new o(this));
        this.CP.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ejm != null && this.ejm.fU) {
            aQo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ejo = true;
        if (this.CP != null && this.CP.isShowing()) {
            this.CP.dismiss();
        }
        if (this.ejl != null) {
            this.ejl.cancelLoadData();
            this.ejl = null;
        }
        if (this.ejk != null && this.ejk.aQJ() != null) {
            this.ejk.aQJ().aQp();
        }
        if (this.ejm != null) {
            if (this.ejm.fU) {
                aQo();
            }
            this.ejm.cancelMessage();
            this.ejm = null;
        }
        if (this.ejl != null) {
            this.ejl.cancelLoadData();
            this.ejl = null;
        }
    }

    private void aQo() {
        this.ejn = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(t.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.ejk.aQH();
    }
}
