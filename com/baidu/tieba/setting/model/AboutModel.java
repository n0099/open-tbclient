package com.baidu.tieba.setting.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.bf5;
import com.baidu.tieba.eq9;
import com.baidu.tieba.ew8;
import com.baidu.tieba.he5;
import com.baidu.tieba.k9;
import com.baidu.tieba.l9;
import com.baidu.tieba.mc5;
import com.baidu.tieba.mi;
import com.baidu.tieba.r95;
import com.baidu.tieba.se5;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.xi;
import com.baidu.tieba.xk;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes7.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public Context b;
    public final boolean c;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, Integer, bf5> {
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
        public bf5 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                bf5 bf5Var = null;
                try {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                    if (eq9.b()) {
                        this.a.addPostData(HttpRequest.OS_VERSION, zi.k());
                    } else {
                        this.a.addPostData(HttpRequest.NEED_DECRYPT, eq9.c());
                        String g = eq9.g(HttpRequest.OS_VERSION);
                        if (!TextUtils.isEmpty(g)) {
                            this.a.addPostData(g, eq9.j());
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer(15);
                    stringBuffer.append(String.valueOf(xi.l(TbadkCoreApplication.getInst().getApp())));
                    stringBuffer.append(",");
                    stringBuffer.append(String.valueOf(xi.j(TbadkCoreApplication.getInst().getApp())));
                    this.a.addPostData("_phone_screen", stringBuffer.toString());
                    if (se5.d().f() > 0) {
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
                    NetWork netWork = this.a;
                    netWork.addPostData("versioncode", versionCode + "");
                    this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                    this.a.addPostData(PackageTable.MD5, UtilHelper.getTiebaApkMd5());
                    NetWork netWork2 = this.a;
                    String str2 = "64";
                    if (mi.a()) {
                        str = "64";
                    } else {
                        str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork2.addPostData("running_abi", str);
                    NetWork netWork3 = this.a;
                    if (!mi.b()) {
                        str2 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork3.addPostData("support_abi", str2);
                    String postNetData = this.a.postNetData();
                    if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                        bf5 bf5Var2 = new bf5();
                        try {
                            bf5Var2.B(postNetData);
                            if (TbadkCoreApplication.getClientId() == null && bf5Var2.i().a() != null && bf5Var2.i().a().length() > 0) {
                                TbadkCoreApplication.saveClientId(this.b.b, bf5Var2.i().a());
                                TbadkCoreApplication.setClientId(bf5Var2.i().a());
                            }
                            he5 v = bf5Var2.v();
                            if (v != null) {
                                r95.p().A("localvideo_open", v.y());
                            }
                            mc5 e = bf5Var2.e();
                            if (e != null && !TextUtils.isEmpty(e.c())) {
                                r95.p().J("sync_ad_privacy_url", e.c());
                            }
                            ew8 a = xk.a();
                            a.c(Config.DEVICE_PART, "sync success from about page: " + postNetData);
                            return bf5Var2;
                        } catch (Exception e2) {
                            e = e2;
                            bf5Var = bf5Var2;
                            BdLog.e(e.getMessage());
                            ew8 a2 = xk.a();
                            a2.b(Config.DEVICE_PART, "sync exception from about page: " + e.getMessage());
                            return bf5Var;
                        }
                    }
                    xk.a().b(Config.DEVICE_PART, "sync fail from about page");
                    return null;
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                return (bf5) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(bf5 bf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bf5Var) == null) {
                super.onPostExecute(bf5Var);
                if (bf5Var != null && bf5Var.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(bf5Var.e());
                }
                this.b.a = null;
                this.b.mLoadDataCallBack.c(bf5Var);
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
    public AboutModel(BaseActivity baseActivity, k9 k9Var) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, k9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = k9Var;
        this.c = false;
    }

    public void Y() {
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
