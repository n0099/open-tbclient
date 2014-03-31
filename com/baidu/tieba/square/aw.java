package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aw extends BdAsyncTask<Object, aq, aq> {
    final /* synthetic */ au a;
    private int c;
    private com.baidu.tieba.b.c b = null;
    private com.baidu.adp.lib.cache.s<String> d = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ aq a(Object... objArr) {
        aq aqVar;
        String str = null;
        this.b = new com.baidu.tieba.b.c();
        this.d = com.baidu.tbadk.core.c.b.a().o();
        if (this.c == 0) {
            String a = this.d.a("square_cache_key");
            if (a == null) {
                return null;
            }
            aq aqVar2 = new aq();
            aqVar2.a(a);
            if (aqVar2.a()) {
                return aqVar2;
            }
            this.c = 1;
            str = a;
            aqVar = aqVar2;
        } else {
            aqVar = null;
        }
        if (this.c == 1) {
            this.a.d = System.currentTimeMillis();
            str = this.b.g();
            this.a.e = this.b.h();
            this.a.f = this.b.i();
            this.a.g = System.currentTimeMillis();
        }
        if (this.b.c()) {
            aq aqVar3 = new aq();
            aqVar3.a(str);
            this.d.a("square_cache_key", str, 86400000L);
            return aqVar3;
        }
        return aqVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(aq aqVar) {
        av avVar;
        av avVar2;
        av avVar3;
        aq aqVar2 = aqVar;
        this.a.a = null;
        this.a.b = aqVar2;
        avVar = this.a.c;
        if (avVar != null) {
            if (this.c == 0 || this.b.c()) {
                avVar2 = this.a.c;
                avVar2.a(true, null, aqVar2);
                return;
            }
            String d = this.b.d();
            avVar3 = this.a.c;
            avVar3.a(false, d, aqVar2);
        }
    }

    public aw(au auVar, int i) {
        this.a = auVar;
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
