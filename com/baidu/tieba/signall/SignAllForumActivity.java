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
    private ae cik;
    private f cil;
    private u cim;
    private boolean cin;
    private boolean cio;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener cip = new k(this, 2001228);
    private h ciq = new l(this);
    private v cir = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void jg(String str) {
        if (this.cin) {
            c akX = this.cik.akX();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(com.baidu.tieba.t.signallforum_back_finish, new Object[]{0, Integer.valueOf(akX.akp().size())});
            a(str, activity, false);
            if (this.cio) {
                return;
            }
        }
        showToast(str);
        this.cik.akV().akR();
        ArrayList<e> akp = this.cik.akX().akp();
        int size = akp.size();
        for (int i = 0; i < size; i++) {
            e eVar = akp.get(i);
            eVar.eS(true);
            eVar.eT(false);
            eVar.eR(false);
        }
        this.cik.akY().notifyDataSetChanged();
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
        registerListener(this.cip);
        initData();
    }

    private void initUI() {
        this.cik = new ae(this);
        this.cik.a(this);
        this.cik.setOnItemClickListener(this);
    }

    private void initData() {
        this.cil = new f(this);
        this.cil.a(this.ciq);
        this.cim = new u(this);
        this.cim.a(this.cir);
        if (this.cim.pY) {
            this.ciq.a(this.cim.akP());
            this.cik.akV().setSigning(90);
            return;
        }
        this.cik.no();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cik.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.t.neterror);
            this.cik.Iy();
        } else if (!this.cil.LoadData()) {
            this.cik.Iy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c akX = this.cik.akX();
        if (view == this.cik.getProgressBar()) {
            if (this.cik.akV().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.t.signallforum_finished);
                return;
            }
            if (akX.akk() != 0) {
                jh(akX.akl());
                this.Ll.rL();
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    akH();
                } else {
                    showToast(com.baidu.tieba.t.neterror);
                }
            }
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_click");
        } else if (view == this.cik.akZ()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1)));
        }
    }

    private void akH() {
        c akX = this.cik.akX();
        this.cik.akV().setDuration(Math.max(akX.akp().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.cik.akV().setSigning(0);
        this.cim.c(akX);
        this.cim.LoadData();
        this.cik.akY().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cik.akY().getItemViewType(i) == 0 && this.cik.akX() != null && this.cik.akX().akm() != null && this.cik.akX().akm().size() > i && (eVar = this.cik.akX().akm().get(i)) != null) {
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
        if (this.cim != null && this.cim.pY) {
            akI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cio = true;
        if (this.Ll != null && this.Ll.isShowing()) {
            this.Ll.dismiss();
        }
        if (this.cil != null) {
            this.cil.cancelLoadData();
            this.cil = null;
        }
        if (this.cik != null && this.cik.akY() != null) {
            this.cik.akY().akJ();
        }
        if (this.cim != null) {
            if (this.cim.pY) {
                akI();
            }
            this.cim.cancelMessage();
            this.cim.cancelLoadData();
            this.cim = null;
        }
        if (this.cil != null) {
            this.cil.cancelLoadData();
            this.cil = null;
        }
    }

    private void akI() {
        this.cin = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(com.baidu.tieba.t.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cik.akW();
    }
}
