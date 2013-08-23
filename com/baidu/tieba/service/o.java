package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.v f1724a = null;
    int b;
    final /* synthetic */ TiebaMessageService c;

    public o(TiebaMessageService tiebaMessageService, int i) {
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
        if (TiebaApplication.g().ab()) {
            this.f1724a = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/msg");
            if (this.b == 2) {
                this.f1724a.a("bookmark", "1");
            }
            String j = this.f1724a.j();
            if (this.f1724a.c()) {
                ajVar = new aj();
                try {
                    ajVar.a(j);
                } catch (Exception e3) {
                    e = e3;
                    aq.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.c.f1706a = null;
        this.c.b = null;
        if (this.f1724a != null) {
            this.f1724a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(aj ajVar) {
        try {
            super.a((Object) ajVar);
            this.c.f1706a = null;
            this.c.b = null;
            if (ajVar != null) {
                this.c.c = ajVar;
                if (this.b == 2) {
                    TiebaApplication.g().a((Boolean) false);
                }
                this.c.b(this.b);
            }
        } catch (Exception e) {
            aq.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
