package com.baidu.tieba.service;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ah;
import com.baidu.tieba.d.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.d.t a = null;
    final /* synthetic */ TiebaMessageService b;

    public o(TiebaMessageService tiebaMessageService) {
        this.b = tiebaMessageService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public ah a(String... strArr) {
        ah ahVar;
        Exception e;
        try {
        } catch (Exception e2) {
            ahVar = null;
            e = e2;
        }
        if (TiebaApplication.e().Z()) {
            this.a = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/msg");
            String i = this.a.i();
            if (this.a.b()) {
                ahVar = new ah();
                try {
                    ahVar.a(i);
                } catch (Exception e3) {
                    e = e3;
                    ae.b(getClass().getName(), "doInBackground", e.getMessage());
                    return ahVar;
                }
            } else {
                ahVar = null;
            }
            return ahVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.b.a = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(ah ahVar) {
        try {
            super.a((Object) ahVar);
            this.b.a = null;
            if (ahVar != null) {
                this.b.b = ahVar;
                this.b.b();
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
