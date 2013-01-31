package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends AsyncTask {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.c.t b;

    private h(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(EditBarActivity editBarActivity, h hVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(com.baidu.tieba.a.q... qVarArr) {
        com.baidu.tieba.a.q qVar = qVarArr[0];
        if (qVar != null) {
            try {
                if (qVar.b() != null && qVar.c() != null) {
                    this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/unfavolike");
                    this.b.a("fid", qVar.b());
                    this.b.a("kw", qVar.c());
                    this.b.a("favo_type", String.valueOf(qVar.i()));
                    this.b.d(true);
                    this.b.i();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.b.b bVar;
        int i;
        int i2;
        int i3;
        i iVar;
        i iVar2;
        super.onPostExecute(str);
        this.a.k = null;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.b()) {
                bVar = this.a.c;
                ArrayList a = bVar.a();
                if (a != null) {
                    i = this.a.j;
                    if (i >= 0) {
                        i2 = this.a.j;
                        if (i2 < a.size()) {
                            i3 = this.a.j;
                            a.remove(i3);
                            iVar = this.a.g;
                            if (iVar != null) {
                                this.a.l();
                                iVar2 = this.a.g;
                                iVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                if (!TiebaApplication.b().J()) {
                    TiebaApplication.b().g(true);
                    com.baidu.tieba.c.k.a();
                }
                this.a.b(this.a.getString(R.string.success));
                return;
            }
            this.a.b(this.b.f());
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.h;
        progressBar.setVisibility(0);
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.k = null;
        super.cancel(true);
    }
}
