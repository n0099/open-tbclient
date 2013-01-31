package com.baidu.tieba.write;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends AsyncTask {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.c.t b;

    private j(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(AtListActivity atListActivity, j jVar) {
        this(atListActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.m;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.i = null;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.r doInBackground(String... strArr) {
        this.b = new com.baidu.tieba.c.t();
        this.b.a("http://c.tieba.baidu.com/c/u/follow/list");
        String i = this.b.i();
        if (!this.b.b()) {
            return null;
        }
        com.baidu.tieba.a.r rVar = new com.baidu.tieba.a.r();
        rVar.a(i);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.r rVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.a aVar;
        k kVar;
        EditText editText;
        com.baidu.tieba.b.a aVar2;
        com.baidu.tieba.b.a aVar3;
        k kVar2;
        k kVar3;
        k kVar4;
        ListView listView;
        this.a.i = null;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        if (this.b.b()) {
            aVar = this.a.j;
            aVar.a(rVar);
            kVar = this.a.k;
            if (kVar != null) {
                editText = this.a.c;
                if (editText.getText().toString().length() != 0) {
                    aVar2 = this.a.j;
                    if (aVar2.b() != null) {
                        aVar3 = this.a.j;
                        aVar3.b().a(rVar.b());
                        kVar2 = this.a.k;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    kVar3 = this.a.k;
                    kVar3.a(rVar.a());
                    kVar4 = this.a.k;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.a.f;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        }
        super.onPostExecute(rVar);
    }
}
