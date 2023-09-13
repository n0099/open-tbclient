package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sg9 extends AccountLoginCoreHelper {
    public static /* synthetic */ Interceptable $ic;
    public static sg9 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final AccountLoginCoreHelper.IReLoginCallback a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948150596, "Lcom/baidu/tieba/sg9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948150596, "Lcom/baidu/tieba/sg9;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements AccountLoginCoreHelper.IReLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onBeforeLogin(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        public a(sg9 sg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onSuccess(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921613));
            }
        }

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onFailure(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2) == null) && i == 1) {
                ReloginManager.g().f(null);
            }
        }
    }

    public sg9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new a(this);
    }

    public static sg9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = new sg9();
            }
            return b;
        }
        return (sg9) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper
    public BdAsyncTask<?, ?, ?> asyncReLogin(String str, String str2, String str3, String str4, AccountLoginCoreHelper.IReLoginCallback iReLoginCallback) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, iReLoginCallback)) == null) {
            return xb9.a(str, str2, str3, str4, iReLoginCallback);
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper
    public AccountLoginCoreHelper.a parseBDUSS(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            AccountLoginCoreHelper.a aVar = null;
            if (str == null) {
                return null;
            }
            try {
                String[] split = str.split("[|]");
                if (split == null || split.length < 1) {
                    return null;
                }
                AccountLoginCoreHelper.a aVar2 = new AccountLoginCoreHelper.a();
                try {
                    aVar2.a = split[0];
                    if (split.length >= 2) {
                        aVar2.b = split[1];
                    }
                    return aVar2;
                } catch (Exception e) {
                    e = e;
                    aVar = aVar2;
                    BdLog.e(e.getMessage());
                    return aVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (AccountLoginCoreHelper.a) invokeL.objValue;
        }
    }

    @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper
    public void reLoginByCacheAccount() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            AccountLoginCoreHelper.a parseBDUSS = parseBDUSS(currentAccountObj.getBDUSS());
            if (parseBDUSS != null) {
                xb9.a(currentAccountObj.getAccount(), parseBDUSS.a, parseBDUSS.b, currentAccountObj.getStoken(), this.a);
                return;
            }
            return;
        }
        Logger.addLog("account", -1L, 0, "main_tab_has_no_cache_account", 0, "", new Object[0]);
    }
}
