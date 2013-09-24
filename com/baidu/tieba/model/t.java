package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Integer, com.baidu.tieba.data.w, com.baidu.tieba.data.w> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1456a;
    private com.baidu.tieba.a.g b = null;

    public t(s sVar) {
        this.f1456a = sVar;
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
        boolean z = true;
        try {
            if (this.b == null) {
                this.b = new com.baidu.tieba.a.g();
            }
            String num = numArr[0].toString();
            if (numArr.length <= 1) {
                z = false;
            } else if (numArr[1].intValue() != 1) {
                z = false;
            }
            if (z) {
                c((Object[]) new com.baidu.tieba.data.w[]{this.f1456a.h()});
            }
            String b = this.b.b(num);
            if (this.b.c() && b != null) {
                com.baidu.tieba.data.w wVar = new com.baidu.tieba.data.w();
                wVar.a(b);
                if (num.equals("1") && this.b.e() == 0 && wVar.f() == 0) {
                    a(b);
                    return wVar;
                }
                return wVar;
            }
        } catch (Exception e) {
            this.f1456a.g = 0;
            com.baidu.tieba.util.av.b(s.class.getName(), "GetForumFeedTask.doInBackground", e.getMessage().toString());
        }
        return null;
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.q<String> d;
        String C = TiebaApplication.C();
        if (C != null && (d = com.baidu.tieba.b.a.a().d()) != null) {
            d.a("home_forumfeed_" + C, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.w... wVarArr) {
        com.baidu.adp.a.e eVar;
        super.b((Object[]) wVarArr);
        u uVar = new u(this.f1456a);
        uVar.b = 3;
        uVar.f1457a = wVarArr.length > 0 ? wVarArr[0] : null;
        eVar = this.f1456a.mLoadDataCallBack;
        eVar.a(uVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.w wVar) {
        int i;
        com.baidu.adp.a.e eVar;
        com.baidu.tieba.data.w wVar2;
        com.baidu.tieba.data.w wVar3;
        int i2;
        com.baidu.tieba.data.w wVar4;
        com.baidu.adp.a.e eVar2;
        this.b.a();
        if (b(wVar)) {
            eVar2 = this.f1456a.mLoadDataCallBack;
            eVar2.a(null);
        } else {
            i = this.f1456a.f;
            if (i != 1) {
                wVar3 = this.f1456a.d;
                if (wVar3 != null) {
                    i2 = this.f1456a.f;
                    if (i2 == 2) {
                        if (this.f1456a.a()) {
                            this.f1456a.d = wVar;
                        } else {
                            wVar4 = this.f1456a.d;
                            wVar4.a(wVar, true);
                        }
                    }
                    eVar = this.f1456a.mLoadDataCallBack;
                    wVar2 = this.f1456a.d;
                    eVar.a(wVar2);
                }
            }
            this.f1456a.d = wVar;
            eVar = this.f1456a.mLoadDataCallBack;
            wVar2 = this.f1456a.d;
            eVar.a(wVar2);
        }
        this.f1456a.g = 0;
    }

    private boolean b(com.baidu.tieba.data.w wVar) {
        if (wVar == null || this.b.e() != 0) {
            this.f1456a.setErrorCode(this.b.e());
            this.f1456a.setErrorString(this.b.f());
            return true;
        } else if (wVar != null && wVar.f() != 0) {
            this.f1456a.setErrorCode(wVar.f());
            this.f1456a.setErrorString(wVar.g());
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
