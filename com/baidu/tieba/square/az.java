package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, ar, ar> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ax f2393a;
    private int c;
    private com.baidu.tieba.a.j b = null;
    private com.baidu.adp.lib.cache.s<String> d = null;

    public az(ax axVar, int i) {
        this.f2393a = axVar;
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
        this.d = com.baidu.tieba.b.a.a().l();
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
        this.f2393a.f2392a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ar arVar) {
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        this.f2393a.f2392a = null;
        this.f2393a.b = arVar;
        ayVar = this.f2393a.c;
        if (ayVar != null) {
            if (this.c == 0 || this.b.c()) {
                ayVar2 = this.f2393a.c;
                ayVar2.a(true, null, arVar);
                return;
            }
            String d = this.b.d();
            ayVar3 = this.f2393a.c;
            ayVar3.a(false, d, arVar);
        }
    }
}
