package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
import com.google.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, TRForumListData> {

    /* renamed from: a  reason: collision with root package name */
    TRForumListData f1875a;
    final /* synthetic */ l b;
    private z c;

    private m(l lVar) {
        this.b = lVar;
        this.c = null;
        this.f1875a = new TRForumListData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(l lVar, m mVar) {
        this(lVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public TRForumListData a(Object... objArr) {
        String j;
        try {
            this.c = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/forum/random_recommend_forum");
            this.c.a("rn", "100");
            j = this.c.j();
            av.e("TopRecModel", "doInBackground", j);
        } catch (Exception e) {
            av.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (j == null) {
            return null;
        }
        if (!this.c.c()) {
            this.b.c = false;
        } else {
            this.f1875a = (TRForumListData) new GsonBuilder().create().fromJson(j, (Class<Object>) TRForumListData.class);
            this.b.c = true;
            av.c(this.f1875a.toString());
        }
        return this.f1875a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(TRForumListData tRForumListData) {
        boolean z;
        boolean z2;
        super.a((m) tRForumListData);
        if (tRForumListData != null) {
            av.c(tRForumListData.toString());
            if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                n nVar = this.b.b;
                z2 = this.b.c;
                nVar.a(Boolean.valueOf(z2), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                return;
            }
            n nVar2 = this.b.b;
            z = this.b.c;
            nVar2.a(Boolean.valueOf(z), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
        }
    }
}
