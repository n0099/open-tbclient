package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.tieba.setting.more.AboutActivity;
import d.a.c.e.p.l;
import d.a.m0.s.c.k0;
import d.a.m0.s.d.d;
import d.a.m0.s.e.e;
/* loaded from: classes5.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f20384e;

    /* renamed from: f  reason: collision with root package name */
    public Context f20385f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f20386g;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, e> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20387a;

        public b() {
            this.f20387a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public e doInBackground(String... strArr) {
            e eVar = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.f20387a = netWork;
                netWork.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                this.f20387a.addPostData("_phone_screen", stringBuffer.toString());
                if (d.d().e() > 0) {
                    this.f20387a.addPostData("_msg_status", "0");
                } else {
                    this.f20387a.addPostData("_msg_status", "1");
                }
                if (AboutModel.this.f20386g) {
                    this.f20387a.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.f20387a.addPostData(AsInstallService.SCHEME_PACKAGE_ADDED, packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.f20387a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.f20387a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.f20387a.addPostData(PackageTable.MD5, UtilHelper.getTiebaApkMd5());
                String postNetData = this.f20387a.postNetData();
                if (this.f20387a.getNetContext().getResponse().isRequestSuccess()) {
                    e eVar2 = new e();
                    try {
                        eVar2.y(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar2.i().a() != null && eVar2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(AboutModel.this.f20385f, eVar2.i().a());
                            TbadkCoreApplication.setClientId(eVar2.i().a());
                        }
                        k0 t = eVar2.t();
                        if (t != null) {
                            d.a.m0.r.d0.b.j().t("localvideo_open", t.z());
                        }
                        d.a.m0.s.c.d e2 = eVar2.e();
                        if (e2 != null && !TextUtils.isEmpty(e2.c())) {
                            d.a.m0.r.d0.b.j().x("sync_ad_privacy_url", e2.c());
                        }
                        return eVar2;
                    } catch (Exception e3) {
                        e = e3;
                        eVar = eVar2;
                        BdLog.e(e.getMessage());
                        return eVar;
                    }
                }
                return null;
            } catch (Exception e4) {
                e = e4;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(e eVar) {
            super.onPostExecute(eVar);
            if (eVar != null && eVar.e() != null) {
                TbadkCoreApplication.getInst().setAdAdSense(eVar.e());
            }
            AboutModel.this.f20384e = null;
            AboutModel.this.mLoadDataCallBack.c(eVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AboutModel.this.f20384e = null;
            NetWork netWork = this.f20387a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public AboutModel(BaseActivity baseActivity, d.a.c.a.e eVar) {
        super(baseActivity.getPageContext());
        this.f20385f = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = eVar;
        this.f20386g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20384e;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }

    public void w() {
        if (this.f20384e == null) {
            this.f20384e = new b();
        }
        this.f20384e.setPriority(3);
        this.f20384e.execute(new String[0]);
    }
}
