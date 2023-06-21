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
import com.baidu.tieba.ee5;
import com.baidu.tieba.j9;
import com.baidu.tieba.jc5;
import com.baidu.tieba.k9;
import com.baidu.tieba.li;
import com.baidu.tieba.o95;
import com.baidu.tieba.oe5;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.sl9;
import com.baidu.tieba.tr8;
import com.baidu.tieba.wi;
import com.baidu.tieba.wk;
import com.baidu.tieba.xe5;
import com.baidu.tieba.yi;
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
    public class b extends BdAsyncTask<String, Integer, xe5> {
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
        public xe5 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                xe5 xe5Var = null;
                try {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                    if (sl9.b()) {
                        this.a.addPostData(HttpRequest.OS_VERSION, yi.k());
                    } else {
                        this.a.addPostData(HttpRequest.NEED_DECRYPT, sl9.c());
                        String g = sl9.g(HttpRequest.OS_VERSION);
                        if (!TextUtils.isEmpty(g)) {
                            this.a.addPostData(g, sl9.j());
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer(15);
                    stringBuffer.append(String.valueOf(wi.l(TbadkCoreApplication.getInst().getApp())));
                    stringBuffer.append(",");
                    stringBuffer.append(String.valueOf(wi.j(TbadkCoreApplication.getInst().getApp())));
                    this.a.addPostData("_phone_screen", stringBuffer.toString());
                    if (oe5.d().f() > 0) {
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
                    if (li.a()) {
                        str = "64";
                    } else {
                        str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork2.addPostData("running_abi", str);
                    NetWork netWork3 = this.a;
                    if (!li.b()) {
                        str2 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork3.addPostData("support_abi", str2);
                    String postNetData = this.a.postNetData();
                    if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                        xe5 xe5Var2 = new xe5();
                        try {
                            xe5Var2.B(postNetData);
                            if (TbadkCoreApplication.getClientId() == null && xe5Var2.i().a() != null && xe5Var2.i().a().length() > 0) {
                                TbadkCoreApplication.saveClientId(this.b.b, xe5Var2.i().a());
                                TbadkCoreApplication.setClientId(xe5Var2.i().a());
                            }
                            ee5 v = xe5Var2.v();
                            if (v != null) {
                                o95.p().A("localvideo_open", v.y());
                            }
                            jc5 e = xe5Var2.e();
                            if (e != null && !TextUtils.isEmpty(e.c())) {
                                o95.p().J("sync_ad_privacy_url", e.c());
                            }
                            tr8 a = wk.a();
                            a.c(Config.DEVICE_PART, "sync success from about page: " + postNetData);
                            return xe5Var2;
                        } catch (Exception e2) {
                            e = e2;
                            xe5Var = xe5Var2;
                            BdLog.e(e.getMessage());
                            tr8 a2 = wk.a();
                            a2.b(Config.DEVICE_PART, "sync exception from about page: " + e.getMessage());
                            return xe5Var;
                        }
                    }
                    wk.a().b(Config.DEVICE_PART, "sync fail from about page");
                    return null;
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                return (xe5) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(xe5 xe5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xe5Var) == null) {
                super.onPostExecute(xe5Var);
                if (xe5Var != null && xe5Var.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(xe5Var.e());
                }
                this.b.a = null;
                this.b.mLoadDataCallBack.c(xe5Var);
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
    public AboutModel(BaseActivity baseActivity, j9 j9Var) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, j9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = baseActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = j9Var;
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
