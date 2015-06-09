package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class az extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tbadk.core.util.aa aaG = null;
    private WeakReference<ay> crK;
    private long mForumId;
    private String mForumName;
    private String mFrom;

    public az(String str, long j, String str2, ay ayVar) {
        this.mForumName = null;
        this.mForumId = 0L;
        this.crK = null;
        this.mForumName = str;
        this.mForumId = j;
        this.crK = new WeakReference<>(ayVar);
        this.mFrom = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public Integer doInBackground(Integer... numArr) {
        try {
            if (this.mForumId != 0 && this.mForumName != null) {
                this.aaG = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.aaG.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                this.aaG.o("kw", this.mForumName);
                this.aaG.o("favo_type", "1");
                this.aaG.o("st_type", this.mFrom);
                this.aaG.sX().tS().mIsNeedTbs = true;
                this.aaG.sw();
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
        ay ayVar;
        super.onPostExecute((az) num);
        if (this.crK != null && (ayVar = this.crK.get()) != null) {
            if (this.aaG != null) {
                if (this.aaG.sX().tT().qa()) {
                    if (num.intValue() == 1) {
                        TbadkCoreApplication.m411getInst().delLikeForum(this.mForumName);
                        ayVar.g(this.mForumName, this.mForumId);
                        return;
                    }
                    ayVar.h(this.mForumName, this.mForumId);
                    return;
                }
                ayVar.h(this.mForumName, this.mForumId);
                return;
            }
            ayVar.h(this.mForumName, this.mForumId);
        }
    }
}
