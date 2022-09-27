package com.baidu.tieba.setting.model;

import android.content.Context;
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
import com.baidu.tieba.c25;
import com.baidu.tieba.ej;
import com.baidu.tieba.gj;
import com.baidu.tieba.k25;
import com.baidu.tieba.l05;
import com.baidu.tieba.ox4;
import com.baidu.tieba.q9;
import com.baidu.tieba.r9;
import com.baidu.tieba.s25;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.ti;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes5.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public Context b;
    public final boolean c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AboutModel(BaseActivity baseActivity, q9 q9Var) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, q9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = q9Var;
        this.c = false;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == null) {
                this.a = new b(this, null);
            }
            this.a.setPriority(3);
            this.a.execute(new String[0]);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, s25> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ AboutModel b;

        public b(AboutModel aboutModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aboutModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aboutModel;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public s25 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (s25) invokeL.objValue;
            }
            s25 s25Var = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                this.a = netWork;
                netWork.addPostData("_os_version", gj.k());
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(ej.k(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(ej.i(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("_phone_screen", stringBuffer.toString());
                if (k25.d().f() > 0) {
                    this.a.addPostData("_msg_status", "0");
                } else {
                    this.a.addPostData("_msg_status", "1");
                }
                if (this.b.c) {
                    this.a.addPostData("reversion_return", "1");
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.a.addPostData(PackageTable.MD5, UtilHelper.getTiebaApkMd5());
                NetWork netWork3 = this.a;
                boolean a = ti.a();
                String str = WebKitFactory.OS_64;
                netWork3.addPostData("running_abi", a ? WebKitFactory.OS_64 : "32");
                NetWork netWork4 = this.a;
                if (!ti.b()) {
                    str = "32";
                }
                netWork4.addPostData("support_abi", str);
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    s25 s25Var2 = new s25();
                    try {
                        s25Var2.A(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && s25Var2.i().a() != null && s25Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b.b, s25Var2.i().a());
                            TbadkCoreApplication.setClientId(s25Var2.i().a());
                        }
                        c25 u = s25Var2.u();
                        if (u != null) {
                            ox4.k().u("localvideo_open", u.y());
                        }
                        l05 e = s25Var2.e();
                        if (e != null && !TextUtils.isEmpty(e.c())) {
                            ox4.k().y("sync_ad_privacy_url", e.c());
                        }
                        return s25Var2;
                    } catch (Exception e2) {
                        e = e2;
                        s25Var = s25Var2;
                        BdLog.e(e.getMessage());
                        return s25Var;
                    }
                }
                return null;
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(s25 s25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s25Var) == null) {
                super.onPostExecute(s25Var);
                if (s25Var != null && s25Var.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(s25Var.e());
                }
                this.b.a = null;
                this.b.mLoadDataCallBack.c(s25Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.a = null;
                NetWork netWork = this.a;
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
