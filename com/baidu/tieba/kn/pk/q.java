package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1255a;
    private com.baidu.tieba.util.v b = null;

    public q(PKingActivity pKingActivity) {
        this.f1255a = pKingActivity;
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
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/uo/pkdetail");
            com.baidu.tieba.util.v vVar = this.b;
            str = this.f1255a.e;
            vVar.a("pk_id", str);
            this.b.a("rn", "25");
            String j = this.b.j();
            if (this.b.c()) {
                sVar.b(j);
                if (!sVar.b() && ap.c(sVar.f1257a)) {
                    sVar.a(this.f1255a.getString(R.string.kn_data_corrupted));
                }
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
        this.f1255a.a(sVar);
        this.f1255a.j = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1255a.l();
        this.f1255a.j = false;
    }
}
