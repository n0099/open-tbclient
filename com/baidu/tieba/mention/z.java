package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.bo;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<Object, Integer, ao> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ PostActivity b;
    private at c = null;
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
    public void b() {
        ProgressBar progressBar;
        progressBar = this.b.f;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public ao a(Object... objArr) {
        ao aoVar = null;
        try {
            this.c = new at(this.d);
            this.c.a(this.a);
            String l = this.c.l();
            if (this.c.c()) {
                ao aoVar2 = new ao();
                try {
                    aoVar2.b(l);
                    int size = aoVar2.e().size();
                    for (int i = 0; i < size; i++) {
                        aoVar2.e().get(i).b(this.b);
                        aoVar2.e().get(i).a((ArrayList<com.baidu.tieba.data.j>) null);
                    }
                    return aoVar2;
                } catch (Exception e) {
                    aoVar = aoVar2;
                    e = e;
                    bo.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return aoVar;
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
    public void a(ao aoVar) {
        ProgressBar progressBar;
        bv bvVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (aoVar != null) {
                bvVar = this.b.l;
                bvVar.a(aoVar);
            } else if (this.c != null) {
                if (this.c.d()) {
                    this.b.showToast(this.c.i());
                    if (this.c.e() == 4 || this.c.e() == 28 || this.c.e() == 29) {
                        this.b.finish();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(R.string.error));
                    builder.setMessage(this.c.i());
                    builder.setPositiveButton(this.b.getString(R.string.retry), new aa(this));
                    builder.setNegativeButton(this.b.getString(R.string.cancel), new ab(this));
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
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.j();
        }
        progressBar = this.b.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
