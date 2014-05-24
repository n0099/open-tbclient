package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.model.am;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.af> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ PostActivity b;
    private al c = null;
    private String d;

    public ac(PostActivity postActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = postActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.b.f;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.af doInBackground(Object... objArr) {
        com.baidu.tieba.data.af afVar = null;
        try {
            this.c = new al(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (this.c.a().b().b()) {
                com.baidu.tieba.data.af afVar2 = new com.baidu.tieba.data.af();
                try {
                    afVar2.b(i);
                    int size = afVar2.e().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        afVar2.e().get(i2).b(this.b);
                        afVar2.e().get(i2).a((ArrayList<com.baidu.tieba.data.f>) null);
                    }
                    return afVar2;
                } catch (Exception e) {
                    afVar = afVar2;
                    e = e;
                    BdLog.e("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return afVar;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.af afVar) {
        ProgressBar progressBar;
        am amVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (afVar != null) {
                amVar = this.b.l;
                amVar.a(afVar);
            } else if (this.c != null) {
                if (this.c.c()) {
                    this.b.showToast(this.c.f());
                    if (this.c.d() == 4 || this.c.d() == 28 || this.c.d() == 29) {
                        this.b.finish();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(com.baidu.tieba.y.error));
                    builder.setMessage(this.c.f());
                    builder.setPositiveButton(this.b.getString(com.baidu.tieba.y.retry), new ad(this));
                    builder.setNegativeButton(this.b.getString(com.baidu.tieba.y.cancel), new ae(this));
                    builder.create().show();
                }
            }
            this.b.d();
        } catch (Exception e) {
        }
        this.b.k = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
        }
        progressBar = this.b.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
