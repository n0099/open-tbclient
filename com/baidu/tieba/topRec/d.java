package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.topRec.TRForumListData;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    int f1866a;
    int b;
    TRForumListData.TRForum c;
    final /* synthetic */ TopRecActivity d;
    private z e;

    private d(TopRecActivity topRecActivity) {
        this.d = topRecActivity;
        this.e = null;
        this.f1866a = -1;
        this.b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(TopRecActivity topRecActivity, d dVar) {
        this(topRecActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        int b;
        TRForumListData tRForumListData;
        this.b = numArr[0].intValue();
        b = this.d.b(this.b);
        this.f1866a = b;
        if (this.f1866a >= 0) {
            tRForumListData = this.d.f;
            this.c = tRForumListData.forum_list[this.f1866a];
        }
        try {
            if (this.c != null && this.c.forum_id != 0 && this.c.forum_name != null) {
                this.e = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/forum/unfavolike");
                this.e.a("fid", String.valueOf(this.c.forum_id));
                this.e.a("kw", this.c.forum_name);
                this.e.a("favo_type", "1");
                this.e.a("st_type", "from_topRec");
                this.e.e(true);
                this.e.j();
                return null;
            }
            return null;
        } catch (Exception e) {
            av.b(getClass().getName(), "doInBackground", e.getMessage());
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
            this.d.a(this.f1866a, this.c.forum_id);
        } else if (!this.e.c()) {
            this.d.a(this.f1866a, this.c.forum_id);
        } else if (this.c == null) {
            this.d.a(this.f1866a, this.c.forum_id);
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
        hVar = this.d.f1862a;
        hVar.a(false);
        this.d.e = null;
        super.cancel(true);
    }
}
