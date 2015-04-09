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
    private aa ZF = null;
    private boolean aVz;
    private int bNr;
    private int cpQ;
    final /* synthetic */ a cpR;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;

    public b(a aVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.cpR = aVar;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mPostId = str4;
        this.cpQ = i;
        this.bNr = i2;
        this.aVz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String str;
        String str2 = TbConfig.SERVER_ADDRESS;
        if (this.cpQ == 0) {
            str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
        } else {
            str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
        }
        this.ZF = new aa(str);
        this.ZF.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.ZF.o("word", this.mForumName);
        this.ZF.o("z", this.mThreadId);
        if (this.cpQ == 0) {
            if (this.bNr == 0) {
                this.ZF.o("delete_my_thread", "1");
            }
        } else if (this.cpQ == 1) {
            this.ZF.o("pid", this.mPostId);
            this.ZF.o("isfloor", GameInfoData.NOT_FROM_DETAIL);
            this.ZF.o("src", "1");
            if (this.bNr == 0 && this.aVz) {
                this.ZF.o("delete_my_post", "1");
            }
        } else if (this.cpQ == 2) {
            this.ZF.o("pid", this.mPostId);
            this.ZF.o("isfloor", "1");
            this.ZF.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            if (this.bNr == 0 && this.aVz) {
                this.ZF.o("delete_my_post", "1");
            }
        }
        if (this.bNr == 0 && !this.aVz) {
            this.ZF.o("is_vipdel", "1");
        } else {
            this.ZF.o("is_vipdel", GameInfoData.NOT_FROM_DETAIL);
        }
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
        this.cpR.cpN = null;
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
        super.onPostExecute((b) str);
        this.cpR.cpN = null;
        if (this.ZF == null) {
            iVar2 = this.cpR.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        c cVar = new c(this.cpR);
        cVar.cpQ = this.cpQ;
        cVar.mPostId = this.mPostId;
        cVar.cpS = str;
        if (str == null) {
            cVar.AM = true;
        } else {
            cVar.AM = false;
        }
        iVar = this.cpR.mLoadDataCallBack;
        iVar.c(cVar);
    }
}
