package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes6.dex */
public class jgb {
    public static /* synthetic */ Interceptable $ic;
    public static final SharedPreferences a;
    public static final SharedPreferences.Editor b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947883748, "Lcom/baidu/tieba/jgb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947883748, "Lcom/baidu/tieba/jgb;");
                return;
            }
        }
        SharedPreferences sharedPreferences = FunAdSdk.getAppContext().getSharedPreferences("csj_ad_ripper", 0);
        a = sharedPreferences;
        b = sharedPreferences.edit();
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.getLong("key_ad_anti_spam_time", 0L) : invokeV.longValue;
    }
}
