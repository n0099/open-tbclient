package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<AboutActivity> {
    private C0079a dsL;
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
        if (this.dsL != null) {
            this.dsL.cancel();
            return false;
        }
        return false;
    }

    public void azt() {
        if (this.dsL == null) {
            this.dsL = new C0079a(this, null);
        }
        this.dsL.setPriority(3);
        this.dsL.execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.setting.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0079a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        ab Ua;

        private C0079a() {
            this.Ua = null;
        }

        /* synthetic */ C0079a(a aVar, C0079a c0079a) {
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
                this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Ua.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Ua.o("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().xV() > 0) {
                    this.Ua.o("_msg_status", "0");
                } else {
                    this.Ua.o("_msg_status", "1");
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Ua.o("package", packageName);
                this.Ua.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Ua.o("signmd5", az.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Ua.o("md5", UtilHelper.getTiebaApkMd5());
                String tV = this.Ua.tV();
                if (!this.Ua.uw().vq().qO()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.d.d();
                try {
                    dVar.parserJson(tV);
                    if (TbadkCoreApplication.getClientId() == null && dVar.yx().getClientId() != null && dVar.yx().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(a.this.mContext, dVar.yx().getClientId());
                        TbadkCoreApplication.setClientId(dVar.yx().getClientId());
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
            a.this.dsL = null;
            if (this.Ua != null) {
                this.Ua.gL();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.d.d dVar) {
            super.onPostExecute(dVar);
            a.this.dsL = null;
            a.this.mLoadDataCallBack.d(dVar);
        }
    }
}
