package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, TRForumListData> {
    private ad CV;
    TRForumListData ccF;
    final /* synthetic */ j cdg;

    private k(j jVar) {
        this.cdg = jVar;
        this.CV = null;
        this.ccF = new TRForumListData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, k kVar) {
        this(jVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: C */
    public TRForumListData doInBackground(Object... objArr) {
        String ov;
        try {
            this.CV = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
            this.CV.o("rn", "100");
            ov = this.CV.ov();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (ov == null) {
            return null;
        }
        if (!this.CV.oW().pW().ma()) {
            this.cdg.ayu = false;
        } else {
            this.ccF = (TRForumListData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(ov, TRForumListData.class);
            this.cdg.ayu = true;
        }
        return this.ccF;
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
                l lVar = this.cdg.cdf;
                z2 = this.cdg.ayu;
                lVar.a(Boolean.valueOf(z2), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                return;
            }
            l lVar2 = this.cdg.cdf;
            z = this.cdg.ayu;
            lVar2.a(Boolean.valueOf(z), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
        }
    }
}
