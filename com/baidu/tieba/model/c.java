package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, ch> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.ap f1925a;
    final /* synthetic */ a b;

    private c(a aVar) {
        this.b = aVar;
        this.f1925a = null;
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
            this.f1925a = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/s/sync");
            this.f1925a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f1925a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().P() > 0) {
                this.f1925a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.f1925a.a("_msg_status", SocialConstants.TRUE);
            }
            String j = this.f1925a.j();
            if (!this.f1925a.c()) {
                return null;
            }
            chVar = new ch();
            try {
                chVar.a(j);
                if (TiebaApplication.N() == null && chVar.d().a() != null && chVar.d().a().length() > 0) {
                    context = this.b.c;
                    TiebaApplication.a(context, chVar.d().a());
                    TiebaApplication.n(chVar.d().a());
                    return chVar;
                }
                return chVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        if (this.f1925a != null) {
            this.f1925a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ch chVar) {
        super.a((c) chVar);
        this.b.b = null;
        this.b.f1880a.a(chVar);
    }
}
