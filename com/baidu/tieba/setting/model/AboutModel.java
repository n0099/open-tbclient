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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tieba.setting.more.AboutActivity;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private a jQp;
    private final boolean jQq;
    private Context mContext;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.jQq = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jQp != null) {
            this.jQp.cancel();
            return false;
        }
        return false;
    }

    public void cDB() {
        if (this.jQp == null) {
            this.jQp = new a();
        }
        this.jQp.setPriority(3);
        this.jQp.execute(new String[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.d> {
        x cHA;

        private a() {
            this.cHA = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: N */
        public com.baidu.tbadk.coreExtra.model.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.model.d dVar;
            Exception e;
            try {
                this.cHA = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cHA.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.cHA.addPostData("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIT() > 0) {
                    this.cHA.addPostData("_msg_status", "0");
                } else {
                    this.cHA.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.jQq) {
                    this.cHA.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cHA.addPostData("package", packageName);
                this.cHA.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cHA.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cHA.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.cHA.postNetData();
                if (!this.cHA.aDU().aEv().isRequestSuccess()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.model.d();
                try {
                    dVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && dVar.aJu().getClientId() != null && dVar.aJu().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, dVar.aJu().getClientId());
                        TbadkCoreApplication.setClientId(dVar.aJu().getClientId());
                    }
                    ab aJv = dVar.aJv();
                    if (aJv != null) {
                        b.aDr().putBoolean("localvideo_open", aJv.aHS());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.aDr().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.jQp = null;
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
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
            AboutModel.this.jQp = null;
            AboutModel.this.mLoadDataCallBack.callback(dVar);
        }
    }
}
