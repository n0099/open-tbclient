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
    private boolean aIK;
    private ad bQU;
    private e bQV;
    private u bQW;
    private boolean bQX;
    private AlertDialog mDialog;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener bQY = new k(this, 2001228);
    private g bQZ = new l(this);
    private v bRa = new m(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(String str) {
        if (this.bQX) {
            b aeg = this.bQU.aeg();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(com.baidu.tieba.z.signallforum_back_finish, new Object[]{0, Integer.valueOf(aeg.adx().size())});
            a(str, activity, false);
            if (this.aIK) {
                return;
            }
        }
        showToast(str);
        this.bQU.aee().aea();
        ArrayList<d> adx = this.bQU.aeg().adx();
        int size = adx.size();
        for (int i = 0; i < size; i++) {
            d dVar = adx.get(i);
            dVar.es(true);
            dVar.et(false);
            dVar.er(false);
        }
        this.bQU.aeh().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), com.baidu.tieba.v.singnallforum_progress, getPageContext().getString(com.baidu.tieba.z.app_name), str, str, pendingIntent, z);
    }

    private void rW() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), com.baidu.tieba.v.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        rW();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.bQY);
        initData();
    }

    private void initUI() {
        this.bQU = new ad(this);
        this.bQU.a(this);
        this.bQU.setOnItemClickListener(this);
        adQ();
    }

    private void initData() {
        this.bQV = new e(this);
        this.bQV.a(this.bQZ);
        this.bQW = u.e(this);
        this.bQW.a(this.bRa);
        if (this.bQW.eB) {
            this.bQZ.a(this.bQW.adY());
            this.bQU.aee().setSigning(90);
            return;
        }
        this.bQU.jC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bQU.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.z.neterror);
            this.bQU.JD();
        } else if (!this.bQV.LoadData()) {
            this.bQU.JD();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        b aeg = this.bQU.aeg();
        if (view == this.bQU.getProgressBar()) {
            if (this.bQU.aee().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.z.signallforum_finished);
                return;
            }
            if (aeg.ads() != 0) {
                this.mDialog.setMessage(aeg.adt());
                if (!this.mDialog.isShowing()) {
                    this.mDialog.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    adP();
                } else {
                    showToast(com.baidu.tieba.z.neterror);
                }
            }
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "signall_click");
        } else if (view == this.bQU.aei()) {
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign")));
        }
    }

    private void adP() {
        b aeg = this.bQU.aeg();
        this.bQU.aee().setDuration(Math.max(aeg.adx().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.bQU.aee().setSigning(0);
        this.bQW.c(aeg);
        this.bQW.LoadData();
        this.bQU.aeh().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.bQU.aeh().getItemViewType(i) == 0 && this.bQU.aeg() != null && this.bQU.aeg().adu() != null && this.bQU.aeg().adu().size() > i && (dVar = this.bQU.aeg().adu().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "signall_frs_click");
        }
    }

    private void adQ() {
        this.mDialog = new AlertDialog.Builder(getPageContext().getPageActivity()).setPositiveButton(com.baidu.tieba.z.signallforum_signnow, new n(this)).create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bQW != null && this.bQW.eB) {
            adR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aIK = true;
        if (this.bQV != null) {
            this.bQV.cancelLoadData();
            this.bQV = null;
        }
        if (this.bQU != null && this.bQU.aeh() != null) {
            this.bQU.aeh().adS();
        }
        if (this.bQW != null && this.bQW.eB) {
            adR();
        } else if (this.bQV != null) {
            this.bQV.cancelLoadData();
            this.bQV = null;
        }
    }

    private void adR() {
        this.bQX = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(com.baidu.tieba.z.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bQU.aef();
    }
}
