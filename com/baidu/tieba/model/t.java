package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends BdAsyncTask<Integer, com.baidu.tieba.data.p, com.baidu.tieba.data.p> {
    final /* synthetic */ s a;
    private com.baidu.tieba.b.b b = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.p pVar) {
        boolean z;
        int i;
        com.baidu.adp.a.h hVar;
        com.baidu.tieba.data.p pVar2;
        com.baidu.tieba.data.p pVar3;
        int i2;
        com.baidu.tieba.data.p pVar4;
        com.baidu.adp.a.h hVar2;
        com.baidu.tieba.data.p pVar5 = pVar;
        this.b.a();
        if (pVar5 == null || this.b.e() != 0) {
            this.a.setErrorCode(this.b.e());
            this.a.setErrorString(this.b.f());
            z = true;
        } else if (pVar5 == null || pVar5.d() == 0) {
            z = false;
        } else {
            this.a.setErrorCode(pVar5.d());
            this.a.setErrorString(pVar5.e());
            z = true;
        }
        if (z) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(null);
        } else {
            i = this.a.f;
            if (i != 1) {
                pVar3 = this.a.d;
                if (pVar3 != null) {
                    i2 = this.a.f;
                    if (i2 == 2) {
                        if (this.a.a()) {
                            this.a.d = pVar5;
                        } else {
                            pVar4 = this.a.d;
                            pVar4.a(pVar5, true);
                        }
                    }
                    hVar = this.a.mLoadDataCallBack;
                    pVar2 = this.a.d;
                    hVar.a(pVar2);
                }
            }
            this.a.d = pVar5;
            hVar = this.a.mLoadDataCallBack;
            pVar2 = this.a.d;
            hVar.a(pVar2);
        }
        this.a.g = 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(com.baidu.tieba.data.p... pVarArr) {
        com.baidu.adp.a.h hVar;
        com.baidu.tieba.data.p[] pVarArr2 = pVarArr;
        super.b((Object[]) pVarArr2);
        u uVar = new u(this.a);
        uVar.b = 3;
        uVar.a = pVarArr2.length > 0 ? pVarArr2[0] : null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(uVar);
    }

    public t(s sVar) {
        this.a = sVar;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.p a(Integer... numArr) {
        String E;
        com.baidu.adp.lib.cache.s<String> g;
        try {
            if (this.b == null) {
                this.b = new com.baidu.tieba.b.b();
            }
            String num = numArr[0].toString();
            if (numArr.length > 1 ? numArr[1].intValue() == 1 : false) {
                c((Object[]) new com.baidu.tieba.data.p[]{this.a.f()});
                if (numArr[1].intValue() == 1) {
                    return null;
                }
            }
            String b = this.b.b(num);
            if (!this.b.c() || b == null) {
                return null;
            }
            com.baidu.tieba.data.p pVar = new com.baidu.tieba.data.p();
            pVar.a(b);
            if (num.equals("1") && this.b.e() == 0 && pVar.d() == 0 && (E = TbadkApplication.E()) != null && (g = com.baidu.tbadk.core.c.b.a().g()) != null) {
                g.a("home_forumfeed_" + E, b, 604800000L);
            }
            return pVar;
        } catch (Exception e) {
            this.a.g = 0;
            com.baidu.adp.lib.util.f.b(s.class.getName(), "GetForumFeedTask.doInBackground", e.getMessage().toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        super.d();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
    }
}
