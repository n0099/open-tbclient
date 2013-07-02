package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask {
    final /* synthetic */ am a;
    private com.baidu.tieba.util.r b = null;
    private boolean c;
    private com.baidu.tieba.data.ay d;

    public an(am amVar, boolean z) {
        this.a = amVar;
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
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/post/addstore");
            f fVar = new f();
            markData3 = this.a.b;
            fVar.a(markData3);
            this.b.a("data", fVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/post/rmstore");
            com.baidu.tieba.util.r rVar = this.b;
            markData = this.a.b;
            rVar.a(PushConstants.EXTRA_USER_ID, markData.getAccount());
            com.baidu.tieba.util.r rVar2 = this.b;
            markData2 = this.a.b;
            rVar2.a("tid", markData2.getId());
        }
        this.d.a(this.b.j());
        boolean z = this.d.a() == 0;
        if (this.b.c() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.a.c = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        ao aoVar4;
        ao aoVar5;
        if (bool.booleanValue()) {
            aoVar4 = this.a.d;
            if (aoVar4 != null) {
                aoVar5 = this.a.d;
                aoVar5.a(true, this.c, null);
            }
        } else {
            aoVar = this.a.d;
            if (aoVar != null) {
                if (this.b == null || this.b.c()) {
                    aoVar2 = this.a.d;
                    aoVar2.a(false, this.c, this.d.b());
                } else {
                    aoVar3 = this.a.d;
                    aoVar3.a(false, this.c, this.b.g());
                }
            }
        }
        this.a.c = null;
    }
}
