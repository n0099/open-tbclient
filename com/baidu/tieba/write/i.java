package com.baidu.tieba.write;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends AsyncTask {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.c.t b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(AtListActivity atListActivity, i iVar) {
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
        this.a.h = null;
        this.c = null;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.au doInBackground(String... strArr) {
        com.baidu.tieba.b.a aVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.c.t();
        if (this.c != null && this.c.length() > 0) {
            this.b.a("http://c.tieba.baidu.com/c/u/follow/sug");
            this.b.a("uid", TiebaApplication.w());
            this.b.a("q", this.c);
            String i = this.b.i();
            if (this.b.b()) {
                com.baidu.tieba.a.au auVar = new com.baidu.tieba.a.au();
                aVar = this.a.j;
                com.baidu.tieba.a.r a = aVar.a();
                if (a != null) {
                    auVar.a(i, a.b());
                    return auVar;
                }
                auVar.a(i, (HashMap) null);
                return auVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.au auVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.b.a aVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        if (this.b.b() && this.c != null) {
            editText = this.a.c;
            if (editText.getText().toString().equals(this.c)) {
                aVar = this.a.j;
                aVar.a(auVar);
                kVar = this.a.k;
                kVar.a(auVar.a());
                kVar2 = this.a.k;
                kVar2.notifyDataSetInvalidated();
                listView = this.a.f;
                listView.setSelection(0);
            }
        }
        super.onPostExecute(auVar);
    }
}
