package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, String> {
    private ad CX;
    private String aoL;
    final /* synthetic */ a caz;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private String mUserName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        this.CX = new ad(strArr[0]);
        this.CX.o("day", this.aoL);
        this.CX.o("un", this.mUserName);
        this.CX.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.CX.o("word", this.mForumName);
        this.CX.o("z", this.mThreadId);
        this.CX.o("ntn", "banid");
        this.CX.oZ().qg().mIsNeedTbs = true;
        this.CX.oy();
        if (this.CX.oZ().qh().ma()) {
            return null;
        }
        return this.CX.getErrorString();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.CX != null) {
            this.CX.dJ();
        }
        this.caz.caw = null;
        super.cancel(true);
        iVar = this.caz.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        i iVar;
        i iVar2;
        super.onPostExecute((d) str);
        this.caz.caw = null;
        if (this.CX == null) {
            iVar2 = this.caz.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        e eVar = new e(this.caz);
        if (str == null) {
            eVar.qb = true;
        } else {
            eVar.qb = false;
            eVar.caA = str;
        }
        iVar = this.caz.mLoadDataCallBack;
        iVar.c(eVar);
    }
}
