package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, co> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.ag f1930a;
    final /* synthetic */ a b;

    private c(a aVar) {
        this.b = aVar;
        this.f1930a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public co a(String... strArr) {
        co coVar;
        Exception e;
        Context context;
        try {
            this.f1930a = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/s/sync");
            this.f1930a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f1930a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().R() > 0) {
                this.f1930a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.f1930a.a("_msg_status", SocialConstants.TRUE);
            }
            String j = this.f1930a.j();
            if (!this.f1930a.c()) {
                return null;
            }
            coVar = new co();
            try {
                coVar.a(j);
                if (TiebaApplication.P() == null && coVar.d().a() != null && coVar.d().a().length() > 0) {
                    context = this.b.c;
                    TiebaApplication.a(context, coVar.d().a());
                    TiebaApplication.n(coVar.d().a());
                    return coVar;
                }
                return coVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
                return coVar;
            }
        } catch (Exception e3) {
            coVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.f1930a != null) {
            this.f1930a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(co coVar) {
        super.a((c) coVar);
        this.b.b = null;
        this.b.f1884a.a(coVar);
    }
}
