package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, String> {
    private aa ZD;
    private String acM;
    private String bFE;
    final /* synthetic */ a cpB;
    private String mForumId;
    private String mForumName;
    private String mThreadId;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        this.ZD = new aa(strArr[0]);
        this.ZD.o("day", this.bFE);
        this.ZD.o("un", this.acM);
        this.ZD.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.ZD.o("word", this.mForumName);
        this.ZD.o("z", this.mThreadId);
        this.ZD.o("ntn", "banid");
        this.ZD.sp().tp().mIsNeedTbs = true;
        this.ZD.rO();
        if (this.ZD.sp().tq().pv()) {
            return null;
        }
        return this.ZD.getErrorString();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.ZD != null) {
            this.ZD.hh();
        }
        this.cpB.cpy = null;
        super.cancel(true);
        iVar = this.cpB.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        i iVar;
        i iVar2;
        super.onPostExecute((d) str);
        this.cpB.cpy = null;
        if (this.ZD == null) {
            iVar2 = this.cpB.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        e eVar = new e(this.cpB);
        if (str == null) {
            eVar.AM = true;
        } else {
            eVar.AM = false;
            eVar.cpC = str;
        }
        iVar = this.cpB.mLoadDataCallBack;
        iVar.c(eVar);
    }
}
