package com.baidu.tieba.service;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.aj;
import com.baidu.tieba.bc;
import com.baidu.tieba.model.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<String, Integer, ba> {
    final /* synthetic */ SyncLoginService bIP;
    ac mNetWork;

    private o(SyncLoginService syncLoginService) {
        this.bIP = syncLoginService;
        this.mNetWork = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(SyncLoginService syncLoginService, o oVar) {
        this(syncLoginService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: z */
    public ba doInBackground(String... strArr) {
        ba baVar;
        Exception e;
        String str;
        String str2;
        try {
            this.mNetWork = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
            this.mNetWork.k("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.n(aj.wk().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.o(aj.wk().getApp())));
            this.mNetWork.k("_phone_screen", stringBuffer.toString());
            this.mNetWork.k("scr_w", String.valueOf(com.baidu.adp.lib.util.m.n(aj.wk().getApp())));
            this.mNetWork.k("scr_h", String.valueOf(com.baidu.adp.lib.util.m.o(aj.wk().getApp())));
            this.mNetWork.k("scr_dip", String.valueOf(com.baidu.adp.lib.util.m.p(aj.wk().getApp())));
            if (TbadkApplication.m251getInst().getMsgFrequency() > 0) {
                this.mNetWork.k("_msg_status", "0");
            } else {
                this.mNetWork.k("_msg_status", "1");
            }
            String wK = aj.wk().wK();
            if (wK != null) {
                if (wK.length() < 1) {
                    wK = "0";
                }
                this.mNetWork.k("_active", wK);
            }
            this.mNetWork.k("_pic_quality", String.valueOf(TbadkApplication.m251getInst().getViewImageQuality()));
            str = SyncLoginService.mStatistics;
            if (str != null) {
                ac acVar = this.mNetWork;
                str2 = SyncLoginService.mStatistics;
                acVar.k("_msg_type", str2);
            }
            String packageName = TbadkApplication.m251getInst().getPackageName();
            this.mNetWork.k("package", packageName);
            this.mNetWork.k("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m251getInst().getVersionCode())).toString());
            this.mNetWork.k("signmd5", com.baidu.tbadk.core.util.ba.c(TbadkApplication.m251getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.mNetWork.k("md5", bc.xa());
            String lA = this.mNetWork.lA();
            if (this.mNetWork.mc().nb().jq()) {
                baVar = new ba();
                try {
                    baVar.parserJson(lA);
                    SyncLoginService.mStatistics = null;
                    return baVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return baVar;
                }
            }
            return null;
        } catch (Exception e3) {
            baVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bIP.mSyncTask = null;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ba baVar) {
        super.onPostExecute(baVar);
        this.bIP.mSyncTask = null;
    }
}
