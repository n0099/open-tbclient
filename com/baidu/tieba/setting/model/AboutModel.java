package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.aj;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes7.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private Context mContext;
    private a nhj;
    private final boolean nhk;

    public AboutModel(BaseActivity baseActivity, e eVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = eVar;
        this.nhk = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nhj != null) {
            this.nhj.cancel();
            return false;
        }
        return false;
    }

    public void checkUpdate() {
        if (this.nhj == null) {
            this.nhj = new a();
        }
        this.nhj.setPriority(3);
        this.nhj.execute(new String[0]);
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.e> {
        aa cnM;

        private a() {
            this.cnM = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Z */
        public com.baidu.tbadk.coreExtra.model.e doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.model.e eVar;
            try {
                this.cnM = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cnM.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.cnM.addPostData("_phone_screen", stringBuffer.toString());
                if (d.byh().byk() > 0) {
                    this.cnM.addPostData("_msg_status", "0");
                } else {
                    this.cnM.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.nhk) {
                    this.cnM.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cnM.addPostData("package", packageName);
                this.cnM.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cnM.addPostData("signmd5", aw.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cnM.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.cnM.postNetData();
                if (!this.cnM.bsu().bte().isRequestSuccess()) {
                    return null;
                }
                eVar = new com.baidu.tbadk.coreExtra.model.e();
                try {
                    eVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && eVar.byN().getClientId() != null && eVar.byN().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, eVar.byN().getClientId());
                        TbadkCoreApplication.setClientId(eVar.byN().getClientId());
                    }
                    aj byO = eVar.byO();
                    if (byO != null) {
                        b.brR().putBoolean("localvideo_open", byO.bxn());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.brR().putString("sync_ad_privacy_url", adAdSense.getUrl());
                        return eVar;
                    }
                    return eVar;
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    return eVar;
                }
            } catch (Exception e2) {
                e = e2;
                eVar = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AboutModel.this.nhj = null;
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.model.e eVar) {
            super.onPostExecute(eVar);
            if (eVar != null && eVar.getAdAdSense() != null) {
                TbadkCoreApplication.getInst().setAdAdSense(eVar.getAdAdSense());
            }
            AboutModel.this.nhj = null;
            AboutModel.this.mLoadDataCallBack.callback(eVar);
        }
    }
}
