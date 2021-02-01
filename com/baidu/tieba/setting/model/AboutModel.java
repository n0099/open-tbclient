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
/* loaded from: classes8.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private Context mContext;
    private a neF;
    private final boolean neG;

    public AboutModel(BaseActivity baseActivity, e eVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = eVar;
        this.neG = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.neF != null) {
            this.neF.cancel();
            return false;
        }
        return false;
    }

    public void checkUpdate() {
        if (this.neF == null) {
            this.neF = new a();
        }
        this.neF.setPriority(3);
        this.neF.execute(new String[0]);
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.e> {
        aa cml;

        private a() {
            this.cml = null;
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
                this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cml.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.cml.addPostData("_phone_screen", stringBuffer.toString());
                if (d.bye().byh() > 0) {
                    this.cml.addPostData("_msg_status", "0");
                } else {
                    this.cml.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.neG) {
                    this.cml.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cml.addPostData("package", packageName);
                this.cml.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cml.addPostData("signmd5", aw.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cml.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.cml.postNetData();
                if (!this.cml.bsr().btb().isRequestSuccess()) {
                    return null;
                }
                eVar = new com.baidu.tbadk.coreExtra.model.e();
                try {
                    eVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && eVar.byK().getClientId() != null && eVar.byK().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, eVar.byK().getClientId());
                        TbadkCoreApplication.setClientId(eVar.byK().getClientId());
                    }
                    aj byL = eVar.byL();
                    if (byL != null) {
                        b.brQ().putBoolean("localvideo_open", byL.bxk());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.brQ().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.neF = null;
            if (this.cml != null) {
                this.cml.cancelNetConnect();
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
            AboutModel.this.neF = null;
            AboutModel.this.mLoadDataCallBack.callback(eVar);
        }
    }
}
