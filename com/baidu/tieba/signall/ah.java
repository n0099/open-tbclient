package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Object, Integer, SignData> {
    private volatile com.baidu.tbadk.core.util.ad CX;
    final /* synthetic */ af bSh;

    private ah(af afVar) {
        this.bSh = afVar;
        this.CX = null;
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
            this.CX = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.ad adVar = this.CX;
            str = this.bSh.mForumName;
            adVar.o("kw", str);
            com.baidu.tbadk.core.util.ad adVar2 = this.CX;
            str2 = this.bSh.mForumId;
            adVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.CX.oZ().qg().mIsNeedTbs = true;
            String oy = this.CX.oy();
            if (!this.CX.pc() || !this.CX.oZ().qh().ma()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(oy);
                str3 = this.bSh.mForumId;
                signData.setForumId(str3);
                str4 = this.bSh.mForumName;
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
        if (this.CX != null) {
            this.CX.dJ();
        }
        this.bSh.bSf = null;
        super.cancel(true);
        agVar = this.bSh.bSg;
        str = this.bSh.mForumId;
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
        this.bSh.bSf = null;
        if (signData != null || this.CX == null) {
            agVar = this.bSh.bSg;
            agVar.c(signData);
            return;
        }
        this.bSh.mErrorCode = this.CX.pd();
        this.bSh.mErrorString = this.CX.getErrorString();
        agVar2 = this.bSh.bSg;
        str = this.bSh.mForumId;
        str2 = this.bSh.mErrorString;
        agVar2.aP(str, str2);
    }
}
