package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.r> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f2047a;
    private com.baidu.tieba.a.f b = null;
    private int c;

    public v(t tVar, int i) {
        this.f2047a = tVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.r a(Object... objArr) {
        boolean z;
        com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
        this.b = new com.baidu.tieba.a.f();
        z = this.f2047a.c;
        if (!z) {
            rVar.a(true);
            return rVar;
        }
        int i = this.c;
        if (i == 0) {
            return e();
        }
        if (i == 1) {
            if (UtilHelper.g(TiebaApplication.h().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                return d();
            }
            return e();
        }
        return rVar;
    }

    private com.baidu.tieba.data.r d() {
        com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
        String g = this.b.g();
        if (this.b.c()) {
            rVar.a(g);
            a(g);
        }
        return rVar;
    }

    private com.baidu.tieba.data.r e() {
        boolean z;
        com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
        String str = null;
        z = this.f2047a.c;
        if (z) {
            str = DatabaseService.d();
        }
        if (str != null) {
            rVar.a(str);
            if (rVar.e() && !rVar.f()) {
                rVar.d().c();
            }
        }
        return rVar;
    }

    private void a(String str) {
        boolean z;
        z = this.f2047a.c;
        if (z) {
            DatabaseService.d(str);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f2047a.f2045a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.r rVar) {
        w wVar;
        w wVar2;
        com.baidu.tieba.data.r rVar2;
        w wVar3;
        com.baidu.tieba.data.r rVar3;
        w wVar4;
        this.f2047a.f2045a = null;
        this.f2047a.b = rVar;
        u uVar = new u(this.f2047a);
        uVar.c = this.c;
        wVar = this.f2047a.d;
        if (wVar != null) {
            if (this.c != 0 && (this.b == null || !this.b.c())) {
                rVar2 = this.f2047a.b;
                if (rVar2 != null) {
                    rVar3 = this.f2047a.b;
                    if (rVar3.e()) {
                        uVar.b = true;
                        uVar.d = rVar;
                        wVar4 = this.f2047a.d;
                        wVar4.a(uVar);
                        return;
                    }
                }
                String d = this.b != null ? this.b.d() : null;
                uVar.b = false;
                uVar.f2046a = d;
                uVar.d = rVar;
                wVar3 = this.f2047a.d;
                wVar3.a(uVar);
                return;
            }
            uVar.b = true;
            uVar.d = rVar;
            wVar2 = this.f2047a.d;
            wVar2.a(uVar);
        }
    }
}
