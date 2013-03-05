package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends AsyncTask {
    final /* synthetic */ PersonInfoActivity a;
    private com.baidu.tieba.c.t b;
    private volatile boolean c;
    private boolean d;

    private bc(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(PersonInfoActivity personInfoActivity, bc bcVar) {
        this(personInfoActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.av doInBackground(Boolean... boolArr) {
        com.baidu.tieba.a.av avVar;
        Exception e;
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        com.baidu.tieba.b.s sVar3;
        com.baidu.tieba.b.s sVar4;
        com.baidu.tieba.b.s sVar5;
        String c;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            sVar = this.a.p;
            if (sVar.b() && booleanValue && (c = com.baidu.tieba.c.k.c()) != null) {
                com.baidu.tieba.a.av avVar2 = new com.baidu.tieba.a.av();
                avVar2.e(c);
                publishProgress(avVar2);
                this.d = false;
            }
            if (!this.c) {
                sVar2 = this.a.p;
                if (sVar2 != null) {
                    sVar3 = this.a.p;
                    if (sVar3.a() != null) {
                        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/u/user/profile");
                        com.baidu.tieba.c.t tVar = this.b;
                        sVar4 = this.a.p;
                        tVar.a("uid", sVar4.a());
                        String i = this.b.i();
                        if (this.b.b()) {
                            avVar = new com.baidu.tieba.a.av();
                            try {
                                JSONObject optJSONObject = new JSONObject(i).optJSONObject("user");
                                avVar.a(optJSONObject);
                                sVar5 = this.a.p;
                                if (sVar5.b()) {
                                    com.baidu.tieba.c.k.g(optJSONObject.toString());
                                    return avVar;
                                }
                                return avVar;
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
                                return avVar;
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            avVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(com.baidu.tieba.a.av... avVarArr) {
        ProgressBar progressBar;
        com.baidu.tieba.b.s sVar;
        super.onProgressUpdate(avVarArr);
        com.baidu.tieba.a.av avVar = avVarArr[0];
        progressBar = this.a.t;
        progressBar.setVisibility(8);
        if (avVar != null) {
            sVar = this.a.p;
            sVar.a(avVar);
            this.a.j();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.av avVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        super.onPostExecute(avVar);
        this.a.s = null;
        progressBar = this.a.t;
        progressBar.setVisibility(8);
        if (avVar != null) {
            sVar = this.a.p;
            sVar.a(avVar);
            sVar2 = this.a.p;
            sVar2.e().d(avVar.d());
            this.a.j();
            this.a.m();
        } else if (this.b != null && this.d) {
            this.a.b(this.b.f());
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        ProgressBar progressBar;
        sVar = this.a.p;
        if (sVar != null) {
            sVar2 = this.a.p;
            if (sVar2.d() == null) {
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
