package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ ay bpU;
    private volatile com.baidu.tbadk.core.util.ac yV;

    private az(ay ayVar) {
        this.bpU = ayVar;
        this.yV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(ay ayVar, az azVar) {
        this(ayVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x00ec */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x00bb */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x009d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00bb */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0020 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tbadk.core.data.SignData] */
    /* JADX WARN: Type inference failed for: r1v16 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public SignData doInBackground(Object... objArr) {
        String str;
        Exception e;
        String str2;
        String str3;
        String lA;
        JSONObject jSONObject;
        String str4;
        TiebaStatic.eventStat(TbadkApplication.m251getInst().getApplicationContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        String str5 = null;
        str5 = null;
        try {
            TiebaStatic.eventStat(TbadkApplication.m251getInst().getApplicationContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/sign");
            com.baidu.tbadk.core.util.ac acVar = this.yV;
            str2 = this.bpU.mForumName;
            acVar.k("kw", str2);
            com.baidu.tbadk.core.util.ac acVar2 = this.yV;
            str3 = this.bpU.mForumId;
            acVar2.k(ImageViewerConfig.FORUM_ID, str3);
            this.yV.mc().na().mIsNeedTbs = true;
            lA = this.yV.lA();
        } catch (Exception e2) {
            str = str5;
            e = e2;
        }
        if (this.yV.mf()) {
            str = this.yV.mc().nb().jq();
            try {
                if (str != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(lA);
                    int signed = signData.getSigned();
                    str = signData;
                    str5 = signed;
                    if (signed == 1) {
                        str4 = this.bpU.mForumId;
                        Hao123Model.updateSign(str4, true, signData.getCountSignNum());
                        str = signData;
                        str5 = str4;
                    }
                } else if (!com.baidu.tbadk.core.util.az.aA(lA) && (jSONObject = new JSONObject(lA)) != null && "199901".equals(jSONObject.optString("error_code"))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(lA);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    str5 = null;
                    signData2.setBonusPoint(0);
                    str = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        if (this.yV != null) {
            this.yV.dM();
        }
        this.bpU.bpT = null;
        super.cancel(true);
        hVar = this.bpU.mLoadDataCallBack;
        hVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(SignData signData) {
        com.baidu.adp.base.h hVar;
        TiebaStatic.eventStat(TbadkApplication.m251getInst().getApplicationContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        this.bpU.bpT = null;
        TiebaStatic.eventStat(TbadkApplication.m251getInst().getApplicationContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        if (signData == null && this.yV != null) {
            this.bpU.mErrorCode = this.yV.mg();
            this.bpU.mErrorString = this.yV.getErrorString();
        }
        hVar = this.bpU.mLoadDataCallBack;
        hVar.a(signData);
    }
}
