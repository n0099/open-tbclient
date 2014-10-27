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
    final /* synthetic */ TopRecActivity bPw;
    TRForumListData.TRForum bPx;
    int id;
    int position;
    private ac yV;

    private d(TopRecActivity topRecActivity) {
        this.bPw = topRecActivity;
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
        hu = this.bPw.hu(this.id);
        this.position = hu;
        if (this.position >= 0) {
            tRForumListData = this.bPw.bPq;
            this.bPx = tRForumListData.forum_list[this.position];
        }
        try {
            if (this.bPx != null && this.bPx.forum_id != 0 && this.bPx.forum_name != null) {
                this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
                this.yV.k(ImageViewerConfig.FORUM_ID, String.valueOf(this.bPx.forum_id));
                this.yV.k("kw", this.bPx.forum_name);
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
        this.bPw.bPp = null;
        if (this.yV == null) {
            this.bPw.W(this.position, this.bPx.forum_id);
        } else if (!this.yV.mc().nb().jq()) {
            this.bPw.W(this.position, this.bPx.forum_id);
        } else if (str == null) {
            this.bPw.W(this.position, this.bPx.forum_id);
        } else {
            aj.wk().dX(this.bPx.forum_name);
            this.bPw.aep();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        g gVar;
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        gVar = this.bPw.bPm;
        gVar.da(false);
        this.bPw.bPp = null;
        super.cancel(true);
    }
}
