package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes3.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private a gyn;
    private final boolean gyo;
    private Context mContext;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.gyo = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gyn != null) {
            this.gyn.cancel();
            return false;
        }
        return false;
    }

    public void bpl() {
        if (this.gyn == null) {
            this.gyn = new a();
        }
        this.gyn.setPriority(3);
        this.gyn.execute(new String[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.d> {
        y mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public com.baidu.tbadk.coreExtra.model.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.model.d dVar;
            Exception e;
            try {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.o("_phone_screen", stringBuffer.toString());
                if (c.DS().DV() > 0) {
                    this.mNetWork.o("_msg_status", "0");
                } else {
                    this.mNetWork.o("_msg_status", "1");
                }
                if (AboutModel.this.gyo) {
                    this.mNetWork.o("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.o("package", packageName);
                this.mNetWork.o("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.o("signmd5", as.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.o(ARResourceKey.HTTP_AR_MD5, UtilHelper.getTiebaApkMd5());
                String yo = this.mNetWork.yo();
                if (!this.mNetWork.yM().zL().isRequestSuccess()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.model.d();
                try {
                    dVar.parserJson(yo);
                    if (TbadkCoreApplication.getClientId() == null && dVar.Ex().getClientId() != null && dVar.Ex().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, dVar.Ex().getClientId());
                        TbadkCoreApplication.setClientId(dVar.Ex().getClientId());
                    }
                    w Ey = dVar.Ey();
                    if (Ey != null) {
                        b.getInstance().putBoolean("localvideo_open", Ey.CZ());
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
            AboutModel.this.gyn = null;
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.model.d dVar) {
            super.onPostExecute(dVar);
            if (dVar != null && dVar.getAdAdSense() != null) {
                TbadkCoreApplication.getInst().setAdAdSense(dVar.getAdAdSense());
            }
            AboutModel.this.gyn = null;
            AboutModel.this.mLoadDataCallBack.i(dVar);
        }
    }
}
