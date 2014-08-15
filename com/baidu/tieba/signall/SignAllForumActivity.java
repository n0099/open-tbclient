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
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity implements com.baidu.adp.widget.ListView.d {
    private aa a;
    private e b;
    private AlertDialog c;
    private t d;
    private boolean e;
    private boolean f;
    private final CustomMessageListener g = new j(this, 2001200);
    private g h = new k(this);
    private u i = new l(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.e) {
            b f = this.a.f();
            Intent intent = new Intent(this, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            str = getString(com.baidu.tieba.x.signallforum_back_finish, new Object[]{0, Integer.valueOf(f.l().size())});
            a(str, activity, false);
            if (this.f) {
                return;
            }
        }
        showToast(str);
        this.a.c().b();
        ArrayList<d> l = this.a.f().l();
        int size = l.size();
        for (int i = 0; i < size; i++) {
            d dVar = l.get(i);
            dVar.b(true);
            dVar.c(false);
            dVar.a(false);
        }
        this.a.g().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        ap.a(this, com.baidu.tieba.t.singnallforum_progress, getString(com.baidu.tieba.x.app_name), str, str, pendingIntent, z);
    }

    private void a() {
        ap.a(this, com.baidu.tieba.t.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        a();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.f.a(this, "signall_noyify_click");
        }
        registerListener(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void b() {
        this.a = new aa(this);
        this.a.a((com.baidu.adp.widget.ListView.d) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        e();
    }

    private void c() {
        this.b = new e(this);
        this.b.a(this.h);
        this.d = t.a(this);
        this.d.a(this.i);
        if (this.d.a) {
            this.h.a(this.d.a());
            this.a.c().setSigning(90);
            return;
        }
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.x.neterror);
            this.a.b();
        } else if (!this.b.LoadData()) {
            this.a.b();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        b f = this.a.f();
        if (view == this.a.d()) {
            if (this.a.c().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.x.signallforum_finished);
                return;
            }
            if (f.g() != 0) {
                this.c.setMessage(f.h());
                if (!this.c.isShowing()) {
                    this.c.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    d();
                } else {
                    showToast(com.baidu.tieba.x.neterror);
                }
            }
            com.baidu.tbadk.core.f.a(this, "signall_click");
        } else if (view == this.a.h()) {
            sendMessage(new CustomMessage(2002001, new at(this, 2, "msign")));
        }
    }

    private void d() {
        b f = this.a.f();
        this.a.c().setDuration(Math.max(f.l().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.a.c().setSigning(0);
        this.d.a(f);
        this.d.LoadData();
        this.a.g().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.a.g().getItemViewType(i) == 0 && (dVar = this.a.f().i().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this).a(dVar.c(), "signallforum")));
            com.baidu.tbadk.core.f.a(this, "signall_frs_click");
        }
    }

    private void e() {
        this.c = new AlertDialog.Builder(this).setPositiveButton(com.baidu.tieba.x.signallforum_signnow, new m(this)).create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.d != null && this.d.a) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f = true;
        if (this.b != null) {
            this.b.cancelLoadData();
            this.b = null;
        }
        if (this.a != null && this.a.g() != null) {
            this.a.g().a();
        }
        if (this.d != null && this.d.a) {
            f();
        } else if (this.b != null) {
            this.b.cancelLoadData();
            this.b = null;
        }
    }

    private void f() {
        this.e = true;
        Intent intent = new Intent(this, SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getString(com.baidu.tieba.x.signallforum_back_signing), PendingIntent.getActivity(this, 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.a.e();
    }
}
