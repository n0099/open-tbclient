package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.an;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<Object, Integer, an> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f1945a;
    final /* synthetic */ PostActivity b;
    private am c = null;
    private String d;

    public aa(PostActivity postActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = postActivity;
        this.d = null;
        this.f1945a = null;
        this.d = str;
        this.f1945a = arrayList;
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
    public an a(Object... objArr) {
        an anVar = null;
        try {
            this.c = new am(this.d);
            this.c.a(this.f1945a);
            String l = this.c.l();
            if (this.c.c()) {
                an anVar2 = new an();
                try {
                    anVar2.b(l);
                    int size = anVar2.e().size();
                    for (int i = 0; i < size; i++) {
                        anVar2.e().get(i).b(this.b);
                        anVar2.e().get(i).a((ArrayList<com.baidu.tieba.data.j>) null);
                    }
                    return anVar2;
                } catch (Exception e) {
                    anVar = anVar2;
                    e = e;
                    bd.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return anVar;
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
    public void a(an anVar) {
        ProgressBar progressBar;
        bv bvVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (anVar != null) {
                bvVar = this.b.l;
                bvVar.a(anVar);
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
                    builder.setPositiveButton(this.b.getString(R.string.retry), new ab(this));
                    builder.setNegativeButton(this.b.getString(R.string.cancel), new ac(this));
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
