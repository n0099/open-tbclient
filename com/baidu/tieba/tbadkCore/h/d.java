package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, String> {
    private aa aaG;
    private String aec;
    private String bIM;
    final /* synthetic */ a ctS;
    private String mForumId;
    private String mForumName;
    private String mThreadId;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        this.aaG = new aa(strArr[0]);
        this.aaG.o("day", this.bIM);
        this.aaG.o("un", this.aec);
        this.aaG.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.aaG.o("word", this.mForumName);
        this.aaG.o("z", this.mThreadId);
        this.aaG.o("ntn", "banid");
        this.aaG.sX().tS().mIsNeedTbs = true;
        this.aaG.sw();
        if (this.aaG.sX().tT().qa()) {
            return null;
        }
        return this.aaG.getErrorString();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.aaG != null) {
            this.aaG.gS();
        }
        this.ctS.ctP = null;
        super.cancel(true);
        iVar = this.ctS.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        i iVar;
        i iVar2;
        super.onPostExecute((d) str);
        this.ctS.ctP = null;
        if (this.aaG == null) {
            iVar2 = this.ctS.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        e eVar = new e(this.ctS);
        if (str == null) {
            eVar.AA = true;
        } else {
            eVar.AA = false;
            eVar.ctT = str;
        }
        iVar = this.ctS.mLoadDataCallBack;
        iVar.c(eVar);
    }
}
