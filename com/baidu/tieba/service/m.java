package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<String, Integer, ai> {
    int b;
    final /* synthetic */ TiebaMessageService c;
    ba a = null;
    private TiebaApplication d = TiebaApplication.g();
    private String e = TiebaApplication.v();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ ai a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ai aiVar) {
        ai aiVar2 = aiVar;
        try {
            super.a((m) aiVar2);
            this.c.a = null;
            this.c.b = null;
            if (aiVar2 != null) {
                this.c.c = aiVar2;
                if (this.e == null || this.e.length() <= 0) {
                    return;
                }
                TiebaMessageService.c(this.c, this.b);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }

    public m(TiebaMessageService tiebaMessageService, int i) {
        this.c = tiebaMessageService;
        this.b = 0;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        super.b();
    }

    private ai d() {
        ai aiVar;
        Exception e;
        try {
        } catch (Exception e2) {
            aiVar = null;
            e = e2;
        }
        if (this.d.T() && this.e != null && this.e.length() > 0) {
            this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/msg");
            if (this.b == 2) {
                this.a.a("bookmark", SocialConstants.TRUE);
            }
            String l = this.a.l();
            if (this.a.c()) {
                aiVar = new ai();
                try {
                    aiVar.a(l);
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
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
    public final void cancel() {
        this.c.a = null;
        this.c.b = null;
        if (this.a != null) {
            this.a.j();
        }
        super.cancel(true);
    }
}
