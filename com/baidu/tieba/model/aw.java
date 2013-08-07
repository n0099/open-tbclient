package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ av f1339a;
    private com.baidu.tieba.util.u b = null;
    private boolean c;
    private com.baidu.tieba.data.bk d;

    public aw(av avVar, boolean z) {
        this.f1339a = avVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.data.bk();
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
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/c/post/addstore");
            f fVar = new f();
            markData3 = this.f1339a.b;
            fVar.a(markData3);
            this.b.a("data", fVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/c/post/rmstore");
            com.baidu.tieba.util.u uVar = this.b;
            markData = this.f1339a.b;
            uVar.a(PushConstants.EXTRA_USER_ID, markData.getAccount());
            com.baidu.tieba.util.u uVar2 = this.b;
            markData2 = this.f1339a.b;
            uVar2.a("tid", markData2.getId());
        }
        this.d.a(this.b.k());
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
            this.b.i();
        }
        this.f1339a.c = null;
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
        if (bool.booleanValue()) {
            axVar4 = this.f1339a.d;
            if (axVar4 != null) {
                axVar5 = this.f1339a.d;
                axVar5.a(true, this.c, null);
            }
        } else {
            axVar = this.f1339a.d;
            if (axVar != null) {
                if (this.b == null || this.b.d()) {
                    axVar2 = this.f1339a.d;
                    axVar2.a(false, this.c, this.d.b());
                } else {
                    axVar3 = this.f1339a.d;
                    axVar3.a(false, this.c, this.b.h());
                }
            }
        }
        this.f1339a.c = null;
    }
}
