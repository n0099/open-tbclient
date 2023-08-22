package com.baidu.tieba;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.data.DelAllUerDataReqMsg;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m05 {
    public static /* synthetic */ Interceptable $ic;
    public static m05 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressDialog a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947918871, "Lcom/baidu/tieba/m05;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947918871, "Lcom/baidu/tieba/m05;");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements gw5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m05 a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    toa.b(true);
                }
            }
        }

        public b(m05 m05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m05Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gw5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.d();
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    new TBAlertBuilder(currentActivity).setTitle(R.string.delete_success).setDesc(R.string.delete_all_user_data_hint).setOperateBtn(new TBAlertConfig.OperateBtnConfig(currentActivity.getString(R.string.obfuscated_res_0x7f0f1100), TBAlertConfig.OperateBtnStyle.MAIN, new a(this))).show();
                } else {
                    BdUtilHelper.showToast(currentActivity, (int) R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends bx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(m05 m05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.bx5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2008015, currentAccount));
                    ie5.p0().b0(true);
                    NotificationHelper.cancelAllNotification(TbadkCoreApplication.getInst());
                    dfa.B("");
                    j05.t().g(currentAccount, false);
                    BdCacheService.n().a(currentAccount);
                    SharedPrefHelper.getInstance().clearByAccount(currentAccount);
                    return Boolean.TRUE;
                } catch (Exception e) {
                    BdLog.e(e);
                    return Boolean.FALSE;
                }
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public m05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static m05 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (m05.class) {
                    if (b == null) {
                        b = new m05();
                    }
                }
            }
            return b;
        }
        return (m05) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fx5.b(new a(this), new b(this));
        }
    }

    public final void d() {
        ProgressDialog progressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (progressDialog = this.a) != null && progressDialog.isShowing()) {
            this.a.dismiss();
            this.a = null;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            DelAllUerDataReqMsg delAllUerDataReqMsg = new DelAllUerDataReqMsg();
            delAllUerDataReqMsg.setOpType(1);
            MessageManager.getInstance().sendMessage(delAllUerDataReqMsg);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ProgressDialog progressDialog = this.a;
            if (progressDialog == null) {
                this.a = BdUtilHelper.showLoadingDialog(TbadkCoreApplication.getInst().getCurrentActivity(), null);
            } else {
                progressDialog.show();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g();
            f();
        }
    }

    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
            if (z) {
                d();
                BdUtilHelper.showToast(TbadkCoreApplication.getInst().getCurrentActivity(), str);
                return;
            }
            b();
        }
    }
}
