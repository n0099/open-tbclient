package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.a.al;
import com.baidu.tieba.a.an;
import com.baidu.tieba.c.af;
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

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.b.h;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public al doInBackground(Object... objArr) {
        al alVar = null;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (this.c.b()) {
                al alVar2 = new al();
                try {
                    alVar2.a(i);
                    int size = alVar2.c().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((an) alVar2.c().get(i2)).c(this.b);
                        ((an) alVar2.c().get(i2)).a((ArrayList) null);
                    }
                    return alVar2;
                } catch (Exception e) {
                    alVar = alVar2;
                    e = e;
                    af.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return alVar;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(al alVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.p pVar;
        try {
            progressBar = this.b.h;
            progressBar.setVisibility(8);
            if (alVar != null) {
                pVar = this.b.n;
                pVar.a(alVar);
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
            this.b.l();
        } catch (Exception e) {
        }
        this.b.m = null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    public void a() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
        }
        progressBar = this.b.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
