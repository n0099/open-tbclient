package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Object, ar, ar> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ av f2493a;
    private int c;
    private com.baidu.tieba.a.j b = null;
    private com.baidu.adp.lib.cache.s<String> d = null;

    public ax(av avVar, int i) {
        this.f2493a = avVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public ar a(Object... objArr) {
        ar arVar;
        String str = null;
        this.b = new com.baidu.tieba.a.j();
        this.d = com.baidu.tieba.b.a.a().o();
        if (this.c == 0) {
            String a2 = this.d.a("square_cache_key");
            if (a2 == null) {
                return null;
            }
            ar arVar2 = new ar();
            arVar2.a(a2);
            if (!arVar2.a()) {
                this.c = 1;
                str = a2;
                arVar = arVar2;
            } else {
                return arVar2;
            }
        } else {
            arVar = null;
        }
        if (this.c == 1) {
            str = this.b.g();
        }
        if (this.b.c()) {
            arVar = new ar();
            arVar.a(str);
            this.d.a("square_cache_key", str, Util.MILLSECONDS_OF_DAY);
        }
        return arVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.b != null) {
            this.b.a();
        }
        this.f2493a.f2492a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ar arVar) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        this.f2493a.f2492a = null;
        this.f2493a.b = arVar;
        awVar = this.f2493a.c;
        if (awVar != null) {
            if (this.c == 0 || this.b.c()) {
                awVar2 = this.f2493a.c;
                awVar2.a(true, null, arVar);
                return;
            }
            String d = this.b.d();
            awVar3 = this.f2493a.c;
            awVar3.a(false, d, arVar);
        }
    }
}
