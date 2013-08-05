package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1356a;
    private com.baidu.tieba.util.u b;

    private bo(bn bnVar) {
        this.f1356a = bnVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bo(bn bnVar, bo boVar) {
        this(bnVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        try {
            int intValue = numArr[0].intValue();
            if (this.f1356a.c() != null) {
                this.b = new com.baidu.tieba.util.u();
                if (intValue == 0) {
                    this.b.a(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/user/follow");
                } else {
                    this.b.a(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.f1356a.c().getPortrait());
                this.b.e(true);
                this.b.k();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) str);
        this.f1356a.m = null;
        if (this.b != null) {
            if (!this.b.d()) {
                this.f1356a.mLoadDataMode = 3;
                this.f1356a.setErrorString(this.b.h());
                eVar = this.f1356a.mLoadDataCallBack;
                eVar.a(false);
                return;
            }
            if (this.f1356a.c() != null) {
                if (this.f1356a.c().getHave_attention() == 1) {
                    this.f1356a.c().setHave_attention(0);
                } else {
                    this.f1356a.c().setHave_attention(1);
                }
            }
            this.f1356a.mLoadDataMode = 3;
            eVar2 = this.f1356a.mLoadDataCallBack;
            eVar2.a(true);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1356a.m = null;
        eVar = this.f1356a.mLoadDataCallBack;
        eVar.a(false);
    }
}
