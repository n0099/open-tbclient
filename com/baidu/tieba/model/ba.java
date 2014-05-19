package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ az a;
    private volatile com.baidu.tbadk.core.util.al b;

    private ba(az azVar) {
        this.a = azVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(az azVar, ba baVar) {
        this(azVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00de */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x00ab */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x00ab */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tbadk.core.data.SignData] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public SignData doInBackground(Object... objArr) {
        boolean z;
        Exception e;
        String str;
        String str2;
        String i;
        JSONObject jSONObject;
        TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        Object obj = null;
        try {
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/sign");
            com.baidu.tbadk.core.util.al alVar = this.b;
            str = this.a.a;
            alVar.a("kw", str);
            com.baidu.tbadk.core.util.al alVar2 = this.b;
            str2 = this.a.b;
            alVar2.a("fid", str2);
            this.b.a().a().a = true;
            i = this.b.i();
        } catch (Exception e2) {
            z = obj;
            e = e2;
        }
        if (this.b.c()) {
            z = this.b.a().b().b();
            try {
                if (z != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(i);
                    z = signData;
                } else if (!com.baidu.tbadk.core.util.be.c(i) && (jSONObject = new JSONObject(i)) != null && "199901".equals(jSONObject.optString("error_code"))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(i);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    obj = null;
                    signData2.setBonusPoint(0);
                    z = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return z;
            }
            return z;
        }
        z = 0;
        return z;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.g gVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        com.baidu.adp.base.g gVar;
        TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        this.a.c = null;
        TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        if (signData == null && this.b != null) {
            this.a.mErrorCode = this.b.d();
            this.a.mErrorString = this.b.f();
        }
        gVar = this.a.mLoadDataCallBack;
        gVar.a(signData);
    }
}
