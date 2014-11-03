package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.aj;
import com.baidu.tieba.topRec.TRForumListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ TopRecActivity bPL;
    TRForumListData.TRForum bPM;
    int id;
    int position;
    private ac yV;

    private d(TopRecActivity topRecActivity) {
        this.bPL = topRecActivity;
        this.yV = null;
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
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        int hu;
        TRForumListData tRForumListData;
        this.id = numArr[0].intValue();
        hu = this.bPL.hu(this.id);
        this.position = hu;
        if (this.position >= 0) {
            tRForumListData = this.bPL.bPF;
            this.bPM = tRForumListData.forum_list[this.position];
        }
        try {
            if (this.bPM != null && this.bPM.forum_id != 0 && this.bPM.forum_name != null) {
                this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
                this.yV.k(ImageViewerConfig.FORUM_ID, String.valueOf(this.bPM.forum_id));
                this.yV.k("kw", this.bPM.forum_name);
                this.yV.k("favo_type", "1");
                this.yV.k("st_type", "from_topRec");
                this.yV.mc().na().mIsNeedTbs = true;
                this.yV.lA();
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
        this.bPL.bPE = null;
        if (this.yV == null) {
            this.bPL.W(this.position, this.bPM.forum_id);
        } else if (!this.yV.mc().nb().jq()) {
            this.bPL.W(this.position, this.bPM.forum_id);
        } else if (str == null) {
            this.bPL.W(this.position, this.bPM.forum_id);
        } else {
            aj.wm().dX(this.bPM.forum_name);
            this.bPL.aes();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        g gVar;
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        gVar = this.bPL.bPB;
        gVar.da(false);
        this.bPL.bPE = null;
        super.cancel(true);
    }
}
