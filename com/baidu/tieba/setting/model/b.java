package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.c.g;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, g> {
    aa Oi;
    final /* synthetic */ a bZF;

    private b(a aVar) {
        this.bZF = aVar;
        this.Oi = null;
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
    public g doInBackground(String... strArr) {
        g gVar;
        Exception e;
        Context context;
        try {
            this.Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
            this.Oi.o("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(n.M(TbadkCoreApplication.m411getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(n.N(TbadkCoreApplication.m411getInst().getApp())));
            this.Oi.o("_phone_screen", stringBuffer.toString());
            if (c.vq().vt() > 0) {
                this.Oi.o("_msg_status", GameInfoData.NOT_FROM_DETAIL);
            } else {
                this.Oi.o("_msg_status", "1");
            }
            String packageName = TbadkCoreApplication.m411getInst().getPackageName();
            this.Oi.o("package", packageName);
            this.Oi.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
            this.Oi.o("signmd5", bf.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.Oi.o("md5", UtilHelper.getTiebaApkMd5());
            String rO = this.Oi.rO();
            if (!this.Oi.sp().tq().pv()) {
                return null;
            }
            gVar = new g();
            try {
                gVar.parserJson(rO);
                if (TbadkCoreApplication.getClientId() == null && gVar.vW().getClientId() != null && gVar.vW().getClientId().length() > 0) {
                    context = this.bZF.mContext;
                    TbadkCoreApplication.saveClientId(context, gVar.vW().getClientId());
                    TbadkCoreApplication.setClientId(gVar.vW().getClientId());
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
        this.bZF.bZE = null;
        if (this.Oi != null) {
            this.Oi.hh();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(g gVar) {
        super.onPostExecute(gVar);
        this.bZF.bZE = null;
        this.bZF.mLoadDataCallBack.c(gVar);
    }
}
