package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.data.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<String, Integer, ab> {
    int b;
    final /* synthetic */ TiebaMessageService c;
    ak a = null;
    private final TbadkApplication d = TbadkApplication.j();
    private final String e = TbadkApplication.E();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ab a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ab abVar) {
        ab abVar2 = abVar;
        try {
            super.a((m) abVar2);
            this.c.a = null;
            this.c.b = null;
            if (abVar2 != null) {
                this.c.c = abVar2;
                if (this.e == null || this.e.length() <= 0) {
                    return;
                }
                TiebaMessageService.c(this.c, this.b);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }

    public m(TiebaMessageService tiebaMessageService, int i) {
        this.c = tiebaMessageService;
        this.b = 0;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }

    private ab a() {
        ab abVar;
        Exception e;
        try {
            TbadkApplication tbadkApplication = this.d;
        } catch (Exception e2) {
            abVar = null;
            e = e2;
        }
        if (TbadkApplication.aG() && this.e != null && this.e.length() > 0) {
            this.a = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/msg");
            if (this.b == 2) {
                this.a.a("bookmark", "1");
            }
            String i = this.a.i();
            if (this.a.a().b().b()) {
                abVar = new ab();
                try {
                    abVar.a(i);
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                    return abVar;
                }
            } else {
                abVar = null;
            }
            return abVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.c.a = null;
        this.c.b = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }
}
