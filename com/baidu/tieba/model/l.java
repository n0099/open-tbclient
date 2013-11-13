package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1943a;
    private volatile com.baidu.tieba.util.ap b;

    private l(f fVar) {
        this.f1943a = fVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(f fVar, g gVar) {
        this(fVar);
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
        String str5;
        String str6;
        try {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/s/delcom");
            this.b.e(true);
            com.baidu.tieba.util.ap apVar = this.b;
            str = this.f1943a.d;
            apVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.ap apVar2 = this.b;
            str2 = this.f1943a.e;
            apVar2.a("com_id", str2);
            String j = this.b.j();
            if (this.b.c() && j != null && (jSONObject = new JSONObject(j)) != null && jSONObject.optJSONObject("error").optInt("errno") == 0) {
                com.baidu.tieba.data.chat.c a2 = com.baidu.tieba.data.chat.c.a();
                com.baidu.tieba.data.chat.c a3 = com.baidu.tieba.data.chat.c.a();
                str3 = this.f1943a.d;
                str4 = this.f1943a.e;
                a3.c(str3, str4);
                str5 = this.f1943a.d;
                str6 = this.f1943a.e;
                a2.b(str5, str6);
                return true;
            }
            return false;
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.g gVar;
        this.f1943a.l = null;
        if (!bool.booleanValue()) {
            this.f1943a.mErrorCode = this.b.e();
            this.f1943a.mErrorString = this.b.g();
            gVar = this.f1943a.mLoadDataCallBack;
            gVar.a(false);
            return;
        }
        com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) new m(this));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        gVar = this.f1943a.mLoadDataCallBack;
        gVar.a(false);
    }
}
