package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<AboutActivity> {
    private C0083a dIP;
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
        if (this.dIP != null) {
            this.dIP.cancel();
            return false;
        }
        return false;
    }

    public void aGA() {
        if (this.dIP == null) {
            this.dIP = new C0083a(this, null);
        }
        this.dIP.setPriority(3);
        this.dIP.execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.setting.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0083a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        aa Ty;

        private C0083a() {
            this.Ty = null;
        }

        /* synthetic */ C0083a(a aVar, C0083a c0083a) {
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
        /* renamed from: C */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Ty.p("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Ty.p("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zn() > 0) {
                    this.Ty.p("_msg_status", "0");
                } else {
                    this.Ty.p("_msg_status", "1");
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Ty.p("package", packageName);
                this.Ty.p("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Ty.p("signmd5", ay.a(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Ty.p("md5", UtilHelper.getTiebaApkMd5());
                String uZ = this.Ty.uZ();
                if (!this.Ty.vB().ww().rl()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.d.d();
                try {
                    dVar.parserJson(uZ);
                    if (TbadkCoreApplication.getClientId() == null && dVar.zP().getClientId() != null && dVar.zP().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(a.this.mContext, dVar.zP().getClientId());
                        TbadkCoreApplication.setClientId(dVar.zP().getClientId());
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
            a.this.dIP = null;
            if (this.Ty != null) {
                this.Ty.gT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.d.d dVar) {
            super.onPostExecute(dVar);
            a.this.dIP = null;
            a.this.mLoadDataCallBack.d(dVar);
        }
    }
}
