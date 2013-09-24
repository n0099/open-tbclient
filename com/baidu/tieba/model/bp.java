package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1425a;
    private com.baidu.tieba.util.z b;

    private bp(bo boVar) {
        this.f1425a = boVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bp(bo boVar, bp bpVar) {
        this(boVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        try {
            int intValue = numArr[0].intValue();
            if (this.f1425a.c() != null) {
                this.b = new com.baidu.tieba.util.z();
                if (intValue == 0) {
                    this.b.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/user/follow");
                } else {
                    this.b.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.f1425a.c().getPortrait());
                this.b.e(true);
                this.b.j();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((bp) str);
        this.f1425a.n = null;
        if (this.b != null) {
            if (!this.b.c()) {
                this.f1425a.mLoadDataMode = 3;
                this.f1425a.setErrorString(this.b.g());
                eVar = this.f1425a.mLoadDataCallBack;
                eVar.a(false);
                return;
            }
            if (this.f1425a.c() != null) {
                if (this.f1425a.c().getHave_attention() == 1) {
                    this.f1425a.c().setHave_attention(0);
                } else {
                    this.f1425a.c().setHave_attention(1);
                }
            }
            this.f1425a.mLoadDataMode = 3;
            eVar2 = this.f1425a.mLoadDataCallBack;
            eVar2.a(true);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1425a.n = null;
        eVar = this.f1425a.mLoadDataCallBack;
        eVar.a(false);
    }
}
