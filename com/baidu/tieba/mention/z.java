package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.model.al;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<Object, Integer, ai> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ PostActivity b;
    private aq c = null;
    private String d;

    public z(PostActivity postActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
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
    public ai doInBackground(Object... objArr) {
        ai aiVar = null;
        try {
            this.c = new aq(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (this.c.a().b().b()) {
                ai aiVar2 = new ai();
                try {
                    aiVar2.b(i);
                    int size = aiVar2.d().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        aiVar2.d().get(i2).b(this.b);
                        aiVar2.d().get(i2).a((ArrayList<com.baidu.tieba.data.g>) null);
                    }
                    return aiVar2;
                } catch (Exception e) {
                    aiVar = aiVar2;
                    e = e;
                    BdLog.e(e.getMessage());
                    return aiVar;
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
    public void onPostExecute(ai aiVar) {
        ProgressBar progressBar;
        al alVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (aiVar != null) {
                alVar = this.b.l;
                alVar.a(aiVar);
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
                    builder.setPositiveButton(this.b.getString(com.baidu.tieba.y.retry), new aa(this));
                    builder.setNegativeButton(this.b.getString(com.baidu.tieba.y.cancel), new ab(this));
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
