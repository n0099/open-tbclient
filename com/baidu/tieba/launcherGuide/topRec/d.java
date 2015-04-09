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
    private aa ZF;
    final /* synthetic */ TopRecActivity bxZ;
    TRForumListData.TRForum bya;
    int id;
    int position;

    private d(TopRecActivity topRecActivity) {
        this.bxZ = topRecActivity;
        this.ZF = null;
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
        int gJ;
        TRForumListData tRForumListData;
        this.id = numArr[0].intValue();
        gJ = this.bxZ.gJ(this.id);
        this.position = gJ;
        if (this.position >= 0) {
            tRForumListData = this.bxZ.bxT;
            this.bya = tRForumListData.forum_list[this.position];
        }
        try {
            if (this.bya != null && this.bya.forum_id != 0 && this.bya.forum_name != null) {
                this.ZF = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.ZF.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.bya.forum_id));
                this.ZF.o("kw", this.bya.forum_name);
                this.ZF.o("favo_type", "1");
                this.ZF.o("st_type", "from_topRec");
                this.ZF.sp().tp().mIsNeedTbs = true;
                this.ZF.rO();
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
        this.bxZ.bxS = null;
        if (this.ZF == null) {
            this.bxZ.aa(this.position, this.bya.forum_id);
        } else if (!this.ZF.sp().tq().pv()) {
            this.bxZ.aa(this.position, this.bya.forum_id);
        } else if (str == null) {
            this.bxZ.aa(this.position, this.bya.forum_id);
        } else {
            TbadkApplication.getInst().delLikeForum(this.bya.forum_name);
            this.bxZ.WE();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        g gVar;
        if (this.ZF != null) {
            this.ZF.hh();
            this.ZF = null;
        }
        gVar = this.bxZ.bxP;
        gVar.cI(false);
        this.bxZ.bxS = null;
        super.cancel(true);
    }
}
