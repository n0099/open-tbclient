package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, String> {
    private aa ZD = null;
    private boolean aVk;
    private int bNb;
    private int cpA;
    final /* synthetic */ a cpB;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;

    public b(a aVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.cpB = aVar;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mPostId = str4;
        this.cpA = i;
        this.bNb = i2;
        this.aVk = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String str;
        String str2 = TbConfig.SERVER_ADDRESS;
        if (this.cpA == 0) {
            str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
        } else {
            str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
        }
        this.ZD = new aa(str);
        this.ZD.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.ZD.o("word", this.mForumName);
        this.ZD.o("z", this.mThreadId);
        if (this.cpA == 0) {
            if (this.bNb == 0) {
                this.ZD.o("delete_my_thread", "1");
            }
        } else if (this.cpA == 1) {
            this.ZD.o("pid", this.mPostId);
            this.ZD.o("isfloor", GameInfoData.NOT_FROM_DETAIL);
            this.ZD.o("src", "1");
            if (this.bNb == 0 && this.aVk) {
                this.ZD.o("delete_my_post", "1");
            }
        } else if (this.cpA == 2) {
            this.ZD.o("pid", this.mPostId);
            this.ZD.o("isfloor", "1");
            this.ZD.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            if (this.bNb == 0 && this.aVk) {
                this.ZD.o("delete_my_post", "1");
            }
        }
        if (this.bNb == 0 && !this.aVk) {
            this.ZD.o("is_vipdel", "1");
        } else {
            this.ZD.o("is_vipdel", GameInfoData.NOT_FROM_DETAIL);
        }
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
        this.cpB.cpx = null;
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
        super.onPostExecute((b) str);
        this.cpB.cpx = null;
        if (this.ZD == null) {
            iVar2 = this.cpB.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        c cVar = new c(this.cpB);
        cVar.cpA = this.cpA;
        cVar.mPostId = this.mPostId;
        cVar.cpC = str;
        if (str == null) {
            cVar.AM = true;
        } else {
            cVar.AM = false;
        }
        iVar = this.cpB.mLoadDataCallBack;
        iVar.c(cVar);
    }
}
