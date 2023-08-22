package com.baidu.tieba.setting.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.ck;
import com.baidu.tieba.h9;
import com.baidu.tieba.jz9;
import com.baidu.tieba.ke5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.re5;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.ud5;
import com.baidu.tieba.uh;
import com.baidu.tieba.zb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes8.dex */
public class AboutModel extends BdBaseModel<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public Context b;
    public final boolean c;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<String, Integer, re5> {
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
        public re5 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                re5 re5Var = null;
                try {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                    if (jz9.b()) {
                        this.a.addPostData(HttpRequest.OS_VERSION, DeviceInfoHelper.getOsVersion());
                    } else {
                        this.a.addPostData(HttpRequest.NEED_DECRYPT, jz9.c());
                        String g = jz9.g(HttpRequest.OS_VERSION);
                        if (!TextUtils.isEmpty(g)) {
                            this.a.addPostData(g, jz9.j());
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer(15);
                    stringBuffer.append(String.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                    stringBuffer.append(",");
                    stringBuffer.append(String.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                    this.a.addPostData("_phone_screen", stringBuffer.toString());
                    if (ke5.d().f() > 0) {
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
                    if (uh.a()) {
                        str = "64";
                    } else {
                        str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork2.addPostData("running_abi", str);
                    NetWork netWork3 = this.a;
                    if (!uh.b()) {
                        str2 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork3.addPostData("support_abi", str2);
                    String postNetData = this.a.postNetData();
                    if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                        re5 re5Var2 = new re5();
                        try {
                            re5Var2.C(postNetData);
                            if (TbadkCoreApplication.getClientId() == null && re5Var2.i().a() != null && re5Var2.i().a().length() > 0) {
                                TbadkCoreApplication.saveClientId(this.b.b, re5Var2.i().a());
                                TbadkCoreApplication.setClientId(re5Var2.i().a());
                            }
                            ud5 w = re5Var2.w();
                            if (w != null) {
                                SharedPrefHelper.getInstance().putBoolean("localvideo_open", w.z());
                            }
                            zb5 e = re5Var2.e();
                            if (e != null && !TextUtils.isEmpty(e.c())) {
                                SharedPrefHelper.getInstance().putString("sync_ad_privacy_url", e.c());
                            }
                            TbLog a = ck.a();
                            a.i(Config.DEVICE_PART, "sync success from about page: " + postNetData);
                            return re5Var2;
                        } catch (Exception e2) {
                            e = e2;
                            re5Var = re5Var2;
                            BdLog.e(e.getMessage());
                            TbLog a2 = ck.a();
                            a2.e(Config.DEVICE_PART, "sync exception from about page: " + e.getMessage());
                            return re5Var;
                        }
                    }
                    ck.a().e(Config.DEVICE_PART, "sync fail from about page");
                    return null;
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                return (re5) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(re5 re5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, re5Var) == null) {
                super.onPostExecute(re5Var);
                if (re5Var != null && re5Var.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(re5Var.e());
                }
                this.b.a = null;
                this.b.mLoadDataCallBack.c(re5Var);
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
    public AboutModel(BaseActivity baseActivity, h9 h9Var) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, h9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = h9Var;
        this.c = false;
    }

    public void R() {
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
