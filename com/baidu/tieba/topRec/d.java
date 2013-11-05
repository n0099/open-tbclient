package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.topRec.TRForumListData;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    int f2388a;
    int b;
    TRForumListData.TRForum c;
    final /* synthetic */ TopRecActivity d;
    private ag e;

    private d(TopRecActivity topRecActivity) {
        this.d = topRecActivity;
        this.e = null;
        this.f2388a = -1;
        this.b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(TopRecActivity topRecActivity, a aVar) {
        this(topRecActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        int d;
        TRForumListData tRForumListData;
        this.b = numArr[0].intValue();
        d = this.d.d(this.b);
        this.f2388a = d;
        if (this.f2388a >= 0) {
            tRForumListData = this.d.f;
            this.c = tRForumListData.forum_list[this.f2388a];
        }
        try {
            if (this.c != null && this.c.forum_id != 0 && this.c.forum_name != null) {
                this.e = new ag(com.baidu.tieba.data.h.f1165a + "c/c/forum/unfavolike");
                this.e.a("fid", String.valueOf(this.c.forum_id));
                this.e.a("kw", this.c.forum_name);
                this.e.a("favo_type", SocialConstants.TRUE);
                this.e.a("st_type", "from_topRec");
                this.e.e(true);
                this.e.j();
                return null;
            }
            return null;
        } catch (Exception e) {
            be.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((d) str);
        this.d.e = null;
        if (this.e == null) {
            this.d.b(this.f2388a, this.c.forum_id);
        } else if (!this.e.c()) {
            this.d.b(this.f2388a, this.c.forum_id);
        } else if (this.c == null) {
            this.d.b(this.f2388a, this.c.forum_id);
        } else {
            TiebaApplication.g().f(this.c.forum_name);
            this.d.e();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        h hVar;
        if (this.e != null) {
            this.e.h();
            this.e = null;
        }
        hVar = this.d.f2384a;
        hVar.a(false);
        this.d.e = null;
        super.cancel(true);
    }
}
