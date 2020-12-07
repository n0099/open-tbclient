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
/* loaded from: classes26.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private Context mContext;
    private a mUd;
    private final boolean mUe;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.mUe = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mUd != null) {
            this.mUd.cancel();
            return false;
        }
        return false;
    }

    public void dIf() {
        if (this.mUd == null) {
            this.mUd = new a();
        }
        this.mUd.setPriority(3);
        this.mUd.execute(new String[0]);
    }

    /* loaded from: classes26.dex */
    private class a extends BdAsyncTask<String, Integer, e> {
        aa cfI;

        private a() {
            this.cfI = null;
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
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cfI.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.cfI.addPostData("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo() > 0) {
                    this.cfI.addPostData("_msg_status", "0");
                } else {
                    this.cfI.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.mUe) {
                    this.cfI.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cfI.addPostData("package", packageName);
                this.cfI.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cfI.addPostData("signmd5", aw.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cfI.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.cfI.postNetData();
                if (!this.cfI.btv().buf().isRequestSuccess()) {
                    return null;
                }
                eVar = new e();
                try {
                    eVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && eVar.bzR().getClientId() != null && eVar.bzR().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, eVar.bzR().getClientId());
                        TbadkCoreApplication.setClientId(eVar.bzR().getClientId());
                    }
                    aj bzS = eVar.bzS();
                    if (bzS != null) {
                        b.bsO().putBoolean("localvideo_open", bzS.byr());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.bsO().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.mUd = null;
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
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
            AboutModel.this.mUd = null;
            AboutModel.this.mLoadDataCallBack.callback(eVar);
        }
    }
}
