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
    private volatile com.baidu.tbadk.core.util.aa aaG;
    final /* synthetic */ af cpN;

    private ag(af afVar) {
        this.cpN = afVar;
        this.aaG = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(af afVar, ag agVar) {
        this(afVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: F */
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
            this.aaG = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
            com.baidu.tbadk.core.util.aa aaVar = this.aaG;
            str = this.cpN.mForumName;
            aaVar.o("kw", str);
            com.baidu.tbadk.core.util.aa aaVar2 = this.aaG;
            str2 = this.cpN.mForumId;
            aaVar2.o(ImageViewerConfig.FORUM_ID, str2);
            com.baidu.tbadk.core.util.aa aaVar3 = this.aaG;
            str3 = this.cpN.from;
            aaVar3.o("st_type", str3);
            str4 = this.cpN.cpM;
            if (!StringUtils.isNull(str4)) {
                com.baidu.tbadk.core.util.aa aaVar4 = this.aaG;
                str8 = this.cpN.cpM;
                aaVar4.o("dev_id", str8);
            }
            str5 = this.cpN.cpK;
            if (!TextUtils.isEmpty(str5)) {
                com.baidu.tbadk.core.util.aa aaVar5 = this.aaG;
                str7 = this.cpN.cpK;
                aaVar5.o("pagefrom", str7);
            }
            this.aaG.sX().tS().mIsNeedTbs = true;
            String sw = this.aaG.sw();
            if (this.aaG.sX().tT().qa() && sw != null) {
                ah ahVar = new ah();
                ahVar.parserJson(sw);
                str6 = this.cpN.mForumId;
                ahVar.jv(str6);
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
        this.cpN.cpL = null;
        if (ahVar == null && this.aaG != null) {
            this.cpN.mErrorCode = this.aaG.tb();
            this.cpN.mErrorString = this.aaG.getErrorString();
        }
        iVar = this.cpN.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.cpN.mLoadDataCallBack;
            iVar2.c(ahVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        if (this.aaG != null) {
            this.aaG.gS();
            this.aaG = null;
        }
        this.cpN.cpL = null;
        super.cancel(true);
        iVar = this.cpN.mLoadDataCallBack;
        iVar.c(null);
    }
}
