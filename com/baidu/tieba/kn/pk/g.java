package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKJumpActivity f1212a;
    private com.baidu.tieba.util.u b = null;

    public g(PKJumpActivity pKJumpActivity) {
        this.f1212a = pKJumpActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public s a(Object... objArr) {
        String str;
        s sVar = new s();
        try {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/uo/pkdetail");
            com.baidu.tieba.util.u uVar = this.b;
            str = this.f1212a.c;
            uVar.a("pk_id", str);
            this.b.a("rn", "25");
            String k = this.b.k();
            if (this.b.d()) {
                sVar.b(k);
            } else {
                sVar.a(this.b.h());
            }
        } catch (Exception e) {
            sVar.a(e.getMessage());
            aj.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(s sVar) {
        this.f1212a.a(sVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1212a.d();
    }
}
