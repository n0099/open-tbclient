package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<Object, Integer, SignData> {
    private volatile com.baidu.tbadk.core.util.aa aaG;
    final /* synthetic */ ag cjv;

    private ai(ag agVar) {
        this.cjv = agVar;
        this.aaG = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(ag agVar, ai aiVar) {
        this(agVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: u */
    public SignData doInBackground(Object... objArr) {
        SignData signData;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            this.aaG = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.aa aaVar = this.aaG;
            str = this.cjv.mForumName;
            aaVar.o("kw", str);
            com.baidu.tbadk.core.util.aa aaVar2 = this.aaG;
            str2 = this.cjv.mForumId;
            aaVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.aaG.sX().tS().mIsNeedTbs = true;
            String sw = this.aaG.sw();
            if (!this.aaG.ta() || !this.aaG.sX().tT().qa()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(sw);
                str3 = this.cjv.mForumId;
                signData.setForumId(str3);
                str4 = this.cjv.mForumName;
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
        ah ahVar;
        String str;
        if (this.aaG != null) {
            this.aaG.gS();
        }
        this.cjv.cjt = null;
        super.cancel(true);
        ahVar = this.cjv.cju;
        str = this.cjv.mForumId;
        ahVar.aZ(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        ah ahVar;
        ah ahVar2;
        String str;
        String str2;
        this.cjv.cjt = null;
        if (signData != null || this.aaG == null) {
            ahVar = this.cjv.cju;
            ahVar.c(signData);
            return;
        }
        this.cjv.mErrorCode = this.aaG.tb();
        this.cjv.mErrorString = this.aaG.getErrorString();
        ahVar2 = this.cjv.cju;
        str = this.cjv.mForumId;
        str2 = this.cjv.mErrorString;
        ahVar2.aZ(str, str2);
    }
}
