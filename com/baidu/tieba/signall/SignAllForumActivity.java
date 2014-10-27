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
    private boolean aFO;
    private ab bKG;
    private e bKH;
    private u bKI;
    private boolean bKJ;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener bKK = new k(this, 2001228);
    private g bKL = new l(this);
    private v bKM = new m(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(String str) {
        if (this.bKJ) {
            b adg = this.bKG.adg();
            Intent intent = new Intent(this, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            str = getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{0, Integer.valueOf(adg.acA().size())});
            a(str, activity, false);
            if (this.aFO) {
                return;
            }
        }
        showToast(str);
        this.bKG.ade().adc();
        ArrayList<d> acA = this.bKG.adg().acA();
        int size = acA.size();
        for (int i = 0; i < size; i++) {
            d dVar = acA.get(i);
            dVar.eE(true);
            dVar.eF(false);
            dVar.eD(false);
        }
        this.bKG.adh().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(this, com.baidu.tieba.u.singnallforum_progress, getString(com.baidu.tieba.y.app_name), str, str, pendingIntent, z);
    }

    private void oF() {
        NotificationHelper.cancelNotification(this, com.baidu.tieba.u.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        oF();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.i.l(this, "signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.bKK);
        initData();
    }

    private void initUI() {
        this.bKG = new ab(this);
        this.bKG.a(this);
        this.bKG.setOnItemClickListener(this);
        acS();
    }

    private void initData() {
        this.bKH = new e(this);
        this.bKH.a(this.bKL);
        this.bKI = u.ai(this);
        this.bKI.a(this.bKM);
        if (this.bKI.cs) {
            this.bKL.a(this.bKI.ada());
            this.bKG.ade().setSigning(90);
            return;
        }
        this.bKG.hO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bKG.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.y.neterror);
            this.bKG.IN();
        } else if (!this.bKH.LoadData()) {
            this.bKG.IN();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        b adg = this.bKG.adg();
        if (view == this.bKG.getProgressBar()) {
            if (this.bKG.ade().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.y.signallforum_finished);
                return;
            }
            if (adg.acv() != 0) {
                this.Bf.setMessage(adg.acw());
                if (!this.Bf.isShowing()) {
                    this.Bf.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    acR();
                } else {
                    showToast(com.baidu.tieba.y.neterror);
                }
            }
            com.baidu.tbadk.core.i.l(this, "signall_click");
        } else if (view == this.bKG.adi()) {
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this, 2, "msign")));
        }
    }

    private void acR() {
        b adg = this.bKG.adg();
        this.bKG.ade().setDuration(Math.max(adg.acA().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.bKG.ade().setSigning(0);
        this.bKI.c(adg);
        this.bKI.LoadData();
        this.bKG.adh().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.bKG.adh().getItemViewType(i) == 0 && this.bKG.adg() != null && this.bKG.adg().acx() != null && this.bKG.adg().acx().size() > i && (dVar = this.bKG.adg().acx().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this).createNormalCfg(dVar.getForumName(), "signallforum")));
            com.baidu.tbadk.core.i.l(this, "signall_frs_click");
        }
    }

    private void acS() {
        this.Bf = new AlertDialog.Builder(this).setPositiveButton(com.baidu.tieba.y.signallforum_signnow, new n(this)).create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bKI != null && this.bKI.cs) {
            acT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aFO = true;
        if (this.bKH != null) {
            this.bKH.cancelLoadData();
            this.bKH = null;
        }
        if (this.bKG != null && this.bKG.adh() != null) {
            this.bKG.adh().acU();
        }
        if (this.bKI != null && this.bKI.cs) {
            acT();
        } else if (this.bKH != null) {
            this.bKH.cancelLoadData();
            this.bKH = null;
        }
    }

    private void acT() {
        this.bKJ = true;
        Intent intent = new Intent(this, SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getString(com.baidu.tieba.y.signallforum_back_signing), PendingIntent.getActivity(this, 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bKG.adf();
    }
}
