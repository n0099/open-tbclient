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
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tieba.setting.more.AboutActivity;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes20.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private a lOb;
    private final boolean lOc;
    private Context mContext;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.lOc = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lOb != null) {
            this.lOb.cancel();
            return false;
        }
        return false;
    }

    public void dqe() {
        if (this.lOb == null) {
            this.lOb = new a();
        }
        this.lOb.setPriority(3);
        this.lOb.execute(new String[0]);
    }

    /* loaded from: classes20.dex */
    private class a extends BdAsyncTask<String, Integer, e> {
        aa bDY;

        private a() {
            this.bDY = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.bDY = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bDY.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.bDY.addPostData("_phone_screen", stringBuffer.toString());
                if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() > 0) {
                    this.bDY.addPostData("_msg_status", "0");
                } else {
                    this.bDY.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.lOc) {
                    this.bDY.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bDY.addPostData("package", packageName);
                this.bDY.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bDY.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bDY.addPostData("md5", UtilHelper.getTiebaApkMd5());
                String postNetData = this.bDY.postNetData();
                if (!this.bDY.biQ().bjw().isRequestSuccess()) {
                    return null;
                }
                eVar = new e();
                try {
                    eVar.parserJson(postNetData);
                    if (TbadkCoreApplication.getClientId() == null && eVar.bpd().getClientId() != null && eVar.bpd().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, eVar.bpd().getClientId());
                        TbadkCoreApplication.setClientId(eVar.bpd().getClientId());
                    }
                    ai bpe = eVar.bpe();
                    if (bpe != null) {
                        b.bik().putBoolean("localvideo_open", bpe.bnE());
                    }
                    com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                    if (adAdSense != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                        b.bik().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            AboutModel.this.lOb = null;
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
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
            AboutModel.this.lOb = null;
            AboutModel.this.mLoadDataCallBack.callback(eVar);
        }
    }
}
