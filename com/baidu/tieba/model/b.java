package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, bw> {
    com.baidu.tieba.util.ba a;
    final /* synthetic */ a b;

    private b(a aVar) {
        this.b = aVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, b bVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bw a(String... strArr) {
        bw bwVar;
        Exception e;
        Context context;
        try {
            this.a = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(BdUtilHelper.b(TiebaApplication.g().b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(BdUtilHelper.c(TiebaApplication.g().b())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().M() > 0) {
                this.a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.a.a("_msg_status", SocialConstants.TRUE);
            }
            String m = this.a.m();
            if (!this.a.d()) {
                return null;
            }
            bwVar = new bw();
            try {
                bwVar.a(m);
                if (TiebaApplication.K() == null && bwVar.d().a() != null && bwVar.d().a().length() > 0) {
                    context = this.b.c;
                    TiebaApplication.a(context, bwVar.d().a());
                    TiebaApplication.m(bwVar.d().a());
                    return bwVar;
                }
                return bwVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return bwVar;
            }
        } catch (Exception e3) {
            bwVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.k();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bw bwVar) {
        super.a((b) bwVar);
        this.b.b = null;
        this.b.a.a(bwVar);
    }
}
