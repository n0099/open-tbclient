package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.r0.s.c.k0;
import d.a.r0.s.d.d;
/* loaded from: classes5.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f20692e;

    /* renamed from: f  reason: collision with root package name */
    public Context f20693f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f20694g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AboutModel(BaseActivity baseActivity, e eVar) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20693f = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = eVar;
        this.f20694g = false;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f20692e == null) {
                this.f20692e = new b(this, null);
            }
            this.f20692e.setPriority(3);
            this.f20692e.execute(new String[0]);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.f20692e;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, d.a.r0.s.e.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20695a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AboutModel f20696b;

        public b(AboutModel aboutModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aboutModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20696b = aboutModel;
            this.f20695a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.r0.s.e.e doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (d.a.r0.s.e.e) invokeL.objValue;
            }
            d.a.r0.s.e.e eVar = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.f20695a = netWork;
                netWork.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                this.f20695a.addPostData("_phone_screen", stringBuffer.toString());
                if (d.d().e() > 0) {
                    this.f20695a.addPostData("_msg_status", "0");
                } else {
                    this.f20695a.addPostData("_msg_status", "1");
                }
                if (this.f20696b.f20694g) {
                    this.f20695a.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.f20695a.addPostData(AsInstallService.SCHEME_PACKAGE_ADDED, packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.f20695a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.f20695a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.f20695a.addPostData(PackageTable.MD5, UtilHelper.getTiebaApkMd5());
                String postNetData = this.f20695a.postNetData();
                if (this.f20695a.getNetContext().getResponse().isRequestSuccess()) {
                    d.a.r0.s.e.e eVar2 = new d.a.r0.s.e.e();
                    try {
                        eVar2.z(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar2.i().a() != null && eVar2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.f20696b.f20693f, eVar2.i().a());
                            TbadkCoreApplication.setClientId(eVar2.i().a());
                        }
                        k0 t = eVar2.t();
                        if (t != null) {
                            d.a.r0.r.d0.b.j().t("localvideo_open", t.z());
                        }
                        d.a.r0.s.c.d e2 = eVar2.e();
                        if (e2 != null && !TextUtils.isEmpty(e2.c())) {
                            d.a.r0.r.d0.b.j().x("sync_ad_privacy_url", e2.c());
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
        public void onPostExecute(d.a.r0.s.e.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                super.onPostExecute(eVar);
                if (eVar != null && eVar.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(eVar.e());
                }
                this.f20696b.f20692e = null;
                this.f20696b.mLoadDataCallBack.c(eVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f20696b.f20692e = null;
                NetWork netWork = this.f20695a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
            }
        }

        public /* synthetic */ b(AboutModel aboutModel, a aVar) {
            this(aboutModel);
        }
    }
}
