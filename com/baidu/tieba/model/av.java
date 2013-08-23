package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ au f1373a;
    private com.baidu.tieba.util.v b = null;
    private boolean c;
    private com.baidu.tieba.data.bg d;

    public av(au auVar, boolean z) {
        this.f1373a = auVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.data.bg();
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
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/post/addstore");
            f fVar = new f();
            markData3 = this.f1373a.b;
            fVar.a(markData3);
            this.b.a("data", fVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/post/rmstore");
            com.baidu.tieba.util.v vVar = this.b;
            markData = this.f1373a.b;
            vVar.a(PushConstants.EXTRA_USER_ID, markData.getAccount());
            com.baidu.tieba.util.v vVar2 = this.b;
            markData2 = this.f1373a.b;
            vVar2.a("tid", markData2.getId());
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
        this.f1373a.c = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        aw awVar5;
        if (bool.booleanValue()) {
            awVar4 = this.f1373a.d;
            if (awVar4 != null) {
                awVar5 = this.f1373a.d;
                awVar5.a(true, this.c, null);
            }
        } else {
            awVar = this.f1373a.d;
            if (awVar != null) {
                if (this.b == null || this.b.c()) {
                    awVar2 = this.f1373a.d;
                    awVar2.a(false, this.c, this.d.b());
                } else {
                    awVar3 = this.f1373a.d;
                    awVar3.a(false, this.c, this.b.g());
                }
            }
        }
        this.f1373a.c = null;
    }
}
