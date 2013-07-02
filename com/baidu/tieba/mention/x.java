package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.data.an;
import com.baidu.tieba.model.bg;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask {
    ArrayList a;
    final /* synthetic */ PostActivity b;
    private com.baidu.tieba.util.r c = null;
    private String d;

    public x(PostActivity postActivity, String str, ArrayList arrayList) {
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
    public aj a(Object... objArr) {
        aj ajVar = null;
        try {
            this.c = new com.baidu.tieba.util.r(this.d);
            this.c.a(this.a);
            String j = this.c.j();
            if (this.c.c()) {
                aj ajVar2 = new aj();
                try {
                    ajVar2.b(j);
                    int size = ajVar2.d().size();
                    for (int i = 0; i < size; i++) {
                        ((an) ajVar2.d().get(i)).d(this.b);
                        ((an) ajVar2.d().get(i)).a((ArrayList) null);
                    }
                    return ajVar2;
                } catch (Exception e) {
                    ajVar = ajVar2;
                    e = e;
                    com.baidu.tieba.util.z.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
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
    public void a(aj ajVar) {
        ProgressBar progressBar;
        bg bgVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (ajVar != null) {
                bgVar = this.b.n;
                bgVar.a(ajVar);
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
                    builder.setPositiveButton(this.b.getString(R.string.retry), new y(this));
                    builder.setNegativeButton(this.b.getString(R.string.cancel), new z(this));
                    builder.create().show();
                }
            }
            this.b.m();
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
