package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Object, ar, ar> {
    final /* synthetic */ av a;
    private int c;
    private com.baidu.tieba.a.h b = null;
    private com.baidu.adp.lib.cache.s<String> d = null;

    public ax(av avVar, int i) {
        this.a = avVar;
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
        this.b = new com.baidu.tieba.a.h();
        this.d = com.baidu.tieba.b.a.a().o();
        if (this.c == 0) {
            String a = this.d.a("square_cache_key");
            if (a == null) {
                return null;
            }
            ar arVar2 = new ar();
            arVar2.a(a);
            if (!arVar2.a()) {
                this.c = 1;
                str = a;
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
            this.d.a("square_cache_key", str, 86400000L);
        }
        return arVar;
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
    public void a(ar arVar) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        this.a.a = null;
        this.a.b = arVar;
        awVar = this.a.c;
        if (awVar != null) {
            if (this.c == 0 || this.b.c()) {
                awVar2 = this.a.c;
                awVar2.a(true, null, arVar);
                return;
            }
            String d = this.b.d();
            awVar3 = this.a.c;
            awVar3.a(false, d, arVar);
        }
    }
}
