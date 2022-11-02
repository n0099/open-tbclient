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
import com.baidu.tieba.a35;
import com.baidu.tieba.g15;
import com.baidu.tieba.i35;
import com.baidu.tieba.ky4;
import com.baidu.tieba.mi;
import com.baidu.tieba.q35;
import com.baidu.tieba.q9;
import com.baidu.tieba.r9;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.xi;
import com.baidu.tieba.zi;
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
    public class b extends BdAsyncTask<String, Integer, q35> {
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

        public /* synthetic */ b(AboutModel aboutModel, a aVar) {
            this(aboutModel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public q35 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                q35 q35Var = null;
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                    this.a = netWork;
                    netWork.addPostData("_os_version", zi.k());
                    StringBuffer stringBuffer = new StringBuffer(15);
                    stringBuffer.append(String.valueOf(xi.l(TbadkCoreApplication.getInst().getApp())));
                    stringBuffer.append(",");
                    stringBuffer.append(String.valueOf(xi.j(TbadkCoreApplication.getInst().getApp())));
                    this.a.addPostData("_phone_screen", stringBuffer.toString());
                    if (i35.d().f() > 0) {
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
                    boolean a = mi.a();
                    String str2 = WebKitFactory.OS_64;
                    if (!a) {
                        str = "32";
                    } else {
                        str = WebKitFactory.OS_64;
                    }
                    netWork3.addPostData("running_abi", str);
                    NetWork netWork4 = this.a;
                    if (!mi.b()) {
                        str2 = "32";
                    }
                    netWork4.addPostData("support_abi", str2);
                    String postNetData = this.a.postNetData();
                    if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    q35 q35Var2 = new q35();
                    try {
                        q35Var2.B(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && q35Var2.i().a() != null && q35Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b.b, q35Var2.i().a());
                            TbadkCoreApplication.setClientId(q35Var2.i().a());
                        }
                        a35 v = q35Var2.v();
                        if (v != null) {
                            ky4.k().u("localvideo_open", v.y());
                        }
                        g15 e = q35Var2.e();
                        if (e != null && !TextUtils.isEmpty(e.c())) {
                            ky4.k().y("sync_ad_privacy_url", e.c());
                        }
                        return q35Var2;
                    } catch (Exception e2) {
                        e = e2;
                        q35Var = q35Var2;
                        BdLog.e(e.getMessage());
                        return q35Var;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                return (q35) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(q35 q35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q35Var) == null) {
                super.onPostExecute(q35Var);
                if (q35Var != null && q35Var.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(q35Var.e());
                }
                this.b.a = null;
                this.b.mLoadDataCallBack.c(q35Var);
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
}
