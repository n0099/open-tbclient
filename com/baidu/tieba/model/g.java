package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1444a;
    private volatile com.baidu.tieba.util.z b;

    private g(e eVar) {
        this.f1444a = eVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(e eVar, g gVar) {
        this(eVar);
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
        List<com.baidu.tieba.data.a.g> list2;
        try {
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/comlist");
            this.b.e(true);
            com.baidu.tieba.util.z zVar = this.b;
            str = this.f1444a.b;
            zVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.z zVar2 = this.b;
            str2 = this.f1444a.d;
            zVar2.a("pn", str2);
            com.baidu.tieba.util.z zVar3 = this.b;
            str3 = this.f1444a.e;
            zVar3.a("rn", str3);
            String j = this.b.j();
            if (this.b.c() && j != null) {
                this.f1444a.b(j);
                if (this.f1444a.c() == 0) {
                    str4 = this.f1444a.d;
                    if (str4.equals("1")) {
                        list = this.f1444a.f1442a;
                        if (list != null) {
                            com.baidu.tieba.data.a.f a2 = com.baidu.tieba.data.a.f.a();
                            str5 = this.f1444a.b;
                            list2 = this.f1444a.f1442a;
                            a2.a(str5, list2);
                        }
                    }
                }
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1444a.i = null;
        if (bool.booleanValue()) {
            eVar = this.f1444a.mLoadDataCallBack;
            eVar.a(true);
            return;
        }
        this.f1444a.mErrorCode = this.b.e();
        this.f1444a.mErrorString = this.b.g();
        eVar2 = this.f1444a.mLoadDataCallBack;
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
        this.f1444a.f1442a = null;
        eVar = this.f1444a.mLoadDataCallBack;
        eVar.a(false);
    }
}
