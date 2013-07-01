package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bi f1039a;
    private com.baidu.tieba.util.r b;

    private bj(bi biVar) {
        this.f1039a = biVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bj(bi biVar, bj bjVar) {
        this(biVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        try {
            int intValue = numArr[0].intValue();
            if (this.f1039a.c() != null) {
                this.b = new com.baidu.tieba.util.r();
                if (intValue == 0) {
                    this.b.a(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/user/follow");
                } else {
                    this.b.a(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.f1039a.c().getPortrait());
                this.b.d(true);
                this.b.j();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f1039a.m = null;
        if (this.b != null) {
            if (!this.b.c()) {
                this.f1039a.mLoadDataMode = 3;
                this.f1039a.setErrorString(this.b.g());
                eVar = this.f1039a.mLoadDataCallBack;
                eVar.a(false);
                return;
            }
            if (this.f1039a.c() != null) {
                if (this.f1039a.c().getHave_attention() == 1) {
                    this.f1039a.c().setHave_attention(0);
                } else {
                    this.f1039a.c().setHave_attention(1);
                }
            }
            this.f1039a.mLoadDataMode = 3;
            eVar2 = this.f1039a.mLoadDataCallBack;
            eVar2.a(true);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1039a.m = null;
        super.cancel(true);
        eVar = this.f1039a.mLoadDataCallBack;
        eVar.a(false);
    }
}
