package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f2041a;
    private volatile com.baidu.tieba.util.am b;

    private n(f fVar) {
        this.f2041a = fVar;
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
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/comlist");
            this.b.e(true);
            com.baidu.tieba.util.am amVar = this.b;
            str = this.f2041a.e;
            amVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.am amVar2 = this.b;
            str2 = this.f2041a.g;
            amVar2.a("pn", str2);
            com.baidu.tieba.util.am amVar3 = this.b;
            str3 = this.f2041a.h;
            amVar3.a("rn", str3);
            String l = this.b.l();
            if (this.b.c() && l != null) {
                this.f2041a.c(l);
                if (this.f2041a.d() == 0) {
                    str4 = this.f2041a.g;
                    if (str4.equals(SocialConstants.TRUE)) {
                        list = this.f2041a.d;
                        if (list != null) {
                            this.f2041a.g();
                        }
                    }
                }
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        List list;
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        List list2;
        List list3;
        List list4;
        List list5;
        this.f2041a.l = null;
        list = this.f2041a.c;
        if (list != null) {
            list2 = this.f2041a.d;
            if (list2 != null) {
                list3 = this.f2041a.c;
                list3.clear();
                list4 = this.f2041a.c;
                list5 = this.f2041a.d;
                list4.addAll(list5);
            }
        }
        this.f2041a.f();
        if (bool.booleanValue()) {
            gVar = this.f2041a.mLoadDataCallBack;
            gVar.a(true);
            return;
        }
        this.f2041a.mErrorCode = this.b.e();
        this.f2041a.mErrorString = this.b.i();
        gVar2 = this.f2041a.mLoadDataCallBack;
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
        gVar = this.f2041a.mLoadDataCallBack;
        gVar.a(false);
    }
}
