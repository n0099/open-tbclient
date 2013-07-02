package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask {
    final /* synthetic */ c a;
    private volatile com.baidu.tieba.util.r b;

    private e(c cVar) {
        this.a = cVar;
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
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/comlist");
            this.b.d(true);
            com.baidu.tieba.util.r rVar = this.b;
            str = this.a.b;
            rVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.r rVar2 = this.b;
            str2 = this.a.d;
            rVar2.a("pn", str2);
            com.baidu.tieba.util.r rVar3 = this.b;
            str3 = this.a.e;
            rVar3.a("rn", str3);
            String j = this.b.j();
            if (this.b.c() && j != null) {
                this.a.b(j);
                if (this.a.c() == 0) {
                    str4 = this.a.d;
                    if (str4.equals("1")) {
                        list = this.a.a;
                        if (list != null) {
                            com.baidu.tieba.data.a.f a = com.baidu.tieba.data.a.f.a();
                            str5 = this.a.b;
                            list2 = this.a.a;
                            a.a(str5, list2);
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
        this.a.i = null;
        if (bool.booleanValue()) {
            eVar = this.a.mLoadDataCallBack;
            eVar.a(true);
            return;
        }
        this.a.mErrorCode = this.b.e();
        this.a.mErrorString = this.b.g();
        eVar2 = this.a.mLoadDataCallBack;
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
        this.a.a = null;
        eVar = this.a.mLoadDataCallBack;
        eVar.a(false);
    }
}
