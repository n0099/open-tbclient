package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f1397a;
    private int c;
    private com.baidu.tieba.a.k b = null;
    private com.baidu.adp.lib.cache.q d = null;

    public bz(bx bxVar, int i) {
        this.f1397a = bxVar;
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
        this.b = new com.baidu.tieba.a.k();
        this.d = com.baidu.tieba.b.a.a().j();
        if (this.c == 0) {
            String str2 = (String) this.d.a("square_cache_key");
            com.baidu.tieba.data.bc bcVar2 = new com.baidu.tieba.data.bc();
            bcVar2.a(str2);
            if (!bcVar2.c()) {
                this.c = 1;
                str = str2;
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
        this.f1397a.f1396a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bc bcVar) {
        by byVar;
        by byVar2;
        by byVar3;
        this.f1397a.f1396a = null;
        this.f1397a.b = bcVar;
        byVar = this.f1397a.c;
        if (byVar != null) {
            if (this.c == 0 || this.b.c()) {
                byVar2 = this.f1397a.c;
                byVar2.a(true, null, bcVar);
                return;
            }
            String d = this.b.d();
            byVar3 = this.f1397a.c;
            byVar3.a(false, d, bcVar);
        }
    }
}
