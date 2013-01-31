package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends AsyncTask {
    final /* synthetic */ PersonInfoActivity a;
    private com.baidu.tieba.c.t b;

    private bb(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bb(PersonInfoActivity personInfoActivity, bb bbVar) {
        this(personInfoActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        try {
            int intValue = numArr[0].intValue();
            rVar = this.a.p;
            if (rVar != null) {
                rVar2 = this.a.p;
                if (rVar2.d() != null) {
                    this.b = new com.baidu.tieba.c.t();
                    if (intValue == 0) {
                        this.b.a("http://c.tieba.baidu.com/c/c/user/follow");
                    } else {
                        this.b.a("http://c.tieba.baidu.com/c/c/user/unfollow");
                    }
                    com.baidu.tieba.c.t tVar = this.b;
                    rVar3 = this.a.p;
                    tVar.a("portrait", rVar3.d().d());
                    this.b.d(true);
                    this.b.i();
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        super.onPostExecute(str);
        this.a.V = null;
        progressBar = this.a.u;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.b()) {
                rVar = this.a.p;
                if (rVar.d() != null) {
                    rVar2 = this.a.p;
                    if (rVar2.d().m() == 1) {
                        rVar4 = this.a.p;
                        rVar4.d().b(0);
                    } else {
                        rVar3 = this.a.p;
                        rVar3.d().b(1);
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
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        ProgressBar progressBar;
        rVar = this.a.p;
        if (rVar != null) {
            rVar2 = this.a.p;
            if (rVar2.d() != null) {
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
        this.a.V = null;
        super.cancel(true);
    }
}
