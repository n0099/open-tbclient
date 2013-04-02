package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends AsyncTask {
    final /* synthetic */ PersonInfoActivity a;
    private com.baidu.tieba.c.t b;

    private bg(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bg(PersonInfoActivity personInfoActivity, bg bgVar) {
        this(personInfoActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        try {
            int intValue = numArr[0].intValue();
            tVar = this.a.p;
            if (tVar != null) {
                tVar2 = this.a.p;
                if (tVar2.c() != null) {
                    this.b = new com.baidu.tieba.c.t();
                    if (intValue == 0) {
                        this.b.a("http://c.tieba.baidu.com/c/c/user/follow");
                    } else {
                        this.b.a("http://c.tieba.baidu.com/c/c/user/unfollow");
                    }
                    com.baidu.tieba.c.t tVar4 = this.b;
                    tVar3 = this.a.p;
                    tVar4.a("portrait", tVar3.c().d());
                    this.b.d(true);
                    this.b.i();
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        com.baidu.tieba.b.t tVar4;
        super.onPostExecute(str);
        this.a.X = null;
        progressBar = this.a.u;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.b()) {
                tVar = this.a.p;
                if (tVar.c() != null) {
                    tVar2 = this.a.p;
                    if (tVar2.c().m() == 1) {
                        tVar4 = this.a.p;
                        tVar4.c().c(0);
                    } else {
                        tVar3 = this.a.p;
                        tVar3.c().c(1);
                    }
                }
                this.a.l();
                this.a.b(this.a.getString(R.string.success));
                return;
            }
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
            if (tVar2.c() != null) {
                progressBar = this.a.u;
                progressBar.setVisibility(0);
            }
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.u;
        progressBar.setVisibility(8);
        this.a.X = null;
        super.cancel(true);
    }
}
