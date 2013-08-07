package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ai;
import com.baidu.tieba.util.aj;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1222a;
    private com.baidu.tieba.util.u b = null;

    public q(PKingActivity pKingActivity) {
        this.f1222a = pKingActivity;
        pKingActivity.j = true;
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
            str = this.f1222a.e;
            uVar.a("pk_id", str);
            this.b.a("rn", "25");
            String k = this.b.k();
            if (this.b.d()) {
                sVar.b(k);
                if (!sVar.a() && ai.c(sVar.f1224a)) {
                    sVar.a(this.f1222a.getString(R.string.kn_data_corrupted));
                }
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
        this.f1222a.a(sVar);
        this.f1222a.j = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1222a.l();
        this.f1222a.j = false;
    }
}
