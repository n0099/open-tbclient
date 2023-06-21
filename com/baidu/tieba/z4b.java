package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes8.dex */
public class z4b {
    public static /* synthetic */ Interceptable $ic;
    public static final SharedPreferences a;
    public static final SharedPreferences.Editor b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311393, "Lcom/baidu/tieba/z4b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311393, "Lcom/baidu/tieba/z4b;");
                return;
            }
        }
        SharedPreferences sharedPreferences = FunAdSdk.getAppContext().getSharedPreferences("gdt_ad_forbid", 0);
        a = sharedPreferences;
        b = sharedPreferences.edit();
    }
}
