package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends AsyncTask {
    final /* synthetic */ PersonInfoActivity a;
    private com.baidu.tieba.c.t b;
    private volatile boolean c;
    private boolean d;

    private bh(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bh(PersonInfoActivity personInfoActivity, bh bhVar) {
        this(personInfoActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.az doInBackground(Boolean... boolArr) {
        com.baidu.tieba.a.az azVar;
        Exception e;
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        com.baidu.tieba.b.t tVar4;
        com.baidu.tieba.b.t tVar5;
        String d;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            tVar = this.a.p;
            if (tVar.b() && booleanValue && (d = com.baidu.tieba.c.k.d()) != null) {
                com.baidu.tieba.a.az azVar2 = new com.baidu.tieba.a.az();
                azVar2.e(d);
                publishProgress(azVar2);
                this.d = false;
            }
            if (!this.c) {
                tVar2 = this.a.p;
                if (tVar2 != null) {
                    tVar3 = this.a.p;
                    if (tVar3.a() != null) {
                        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/u/user/profile");
                        com.baidu.tieba.c.t tVar6 = this.b;
                        tVar4 = this.a.p;
                        tVar6.a("uid", tVar4.a());
                        String i = this.b.i();
                        if (this.b.b()) {
                            azVar = new com.baidu.tieba.a.az();
                            try {
                                JSONObject optJSONObject = new JSONObject(i).optJSONObject("user");
                                azVar.a(optJSONObject);
                                tVar5 = this.a.p;
                                if (tVar5.b()) {
                                    com.baidu.tieba.c.k.g(optJSONObject.toString());
                                    return azVar;
                                }
                                return azVar;
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
                                return azVar;
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            azVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(com.baidu.tieba.a.az... azVarArr) {
        ProgressBar progressBar;
        com.baidu.tieba.b.t tVar;
        super.onProgressUpdate(azVarArr);
        com.baidu.tieba.a.az azVar = azVarArr[0];
        progressBar = this.a.t;
        progressBar.setVisibility(8);
        if (azVar != null) {
            tVar = this.a.p;
            tVar.a(azVar);
            this.a.j();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.az azVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        super.onPostExecute(azVar);
        this.a.s = null;
        progressBar = this.a.t;
        progressBar.setVisibility(8);
        if (azVar != null) {
            tVar = this.a.p;
            tVar.a(azVar);
            tVar2 = this.a.p;
            tVar2.d().d(azVar.d());
            this.a.j();
            this.a.m();
        } else if (this.b != null && this.d) {
            this.a.b(this.b.f());
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        ProgressBar progressBar;
        tVar = this.a.p;
        if (tVar != null) {
            tVar2 = this.a.p;
            if (tVar2.c() == null) {
                progressBar = this.a.t;
                progressBar.setVisibility(0);
            }
        }
    }

    public void a() {
        ProgressBar progressBar;
        this.c = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.t;
        progressBar.setVisibility(8);
        this.a.s = null;
        super.cancel(true);
    }
}
