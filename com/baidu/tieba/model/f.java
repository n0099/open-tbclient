package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1443a;
    private volatile com.baidu.tieba.util.z b;

    private f(e eVar) {
        this.f1443a = eVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(e eVar, f fVar) {
        this(eVar);
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
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/delcom");
            this.b.e(true);
            com.baidu.tieba.util.z zVar = this.b;
            str = this.f1443a.b;
            zVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.z zVar2 = this.b;
            str2 = this.f1443a.c;
            zVar2.a("com_id", str2);
            String j = this.b.j();
            if (this.b.c() && j != null && (jSONObject = new JSONObject(j)) != null && jSONObject.optJSONObject("error").optInt("errno") == 0) {
                com.baidu.tieba.data.a.f a2 = com.baidu.tieba.data.a.f.a();
                str3 = this.f1443a.b;
                str4 = this.f1443a.c;
                a2.b(str3, str4);
                return true;
            }
            return false;
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1443a.j = null;
        if (bool.booleanValue()) {
            eVar = this.f1443a.mLoadDataCallBack;
            eVar.a(true);
            return;
        }
        this.f1443a.mErrorCode = this.b.e();
        this.f1443a.mErrorString = this.b.g();
        eVar2 = this.f1443a.mLoadDataCallBack;
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
        eVar = this.f1443a.mLoadDataCallBack;
        eVar.a(false);
    }
}
