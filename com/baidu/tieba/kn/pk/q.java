package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Object, Integer, s> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1784a;
    private ag b = null;

    public q(PKingActivity pKingActivity) {
        this.f1784a = pKingActivity;
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
            this.b = new ag(com.baidu.tieba.data.h.f1165a + "c/s/uo/pkdetail");
            ag agVar = this.b;
            str = this.f1784a.e;
            agVar.a("pk_id", str);
            this.b.a("rn", "25");
            String j = this.b.j();
            if (this.b.c()) {
                sVar.b(j);
                if (!sVar.b() && bc.c(sVar.f1786a)) {
                    sVar.a(this.f1784a.getString(R.string.kn_data_corrupted));
                }
            } else {
                sVar.a(this.b.g());
            }
        } catch (Exception e) {
            sVar.a(e.getMessage());
            be.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(s sVar) {
        this.f1784a.a(sVar);
        this.f1784a.j = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1784a.f();
        this.f1784a.j = false;
    }
}
