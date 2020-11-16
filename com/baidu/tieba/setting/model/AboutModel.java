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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.aj;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tieba.setting.more.AboutActivity;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes25.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private Context mContext;
    private a mGa;
    private final boolean mGb;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.mGb = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mGa != null) {
            this.mGa.cancel();
            return false;
        }
        return false;
    }

    public void dCU() {
        if (this.mGa == null) {
            this.mGa = new a();
        }
        this.mGa.setPriority(3);
        this.mGa.execute(new String[0]);
    }

    /* loaded from: classes25.dex */
    private class a extends BdAsyncTask<String, Integer, e> {
        aa bZh;

        private a() {
            this.bZh = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: T */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.bZh = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bZh.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.bZh.addPostData("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvO() > 0) {
                    this.bZh.addPostData("_msg_status", "0");
                } else {
                    this.bZh.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.mGb) {
                    this.bZh.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bZh.addPostData("package", packageName);
                this.bZh.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bZh.addPostData("signmd5", aw.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bZh.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.bZh.postNetData();
                if (!this.bZh.bqa().bqI().isRequestSuccess()) {
                    return null;
                }
                eVar = new e();
                try {
                    eVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && eVar.bwr().getClientId() != null && eVar.bwr().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, eVar.bwr().getClientId());
                        TbadkCoreApplication.setClientId(eVar.bwr().getClientId());
                    }
                    aj bws = eVar.bws();
                    if (bws != null) {
                        b.bpu().putBoolean("localvideo_open", bws.buR());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.bpu().putString("sync_ad_privacy_url", adAdSense.getUrl());
                        return eVar;
                    }
                    return eVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return eVar;
                }
            } catch (Exception e3) {
                eVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AboutModel.this.mGa = null;
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(e eVar) {
            super.onPostExecute(eVar);
            if (eVar != null && eVar.getAdAdSense() != null) {
                TbadkCoreApplication.getInst().setAdAdSense(eVar.getAdAdSense());
            }
            AboutModel.this.mGa = null;
            AboutModel.this.mLoadDataCallBack.callback(eVar);
        }
    }
}
