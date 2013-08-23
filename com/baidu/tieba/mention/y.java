package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bk;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1347a;
    final /* synthetic */ PostActivity b;
    private com.baidu.tieba.util.v c = null;
    private String d;

    public y(PostActivity postActivity, String str, ArrayList arrayList) {
        this.b = postActivity;
        this.d = null;
        this.f1347a = null;
        this.d = str;
        this.f1347a = arrayList;
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
            this.c = new com.baidu.tieba.util.v(this.d);
            this.c.a(this.f1347a);
            String j = this.c.j();
            if (this.c.c()) {
                ao aoVar2 = new ao();
                try {
                    aoVar2.b(j);
                    int size = aoVar2.d().size();
                    for (int i = 0; i < size; i++) {
                        ((as) aoVar2.d().get(i)).c(this.b);
                        ((as) aoVar2.d().get(i)).a((ArrayList) null);
                    }
                    return aoVar2;
                } catch (Exception e) {
                    aoVar = aoVar2;
                    e = e;
                    aq.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
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
        bk bkVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (aoVar != null) {
                bkVar = this.b.n;
                bkVar.a(aoVar);
            } else if (this.c != null) {
                if (this.c.d()) {
                    this.b.a(this.c.g());
                    if (this.c.e() == 4 || this.c.e() == 28 || this.c.e() == 29) {
                        this.b.finish();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(R.string.error));
                    builder.setMessage(this.c.g());
                    builder.setPositiveButton(this.b.getString(R.string.retry), new z(this));
                    builder.setNegativeButton(this.b.getString(R.string.cancel), new aa(this));
                    builder.create().show();
                }
            }
            this.b.k();
        } catch (Exception e) {
        }
        this.b.m = null;
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
            this.c.h();
        }
        progressBar = this.b.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
