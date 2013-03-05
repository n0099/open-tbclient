package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.a.aq;
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

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.h;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public aq doInBackground(Object... objArr) {
        aq aqVar;
        Exception e;
        String str;
        String str2;
        String i;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/sign");
            com.baidu.tieba.c.t tVar = this.b;
            str = this.a.q;
            tVar.a("kw", str);
            com.baidu.tieba.c.t tVar2 = this.b;
            str2 = this.a.r;
            tVar2.a("fid", str2);
            this.b.d(true);
            i = this.b.i();
        } catch (Exception e2) {
            aqVar = null;
            e = e2;
        }
        if (this.b.c()) {
            if (this.b.b()) {
                aqVar = new aq();
                try {
                    aqVar.a(i);
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
                    return aqVar;
                }
            } else if (this.b.d() == 160002) {
                this.c = true;
                aqVar = null;
            }
            return aqVar;
        }
        aqVar = null;
        return aqVar;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.s = null;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(aq aqVar) {
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
        this.a.s = null;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        if (this.c) {
            this.a.b(1);
        } else if (aqVar == null) {
            if (this.b != null) {
                activity8 = this.a.o;
                com.baidu.tieba.c.ai.a((Context) activity8, this.b.f());
            }
        } else {
            this.a.b(1);
            StringBuilder sb = new StringBuilder(100);
            i = this.a.m;
            if (i == 0) {
                activity5 = this.a.o;
                sb.append(activity5.getString(R.string.sign_success));
                sb.append("!\n");
                activity6 = this.a.o;
                sb.append(String.format(activity6.getString(R.string.sign_user), Integer.valueOf(aqVar.c())));
                activity7 = this.a.o;
                com.baidu.tieba.c.ai.a((Context) activity7, sb.toString());
                return;
            }
            activity = this.a.o;
            sb.append(activity.getString(R.string.sign_success));
            sb.append(",");
            activity2 = this.a.o;
            sb.append(String.format(activity2.getString(R.string.sign_point), Integer.valueOf(aqVar.d())));
            sb.append("!\n");
            activity3 = this.a.o;
            sb.append(String.format(activity3.getString(R.string.sign_user), Integer.valueOf(aqVar.c())));
            activity4 = this.a.o;
            com.baidu.tieba.c.ai.a((Context) activity4, sb.toString());
        }
    }
}
