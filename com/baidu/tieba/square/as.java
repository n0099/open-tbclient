package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<Object, am, am> {
    final /* synthetic */ aq a;
    private int c;
    private com.baidu.tieba.a.c b = null;
    private com.baidu.adp.lib.cache.t<String> d = null;

    public as(aq aqVar, int i) {
        this.a = aqVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public am doInBackground(Object... objArr) {
        am amVar;
        String str = null;
        this.b = new com.baidu.tieba.a.c();
        this.d = com.baidu.tbadk.core.a.a.a().b("tb.square");
        if (this.c == 0) {
            String a = this.d.a("square_cache_key");
            if (a == null) {
                return null;
            }
            am amVar2 = new am();
            amVar2.a(a);
            if (!amVar2.a()) {
                this.c = 1;
                str = a;
                amVar = amVar2;
            } else {
                return amVar2;
            }
        } else {
            amVar = null;
        }
        if (this.c == 1) {
            this.a.d = System.currentTimeMillis();
            str = this.b.g();
            this.a.e = this.b.h();
            this.a.f = this.b.i();
            this.a.g = System.currentTimeMillis();
        }
        if (this.b.c()) {
            amVar = new am();
            amVar.a(str);
            this.d.a("square_cache_key", str, 86400000L);
        }
        return amVar;
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
    public void onPostExecute(am amVar) {
        ar arVar;
        ar arVar2;
        ar arVar3;
        this.a.a = null;
        this.a.b = amVar;
        arVar = this.a.c;
        if (arVar != null) {
            if (this.c == 0 || this.b.c()) {
                arVar2 = this.a.c;
                arVar2.a(true, null, amVar);
                return;
            }
            String d = this.b.d();
            arVar3 = this.a.c;
            arVar3.a(false, d, amVar);
        }
    }
}
