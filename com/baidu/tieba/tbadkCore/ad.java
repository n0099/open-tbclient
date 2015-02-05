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
    private volatile com.baidu.tbadk.core.util.ad CU;
    final /* synthetic */ ac bUR;

    private ad(ac acVar) {
        this.bUR = acVar;
        this.CU = null;
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
            this.CU = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
            com.baidu.tbadk.core.util.ad adVar = this.CU;
            str = this.bUR.mForumName;
            adVar.o("kw", str);
            com.baidu.tbadk.core.util.ad adVar2 = this.CU;
            str2 = this.bUR.mForumId;
            adVar2.o(ImageViewerConfig.FORUM_ID, str2);
            com.baidu.tbadk.core.util.ad adVar3 = this.CU;
            str3 = this.bUR.from;
            adVar3.o("st_type", str3);
            str4 = this.bUR.bUQ;
            if (!StringUtils.isNull(str4)) {
                com.baidu.tbadk.core.util.ad adVar4 = this.CU;
                str8 = this.bUR.bUQ;
                adVar4.o("dev_id", str8);
            }
            str5 = this.bUR.bUO;
            if (!TextUtils.isEmpty(str5)) {
                com.baidu.tbadk.core.util.ad adVar5 = this.CU;
                str7 = this.bUR.bUO;
                adVar5.o("pagefrom", str7);
            }
            this.CU.oS().pZ().mIsNeedTbs = true;
            String or = this.CU.or();
            if (this.CU.oS().qa().lT() && or != null) {
                ae aeVar = new ae();
                aeVar.parserJson(or);
                str6 = this.bUR.mForumId;
                aeVar.id(str6);
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
        this.bUR.bUP = null;
        if (aeVar == null && this.CU != null) {
            this.bUR.mErrorCode = this.CU.oW();
            this.bUR.mErrorString = this.CU.getErrorString();
        }
        iVar = this.bUR.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.bUR.mLoadDataCallBack;
            iVar2.c(aeVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        if (this.CU != null) {
            this.CU.dJ();
            this.CU = null;
        }
        this.bUR.bUP = null;
        super.cancel(true);
        iVar = this.bUR.mLoadDataCallBack;
        iVar.c(null);
    }
}
