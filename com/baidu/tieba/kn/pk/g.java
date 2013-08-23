package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKJumpActivity f1245a;
    private com.baidu.tieba.util.v b = null;

    public g(PKJumpActivity pKJumpActivity) {
        this.f1245a = pKJumpActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public s a(Object... objArr) {
        String str;
        s sVar = new s();
        try {
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/uo/pkdetail");
            com.baidu.tieba.util.v vVar = this.b;
            str = this.f1245a.c;
            vVar.a("pk_id", str);
            this.b.a("rn", "25");
            String j = this.b.j();
            if (this.b.c()) {
                sVar.b(j);
            } else {
                sVar.a(this.b.g());
            }
        } catch (Exception e) {
            sVar.a(e.getMessage());
            aq.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(s sVar) {
        this.f1245a.a(sVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1245a.d();
    }
}
