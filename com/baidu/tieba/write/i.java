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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.ar doInBackground(String... strArr) {
        com.baidu.tieba.b.a aVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.c.t();
        if (this.c != null && this.c.length() > 0) {
            this.b.a("http://c.tieba.baidu.com/c/u/follow/sug");
            this.b.a("uid", TiebaApplication.u());
            this.b.a("q", this.c);
            String i = this.b.i();
            if (this.b.b()) {
                com.baidu.tieba.a.ar arVar = new com.baidu.tieba.a.ar();
                aVar = this.a.i;
                com.baidu.tieba.a.q a = aVar.a();
                if (a != null) {
                    arVar.a(i, a.b());
                    return arVar;
                }
                arVar.a(i, (HashMap) null);
                return arVar;
            }
        }
        return null;
    }

    public void a() {
        ProgressBar progressBar;
        this.a.g = null;
        this.c = null;
        progressBar = this.a.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.ar arVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.b.a aVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.a.l;
        progressBar.setVisibility(8);
        if (this.b.b() && this.c != null) {
            editText = this.a.b;
            if (editText.getText().toString().equals(this.c)) {
                aVar = this.a.i;
                aVar.a(arVar);
                kVar = this.a.j;
                kVar.a(arVar.a());
                kVar2 = this.a.j;
                kVar2.notifyDataSetInvalidated();
                listView = this.a.e;
                listView.setSelection(0);
            }
        }
        super.onPostExecute(arVar);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.l;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }
}
