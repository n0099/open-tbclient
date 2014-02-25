package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, TRForumListData> {
    TRForumListData a;
    final /* synthetic */ l b;
    private ba c;

    private m(l lVar) {
        this.b = lVar;
        this.c = null;
        this.a = new TRForumListData();
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
        String m;
        try {
            this.c = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/random_recommend_forum");
            this.c.a("rn", "100");
            m = this.c.m();
            com.baidu.adp.lib.util.f.e("TopRecModel", "doInBackground", m);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (m == null) {
            return null;
        }
        if (!this.c.d()) {
            this.b.c = false;
        } else {
            this.a = (TRForumListData) new GsonBuilder().create().fromJson(m, (Class<Object>) TRForumListData.class);
            this.b.c = true;
            com.baidu.adp.lib.util.f.e(this.a.toString());
        }
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(TRForumListData tRForumListData) {
        boolean z;
        boolean z2;
        super.a((m) tRForumListData);
        if (tRForumListData != null) {
            com.baidu.adp.lib.util.f.e(tRForumListData.toString());
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
