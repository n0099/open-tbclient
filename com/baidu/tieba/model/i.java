package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1371a;
    private com.baidu.tieba.util.u b;
    private com.baidu.tieba.data.bk c;

    private i(f fVar) {
        this.f1371a = fVar;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(f fVar, i iVar) {
        this(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.c = new com.baidu.tieba.data.bk();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(f... fVarArr) {
        f fVar = new f();
        try {
            fVar.e();
            this.b = new com.baidu.tieba.util.u();
            this.b.a(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/c/post/addstore");
            int h = this.f1371a.h();
            if (fVar.c() - 1 <= h) {
                h = fVar.c() - 1;
            }
            while (h >= 0) {
                String a2 = fVar.a(h, 20);
                this.b.a(new ArrayList());
                this.b.a("data", a2);
                this.c.a(this.b.k());
                if (!this.b.d() || this.c.a() != 0) {
                    break;
                }
                h -= 20;
            }
            this.f1371a.b(h);
            if (h >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
        }
        this.f1371a.c = null;
        if (this.f1371a.f1368a != null) {
            this.f1371a.f1368a.a(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.f1371a.c = null;
        if (bool.booleanValue()) {
            arrayList = this.f1371a.e;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.b.d()) {
            str = this.c.b();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.f1371a.f1368a != null) {
            this.f1371a.f1368a.a(1, bool, str, Boolean.valueOf(z));
        }
    }
}
