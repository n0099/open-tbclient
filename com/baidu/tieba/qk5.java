package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qk5 {
    public static /* synthetic */ Interceptable $ic;
    public static qk5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948094734, "Lcom/baidu/tieba/qk5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948094734, "Lcom/baidu/tieba/qk5;");
        }
    }

    public qk5() {
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

    public static synchronized qk5 c() {
        InterceptResult invokeV;
        qk5 qk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (qk5.class) {
                if (a == null) {
                    a = new qk5();
                }
                qk5Var = a;
            }
            return qk5Var;
        }
        return (qk5) invokeV.objValue;
    }

    public void a(PayConfig payConfig, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, payConfig, context) == null) {
            if (payConfig != null && context != null) {
                if (!d()) {
                    e(R.string.plugin_pay_wallet_not_found);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayWalletActivityConfig(context, payConfig)));
                return;
            }
            e(R.string.plugin_pay_error);
        }
    }

    public void b(String str, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2001351) || !TbadkCoreApplication.getInst().isWalletShouldOpen() || Build.VERSION.SDK_INT < 8) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            hi.P(TbadkCoreApplication.getInst().getContext(), i);
        }
    }
}
