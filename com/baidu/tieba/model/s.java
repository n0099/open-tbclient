package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<o, Integer, Boolean> {
    final /* synthetic */ o a;
    private com.baidu.tieba.util.an b;
    private com.baidu.tieba.data.ay c;

    private s(o oVar) {
        this.a = oVar;
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
            this.b = new com.baidu.tieba.util.an();
            this.b.a(com.baidu.tieba.data.h.a + "c/c/post/addstore");
            int h = this.a.h();
            if (oVar.d() - 1 <= h) {
                h = oVar.d() - 1;
            }
            while (h >= 0) {
                String a = oVar.a(h, 20);
                this.b.a(new ArrayList<>());
                this.b.a("data", a);
                this.c.a(this.b.l());
                if (!this.b.c() || this.c.a() != 0) {
                    break;
                }
                h -= 20;
            }
            this.a.c(h);
            if (h >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.a.c = null;
        if (this.a.a != null) {
            this.a.a.a(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.a.c = null;
        if (bool.booleanValue()) {
            arrayList = this.a.e;
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
        if (this.a.a != null) {
            this.a.a.a(1, bool, str, Boolean.valueOf(z));
        }
    }
}
