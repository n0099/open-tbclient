package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<Object, Integer, TRForumListData> {
    TRForumListData a;
    final /* synthetic */ l b;
    private ak c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ TRForumListData a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(TRForumListData tRForumListData) {
        boolean z;
        boolean z2;
        TRForumListData tRForumListData2 = tRForumListData;
        super.a((m) tRForumListData2);
        if (tRForumListData2 != null) {
            com.baidu.adp.lib.util.f.e(tRForumListData2.toString());
            if (tRForumListData2.error_code != 0 || tRForumListData2.error == null) {
                n nVar = this.b.b;
                z = this.b.c;
                nVar.a(Boolean.valueOf(z), tRForumListData2, tRForumListData2.error_code, tRForumListData2.error_msg);
                return;
            }
            n nVar2 = this.b.b;
            z2 = this.b.c;
            nVar2.a(Boolean.valueOf(z2), tRForumListData2, tRForumListData2.error.errno, tRForumListData2.error.usermsg);
        }
    }

    private m(l lVar) {
        this.b = lVar;
        this.c = null;
        this.a = new TRForumListData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(l lVar, byte b) {
        this(lVar);
    }

    private TRForumListData a() {
        String i;
        try {
            this.c = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/forum/random_recommend_forum");
            this.c.a("rn", "100");
            i = this.c.i();
            com.baidu.adp.lib.util.f.e("TopRecModel", "doInBackground", i);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (i == null) {
            return null;
        }
        if (!this.c.a().b().b()) {
            this.b.c = false;
        } else {
            this.a = (TRForumListData) new GsonBuilder().create().fromJson(i, (Class<Object>) TRForumListData.class);
            this.b.c = true;
            com.baidu.adp.lib.util.f.e(this.a.toString());
        }
        return this.a;
    }
}
