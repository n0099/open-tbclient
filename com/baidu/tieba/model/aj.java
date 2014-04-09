package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aj extends BdAsyncTask<Boolean, Integer, Boolean> {
    final /* synthetic */ ai a;
    private com.baidu.tbadk.core.util.ak b = null;
    private boolean c;
    private com.baidu.tieba.data.ap d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(Boolean... boolArr) {
        MarkData markData;
        MarkData markData2;
        MarkData markData3;
        if (this.c) {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/post/addstore");
            k kVar = new k();
            markData3 = this.a.b;
            kVar.a(markData3);
            this.b.a("data", kVar.a(0, 1));
        } else {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/post/rmstore");
            com.baidu.tbadk.core.util.ak akVar = this.b;
            markData = this.a.b;
            akVar.a("user_id", markData.getAccount());
            com.baidu.tbadk.core.util.ak akVar2 = this.b;
            markData2 = this.a.b;
            akVar2.a("tid", markData2.getId());
        }
        this.d.a(this.b.i());
        return this.b.a().b().b() && (this.d.a() == 0);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        try {
            if (bool.booleanValue()) {
                akVar4 = this.a.d;
                if (akVar4 != null) {
                    akVar5 = this.a.d;
                    akVar5.a(true, this.c);
                }
            } else {
                akVar = this.a.d;
                if (akVar != null) {
                    if (this.b == null || this.b.a().b().b()) {
                        akVar2 = this.a.d;
                        boolean z = this.c;
                        this.d.b();
                        akVar2.a(false, z);
                    } else {
                        akVar3 = this.a.d;
                        boolean z2 = this.c;
                        this.b.f();
                        akVar3.a(false, z2);
                    }
                }
            }
            this.a.c = null;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.toString());
        }
    }

    public aj(ai aiVar, boolean z) {
        this.a = aiVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.data.ap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
    }
}
