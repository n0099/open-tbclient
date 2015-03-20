package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.baidu.tbadk.core.util.NotificationHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements com.baidu.tbadk.core.view.ae {
    private com.baidu.tbadk.core.dialog.a Lr;
    private ae cdP;
    private f cdQ;
    private u cdR;
    private boolean cdS;
    private boolean cdT;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener cdU = new k(this, 2001228);
    private h cdV = new l(this);
    private v cdW = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void ik(String str) {
        if (this.cdS) {
            c aiX = this.cdP.aiX();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{0, Integer.valueOf(aiX.aip().size())});
            a(str, activity, false);
            if (this.cdT) {
                return;
            }
        }
        showToast(str);
        this.cdP.aiV().aiR();
        ArrayList<e> aip = this.cdP.aiX().aip();
        int size = aip.size();
        for (int i = 0; i < size; i++) {
            e eVar = aip.get(i);
            eVar.eA(true);
            eVar.eB(false);
            eVar.ez(false);
        }
        this.cdP.aiY().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), com.baidu.tieba.u.singnallforum_progress, getPageContext().getString(com.baidu.tieba.y.app_name), str, str, pendingIntent, z);
    }

    private void uX() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), com.baidu.tieba.u.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        uX();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.cdU);
        initData();
    }

    private void initUI() {
        this.cdP = new ae(this);
        this.cdP.a(this);
        this.cdP.setOnItemClickListener(this);
    }

    private void initData() {
        this.cdQ = new f(this);
        this.cdQ.a(this.cdV);
        this.cdR = u.e(this);
        this.cdR.a(this.cdW);
        if (this.cdR.pT) {
            this.cdV.a(this.cdR.aiP());
            this.cdP.aiV().setSigning(90);
            return;
        }
        this.cdP.mX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cdP.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.y.neterror);
            this.cdP.Hr();
        } else if (!this.cdQ.LoadData()) {
            this.cdP.Hr();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c aiX = this.cdP.aiX();
        if (view == this.cdP.getProgressBar()) {
            if (this.cdP.aiV().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.y.signallforum_finished);
                return;
            }
            if (aiX.aik() != 0) {
                il(aiX.ail());
                this.Lr.re();
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    aiH();
                } else {
                    showToast(com.baidu.tieba.y.neterror);
                }
            }
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_click");
        } else if (view == this.cdP.aiZ()) {
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign")));
        }
    }

    private void aiH() {
        c aiX = this.cdP.aiX();
        this.cdP.aiV().setDuration(Math.max(aiX.aip().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.cdP.aiV().setSigning(0);
        this.cdR.c(aiX);
        this.cdR.LoadData();
        this.cdP.aiY().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cdP.aiY().getItemViewType(i) == 0 && this.cdP.aiX() != null && this.cdP.aiX().aim() != null && this.cdP.aiX().aim().size() > i && (eVar = this.cdP.aiX().aim().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il(String str) {
        this.Lr = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ca(str).a(com.baidu.tieba.y.signallforum_signnow, new n(this));
        this.Lr.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cdR != null && this.cdR.pT) {
            aiI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cdT = true;
        if (this.cdQ != null) {
            this.cdQ.cancelLoadData();
            this.cdQ = null;
        }
        if (this.cdP != null && this.cdP.aiY() != null) {
            this.cdP.aiY().aiJ();
        }
        if (this.cdR != null && this.cdR.pT) {
            aiI();
        } else if (this.cdQ != null) {
            this.cdQ.cancelLoadData();
            this.cdQ = null;
        }
    }

    private void aiI() {
        this.cdS = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(com.baidu.tieba.y.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cdP.aiW();
    }
}
