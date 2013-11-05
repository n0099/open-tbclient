package com.baidu.tieba.kn.pk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, s> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKEndActivity f1769a;
    private ag b = null;

    public b(PKEndActivity pKEndActivity) {
        this.f1769a = pKEndActivity;
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
            str = this.f1769a.c;
            agVar.a("pk_id", str);
            this.b.a("rn", SocialConstants.TRUE);
            String j = this.b.j();
            if (this.b.c()) {
                sVar.b(j);
                if (!sVar.b() && bc.c(sVar.f1786a)) {
                    sVar.a(this.f1769a.getString(R.string.kn_data_corrupted));
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
        this.f1769a.a(sVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1769a.d();
    }
}
