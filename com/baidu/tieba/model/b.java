package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.g> {
    ad AR;
    final /* synthetic */ a bsJ;

    private b(a aVar) {
        this.bsJ = aVar;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, b bVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public com.baidu.tbadk.coreExtra.c.g doInBackground(String... strArr) {
        com.baidu.tbadk.coreExtra.c.g gVar;
        Exception e;
        Context context;
        try {
            this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
            this.AR.o("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp())));
            this.AR.o("_phone_screen", stringBuffer.toString());
            if (TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                this.AR.o("_msg_status", "0");
            } else {
                this.AR.o("_msg_status", "1");
            }
            String packageName = TbadkCoreApplication.m255getInst().getPackageName();
            this.AR.o("package", packageName);
            this.AR.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m255getInst().getVersionCode())).toString());
            this.AR.o("signmd5", bc.b(TbadkCoreApplication.m255getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.AR.o("md5", UtilHelper.getTiebaApkMd5());
            String ov = this.AR.ov();
            if (!this.AR.oW().pW().ma()) {
                return null;
            }
            gVar = new com.baidu.tbadk.coreExtra.c.g();
            try {
                gVar.parserJson(ov);
                if (TbadkCoreApplication.getClientId() == null && gVar.sq().getClientId() != null && gVar.sq().getClientId().length() > 0) {
                    context = this.bsJ.mContext;
                    TbadkCoreApplication.saveClientId(context, gVar.sq().getClientId());
                    TbadkCoreApplication.setClientId(gVar.sq().getClientId());
                    return gVar;
                }
                return gVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return gVar;
            }
        } catch (Exception e3) {
            gVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bsJ.bsI = null;
        if (this.AR != null) {
            this.AR.dL();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.c.g gVar) {
        super.onPostExecute(gVar);
        this.bsJ.bsI = null;
        this.bsJ.mLoadDataCallBack.c(gVar);
    }
}
