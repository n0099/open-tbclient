package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<o, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1932a;
    private com.baidu.tieba.util.ap b;
    private com.baidu.tieba.data.ay c;

    private s(o oVar) {
        this.f1932a = oVar;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.c = new com.baidu.tieba.data.ay();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(o... oVarArr) {
        o oVar = new o();
        try {
            oVar.f();
            this.b = new com.baidu.tieba.util.ap();
            this.b.a(com.baidu.tieba.data.h.f1201a + "c/c/post/addstore");
            int h = this.f1932a.h();
            if (oVar.d() - 1 <= h) {
                h = oVar.d() - 1;
            }
            while (h >= 0) {
                String a2 = oVar.a(h, 20);
                this.b.a(new ArrayList<>());
                this.b.a("data", a2);
                this.c.a(this.b.l());
                if (!this.b.c() || this.c.a() != 0) {
                    break;
                }
                h -= 20;
            }
            this.f1932a.c(h);
            if (h >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.f1932a.c = null;
        if (this.f1932a.f1929a != null) {
            this.f1932a.f1929a.a(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.f1932a.c = null;
        if (bool.booleanValue()) {
            arrayList = this.f1932a.e;
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
        if (this.f1932a.f1929a != null) {
            this.f1932a.f1929a.a(1, bool, str, Boolean.valueOf(z));
        }
    }
}
