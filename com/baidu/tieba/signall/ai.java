package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<Object, Integer, SignData> {
    private volatile com.baidu.tbadk.core.util.aa ZF;
    final /* synthetic */ ag cfr;

    private ai(ag agVar) {
        this.cfr = agVar;
        this.ZF = null;
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
            this.ZF = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.aa aaVar = this.ZF;
            str = this.cfr.mForumName;
            aaVar.o("kw", str);
            com.baidu.tbadk.core.util.aa aaVar2 = this.ZF;
            str2 = this.cfr.mForumId;
            aaVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.ZF.sp().tp().mIsNeedTbs = true;
            String rO = this.ZF.rO();
            if (!this.ZF.ss() || !this.ZF.sp().tq().pv()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(rO);
                str3 = this.cfr.mForumId;
                signData.setForumId(str3);
                str4 = this.cfr.mForumName;
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
        if (this.ZF != null) {
            this.ZF.hh();
        }
        this.cfr.cfp = null;
        super.cancel(true);
        ahVar = this.cfr.cfq;
        str = this.cfr.mForumId;
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
        this.cfr.cfp = null;
        if (signData != null || this.ZF == null) {
            ahVar = this.cfr.cfq;
            ahVar.c(signData);
            return;
        }
        this.cfr.mErrorCode = this.ZF.st();
        this.cfr.mErrorString = this.ZF.getErrorString();
        ahVar2 = this.cfr.cfq;
        str = this.cfr.mForumId;
        str2 = this.cfr.mErrorString;
        ahVar2.aU(str, str2);
    }
}
