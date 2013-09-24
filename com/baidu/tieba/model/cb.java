package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb extends BdAsyncTask<Object, com.baidu.tieba.data.bc, com.baidu.tieba.data.bc> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bz f1435a;
    private int c;
    private com.baidu.tieba.a.m b = null;
    private com.baidu.adp.lib.cache.q<String> d = null;

    public cb(bz bzVar, int i) {
        this.f1435a = bzVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bc a(Object... objArr) {
        String str;
        com.baidu.tieba.data.bc bcVar = null;
        this.b = new com.baidu.tieba.a.m();
        this.d = com.baidu.tieba.b.a.a().j();
        if (this.c == 0) {
            String a2 = this.d.a("square_cache_key");
            com.baidu.tieba.data.bc bcVar2 = new com.baidu.tieba.data.bc();
            bcVar2.a(a2);
            if (!bcVar2.c()) {
                this.c = 1;
                str = a2;
                bcVar = bcVar2;
            } else {
                return bcVar2;
            }
        } else {
            str = null;
        }
        if (this.c == 1) {
            str = this.b.g();
        }
        if (this.b.c()) {
            bcVar = new com.baidu.tieba.data.bc();
            bcVar.a(str);
            this.d.a("square_cache_key", str, Util.MILLSECONDS_OF_DAY);
        }
        return bcVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f1435a.f1433a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bc bcVar) {
        ca caVar;
        ca caVar2;
        ca caVar3;
        this.f1435a.f1433a = null;
        this.f1435a.b = bcVar;
        caVar = this.f1435a.c;
        if (caVar != null) {
            if (this.c == 0 || this.b.c()) {
                caVar2 = this.f1435a.c;
                caVar2.a(true, null, bcVar);
                return;
            }
            String d = this.b.d();
            caVar3 = this.f1435a.c;
            caVar3.a(false, d, bcVar);
        }
    }
}
