package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, String> {
    private ad CV;
    private String anQ;
    final /* synthetic */ a bYG;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private String mUserName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        this.CV = new ad(strArr[0]);
        this.CV.o("day", this.anQ);
        this.CV.o("un", this.mUserName);
        this.CV.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.CV.o("word", this.mForumName);
        this.CV.o("z", this.mThreadId);
        this.CV.o("ntn", "banid");
        this.CV.oW().pV().mIsNeedTbs = true;
        this.CV.ov();
        if (this.CV.oW().pW().ma()) {
            return null;
        }
        return this.CV.getErrorString();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.CV != null) {
            this.CV.dL();
        }
        this.bYG.bYD = null;
        super.cancel(true);
        iVar = this.bYG.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        i iVar;
        i iVar2;
        super.onPostExecute((d) str);
        this.bYG.bYD = null;
        if (this.CV == null) {
            iVar2 = this.bYG.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        e eVar = new e(this.bYG);
        if (str == null) {
            eVar.pW = true;
        } else {
            eVar.pW = false;
            eVar.bYH = str;
        }
        iVar = this.bYG.mLoadDataCallBack;
        iVar.c(eVar);
    }
}
