package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, String> {
    private ad CU = null;
    private int bFu;
    private boolean bzd;
    private int cax;
    final /* synthetic */ a cay;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;

    public b(a aVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.cay = aVar;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mPostId = str4;
        this.cax = i;
        this.bFu = i2;
        this.bzd = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String str;
        String str2 = TbConfig.SERVER_ADDRESS;
        if (this.cax == 0) {
            str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
        } else {
            str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
        }
        this.CU = new ad(str);
        this.CU.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.CU.o("word", this.mForumName);
        this.CU.o("z", this.mThreadId);
        if (this.cax == 0) {
            if (this.bFu == 0) {
                this.CU.o("delete_my_thread", "1");
            }
        } else if (this.cax == 1) {
            this.CU.o("pid", this.mPostId);
            this.CU.o("isfloor", "0");
            this.CU.o("src", "1");
            if (this.bFu == 0 && this.bzd) {
                this.CU.o("delete_my_post", "1");
            }
        } else if (this.cax == 2) {
            this.CU.o("pid", this.mPostId);
            this.CU.o("isfloor", "1");
            this.CU.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            if (this.bFu == 0 && this.bzd) {
                this.CU.o("delete_my_post", "1");
            }
        }
        if (this.bFu == 0 && !this.bzd) {
            this.CU.o("is_vipdel", "1");
        } else {
            this.CU.o("is_vipdel", "0");
        }
        this.CU.oS().pZ().mIsNeedTbs = true;
        this.CU.or();
        if (this.CU.oS().qa().lT()) {
            return null;
        }
        return this.CU.getErrorString();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.CU != null) {
            this.CU.dJ();
        }
        this.cay.cau = null;
        super.cancel(true);
        iVar = this.cay.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        i iVar;
        i iVar2;
        super.onPostExecute((b) str);
        this.cay.cau = null;
        if (this.CU == null) {
            iVar2 = this.cay.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        c cVar = new c(this.cay);
        cVar.cax = this.cax;
        cVar.mPostId = this.mPostId;
        cVar.caz = str;
        if (str == null) {
            cVar.qb = true;
        } else {
            cVar.qb = false;
        }
        iVar = this.cay.mLoadDataCallBack;
        iVar.c(cVar);
    }
}
