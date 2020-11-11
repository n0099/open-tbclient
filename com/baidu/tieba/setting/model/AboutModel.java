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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.aj;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tieba.setting.more.AboutActivity;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes26.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private Context mContext;
    private a mFD;
    private final boolean mFE;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.mFE = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mFD != null) {
            this.mFD.cancel();
            return false;
        }
        return false;
    }

    public void dDq() {
        if (this.mFD == null) {
            this.mFD = new a();
        }
        this.mFD.setPriority(3);
        this.mFD.execute(new String[0]);
    }

    /* loaded from: classes26.dex */
    private class a extends BdAsyncTask<String, Integer, e> {
        aa caS;

        private a() {
            this.caS = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.caS = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.caS.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.caS.addPostData("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwy() > 0) {
                    this.caS.addPostData("_msg_status", "0");
                } else {
                    this.caS.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.mFE) {
                    this.caS.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.caS.addPostData("package", packageName);
                this.caS.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.caS.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.caS.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.caS.postNetData();
                if (!this.caS.bqN().bru().isRequestSuccess()) {
                    return null;
                }
                eVar = new e();
                try {
                    eVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && eVar.bxb().getClientId() != null && eVar.bxb().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, eVar.bxb().getClientId());
                        TbadkCoreApplication.setClientId(eVar.bxb().getClientId());
                    }
                    aj bxc = eVar.bxc();
                    if (bxc != null) {
                        b.bqh().putBoolean("localvideo_open", bxc.bvB());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.bqh().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.mFD = null;
            if (this.caS != null) {
                this.caS.cancelNetConnect();
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
            AboutModel.this.mFD = null;
            AboutModel.this.mLoadDataCallBack.callback(eVar);
        }
    }
}
