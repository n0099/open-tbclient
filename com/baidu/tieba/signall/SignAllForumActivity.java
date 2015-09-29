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
    private com.baidu.tbadk.core.dialog.a Lt;
    private z cPQ;
    private f cPR;
    private r cPS;
    private boolean cPT;
    private boolean cPU;
    private final CustomMessageListener mMemListener = new i(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener cPV = new j(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a cPW = new k(this);
    private r.a cPX = new l(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void lf(String str) {
        if (this.cPT) {
            c atV = this.cPQ.atV();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{0, Integer.valueOf(atV.atn().size())});
            a(str, activity, false);
            if (this.cPU) {
                return;
            }
        }
        showToast(str);
        this.cPQ.atT().atP();
        ArrayList<e> atn = this.cPQ.atV().atn();
        int size = atn.size();
        for (int i = 0; i < size; i++) {
            e eVar = atn.get(i);
            eVar.gh(true);
            eVar.gi(false);
            eVar.gg(false);
        }
        this.cPQ.atW().notifyDataSetChanged();
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
        registerListener(this.cPV);
        initData();
    }

    private void initUI() {
        this.cPQ = new z(this);
        this.cPQ.a(this);
        this.cPQ.setOnItemClickListener(this);
    }

    private void initData() {
        this.cPR = new f(this);
        this.cPR.a(this.cPW);
        this.cPS = new r(this);
        this.cPS.a(this.cPX);
        if (this.cPS.pY) {
            this.cPW.a(this.cPS.atN());
            this.cPQ.atT().setSigning(90);
            return;
        }
        this.cPQ.nw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cPQ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.i.iM()) {
            showToast(i.h.neterror);
            this.cPQ.IU();
        } else if (!this.cPR.LoadData()) {
            this.cPQ.IU();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c atV = this.cPQ.atV();
        if (view == this.cPQ.getProgressBar()) {
            if (this.cPQ.atT().getCurrentStatus() == 2) {
                showToast(i.h.signallforum_finished);
                return;
            }
            if (atV.ati() != 0) {
                lg(atV.atj());
                this.Lt.sR();
            } else if (com.baidu.adp.lib.util.i.iM()) {
                atF();
            } else {
                showToast(i.h.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.cPQ.atX()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1)));
        }
    }

    private void atF() {
        c atV = this.cPQ.atV();
        this.cPQ.atT().setDuration(Math.max(atV.atn().size() * 50, 2000));
        this.cPQ.atT().setSigning(0);
        this.cPS.c(atV);
        this.cPS.LoadData();
        this.cPQ.atW().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cPQ.atW().getItemViewType(i) == 0 && this.cPQ.atV() != null && this.cPQ.atV().atk() != null && this.cPQ.atV().atk().size() > i && (eVar = this.cPQ.atV().atk().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg(String str) {
        this.Lt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ct(str).a(i.h.signallforum_signnow, new m(this));
        this.Lt.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cPS != null && this.cPS.pY) {
            atG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cPU = true;
        if (this.Lt != null && this.Lt.isShowing()) {
            this.Lt.dismiss();
        }
        if (this.cPR != null) {
            this.cPR.cancelLoadData();
            this.cPR = null;
        }
        if (this.cPQ != null && this.cPQ.atW() != null) {
            this.cPQ.atW().atH();
        }
        if (this.cPS != null) {
            if (this.cPS.pY) {
                atG();
            }
            this.cPS.cancelMessage();
            this.cPS.cancelLoadData();
            this.cPS = null;
        }
        if (this.cPR != null) {
            this.cPR.cancelLoadData();
            this.cPR = null;
        }
    }

    private void atG() {
        this.cPT = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(i.h.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cPQ.atU();
    }
}
