package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.topRec.TRForumListData;
/* loaded from: classes.dex */
final class d extends BdAsyncTask<Integer, Integer, String> {
    int a;
    int b;
    TRForumListData.TRForum c;
    final /* synthetic */ TopRecActivity d;
    private ak e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        super.a((d) str2);
        this.d.e = null;
        if (this.e == null) {
            TopRecActivity topRecActivity = this.d;
            int i = this.a;
            int i2 = this.c.forum_id;
            topRecActivity.a(i);
        } else if (!this.e.a().b().b()) {
            TopRecActivity topRecActivity2 = this.d;
            int i3 = this.a;
            int i4 = this.c.forum_id;
            topRecActivity2.a(i3);
        } else if (str2 == null) {
            TopRecActivity topRecActivity3 = this.d;
            int i5 = this.a;
            int i6 = this.c.forum_id;
            topRecActivity3.a(i5);
        } else {
            com.baidu.tieba.p.c().f(this.c.forum_name);
            this.d.b();
        }
    }

    private d(TopRecActivity topRecActivity) {
        this.d = topRecActivity;
        this.e = null;
        this.a = -1;
        this.b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(TopRecActivity topRecActivity, byte b) {
        this(topRecActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        int c;
        TRForumListData tRForumListData;
        this.b = numArr[0].intValue();
        c = this.d.c(this.b);
        this.a = c;
        if (this.a >= 0) {
            tRForumListData = this.d.f;
            this.c = tRForumListData.forum_list[this.a];
        }
        try {
            if (this.c != null && this.c.forum_id != 0 && this.c.forum_name != null) {
                this.e = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/forum/unfavolike");
                this.e.a("fid", String.valueOf(this.c.forum_id));
                this.e.a("kw", this.c.forum_name);
                this.e.a("favo_type", "1");
                this.e.a("st_type", "from_topRec");
                this.e.a().a().a = true;
                this.e.i();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
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
