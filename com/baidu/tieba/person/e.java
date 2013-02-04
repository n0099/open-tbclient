package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends AsyncTask {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.c.t b;

    private e(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(EditBarActivity editBarActivity, e eVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.b doInBackground(Object... objArr) {
        com.baidu.tieba.b.b bVar;
        Exception e;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/forum/like");
            String i = this.b.i();
            if (this.b.b()) {
                bVar = new com.baidu.tieba.b.b();
                try {
                    bVar.a(i);
                    return bVar;
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                    return bVar;
                }
            }
            return null;
        } catch (Exception e3) {
            bVar = null;
            e = e3;
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.h = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.b bVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.b bVar2;
        g gVar;
        g gVar2;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.h = null;
        if (this.b != null) {
            if (!this.b.b() || bVar == null) {
                this.a.b(this.b.f());
                return;
            }
            bVar2 = this.a.b;
            bVar2.a(bVar.a());
            gVar = this.a.f;
            if (gVar != null) {
                this.a.j();
                gVar2 = this.a.f;
                gVar2.notifyDataSetChanged();
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
    }
}
