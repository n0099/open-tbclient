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
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        com.baidu.tieba.b.s sVar3;
        try {
            int intValue = numArr[0].intValue();
            sVar = this.a.p;
            if (sVar != null) {
                sVar2 = this.a.p;
                if (sVar2.d() != null) {
                    this.b = new com.baidu.tieba.c.t();
                    if (intValue == 0) {
                        this.b.a("http://c.tieba.baidu.com/c/c/user/follow");
                    } else {
                        this.b.a("http://c.tieba.baidu.com/c/c/user/unfollow");
                    }
                    com.baidu.tieba.c.t tVar = this.b;
                    sVar3 = this.a.p;
                    tVar.a("portrait", sVar3.d().d());
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
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        com.baidu.tieba.b.s sVar3;
        com.baidu.tieba.b.s sVar4;
        super.onPostExecute(str);
        this.a.Y = null;
        progressBar = this.a.u;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.b()) {
                sVar = this.a.p;
                if (sVar.d() != null) {
                    sVar2 = this.a.p;
                    if (sVar2.d().m() == 1) {
                        sVar4 = this.a.p;
                        sVar4.d().c(0);
                    } else {
                        sVar3 = this.a.p;
                        sVar3.d().c(1);
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
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        ProgressBar progressBar;
        sVar = this.a.p;
        if (sVar != null) {
            sVar2 = this.a.p;
            if (sVar2.d() != null) {
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
        this.a.Y = null;
        super.cancel(true);
    }
}
