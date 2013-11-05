package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, s> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKWaitingActivity f1778a;
    private ag b = null;

    public k(PKWaitingActivity pKWaitingActivity) {
        this.f1778a = pKWaitingActivity;
        pKWaitingActivity.f = true;
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
            str = this.f1778a.d;
            agVar.a("pk_id", str);
            this.b.a("rn", SocialConstants.TRUE);
            String j = this.b.j();
            if (this.b.c()) {
                sVar.b(j);
                if (!sVar.b() && bc.c(sVar.f1786a)) {
                    sVar.a(this.f1778a.getString(R.string.kn_data_corrupted));
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
        this.f1778a.a(sVar);
        this.f1778a.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1778a.f();
        this.f1778a.f = false;
    }
}
