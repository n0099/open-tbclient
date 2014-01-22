package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<String, Integer, ak> {
    int b;
    final /* synthetic */ TiebaMessageService c;
    ax a = null;
    private TiebaApplication d = TiebaApplication.h();
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
    public ak a(String... strArr) {
        ak akVar;
        Exception e;
        try {
        } catch (Exception e2) {
            akVar = null;
            e = e2;
        }
        if (this.d.aa() && this.e != null && this.e.length() > 0) {
            this.a = new ax(com.baidu.tieba.data.h.a + "c/s/msg");
            if (this.b == 2) {
                this.a.a("bookmark", SocialConstants.TRUE);
            }
            String m = this.a.m();
            if (this.a.d()) {
                akVar = new ak();
                try {
                    akVar.a(m);
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
                    return akVar;
                }
            } else {
                akVar = null;
            }
            return akVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.c.a = null;
        this.c.b = null;
        if (this.a != null) {
            this.a.k();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ak akVar) {
        try {
            super.a((n) akVar);
            this.c.a = null;
            this.c.b = null;
            if (akVar != null) {
                this.c.c = akVar;
                if (this.e != null && this.e.length() > 0) {
                    this.c.b(this.b);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
