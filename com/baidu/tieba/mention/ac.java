package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.am;
import com.baidu.tieba.model.bn;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends BdAsyncTask<Object, Integer, am> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ PostActivity b;
    private ba c = null;
    private String d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ am a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(am amVar) {
        ProgressBar progressBar;
        bn bnVar;
        am amVar2 = amVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (amVar2 != null) {
                bnVar = this.b.l;
                bnVar.a(amVar2);
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
                    builder.setPositiveButton(this.b.getString(R.string.retry), new ad(this));
                    builder.setNegativeButton(this.b.getString(R.string.cancel), new ae(this));
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
    public final void b() {
        ProgressBar progressBar;
        progressBar = this.b.f;
        progressBar.setVisibility(0);
    }

    private am d() {
        am amVar = null;
        try {
            this.c = new ba(this.d);
            this.c.a(this.a);
            String l = this.c.l();
            if (this.c.c()) {
                am amVar2 = new am();
                try {
                    amVar2.b(l);
                    int size = amVar2.e().size();
                    for (int i = 0; i < size; i++) {
                        amVar2.e().get(i).b(this.b);
                        amVar2.e().get(i).a((ArrayList<com.baidu.tieba.data.k>) null);
                    }
                    return amVar2;
                } catch (Exception e) {
                    amVar = amVar2;
                    e = e;
                    com.baidu.adp.lib.util.e.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return amVar;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.j();
        }
        progressBar = this.b.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
