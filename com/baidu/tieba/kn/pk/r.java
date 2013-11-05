package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, h> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1785a;
    private ag b = null;

    public r(PKingActivity pKingActivity) {
        this.f1785a = pKingActivity;
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
        tVar = this.f1785a.b;
        tVar2 = this.f1785a.b;
        long min = Math.min(((tVar.f1787a.e() / 1000) - tVar2.d) - 1, 15L);
        if (min <= 0) {
            StringBuilder append = new StringBuilder().append("inc interval last vote:");
            tVar3 = this.f1785a.b;
            StringBuilder append2 = append.append(tVar3.d).append(", now is:");
            tVar4 = this.f1785a.b;
            com.baidu.adp.lib.h.d.a(append2.append(tVar4.f1787a.e() / 1000).toString());
            return null;
        }
        try {
            this.b = new ag(com.baidu.tieba.data.h.f1165a + "c/s/uo/pkvoteinfo");
            ag agVar = this.b;
            str = this.f1785a.e;
            agVar.a("pk_id", str);
            this.b.a("rn", "15");
            this.b.a("time", String.valueOf(min));
            String j = this.b.j();
            if (com.baidu.adp.lib.h.d.a()) {
                com.baidu.adp.lib.h.d.d("inc interval is:" + min + ", result is:" + j);
            }
            if (this.b.c()) {
                hVar.b(j);
                return hVar;
            }
            hVar.a(this.b.g());
            return hVar;
        } catch (Exception e) {
            hVar.a(e.getMessage());
            be.b(getClass().getName(), "doInBackground", e.getMessage());
            return hVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(h hVar) {
        this.f1785a.a(hVar);
        this.f1785a.j = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1785a.n();
        this.f1785a.j = false;
    }
}
