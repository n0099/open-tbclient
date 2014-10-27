package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, String> {
    private int boK;
    private int boL;
    private boolean boM;
    final /* synthetic */ v boN;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;
    private com.baidu.tbadk.core.util.ac yV = null;

    public w(v vVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.boN = vVar;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mPostId = str4;
        this.boK = i;
        this.boL = i2;
        this.boM = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        String str;
        String str2 = TbConfig.SERVER_ADDRESS;
        if (this.boK == 0) {
            str = String.valueOf(str2) + "c/c/bawu/delthread";
        } else {
            str = String.valueOf(str2) + "c/c/bawu/delpost";
        }
        this.yV = new com.baidu.tbadk.core.util.ac(str);
        this.yV.k(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.yV.k("word", this.mForumName);
        this.yV.k("z", this.mThreadId);
        if (this.boK == 0) {
            if (this.boL == 0) {
                this.yV.k("delete_my_thread", "1");
            }
        } else if (this.boK == 1) {
            this.yV.k("pid", this.mPostId);
            this.yV.k("isfloor", "0");
            this.yV.k("src", "1");
            if (this.boL == 0 && this.boM) {
                this.yV.k("delete_my_post", "1");
            }
        } else if (this.boK == 2) {
            this.yV.k("pid", this.mPostId);
            this.yV.k("isfloor", "1");
            this.yV.k("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            if (this.boL == 0 && this.boM) {
                this.yV.k("delete_my_post", "1");
            }
        }
        if (this.boL == 0 && !this.boM) {
            this.yV.k("is_vipdel", "1");
        } else {
            this.yV.k("is_vipdel", "0");
        }
        this.yV.mc().na().mIsNeedTbs = true;
        this.yV.lA();
        if (this.yV.mc().nb().jq()) {
            return null;
        }
        return this.yV.getErrorString();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        if (this.yV != null) {
            this.yV.dM();
        }
        this.boN.boH = null;
        super.cancel(true);
        hVar = this.boN.mLoadDataCallBack;
        hVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute((w) str);
        this.boN.boH = null;
        if (this.yV == null) {
            hVar2 = this.boN.mLoadDataCallBack;
            hVar2.a(null);
            return;
        }
        x xVar = new x(this.boN);
        xVar.boK = this.boK;
        xVar.mPostId = this.mPostId;
        xVar.boO = str;
        if (str == null) {
            xVar.qa = true;
        } else {
            xVar.qa = false;
        }
        hVar = this.boN.mLoadDataCallBack;
        hVar.a(xVar);
    }
}
