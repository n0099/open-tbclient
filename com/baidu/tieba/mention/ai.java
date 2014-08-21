package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.aj> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ PostActivity b;
    private com.baidu.tbadk.core.util.ae c = null;
    private String d;

    public ai(PostActivity postActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
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
    public com.baidu.tieba.data.aj doInBackground(Object... objArr) {
        com.baidu.tieba.data.aj ajVar = null;
        try {
            this.c = new com.baidu.tbadk.core.util.ae(this.d);
            this.c.a(this.a);
            String h = this.c.h();
            if (this.c.a().b().b()) {
                com.baidu.tieba.data.aj ajVar2 = new com.baidu.tieba.data.aj();
                try {
                    ajVar2.b(h);
                    int size = ajVar2.e().size();
                    for (int i = 0; i < size; i++) {
                        ajVar2.e().get(i).b(this.b);
                        ajVar2.e().get(i).a((ArrayList<com.baidu.tieba.data.g>) null);
                    }
                    return ajVar2;
                } catch (Exception e) {
                    ajVar = ajVar2;
                    e = e;
                    BdLog.e(e.getMessage());
                    return ajVar;
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
    public void onPostExecute(com.baidu.tieba.data.aj ajVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.am amVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (ajVar != null) {
                amVar = this.b.l;
                amVar.a(ajVar);
            } else if (this.c != null) {
                if (this.c.b()) {
                    this.b.showToast(this.c.e());
                    if (this.c.c() == 4 || this.c.c() == 28 || this.c.c() == 29) {
                        this.b.finish();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(com.baidu.tieba.x.error));
                    builder.setMessage(this.c.e());
                    builder.setPositiveButton(this.b.getString(com.baidu.tieba.x.retry), new aj(this));
                    builder.setNegativeButton(this.b.getString(com.baidu.tieba.x.cancel), new ak(this));
                    com.baidu.adp.lib.e.e.a(builder.create(), this.b);
                }
            }
            this.b.e();
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
            this.c.f();
        }
        progressBar = this.b.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
