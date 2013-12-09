package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.SignData;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf extends BdAsyncTask<Object, Integer, SignData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cd f2025a;
    private volatile com.baidu.tieba.util.am b;

    private cf(cd cdVar) {
        this.f2025a = cdVar;
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
        String l;
        JSONObject jSONObject;
        Object obj2 = null;
        try {
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/forum/sign");
            com.baidu.tieba.util.am amVar = this.b;
            str = this.f2025a.f2024a;
            amVar.a("kw", str);
            com.baidu.tieba.util.am amVar2 = this.b;
            str2 = this.f2025a.b;
            amVar2.a("fid", str2);
            this.b.e(true);
            l = this.b.l();
        } catch (Exception e2) {
            obj = obj2;
            e = e2;
        }
        if (this.b.d()) {
            obj = this.b.c();
            try {
                if (obj != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(l);
                    obj = signData;
                } else if (!com.baidu.tieba.util.bb.c(l) && (jSONObject = new JSONObject(l)) != null && "199901".equals(jSONObject.optString(SocialConstants.PARAM_ERROR_CODE))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(l);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    obj2 = null;
                    signData2.setBonusPoint(0);
                    obj = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
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
            this.b.j();
        }
        this.f2025a.c = null;
        super.cancel(true);
        gVar = this.f2025a.mLoadDataCallBack;
        gVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SignData signData) {
        com.baidu.adp.a.g gVar;
        this.f2025a.c = null;
        if (signData == null && this.b != null) {
            this.f2025a.mErrorCode = this.b.e();
            this.f2025a.mErrorString = this.b.i();
        }
        gVar = this.f2025a.mLoadDataCallBack;
        gVar.a(signData);
    }
}
