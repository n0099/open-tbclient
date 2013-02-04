package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends AsyncTask {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.c.t b;

    private f(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(EditBarActivity editBarActivity, f fVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(com.baidu.tieba.a.p... pVarArr) {
        com.baidu.tieba.a.p pVar = pVarArr[0];
        if (pVar != null) {
            try {
                if (pVar.b() == null || pVar.c() == null) {
                    return null;
                }
                this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/unfavolike");
                this.b.a("fid", pVar.b());
                this.b.a("kw", pVar.c());
                this.b.a("favo_type", String.valueOf(pVar.i()));
                this.b.d(true);
                this.b.i();
                return null;
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.j = null;
        super.cancel(true);
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
        g gVar;
        g gVar2;
        super.onPostExecute(str);
        this.a.j = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (!this.b.b()) {
                this.a.b(this.b.f());
                return;
            }
            bVar = this.a.b;
            ArrayList a = bVar.a();
            if (a != null) {
                i = this.a.i;
                if (i >= 0) {
                    i2 = this.a.i;
                    if (i2 < a.size()) {
                        i3 = this.a.i;
                        a.remove(i3);
                        gVar = this.a.f;
                        if (gVar != null) {
                            this.a.j();
                            gVar2 = this.a.f;
                            gVar2.notifyDataSetChanged();
                        }
                    }
                }
            }
            if (!TiebaApplication.a().F()) {
                TiebaApplication.a().f(true);
                com.baidu.tieba.c.k.a();
            }
            this.a.b(this.a.getString(R.string.success));
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
    }
}
