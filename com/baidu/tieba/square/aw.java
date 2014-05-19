package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<Object, aq, aq> {
    final /* synthetic */ au a;
    private int c;
    private com.baidu.tieba.a.c b = null;
    private com.baidu.adp.lib.cache.s<String> d = null;

    public aw(au auVar, int i) {
        this.a = auVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public aq doInBackground(Object... objArr) {
        aq aqVar;
        String str = null;
        this.b = new com.baidu.tieba.a.c();
        this.d = com.baidu.tbadk.core.a.b.a().q();
        if (this.c == 0) {
            String a = this.d.a("square_cache_key");
            if (a == null) {
                return null;
            }
            aq aqVar2 = new aq();
            aqVar2.a(a);
            if (!aqVar2.a()) {
                this.c = 1;
                str = a;
                aqVar = aqVar2;
            } else {
                return aqVar2;
            }
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
            aqVar = new aq();
            aqVar.a(str);
            this.d.a("square_cache_key", str, 86400000L);
        }
        return aqVar;
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
    /* renamed from: a */
    public void onPostExecute(aq aqVar) {
        av avVar;
        av avVar2;
        av avVar3;
        this.a.a = null;
        this.a.b = aqVar;
        avVar = this.a.c;
        if (avVar != null) {
            if (this.c == 0 || this.b.c()) {
                avVar2 = this.a.c;
                avVar2.a(true, null, aqVar);
                return;
            }
            String d = this.b.d();
            avVar3 = this.a.c;
            avVar3.a(false, d, aqVar);
        }
    }
}
