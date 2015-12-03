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
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.n;
import com.baidu.tieba.signall.f;
import com.baidu.tieba.signall.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements q.a {
    private com.baidu.tbadk.core.dialog.a LN;
    private z dqi;
    private f dqj;
    private r dqk;
    private boolean dql;
    private boolean dqm;
    private final CustomMessageListener mMemListener = new i(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener dqn = new j(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a dqo = new k(this);
    private r.a dqp = new l(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(String str) {
        if (this.dql) {
            c aAf = this.dqi.aAf();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(n.i.signallforum_back_finish, new Object[]{0, Integer.valueOf(aAf.azx().size())});
            a(str, activity, false);
            if (this.dqm) {
                return;
            }
        }
        showToast(str);
        this.dqi.aAd().azZ();
        ArrayList<e> azx = this.dqi.aAf().azx();
        int size = azx.size();
        for (int i = 0; i < size; i++) {
            e eVar = azx.get(i);
            eVar.gZ(true);
            eVar.ha(false);
            eVar.gY(false);
        }
        this.dqi.aAg().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), n.e.singnallforum_progress, getPageContext().getString(n.i.app_name), str, str, pendingIntent, z);
    }

    private void xN() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), n.e.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xN();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.dqn);
        initData();
        initUI();
    }

    private void initUI() {
        this.dqi = new z(this);
        this.dqi.a(this);
        this.dqi.setOnItemClickListener(this);
        if (this.dqk.pZ) {
            this.dqo.a(this.dqk.azX());
            this.dqi.aAd().setSigning(90);
            return;
        }
        this.dqi.nD();
    }

    private void initData() {
        this.dqj = new f(this);
        this.dqj.a(this.dqo);
        this.dqk = new r(this);
        this.dqk.a(this.dqp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dqi.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.i.iP()) {
            showToast(n.i.neterror);
            this.dqi.Kr();
        } else if (!this.dqj.LoadData()) {
            this.dqi.Kr();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c aAf = this.dqi.aAf();
        if (view == this.dqi.getProgressBar()) {
            if (this.dqi.aAd().getCurrentStatus() == 2) {
                showToast(n.i.signallforum_finished);
                return;
            }
            if (aAf.azs() != 0) {
                mb(aAf.azt());
                this.LN.tv();
            } else if (com.baidu.adp.lib.util.i.iP()) {
                azP();
            } else {
                showToast(n.i.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.dqi.aAh()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void azP() {
        c aAf = this.dqi.aAf();
        this.dqi.aAd().setDuration(Math.max(aAf.azx().size() * 50, 2000));
        this.dqi.aAd().setSigning(0);
        this.dqk.c(aAf);
        this.dqk.LoadData();
        this.dqi.aAg().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.dqi.aAg().getItemViewType(i) == 0 && this.dqi.aAf() != null && this.dqi.aAf().azu() != null && this.dqi.aAf().azu().size() > i && (eVar = this.dqi.aAf().azu().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(String str) {
        this.LN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cC(str).a(n.i.signallforum_signnow, new m(this));
        this.LN.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dqk != null && this.dqk.pZ) {
            azQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dqm = true;
        if (this.LN != null && this.LN.isShowing()) {
            this.LN.dismiss();
        }
        if (this.dqj != null) {
            this.dqj.cancelLoadData();
            this.dqj = null;
        }
        if (this.dqi != null && this.dqi.aAg() != null) {
            this.dqi.aAg().azR();
        }
        if (this.dqk != null) {
            if (this.dqk.pZ) {
                azQ();
            }
            this.dqk.cancelMessage();
            this.dqk.cancelLoadData();
            this.dqk = null;
        }
        if (this.dqj != null) {
            this.dqj.cancelLoadData();
            this.dqj = null;
        }
    }

    private void azQ() {
        this.dql = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(n.i.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.dqi.aAe();
    }
}
