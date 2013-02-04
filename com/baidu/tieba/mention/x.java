package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.a.ak;
import com.baidu.tieba.a.am;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends AsyncTask {
    ArrayList a;
    final /* synthetic */ PostActivity b;
    private com.baidu.tieba.c.t c = null;
    private String d;

    public x(PostActivity postActivity, String str, ArrayList arrayList) {
        this.b = postActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ak doInBackground(Object... objArr) {
        ak akVar = null;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (this.c.b()) {
                ak akVar2 = new ak();
                try {
                    akVar2.a(i);
                    int size = akVar2.c().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((am) akVar2.c().get(i2)).c(this.b);
                        ((am) akVar2.c().get(i2)).a((ArrayList) null);
                    }
                    return akVar2;
                } catch (Exception e) {
                    akVar = akVar2;
                    e = e;
                    ae.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return akVar;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
        }
        progressBar = this.b.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(ak akVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.n nVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (akVar != null) {
                nVar = this.b.k;
                nVar.a(akVar);
            } else if (this.c != null) {
                if (this.c.c()) {
                    this.b.b(this.c.f());
                    if (this.c.d() == 4 || this.c.d() == 28 || this.c.d() == 29) {
                        this.b.finish();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(R.string.error));
                    builder.setMessage(this.c.f());
                    builder.setPositiveButton(this.b.getString(R.string.retry), new y(this));
                    builder.setNegativeButton(this.b.getString(R.string.cancel), new z(this));
                    builder.create().show();
                }
            }
            this.b.j();
        } catch (Exception e) {
        }
        this.b.j = null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.b.f;
        progressBar.setVisibility(0);
    }
}
