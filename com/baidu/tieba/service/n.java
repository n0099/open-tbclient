package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<String, Integer, ak> {
    int b;
    final /* synthetic */ TiebaMessageService c;

    /* renamed from: a  reason: collision with root package name */
    ap f2350a = null;
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
    public ak a(String... strArr) {
        ak akVar;
        Exception e;
        try {
        } catch (Exception e2) {
            akVar = null;
            e = e2;
        }
        if (this.d.ad() && this.e != null && this.e.length() > 0) {
            this.f2350a = new ap(com.baidu.tieba.data.h.f1196a + "c/s/msg");
            if (this.b == 2) {
                this.f2350a.a("bookmark", SocialConstants.TRUE);
            }
            String j = this.f2350a.j();
            if (this.f2350a.c()) {
                akVar = new ak();
                try {
                    akVar.a(j);
                } catch (Exception e3) {
                    e = e3;
                    bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.c.f2334a = null;
        this.c.b = null;
        if (this.f2350a != null) {
            this.f2350a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ak akVar) {
        try {
            super.a((n) akVar);
            this.c.f2334a = null;
            this.c.b = null;
            if (akVar != null) {
                this.c.c = akVar;
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
