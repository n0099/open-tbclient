package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Object, Integer, SignData> {
    private volatile com.baidu.tbadk.core.util.ad CV;
    final /* synthetic */ af bQw;

    private ah(af afVar) {
        this.bQw = afVar;
        this.CV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(af afVar, ah ahVar) {
        this(afVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public SignData doInBackground(Object... objArr) {
        SignData signData;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            this.CV = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.ad adVar = this.CV;
            str = this.bQw.mForumName;
            adVar.o("kw", str);
            com.baidu.tbadk.core.util.ad adVar2 = this.CV;
            str2 = this.bQw.mForumId;
            adVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.CV.oW().pV().mIsNeedTbs = true;
            String ov = this.CV.ov();
            if (!this.CV.oZ() || !this.CV.oW().pW().ma()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(ov);
                str3 = this.bQw.mForumId;
                signData.setForumId(str3);
                str4 = this.bQw.mForumName;
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
        ag agVar;
        String str;
        if (this.CV != null) {
            this.CV.dL();
        }
        this.bQw.bQu = null;
        super.cancel(true);
        agVar = this.bQw.bQv;
        str = this.bQw.mForumId;
        agVar.aM(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        ag agVar;
        ag agVar2;
        String str;
        String str2;
        this.bQw.bQu = null;
        if (signData != null || this.CV == null) {
            agVar = this.bQw.bQv;
            agVar.c(signData);
            return;
        }
        this.bQw.mErrorCode = this.CV.pa();
        this.bQw.mErrorString = this.CV.getErrorString();
        agVar2 = this.bQw.bQv;
        str = this.bQw.mForumId;
        str2 = this.bQw.mErrorString;
        agVar2.aM(str, str2);
    }
}
