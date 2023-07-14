package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
/* loaded from: classes8.dex */
public class uac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PayType a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (PayType.ALI_PAY.getChannel().equals(str) && PayType.ALI_PAY.getMethod().equals(str2)) {
                return PayType.ALI_PAY;
            }
            if (PayType.WECHAT_PAY.getChannel().equals(str) && PayType.WECHAT_PAY.getMethod().equals(str2)) {
                return PayType.WECHAT_PAY;
            }
            if (PayType.DXM_PAY.getChannel().equals(str) && PayType.DXM_PAY.getMethod().equals(str2)) {
                return PayType.DXM_PAY;
            }
            if (PayType.DXM_PAY_KJ.getChannel().equals(str) && PayType.DXM_PAY_KJ.getMethod().equals(str2)) {
                return PayType.DXM_PAY_KJ;
            }
            if (PayType.QQ_PAY.getChannel().equals(str) && PayType.QQ_PAY.getMethod().equals(str2)) {
                return PayType.QQ_PAY;
            }
            if (PayType.UNION_PAY.getChannel().equals(str) && PayType.UNION_PAY.getMethod().equals(str2)) {
                return PayType.UNION_PAY;
            }
            if (PayType.DXM_PAY_H5.getChannel().equals(str) && PayType.DXM_PAY_H5.getMethod().equals(str2)) {
                return PayType.DXM_PAY_H5;
            }
            return null;
        }
        return (PayType) invokeLL.objValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (PayType.DXM_PAY_H5.getChannel().equals(str) && PayType.DXM_PAY_H5.getMethod().equals(str2)) {
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
            if (PayType.DXM_PAY_KJ.getChannel().equals(str) && PayType.DXM_PAY_KJ.getMethod().equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (!c(str, str2) && !b(str, str2) && !PayType.MOCK_TEST_PAY.getChannel().equals(str) && !PayType.UNION_PAY.getChannel().equals(str)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
