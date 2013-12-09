package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends BdAsyncTask<Boolean, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f2006a;
    private com.baidu.tieba.util.am b = null;
    private boolean c;
    private com.baidu.tieba.data.ay d;

    public bh(bg bgVar, boolean z) {
        this.f2006a = bgVar;
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
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/post/addstore");
            o oVar = new o();
            markData3 = this.f2006a.b;
            oVar.a(markData3);
            this.b.a("data", oVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/post/rmstore");
            com.baidu.tieba.util.am amVar = this.b;
            markData = this.f2006a.b;
            amVar.a(PushConstants.EXTRA_USER_ID, markData.getAccount());
            com.baidu.tieba.util.am amVar2 = this.b;
            markData2 = this.f2006a.b;
            amVar2.a("tid", markData2.getId());
        }
        this.d.a(this.b.l());
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
            this.b.j();
        }
        this.f2006a.c = null;
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
            biVar4 = this.f2006a.d;
            if (biVar4 != null) {
                biVar5 = this.f2006a.d;
                biVar5.a(true, this.c, null);
            }
        } else {
            biVar = this.f2006a.d;
            if (biVar != null) {
                if (this.b == null || this.b.c()) {
                    biVar2 = this.f2006a.d;
                    biVar2.a(false, this.c, this.d.b());
                } else {
                    biVar3 = this.f2006a.d;
                    biVar3.a(false, this.c, this.b.i());
                }
            }
        }
        this.f2006a.c = null;
    }
}
