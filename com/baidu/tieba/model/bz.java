package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f2018a;
    private com.baidu.tieba.util.am b;

    private bz(bx bxVar) {
        this.f2018a = bxVar;
        this.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        try {
            int intValue = numArr[0].intValue();
            if (this.f2018a.d() != null) {
                this.b = new com.baidu.tieba.util.am();
                if (intValue == 0) {
                    this.b.a(com.baidu.tieba.data.h.f1248a + "c/c/user/follow");
                } else {
                    this.b.a(com.baidu.tieba.data.h.f1248a + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.f2018a.d().getPortrait());
                this.b.e(true);
                this.b.l();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f2018a.o = null;
        if (this.b != null) {
            if (!this.b.c()) {
                this.f2018a.mLoadDataMode = 3;
                this.f2018a.setErrorString(this.b.i());
                gVar = this.f2018a.mLoadDataCallBack;
                gVar.a(false);
                return;
            }
            if (this.f2018a.d() != null) {
                if (this.f2018a.d().getHave_attention() == 1) {
                    this.f2018a.d().setHave_attention(0);
                } else {
                    this.f2018a.d().setHave_attention(1);
                }
            }
            this.f2018a.mLoadDataMode = 3;
            gVar2 = this.f2018a.mLoadDataCallBack;
            gVar2.a(true);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.f2018a.o = null;
        gVar = this.f2018a.mLoadDataCallBack;
        gVar.a(false);
    }
}
