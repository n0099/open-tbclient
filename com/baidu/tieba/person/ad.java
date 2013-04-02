package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends AsyncTask {
    final /* synthetic */ EditMarkActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c = null;
    private int d;
    private com.baidu.tieba.a.av e;

    public ad(EditMarkActivity editMarkActivity, int i) {
        this.a = editMarkActivity;
        this.d = 0;
        this.e = null;
        this.d = i;
        this.e = new com.baidu.tieba.a.av();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        com.baidu.tieba.home.ab abVar;
        com.baidu.tieba.home.ab abVar2;
        ProgressBar progressBar;
        if (this.d == 0) {
            progressBar = this.a.n;
            progressBar.setVisibility(0);
        }
        abVar = this.a.c;
        abVar.b(true);
        abVar2 = this.a.c;
        abVar2.notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.j doInBackground(Boolean... boolArr) {
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/post/threadstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.y());
        this.b.a("offset", String.valueOf(this.d));
        this.b.a("rn", String.valueOf(20));
        this.c = this.b.i();
        this.e.a(this.c);
        com.baidu.tieba.b.j jVar = new com.baidu.tieba.b.j();
        if (this.b.b() || this.e.a() == 0) {
            jVar.a(this.c);
            if (this.d == 0) {
                com.baidu.tieba.c.k.h(this.c);
            }
        } else {
            this.c = com.baidu.tieba.c.k.c();
            jVar.a(this.c);
        }
        return jVar;
    }

    public void a() {
        ProgressBar progressBar;
        com.baidu.tieba.home.ab abVar;
        com.baidu.tieba.home.ab abVar2;
        super.cancel(true);
        this.b.g();
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.l = null;
        abVar = this.a.c;
        abVar.b(false);
        abVar2 = this.a.c;
        abVar2.notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.j jVar) {
        ProgressBar progressBar;
        com.baidu.tieba.home.ab abVar;
        com.baidu.tieba.home.ab abVar2;
        com.baidu.tieba.b.j jVar2;
        com.baidu.tieba.home.ab abVar3;
        com.baidu.tieba.b.j jVar3;
        com.baidu.tieba.home.ab abVar4;
        com.baidu.tieba.home.ab abVar5;
        com.baidu.tieba.b.j jVar4;
        Button button;
        Button button2;
        com.baidu.tieba.home.ab abVar6;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.l = null;
        if (jVar != null) {
            if (jVar.c() == 0) {
                this.a.b(this.a.getString(R.string.no_more_mark));
            }
            if (jVar.c() < 20) {
                abVar6 = this.a.c;
                abVar6.a(false);
            }
            jVar2 = this.a.d;
            jVar2.b(jVar.b());
            abVar3 = this.a.c;
            jVar3 = this.a.d;
            abVar3.a(jVar3.b());
            abVar4 = this.a.c;
            abVar4.c(true);
            abVar5 = this.a.c;
            abVar5.b();
            jVar4 = this.a.d;
            if (jVar4.c() > 0) {
                button2 = this.a.g;
                button2.setVisibility(0);
            } else {
                button = this.a.g;
                button.setVisibility(4);
            }
        }
        if (this.b.b()) {
            this.a.b(this.e.b());
        } else {
            this.a.b(this.b.f());
        }
        abVar = this.a.c;
        abVar.b(false);
        abVar2 = this.a.c;
        abVar2.notifyDataSetChanged();
    }
}
