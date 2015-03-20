package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<Object, Integer, SignData> {
    private volatile com.baidu.tbadk.core.util.aa ZD;
    final /* synthetic */ ag cfc;

    private ai(ag agVar) {
        this.cfc = agVar;
        this.ZD = null;
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
    /* renamed from: r */
    public SignData doInBackground(Object... objArr) {
        SignData signData;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            this.ZD = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.aa aaVar = this.ZD;
            str = this.cfc.mForumName;
            aaVar.o("kw", str);
            com.baidu.tbadk.core.util.aa aaVar2 = this.ZD;
            str2 = this.cfc.mForumId;
            aaVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.ZD.sp().tp().mIsNeedTbs = true;
            String rO = this.ZD.rO();
            if (!this.ZD.ss() || !this.ZD.sp().tq().pv()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(rO);
                str3 = this.cfc.mForumId;
                signData.setForumId(str3);
                str4 = this.cfc.mForumName;
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
        if (this.ZD != null) {
            this.ZD.hh();
        }
        this.cfc.cfa = null;
        super.cancel(true);
        ahVar = this.cfc.cfb;
        str = this.cfc.mForumId;
        ahVar.aU(str, null);
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
        this.cfc.cfa = null;
        if (signData != null || this.ZD == null) {
            ahVar = this.cfc.cfb;
            ahVar.c(signData);
            return;
        }
        this.cfc.mErrorCode = this.ZD.st();
        this.cfc.mErrorString = this.ZD.getErrorString();
        ahVar2 = this.cfc.cfb;
        str = this.cfc.mForumId;
        str2 = this.cfc.mErrorString;
        ahVar2.aU(str, str2);
    }
}
