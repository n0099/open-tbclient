package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, ah> {
    private volatile com.baidu.tbadk.core.util.aa ZD;
    final /* synthetic */ af clx;

    private ag(af afVar) {
        this.clx = afVar;
        this.ZD = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(af afVar, ag agVar) {
        this(afVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: C */
    public ah doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            this.ZD = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
            com.baidu.tbadk.core.util.aa aaVar = this.ZD;
            str = this.clx.mForumName;
            aaVar.o("kw", str);
            com.baidu.tbadk.core.util.aa aaVar2 = this.ZD;
            str2 = this.clx.mForumId;
            aaVar2.o(ImageViewerConfig.FORUM_ID, str2);
            com.baidu.tbadk.core.util.aa aaVar3 = this.ZD;
            str3 = this.clx.from;
            aaVar3.o("st_type", str3);
            str4 = this.clx.clw;
            if (!StringUtils.isNull(str4)) {
                com.baidu.tbadk.core.util.aa aaVar4 = this.ZD;
                str8 = this.clx.clw;
                aaVar4.o("dev_id", str8);
            }
            str5 = this.clx.clu;
            if (!TextUtils.isEmpty(str5)) {
                com.baidu.tbadk.core.util.aa aaVar5 = this.ZD;
                str7 = this.clx.clu;
                aaVar5.o("pagefrom", str7);
            }
            this.ZD.sp().tp().mIsNeedTbs = true;
            String rO = this.ZD.rO();
            if (this.ZD.sp().tq().pv() && rO != null) {
                ah ahVar = new ah();
                ahVar.parserJson(rO);
                str6 = this.clx.mForumId;
                ahVar.iz(str6);
                return ahVar;
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
    public void onPostExecute(ah ahVar) {
        com.baidu.adp.base.i iVar;
        com.baidu.adp.base.i iVar2;
        this.clx.clv = null;
        if (ahVar == null && this.ZD != null) {
            this.clx.mErrorCode = this.ZD.st();
            this.clx.mErrorString = this.ZD.getErrorString();
        }
        iVar = this.clx.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.clx.mLoadDataCallBack;
            iVar2.c(ahVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        if (this.ZD != null) {
            this.ZD.hh();
            this.ZD = null;
        }
        this.clx.clv = null;
        super.cancel(true);
        iVar = this.clx.mLoadDataCallBack;
        iVar.c(null);
    }
}
