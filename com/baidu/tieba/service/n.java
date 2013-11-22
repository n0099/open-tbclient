package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<String, Integer, aj> {
    int b;
    final /* synthetic */ TiebaMessageService c;

    /* renamed from: a  reason: collision with root package name */
    ap f2335a = null;
    private TiebaApplication d = TiebaApplication.g();
    private String e = TiebaApplication.A();

    public n(TiebaMessageService tiebaMessageService, int i) {
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
            this.f2335a = new ap(com.baidu.tieba.data.h.f1201a + "c/s/msg");
            if (this.b == 2) {
                this.f2335a.a("bookmark", SocialConstants.TRUE);
            }
            String l = this.f2335a.l();
            if (this.f2335a.c()) {
                ajVar = new aj();
                try {
                    ajVar.a(l);
                } catch (Exception e3) {
                    e = e3;
                    bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.c.f2319a = null;
        this.c.b = null;
        if (this.f2335a != null) {
            this.f2335a.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(aj ajVar) {
        try {
            super.a((n) ajVar);
            this.c.f2319a = null;
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
            bg.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
