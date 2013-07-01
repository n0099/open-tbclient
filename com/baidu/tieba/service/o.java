package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.af;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.r f1417a = null;
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
    public af a(String... strArr) {
        af afVar;
        Exception e;
        try {
        } catch (Exception e2) {
            afVar = null;
            e = e2;
        }
        if (TiebaApplication.f().aa()) {
            this.f1417a = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/msg");
            String j = this.f1417a.j();
            if (this.f1417a.c()) {
                afVar = new af();
                try {
                    afVar.a(j);
                } catch (Exception e3) {
                    e = e3;
                    z.b(getClass().getName(), "doInBackground", e.getMessage());
                    return afVar;
                }
            } else {
                afVar = null;
            }
            return afVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1400a = null;
        if (this.f1417a != null) {
            this.f1417a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(af afVar) {
        try {
            super.a((Object) afVar);
            this.b.f1400a = null;
            if (afVar != null) {
                this.b.b = afVar;
                this.b.b();
            }
        } catch (Exception e) {
            z.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
