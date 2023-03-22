package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes6.dex */
public class rca {
    public static /* synthetic */ Interceptable $ic;
    public static final SharedPreferences a;
    public static final SharedPreferences.Editor b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948118201, "Lcom/baidu/tieba/rca;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948118201, "Lcom/baidu/tieba/rca;");
                return;
            }
        }
        SharedPreferences sharedPreferences = FunAdSdk.getAppContext().getSharedPreferences("fun_ad_sdk_price", 0);
        a = sharedPreferences;
        b = sharedPreferences.edit();
    }

    public static double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Double.longBitsToDouble(a.getLong("key_price_by_baseprice", 0L)) : invokeV.doubleValue;
    }

    public static double b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            SharedPreferences sharedPreferences = a;
            return Double.longBitsToDouble(sharedPreferences.getLong(str + "_", 0L));
        }
        return invokeL.doubleValue;
    }
}
