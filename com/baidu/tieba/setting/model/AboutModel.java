package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tieba.setting.more.AboutActivity;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private a iqX;
    private final boolean iqY;
    private Context mContext;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.iqY = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iqX != null) {
            this.iqX.cancel();
            return false;
        }
        return false;
    }

    public void bYJ() {
        if (this.iqX == null) {
            this.iqX = new a();
        }
        this.iqX.setPriority(3);
        this.iqX.execute(new String[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.d> {
        x mNetWork;

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
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.model.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.model.d dVar;
            Exception e;
            try {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.x("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aik() > 0) {
                    this.mNetWork.x("_msg_status", "0");
                } else {
                    this.mNetWork.x("_msg_status", "1");
                }
                if (AboutModel.this.iqY) {
                    this.mNetWork.x("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.x("package", packageName);
                this.mNetWork.x("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.x("signmd5", as.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.x("md5", UtilHelper.getTiebaApkMd5());
                String acj = this.mNetWork.acj();
                if (!this.mNetWork.acH().adG().isRequestSuccess()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.model.d();
                try {
                    dVar.parserJson(acj);
                    if (TbadkCoreApplication.getClientId() == null && dVar.aiP().getClientId() != null && dVar.aiP().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, dVar.aiP().getClientId());
                        TbadkCoreApplication.setClientId(dVar.aiP().getClientId());
                    }
                    z aiQ = dVar.aiQ();
                    if (aiQ != null) {
                        b.getInstance().putBoolean("localvideo_open", aiQ.ahl());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.getInstance().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.iqX = null;
            if (this.mNetWork != null) {
                this.mNetWork.ji();
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
            AboutModel.this.iqX = null;
            AboutModel.this.mLoadDataCallBack.m(dVar);
        }
    }
}
