package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.SignData;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ bt a;
    private volatile com.baidu.tieba.util.ba b;

    private bu(bt btVar) {
        this.a = btVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bu(bt btVar, bu buVar) {
        this(btVar);
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
        String m;
        JSONObject jSONObject;
        Object obj2 = null;
        try {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/sign");
            com.baidu.tieba.util.ba baVar = this.b;
            str = this.a.a;
            baVar.a("kw", str);
            com.baidu.tieba.util.ba baVar2 = this.b;
            str2 = this.a.b;
            baVar2.a("fid", str2);
            this.b.e(true);
            m = this.b.m();
        } catch (Exception e2) {
            obj = obj2;
            e = e2;
        }
        if (this.b.e()) {
            obj = this.b.d();
            try {
                if (obj != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(m);
                    obj = signData;
                } else if (!com.baidu.tieba.util.bs.c(m) && (jSONObject = new JSONObject(m)) != null && "199901".equals(jSONObject.optString(SocialConstants.PARAM_ERROR_CODE))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(m);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    obj2 = null;
                    signData2.setBonusPoint(0);
                    obj = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
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
            this.b.k();
        }
        this.a.c = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SignData signData) {
        com.baidu.adp.a.g gVar;
        this.a.c = null;
        if (signData == null && this.b != null) {
            this.a.mErrorCode = this.b.f();
            this.a.mErrorString = this.b.j();
        }
        gVar = this.a.mLoadDataCallBack;
        gVar.a(signData);
    }
}
