package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends AsyncTask {
    final /* synthetic */ PersonInfoActivity a;
    private com.baidu.tieba.c.t b;
    private volatile boolean c;
    private boolean d;

    private ar(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(PersonInfoActivity personInfoActivity, ar arVar) {
        this(personInfoActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.au doInBackground(Boolean... boolArr) {
        com.baidu.tieba.a.au auVar;
        Exception e;
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        com.baidu.tieba.b.p pVar4;
        com.baidu.tieba.b.p pVar5;
        String c;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            pVar = this.a.k;
            if (pVar.b() && booleanValue && (c = com.baidu.tieba.c.k.c()) != null) {
                com.baidu.tieba.a.au auVar2 = new com.baidu.tieba.a.au();
                auVar2.d(c);
                publishProgress(auVar2);
                this.d = false;
            }
            if (!this.c) {
                pVar2 = this.a.k;
                if (pVar2 != null) {
                    pVar3 = this.a.k;
                    if (pVar3.a() != null) {
                        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/u/user/profile");
                        com.baidu.tieba.c.t tVar = this.b;
                        pVar4 = this.a.k;
                        tVar.a("uid", pVar4.a());
                        String i = this.b.i();
                        if (this.b.b()) {
                            auVar = new com.baidu.tieba.a.au();
                            try {
                                JSONObject optJSONObject = new JSONObject(i).optJSONObject("user");
                                auVar.a(optJSONObject);
                                pVar5 = this.a.k;
                                if (pVar5.b()) {
                                    com.baidu.tieba.c.k.g(optJSONObject.toString());
                                    return auVar;
                                }
                                return auVar;
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                                return auVar;
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            auVar = null;
            e = e3;
        }
    }

    public void a() {
        ProgressBar progressBar;
        this.c = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.o;
        progressBar.setVisibility(8);
        this.a.n = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.au auVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        super.onPostExecute(auVar);
        this.a.n = null;
        progressBar = this.a.o;
        progressBar.setVisibility(8);
        if (auVar == null) {
            if (this.b == null || !this.d) {
                return;
            }
            this.a.b(this.b.f());
            return;
        }
        pVar = this.a.k;
        pVar.a(auVar);
        pVar2 = this.a.k;
        pVar2.e().d(auVar.d());
        this.a.h();
        this.a.k();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(com.baidu.tieba.a.au... auVarArr) {
        ProgressBar progressBar;
        com.baidu.tieba.b.p pVar;
        super.onProgressUpdate(auVarArr);
        com.baidu.tieba.a.au auVar = auVarArr[0];
        progressBar = this.a.o;
        progressBar.setVisibility(8);
        if (auVar != null) {
            pVar = this.a.k;
            pVar.a(auVar);
            this.a.h();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        ProgressBar progressBar;
        pVar = this.a.k;
        if (pVar != null) {
            pVar2 = this.a.k;
            if (pVar2.d() == null) {
                progressBar = this.a.o;
                progressBar.setVisibility(0);
            }
        }
    }
}
