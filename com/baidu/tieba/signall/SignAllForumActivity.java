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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.f;
import com.baidu.tieba.signall.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements x.a {
    private com.baidu.tbadk.core.dialog.a Lt;
    private boolean cAA;
    private boolean cAB;
    private z cAx;
    private f cAy;
    private r cAz;
    private final CustomMessageListener mMemListener = new i(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener cAC = new j(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a cAD = new k(this);
    private r.a cAE = new l(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void kc(String str) {
        if (this.cAA) {
            c any = this.cAx.any();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(i.C0057i.signallforum_back_finish, new Object[]{0, Integer.valueOf(any.amQ().size())});
            a(str, activity, false);
            if (this.cAB) {
                return;
            }
        }
        showToast(str);
        this.cAx.anw().ans();
        ArrayList<e> amQ = this.cAx.any().amQ();
        int size = amQ.size();
        for (int i = 0; i < size; i++) {
            e eVar = amQ.get(i);
            eVar.fl(true);
            eVar.fm(false);
            eVar.fk(false);
        }
        this.cAx.anz().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress, getPageContext().getString(i.C0057i.app_name), str, str, pendingIntent, z);
    }

    private void wX() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        wX();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.cAC);
        initData();
    }

    private void initUI() {
        this.cAx = new z(this);
        this.cAx.a(this);
        this.cAx.setOnItemClickListener(this);
    }

    private void initData() {
        this.cAy = new f(this);
        this.cAy.a(this.cAD);
        this.cAz = new r(this);
        this.cAz.a(this.cAE);
        if (this.cAz.pY) {
            this.cAD.a(this.cAz.anq());
            this.cAx.anw().setSigning(90);
            return;
        }
        this.cAx.ny();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cAx.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.i.iO()) {
            showToast(i.C0057i.neterror);
            this.cAx.Jl();
        } else if (!this.cAy.LoadData()) {
            this.cAx.Jl();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c any = this.cAx.any();
        if (view == this.cAx.getProgressBar()) {
            if (this.cAx.anw().getCurrentStatus() == 2) {
                showToast(i.C0057i.signallforum_finished);
                return;
            }
            if (any.amL() != 0) {
                kd(any.amM());
                this.Lt.sP();
            } else if (com.baidu.adp.lib.util.i.iO()) {
                ani();
            } else {
                showToast(i.C0057i.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.cAx.anA()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1)));
        }
    }

    private void ani() {
        c any = this.cAx.any();
        this.cAx.anw().setDuration(Math.max(any.amQ().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.cAx.anw().setSigning(0);
        this.cAz.c(any);
        this.cAz.LoadData();
        this.cAx.anz().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cAx.anz().getItemViewType(i) == 0 && this.cAx.any() != null && this.cAx.any().amN() != null && this.cAx.any().amN().size() > i && (eVar = this.cAx.any().amN().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(String str) {
        this.Lt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cn(str).a(i.C0057i.signallforum_signnow, new m(this));
        this.Lt.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cAz != null && this.cAz.pY) {
            anj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cAB = true;
        if (this.Lt != null && this.Lt.isShowing()) {
            this.Lt.dismiss();
        }
        if (this.cAy != null) {
            this.cAy.cancelLoadData();
            this.cAy = null;
        }
        if (this.cAx != null && this.cAx.anz() != null) {
            this.cAx.anz().ank();
        }
        if (this.cAz != null) {
            if (this.cAz.pY) {
                anj();
            }
            this.cAz.cancelMessage();
            this.cAz.cancelLoadData();
            this.cAz = null;
        }
        if (this.cAy != null) {
            this.cAy.cancelLoadData();
            this.cAy = null;
        }
    }

    private void anj() {
        this.cAA = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(i.C0057i.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cAx.anx();
    }
}
