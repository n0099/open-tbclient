package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends BdAsyncTask<String, Integer, bw> {
    com.baidu.tieba.util.ba a;
    final /* synthetic */ a b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ bw a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(bw bwVar) {
        bw bwVar2 = bwVar;
        super.a((b) bwVar2);
        this.b.b = null;
        this.b.a.a(bwVar2);
    }

    private b(a aVar) {
        this.b = aVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        super.b();
    }

    private bw d() {
        bw bwVar;
        Exception e;
        Context unused;
        try {
            this.a = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(BdUtilHelper.b(TiebaApplication.g().b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(BdUtilHelper.c(TiebaApplication.g().b())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().G() > 0) {
                this.a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.a.a("_msg_status", SocialConstants.TRUE);
            }
            String l = this.a.l();
            if (!this.a.c()) {
                return null;
            }
            bwVar = new bw();
            try {
                bwVar.a(l);
                if (TiebaApplication.E() == null && bwVar.d().a() != null && bwVar.d().a().length() > 0) {
                    unused = this.b.c;
                    TiebaApplication.m(bwVar.d().a());
                    TiebaApplication.n(bwVar.d().a());
                    return bwVar;
                }
                return bwVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return bwVar;
            }
        } catch (Exception e3) {
            bwVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.j();
        }
        super.cancel(true);
    }
}
