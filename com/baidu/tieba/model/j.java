package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<g, Integer, Boolean> {
    final /* synthetic */ g a;
    private com.baidu.tieba.util.ba b;
    private com.baidu.tieba.data.ay c;

    private j(g gVar) {
        this.a = gVar;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(g gVar, j jVar) {
        this(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.c = new com.baidu.tieba.data.ay();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(g... gVarArr) {
        g gVar = new g();
        try {
            gVar.i();
            this.b = new com.baidu.tieba.util.ba();
            this.b.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/addstore");
            int k = this.a.k();
            if (gVar.g() - 1 <= k) {
                k = gVar.g() - 1;
            }
            while (k >= 0) {
                String a = gVar.a(k, 20);
                this.b.a(new ArrayList<>());
                this.b.a("data", a);
                this.c.a(this.b.m());
                if (!this.b.d() || this.c.a() != 0) {
                    break;
                }
                k -= 20;
            }
            this.a.c(k);
            if (k >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.k();
        }
        this.a.c = null;
        if (this.a.a != null) {
            this.a.a.a(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.a.c = null;
        if (bool.booleanValue()) {
            arrayList = this.a.e;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.b.d()) {
            str = this.c.b();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.a.a != null) {
            this.a.a.a(1, bool, str, Boolean.valueOf(z));
        }
    }
}
