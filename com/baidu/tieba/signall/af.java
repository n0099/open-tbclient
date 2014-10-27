package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ ad bLQ;
    private volatile com.baidu.tbadk.core.util.ac yV;

    private af(ad adVar) {
        this.bLQ = adVar;
        this.yV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(ad adVar, af afVar) {
        this(adVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public SignData doInBackground(Object... objArr) {
        SignData signData;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/sign");
            com.baidu.tbadk.core.util.ac acVar = this.yV;
            str = this.bLQ.mForumName;
            acVar.k("kw", str);
            com.baidu.tbadk.core.util.ac acVar2 = this.yV;
            str2 = this.bLQ.mForumId;
            acVar2.k(ImageViewerConfig.FORUM_ID, str2);
            this.yV.mc().na().mIsNeedTbs = true;
            String lA = this.yV.lA();
            if (!this.yV.mf() || !this.yV.mc().nb().jq()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(lA);
                str3 = this.bLQ.mForumId;
                signData.setForumId(str3);
                str4 = this.bLQ.mForumName;
                signData.setForumName(str4);
                return signData;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ae aeVar;
        String str;
        if (this.yV != null) {
            this.yV.dM();
        }
        this.bLQ.bLO = null;
        super.cancel(true);
        aeVar = this.bLQ.bLP;
        str = this.bLQ.mForumId;
        aeVar.aC(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(SignData signData) {
        ae aeVar;
        ae aeVar2;
        String str;
        String str2;
        this.bLQ.bLO = null;
        if (signData != null || this.yV == null) {
            aeVar = this.bLQ.bLP;
            aeVar.d(signData);
            return;
        }
        this.bLQ.mErrorCode = this.yV.mg();
        this.bLQ.mErrorString = this.yV.getErrorString();
        aeVar2 = this.bLQ.bLP;
        str = this.bLQ.mForumId;
        str2 = this.bLQ.mErrorString;
        aeVar2.aC(str, str2);
    }
}
