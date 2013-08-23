package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1402a;
    private volatile com.baidu.tieba.util.v b;

    private d(c cVar) {
        this.f1402a = cVar;
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
        String str3;
        String str4;
        try {
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/delcom");
            this.b.e(true);
            com.baidu.tieba.util.v vVar = this.b;
            str = this.f1402a.b;
            vVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.v vVar2 = this.b;
            str2 = this.f1402a.c;
            vVar2.a("com_id", str2);
            String j = this.b.j();
            if (this.b.c() && j != null && (jSONObject = new JSONObject(j)) != null && jSONObject.optJSONObject("error").optInt("errno") == 0) {
                com.baidu.tieba.data.a.f a2 = com.baidu.tieba.data.a.f.a();
                str3 = this.f1402a.b;
                str4 = this.f1402a.c;
                a2.b(str3, str4);
                return true;
            }
            return false;
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1402a.j = null;
        if (bool.booleanValue()) {
            eVar = this.f1402a.mLoadDataCallBack;
            eVar.a(true);
            return;
        }
        this.f1402a.mErrorCode = this.b.e();
        this.f1402a.mErrorString = this.b.g();
        eVar2 = this.f1402a.mLoadDataCallBack;
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
        eVar = this.f1402a.mLoadDataCallBack;
        eVar.a(false);
    }
}
