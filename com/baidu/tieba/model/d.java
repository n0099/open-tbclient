package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1366a;
    private volatile com.baidu.tieba.util.u b;

    private d(c cVar) {
        this.f1366a = cVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(c cVar, d dVar) {
        this(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        String str;
        String str2;
        JSONObject jSONObject;
        try {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/delcom");
            this.b.e(true);
            com.baidu.tieba.util.u uVar = this.b;
            str = this.f1366a.b;
            uVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.u uVar2 = this.b;
            str2 = this.f1366a.c;
            uVar2.a("com_id", str2);
            String k = this.b.k();
            if (this.b.d() && k != null && (jSONObject = new JSONObject(k)) != null && jSONObject.optJSONObject("error").optInt("errno") == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1366a.j = null;
        if (bool.booleanValue()) {
            eVar = this.f1366a.mLoadDataCallBack;
            eVar.a(true);
            return;
        }
        this.f1366a.mErrorCode = this.b.f();
        this.f1366a.mErrorString = this.b.h();
        eVar2 = this.f1366a.mLoadDataCallBack;
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
        eVar = this.f1366a.mLoadDataCallBack;
        eVar.a(false);
    }
}
