package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.topRec.TRForumListData;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    int f2547a;
    int b;
    TRForumListData.TRForum c;
    final /* synthetic */ TopRecActivity d;
    private am e;

    private d(TopRecActivity topRecActivity) {
        this.d = topRecActivity;
        this.e = null;
        this.f2547a = -1;
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
        int a2;
        TRForumListData tRForumListData;
        this.b = numArr[0].intValue();
        a2 = this.d.a(this.b);
        this.f2547a = a2;
        if (this.f2547a >= 0) {
            tRForumListData = this.d.f;
            this.c = tRForumListData.forum_list[this.f2547a];
        }
        try {
            if (this.c != null && this.c.forum_id != 0 && this.c.forum_name != null) {
                this.e = new am(com.baidu.tieba.data.h.f1248a + "c/c/forum/unfavolike");
                this.e.a("fid", String.valueOf(this.c.forum_id));
                this.e.a("kw", this.c.forum_name);
                this.e.a("favo_type", SocialConstants.TRUE);
                this.e.a("st_type", "from_topRec");
                this.e.e(true);
                this.e.l();
                return null;
            }
            return null;
        } catch (Exception e) {
            bd.b(getClass().getName(), "doInBackground", e.getMessage());
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
            this.d.a(this.f2547a, this.c.forum_id);
        } else if (!this.e.c()) {
            this.d.a(this.f2547a, this.c.forum_id);
        } else if (str == null) {
            this.d.a(this.f2547a, this.c.forum_id);
        } else {
            TiebaApplication.h().g(this.c.forum_name);
            this.d.d();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        h hVar;
        if (this.e != null) {
            this.e.j();
            this.e = null;
        }
        hVar = this.d.f2543a;
        hVar.a(false);
        this.d.e = null;
        super.cancel(true);
    }
}
