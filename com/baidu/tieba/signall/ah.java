package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Object, Integer, SignData> {
    private volatile com.baidu.tbadk.core.util.ad CU;
    final /* synthetic */ af bSg;

    private ah(af afVar) {
        this.bSg = afVar;
        this.CU = null;
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
            this.CU = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.ad adVar = this.CU;
            str = this.bSg.mForumName;
            adVar.o("kw", str);
            com.baidu.tbadk.core.util.ad adVar2 = this.CU;
            str2 = this.bSg.mForumId;
            adVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.CU.oS().pZ().mIsNeedTbs = true;
            String or = this.CU.or();
            if (!this.CU.oV() || !this.CU.oS().qa().lT()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(or);
                str3 = this.bSg.mForumId;
                signData.setForumId(str3);
                str4 = this.bSg.mForumName;
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
        if (this.CU != null) {
            this.CU.dJ();
        }
        this.bSg.bSe = null;
        super.cancel(true);
        agVar = this.bSg.bSf;
        str = this.bSg.mForumId;
        agVar.aP(str, null);
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
        this.bSg.bSe = null;
        if (signData != null || this.CU == null) {
            agVar = this.bSg.bSf;
            agVar.c(signData);
            return;
        }
        this.bSg.mErrorCode = this.CU.oW();
        this.bSg.mErrorString = this.CU.getErrorString();
        agVar2 = this.bSg.bSf;
        str = this.bSg.mForumId;
        str2 = this.bSg.mErrorString;
        agVar2.aP(str, str2);
    }
}
