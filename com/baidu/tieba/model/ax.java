package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Boolean, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aw f1410a;
    private com.baidu.tieba.util.z b = null;
    private boolean c;
    private com.baidu.tieba.data.bg d;

    public ax(aw awVar, boolean z) {
        this.f1410a = awVar;
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
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/post/addstore");
            h hVar = new h();
            markData3 = this.f1410a.b;
            hVar.a(markData3);
            this.b.a("data", hVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/post/rmstore");
            com.baidu.tieba.util.z zVar = this.b;
            markData = this.f1410a.b;
            zVar.a(PushConstants.EXTRA_USER_ID, markData.getAccount());
            com.baidu.tieba.util.z zVar2 = this.b;
            markData2 = this.f1410a.b;
            zVar2.a("tid", markData2.getId());
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
        this.f1410a.c = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        ay ayVar4;
        ay ayVar5;
        if (bool.booleanValue()) {
            ayVar4 = this.f1410a.d;
            if (ayVar4 != null) {
                ayVar5 = this.f1410a.d;
                ayVar5.a(true, this.c, null);
            }
        } else {
            ayVar = this.f1410a.d;
            if (ayVar != null) {
                if (this.b == null || this.b.c()) {
                    ayVar2 = this.f1410a.d;
                    ayVar2.a(false, this.c, this.d.b());
                } else {
                    ayVar3 = this.f1410a.d;
                    ayVar3.a(false, this.c, this.b.g());
                }
            }
        }
        this.f1410a.c = null;
    }
}
