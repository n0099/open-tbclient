package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.SignData;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bu extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ bt a;
    private volatile com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ SignData a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(SignData signData) {
        com.baidu.adp.a.g gVar;
        SignData signData2 = signData;
        this.a.c = null;
        if (signData2 == null && this.b != null) {
            this.a.mErrorCode = this.b.e();
            this.a.mErrorString = this.b.i();
        }
        gVar = this.a.mLoadDataCallBack;
        gVar.a(signData2);
    }

    private bu(bt btVar) {
        this.a = btVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bu(bt btVar, byte b) {
        this(btVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x008a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x005b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.data.SignData] */
    private SignData d() {
        Object obj;
        Exception e;
        String str;
        String str2;
        String l;
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
                } else if (!com.baidu.tieba.util.bs.c(l) && "199901".equals(new JSONObject(l).optString(SocialConstants.PARAM_ERROR_CODE))) {
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
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return obj;
            }
            return obj;
        }
        obj = 0;
        return obj;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.j();
        }
        this.a.c = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }
}
