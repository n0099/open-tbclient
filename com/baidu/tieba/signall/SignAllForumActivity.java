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
    private boolean aHD;
    private ad bPl;
    private e bPm;
    private u bPn;
    private boolean bPo;
    private AlertDialog mDialog;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener bPp = new k(this, 2001228);
    private g bPq = new l(this);
    private v bPr = new m(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(String str) {
        if (this.bPo) {
            b adH = this.bPl.adH();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(com.baidu.tieba.z.signallforum_back_finish, new Object[]{0, Integer.valueOf(adH.acY().size())});
            a(str, activity, false);
            if (this.aHD) {
                return;
            }
        }
        showToast(str);
        this.bPl.adF().adB();
        ArrayList<d> acY = this.bPl.adH().acY();
        int size = acY.size();
        for (int i = 0; i < size; i++) {
            d dVar = acY.get(i);
            dVar.el(true);
            dVar.em(false);
            dVar.ek(false);
        }
        this.bPl.adI().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), com.baidu.tieba.v.singnallforum_progress, getPageContext().getString(com.baidu.tieba.z.app_name), str, str, pendingIntent, z);
    }

    private void rM() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), com.baidu.tieba.v.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        rM();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.bPp);
        initData();
    }

    private void initUI() {
        this.bPl = new ad(this);
        this.bPl.a(this);
        this.bPl.setOnItemClickListener(this);
        adr();
    }

    private void initData() {
        this.bPm = new e(this);
        this.bPm.a(this.bPq);
        this.bPn = u.e(this);
        this.bPn.a(this.bPr);
        if (this.bPn.ez) {
            this.bPq.a(this.bPn.adz());
            this.bPl.adF().setSigning(90);
            return;
        }
        this.bPl.jK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bPl.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.z.neterror);
            this.bPl.Jm();
        } else if (!this.bPm.LoadData()) {
            this.bPl.Jm();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        b adH = this.bPl.adH();
        if (view == this.bPl.getProgressBar()) {
            if (this.bPl.adF().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.z.signallforum_finished);
                return;
            }
            if (adH.acT() != 0) {
                this.mDialog.setMessage(adH.acU());
                if (!this.mDialog.isShowing()) {
                    this.mDialog.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    adq();
                } else {
                    showToast(com.baidu.tieba.z.neterror);
                }
            }
            com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "signall_click");
        } else if (view == this.bPl.adJ()) {
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign")));
        }
    }

    private void adq() {
        b adH = this.bPl.adH();
        this.bPl.adF().setDuration(Math.max(adH.acY().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.bPl.adF().setSigning(0);
        this.bPn.c(adH);
        this.bPn.LoadData();
        this.bPl.adI().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.bPl.adI().getItemViewType(i) == 0 && this.bPl.adH() != null && this.bPl.adH().acV() != null && this.bPl.adH().acV().size() > i && (dVar = this.bPl.adH().acV().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "signall_frs_click");
        }
    }

    private void adr() {
        this.mDialog = new AlertDialog.Builder(getPageContext().getPageActivity()).setPositiveButton(com.baidu.tieba.z.signallforum_signnow, new n(this)).create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bPn != null && this.bPn.ez) {
            ads();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aHD = true;
        if (this.bPm != null) {
            this.bPm.cancelLoadData();
            this.bPm = null;
        }
        if (this.bPl != null && this.bPl.adI() != null) {
            this.bPl.adI().adt();
        }
        if (this.bPn != null && this.bPn.ez) {
            ads();
        } else if (this.bPm != null) {
            this.bPm.cancelLoadData();
            this.bPm = null;
        }
    }

    private void ads() {
        this.bPo = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(com.baidu.tieba.z.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bPl.adG();
    }
}
