package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f2039a;
    private volatile com.baidu.tieba.util.am b;

    private l(f fVar) {
        this.f2039a = fVar;
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
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/delcom");
            this.b.e(true);
            com.baidu.tieba.util.am amVar = this.b;
            str = this.f2039a.e;
            amVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.util.am amVar2 = this.b;
            str2 = this.f2039a.f;
            amVar2.a("com_id", str2);
            String l = this.b.l();
            if (this.b.c() && l != null && (jSONObject = new JSONObject(l)) != null && jSONObject.optJSONObject("error").optInt("errno") == 0) {
                com.baidu.tieba.data.chat.c a2 = com.baidu.tieba.data.chat.c.a();
                com.baidu.tieba.data.chat.c a3 = com.baidu.tieba.data.chat.c.a();
                str3 = this.f2039a.e;
                str4 = this.f2039a.f;
                a3.c(str3, str4);
                str5 = this.f2039a.e;
                str6 = this.f2039a.f;
                a2.b(str5, str6);
                return true;
            }
            return false;
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.g gVar;
        this.f2039a.m = null;
        if (!bool.booleanValue()) {
            this.f2039a.mErrorCode = this.b.e();
            this.f2039a.mErrorString = this.b.i();
            gVar = this.f2039a.mLoadDataCallBack;
            gVar.a(false);
            return;
        }
        com.baidu.tieba.im.pushNotify.a.h().b(false, (com.baidu.tieba.im.a<Void>) new m(this));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        gVar = this.f2039a.mLoadDataCallBack;
        gVar.a(false);
    }
}
