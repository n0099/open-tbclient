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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.ai;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity implements com.baidu.adp.widget.ListView.d {
    private x a;
    private c b;
    private AlertDialog c;
    private q d;
    private boolean e;
    private boolean f;
    private e g = new h(this);
    private r h = new i(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.e) {
            a f = this.a.f();
            Intent intent = new Intent(this, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            str = getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{0, Integer.valueOf(f.m().size())});
            a(str, activity, false);
            if (this.f) {
                return;
            }
        }
        showToast(str);
        this.a.c().a();
        a f2 = this.a.f();
        ArrayList<b> m = f2.m();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            b bVar = m.get(i);
            bVar.b(true);
            bVar.c(false);
            bVar.a(false);
        }
        int size2 = f2.j().size();
        int size3 = f2.l().size();
        this.a.h().setText(getString(com.baidu.tieba.y.signallforum_res, new Object[]{Integer.valueOf(size3), Integer.valueOf(size2 - size3)}));
        this.a.g().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        bb.a(this, com.baidu.tieba.u.singnallforum_progress, getString(com.baidu.tieba.y.app_name), str, str, pendingIntent, z);
    }

    private void a() {
        bb.a(this, com.baidu.tieba.u.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
        a();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.f.a(this, "signall_noyify_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (ai.c().i() > 0 && this.a != null && this.a.f() != null && this.a.f().j() != null) {
            a f = this.a.f();
            ai c = ai.c();
            ArrayList<b> m = f.m();
            ArrayList<b> l = f.l();
            Iterator<b> it = m.iterator();
            while (it.hasNext()) {
                b next = it.next();
                String b = next.b();
                if (c.a(b)) {
                    int b2 = c.b(b);
                    next.a(1);
                    next.a(true);
                    next.d(b2);
                    next.b(false);
                    next.c(false);
                    it.remove();
                    l.add(next);
                }
            }
        }
        this.a.g().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void b() {
        this.a = new x(this);
        this.a.a((com.baidu.adp.widget.ListView.d) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        e();
    }

    private void c() {
        this.b = new c();
        this.b.a(this.g);
        this.d = q.a();
        this.d.a(this.h);
        if (this.d.a) {
            this.g.a(this.d.b());
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
            showToast(com.baidu.tieba.y.neterror);
            this.a.b();
        } else if (!this.b.LoadData()) {
            this.a.b();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        a f = this.a.f();
        if (view == this.a.d()) {
            if (this.a.c().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.y.signallforum_finished);
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
                    showToast(com.baidu.tieba.y.neterror);
                }
            }
            com.baidu.tbadk.core.f.a(this, "signall_click");
        }
    }

    private void d() {
        a f = this.a.f();
        this.a.c().setDuration(Math.max(f.m().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.a.c().setSigning(0);
        this.d.a(f);
        this.d.LoadData();
        this.a.g().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        if (this.a.g().getItemViewType(i) == 0 && (bVar = this.a.f().j().get(i / 2)) != null) {
            sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(this).a(bVar.b(), "signallforum")));
            com.baidu.tbadk.core.f.a(this, "signall_frs_click");
        }
    }

    private void e() {
        this.c = new AlertDialog.Builder(this).setPositiveButton(com.baidu.tieba.y.signallforum_signnow, new j(this)).create();
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
        a(getString(com.baidu.tieba.y.signallforum_back_signing), PendingIntent.getActivity(this, 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.a.e();
    }
}
