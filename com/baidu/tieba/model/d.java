package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask {
    final /* synthetic */ c a;
    private volatile com.baidu.tieba.util.r b;

    private d(c cVar) {
        this.a = cVar;
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
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/delcom");
            this.b.d(true);
            com.baidu.tieba.util.r rVar = this.b;
            str = this.a.b;
            rVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.r rVar2 = this.b;
            str2 = this.a.c;
            rVar2.a("com_id", str2);
            String j = this.b.j();
            if (this.b.c() && j != null && (jSONObject = new JSONObject(j)) != null && jSONObject.optJSONObject("error").optInt("errno") == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.a.j = null;
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
        eVar = this.a.mLoadDataCallBack;
        eVar.a(false);
    }
}
