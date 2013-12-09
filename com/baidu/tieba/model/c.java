package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, ci> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.am f2020a;
    final /* synthetic */ a b;

    private c(a aVar) {
        this.b = aVar;
        this.f2020a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ci a(String... strArr) {
        ci ciVar;
        Exception e;
        Context context;
        try {
            this.f2020a = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/sync");
            this.f2020a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.b(TiebaApplication.h())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.c(TiebaApplication.h())));
            this.f2020a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.h().N() > 0) {
                this.f2020a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.f2020a.a("_msg_status", SocialConstants.TRUE);
            }
            String l = this.f2020a.l();
            if (!this.f2020a.c()) {
                return null;
            }
            ciVar = new ci();
            try {
                ciVar.a(l);
                if (TiebaApplication.L() == null && ciVar.d().a() != null && ciVar.d().a().length() > 0) {
                    context = this.b.c;
                    TiebaApplication.a(context, ciVar.d().a());
                    TiebaApplication.o(ciVar.d().a());
                    return ciVar;
                }
                return ciVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
                return ciVar;
            }
        } catch (Exception e3) {
            ciVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.f2020a != null) {
            this.f2020a.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ci ciVar) {
        super.a((c) ciVar);
        this.b.b = null;
        this.b.f1975a.a(ciVar);
    }
}
