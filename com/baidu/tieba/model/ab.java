package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Integer, com.baidu.tieba.data.v, com.baidu.tieba.data.v> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1976a;
    private com.baidu.tieba.a.g b = null;

    public ab(aa aaVar) {
        this.f1976a = aaVar;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.v a(Integer... numArr) {
        try {
            if (this.b == null) {
                this.b = new com.baidu.tieba.a.g();
            }
            String num = numArr[0].toString();
            if (numArr.length > 1 ? numArr[1].intValue() == 1 : false) {
                c((Object[]) new com.baidu.tieba.data.v[]{this.f1976a.h()});
                if (numArr[1].intValue() == 1) {
                    return null;
                }
            }
            String b = this.b.b(num);
            if (!this.b.c() || b == null) {
                return null;
            }
            com.baidu.tieba.data.v vVar = new com.baidu.tieba.data.v();
            vVar.a(b);
            if (num.equals(SocialConstants.TRUE) && this.b.e() == 0 && vVar.g() == 0) {
                a(b);
            }
            return vVar;
        } catch (Exception e) {
            this.f1976a.g = 0;
            com.baidu.tieba.util.bd.b(aa.class.getName(), "GetForumFeedTask.doInBackground", e.getMessage().toString());
            return null;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> g;
        String B = TiebaApplication.B();
        if (B != null && (g = com.baidu.tieba.b.a.a().g()) != null) {
            g.a("home_forumfeed_" + B, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.v... vVarArr) {
        com.baidu.adp.a.g gVar;
        super.b((Object[]) vVarArr);
        ac acVar = new ac(this.f1976a);
        acVar.b = 3;
        acVar.f1977a = vVarArr.length > 0 ? vVarArr[0] : null;
        gVar = this.f1976a.mLoadDataCallBack;
        gVar.a(acVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.v vVar) {
        int i;
        com.baidu.adp.a.g gVar;
        com.baidu.tieba.data.v vVar2;
        com.baidu.tieba.data.v vVar3;
        int i2;
        com.baidu.tieba.data.v vVar4;
        com.baidu.adp.a.g gVar2;
        this.b.a();
        if (b(vVar)) {
            gVar2 = this.f1976a.mLoadDataCallBack;
            gVar2.a(null);
        } else {
            i = this.f1976a.f;
            if (i != 1) {
                vVar3 = this.f1976a.d;
                if (vVar3 != null) {
                    i2 = this.f1976a.f;
                    if (i2 == 2) {
                        if (this.f1976a.a()) {
                            this.f1976a.d = vVar;
                        } else {
                            vVar4 = this.f1976a.d;
                            vVar4.a(vVar, true);
                        }
                    }
                    gVar = this.f1976a.mLoadDataCallBack;
                    vVar2 = this.f1976a.d;
                    gVar.a(vVar2);
                }
            }
            this.f1976a.d = vVar;
            gVar = this.f1976a.mLoadDataCallBack;
            vVar2 = this.f1976a.d;
            gVar.a(vVar2);
        }
        this.f1976a.g = 0;
    }

    private boolean b(com.baidu.tieba.data.v vVar) {
        if (vVar == null || this.b.e() != 0) {
            this.f1976a.setErrorCode(this.b.e());
            this.f1976a.setErrorString(this.b.f());
            return true;
        } else if (vVar != null && vVar.g() != 0) {
            this.f1976a.setErrorCode(vVar.g());
            this.f1976a.setErrorString(vVar.h());
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
