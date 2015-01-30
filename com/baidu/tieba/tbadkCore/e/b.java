package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, String> {
    private ad CX = null;
    private int bFv;
    private boolean bze;
    private int cay;
    final /* synthetic */ a caz;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;

    public b(a aVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.caz = aVar;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mPostId = str4;
        this.cay = i;
        this.bFv = i2;
        this.bze = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String str;
        String str2 = TbConfig.SERVER_ADDRESS;
        if (this.cay == 0) {
            str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
        } else {
            str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
        }
        this.CX = new ad(str);
        this.CX.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.CX.o("word", this.mForumName);
        this.CX.o("z", this.mThreadId);
        if (this.cay == 0) {
            if (this.bFv == 0) {
                this.CX.o("delete_my_thread", "1");
            }
        } else if (this.cay == 1) {
            this.CX.o("pid", this.mPostId);
            this.CX.o("isfloor", "0");
            this.CX.o("src", "1");
            if (this.bFv == 0 && this.bze) {
                this.CX.o("delete_my_post", "1");
            }
        } else if (this.cay == 2) {
            this.CX.o("pid", this.mPostId);
            this.CX.o("isfloor", "1");
            this.CX.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            if (this.bFv == 0 && this.bze) {
                this.CX.o("delete_my_post", "1");
            }
        }
        if (this.bFv == 0 && !this.bze) {
            this.CX.o("is_vipdel", "1");
        } else {
            this.CX.o("is_vipdel", "0");
        }
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
        this.caz.cav = null;
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
        super.onPostExecute((b) str);
        this.caz.cav = null;
        if (this.CX == null) {
            iVar2 = this.caz.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        c cVar = new c(this.caz);
        cVar.cay = this.cay;
        cVar.mPostId = this.mPostId;
        cVar.caA = str;
        if (str == null) {
            cVar.qb = true;
        } else {
            cVar.qb = false;
        }
        iVar = this.caz.mLoadDataCallBack;
        iVar.c(cVar);
    }
}
