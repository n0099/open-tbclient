package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends AsyncTask {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.c.t b;

    private g(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(EditBarActivity editBarActivity, g gVar) {
        this(editBarActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.h;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.b doInBackground(Object... objArr) {
        com.baidu.tieba.b.b bVar;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/forum/like");
            str = this.a.o;
            if (str != null) {
                com.baidu.tieba.c.t tVar = this.b;
                str2 = this.a.o;
                tVar.a("uid", str2);
            }
            String i = this.b.i();
            if (!this.b.b()) {
                return null;
            }
            bVar = new com.baidu.tieba.b.b();
            try {
                bVar.a(i);
                return bVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
                return bVar;
            }
        } catch (Exception e3) {
            bVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.b bVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.b bVar2;
        i iVar;
        i iVar2;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.i = null;
        if (this.b != null) {
            if (this.b.b() && bVar != null) {
                bVar2 = this.a.c;
                bVar2.a(bVar.a());
                iVar = this.a.g;
                if (iVar == null) {
                    return;
                }
                this.a.l();
                iVar2 = this.a.g;
                iVar2.notifyDataSetChanged();
                return;
            }
            this.a.b(this.b.f());
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.i = null;
        super.cancel(true);
    }
}
