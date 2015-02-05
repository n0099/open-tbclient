package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class aw extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tbadk.core.util.ad CU = null;
    private String KQ;
    private WeakReference<av> bXA;
    private long mForumId;
    private String mForumName;

    public aw(String str, long j, String str2, av avVar) {
        this.mForumName = null;
        this.mForumId = 0L;
        this.bXA = null;
        this.mForumName = str;
        this.mForumId = j;
        this.bXA = new WeakReference<>(avVar);
        this.KQ = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public Integer doInBackground(Integer... numArr) {
        try {
            if (this.mForumId != 0 && this.mForumName != null) {
                this.CU = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.CU.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                this.CU.o("kw", this.mForumName);
                this.CU.o("favo_type", "1");
                this.CU.o("st_type", this.KQ);
                this.CU.oS().pZ().mIsNeedTbs = true;
                this.CU.or();
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
        if (this.bXA != null && (avVar = this.bXA.get()) != null) {
            if (this.CU != null) {
                if (this.CU.oS().qa().lT()) {
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
