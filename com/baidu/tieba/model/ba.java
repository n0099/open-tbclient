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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x00f3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0021 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00c0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:? */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tbadk.core.data.SignData] */
    /* JADX WARN: Type inference failed for: r1v15 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public SignData doInBackground(Object... objArr) {
        String str;
        Exception e;
        String str2;
        String str3;
        String i;
        JSONObject jSONObject;
        String str4;
        TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        String str5 = null;
        str5 = null;
        try {
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/sign");
            com.baidu.tbadk.core.util.al alVar = this.b;
            str2 = this.a.a;
            alVar.a("kw", str2);
            com.baidu.tbadk.core.util.al alVar2 = this.b;
            str3 = this.a.b;
            alVar2.a("fid", str3);
            this.b.a().a().a = true;
            i = this.b.i();
        } catch (Exception e2) {
            str = str5;
            e = e2;
        }
        if (this.b.c()) {
            str = this.b.a().b().b();
            try {
                if (str != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(i);
                    int signed = signData.getSigned();
                    str = signData;
                    str5 = signed;
                    if (signed == 1) {
                        str4 = this.a.b;
                        Hao123Model.updateSign(str4, true, signData.getCountSignNum());
                        str = signData;
                        str5 = str4;
                    }
                } else if (!com.baidu.tbadk.core.util.be.c(i) && (jSONObject = new JSONObject(i)) != null && "199901".equals(jSONObject.optString("error_code"))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(i);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    str5 = null;
                    signData2.setBonusPoint(0);
                    str = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.e eVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
        super.cancel(true);
        eVar = this.a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        com.baidu.adp.base.e eVar;
        TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        this.a.c = null;
        TiebaStatic.eventStat(TbadkApplication.m252getInst().getApplicationContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        if (signData == null && this.b != null) {
            this.a.mErrorCode = this.b.d();
            this.a.mErrorString = this.b.f();
        }
        eVar = this.a.mLoadDataCallBack;
        eVar.a(signData);
    }
}
