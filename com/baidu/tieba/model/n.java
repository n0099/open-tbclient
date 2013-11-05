package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1954a;
    private volatile com.baidu.tieba.util.ag b;

    private n(f fVar) {
        this.f1954a = fVar;
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
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/s/comlist");
            this.b.e(true);
            com.baidu.tieba.util.ag agVar = this.b;
            str = this.f1954a.d;
            agVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.ag agVar2 = this.b;
            str2 = this.f1954a.f;
            agVar2.a("pn", str2);
            com.baidu.tieba.util.ag agVar3 = this.b;
            str3 = this.f1954a.g;
            agVar3.a("rn", str3);
            String j = this.b.j();
            if (this.b.c() && j != null) {
                this.f1954a.c(j);
                if (this.f1954a.d() == 0) {
                    str4 = this.f1954a.f;
                    if (str4.equals(SocialConstants.TRUE)) {
                        list = this.f1954a.c;
                        if (list != null) {
                            this.f1954a.f();
                        }
                    }
                }
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        this.f1954a.k = null;
        this.f1954a.e();
        if (bool.booleanValue()) {
            gVar = this.f1954a.mLoadDataCallBack;
            gVar.a(true);
            return;
        }
        this.f1954a.mErrorCode = this.b.e();
        this.f1954a.mErrorString = this.b.g();
        gVar2 = this.f1954a.mLoadDataCallBack;
        gVar2.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        gVar = this.f1954a.mLoadDataCallBack;
        gVar.a(false);
    }
}
