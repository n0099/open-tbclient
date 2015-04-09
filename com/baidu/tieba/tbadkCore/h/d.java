package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, String> {
    private aa ZF;
    private String acU;
    private String bFR;
    final /* synthetic */ a cpR;
    private String mForumId;
    private String mForumName;
    private String mThreadId;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        this.ZF = new aa(strArr[0]);
        this.ZF.o("day", this.bFR);
        this.ZF.o("un", this.acU);
        this.ZF.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.ZF.o("word", this.mForumName);
        this.ZF.o("z", this.mThreadId);
        this.ZF.o("ntn", "banid");
        this.ZF.sp().tp().mIsNeedTbs = true;
        this.ZF.rO();
        if (this.ZF.sp().tq().pv()) {
            return null;
        }
        return this.ZF.getErrorString();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.ZF != null) {
            this.ZF.hh();
        }
        this.cpR.cpO = null;
        super.cancel(true);
        iVar = this.cpR.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        i iVar;
        i iVar2;
        super.onPostExecute((d) str);
        this.cpR.cpO = null;
        if (this.ZF == null) {
            iVar2 = this.cpR.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        e eVar = new e(this.cpR);
        if (str == null) {
            eVar.AM = true;
        } else {
            eVar.AM = false;
            eVar.cpS = str;
        }
        iVar = this.cpR.mLoadDataCallBack;
        iVar.c(eVar);
    }
}
