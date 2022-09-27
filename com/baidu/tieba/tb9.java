package com.baidu.tieba;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class tb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (!ac9.i() || dc9.f(context) == 1) {
                    return ub9.c(ub9.b(str, "http://absample.baidu.com/appabapp/appapi/applog"), null);
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
