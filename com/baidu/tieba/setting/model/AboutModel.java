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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.aj;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes7.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private Context mContext;
    private a mUW;
    private final boolean mUX;

    public AboutModel(BaseActivity baseActivity, e eVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = eVar;
        this.mUX = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mUW != null) {
            this.mUW.cancel();
            return false;
        }
        return false;
    }

    public void checkUpdate() {
        if (this.mUW == null) {
            this.mUW = new a();
        }
        this.mUW.setPriority(3);
        this.mUW.execute(new String[0]);
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.e> {
        z chV;

        private a() {
            this.chV = null;
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
                this.chV = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.chV.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.chV.addPostData("_phone_screen", stringBuffer.toString());
                if (d.bxM().bxP() > 0) {
                    this.chV.addPostData("_msg_status", "0");
                } else {
                    this.chV.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.mUX) {
                    this.chV.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.chV.addPostData("package", packageName);
                this.chV.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.chV.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.chV.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.chV.postNetData();
                if (!this.chV.brX().bsH().isRequestSuccess()) {
                    return null;
                }
                eVar = new com.baidu.tbadk.coreExtra.model.e();
                try {
                    eVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && eVar.bys().getClientId() != null && eVar.bys().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, eVar.bys().getClientId());
                        TbadkCoreApplication.setClientId(eVar.bys().getClientId());
                    }
                    aj byt = eVar.byt();
                    if (byt != null) {
                        b.brx().putBoolean("localvideo_open", byt.bwS());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.brx().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.mUW = null;
            if (this.chV != null) {
                this.chV.cancelNetConnect();
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
            AboutModel.this.mUW = null;
            AboutModel.this.mLoadDataCallBack.callback(eVar);
        }
    }
}
