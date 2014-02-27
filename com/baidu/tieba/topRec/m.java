package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<Object, Integer, TRForumListData> {
    TRForumListData a;
    final /* synthetic */ l b;
    private ba c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ TRForumListData a(Object... objArr) {
        return d();
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
            com.baidu.adp.lib.util.e.e(tRForumListData2.toString());
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

    private TRForumListData d() {
        String l;
        try {
            this.c = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/random_recommend_forum");
            this.c.a("rn", "100");
            l = this.c.l();
            com.baidu.adp.lib.util.e.e("TopRecModel", "doInBackground", l);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (l == null) {
            return null;
        }
        if (!this.c.c()) {
            this.b.c = false;
        } else {
            this.a = (TRForumListData) new GsonBuilder().create().fromJson(l, (Class<Object>) TRForumListData.class);
            this.b.c = true;
            com.baidu.adp.lib.util.e.e(this.a.toString());
        }
        return this.a;
    }
}
