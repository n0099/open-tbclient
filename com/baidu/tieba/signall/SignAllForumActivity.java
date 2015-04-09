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
    private com.baidu.tbadk.core.dialog.a Lt;
    private ae cee;
    private f cef;
    private u ceg;
    private boolean ceh;
    private boolean cei;
    private final CustomMessageListener mMemListener = new j(this, 2001200);
    private final CustomMessageListener cej = new k(this, 2001228);
    private h cek = new l(this);
    private v cel = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void in(String str) {
        if (this.ceh) {
            c ajm = this.cee.ajm();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{0, Integer.valueOf(ajm.aiE().size())});
            a(str, activity, false);
            if (this.cei) {
                return;
            }
        }
        showToast(str);
        this.cee.ajk().ajg();
        ArrayList<e> aiE = this.cee.ajm().aiE();
        int size = aiE.size();
        for (int i = 0; i < size; i++) {
            e eVar = aiE.get(i);
            eVar.ey(true);
            eVar.ez(false);
            eVar.ex(false);
        }
        this.cee.ajn().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), com.baidu.tieba.u.singnallforum_progress, getPageContext().getString(com.baidu.tieba.y.app_name), str, str, pendingIntent, z);
    }

    private void vd() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), com.baidu.tieba.u.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        vd();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.cej);
        initData();
    }

    private void initUI() {
        this.cee = new ae(this);
        this.cee.a(this);
        this.cee.setOnItemClickListener(this);
    }

    private void initData() {
        this.cef = new f(this);
        this.cef.a(this.cek);
        this.ceg = u.e(this);
        this.ceg.a(this.cel);
        if (this.ceg.pT) {
            this.cek.a(this.ceg.aje());
            this.cee.ajk().setSigning(90);
            return;
        }
        this.cee.mX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cee.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.y.neterror);
            this.cee.Hx();
        } else if (!this.cef.LoadData()) {
            this.cee.Hx();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c ajm = this.cee.ajm();
        if (view == this.cee.getProgressBar()) {
            if (this.cee.ajk().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.y.signallforum_finished);
                return;
            }
            if (ajm.aiz() != 0) {
                io(ajm.aiA());
                this.Lt.re();
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    aiW();
                } else {
                    showToast(com.baidu.tieba.y.neterror);
                }
            }
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_click");
        } else if (view == this.cee.ajo()) {
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign")));
        }
    }

    private void aiW() {
        c ajm = this.cee.ajm();
        this.cee.ajk().setDuration(Math.max(ajm.aiE().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.cee.ajk().setSigning(0);
        this.ceg.c(ajm);
        this.ceg.LoadData();
        this.cee.ajn().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cee.ajn().getItemViewType(i) == 0 && this.cee.ajm() != null && this.cee.ajm().aiB() != null && this.cee.ajm().aiB().size() > i && (eVar = this.cee.ajm().aiB().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io(String str) {
        this.Lt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ca(str).a(com.baidu.tieba.y.signallforum_signnow, new n(this));
        this.Lt.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ceg != null && this.ceg.pT) {
            aiX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cei = true;
        if (this.cef != null) {
            this.cef.cancelLoadData();
            this.cef = null;
        }
        if (this.cee != null && this.cee.ajn() != null) {
            this.cee.ajn().aiY();
        }
        if (this.ceg != null && this.ceg.pT) {
            aiX();
        } else if (this.cef != null) {
            this.cef.cancelLoadData();
            this.cef = null;
        }
    }

    private void aiX() {
        this.ceh = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(com.baidu.tieba.y.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cee.ajl();
    }
}
