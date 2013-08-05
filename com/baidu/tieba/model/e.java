package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1369a;
    private volatile com.baidu.tieba.util.u b;

    private e(c cVar) {
        this.f1369a = cVar;
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
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/comlist");
            this.b.e(true);
            com.baidu.tieba.util.u uVar = this.b;
            str = this.f1369a.b;
            uVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.u uVar2 = this.b;
            str2 = this.f1369a.d;
            uVar2.a("pn", str2);
            com.baidu.tieba.util.u uVar3 = this.b;
            str3 = this.f1369a.e;
            uVar3.a("rn", str3);
            String k = this.b.k();
            if (this.b.d() && k != null) {
                this.f1369a.b(k);
                if (this.f1369a.c() == 0) {
                    str4 = this.f1369a.d;
                    if (str4.equals("1")) {
                        list = this.f1369a.f1366a;
                        if (list != null) {
                            com.baidu.tieba.data.a.f a2 = com.baidu.tieba.data.a.f.a();
                            str5 = this.f1369a.b;
                            list2 = this.f1369a.f1366a;
                            a2.a(str5, list2);
                        }
                    }
                }
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1369a.i = null;
        if (bool.booleanValue()) {
            eVar = this.f1369a.mLoadDataCallBack;
            eVar.a(true);
            return;
        }
        this.f1369a.mErrorCode = this.b.f();
        this.f1369a.mErrorString = this.b.h();
        eVar2 = this.f1369a.mLoadDataCallBack;
        eVar2.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1369a.f1366a = null;
        eVar = this.f1369a.mLoadDataCallBack;
        eVar.a(false);
    }
}
