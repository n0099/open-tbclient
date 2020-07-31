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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tieba.setting.more.AboutActivity;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes20.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private a lwL;
    private final boolean lwM;
    private Context mContext;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.lwM = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lwL != null) {
            this.lwL.cancel();
            return false;
        }
        return false;
    }

    public void deL() {
        if (this.lwL == null) {
            this.lwL = new a();
        }
        this.lwL.setPriority(3);
        this.lwL.execute(new String[0]);
    }

    /* loaded from: classes20.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.d> {
        z byq;

        private a() {
            this.byq = null;
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
                this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.byq.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.byq.addPostData("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfR() > 0) {
                    this.byq.addPostData("_msg_status", "0");
                } else {
                    this.byq.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.lwM) {
                    this.byq.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.byq.addPostData("package", packageName);
                this.byq.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.byq.addPostData("signmd5", au.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.byq.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.byq.postNetData();
                if (!this.byq.bav().baX().isRequestSuccess()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.model.d();
                try {
                    dVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && dVar.bgs().getClientId() != null && dVar.bgs().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, dVar.bgs().getClientId());
                        TbadkCoreApplication.setClientId(dVar.bgs().getClientId());
                    }
                    af bgt = dVar.bgt();
                    if (bgt != null) {
                        b.aZP().putBoolean("localvideo_open", bgt.beU());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.aZP().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.lwL = null;
            if (this.byq != null) {
                this.byq.cancelNetConnect();
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
            AboutModel.this.lwL = null;
            AboutModel.this.mLoadDataCallBack.callback(dVar);
        }
    }
}
