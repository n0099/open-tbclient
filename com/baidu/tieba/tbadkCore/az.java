package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class az extends BdAsyncTask<Integer, Integer, Integer> {
    private String Wu;
    private com.baidu.tbadk.core.util.aa ZF = null;
    private WeakReference<ay> cnL;
    private long mForumId;
    private String mForumName;

    public az(String str, long j, String str2, ay ayVar) {
        this.mForumName = null;
        this.mForumId = 0L;
        this.cnL = null;
        this.mForumName = str;
        this.mForumId = j;
        this.cnL = new WeakReference<>(ayVar);
        this.Wu = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public Integer doInBackground(Integer... numArr) {
        try {
            if (this.mForumId != 0 && this.mForumName != null) {
                this.ZF = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.ZF.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                this.ZF.o("kw", this.mForumName);
                this.ZF.o("favo_type", "1");
                this.ZF.o("st_type", this.Wu);
                this.ZF.sp().tp().mIsNeedTbs = true;
                this.ZF.rO();
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
        if (this.cnL != null && (ayVar = this.cnL.get()) != null) {
            if (this.ZF != null) {
                if (this.ZF.sp().tq().pv()) {
                    if (num.intValue() == 1) {
                        TbadkCoreApplication.m411getInst().delLikeForum(this.mForumName);
                        ayVar.d(this.mForumName, this.mForumId);
                        return;
                    }
                    ayVar.e(this.mForumName, this.mForumId);
                    return;
                }
                ayVar.e(this.mForumName, this.mForumId);
                return;
            }
            ayVar.e(this.mForumName, this.mForumId);
        }
    }
}
