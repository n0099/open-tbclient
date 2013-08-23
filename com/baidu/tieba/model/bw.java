package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bv f1395a;
    private volatile com.baidu.tieba.util.v b;

    private bw(bv bvVar) {
        this.f1395a = bvVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bw(bv bvVar, bw bwVar) {
        this(bvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bb a(Object... objArr) {
        com.baidu.tieba.data.bb bbVar;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/forum/sign");
            com.baidu.tieba.util.v vVar = this.b;
            str = this.f1395a.f1394a;
            vVar.a("kw", str);
            com.baidu.tieba.util.v vVar2 = this.b;
            str2 = this.f1395a.b;
            vVar2.a("fid", str2);
            this.b.e(true);
            String j = this.b.j();
            if (!this.b.d() || !this.b.c()) {
                return null;
            }
            bbVar = new com.baidu.tieba.data.bb();
            try {
                bbVar.a(j);
                return bbVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
                return bbVar;
            }
        } catch (Exception e3) {
            bbVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1395a.c = null;
        super.cancel(true);
        eVar = this.f1395a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bb bbVar) {
        com.baidu.adp.a.e eVar;
        this.f1395a.c = null;
        if (bbVar == null && this.b != null) {
            this.f1395a.mErrorCode = this.b.e();
            this.f1395a.mErrorString = this.b.g();
        }
        eVar = this.f1395a.mLoadDataCallBack;
        eVar.a(bbVar);
    }
}
