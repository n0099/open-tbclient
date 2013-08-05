package com.baidu.tieba.mention;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.as;
import com.baidu.tieba.data.aw;
import com.baidu.tieba.data.bh;
import com.baidu.tieba.model.by;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1307a;
    final /* synthetic */ h b;
    private com.baidu.tieba.util.u c = null;
    private String d;
    private String e;
    private int f;

    public q(h hVar, String str, ArrayList arrayList, int i, String str2) {
        this.b = hVar;
        this.d = null;
        this.e = null;
        this.f1307a = null;
        this.d = str;
        this.f1307a = arrayList;
        this.f = i;
        this.e = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.b.l;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.util.u(this.d);
            this.c.a(this.f1307a);
            return this.c.k();
        } catch (Exception e) {
            aj.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        com.baidu.tieba.g gVar3;
        com.baidu.tieba.g gVar4;
        try {
            progressBar = this.b.l;
            progressBar.setVisibility(8);
            if (this.c != null && this.c.d()) {
                if (this.f == 1) {
                    as asVar = new as();
                    asVar.b(str);
                    aw awVar = (aw) asVar.c().get(0);
                    if (awVar != null) {
                        gVar4 = this.b.b;
                        WriteActivity.a(gVar4, asVar.a().a(), asVar.a().b(), asVar.b().a(), awVar.d(), awVar.e(), this.e, asVar.e(), asVar.h());
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    gVar2 = this.b.b;
                    bh a2 = new by(gVar2, str).a();
                    String a3 = a2.g().a();
                    String b = a2.g().b();
                    String a4 = a2.l().a();
                    AntiData h = a2.h();
                    String d = a2.a().d();
                    int e = a2.a().e();
                    gVar3 = this.b.b;
                    WriteActivity.a(gVar3, a3, b, a4, d, e, this.e, h, true);
                }
            } else if (this.c != null) {
                gVar = this.b.b;
                gVar.a(this.c.h());
            }
        } catch (Exception e2) {
        }
        this.b.m = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.i();
        }
        progressBar = this.b.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
