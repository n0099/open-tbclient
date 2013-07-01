package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1050a;
    private volatile com.baidu.tieba.util.r b;

    private e(c cVar) {
        this.f1050a = cVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(c cVar, e eVar) {
        this(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        String str5;
        List list2;
        try {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/comlist");
            this.b.d(true);
            com.baidu.tieba.util.r rVar = this.b;
            str = this.f1050a.b;
            rVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.r rVar2 = this.b;
            str2 = this.f1050a.d;
            rVar2.a("pn", str2);
            com.baidu.tieba.util.r rVar3 = this.b;
            str3 = this.f1050a.e;
            rVar3.a("rn", str3);
            String j = this.b.j();
            if (this.b.c() && j != null) {
                this.f1050a.b(j);
                if (this.f1050a.c() == 0) {
                    str4 = this.f1050a.d;
                    if (str4.equals("1")) {
                        list = this.f1050a.f1048a;
                        if (list != null) {
                            com.baidu.tieba.data.a.f a2 = com.baidu.tieba.data.a.f.a();
                            str5 = this.f1050a.b;
                            list2 = this.f1050a.f1048a;
                            a2.a(str5, list2);
                        }
                    }
                }
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1050a.i = null;
        if (bool.booleanValue()) {
            eVar = this.f1050a.mLoadDataCallBack;
            eVar.a(true);
            return;
        }
        this.f1050a.mErrorCode = this.b.e();
        this.f1050a.mErrorString = this.b.g();
        eVar2 = this.f1050a.mLoadDataCallBack;
        eVar2.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1050a.f1048a = null;
        eVar = this.f1050a.mLoadDataCallBack;
        eVar.a(false);
    }
}
