package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.message.Hao123AddLikeMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, Integer, ae> {
    private volatile com.baidu.tbadk.core.util.ad CV;
    final /* synthetic */ ac bSZ;

    private ad(ac acVar) {
        this.bSZ = acVar;
        this.CV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(ac acVar, ad adVar) {
        this(acVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public ae doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        try {
            this.CV = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
            com.baidu.tbadk.core.util.ad adVar = this.CV;
            str = this.bSZ.mForumName;
            adVar.o("kw", str);
            com.baidu.tbadk.core.util.ad adVar2 = this.CV;
            str2 = this.bSZ.mForumId;
            adVar2.o(ImageViewerConfig.FORUM_ID, str2);
            com.baidu.tbadk.core.util.ad adVar3 = this.CV;
            str3 = this.bSZ.from;
            adVar3.o("st_type", str3);
            str4 = this.bSZ.bSY;
            if (!StringUtils.isNull(str4)) {
                com.baidu.tbadk.core.util.ad adVar4 = this.CV;
                str10 = this.bSZ.bSY;
                adVar4.o("dev_id", str10);
            }
            str5 = this.bSZ.bSW;
            if (!TextUtils.isEmpty(str5)) {
                com.baidu.tbadk.core.util.ad adVar5 = this.CV;
                str9 = this.bSZ.bSW;
                adVar5.o("pagefrom", str9);
            }
            this.CV.oW().pV().mIsNeedTbs = true;
            String ov = this.CV.ov();
            if (this.CV.oW().pW().ma() && ov != null) {
                ae aeVar = new ae();
                aeVar.parserJson(ov);
                str6 = this.bSZ.mForumId;
                aeVar.hY(str6);
                com.baidu.tbadk.core.message.a aVar = new com.baidu.tbadk.core.message.a();
                str7 = this.bSZ.mForumName;
                aVar.forumName = str7;
                str8 = this.bSZ.mForumId;
                aVar.Gb = str8;
                aVar.level = aeVar.adi();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new Hao123AddLikeMessage(aVar));
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
        this.bSZ.bSX = null;
        if (aeVar == null && this.CV != null) {
            this.bSZ.mErrorCode = this.CV.pa();
            this.bSZ.mErrorString = this.CV.getErrorString();
        }
        iVar = this.bSZ.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.bSZ.mLoadDataCallBack;
            iVar2.c(aeVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        if (this.CV != null) {
            this.CV.dL();
            this.CV = null;
        }
        this.bSZ.bSX = null;
        super.cancel(true);
        iVar = this.bSZ.mLoadDataCallBack;
        iVar.c(null);
    }
}
