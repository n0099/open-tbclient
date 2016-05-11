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
            String UR = cVar.UR();
            String Fl = cVar.Fl();
            boolean aPS = cVar.aPS();
            if (cVar.aPG()) {
                this.ejk.gE(0);
                new Handler().postDelayed(new n(this, UR, Fl, aPS), 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(String str) {
        if (this.ejn) {
            c aQF = this.ejk.aQF();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(t.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(aQF.aPR().size())});
            a(str, activity, false);
            if (this.ejo) {
                return;
            }
        }
        showToast(str);
        this.ejk.aQD().aQx();
        ArrayList<e> aPR = this.ejk.aQF().aPR();
        int size = aPR.size();
        for (int i = 0; i < size; i++) {
            e eVar = aPR.get(i);
            eVar.jl(true);
            eVar.jm(false);
            eVar.jk(false);
        }
        this.ejk.aQG().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), t.f.singnallforum_progress, getPageContext().getString(t.j.app_name), str, str, pendingIntent, z);
    }

    private void xm() {
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
        xm();
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
            this.ejq.a(this.ejm.aQt());
            this.ejk.aQD().setSigning(90);
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
            this.ejk.Nn();
        } else if (!this.ejl.LoadData()) {
            this.ejk.Nn();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c aQF = this.ejk.aQF();
        if (view == this.ejk.getProgressBar()) {
            if (this.ejk.aQD().getCurrentStatus() == 2) {
                showToast(t.j.signallforum_finished);
                return;
            }
            if (aQF.aPM() != 0) {
                nz(aQF.aPN());
                this.CP.rU();
            } else if (com.baidu.adp.lib.util.i.fq()) {
                aQk();
            } else {
                showToast(t.j.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.ejk.aQH()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void aQk() {
        c aQF = this.ejk.aQF();
        this.ejk.aQD().setDuration(Math.max(aQF.aPR().size() * 50, 2000));
        this.ejk.aQD().setSigning(0);
        this.ejm.d(aQF);
        this.ejm.LoadData();
        this.ejk.aQG().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.ejk.aQG().getItemViewType(i) == 0 && this.ejk.aQF() != null && this.ejk.aQF().aPO() != null && this.ejk.aQF().aPO().size() > i && (eVar = this.ejk.aQF().aPO().get(i)) != null) {
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
            aQl();
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
        if (this.ejk != null && this.ejk.aQG() != null) {
            this.ejk.aQG().aQm();
        }
        if (this.ejm != null) {
            if (this.ejm.fU) {
                aQl();
            }
            this.ejm.cancelMessage();
            this.ejm = null;
        }
        if (this.ejl != null) {
            this.ejl.cancelLoadData();
            this.ejl = null;
        }
    }

    private void aQl() {
        this.ejn = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(t.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.ejk.aQE();
    }
}
