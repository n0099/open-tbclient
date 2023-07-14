package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class oj9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oj9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948034315, "Lcom/baidu/tieba/oj9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948034315, "Lcom/baidu/tieba/oj9;");
        }
    }

    public oj9() {
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

    public static oj9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (oj9.class) {
                    if (a == null) {
                        a = new oj9();
                    }
                }
            }
            return a;
        }
        return (oj9) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null && str.contains("bookcover:")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("xiaoying.tv");
        }
        return invokeL.booleanValue;
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return b(xi.getUrlDecode(str2));
            }
            return "1".equals(paramPair.get("tbgametype"));
        }
        return invokeL.booleanValue;
    }

    public void e(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, str) != null) || tbPageContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (b(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
        } else if (d(str)) {
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{str}, true);
        } else {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
    }
}
