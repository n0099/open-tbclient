package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class az extends BdAsyncTask<Integer, Integer, Integer> {
    private String Ws;
    private com.baidu.tbadk.core.util.aa ZD = null;
    private WeakReference<ay> cnv;
    private long mForumId;
    private String mForumName;

    public az(String str, long j, String str2, ay ayVar) {
        this.mForumName = null;
        this.mForumId = 0L;
        this.cnv = null;
        this.mForumName = str;
        this.mForumId = j;
        this.cnv = new WeakReference<>(ayVar);
        this.Ws = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public Integer doInBackground(Integer... numArr) {
        try {
            if (this.mForumId != 0 && this.mForumName != null) {
                this.ZD = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.ZD.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                this.ZD.o("kw", this.mForumName);
                this.ZD.o("favo_type", "1");
                this.ZD.o("st_type", this.Ws);
                this.ZD.sp().tp().mIsNeedTbs = true;
                this.ZD.rO();
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
        if (this.cnv != null && (ayVar = this.cnv.get()) != null) {
            if (this.ZD != null) {
                if (this.ZD.sp().tq().pv()) {
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
