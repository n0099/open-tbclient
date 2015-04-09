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
    private volatile com.baidu.tbadk.core.util.aa ZF;
    final /* synthetic */ af clN;

    private ag(af afVar) {
        this.clN = afVar;
        this.ZF = null;
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
            this.ZF = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
            com.baidu.tbadk.core.util.aa aaVar = this.ZF;
            str = this.clN.mForumName;
            aaVar.o("kw", str);
            com.baidu.tbadk.core.util.aa aaVar2 = this.ZF;
            str2 = this.clN.mForumId;
            aaVar2.o(ImageViewerConfig.FORUM_ID, str2);
            com.baidu.tbadk.core.util.aa aaVar3 = this.ZF;
            str3 = this.clN.from;
            aaVar3.o("st_type", str3);
            str4 = this.clN.clM;
            if (!StringUtils.isNull(str4)) {
                com.baidu.tbadk.core.util.aa aaVar4 = this.ZF;
                str8 = this.clN.clM;
                aaVar4.o("dev_id", str8);
            }
            str5 = this.clN.clK;
            if (!TextUtils.isEmpty(str5)) {
                com.baidu.tbadk.core.util.aa aaVar5 = this.ZF;
                str7 = this.clN.clK;
                aaVar5.o("pagefrom", str7);
            }
            this.ZF.sp().tp().mIsNeedTbs = true;
            String rO = this.ZF.rO();
            if (this.ZF.sp().tq().pv() && rO != null) {
                ah ahVar = new ah();
                ahVar.parserJson(rO);
                str6 = this.clN.mForumId;
                ahVar.iC(str6);
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
        this.clN.clL = null;
        if (ahVar == null && this.ZF != null) {
            this.clN.mErrorCode = this.ZF.st();
            this.clN.mErrorString = this.ZF.getErrorString();
        }
        iVar = this.clN.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.clN.mLoadDataCallBack;
            iVar2.c(ahVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        if (this.ZF != null) {
            this.ZF.hh();
            this.ZF = null;
        }
        this.clN.clL = null;
        super.cancel(true);
        iVar = this.clN.mLoadDataCallBack;
        iVar.c(null);
    }
}
