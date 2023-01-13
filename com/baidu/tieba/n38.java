package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.sr4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n38 extends sr4 {
    public static /* synthetic */ Interceptable $ic;
    public static n38 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final sr4.a b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947951638, "Lcom/baidu/tieba/n38;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947951638, "Lcom/baidu/tieba/n38;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements sr4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.sr4.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        public a(n38 n38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.sr4.a
        public void c(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921613));
            }
        }

        @Override // com.baidu.tieba.sr4.a
        public void a(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) && i == 1) {
                ReloginManager.g().f(null);
            }
        }
    }

    public n38() {
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
        this.b = new a(this);
    }

    public static n38 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                c = new n38();
            }
            return c;
        }
        return (n38) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sr4
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, sr4.a aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, aVar)) == null) {
            return ty7.a(str, str2, str3, str4, aVar);
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }

    @Override // com.baidu.tieba.sr4
    public sr4.b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            sr4.b bVar = null;
            if (str == null) {
                return null;
            }
            try {
                String[] split = str.split("[|]");
                if (split == null || split.length < 1) {
                    return null;
                }
                sr4.b bVar2 = new sr4.b();
                try {
                    bVar2.a = split[0];
                    if (split.length >= 2) {
                        bVar2.b = split[1];
                    }
                    return bVar2;
                } catch (Exception e) {
                    e = e;
                    bVar = bVar2;
                    BdLog.e(e.getMessage());
                    return bVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (sr4.b) invokeL.objValue;
        }
    }

    @Override // com.baidu.tieba.sr4
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            sr4.b c2 = c(currentAccountObj.getBDUSS());
            if (c2 != null) {
                ty7.a(currentAccountObj.getAccount(), c2.a, c2.b, currentAccountObj.getStoken(), this.b);
                return;
            }
            return;
        }
        ry4.a(DI.ACCOUNT, -1L, 0, "main_tab_has_no_cache_account", 0, "", new Object[0]);
    }
}
