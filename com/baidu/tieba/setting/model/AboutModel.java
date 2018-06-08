package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes3.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    private a gtk;
    private final boolean gtl;
    private Context mContext;

    public AboutModel(BaseActivity baseActivity, d dVar) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = dVar;
        this.gtl = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gtk != null) {
            this.gtk.cancel();
            return false;
        }
        return false;
    }

    public void bqg() {
        if (this.gtk == null) {
            this.gtk = new a();
        }
        this.gtk.setPriority(3);
        this.gtk.execute(new String[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.model.d> {
        y mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public com.baidu.tbadk.coreExtra.model.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.model.d dVar;
            Exception e;
            try {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.o("_phone_screen", stringBuffer.toString());
                if (c.DE().DH() > 0) {
                    this.mNetWork.o("_msg_status", "0");
                } else {
                    this.mNetWork.o("_msg_status", "1");
                }
                if (AboutModel.this.gtl) {
                    this.mNetWork.o("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.o("package", packageName);
                this.mNetWork.o("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.o("signmd5", ar.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.o(ARResourceKey.HTTP_AR_MD5, UtilHelper.getTiebaApkMd5());
                String yl = this.mNetWork.yl();
                if (!this.mNetWork.yJ().zJ().isRequestSuccess()) {
                    return null;
                }
                dVar = new com.baidu.tbadk.coreExtra.model.d();
                try {
                    dVar.parserJson(yl);
                    if (TbadkCoreApplication.getClientId() == null && dVar.Ej().getClientId() != null && dVar.Ej().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(AboutModel.this.mContext, dVar.Ej().getClientId());
                        TbadkCoreApplication.setClientId(dVar.Ej().getClientId());
                    }
                    v Ek = dVar.Ek();
                    if (Ek != null) {
                        b.getInstance().putBoolean("localvideo_open", Ek.CO());
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
            AboutModel.this.gtk = null;
            if (this.mNetWork != null) {
                this.mNetWork.hN();
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
            AboutModel.this.gtk = null;
            AboutModel.this.mLoadDataCallBack.i(dVar);
        }
    }
}
