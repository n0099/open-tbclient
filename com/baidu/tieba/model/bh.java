package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends BdAsyncTask<Boolean, Integer, Boolean> {
    final /* synthetic */ bg a;
    private com.baidu.tieba.util.ax b = null;
    private boolean c;
    private com.baidu.tieba.data.ba d;

    public bh(bg bgVar, boolean z) {
        this.a = bgVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.data.ba();
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
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/c/post/addstore");
            o oVar = new o();
            markData3 = this.a.b;
            oVar.a(markData3);
            this.b.a("data", oVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/c/post/rmstore");
            com.baidu.tieba.util.ax axVar = this.b;
            markData = this.a.b;
            axVar.a(PushConstants.EXTRA_USER_ID, markData.getAccount());
            com.baidu.tieba.util.ax axVar2 = this.b;
            markData2 = this.a.b;
            axVar2.a("tid", markData2.getId());
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
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        if (bool.booleanValue()) {
            biVar4 = this.a.d;
            if (biVar4 != null) {
                biVar5 = this.a.d;
                biVar5.a(true, this.c, null);
            }
        } else {
            biVar = this.a.d;
            if (biVar != null) {
                if (this.b == null || this.b.d()) {
                    biVar2 = this.a.d;
                    biVar2.a(false, this.c, this.d.b());
                } else {
                    biVar3 = this.a.d;
                    biVar3.a(false, this.c, this.b.j());
                }
            }
        }
        this.a.c = null;
    }
}
