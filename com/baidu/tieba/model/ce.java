package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.SignData;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce extends BdAsyncTask<Object, Integer, SignData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cc f1929a;
    private volatile com.baidu.tieba.util.ap b;

    private ce(cc ccVar) {
        this.f1929a = ccVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x008c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x005b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:? */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.data.SignData] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public SignData a(Object... objArr) {
        Object obj;
        Exception e;
        String str;
        String str2;
        String j;
        JSONObject jSONObject;
        Object obj2 = null;
        try {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/c/forum/sign");
            com.baidu.tieba.util.ap apVar = this.b;
            str = this.f1929a.f1928a;
            apVar.a("kw", str);
            com.baidu.tieba.util.ap apVar2 = this.b;
            str2 = this.f1929a.b;
            apVar2.a("fid", str2);
            this.b.e(true);
            j = this.b.j();
        } catch (Exception e2) {
            obj = obj2;
            e = e2;
        }
        if (this.b.d()) {
            obj = this.b.c();
            try {
                if (obj != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(j);
                    obj = signData;
                } else if (!com.baidu.tieba.util.be.c(j) && (jSONObject = new JSONObject(j)) != null && "199901".equals(jSONObject.optString(SocialConstants.PARAM_ERROR_CODE))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(j);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    obj2 = null;
                    signData2.setBonusPoint(0);
                    obj = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
                return obj;
            }
            return obj;
        }
        obj = 0;
        return obj;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1929a.c = null;
        super.cancel(true);
        gVar = this.f1929a.mLoadDataCallBack;
        gVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SignData signData) {
        com.baidu.adp.a.g gVar;
        this.f1929a.c = null;
        if (signData == null && this.b != null) {
            this.f1929a.mErrorCode = this.b.e();
            this.f1929a.mErrorString = this.b.g();
        }
        gVar = this.f1929a.mLoadDataCallBack;
        gVar.a(signData);
    }
}
