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
    public com.baidu.tieba.a.ax doInBackground(Boolean... boolArr) {
        com.baidu.tieba.a.ax axVar;
        Exception e;
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        com.baidu.tieba.b.r rVar5;
        String c;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            rVar = this.a.p;
            if (rVar.b() && booleanValue && (c = com.baidu.tieba.c.k.c()) != null) {
                com.baidu.tieba.a.ax axVar2 = new com.baidu.tieba.a.ax();
                axVar2.d(c);
                publishProgress(axVar2);
                this.d = false;
            }
            if (!this.c) {
                rVar2 = this.a.p;
                if (rVar2 != null) {
                    rVar3 = this.a.p;
                    if (rVar3.a() != null) {
                        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/u/user/profile");
                        com.baidu.tieba.c.t tVar = this.b;
                        rVar4 = this.a.p;
                        tVar.a("uid", rVar4.a());
                        String i = this.b.i();
                        if (this.b.b()) {
                            axVar = new com.baidu.tieba.a.ax();
                            try {
                                JSONObject optJSONObject = new JSONObject(i).optJSONObject("user");
                                axVar.a(optJSONObject);
                                rVar5 = this.a.p;
                                if (rVar5.b()) {
                                    com.baidu.tieba.c.k.g(optJSONObject.toString());
                                    return axVar;
                                }
                                return axVar;
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
                                return axVar;
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            axVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(com.baidu.tieba.a.ax... axVarArr) {
        ProgressBar progressBar;
        com.baidu.tieba.b.r rVar;
        super.onProgressUpdate(axVarArr);
        com.baidu.tieba.a.ax axVar = axVarArr[0];
        progressBar = this.a.t;
        progressBar.setVisibility(8);
        if (axVar != null) {
            rVar = this.a.p;
            rVar.a(axVar);
            this.a.j();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.ax axVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        super.onPostExecute(axVar);
        this.a.s = null;
        progressBar = this.a.t;
        progressBar.setVisibility(8);
        if (axVar != null) {
            rVar = this.a.p;
            rVar.a(axVar);
            rVar2 = this.a.p;
            rVar2.e().d(axVar.d());
            this.a.j();
            this.a.m();
        } else if (this.b != null && this.d) {
            this.a.b(this.b.f());
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        ProgressBar progressBar;
        rVar = this.a.p;
        if (rVar != null) {
            rVar2 = this.a.p;
            if (rVar2.d() == null) {
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
