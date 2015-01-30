package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, Integer, ae> {
    private volatile com.baidu.tbadk.core.util.ad CX;
    final /* synthetic */ ac bUS;

    private ad(ac acVar) {
        this.bUS = acVar;
        this.CX = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(ac acVar, ad adVar) {
        this(acVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: C */
    public ae doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            this.CX = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
            com.baidu.tbadk.core.util.ad adVar = this.CX;
            str = this.bUS.mForumName;
            adVar.o("kw", str);
            com.baidu.tbadk.core.util.ad adVar2 = this.CX;
            str2 = this.bUS.mForumId;
            adVar2.o(ImageViewerConfig.FORUM_ID, str2);
            com.baidu.tbadk.core.util.ad adVar3 = this.CX;
            str3 = this.bUS.from;
            adVar3.o("st_type", str3);
            str4 = this.bUS.bUR;
            if (!StringUtils.isNull(str4)) {
                com.baidu.tbadk.core.util.ad adVar4 = this.CX;
                str8 = this.bUS.bUR;
                adVar4.o("dev_id", str8);
            }
            str5 = this.bUS.bUP;
            if (!TextUtils.isEmpty(str5)) {
                com.baidu.tbadk.core.util.ad adVar5 = this.CX;
                str7 = this.bUS.bUP;
                adVar5.o("pagefrom", str7);
            }
            this.CX.oZ().qg().mIsNeedTbs = true;
            String oy = this.CX.oy();
            if (this.CX.oZ().qh().ma() && oy != null) {
                ae aeVar = new ae();
                aeVar.parserJson(oy);
                str6 = this.bUS.mForumId;
                aeVar.ig(str6);
                return aeVar;
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
    public void onPostExecute(ae aeVar) {
        com.baidu.adp.base.i iVar;
        com.baidu.adp.base.i iVar2;
        this.bUS.bUQ = null;
        if (aeVar == null && this.CX != null) {
            this.bUS.mErrorCode = this.CX.pd();
            this.bUS.mErrorString = this.CX.getErrorString();
        }
        iVar = this.bUS.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.bUS.mLoadDataCallBack;
            iVar2.c(aeVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        if (this.CX != null) {
            this.CX.dJ();
            this.CX = null;
        }
        this.bUS.bUQ = null;
        super.cancel(true);
        iVar = this.bUS.mLoadDataCallBack;
        iVar.c(null);
    }
}
