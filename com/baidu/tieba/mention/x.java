package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.as;
import com.baidu.tieba.data.aw;
import com.baidu.tieba.model.bl;
import com.baidu.tieba.util.aj;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1314a;
    final /* synthetic */ PostActivity b;
    private com.baidu.tieba.util.u c = null;
    private String d;

    public x(PostActivity postActivity, String str, ArrayList arrayList) {
        this.b = postActivity;
        this.d = null;
        this.f1314a = null;
        this.d = str;
        this.f1314a = arrayList;
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
    public as a(Object... objArr) {
        as asVar = null;
        try {
            this.c = new com.baidu.tieba.util.u(this.d);
            this.c.a(this.f1314a);
            String k = this.c.k();
            if (this.c.d()) {
                as asVar2 = new as();
                try {
                    asVar2.b(k);
                    int size = asVar2.c().size();
                    for (int i = 0; i < size; i++) {
                        ((aw) asVar2.c().get(i)).c(this.b);
                        ((aw) asVar2.c().get(i)).a((ArrayList) null);
                    }
                    return asVar2;
                } catch (Exception e) {
                    asVar = asVar2;
                    e = e;
                    aj.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return asVar;
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
    public void a(as asVar) {
        ProgressBar progressBar;
        bl blVar;
        try {
            progressBar = this.b.f;
            progressBar.setVisibility(8);
            if (asVar != null) {
                blVar = this.b.n;
                blVar.a(asVar);
            } else if (this.c != null) {
                if (this.c.e()) {
                    this.b.a(this.c.h());
                    if (this.c.f() == 4 || this.c.f() == 28 || this.c.f() == 29) {
                        this.b.finish();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(R.string.error));
                    builder.setMessage(this.c.h());
                    builder.setPositiveButton(this.b.getString(R.string.retry), new y(this));
                    builder.setNegativeButton(this.b.getString(R.string.cancel), new z(this));
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
            this.c.i();
        }
        progressBar = this.b.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
