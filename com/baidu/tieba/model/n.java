package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends BdAsyncTask<k, Integer, Boolean> {
    final /* synthetic */ k a;
    private com.baidu.tbadk.core.util.ak b;
    private com.baidu.tieba.data.ap c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Boolean a(k... kVarArr) {
        return a();
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
        } else if (this.b.a().b().b()) {
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

    private n(k kVar) {
        this.a = kVar;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(k kVar, byte b) {
        this(kVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        this.c = new com.baidu.tieba.data.ap();
    }

    private Boolean a() {
        k kVar = new k();
        try {
            kVar.i();
            this.b = new com.baidu.tbadk.core.util.ak();
            this.b.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/post/addstore");
            k kVar2 = this.a;
            int k = k.k();
            if (kVar.g() - 1 <= k) {
                k = kVar.g() - 1;
            }
            while (k >= 0) {
                String a = kVar.a(k, 20);
                this.b.a(new ArrayList<>());
                this.b.a("data", a);
                this.c.a(this.b.i());
                if (!this.b.a().b().b() || this.c.a() != 0) {
                    break;
                }
                k -= 20;
            }
            k kVar3 = this.a;
            com.baidu.tbadk.core.sharedPref.b.a().b("uploac_mark_offset", k);
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
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
        if (this.a.a != null) {
            this.a.a.a(1, false, null, false);
        }
    }
}
