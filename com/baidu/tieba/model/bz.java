package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f1906a;
    private com.baidu.tieba.util.ap b;

    private bz(bx bxVar) {
        this.f1906a = bxVar;
        this.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        try {
            int intValue = numArr[0].intValue();
            if (this.f1906a.d() != null) {
                this.b = new com.baidu.tieba.util.ap();
                if (intValue == 0) {
                    this.b.a(com.baidu.tieba.data.h.f1201a + "c/c/user/follow");
                } else {
                    this.b.a(com.baidu.tieba.data.h.f1201a + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.f1906a.d().getPortrait());
                this.b.e(true);
                this.b.j();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((bz) str);
        this.f1906a.o = null;
        if (this.b != null) {
            if (!this.b.c()) {
                this.f1906a.mLoadDataMode = 3;
                this.f1906a.setErrorString(this.b.g());
                gVar = this.f1906a.mLoadDataCallBack;
                gVar.a(false);
                return;
            }
            if (this.f1906a.d() != null) {
                if (this.f1906a.d().getHave_attention() == 1) {
                    this.f1906a.d().setHave_attention(0);
                } else {
                    this.f1906a.d().setHave_attention(1);
                }
            }
            this.f1906a.mLoadDataMode = 3;
            gVar2 = this.f1906a.mLoadDataCallBack;
            gVar2.a(true);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1906a.o = null;
        gVar = this.f1906a.mLoadDataCallBack;
        gVar.a(false);
    }
}
