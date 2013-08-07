package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1223a;
    private com.baidu.tieba.util.u b = null;

    public r(PKingActivity pKingActivity) {
        this.f1223a = pKingActivity;
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
        tVar = this.f1223a.b;
        tVar2 = this.f1223a.b;
        long min = Math.min(((tVar.f1225a.d() / 1000) - tVar2.d) - 1, 15L);
        if (min <= 0) {
            StringBuilder sb = new StringBuilder("inc interval last vote:");
            tVar3 = this.f1223a.b;
            StringBuilder append = sb.append(tVar3.d).append(", now is:");
            tVar4 = this.f1223a.b;
            com.baidu.adp.lib.e.d.a(append.append(tVar4.f1225a.d() / 1000).toString());
            return null;
        }
        try {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/uo/pkvoteinfo");
            com.baidu.tieba.util.u uVar = this.b;
            str = this.f1223a.e;
            uVar.a("pk_id", str);
            this.b.a("rn", "15");
            this.b.a("time", String.valueOf(min));
            String k = this.b.k();
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.c("inc interval is:" + min + ", result is:" + k);
            }
            if (this.b.d()) {
                hVar.b(k);
                return hVar;
            }
            hVar.a(this.b.h());
            return hVar;
        } catch (Exception e) {
            hVar.a(e.getMessage());
            aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return hVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(h hVar) {
        this.f1223a.a(hVar);
        this.f1223a.j = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1223a.m();
        this.f1223a.j = false;
    }
}
