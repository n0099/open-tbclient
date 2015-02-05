package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, String> {
    private ad CU;
    private String aoI;
    final /* synthetic */ a cay;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private String mUserName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        this.CU = new ad(strArr[0]);
        this.CU.o("day", this.aoI);
        this.CU.o("un", this.mUserName);
        this.CU.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.CU.o("word", this.mForumName);
        this.CU.o("z", this.mThreadId);
        this.CU.o("ntn", "banid");
        this.CU.oS().pZ().mIsNeedTbs = true;
        this.CU.or();
        if (this.CU.oS().qa().lT()) {
            return null;
        }
        return this.CU.getErrorString();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.CU != null) {
            this.CU.dJ();
        }
        this.cay.cav = null;
        super.cancel(true);
        iVar = this.cay.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        i iVar;
        i iVar2;
        super.onPostExecute((d) str);
        this.cay.cav = null;
        if (this.CU == null) {
            iVar2 = this.cay.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        e eVar = new e(this.cay);
        if (str == null) {
            eVar.qb = true;
        } else {
            eVar.qb = false;
            eVar.caz = str;
        }
        iVar = this.cay.mLoadDataCallBack;
        iVar.c(eVar);
    }
}
