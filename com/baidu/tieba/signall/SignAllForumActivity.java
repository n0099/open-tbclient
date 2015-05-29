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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.aj;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements aj {
    private com.baidu.tbadk.core.dialog.a Ll;
    private ae cij;
    private f cik;
    private u cil;
    private boolean cim;
    private boolean cin;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener cio = new k(this, 2001228);
    private h cip = new l(this);
    private v ciq = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void jg(String str) {
        if (this.cim) {
            c akW = this.cij.akW();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(com.baidu.tieba.t.signallforum_back_finish, new Object[]{0, Integer.valueOf(akW.ako().size())});
            a(str, activity, false);
            if (this.cin) {
                return;
            }
        }
        showToast(str);
        this.cij.akU().akQ();
        ArrayList<e> ako = this.cij.akW().ako();
        int size = ako.size();
        for (int i = 0; i < size; i++) {
            e eVar = ako.get(i);
            eVar.eS(true);
            eVar.eT(false);
            eVar.eR(false);
        }
        this.cij.akX().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), com.baidu.tieba.p.singnallforum_progress, getPageContext().getString(com.baidu.tieba.t.app_name), str, str, pendingIntent, z);
    }

    private void vN() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), com.baidu.tieba.p.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        vN();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.cio);
        initData();
    }

    private void initUI() {
        this.cij = new ae(this);
        this.cij.a(this);
        this.cij.setOnItemClickListener(this);
    }

    private void initData() {
        this.cik = new f(this);
        this.cik.a(this.cip);
        this.cil = new u(this);
        this.cil.a(this.ciq);
        if (this.cil.pY) {
            this.cip.a(this.cil.akO());
            this.cij.akU().setSigning(90);
            return;
        }
        this.cij.no();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cij.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.t.neterror);
            this.cij.Ix();
        } else if (!this.cik.LoadData()) {
            this.cij.Ix();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c akW = this.cij.akW();
        if (view == this.cij.getProgressBar()) {
            if (this.cij.akU().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.t.signallforum_finished);
                return;
            }
            if (akW.akj() != 0) {
                jh(akW.akk());
                this.Ll.rL();
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    akG();
                } else {
                    showToast(com.baidu.tieba.t.neterror);
                }
            }
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_click");
        } else if (view == this.cij.akY()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1)));
        }
    }

    private void akG() {
        c akW = this.cij.akW();
        this.cij.akU().setDuration(Math.max(akW.ako().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.cij.akU().setSigning(0);
        this.cil.c(akW);
        this.cil.LoadData();
        this.cij.akX().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cij.akX().getItemViewType(i) == 0 && this.cij.akW() != null && this.cij.akW().akl() != null && this.cij.akW().akl().size() > i && (eVar = this.cij.akW().akl().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jh(String str) {
        this.Ll = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cn(str).a(com.baidu.tieba.t.signallforum_signnow, new n(this));
        this.Ll.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cil != null && this.cil.pY) {
            akH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cin = true;
        if (this.Ll != null && this.Ll.isShowing()) {
            this.Ll.dismiss();
        }
        if (this.cik != null) {
            this.cik.cancelLoadData();
            this.cik = null;
        }
        if (this.cij != null && this.cij.akX() != null) {
            this.cij.akX().akI();
        }
        if (this.cil != null) {
            if (this.cil.pY) {
                akH();
            }
            this.cil.cancelMessage();
            this.cil.cancelLoadData();
            this.cil = null;
        }
        if (this.cik != null) {
            this.cik.cancelLoadData();
            this.cik = null;
        }
    }

    private void akH() {
        this.cim = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(com.baidu.tieba.t.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cij.akV();
    }
}
