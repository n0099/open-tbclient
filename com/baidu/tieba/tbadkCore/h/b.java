package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, String> {
    private boolean aYf;
    private aa aaG = null;
    private int bPX;
    private int ctR;
    final /* synthetic */ a ctS;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;

    public b(a aVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.ctS = aVar;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mPostId = str4;
        this.ctR = i;
        this.bPX = i2;
        this.aYf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String str;
        String str2 = TbConfig.SERVER_ADDRESS;
        if (this.ctR == 0) {
            str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
        } else {
            str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
        }
        this.aaG = new aa(str);
        this.aaG.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.aaG.o("word", this.mForumName);
        this.aaG.o("z", this.mThreadId);
        if (this.ctR == 0) {
            if (this.bPX == 0) {
                this.aaG.o("delete_my_thread", "1");
            }
        } else if (this.ctR == 1) {
            this.aaG.o(Info.kBaiduPIDKey, this.mPostId);
            this.aaG.o("isfloor", GameInfoData.NOT_FROM_DETAIL);
            this.aaG.o("src", "1");
            if (this.bPX == 0 && this.aYf) {
                this.aaG.o("delete_my_post", "1");
            }
        } else if (this.ctR == 2) {
            this.aaG.o(Info.kBaiduPIDKey, this.mPostId);
            this.aaG.o("isfloor", "1");
            this.aaG.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            if (this.bPX == 0 && this.aYf) {
                this.aaG.o("delete_my_post", "1");
            }
        }
        if (this.bPX == 0 && !this.aYf) {
            this.aaG.o("is_vipdel", "1");
        } else {
            this.aaG.o("is_vipdel", GameInfoData.NOT_FROM_DETAIL);
        }
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
        this.ctS.ctO = null;
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
        super.onPostExecute((b) str);
        this.ctS.ctO = null;
        if (this.aaG == null) {
            iVar2 = this.ctS.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        c cVar = new c(this.ctS);
        cVar.ctR = this.ctR;
        cVar.mPostId = this.mPostId;
        cVar.ctT = str;
        if (str == null) {
            cVar.AA = true;
        } else {
            cVar.AA = false;
        }
        iVar = this.ctS.mLoadDataCallBack;
        iVar.c(cVar);
    }
}
