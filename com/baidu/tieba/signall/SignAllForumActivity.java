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
    private com.baidu.tbadk.core.dialog.a Lu;
    private z cQp;
    private f cQq;
    private r cQr;
    private boolean cQs;
    private boolean cQt;
    private final CustomMessageListener mMemListener = new i(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener cQu = new j(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a cQv = new k(this);
    private r.a cQw = new l(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void li(String str) {
        if (this.cQs) {
            c aub = this.cQp.aub();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{0, Integer.valueOf(aub.att().size())});
            a(str, activity, false);
            if (this.cQt) {
                return;
            }
        }
        showToast(str);
        this.cQp.atZ().atV();
        ArrayList<e> att = this.cQp.aub().att();
        int size = att.size();
        for (int i = 0; i < size; i++) {
            e eVar = att.get(i);
            eVar.gh(true);
            eVar.gi(false);
            eVar.gg(false);
        }
        this.cQp.auc().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress, getPageContext().getString(i.h.app_name), str, str, pendingIntent, z);
    }

    private void wO() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        wO();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.cQu);
        initData();
    }

    private void initUI() {
        this.cQp = new z(this);
        this.cQp.a(this);
        this.cQp.setOnItemClickListener(this);
    }

    private void initData() {
        this.cQq = new f(this);
        this.cQq.a(this.cQv);
        this.cQr = new r(this);
        this.cQr.a(this.cQw);
        if (this.cQr.pY) {
            this.cQv.a(this.cQr.atT());
            this.cQp.atZ().setSigning(90);
            return;
        }
        this.cQp.nw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cQp.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.i.iM()) {
            showToast(i.h.neterror);
            this.cQp.IU();
        } else if (!this.cQq.LoadData()) {
            this.cQp.IU();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c aub = this.cQp.aub();
        if (view == this.cQp.getProgressBar()) {
            if (this.cQp.atZ().getCurrentStatus() == 2) {
                showToast(i.h.signallforum_finished);
                return;
            }
            if (aub.ato() != 0) {
                lj(aub.atp());
                this.Lu.sR();
            } else if (com.baidu.adp.lib.util.i.iM()) {
                atL();
            } else {
                showToast(i.h.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.cQp.aud()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1)));
        }
    }

    private void atL() {
        c aub = this.cQp.aub();
        this.cQp.atZ().setDuration(Math.max(aub.att().size() * 50, 2000));
        this.cQp.atZ().setSigning(0);
        this.cQr.c(aub);
        this.cQr.LoadData();
        this.cQp.auc().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cQp.auc().getItemViewType(i) == 0 && this.cQp.aub() != null && this.cQp.aub().atq() != null && this.cQp.aub().atq().size() > i && (eVar = this.cQp.aub().atq().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(String str) {
        this.Lu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cu(str).a(i.h.signallforum_signnow, new m(this));
        this.Lu.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cQr != null && this.cQr.pY) {
            atM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cQt = true;
        if (this.Lu != null && this.Lu.isShowing()) {
            this.Lu.dismiss();
        }
        if (this.cQq != null) {
            this.cQq.cancelLoadData();
            this.cQq = null;
        }
        if (this.cQp != null && this.cQp.auc() != null) {
            this.cQp.auc().atN();
        }
        if (this.cQr != null) {
            if (this.cQr.pY) {
                atM();
            }
            this.cQr.cancelMessage();
            this.cQr.cancelLoadData();
            this.cQr = null;
        }
        if (this.cQq != null) {
            this.cQq.cancelLoadData();
            this.cQq = null;
        }
    }

    private void atM() {
        this.cQs = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(i.h.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cQp.aua();
    }
}
