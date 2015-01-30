package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.g> {
    ad AR;
    final /* synthetic */ a buh;

    private b(a aVar) {
        this.buh = aVar;
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
            this.AR.o("signmd5", bh.b(TbadkCoreApplication.m255getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.AR.o("md5", UtilHelper.getTiebaApkMd5());
            String oy = this.AR.oy();
            if (!this.AR.oZ().qh().ma()) {
                return null;
            }
            gVar = new com.baidu.tbadk.coreExtra.c.g();
            try {
                gVar.parserJson(oy);
                if (TbadkCoreApplication.getClientId() == null && gVar.sG().getClientId() != null && gVar.sG().getClientId().length() > 0) {
                    context = this.buh.mContext;
                    TbadkCoreApplication.saveClientId(context, gVar.sG().getClientId());
                    TbadkCoreApplication.setClientId(gVar.sG().getClientId());
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
        this.buh.bug = null;
        if (this.AR != null) {
            this.AR.dJ();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.c.g gVar) {
        super.onPostExecute(gVar);
        this.buh.bug = null;
        this.buh.mLoadDataCallBack.c(gVar);
    }
}
