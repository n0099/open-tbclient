package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1928a;
    private volatile com.baidu.tieba.util.ap b;

    private n(f fVar) {
        this.f1928a = fVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(f fVar, g gVar) {
        this(fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        return d();
    }

    private Boolean d() {
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        try {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/s/comlist");
            this.b.e(true);
            com.baidu.tieba.util.ap apVar = this.b;
            str = this.f1928a.d;
            apVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.ap apVar2 = this.b;
            str2 = this.f1928a.f;
            apVar2.a("pn", str2);
            com.baidu.tieba.util.ap apVar3 = this.b;
            str3 = this.f1928a.g;
            apVar3.a("rn", str3);
            String l = this.b.l();
            if (this.b.c() && l != null) {
                this.f1928a.c(l);
                if (this.f1928a.d() == 0) {
                    str4 = this.f1928a.f;
                    if (str4.equals(SocialConstants.TRUE)) {
                        list = this.f1928a.c;
                        if (list != null) {
                            this.f1928a.g();
                        }
                    }
                }
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        this.f1928a.k = null;
        this.f1928a.f();
        if (bool.booleanValue()) {
            gVar = this.f1928a.mLoadDataCallBack;
            gVar.a(true);
            return;
        }
        this.f1928a.mErrorCode = this.b.e();
        this.f1928a.mErrorString = this.b.i();
        gVar2 = this.f1928a.mLoadDataCallBack;
        gVar2.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        gVar = this.f1928a.mLoadDataCallBack;
        gVar.a(false);
    }
}
