package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
/* loaded from: classes6.dex */
public class z5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (PayType.DXM_PAY_H5.getChannel().equals(str) && PayType.DXM_PAY_H5.getMethod().equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (PayType.DXM_PAY_KJ.getChannel().equals(str) && PayType.DXM_PAY_KJ.getMethod().equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (!b(str, str2) && !a(str, str2) && !PayType.MOCK_TEST_PAY.getChannel().equals(str) && !PayType.UNION_PAY.getChannel().equals(str)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
