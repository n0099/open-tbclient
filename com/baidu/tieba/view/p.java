package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.a.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends AsyncTask {
    final /* synthetic */ l a;
    private volatile com.baidu.tieba.c.t b;
    private volatile boolean c;

    private p(l lVar) {
        this.a = lVar;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(l lVar, p pVar) {
        this(lVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ap doInBackground(Object... objArr) {
        ap apVar;
        Exception e;
        String str;
        String str2;
        String i;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/sign");
            com.baidu.tieba.c.t tVar = this.b;
            str = this.a.p;
            tVar.a("kw", str);
            com.baidu.tieba.c.t tVar2 = this.b;
            str2 = this.a.q;
            tVar2.a("fid", str2);
            this.b.d(true);
            i = this.b.i();
        } catch (Exception e2) {
            apVar = null;
            e = e2;
        }
        if (this.b.c()) {
            if (this.b.b()) {
                apVar = new ap();
                try {
                    apVar.a(i);
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                    return apVar;
                }
            } else if (this.b.d() == 160002) {
                this.c = true;
                apVar = null;
            }
            return apVar;
        }
        apVar = null;
        return apVar;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.r = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(ap apVar) {
        ProgressBar progressBar;
        int i;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        Activity activity6;
        Activity activity7;
        Activity activity8;
        this.a.r = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        if (this.c) {
            this.a.a(1);
        } else if (apVar == null) {
            if (this.b != null) {
                activity8 = this.a.n;
                com.baidu.tieba.c.ag.a((Context) activity8, this.b.f());
            }
        } else {
            this.a.a(1);
            StringBuilder sb = new StringBuilder(100);
            i = this.a.l;
            if (i == 0) {
                activity5 = this.a.n;
                sb.append(activity5.getString(R.string.sign_success));
                sb.append("!\n");
                activity6 = this.a.n;
                sb.append(String.format(activity6.getString(R.string.sign_user), Integer.valueOf(apVar.c())));
                activity7 = this.a.n;
                com.baidu.tieba.c.ag.a((Context) activity7, sb.toString());
                return;
            }
            activity = this.a.n;
            sb.append(activity.getString(R.string.sign_success));
            sb.append(",");
            activity2 = this.a.n;
            sb.append(String.format(activity2.getString(R.string.sign_point), Integer.valueOf(apVar.d())));
            sb.append("!\n");
            activity3 = this.a.n;
            sb.append(String.format(activity3.getString(R.string.sign_user), Integer.valueOf(apVar.c())));
            activity4 = this.a.n;
            com.baidu.tieba.c.ag.a((Context) activity4, sb.toString());
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
    }
}
