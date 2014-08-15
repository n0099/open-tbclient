package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Object, Integer, TRForumListData> {
    TRForumListData a;
    final /* synthetic */ k b;
    private ae c;

    private l(k kVar) {
        this.b = kVar;
        this.c = null;
        this.a = new TRForumListData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(k kVar, l lVar) {
        this(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public TRForumListData doInBackground(Object... objArr) {
        String h;
        try {
            this.c = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
            this.c.a("rn", "100");
            h = this.c.h();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (h == null) {
            return null;
        }
        if (!this.c.a().b().b()) {
            this.b.c = false;
        } else {
            this.a = (TRForumListData) new GsonBuilder().create().fromJson(h, (Class<Object>) TRForumListData.class);
            this.b.c = true;
        }
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(TRForumListData tRForumListData) {
        boolean z;
        boolean z2;
        super.onPostExecute(tRForumListData);
        if (tRForumListData != null) {
            if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                m mVar = this.b.b;
                z2 = this.b.c;
                mVar.a(Boolean.valueOf(z2), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                return;
            }
            m mVar2 = this.b.b;
            z = this.b.c;
            mVar2.a(Boolean.valueOf(z), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
        }
    }
}
