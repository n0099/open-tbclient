package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.an;
import com.baidu.tieba.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.u f1709a = null;
    final /* synthetic */ TiebaMessageService b;

    public o(TiebaMessageService tiebaMessageService) {
        this.b = tiebaMessageService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public an a(String... strArr) {
        an anVar;
        Exception e;
        try {
        } catch (Exception e2) {
            anVar = null;
            e = e2;
        }
        if (TiebaApplication.f().ab()) {
            this.f1709a = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/msg");
            String k = this.f1709a.k();
            if (this.f1709a.d()) {
                anVar = new an();
                try {
                    anVar.a(k);
                } catch (Exception e3) {
                    e = e3;
                    aj.b(getClass().getName(), "doInBackground", e.getMessage());
                    return anVar;
                }
            } else {
                anVar = null;
            }
            return anVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1691a = null;
        if (this.f1709a != null) {
            this.f1709a.i();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(an anVar) {
        try {
            super.a((Object) anVar);
            this.b.f1691a = null;
            if (anVar != null) {
                this.b.b = anVar;
                this.b.b();
            }
        } catch (Exception e) {
            aj.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
