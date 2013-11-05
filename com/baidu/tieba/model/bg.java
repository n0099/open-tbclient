package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends BdAsyncTask<Boolean, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bf f1915a;
    private com.baidu.tieba.util.ag b = null;
    private boolean c;
    private com.baidu.tieba.data.be d;

    public bg(bf bfVar, boolean z) {
        this.f1915a = bfVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.data.be();
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
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/post/addstore");
            o oVar = new o();
            markData3 = this.f1915a.b;
            oVar.a(markData3);
            this.b.a("data", oVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/post/rmstore");
            com.baidu.tieba.util.ag agVar = this.b;
            markData = this.f1915a.b;
            agVar.a(PushConstants.EXTRA_USER_ID, markData.getAccount());
            com.baidu.tieba.util.ag agVar2 = this.b;
            markData2 = this.f1915a.b;
            agVar2.a("tid", markData2.getId());
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
        this.f1915a.c = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        if (bool.booleanValue()) {
            bhVar4 = this.f1915a.d;
            if (bhVar4 != null) {
                bhVar5 = this.f1915a.d;
                bhVar5.a(true, this.c, null);
            }
        } else {
            bhVar = this.f1915a.d;
            if (bhVar != null) {
                if (this.b == null || this.b.c()) {
                    bhVar2 = this.f1915a.d;
                    bhVar2.a(false, this.c, this.d.b());
                } else {
                    bhVar3 = this.f1915a.d;
                    bhVar3.a(false, this.c, this.b.g());
                }
            }
        }
        this.f1915a.c = null;
    }
}
