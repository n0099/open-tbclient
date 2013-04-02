package com.baidu.tieba.person;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends AsyncTask {
    final /* synthetic */ EditMarkActivity a;
    private com.baidu.tieba.c.t b;
    private com.baidu.tieba.a.av c;

    private ae(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(EditMarkActivity editMarkActivity, ae aeVar) {
        this(editMarkActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.a(this.a.getString(R.string.syncing));
        this.c = new com.baidu.tieba.a.av();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(com.baidu.tieba.b.j... jVarArr) {
        int o;
        com.baidu.tieba.b.j jVar = new com.baidu.tieba.b.j();
        try {
            jVar.e();
            this.b = new com.baidu.tieba.c.t();
            this.b.a("http://c.tieba.baidu.com/c/c/post/addstore");
            o = this.a.o();
            if (jVar.c() - 1 <= o) {
                o = jVar.c() - 1;
            }
            while (o >= 0) {
                String a = jVar.a(o, 20);
                this.b.a(new ArrayList());
                this.b.a("data", a);
                this.c.a(this.b.i());
                if (!this.b.b() || this.c.a() != 0) {
                    break;
                }
                o -= 20;
            }
            this.a.c(o);
            if (o >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return false;
        }
    }

    public void a() {
        super.cancel(true);
        this.b.g();
        this.a.d();
        this.a.k = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        com.baidu.tieba.b.j jVar;
        com.baidu.tieba.home.ab abVar;
        com.baidu.tieba.home.ab abVar2;
        this.a.k = null;
        this.a.d();
        if (bool.booleanValue()) {
            jVar = this.a.d;
            jVar.d();
            abVar = this.a.c;
            abVar.b();
            abVar2 = this.a.c;
            abVar2.notifyDataSetChanged();
            this.a.n();
        } else if (!this.b.b()) {
            this.a.j();
        } else {
            this.a.b(this.c.b());
        }
    }
}
