package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, ai> {
    int b;
    final /* synthetic */ TiebaMessageService c;
    ba a = null;
    private TiebaApplication d = TiebaApplication.g();
    private String e = TiebaApplication.A();

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
    public ai a(String... strArr) {
        ai aiVar;
        Exception e;
        try {
        } catch (Exception e2) {
            aiVar = null;
            e = e2;
        }
        if (this.d.Z() && this.e != null && this.e.length() > 0) {
            this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/msg");
            if (this.b == 2) {
                this.a.a("bookmark", SocialConstants.TRUE);
            }
            String m = this.a.m();
            if (this.a.d()) {
                aiVar = new ai();
                try {
                    aiVar.a(m);
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                    return aiVar;
                }
            } else {
                aiVar = null;
            }
            return aiVar;
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
    public void a(ai aiVar) {
        try {
            super.a((m) aiVar);
            this.c.a = null;
            this.c.b = null;
            if (aiVar != null) {
                this.c.c = aiVar;
                if (this.e != null && this.e.length() > 0) {
                    this.c.b(this.b);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
