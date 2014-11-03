package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, TRForumListData> {
    TRForumListData bPF;
    final /* synthetic */ j bQg;
    private ac yV;

    private k(j jVar) {
        this.bQg = jVar;
        this.yV = null;
        this.bPF = new TRForumListData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, k kVar) {
        this(jVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: z */
    public TRForumListData doInBackground(Object... objArr) {
        String lA;
        try {
            this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
            this.yV.k("rn", "100");
            lA = this.yV.lA();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (lA == null) {
            return null;
        }
        if (!this.yV.mc().nb().jq()) {
            this.bQg.avl = false;
        } else {
            this.bPF = (TRForumListData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, TRForumListData.class);
            this.bQg.avl = true;
        }
        return this.bPF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(TRForumListData tRForumListData) {
        boolean z;
        boolean z2;
        super.onPostExecute(tRForumListData);
        if (tRForumListData != null) {
            if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                l lVar = this.bQg.bQf;
                z2 = this.bQg.avl;
                lVar.a(Boolean.valueOf(z2), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                return;
            }
            l lVar2 = this.bQg.bQf;
            z = this.bQg.avl;
            lVar2.a(Boolean.valueOf(z), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
        }
    }
}
