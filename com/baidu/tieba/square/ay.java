package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ay extends BdAsyncTask<Object, as, as> {
    final /* synthetic */ aw a;
    private int c;
    private com.baidu.tieba.b.h b = null;
    private com.baidu.adp.lib.cache.s<String> d = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ as a(Object... objArr) {
        as asVar;
        String str = null;
        this.b = new com.baidu.tieba.b.h();
        this.d = com.baidu.tieba.c.a.a().o();
        if (this.c == 0) {
            String a = this.d.a("square_cache_key");
            if (a == null) {
                return null;
            }
            as asVar2 = new as();
            asVar2.a(a);
            if (asVar2.a()) {
                return asVar2;
            }
            this.c = 1;
            str = a;
            asVar = asVar2;
        } else {
            asVar = null;
        }
        if (this.c == 1) {
            this.a.d = System.currentTimeMillis();
            str = this.b.g();
            this.a.e = this.b.h();
            this.a.f = this.b.i();
            this.a.g = System.currentTimeMillis();
        }
        if (this.b.c()) {
            as asVar3 = new as();
            asVar3.a(str);
            this.d.a("square_cache_key", str, 86400000L);
            return asVar3;
        }
        return asVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(as asVar) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        as asVar2 = asVar;
        this.a.a = null;
        this.a.b = asVar2;
        axVar = this.a.c;
        if (axVar != null) {
            if (this.c == 0 || this.b.c()) {
                axVar2 = this.a.c;
                axVar2.a(true, null, asVar2);
                return;
            }
            String d = this.b.d();
            axVar3 = this.a.c;
            axVar3.a(false, d, asVar2);
        }
    }

    public ay(aw awVar, int i) {
        this.a = awVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        if (this.b != null) {
            this.b.a();
        }
        this.a.a = null;
    }
}
