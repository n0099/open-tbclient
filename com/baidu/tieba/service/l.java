package com.baidu.tieba.service;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ai;
import com.baidu.tieba.bc;
import com.baidu.tieba.model.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, bb> {
    an a;
    final /* synthetic */ SyncLoginService b;

    private l(SyncLoginService syncLoginService) {
        this.b = syncLoginService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(SyncLoginService syncLoginService, l lVar) {
        this(syncLoginService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public bb doInBackground(String... strArr) {
        bb bbVar;
        Exception e;
        String str;
        String str2;
        try {
            this.a = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.b(ai.c().d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.c(ai.c().d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            this.a.a("scr_w", String.valueOf(com.baidu.adp.lib.util.k.b(ai.c().d())));
            this.a.a("scr_h", String.valueOf(com.baidu.adp.lib.util.k.c(ai.c().d())));
            this.a.a("scr_dip", String.valueOf(com.baidu.adp.lib.util.k.d(ai.c().d())));
            if (TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
            String D = ai.c().D();
            if (D != null) {
                if (D.length() < 1) {
                    D = "0";
                }
                this.a.a("_active", D);
            }
            this.a.a("_pic_quality", String.valueOf(TbadkApplication.m252getInst().getViewImageQuality()));
            str = SyncLoginService.mStatistics;
            if (str != null) {
                an anVar = this.a;
                str2 = SyncLoginService.mStatistics;
                anVar.a("_msg_type", str2);
            }
            String packageName = TbadkApplication.m252getInst().getPackageName();
            this.a.a("package", packageName);
            this.a.a("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m252getInst().getVersionCode())).toString());
            this.a.a("signmd5", UtilHelper.getAPKMd5(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.a.a("md5", bc.a());
            String i = this.a.i();
            if (this.a.a().b().b()) {
                bbVar = new bb();
                try {
                    bbVar.a(i);
                    SyncLoginService.mStatistics = null;
                    return bbVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                    return bbVar;
                }
            }
            return null;
        } catch (Exception e3) {
            bbVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.mSyncTask = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(bb bbVar) {
        super.onPostExecute(bbVar);
        this.b.mSyncTask = null;
    }
}
