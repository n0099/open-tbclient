package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Integer, com.baidu.tieba.data.w, com.baidu.tieba.data.w> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1886a;
    private com.baidu.tieba.a.g b = null;

    public ab(aa aaVar) {
        this.f1886a = aaVar;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.w a(Integer... numArr) {
        try {
            if (this.b == null) {
                this.b = new com.baidu.tieba.a.g();
            }
            String num = numArr[0].toString();
            if (numArr.length > 1 ? numArr[1].intValue() == 1 : false) {
                c((Object[]) new com.baidu.tieba.data.w[]{this.f1886a.h()});
            }
            String b = this.b.b(num);
            if (this.b.c() && b != null) {
                com.baidu.tieba.data.w wVar = new com.baidu.tieba.data.w();
                wVar.a(b);
                if (num.equals(SocialConstants.TRUE) && this.b.e() == 0 && wVar.f() == 0) {
                    a(b);
                    return wVar;
                }
                return wVar;
            }
        } catch (Exception e) {
            this.f1886a.g = 0;
            com.baidu.tieba.util.be.b(aa.class.getName(), "GetForumFeedTask.doInBackground", e.getMessage().toString());
        }
        return null;
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> e;
        String C = TiebaApplication.C();
        if (C != null && (e = com.baidu.tieba.b.a.a().e()) != null) {
            e.a("home_forumfeed_" + C, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.w... wVarArr) {
        com.baidu.adp.a.g gVar;
        super.b((Object[]) wVarArr);
        ac acVar = new ac(this.f1886a);
        acVar.b = 3;
        acVar.f1887a = wVarArr.length > 0 ? wVarArr[0] : null;
        gVar = this.f1886a.mLoadDataCallBack;
        gVar.a(acVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.w wVar) {
        int i;
        com.baidu.adp.a.g gVar;
        com.baidu.tieba.data.w wVar2;
        com.baidu.tieba.data.w wVar3;
        int i2;
        com.baidu.tieba.data.w wVar4;
        com.baidu.adp.a.g gVar2;
        this.b.a();
        if (b(wVar)) {
            gVar2 = this.f1886a.mLoadDataCallBack;
            gVar2.a(null);
        } else {
            i = this.f1886a.f;
            if (i != 1) {
                wVar3 = this.f1886a.d;
                if (wVar3 != null) {
                    i2 = this.f1886a.f;
                    if (i2 == 2) {
                        if (this.f1886a.a()) {
                            this.f1886a.d = wVar;
                        } else {
                            wVar4 = this.f1886a.d;
                            wVar4.a(wVar, true);
                        }
                    }
                    gVar = this.f1886a.mLoadDataCallBack;
                    wVar2 = this.f1886a.d;
                    gVar.a(wVar2);
                }
            }
            this.f1886a.d = wVar;
            gVar = this.f1886a.mLoadDataCallBack;
            wVar2 = this.f1886a.d;
            gVar.a(wVar2);
        }
        this.f1886a.g = 0;
    }

    private boolean b(com.baidu.tieba.data.w wVar) {
        if (wVar == null || this.b.e() != 0) {
            this.f1886a.setErrorCode(this.b.e());
            this.f1886a.setErrorString(this.b.f());
            return true;
        } else if (wVar != null && wVar.f() != 0) {
            this.f1886a.setErrorCode(wVar.f());
            this.f1886a.setErrorString(wVar.g());
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
