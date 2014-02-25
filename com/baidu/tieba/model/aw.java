package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<Boolean, Integer, Boolean> {
    final /* synthetic */ av a;
    private com.baidu.tieba.util.ba b = null;
    private boolean c;
    private com.baidu.tieba.data.ay d;

    public aw(av avVar, boolean z) {
        this.a = avVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.data.ay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(Boolean... boolArr) {
        MarkData markData;
        MarkData markData2;
        MarkData markData3;
        if (this.c) {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/addstore");
            g gVar = new g();
            markData3 = this.a.b;
            gVar.a(markData3);
            this.b.a("data", gVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/rmstore");
            com.baidu.tieba.util.ba baVar = this.b;
            markData = this.a.b;
            baVar.a(PushConstants.EXTRA_USER_ID, markData.getAccount());
            com.baidu.tieba.util.ba baVar2 = this.b;
            markData2 = this.a.b;
            baVar2.a("tid", markData2.getId());
        }
        this.d.a(this.b.m());
        boolean z = this.d.a() == 0;
        if (this.b.d() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.k();
        }
        this.a.c = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        try {
            if (bool.booleanValue()) {
                axVar4 = this.a.d;
                if (axVar4 != null) {
                    axVar5 = this.a.d;
                    axVar5.a(true, this.c, null);
                }
            } else {
                axVar = this.a.d;
                if (axVar != null) {
                    if (this.b == null || this.b.d()) {
                        axVar2 = this.a.d;
                        axVar2.a(false, this.c, this.d.b());
                    } else {
                        axVar3 = this.a.d;
                        axVar3.a(false, this.c, this.b.j());
                    }
                }
            }
            this.a.c = null;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.toString());
        }
    }
}
