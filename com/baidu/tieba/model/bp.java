package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.bb> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1922a;
    private com.baidu.tieba.a.j b = null;
    private int c;

    public bp(bo boVar, int i) {
        this.f1922a = boVar;
        this.c = 0;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bb a(Object... objArr) {
        com.baidu.tieba.data.bb bbVar;
        com.baidu.tieba.data.bb bbVar2;
        com.baidu.tieba.data.bb bbVar3;
        String str;
        String str2;
        String str3;
        Context context;
        Context context2;
        this.b = new com.baidu.tieba.a.j();
        try {
            bbVar = this.f1922a.e;
            int f = bbVar.f();
            if (f == 0) {
                f++;
            } else if (this.c == 0) {
                f++;
            } else if (this.c == 2) {
                bbVar2 = this.f1922a.e;
                int size = bbVar2.b().size();
                bbVar3 = this.f1922a.e;
                if (size % bbVar3.e() == 0) {
                    f++;
                }
            }
            com.baidu.tieba.a.j jVar = this.b;
            str = this.f1922a.f1921a;
            str2 = this.f1922a.c;
            int i = this.c;
            str3 = this.f1922a.b;
            String a2 = jVar.a(str, str2, i, str3, f);
            if (this.b.a()) {
                com.baidu.tieba.data.bb bbVar4 = new com.baidu.tieba.data.bb();
                context = this.f1922a.d;
                bbVar4.a(a2, context);
                for (int i2 = 0; i2 < bbVar4.b().size(); i2++) {
                    context2 = this.f1922a.d;
                    bbVar4.b().get(i2).a(context2);
                }
                return bbVar4;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f1922a.f = null;
        if (this.b != null) {
            this.b.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bb bbVar) {
        com.baidu.tieba.data.bb bbVar2;
        com.baidu.tieba.data.bb bbVar3;
        bq bqVar;
        bq bqVar2;
        com.baidu.tieba.data.bb bbVar4;
        bq bqVar3;
        bq bqVar4;
        this.f1922a.f = null;
        if (bbVar == null) {
            bqVar3 = this.f1922a.g;
            if (bqVar3 != null) {
                bqVar4 = this.f1922a.g;
                bqVar4.a(false, this.b.c(), this.b.b(), null);
                return;
            }
            return;
        }
        if (bbVar.a() != null) {
            this.f1922a.b = bbVar.a().d();
        }
        if (bbVar.l() != null) {
            this.f1922a.f1921a = bbVar.l().a();
        }
        if (this.c == 1) {
            this.f1922a.e = bbVar;
        } else if (this.c == 2) {
            bbVar3 = this.f1922a.e;
            bbVar3.a(bbVar, true);
        } else {
            bbVar2 = this.f1922a.e;
            bbVar2.a(bbVar, false);
        }
        bqVar = this.f1922a.g;
        if (bqVar != null) {
            bqVar2 = this.f1922a.g;
            int c = this.b.c();
            String b = this.b.b();
            bbVar4 = this.f1922a.e;
            bqVar2.a(true, c, b, bbVar4);
        }
        this.b = null;
    }
}
