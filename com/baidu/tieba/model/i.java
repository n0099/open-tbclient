package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1407a;
    private com.baidu.tieba.util.v b;
    private com.baidu.tieba.data.bg c;

    private i(f fVar) {
        this.f1407a = fVar;
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
        this.c = new com.baidu.tieba.data.bg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(f... fVarArr) {
        f fVar = new f();
        try {
            fVar.f();
            this.b = new com.baidu.tieba.util.v();
            this.b.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/post/addstore");
            int h = this.f1407a.h();
            if (fVar.d() - 1 <= h) {
                h = fVar.d() - 1;
            }
            while (h >= 0) {
                String a2 = fVar.a(h, 20);
                this.b.a(new ArrayList());
                this.b.a("data", a2);
                this.c.a(this.b.j());
                if (!this.b.c() || this.c.a() != 0) {
                    break;
                }
                h -= 20;
            }
            this.f1407a.c(h);
            if (h >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1407a.c = null;
        if (this.f1407a.f1404a != null) {
            this.f1407a.f1404a.a(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.f1407a.c = null;
        if (bool.booleanValue()) {
            arrayList = this.f1407a.e;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.b.c()) {
            str = this.c.b();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.f1407a.f1404a != null) {
            this.f1407a.f1404a.a(1, bool, str, Boolean.valueOf(z));
        }
    }
}
