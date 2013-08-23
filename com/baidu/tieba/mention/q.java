package com.baidu.tieba.mention;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.data.as;
import com.baidu.tieba.data.bd;
import com.baidu.tieba.model.ca;
import com.baidu.tieba.util.aq;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1339a;
    final /* synthetic */ i b;
    private com.baidu.tieba.util.v c = null;
    private String d;
    private String e;
    private int f;

    public q(i iVar, String str, ArrayList arrayList, int i, String str2) {
        this.b = iVar;
        this.d = null;
        this.e = null;
        this.f1339a = null;
        this.d = str;
        this.f1339a = arrayList;
        this.f = i;
        this.e = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.util.v(this.d);
            this.c.a(this.f1339a);
            return this.c.j();
        } catch (Exception e) {
            aq.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        com.baidu.tieba.g gVar3;
        com.baidu.tieba.g gVar4;
        try {
            if (this.c != null && this.c.c()) {
                if (this.f == 1) {
                    ao aoVar = new ao();
                    aoVar.b(str);
                    as asVar = (as) aoVar.d().get(0);
                    if (asVar != null) {
                        gVar4 = this.b.b;
                        WriteActivity.a(gVar4, aoVar.b().a(), aoVar.b().b(), aoVar.c().a(), asVar.d(), asVar.e(), this.e, aoVar.f(), aoVar.i());
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    gVar2 = this.b.b;
                    bd a2 = new ca(gVar2, str).a();
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
                gVar.a(this.c.g());
            }
        } catch (Exception e2) {
        }
        this.b.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }
}
