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
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements com.baidu.adp.widget.ListView.g {
    private boolean aIN;
    private ad bQV;
    private e bQW;
    private u bQX;
    private boolean bQY;
    private AlertDialog mDialog;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener bQZ = new k(this, 2001228);
    private g bRa = new l(this);
    private v bRb = new m(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW(String str) {
        if (this.bQY) {
            b ael = this.bQV.ael();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(com.baidu.tieba.z.signallforum_back_finish, new Object[]{0, Integer.valueOf(ael.adC().size())});
            a(str, activity, false);
            if (this.aIN) {
                return;
            }
        }
        showToast(str);
        this.bQV.aej().aef();
        ArrayList<d> adC = this.bQV.ael().adC();
        int size = adC.size();
        for (int i = 0; i < size; i++) {
            d dVar = adC.get(i);
            dVar.es(true);
            dVar.et(false);
            dVar.er(false);
        }
        this.bQV.aem().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), com.baidu.tieba.v.singnallforum_progress, getPageContext().getString(com.baidu.tieba.z.app_name), str, str, pendingIntent, z);
    }

    private void sc() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), com.baidu.tieba.v.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        sc();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.bQZ);
        initData();
    }

    private void initUI() {
        this.bQV = new ad(this);
        this.bQV.a(this);
        this.bQV.setOnItemClickListener(this);
        adV();
    }

    private void initData() {
        this.bQW = new e(this);
        this.bQW.a(this.bRa);
        this.bQX = u.e(this);
        this.bQX.a(this.bRb);
        if (this.bQX.eB) {
            this.bRa.a(this.bQX.aed());
            this.bQV.aej().setSigning(90);
            return;
        }
        this.bQV.jJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bQV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.z.neterror);
            this.bQV.JI();
        } else if (!this.bQW.LoadData()) {
            this.bQV.JI();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        b ael = this.bQV.ael();
        if (view == this.bQV.getProgressBar()) {
            if (this.bQV.aej().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.z.signallforum_finished);
                return;
            }
            if (ael.adx() != 0) {
                this.mDialog.setMessage(ael.ady());
                if (!this.mDialog.isShowing()) {
                    this.mDialog.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    adU();
                } else {
                    showToast(com.baidu.tieba.z.neterror);
                }
            }
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "signall_click");
        } else if (view == this.bQV.aen()) {
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign")));
        }
    }

    private void adU() {
        b ael = this.bQV.ael();
        this.bQV.aej().setDuration(Math.max(ael.adC().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.bQV.aej().setSigning(0);
        this.bQX.c(ael);
        this.bQX.LoadData();
        this.bQV.aem().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.bQV.aem().getItemViewType(i) == 0 && this.bQV.ael() != null && this.bQV.ael().adz() != null && this.bQV.ael().adz().size() > i && (dVar = this.bQV.ael().adz().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "signall_frs_click");
        }
    }

    private void adV() {
        this.mDialog = new AlertDialog.Builder(getPageContext().getPageActivity()).setPositiveButton(com.baidu.tieba.z.signallforum_signnow, new n(this)).create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bQX != null && this.bQX.eB) {
            adW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aIN = true;
        if (this.bQW != null) {
            this.bQW.cancelLoadData();
            this.bQW = null;
        }
        if (this.bQV != null && this.bQV.aem() != null) {
            this.bQV.aem().adX();
        }
        if (this.bQX != null && this.bQX.eB) {
            adW();
        } else if (this.bQW != null) {
            this.bQW.cancelLoadData();
            this.bQW = null;
        }
    }

    private void adW() {
        this.bQY = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(com.baidu.tieba.z.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bQV.aek();
    }
}
