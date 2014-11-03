package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends BdAsyncTask<Integer, Integer, Integer> {
    private String Gp;
    private WeakReference<bd> bqd;
    private long mForumId;
    private String mForumName;
    private com.baidu.tbadk.core.util.ac yV = null;

    public be(String str, long j, String str2, bd bdVar) {
        this.mForumName = null;
        this.mForumId = 0L;
        this.bqd = null;
        this.mForumName = str;
        this.mForumId = j;
        this.bqd = new WeakReference<>(bdVar);
        this.Gp = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public Integer doInBackground(Integer... numArr) {
        try {
            if (this.mForumId != 0 && this.mForumName != null) {
                this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
                this.yV.k(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                this.yV.k("kw", this.mForumName);
                this.yV.k("favo_type", "1");
                this.yV.k("st_type", this.Gp);
                this.yV.mc().na().mIsNeedTbs = true;
                this.yV.lA();
            }
            return 1;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        bd bdVar;
        super.onPostExecute(num);
        if (this.bqd != null && (bdVar = this.bqd.get()) != null) {
            if (this.yV != null) {
                if (this.yV.mc().nb().jq()) {
                    if (num.intValue() == 1) {
                        com.baidu.tieba.aj.wm().dX(this.mForumName);
                        bdVar.d(this.mForumName, this.mForumId);
                        return;
                    }
                    bdVar.e(this.mForumName, this.mForumId);
                    return;
                }
                bdVar.e(this.mForumName, this.mForumId);
                return;
            }
            bdVar.e(this.mForumName, this.mForumId);
        }
    }
}
