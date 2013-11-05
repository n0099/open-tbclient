package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
import com.google.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Object, Integer, TRForumListData> {

    /* renamed from: a  reason: collision with root package name */
    TRForumListData f2397a;
    final /* synthetic */ l b;
    private ag c;

    private n(l lVar) {
        this.b = lVar;
        this.c = null;
        this.f2397a = new TRForumListData();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public TRForumListData a(Object... objArr) {
        String j;
        try {
            this.c = new ag(com.baidu.tieba.data.h.f1165a + "c/f/forum/random_recommend_forum");
            this.c.a("rn", "100");
            j = this.c.j();
            be.e("TopRecModel", "doInBackground", j);
        } catch (Exception e) {
            be.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (j == null) {
            return null;
        }
        if (!this.c.c()) {
            this.b.c = false;
        } else {
            this.f2397a = (TRForumListData) new GsonBuilder().create().fromJson(j, (Class<Object>) TRForumListData.class);
            this.b.c = true;
            be.c(this.f2397a.toString());
        }
        return this.f2397a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(TRForumListData tRForumListData) {
        boolean z;
        boolean z2;
        super.a((n) tRForumListData);
        if (tRForumListData != null) {
            be.c(tRForumListData.toString());
            if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                o oVar = this.b.b;
                z2 = this.b.c;
                oVar.a(Boolean.valueOf(z2), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                return;
            }
            o oVar2 = this.b.b;
            z = this.b.c;
            oVar2.a(Boolean.valueOf(z), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
        }
    }
}
