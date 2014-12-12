package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class aw extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tbadk.core.util.ad CV = null;
    private WeakReference<av> bVJ;
    private long mForumId;
    private String mForumName;
    private String mFrom;

    public aw(String str, long j, String str2, av avVar) {
        this.mForumName = null;
        this.mForumId = 0L;
        this.bVJ = null;
        this.mForumName = str;
        this.mForumId = j;
        this.bVJ = new WeakReference<>(avVar);
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
                this.CV = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.CV.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                this.CV.o("kw", this.mForumName);
                this.CV.o("favo_type", "1");
                this.CV.o("st_type", this.mFrom);
                this.CV.oW().pV().mIsNeedTbs = true;
                this.CV.ov();
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
        if (this.bVJ != null && (avVar = this.bVJ.get()) != null) {
            if (this.CV != null) {
                if (this.CV.oW().pW().ma()) {
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
