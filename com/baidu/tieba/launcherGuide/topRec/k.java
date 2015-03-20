package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, TRForumListData> {
    private aa ZD;
    TRForumListData bxD;
    final /* synthetic */ j byj;

    private k(j jVar) {
        this.byj = jVar;
        this.ZD = null;
        this.bxD = new TRForumListData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, k kVar) {
        this(jVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public TRForumListData doInBackground(Object... objArr) {
        String rO;
        try {
            this.ZD = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
            this.ZD.o("rn", "100");
            rO = this.ZD.rO();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (rO == null) {
            return null;
        }
        if (!this.ZD.sp().tq().pv()) {
            this.byj.aDr = false;
        } else {
            this.bxD = (TRForumListData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(rO, TRForumListData.class);
            this.byj.aDr = true;
        }
        return this.bxD;
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
                l lVar = this.byj.byi;
                z2 = this.byj.aDr;
                lVar.a(Boolean.valueOf(z2), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                return;
            }
            l lVar2 = this.byj.byi;
            z = this.byj.aDr;
            lVar2.a(Boolean.valueOf(z), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
        }
    }
}
