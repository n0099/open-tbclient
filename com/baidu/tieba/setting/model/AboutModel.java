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
/* loaded from: classes8.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private Context mContext;
    private a mZC;
    private final boolean mZD;

    public AboutModel(BaseActivity baseActivity, e eVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = eVar;
        this.mZD = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mZC != null) {
            this.mZC.cancel();
            return false;
        }
        return false;
    }

    public void checkUpdate() {
        if (this.mZC == null) {
            this.mZC = new a();
        }
        this.mZC.setPriority(3);
        this.mZC.execute(new String[0]);
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.e> {
        z cmJ;

        private a() {
            this.cmJ = null;
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
                this.cmJ = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cmJ.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.cmJ.addPostData("_phone_screen", stringBuffer.toString());
                if (d.bBF().bBI() > 0) {
                    this.cmJ.addPostData("_msg_status", "0");
                } else {
                    this.cmJ.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.mZD) {
                    this.cmJ.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cmJ.addPostData("package", packageName);
                this.cmJ.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cmJ.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cmJ.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.cmJ.postNetData();
                if (!this.cmJ.bvQ().bwA().isRequestSuccess()) {
                    return null;
                }
                eVar = new com.baidu.tbadk.coreExtra.model.e();
                try {
                    eVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && eVar.bCl().getClientId() != null && eVar.bCl().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, eVar.bCl().getClientId());
                        TbadkCoreApplication.setClientId(eVar.bCl().getClientId());
                    }
                    aj bCm = eVar.bCm();
                    if (bCm != null) {
                        b.bvq().putBoolean("localvideo_open", bCm.bAL());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.bvq().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.mZC = null;
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
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
            AboutModel.this.mZC = null;
            AboutModel.this.mLoadDataCallBack.callback(eVar);
        }
    }
}
