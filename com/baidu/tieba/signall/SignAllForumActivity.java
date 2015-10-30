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
            c atX = this.cQp.atX();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{0, Integer.valueOf(atX.atp().size())});
            a(str, activity, false);
            if (this.cQt) {
                return;
            }
        }
        showToast(str);
        this.cQp.atV().atR();
        ArrayList<e> atp = this.cQp.atX().atp();
        int size = atp.size();
        for (int i = 0; i < size; i++) {
            e eVar = atp.get(i);
            eVar.gh(true);
            eVar.gi(false);
            eVar.gg(false);
        }
        this.cQp.atY().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress, getPageContext().getString(i.h.app_name), str, str, pendingIntent, z);
    }

    private void wL() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        wL();
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
            this.cQv.a(this.cQr.atP());
            this.cQp.atV().setSigning(90);
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
            this.cQp.IQ();
        } else if (!this.cQq.LoadData()) {
            this.cQp.IQ();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c atX = this.cQp.atX();
        if (view == this.cQp.getProgressBar()) {
            if (this.cQp.atV().getCurrentStatus() == 2) {
                showToast(i.h.signallforum_finished);
                return;
            }
            if (atX.atk() != 0) {
                lj(atX.atl());
                this.Lu.sO();
            } else if (com.baidu.adp.lib.util.i.iM()) {
                atH();
            } else {
                showToast(i.h.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.cQp.atZ()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1)));
        }
    }

    private void atH() {
        c atX = this.cQp.atX();
        this.cQp.atV().setDuration(Math.max(atX.atp().size() * 50, 2000));
        this.cQp.atV().setSigning(0);
        this.cQr.c(atX);
        this.cQr.LoadData();
        this.cQp.atY().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cQp.atY().getItemViewType(i) == 0 && this.cQp.atX() != null && this.cQp.atX().atm() != null && this.cQp.atX().atm().size() > i && (eVar = this.cQp.atX().atm().get(i)) != null) {
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
            atI();
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
        if (this.cQp != null && this.cQp.atY() != null) {
            this.cQp.atY().atJ();
        }
        if (this.cQr != null) {
            if (this.cQr.pY) {
                atI();
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

    private void atI() {
        this.cQs = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(i.h.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cQp.atW();
    }
}
