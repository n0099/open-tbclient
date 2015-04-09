package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, TRForumListData> {
    private aa ZF;
    TRForumListData bxT;
    final /* synthetic */ j byz;

    private k(j jVar) {
        this.byz = jVar;
        this.ZF = null;
        this.bxT = new TRForumListData();
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
            this.ZF = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
            this.ZF.o("rn", "100");
            rO = this.ZF.rO();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (rO == null) {
            return null;
        }
        if (!this.ZF.sp().tq().pv()) {
            this.byz.aDz = false;
        } else {
            this.bxT = (TRForumListData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(rO, TRForumListData.class);
            this.byz.aDz = true;
        }
        return this.bxT;
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
                l lVar = this.byz.byy;
                z2 = this.byz.aDz;
                lVar.a(Boolean.valueOf(z2), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                return;
            }
            l lVar2 = this.byz.byy;
            z = this.byz.aDz;
            lVar2.a(Boolean.valueOf(z), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
        }
    }
}
