package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends BdAsyncTask<g, Integer, Boolean> {
    final /* synthetic */ g a;
    private com.baidu.tieba.util.ba b;
    private com.baidu.tieba.data.ay c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(g... gVarArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        Boolean bool2 = bool;
        this.a.c = null;
        if (bool2.booleanValue()) {
            arrayList = this.a.e;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.b.c()) {
            str = this.c.b();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.a.a != null) {
            this.a.a.a(1, bool2, str, Boolean.valueOf(z));
        }
    }

    private j(g gVar) {
        this.a = gVar;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(g gVar, byte b) {
        this(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        this.c = new com.baidu.tieba.data.ay();
    }

    private Boolean d() {
        g gVar = new g();
        try {
            gVar.i();
            this.b = new com.baidu.tieba.util.ba();
            this.b.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/addstore");
            g gVar2 = this.a;
            int k = g.k();
            if (gVar.g() - 1 <= k) {
                k = gVar.g() - 1;
            }
            while (k >= 0) {
                String a = gVar.a(k, 20);
                this.b.a(new ArrayList<>());
                this.b.a("data", a);
                this.c.a(this.b.l());
                if (!this.b.c() || this.c.a() != 0) {
                    break;
                }
                k -= 20;
            }
            g gVar3 = this.a;
            com.baidu.tieba.sharedPref.b.a().b("uploac_mark_offset", k);
            if (k >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.a.c = null;
        if (this.a.a != null) {
            this.a.a.a(1, false, null, false);
        }
    }
}
