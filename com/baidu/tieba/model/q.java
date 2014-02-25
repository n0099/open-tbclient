package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Integer, com.baidu.tieba.data.u, com.baidu.tieba.data.u> {
    final /* synthetic */ p a;
    private com.baidu.tieba.b.d b = null;

    public q(p pVar) {
        this.a = pVar;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.u a(Integer... numArr) {
        try {
            if (this.b == null) {
                this.b = new com.baidu.tieba.b.d();
            }
            String num = numArr[0].toString();
            if (numArr.length > 1 ? numArr[1].intValue() == 1 : false) {
                c((Object[]) new com.baidu.tieba.data.u[]{this.a.h()});
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
            if (num.equals(SocialConstants.TRUE) && this.b.e() == 0 && uVar.g() == 0) {
                a(b);
            }
            return uVar;
        } catch (Exception e) {
            this.a.g = 0;
            com.baidu.adp.lib.util.f.b(p.class.getName(), "GetForumFeedTask.doInBackground", e.getMessage().toString());
            return null;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> g;
        String A = TiebaApplication.A();
        if (A != null && (g = com.baidu.tieba.c.a.a().g()) != null) {
            g.a("home_forumfeed_" + A, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.u... uVarArr) {
        com.baidu.adp.a.g gVar;
        super.b((Object[]) uVarArr);
        r rVar = new r(this.a);
        rVar.b = 3;
        rVar.a = uVarArr.length > 0 ? uVarArr[0] : null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(rVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.u uVar) {
        int i;
        com.baidu.adp.a.g gVar;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        int i2;
        com.baidu.tieba.data.u uVar4;
        com.baidu.adp.a.g gVar2;
        this.b.a();
        if (b(uVar)) {
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
                            this.a.d = uVar;
                        } else {
                            uVar4 = this.a.d;
                            uVar4.a(uVar, true);
                        }
                    }
                    gVar = this.a.mLoadDataCallBack;
                    uVar2 = this.a.d;
                    gVar.a(uVar2);
                }
            }
            this.a.d = uVar;
            gVar = this.a.mLoadDataCallBack;
            uVar2 = this.a.d;
            gVar.a(uVar2);
        }
        this.a.g = 0;
    }

    private boolean b(com.baidu.tieba.data.u uVar) {
        if (uVar == null || this.b.e() != 0) {
            this.a.setErrorCode(this.b.e());
            this.a.setErrorString(this.b.f());
            return true;
        } else if (uVar != null && uVar.g() != 0) {
            this.a.setErrorCode(uVar.g());
            this.a.setErrorString(uVar.h());
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
    }
}
