package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, String> {
    private ad CV = null;
    private int bDK;
    private int bYF;
    final /* synthetic */ a bYG;
    private boolean bxv;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;

    public b(a aVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.bYG = aVar;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mPostId = str4;
        this.bYF = i;
        this.bDK = i2;
        this.bxv = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String str;
        String str2 = TbConfig.SERVER_ADDRESS;
        if (this.bYF == 0) {
            str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
        } else {
            str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
        }
        this.CV = new ad(str);
        this.CV.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.CV.o("word", this.mForumName);
        this.CV.o("z", this.mThreadId);
        if (this.bYF == 0) {
            if (this.bDK == 0) {
                this.CV.o("delete_my_thread", "1");
            }
        } else if (this.bYF == 1) {
            this.CV.o("pid", this.mPostId);
            this.CV.o("isfloor", "0");
            this.CV.o("src", "1");
            if (this.bDK == 0 && this.bxv) {
                this.CV.o("delete_my_post", "1");
            }
        } else if (this.bYF == 2) {
            this.CV.o("pid", this.mPostId);
            this.CV.o("isfloor", "1");
            this.CV.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            if (this.bDK == 0 && this.bxv) {
                this.CV.o("delete_my_post", "1");
            }
        }
        if (this.bDK == 0 && !this.bxv) {
            this.CV.o("is_vipdel", "1");
        } else {
            this.CV.o("is_vipdel", "0");
        }
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
        this.bYG.bYC = null;
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
        super.onPostExecute((b) str);
        this.bYG.bYC = null;
        if (this.CV == null) {
            iVar2 = this.bYG.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        c cVar = new c(this.bYG);
        cVar.bYF = this.bYF;
        cVar.mPostId = this.mPostId;
        cVar.bYH = str;
        if (str == null) {
            cVar.pW = true;
        } else {
            cVar.pW = false;
        }
        iVar = this.bYG.mLoadDataCallBack;
        iVar.c(cVar);
    }
}
