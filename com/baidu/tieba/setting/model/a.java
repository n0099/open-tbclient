package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<AboutActivity> {
    private C0074a cNn;
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
        if (this.cNn != null) {
            this.cNn.cancel();
            return false;
        }
        return false;
    }

    public void arO() {
        if (this.cNn == null) {
            this.cNn = new C0074a(this, null);
        }
        this.cNn.setPriority(3);
        this.cNn.execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.setting.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0074a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        w Tj;

        private C0074a() {
            this.Tj = null;
        }

        /* synthetic */ C0074a(a aVar, C0074a c0074a) {
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
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Tj.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Tj.o("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xm() > 0) {
                    this.Tj.o("_msg_status", "0");
                } else {
                    this.Tj.o("_msg_status", "1");
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Tj.o("package", packageName);
                this.Tj.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Tj.o("signmd5", au.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Tj.o("md5", UtilHelper.getTiebaApkMd5());
                String tG = this.Tj.tG();
                if (!this.Tj.uh().va().qT()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.d.d();
                try {
                    dVar.parserJson(tG);
                    if (TbadkCoreApplication.getClientId() == null && dVar.xP().getClientId() != null && dVar.xP().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(a.this.mContext, dVar.xP().getClientId());
                        TbadkCoreApplication.setClientId(dVar.xP().getClientId());
                        return dVar;
                    }
                    return dVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return dVar;
                }
            } catch (Exception e3) {
                dVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            a.this.cNn = null;
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.d.d dVar) {
            super.onPostExecute(dVar);
            a.this.cNn = null;
            a.this.mLoadDataCallBack.d(dVar);
        }
    }
}
