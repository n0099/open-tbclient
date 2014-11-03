package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.aa> {
    final /* synthetic */ ag bpq;
    private volatile com.baidu.tbadk.core.util.ac yV;

    private ah(ag agVar) {
        this.bpq = agVar;
        this.yV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(ag agVar, ah ahVar) {
        this(agVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public com.baidu.tieba.data.aa doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/like");
            com.baidu.tbadk.core.util.ac acVar = this.yV;
            str = this.bpq.mForumName;
            acVar.k("kw", str);
            com.baidu.tbadk.core.util.ac acVar2 = this.yV;
            str2 = this.bpq.mForumId;
            acVar2.k(ImageViewerConfig.FORUM_ID, str2);
            com.baidu.tbadk.core.util.ac acVar3 = this.yV;
            str3 = this.bpq.from;
            acVar3.k("st_type", str3);
            str4 = this.bpq.bpo;
            if (!TextUtils.isEmpty(str4)) {
                com.baidu.tbadk.core.util.ac acVar4 = this.yV;
                str8 = this.bpq.bpo;
                acVar4.k("pagefrom", str8);
            }
            this.yV.mc().na().mIsNeedTbs = true;
            String lA = this.yV.lA();
            if (this.yV.mc().nb().jq() && lA != null) {
                com.baidu.tieba.data.aa aaVar = new com.baidu.tieba.data.aa();
                aaVar.parserJson(lA);
                str5 = this.bpq.mForumId;
                aaVar.et(str5);
                str6 = this.bpq.mForumId;
                str7 = this.bpq.mForumName;
                Hao123Model.addLikeData(str6, str7, aaVar.zB());
                return aaVar;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(com.baidu.tieba.data.aa aaVar) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        this.bpq.bpp = null;
        if (aaVar == null && this.yV != null) {
            this.bpq.mErrorCode = this.yV.mg();
            this.bpq.mErrorString = this.yV.getErrorString();
        }
        hVar = this.bpq.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.bpq.mLoadDataCallBack;
            hVar2.a(aaVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        this.bpq.bpp = null;
        super.cancel(true);
        hVar = this.bpq.mLoadDataCallBack;
        hVar.a(null);
    }
}
