package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65536, null, j, str)) == null) {
            if (StringUtils.isNull(str) || j == n95.m().o(str, 0L)) {
                return false;
            }
            return true;
        }
        return invokeJL.booleanValue;
    }

    public static void c(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65538, null, str, j) == null) {
            n95.m().A(n95.q(str), j);
        }
    }

    public static boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
            if (System.currentTimeMillis() - n95.m().o(n95.q("key_new_hot_tip_dismiss_time"), 0L) >= j) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }
}
