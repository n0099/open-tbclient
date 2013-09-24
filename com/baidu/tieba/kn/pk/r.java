package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, h> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1290a;
    private z b = null;

    public r(PKingActivity pKingActivity) {
        this.f1290a = pKingActivity;
        pKingActivity.j = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public h a(Object... objArr) {
        t tVar;
        t tVar2;
        String str;
        t tVar3;
        t tVar4;
        h hVar = new h();
        tVar = this.f1290a.b;
        tVar2 = this.f1290a.b;
        long min = Math.min(((tVar.f1292a.e() / 1000) - tVar2.d) - 1, 15L);
        if (min <= 0) {
            StringBuilder sb = new StringBuilder("inc interval last vote:");
            tVar3 = this.f1290a.b;
            StringBuilder append = sb.append(tVar3.d).append(", now is:");
            tVar4 = this.f1290a.b;
            com.baidu.adp.lib.f.d.a(append.append(tVar4.f1292a.e() / 1000).toString());
            return null;
        }
        try {
            this.b = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/uo/pkvoteinfo");
            z zVar = this.b;
            str = this.f1290a.e;
            zVar.a("pk_id", str);
            this.b.a("rn", "15");
            this.b.a("time", String.valueOf(min));
            String j = this.b.j();
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.c("inc interval is:" + min + ", result is:" + j);
            }
            if (this.b.c()) {
                hVar.b(j);
                return hVar;
            }
            hVar.a(this.b.g());
            return hVar;
        } catch (Exception e) {
            hVar.a(e.getMessage());
            av.b(getClass().getName(), "doInBackground", e.getMessage());
            return hVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(h hVar) {
        this.f1290a.a(hVar);
        this.f1290a.j = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1290a.n();
        this.f1290a.j = false;
    }
}
