package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.model.am;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ae> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ PostActivity b;
    private ak c = null;
    private String d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tieba.data.ae a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.ae aeVar) {
        ProgressBar progressBar;
        am amVar;
        com.baidu.tieba.data.ae aeVar2 = aeVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (aeVar2 != null) {
                amVar = this.b.l;
                amVar.a(aeVar2);
            } else if (this.c != null) {
                if (this.c.c()) {
                    this.b.showToast(this.c.f());
                    if (this.c.d() == 4 || this.c.d() == 28 || this.c.d() == 29) {
                        this.b.finish();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(com.baidu.tieba.a.k.error));
                    builder.setMessage(this.c.f());
                    builder.setPositiveButton(this.b.getString(com.baidu.tieba.a.k.retry), new ad(this));
                    builder.setNegativeButton(this.b.getString(com.baidu.tieba.a.k.cancel), new ae(this));
                    builder.create().show();
                }
            }
            this.b.b();
        } catch (Exception e) {
        }
        this.b.k = null;
    }

    public ac(PostActivity postActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = postActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        progressBar = this.b.f;
        progressBar.setVisibility(0);
    }

    private com.baidu.tieba.data.ae a() {
        com.baidu.tieba.data.ae aeVar = null;
        try {
            this.c = new ak(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (this.c.a().b().b()) {
                com.baidu.tieba.data.ae aeVar2 = new com.baidu.tieba.data.ae();
                try {
                    aeVar2.b(i);
                    int size = aeVar2.e().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        aeVar2.e().get(i2).b(this.b);
                        aeVar2.e().get(i2).a((ArrayList<com.baidu.tieba.data.f>) null);
                    }
                    return aeVar2;
                } catch (Exception e) {
                    aeVar = aeVar2;
                    e = e;
                    com.baidu.adp.lib.util.f.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return aeVar;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        super.d();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
        }
        progressBar = this.b.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
