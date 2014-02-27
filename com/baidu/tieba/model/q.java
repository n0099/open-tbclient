package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends BdAsyncTask<Integer, com.baidu.tieba.data.u, com.baidu.tieba.data.u> {
    final /* synthetic */ p a;
    private com.baidu.tieba.b.d b = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.u uVar) {
        boolean z;
        int i;
        com.baidu.adp.a.g gVar;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        int i2;
        com.baidu.tieba.data.u uVar4;
        com.baidu.adp.a.g gVar2;
        com.baidu.tieba.data.u uVar5 = uVar;
        this.b.a();
        if (uVar5 == null || this.b.e() != 0) {
            this.a.setErrorCode(this.b.e());
            this.a.setErrorString(this.b.f());
            z = true;
        } else if (uVar5 == null || uVar5.d() == 0) {
            z = false;
        } else {
            this.a.setErrorCode(uVar5.d());
            this.a.setErrorString(uVar5.e());
            z = true;
        }
        if (z) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(null);
        } else {
            i = this.a.f;
            if (i != 1) {
                uVar3 = this.a.d;
                if (uVar3 != null) {
                    i2 = this.a.f;
                    if (i2 == 2) {
                        if (this.a.a()) {
                            this.a.d = uVar5;
                        } else {
                            uVar4 = this.a.d;
                            uVar4.a(uVar5, true);
                        }
                    }
                    gVar = this.a.mLoadDataCallBack;
                    uVar2 = this.a.d;
                    gVar.a(uVar2);
                }
            }
            this.a.d = uVar5;
            gVar = this.a.mLoadDataCallBack;
            uVar2 = this.a.d;
            gVar.a(uVar2);
        }
        this.a.g = 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(com.baidu.tieba.data.u... uVarArr) {
        com.baidu.adp.a.g gVar;
        com.baidu.tieba.data.u[] uVarArr2 = uVarArr;
        super.b((Object[]) uVarArr2);
        r rVar = new r(this.a);
        rVar.b = 3;
        rVar.a = uVarArr2.length > 0 ? uVarArr2[0] : null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(rVar);
    }

    public q(p pVar) {
        this.a = pVar;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.u a(Integer... numArr) {
        String v;
        com.baidu.adp.lib.cache.s<String> g;
        try {
            if (this.b == null) {
                this.b = new com.baidu.tieba.b.d();
            }
            String num = numArr[0].toString();
            if (numArr.length > 1 ? numArr[1].intValue() == 1 : false) {
                c((Object[]) new com.baidu.tieba.data.u[]{this.a.f()});
                if (numArr[1].intValue() == 1) {
                    return null;
                }
            }
            String b = this.b.b(num);
            if (!this.b.c() || b == null) {
                return null;
            }
            com.baidu.tieba.data.u uVar = new com.baidu.tieba.data.u();
            uVar.a(b);
            if (num.equals(SocialConstants.TRUE) && this.b.e() == 0 && uVar.d() == 0 && (v = TiebaApplication.v()) != null && (g = com.baidu.tieba.c.a.a().g()) != null) {
                g.a("home_forumfeed_" + v, b, 604800000L);
            }
            return uVar;
        } catch (Exception e) {
            this.a.g = 0;
            com.baidu.adp.lib.util.e.b(p.class.getName(), "GetForumFeedTask.doInBackground", e.getMessage().toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
    }
}
