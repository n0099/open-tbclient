package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<Object, as, as> {
    final /* synthetic */ aw a;
    private int c;
    private com.baidu.tieba.b.h b = null;
    private com.baidu.adp.lib.cache.s<String> d = null;

    public ay(aw awVar, int i) {
        this.a = awVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public as a(Object... objArr) {
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
            if (!asVar2.a()) {
                this.c = 1;
                str = a;
                asVar = asVar2;
            } else {
                return asVar2;
            }
        } else {
            asVar = null;
        }
        if (this.c == 1) {
            str = this.b.g();
        }
        if (this.b.c()) {
            asVar = new as();
            asVar.a(str);
            this.d.a("square_cache_key", str, 86400000L);
        }
        return asVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.b != null) {
            this.b.a();
        }
        this.a.a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(as asVar) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        this.a.a = null;
        this.a.b = asVar;
        axVar = this.a.c;
        if (axVar != null) {
            if (this.c == 0 || this.b.c()) {
                axVar2 = this.a.c;
                axVar2.a(true, null, asVar);
                return;
            }
            String d = this.b.d();
            axVar3 = this.a.c;
            axVar3.a(false, d, asVar);
        }
    }
}
