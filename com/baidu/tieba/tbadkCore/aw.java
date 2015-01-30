package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class aw extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tbadk.core.util.ad CX = null;
    private String KT;
    private WeakReference<av> bXB;
    private long mForumId;
    private String mForumName;

    public aw(String str, long j, String str2, av avVar) {
        this.mForumName = null;
        this.mForumId = 0L;
        this.bXB = null;
        this.mForumName = str;
        this.mForumId = j;
        this.bXB = new WeakReference<>(avVar);
        this.KT = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public Integer doInBackground(Integer... numArr) {
        try {
            if (this.mForumId != 0 && this.mForumName != null) {
                this.CX = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.CX.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                this.CX.o("kw", this.mForumName);
                this.CX.o("favo_type", "1");
                this.CX.o("st_type", this.KT);
                this.CX.oZ().qg().mIsNeedTbs = true;
                this.CX.oy();
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
    public void onPostExecute(Integer num) {
        av avVar;
        super.onPostExecute((aw) num);
        if (this.bXB != null && (avVar = this.bXB.get()) != null) {
            if (this.CX != null) {
                if (this.CX.oZ().qh().ma()) {
                    if (num.intValue() == 1) {
                        TbadkCoreApplication.m255getInst().delLikeForum(this.mForumName);
                        avVar.f(this.mForumName, this.mForumId);
                        return;
                    }
                    avVar.g(this.mForumName, this.mForumId);
                    return;
                }
                avVar.g(this.mForumName, this.mForumId);
                return;
            }
            avVar.g(this.mForumName, this.mForumId);
        }
    }
}
