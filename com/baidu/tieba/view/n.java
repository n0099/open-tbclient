package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends AsyncTask {
    final /* synthetic */ l a;
    private volatile com.baidu.tieba.c.t b;
    private volatile boolean c;
    private volatile int d;
    private volatile String e;

    private n(l lVar) {
        this.a = lVar;
        this.b = null;
        this.c = false;
        this.d = 0;
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(l lVar, n nVar) {
        this(lVar);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.i;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/like");
            com.baidu.tieba.c.t tVar = this.b;
            str = this.a.q;
            tVar.a("kw", str);
            com.baidu.tieba.c.t tVar2 = this.b;
            str2 = this.a.r;
            tVar2.a("fid", str2);
            this.b.d(true);
            String i = this.b.i();
            if (this.b.c()) {
                if (this.b.b()) {
                    a(i);
                    return true;
                } else if (this.b.d() == 22) {
                    a(i);
                    this.c = true;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return false;
    }

    private void a(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("info");
            this.d = optJSONObject.optInt("level_id");
            this.e = optJSONObject.optString("level_name");
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "getLevel", e.getMessage());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        ProgressBar progressBar;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        progressBar = this.a.i;
        progressBar.setVisibility(8);
        this.a.t = null;
        if (this.c) {
            this.a.a(1, this.e, this.d);
            activity4 = this.a.o;
            com.baidu.tieba.c.ai.a((Context) activity4, this.b.f());
        } else if (!bool.booleanValue()) {
            activity = this.a.o;
            com.baidu.tieba.c.ai.a((Context) activity, this.b.f());
        } else {
            this.a.a(1, this.e, this.d);
            activity2 = this.a.o;
            activity3 = this.a.o;
            com.baidu.tieba.c.ai.a((Context) activity2, activity3.getString(R.string.like_success));
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        progressBar = this.a.i;
        progressBar.setVisibility(8);
        this.a.t = null;
        super.cancel(true);
    }
}
