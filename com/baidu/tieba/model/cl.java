package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl extends BdAsyncTask<Object, com.baidu.tieba.data.ba, com.baidu.tieba.data.ba> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cj f1938a;
    private int c;
    private com.baidu.tieba.a.m b = null;
    private com.baidu.adp.lib.cache.s<String> d = null;

    public cl(cj cjVar, int i) {
        this.f1938a = cjVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ba a(Object... objArr) {
        String str;
        com.baidu.tieba.data.ba baVar = null;
        this.b = new com.baidu.tieba.a.m();
        this.d = com.baidu.tieba.b.a.a().k();
        if (this.c == 0) {
            String a2 = this.d.a("square_cache_key");
            com.baidu.tieba.data.ba baVar2 = new com.baidu.tieba.data.ba();
            baVar2.a(a2);
            if (!baVar2.c()) {
                this.c = 1;
                str = a2;
                baVar = baVar2;
            } else {
                return baVar2;
            }
        } else {
            str = null;
        }
        if (this.c == 1) {
            str = this.b.g();
        }
        if (this.b.c()) {
            baVar = new com.baidu.tieba.data.ba();
            baVar.a(str);
            this.d.a("square_cache_key", str, Util.MILLSECONDS_OF_DAY);
        }
        return baVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f1938a.f1937a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ba baVar) {
        ck ckVar;
        ck ckVar2;
        ck ckVar3;
        this.f1938a.f1937a = null;
        this.f1938a.b = baVar;
        ckVar = this.f1938a.c;
        if (ckVar != null) {
            if (this.c == 0 || this.b.c()) {
                ckVar2 = this.f1938a.c;
                ckVar2.a(true, null, baVar);
                return;
            }
            String d = this.b.d();
            ckVar3 = this.f1938a.c;
            ckVar3.a(false, d, baVar);
        }
    }
}
