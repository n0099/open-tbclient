package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, bc> {
    com.baidu.tbadk.core.util.al a;
    final /* synthetic */ a b;

    private b(a aVar) {
        this.b = aVar;
        this.a = null;
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
    /* renamed from: a */
    public bc doInBackground(String... strArr) {
        bc bcVar;
        Exception e;
        Context context;
        try {
            this.a = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.b(com.baidu.tieba.ai.c().d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.c(com.baidu.tieba.ai.c().d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
            String packageName = TbadkApplication.m252getInst().getPackageName();
            this.a.a("package", packageName);
            this.a.a("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m252getInst().getVersionCode())).toString());
            this.a.a("signmd5", UtilHelper.creatSignInt(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.a.a("md5", com.baidu.tieba.bd.a());
            String i = this.a.i();
            if (!this.a.a().b().b()) {
                return null;
            }
            bcVar = new bc();
            try {
                bcVar.a(i);
                if (TbadkApplication.getClientId() == null && bcVar.d().a() != null && bcVar.d().a().length() > 0) {
                    context = this.b.c;
                    TbadkApplication.saveClientId(context, bcVar.d().a());
                    TbadkApplication.setClientId(bcVar.d().a());
                    return bcVar;
                }
                return bcVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return bcVar;
            }
        } catch (Exception e3) {
            bcVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(bc bcVar) {
        super.onPostExecute(bcVar);
        this.b.b = null;
        this.b.a.a(bcVar);
    }
}
