package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends AsyncTask {
    final /* synthetic */ PersonInfoActivity a;
    private com.baidu.tieba.c.t b;

    private aq(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aq(PersonInfoActivity personInfoActivity, aq aqVar) {
        this(personInfoActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        try {
            int intValue = numArr[0].intValue();
            pVar = this.a.k;
            if (pVar != null) {
                pVar2 = this.a.k;
                if (pVar2.d() != null) {
                    this.b = new com.baidu.tieba.c.t();
                    if (intValue == 0) {
                        this.b.a("http://c.tieba.baidu.com/c/c/user/follow");
                    } else {
                        this.b.a("http://c.tieba.baidu.com/c/c/user/unfollow");
                    }
                    com.baidu.tieba.c.t tVar = this.b;
                    pVar3 = this.a.k;
                    tVar.a("portrait", pVar3.d().d());
                    this.b.d(true);
                    this.b.i();
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        this.a.G = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        com.baidu.tieba.b.p pVar4;
        super.onPostExecute(str);
        this.a.G = null;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (!this.b.b()) {
                this.a.b(this.b.f());
                return;
            }
            pVar = this.a.k;
            if (pVar.d() != null) {
                pVar2 = this.a.k;
                if (pVar2.d().m() == 1) {
                    pVar4 = this.a.k;
                    pVar4.d().b(0);
                } else {
                    pVar3 = this.a.k;
                    pVar3.d().b(1);
                }
            }
            this.a.j();
            this.a.b(this.a.getString(R.string.success));
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
            if (pVar2.d() != null) {
                progressBar = this.a.p;
                progressBar.setVisibility(0);
            }
        }
    }
}
