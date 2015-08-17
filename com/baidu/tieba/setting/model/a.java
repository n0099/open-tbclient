package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<AboutActivity> {
    private C0068a cvV;
    private Context mContext;

    public a(AboutActivity aboutActivity, com.baidu.adp.base.g gVar) {
        super(aboutActivity.getPageContext());
        this.mContext = aboutActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = gVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cvV != null) {
            this.cvV.cancel();
            return false;
        }
        return false;
    }

    public void akH() {
        if (this.cvV == null) {
            this.cvV = new C0068a(this, null);
        }
        this.cvV.setPriority(3);
        this.cvV.execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.setting.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0068a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.e> {
        v Tu;

        private C0068a() {
            this.Tu = null;
        }

        /* synthetic */ C0068a(a aVar, C0068a c0068a) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public com.baidu.tbadk.coreExtra.c.e doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.c.e eVar;
            Exception e;
            try {
                this.Tu = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Tu.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Tu.o("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xt() > 0) {
                    this.Tu.o("_msg_status", "0");
                } else {
                    this.Tu.o("_msg_status", "1");
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Tu.o("package", packageName);
                this.Tu.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Tu.o("signmd5", as.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Tu.o("md5", UtilHelper.getTiebaApkMd5());
                String tD = this.Tu.tD();
                if (!this.Tu.ue().uW().rb()) {
                    return null;
                }
                eVar = new com.baidu.tbadk.coreExtra.c.e();
                try {
                    eVar.parserJson(tD);
                    if (TbadkCoreApplication.getClientId() == null && eVar.xW().getClientId() != null && eVar.xW().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(a.this.mContext, eVar.xW().getClientId());
                        TbadkCoreApplication.setClientId(eVar.xW().getClientId());
                        return eVar;
                    }
                    return eVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return eVar;
                }
            } catch (Exception e3) {
                eVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            a.this.cvV = null;
            if (this.Tu != null) {
                this.Tu.gM();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.c.e eVar) {
            super.onPostExecute(eVar);
            a.this.cvV = null;
            a.this.mLoadDataCallBack.d(eVar);
        }
    }
}
