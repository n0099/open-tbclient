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
    private C0070a cEr;
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
        if (this.cEr != null) {
            this.cEr.cancel();
            return false;
        }
        return false;
    }

    public void aoO() {
        if (this.cEr == null) {
            this.cEr = new C0070a(this, null);
        }
        this.cEr.setPriority(3);
        this.cEr.execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.setting.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0070a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.e> {
        v Tv;

        private C0070a() {
            this.Tv = null;
        }

        /* synthetic */ C0070a(a aVar, C0070a c0070a) {
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
        /* renamed from: z */
        public com.baidu.tbadk.coreExtra.c.e doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.c.e eVar;
            Exception e;
            try {
                this.Tv = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Tv.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Tv.o("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xz() > 0) {
                    this.Tv.o("_msg_status", "0");
                } else {
                    this.Tv.o("_msg_status", "1");
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Tv.o("package", packageName);
                this.Tv.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Tv.o("signmd5", as.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Tv.o("md5", UtilHelper.getTiebaApkMd5());
                String tI = this.Tv.tI();
                if (!this.Tv.uj().va().qZ()) {
                    return null;
                }
                eVar = new com.baidu.tbadk.coreExtra.c.e();
                try {
                    eVar.parserJson(tI);
                    if (TbadkCoreApplication.getClientId() == null && eVar.yd().getClientId() != null && eVar.yd().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(a.this.mContext, eVar.yd().getClientId());
                        TbadkCoreApplication.setClientId(eVar.yd().getClientId());
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
            a.this.cEr = null;
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.c.e eVar) {
            super.onPostExecute(eVar);
            a.this.cEr = null;
            a.this.mLoadDataCallBack.d(eVar);
        }
    }
}
