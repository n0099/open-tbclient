package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, ch> {
    com.baidu.tieba.util.an a;
    final /* synthetic */ a b;

    private c(a aVar) {
        this.b = aVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ch a(String... strArr) {
        ch chVar;
        Exception e;
        Context context;
        try {
            this.a = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.b(TiebaApplication.h())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.c(TiebaApplication.h())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.h().N() > 0) {
                this.a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.a.a("_msg_status", SocialConstants.TRUE);
            }
            String l = this.a.l();
            if (!this.a.c()) {
                return null;
            }
            chVar = new ch();
            try {
                chVar.a(l);
                if (TiebaApplication.L() == null && chVar.d().a() != null && chVar.d().a().length() > 0) {
                    context = this.b.c;
                    TiebaApplication.a(context, chVar.d().a());
                    TiebaApplication.o(chVar.d().a());
                    return chVar;
                }
                return chVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
                return chVar;
            }
        } catch (Exception e3) {
            chVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ch chVar) {
        super.a((c) chVar);
        this.b.b = null;
        this.b.a.a(chVar);
    }
}
