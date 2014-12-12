package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.topRec.TRForumListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Integer, Integer, String> {
    private ad CV;
    final /* synthetic */ TopRecActivity ccL;
    TRForumListData.TRForum ccM;
    int id;
    int position;

    private d(TopRecActivity topRecActivity) {
        this.ccL = topRecActivity;
        this.CV = null;
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
        int ik;
        TRForumListData tRForumListData;
        this.id = numArr[0].intValue();
        ik = this.ccL.ik(this.id);
        this.position = ik;
        if (this.position >= 0) {
            tRForumListData = this.ccL.ccF;
            this.ccM = tRForumListData.forum_list[this.position];
        }
        try {
            if (this.ccM != null && this.ccM.forum_id != 0 && this.ccM.forum_name != null) {
                this.CV = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                this.CV.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.ccM.forum_id));
                this.CV.o("kw", this.ccM.forum_name);
                this.CV.o("favo_type", "1");
                this.CV.o("st_type", "from_topRec");
                this.CV.oW().pV().mIsNeedTbs = true;
                this.CV.ov();
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
        this.ccL.ccE = null;
        if (this.CV == null) {
            this.ccL.ah(this.position, this.ccM.forum_id);
        } else if (!this.CV.oW().pW().ma()) {
            this.ccL.ah(this.position, this.ccM.forum_id);
        } else if (str == null) {
            this.ccL.ah(this.position, this.ccM.forum_id);
        } else {
            TbadkApplication.getInst().delLikeForum(this.ccM.forum_name);
            this.ccL.ajw();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        g gVar;
        if (this.CV != null) {
            this.CV.dL();
            this.CV = null;
        }
        gVar = this.ccL.ccB;
        gVar.cR(false);
        this.ccL.ccE = null;
        super.cancel(true);
    }
}
