package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tieba.ad;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity implements com.baidu.adp.widget.ListView.d {
    private y a;
    private c b;
    private AlertDialog c;
    private r d;
    private boolean e;
    private boolean f;
    private e g = new h(this);
    private s h = new i(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfig.SIGN_ALL_FORUM_CUSTOM_CMD, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.e) {
            a e = this.a.e();
            Intent intent = new Intent(this, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            str = getString(com.baidu.tieba.u.signallforum_back_finish, new Object[]{0, Integer.valueOf(e.m().size())});
            a(str, activity, 16);
            if (this.f) {
                return;
            }
        }
        showToast(str);
        this.a.c().a();
        a e2 = this.a.e();
        ArrayList<b> m = e2.m();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            b bVar = m.get(i);
            bVar.b(true);
            bVar.c(false);
            bVar.a(false);
        }
        int size2 = e2.j().size();
        int size3 = e2.l().size();
        this.a.g().setText(getString(com.baidu.tieba.u.signallforum_res, new Object[]{Integer.valueOf(size3), Integer.valueOf(size2 - size3)}));
        this.a.f().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, int i) {
        Notification notification = new Notification(com.baidu.tieba.q.icon, str, System.currentTimeMillis());
        String string = getString(com.baidu.tieba.u.app_name);
        notification.icon = com.baidu.tieba.q.icon;
        notification.setLatestEventInfo(this, string, str, pendingIntent);
        notification.flags = i;
        ((NotificationManager) getSystemService("notification")).notify(com.baidu.tieba.q.singnallforum_progress, notification);
    }

    private void a() {
        ((NotificationManager) getSystemService("notification")).cancel(com.baidu.tieba.q.singnallforum_progress);
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
            com.baidu.tbadk.core.g.a(this, "signall_noyify_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (ad.c().i() > 0 && this.a != null && this.a.e() != null && this.a.e().j() != null) {
            a e = this.a.e();
            ad c = ad.c();
            ArrayList<b> m = e.m();
            ArrayList<b> l = e.l();
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
        this.a.f().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.f().b();
    }

    private void b() {
        this.a = new y(this);
        this.a.a((com.baidu.adp.widget.ListView.d) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        e();
    }

    private void c() {
        this.b = new c();
        this.b.a(this.g);
        this.d = r.a();
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
            showToast(com.baidu.tieba.u.neterror);
            this.a.b();
            return;
        }
        this.b.LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        a e = this.a.e();
        if (view == this.a.d()) {
            if (this.a.c().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.u.signallforum_finished);
                return;
            }
            if (e.g() != 0) {
                this.c.setMessage(e.h());
                if (!this.c.isShowing()) {
                    this.c.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    d();
                } else {
                    showToast(com.baidu.tieba.u.neterror);
                }
            }
            com.baidu.tbadk.core.g.a(this, "signall_click");
        }
    }

    private void d() {
        a e = this.a.e();
        this.a.c().setDuration(Math.max(e.m().size() * 50, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI));
        this.a.c().setSigning(0);
        this.d.a(e);
        this.d.LoadData();
        this.a.f().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        if (this.a.f().getItemViewType(i) == 0 && (bVar = this.a.e().j().get(i / 2)) != null) {
            sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this).a(bVar.b(), "signallforum")));
            com.baidu.tbadk.core.g.a(this, "signall_frs_click");
        }
    }

    private void e() {
        this.c = new AlertDialog.Builder(this).setPositiveButton(com.baidu.tieba.u.signallforum_signnow, new j(this)).create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
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
        if (this.a != null && this.a.f() != null) {
            this.a.f().a();
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
        a(getString(com.baidu.tieba.u.signallforum_back_signing), PendingIntent.getActivity(this, 0, intent, 134217728), 2);
    }
}
