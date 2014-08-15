package com.baidu.tieba.service;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.ai;
import com.baidu.tieba.az;
import com.baidu.tieba.model.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<String, Integer, bd> {
    ae a;
    final /* synthetic */ SyncLoginService b;

    private n(SyncLoginService syncLoginService) {
        this.b = syncLoginService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(SyncLoginService syncLoginService, n nVar) {
        this(syncLoginService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public bd doInBackground(String... strArr) {
        bd bdVar;
        Exception e;
        String str;
        String str2;
        try {
            this.a = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.j.b(ai.c().d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.j.c(ai.c().d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            this.a.a("scr_w", String.valueOf(com.baidu.adp.lib.util.j.b(ai.c().d())));
            this.a.a("scr_h", String.valueOf(com.baidu.adp.lib.util.j.c(ai.c().d())));
            this.a.a("scr_dip", String.valueOf(com.baidu.adp.lib.util.j.d(ai.c().d())));
            if (TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
            String C = ai.c().C();
            if (C != null) {
                if (C.length() < 1) {
                    C = "0";
                }
                this.a.a("_active", C);
            }
            this.a.a("_pic_quality", String.valueOf(TbadkApplication.m252getInst().getViewImageQuality()));
            str = SyncLoginService.mStatistics;
            if (str != null) {
                ae aeVar = this.a;
                str2 = SyncLoginService.mStatistics;
                aeVar.a("_msg_type", str2);
            }
            String packageName = TbadkApplication.m252getInst().getPackageName();
            this.a.a("package", packageName);
            this.a.a("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m252getInst().getVersionCode())).toString());
            this.a.a("signmd5", UtilHelper.getAPKMd5(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.a.a("md5", az.a());
            String h = this.a.h();
            if (this.a.a().b().b()) {
                bdVar = new bd();
                try {
                    bdVar.a(h);
                    SyncLoginService.mStatistics = null;
                    return bdVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return bdVar;
                }
            }
            return null;
        } catch (Exception e3) {
            bdVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.mSyncTask = null;
        if (this.a != null) {
            this.a.f();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(bd bdVar) {
        super.onPostExecute(bdVar);
        this.b.mSyncTask = null;
    }
}
