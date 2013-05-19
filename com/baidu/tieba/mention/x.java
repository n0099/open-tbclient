package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.baidu.tieba.a.al;
import com.baidu.tieba.a.aq;
import com.baidu.tieba.c.bd;
import com.baidu.tieba.d.ae;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.lib.a.a {
    ArrayList a;
    final /* synthetic */ PostActivity b;
    private com.baidu.tieba.d.t c = null;
    private String d;

    public x(PostActivity postActivity, String str, ArrayList arrayList) {
        this.b = postActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        progressBar = this.b.h;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public al a(Object... objArr) {
        al alVar = null;
        try {
            this.c = new com.baidu.tieba.d.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (this.c.b()) {
                al alVar2 = new al();
                try {
                    alVar2.b(i);
                    int size = alVar2.d().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((aq) alVar2.d().get(i2)).e(this.b);
                        ((aq) alVar2.d().get(i2)).a((ArrayList) null);
                    }
                    return alVar2;
                } catch (Exception e) {
                    alVar = alVar2;
                    e = e;
                    ae.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return alVar;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(al alVar) {
        ProgressBar progressBar;
        bd bdVar;
        try {
            progressBar = this.b.h;
            progressBar.setVisibility(8);
            if (alVar != null) {
                bdVar = this.b.n;
                bdVar.a(alVar);
            } else if (this.c != null) {
                if (this.c.c()) {
                    this.b.a(this.c.f());
                    if (this.c.d() == 4 || this.c.d() == 28 || this.c.d() == 29) {
                        this.b.finish();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(R.string.error));
                    builder.setMessage(this.c.f());
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
    @Override // com.baidu.adp.lib.a.a
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
        }
        progressBar = this.b.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
