package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<AboutActivity> {
    private C0080a ebj;
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
        if (this.ebj != null) {
            this.ebj.cancel();
            return false;
        }
        return false;
    }

    public void aNk() {
        if (this.ebj == null) {
            this.ebj = new C0080a(this, null);
        }
        this.ebj.setPriority(3);
        this.ebj.execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.setting.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0080a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        ab QV;

        private C0080a() {
            this.QV = null;
        }

        /* synthetic */ C0080a(a aVar, C0080a c0080a) {
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
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.QV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.QV.p("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getApp())));
                this.QV.p("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zP() > 0) {
                    this.QV.p("_msg_status", "0");
                } else {
                    this.QV.p("_msg_status", "1");
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.QV.p("package", packageName);
                this.QV.p("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.QV.p("signmd5", ba.a(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.QV.p("md5", UtilHelper.getTiebaApkMd5());
                String vw = this.QV.vw();
                if (!this.QV.vU().wP().qC()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.d.d();
                try {
                    dVar.parserJson(vw);
                    if (TbadkCoreApplication.getClientId() == null && dVar.As().getClientId() != null && dVar.As().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(a.this.mContext, dVar.As().getClientId());
                        TbadkCoreApplication.setClientId(dVar.As().getClientId());
                    }
                    o At = dVar.At();
                    if (At != null) {
                        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("localvideo_open", At.zj());
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
            a.this.ebj = null;
            if (this.QV != null) {
                this.QV.gX();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.d.d dVar) {
            super.onPostExecute(dVar);
            a.this.ebj = null;
            a.this.mLoadDataCallBack.d(dVar);
        }
    }
}
