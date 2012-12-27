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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.q doInBackground(String... strArr) {
        this.b = new com.baidu.tieba.c.t();
        this.b.a("http://c.tieba.baidu.com/c/u/follow/list");
        String i = this.b.i();
        if (this.b.b()) {
            com.baidu.tieba.a.q qVar = new com.baidu.tieba.a.q();
            qVar.a(i);
            return qVar;
        }
        return null;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.h = null;
        progressBar = this.a.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.q qVar) {
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
        this.a.h = null;
        progressBar = this.a.l;
        progressBar.setVisibility(8);
        if (this.b.b()) {
            aVar = this.a.i;
            aVar.a(qVar);
            kVar = this.a.j;
            if (kVar == null) {
                return;
            }
            editText = this.a.b;
            if (editText.getText().toString().length() == 0) {
                kVar3 = this.a.j;
                kVar3.a(qVar.a());
                kVar4 = this.a.j;
                kVar4.notifyDataSetInvalidated();
                listView = this.a.e;
                listView.setSelection(0);
            } else {
                aVar2 = this.a.i;
                if (aVar2.b() != null) {
                    aVar3 = this.a.i;
                    aVar3.b().a(qVar.b());
                    kVar2 = this.a.j;
                    kVar2.notifyDataSetInvalidated();
                }
            }
        }
        super.onPostExecute(qVar);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.l;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }
}
