package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, aj> {
    int b;
    final /* synthetic */ TiebaMessageService c;

    /* renamed from: a  reason: collision with root package name */
    z f1796a = null;
    private TiebaApplication d = TiebaApplication.g();
    private String e = TiebaApplication.C();

    public m(TiebaMessageService tiebaMessageService, int i) {
        this.c = tiebaMessageService;
        this.b = 0;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public aj a(String... strArr) {
        aj ajVar;
        Exception e;
        try {
        } catch (Exception e2) {
            ajVar = null;
            e = e2;
        }
        if (this.d.ad() && this.e != null && this.e.length() > 0) {
            this.f1796a = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/msg");
            if (this.b == 2) {
                this.f1796a.a("bookmark", "1");
            }
            String j = this.f1796a.j();
            if (this.f1796a.c()) {
                ajVar = new aj();
                try {
                    ajVar.a(j);
                } catch (Exception e3) {
                    e = e3;
                    av.b(getClass().getName(), "doInBackground", e.getMessage());
                    return ajVar;
                }
            } else {
                ajVar = null;
            }
            return ajVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.c.f1780a = null;
        this.c.b = null;
        if (this.f1796a != null) {
            this.f1796a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(aj ajVar) {
        try {
            super.a((m) ajVar);
            this.c.f1780a = null;
            this.c.b = null;
            if (ajVar != null) {
                this.c.c = ajVar;
                if (this.b == 2) {
                    this.d.a((Boolean) false);
                }
                if (this.e != null && this.e.length() > 0) {
                    this.c.b(this.b);
                }
            }
        } catch (Exception e) {
            av.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
