package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f1361a;
    private volatile com.baidu.tieba.util.u b;

    private bx(bw bwVar) {
        this.f1361a = bwVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bx(bw bwVar, bx bxVar) {
        this(bwVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bg a(Object... objArr) {
        com.baidu.tieba.data.bg bgVar;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/c/forum/sign");
            com.baidu.tieba.util.u uVar = this.b;
            str = this.f1361a.f1360a;
            uVar.a("kw", str);
            com.baidu.tieba.util.u uVar2 = this.b;
            str2 = this.f1361a.b;
            uVar2.a("fid", str2);
            this.b.e(true);
            String k = this.b.k();
            if (!this.b.e() || !this.b.d()) {
                return null;
            }
            bgVar = new com.baidu.tieba.data.bg();
            try {
                bgVar.a(k);
                return bgVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
                return bgVar;
            }
        } catch (Exception e3) {
            bgVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.i();
        }
        this.f1361a.c = null;
        super.cancel(true);
        eVar = this.f1361a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bg bgVar) {
        com.baidu.adp.a.e eVar;
        this.f1361a.c = null;
        if (bgVar == null && this.b != null) {
            this.f1361a.mErrorCode = this.b.f();
            this.f1361a.mErrorString = this.b.h();
        }
        eVar = this.f1361a.mLoadDataCallBack;
        eVar.a(bgVar);
    }
}
