package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<String, Integer, String> {
    private String agz;
    final /* synthetic */ v bpb;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private String mUserName;
    private com.baidu.tbadk.core.util.ac yV;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        this.yV = new com.baidu.tbadk.core.util.ac(strArr[0]);
        this.yV.k("day", this.agz);
        this.yV.k("un", this.mUserName);
        this.yV.k(ImageViewerConfig.FORUM_ID, this.mForumId);
        this.yV.k("word", this.mForumName);
        this.yV.k("z", this.mThreadId);
        this.yV.k("ntn", "banid");
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
        this.bpb.boW = null;
        super.cancel(true);
        hVar = this.bpb.mLoadDataCallBack;
        hVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute((y) str);
        this.bpb.boW = null;
        if (this.yV == null) {
            hVar2 = this.bpb.mLoadDataCallBack;
            hVar2.a(null);
            return;
        }
        z zVar = new z(this.bpb);
        if (str == null) {
            zVar.qa = true;
        } else {
            zVar.qa = false;
            zVar.bpc = str;
        }
        hVar = this.bpb.mLoadDataCallBack;
        hVar.a(zVar);
    }
}
