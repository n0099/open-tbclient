package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.f;
import com.baidu.tieba.signall.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements p.a {
    private com.baidu.tbadk.core.dialog.a Lv;
    private z cRL;
    private f cRM;
    private r cRN;
    private boolean cRO;
    private boolean cRP;
    private final CustomMessageListener mMemListener = new i(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener cRQ = new j(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a cRR = new k(this);
    private r.a cRS = new l(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void lm(String str) {
        if (this.cRO) {
            c auD = this.cRL.auD();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{0, Integer.valueOf(auD.atV().size())});
            a(str, activity, false);
            if (this.cRP) {
                return;
            }
        }
        showToast(str);
        this.cRL.auB().aux();
        ArrayList<e> atV = this.cRL.auD().atV();
        int size = atV.size();
        for (int i = 0; i < size; i++) {
            e eVar = atV.get(i);
            eVar.gk(true);
            eVar.gl(false);
            eVar.gj(false);
        }
        this.cRL.auE().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress, getPageContext().getString(i.h.app_name), str, str, pendingIntent, z);
    }

    private void wQ() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        wQ();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.cRQ);
        initData();
    }

    private void initUI() {
        this.cRL = new z(this);
        this.cRL.a(this);
        this.cRL.setOnItemClickListener(this);
    }

    private void initData() {
        this.cRM = new f(this);
        this.cRM.a(this.cRR);
        this.cRN = new r(this);
        this.cRN.a(this.cRS);
        if (this.cRN.pY) {
            this.cRR.a(this.cRN.auv());
            this.cRL.auB().setSigning(90);
            return;
        }
        this.cRL.nx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cRL.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.i.iN()) {
            showToast(i.h.neterror);
            this.cRL.Jg();
        } else if (!this.cRM.LoadData()) {
            this.cRL.Jg();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c auD = this.cRL.auD();
        if (view == this.cRL.getProgressBar()) {
            if (this.cRL.auB().getCurrentStatus() == 2) {
                showToast(i.h.signallforum_finished);
                return;
            }
            if (auD.atQ() != 0) {
                ln(auD.atR());
                this.Lv.sR();
            } else if (com.baidu.adp.lib.util.i.iN()) {
                aun();
            } else {
                showToast(i.h.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.cRL.auF()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1)));
        }
    }

    private void aun() {
        c auD = this.cRL.auD();
        this.cRL.auB().setDuration(Math.max(auD.atV().size() * 50, 2000));
        this.cRL.auB().setSigning(0);
        this.cRN.c(auD);
        this.cRN.LoadData();
        this.cRL.auE().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cRL.auE().getItemViewType(i) == 0 && this.cRL.auD() != null && this.cRL.auD().atS() != null && this.cRL.auD().atS().size() > i && (eVar = this.cRL.auD().atS().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(String str) {
        this.Lv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cu(str).a(i.h.signallforum_signnow, new m(this));
        this.Lv.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cRN != null && this.cRN.pY) {
            auo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cRP = true;
        if (this.Lv != null && this.Lv.isShowing()) {
            this.Lv.dismiss();
        }
        if (this.cRM != null) {
            this.cRM.cancelLoadData();
            this.cRM = null;
        }
        if (this.cRL != null && this.cRL.auE() != null) {
            this.cRL.auE().aup();
        }
        if (this.cRN != null) {
            if (this.cRN.pY) {
                auo();
            }
            this.cRN.cancelMessage();
            this.cRN.cancelLoadData();
            this.cRN = null;
        }
        if (this.cRM != null) {
            this.cRM.cancelLoadData();
            this.cRM = null;
        }
    }

    private void auo() {
        this.cRO = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(i.h.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cRL.auC();
    }
}
