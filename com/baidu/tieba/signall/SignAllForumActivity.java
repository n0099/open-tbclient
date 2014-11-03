package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity implements com.baidu.adp.widget.ListView.f {
    private AlertDialog Bf;
    private boolean aFY;
    private ab bKV;
    private e bKW;
    private u bKX;
    private boolean bKY;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener bKZ = new k(this, 2001228);
    private g bLa = new l(this);
    private v bLb = new m(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(String str) {
        if (this.bKY) {
            b adj = this.bKV.adj();
            Intent intent = new Intent(this, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            str = getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{0, Integer.valueOf(adj.acD().size())});
            a(str, activity, false);
            if (this.aFY) {
                return;
            }
        }
        showToast(str);
        this.bKV.adh().adf();
        ArrayList<d> acD = this.bKV.adj().acD();
        int size = acD.size();
        for (int i = 0; i < size; i++) {
            d dVar = acD.get(i);
            dVar.eE(true);
            dVar.eF(false);
            dVar.eD(false);
        }
        this.bKV.adk().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(this, com.baidu.tieba.u.singnallforum_progress, getString(com.baidu.tieba.y.app_name), str, str, pendingIntent, z);
    }

    private void oH() {
        NotificationHelper.cancelNotification(this, com.baidu.tieba.u.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        oH();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.j.l(this, "signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.bKZ);
        initData();
    }

    private void initUI() {
        this.bKV = new ab(this);
        this.bKV.a(this);
        this.bKV.setOnItemClickListener(this);
        acV();
    }

    private void initData() {
        this.bKW = new e(this);
        this.bKW.a(this.bLa);
        this.bKX = u.ai(this);
        this.bKX.a(this.bLb);
        if (this.bKX.cs) {
            this.bLa.a(this.bKX.add());
            this.bKV.adh().setSigning(90);
            return;
        }
        this.bKV.hO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bKV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.y.neterror);
            this.bKV.IR();
        } else if (!this.bKW.LoadData()) {
            this.bKV.IR();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        b adj = this.bKV.adj();
        if (view == this.bKV.getProgressBar()) {
            if (this.bKV.adh().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.y.signallforum_finished);
                return;
            }
            if (adj.acy() != 0) {
                this.Bf.setMessage(adj.acz());
                if (!this.Bf.isShowing()) {
                    this.Bf.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    acU();
                } else {
                    showToast(com.baidu.tieba.y.neterror);
                }
            }
            com.baidu.tbadk.core.j.l(this, "signall_click");
        } else if (view == this.bKV.adl()) {
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this, 2, "msign")));
        }
    }

    private void acU() {
        b adj = this.bKV.adj();
        this.bKV.adh().setDuration(Math.max(adj.acD().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.bKV.adh().setSigning(0);
        this.bKX.c(adj);
        this.bKX.LoadData();
        this.bKV.adk().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.bKV.adk().getItemViewType(i) == 0 && this.bKV.adj() != null && this.bKV.adj().acA() != null && this.bKV.adj().acA().size() > i && (dVar = this.bKV.adj().acA().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this).createNormalCfg(dVar.getForumName(), "signallforum")));
            com.baidu.tbadk.core.j.l(this, "signall_frs_click");
        }
    }

    private void acV() {
        this.Bf = new AlertDialog.Builder(this).setPositiveButton(com.baidu.tieba.y.signallforum_signnow, new n(this)).create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bKX != null && this.bKX.cs) {
            acW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aFY = true;
        if (this.bKW != null) {
            this.bKW.cancelLoadData();
            this.bKW = null;
        }
        if (this.bKV != null && this.bKV.adk() != null) {
            this.bKV.adk().acX();
        }
        if (this.bKX != null && this.bKX.cs) {
            acW();
        } else if (this.bKW != null) {
            this.bKW.cancelLoadData();
            this.bKW = null;
        }
    }

    private void acW() {
        this.bKY = true;
        Intent intent = new Intent(this, SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getString(com.baidu.tieba.y.signallforum_back_signing), PendingIntent.getActivity(this, 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bKV.adi();
    }
}
