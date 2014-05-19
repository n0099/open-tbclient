package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.ad;
import com.baidu.tieba.topRec.TRForumListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Integer, Integer, String> {
    int a;
    int b;
    TRForumListData.TRForum c;
    final /* synthetic */ TopRecActivity d;
    private al e;

    private d(TopRecActivity topRecActivity) {
        this.d = topRecActivity;
        this.e = null;
        this.a = -1;
        this.b = 0;
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
        int a;
        TRForumListData tRForumListData;
        this.b = numArr[0].intValue();
        a = this.d.a(this.b);
        this.a = a;
        if (this.a >= 0) {
            tRForumListData = this.d.f;
            this.c = tRForumListData.forum_list[this.a];
        }
        try {
            if (this.c != null && this.c.forum_id != 0 && this.c.forum_name != null) {
                this.e = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
                this.e.a("fid", String.valueOf(this.c.forum_id));
                this.e.a("kw", this.c.forum_name);
                this.e.a("favo_type", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                this.e.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "from_topRec");
                this.e.a().a().a = true;
                this.e.i();
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        this.d.e = null;
        if (this.e == null) {
            this.d.a(this.a, this.c.forum_id);
        } else if (!this.e.a().b().b()) {
            this.d.a(this.a, this.c.forum_id);
        } else if (str == null) {
            this.d.a(this.a, this.c.forum_id);
        } else {
            ad.c().f(this.c.forum_name);
            this.d.d();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        h hVar;
        if (this.e != null) {
            this.e.g();
            this.e = null;
        }
        hVar = this.d.a;
        hVar.a(false);
        this.d.e = null;
        super.cancel(true);
    }
}
