package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Integer, Integer, String> {
    private aa ZD;
    final /* synthetic */ TopRecActivity bxJ;
    TRForumListData.TRForum bxK;
    int id;
    int position;

    private d(TopRecActivity topRecActivity) {
        this.bxJ = topRecActivity;
        this.ZD = null;
        this.position = -1;
        this.id = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(TopRecActivity topRecActivity, d dVar) {
        this(topRecActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Integer... numArr) {
        int gH;
        TRForumListData tRForumListData;
        this.id = numArr[0].intValue();
        gH = this.bxJ.gH(this.id);
        this.position = gH;
        if (this.position >= 0) {
            tRForumListData = this.bxJ.bxD;
            this.bxK = tRForumListData.forum_list[this.position];
        }
        try {
            if (this.bxK != null && this.bxK.forum_id != 0 && this.bxK.forum_name != null) {
                this.ZD = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.ZD.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.bxK.forum_id));
                this.ZD.o("kw", this.bxK.forum_name);
                this.ZD.o("favo_type", "1");
                this.ZD.o("st_type", "from_topRec");
                this.ZD.sp().tp().mIsNeedTbs = true;
                this.ZD.rO();
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((d) str);
        this.bxJ.bxC = null;
        if (this.ZD == null) {
            this.bxJ.aa(this.position, this.bxK.forum_id);
        } else if (!this.ZD.sp().tq().pv()) {
            this.bxJ.aa(this.position, this.bxK.forum_id);
        } else if (str == null) {
            this.bxJ.aa(this.position, this.bxK.forum_id);
        } else {
            TbadkApplication.getInst().delLikeForum(this.bxK.forum_name);
            this.bxJ.Wr();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        g gVar;
        if (this.ZD != null) {
            this.ZD.hh();
            this.ZD = null;
        }
        gVar = this.bxJ.bxz;
        gVar.cK(false);
        this.bxJ.bxC = null;
        super.cancel(true);
    }
}
