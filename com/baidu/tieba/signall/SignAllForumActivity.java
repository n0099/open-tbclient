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
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SignAllForumActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.ListView.d {
    private y a;
    private c b;
    private AlertDialog c;
    private r d;
    private boolean e;
    private boolean f;
    private e g = new h(this);
    private s h = new i(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SignAllForumActivity signAllForumActivity, String str) {
        if (signAllForumActivity.e) {
            a g = signAllForumActivity.a.g();
            Intent intent = new Intent(signAllForumActivity, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(signAllForumActivity, 0, intent, 134217728);
            str = signAllForumActivity.getString(com.baidu.tieba.a.k.signallforum_back_finish, new Object[]{0, Integer.valueOf(g.m().size())});
            signAllForumActivity.a(str, activity, 16);
            if (signAllForumActivity.f) {
                return;
            }
        }
        signAllForumActivity.showToast(str);
        signAllForumActivity.a.e().a();
        a g2 = signAllForumActivity.a.g();
        ArrayList<b> m = g2.m();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            b bVar = m.get(i);
            bVar.b(true);
            bVar.c(false);
            bVar.a(false);
        }
        int size2 = g2.j().size();
        int size3 = g2.l().size();
        signAllForumActivity.a.i().setText(signAllForumActivity.getString(com.baidu.tieba.a.k.signallforum_res, new Object[]{Integer.valueOf(size3), Integer.valueOf(size2 - size3)}));
        signAllForumActivity.a.h().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, int i) {
        Notification notification = new Notification(com.baidu.tieba.a.g.icon, str, System.currentTimeMillis());
        String string = getString(com.baidu.tieba.a.k.app_name);
        notification.icon = com.baidu.tieba.a.g.icon;
        notification.setLatestEventInfo(this, string, str, pendingIntent);
        notification.flags = i;
        ((NotificationManager) getSystemService("notification")).notify(com.baidu.tieba.a.g.singnallforum_progress, notification);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new y(this);
        this.a.a((com.baidu.adp.widget.ListView.d) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        this.c = new AlertDialog.Builder(this).setPositiveButton(com.baidu.tieba.a.k.signallforum_signnow, new j(this)).create();
        this.b = new c();
        this.b.a(this.g);
        this.d = r.a();
        this.d.a(this.h);
        if (this.d.a) {
            this.g.a(this.d.b());
            this.a.e().setSigning(90);
        } else {
            this.a.a();
        }
        ((NotificationManager) getSystemService("notification")).cancel(com.baidu.tieba.a.g.singnallforum_progress);
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tbadk.core.g.a(this, "signall_noyify_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.baidu.tieba.r.c().h() > 0 && this.a != null && this.a.g() != null && this.a.g().j() != null) {
            a g = this.a.g();
            com.baidu.tieba.r c = com.baidu.tieba.r.c();
            ArrayList<b> m = g.m();
            ArrayList<b> l = g.l();
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
        this.a.h().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.h().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(com.baidu.tieba.a.k.neterror);
            this.a.d();
            return;
        }
        this.b.LoadData();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        a g = this.a.g();
        if (view == this.a.f()) {
            if (this.a.e().getCurrentStatus() == 2) {
                showToast(com.baidu.tieba.a.k.signallforum_finished);
                return;
            }
            if (g.g() != 0) {
                this.c.setMessage(g.h());
                if (!this.c.isShowing()) {
                    this.c.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    a g2 = this.a.g();
                    this.a.e().setDuration(Math.max(g2.m().size() * 50, 2000));
                    this.a.e().setSigning(0);
                    this.d.a(g2);
                    this.d.LoadData();
                    this.a.h().notifyDataSetChanged();
                } else {
                    showToast(com.baidu.tieba.a.k.neterror);
                }
            }
            com.baidu.tbadk.core.g.a(this, "signall_click");
        }
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        if (this.a.h().getItemViewType(i) == 0 && (bVar = this.a.g().j().get(i / 2)) != null) {
            sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this).a(bVar.b(), "signallforum")));
            com.baidu.tbadk.core.g.a(this, "signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.d != null && this.d.a) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f = true;
        if (this.b != null) {
            this.b.cancelLoadData();
            this.b = null;
        }
        if (this.a != null && this.a.h() != null) {
            this.a.h().a();
        }
        if (this.d != null && this.d.a) {
            a();
        } else if (this.b != null) {
            this.b.cancelLoadData();
            this.b = null;
        }
    }

    private void a() {
        this.e = true;
        Intent intent = new Intent(this, SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getString(com.baidu.tieba.a.k.signallforum_back_signing), PendingIntent.getActivity(this, 0, intent, 134217728), 2);
    }
}
