package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, bb> {
    final /* synthetic */ a boo;
    com.baidu.tbadk.core.util.ac mNetWork;

    private b(a aVar) {
        this.boo = aVar;
        this.mNetWork = null;
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
    public bb doInBackground(String... strArr) {
        bb bbVar;
        Exception e;
        Context context;
        try {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/sync");
            this.mNetWork.k("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.n(com.baidu.tieba.aj.wm().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.o(com.baidu.tieba.aj.wm().getApp())));
            this.mNetWork.k("_phone_screen", stringBuffer.toString());
            if (TbadkApplication.m251getInst().getMsgFrequency() > 0) {
                this.mNetWork.k("_msg_status", "0");
            } else {
                this.mNetWork.k("_msg_status", "1");
            }
            String packageName = TbadkApplication.m251getInst().getPackageName();
            this.mNetWork.k("package", packageName);
            this.mNetWork.k("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m251getInst().getVersionCode())).toString());
            this.mNetWork.k("signmd5", com.baidu.tbadk.core.util.bb.a(TbadkApplication.m251getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.mNetWork.k("md5", bl.xc());
            String lA = this.mNetWork.lA();
            if (!this.mNetWork.mc().nb().jq()) {
                return null;
            }
            bbVar = new bb();
            try {
                bbVar.parserJson(lA);
                if (TbadkApplication.getClientId() == null && bbVar.Ue().getClientId() != null && bbVar.Ue().getClientId().length() > 0) {
                    context = this.boo.mContext;
                    TbadkApplication.saveClientId(context, bbVar.Ue().getClientId());
                    TbadkApplication.setClientId(bbVar.Ue().getClientId());
                    return bbVar;
                }
                return bbVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return bbVar;
            }
        } catch (Exception e3) {
            bbVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.boo.bon = null;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(bb bbVar) {
        super.onPostExecute(bbVar);
        this.boo.bon = null;
        this.boo.mLoadDataCallBack.a(bbVar);
    }
}
